package br.edu.ifsp.projeto.EOL.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/veros")
public class PainelOsInstaladorController {
	
	@GetMapping
	public String exibirForm() {
		return "painel-instalador-os";
	}
}
