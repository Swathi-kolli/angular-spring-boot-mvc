package com.example.notesapi;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
@RestController
public class NotesApiApplication {

	public static void main(String[] args) {
        SpringApplication.run(NotesApiApplication.class, args);
    }

	@GetMapping("/")
	public String index(@AuthenticationPrincipal Jwt jwt) {
		return String.format("Hello, %s!", jwt.getSubject());
	}

	@GetMapping("/message")
	@PreAuthorize("hasAuthority('SCOPE_message:read')")
	public String message() {
		return "secret message";
	}

	@PostMapping("/message")
	@PreAuthorize("hasAuthority('SCOPE_message:write')")
	public String createMessage(@RequestBody String message) {
		return String.format("Message was created. Content: %s", message);
	}
	



}
