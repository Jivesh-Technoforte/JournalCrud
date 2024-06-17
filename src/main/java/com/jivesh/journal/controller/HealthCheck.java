package com.jivesh.journal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
@GetMapping("")
	public String Check() {
		return "Server is Live ";
	}
}
