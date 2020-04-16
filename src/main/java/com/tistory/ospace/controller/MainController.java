package com.tistory.ospace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tistory.ospace.dto.Account;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("say", "Hi");
		model.addAttribute("account", new Account("foo", "누구"));

		return "index";
	}
}
