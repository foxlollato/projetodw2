package br.edu.ifsp.projeto.EOL.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/relatorio")
public class PainelOsAdminController {

	@GetMapping
	public String registro() {
		return "painel-geral-admin";
	}
}
