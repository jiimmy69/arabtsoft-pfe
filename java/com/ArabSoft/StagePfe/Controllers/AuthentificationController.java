package com.ArabSoft.StagePfe.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ArabSoft.StagePfe.Jwt.JwtUtils;
import com.ArabSoft.StagePfe.Models.ERole;
import com.ArabSoft.StagePfe.Models.JwtResponse;
import com.ArabSoft.StagePfe.Models.LoginRequest;
import com.ArabSoft.StagePfe.Models.MessageResponse;
import com.ArabSoft.StagePfe.Models.Role;
import com.ArabSoft.StagePfe.Models.SignupRequest;
import com.ArabSoft.StagePfe.Models.User;
import com.ArabSoft.StagePfe.Models.UserDetailsImpl;
import com.ArabSoft.StagePfe.Repositorys.RoleRepository;
import com.ArabSoft.StagePfe.Repositorys.UserRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;

	

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println("authentication -------- "+authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		System.out.println("userDetails ------- "+ userDetails.toString());
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getFirstName(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}else
		
		if (userRepository.existsByTelephoneNumber(signUpRequest.getTelephoneNumber())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: number is already taken!"));
		}
		

		// Create new user's account
		User user = new User(signUpRequest.getFirstName(),  signUpRequest.getLastName(),  signUpRequest.getEmail()
				,signUpRequest.getAdresse(),signUpRequest.getDateNaissance(),signUpRequest.getDateDebut(),signUpRequest.getVille()
				,signUpRequest.getGender(),signUpRequest.getMatricule(),signUpRequest.getCodeService(),signUpRequest.getTelephoneNumber()
				,signUpRequest.getSalaire(),encoder.encode(signUpRequest.getPassword()));
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {

			strRoles.forEach(role -> {
				switch (role) {
				case "RH":
					Role ressourceHumaine = roleRepository.findByName(ERole.ROLE_RH)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(ressourceHumaine);
					break;
				case "Manager":
					Role manager = roleRepository.findByName(ERole.ROLE_MANAGER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(manager);
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}