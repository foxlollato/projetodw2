package br.edu.ifsp.projeto.EOL.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.projeto.EOL.model.OrdemServico;
import br.edu.ifsp.projeto.EOL.repositorio.OrdemServicoRepositorio;

@Controller
@RequestMapping("/osatrasadas")
public class OsAtrasadasController {
	
	@Autowired
	private OrdemServicoRepositorio repoOs;
	
	@GetMapping
	public String exibirForm(Model model) {
		List<OrdemServico> oss = repoOs.findAllExpired();
		model.addAttribute("oss", oss);
		return "painel-os-atrasadas";
	}
}
