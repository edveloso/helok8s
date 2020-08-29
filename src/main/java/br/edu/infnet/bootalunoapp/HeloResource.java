package br.edu.infnet.bootalunoapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloResource {

	@RequestMapping("/")
	public String hello() {
		return "Hello container";
	}
	
}
