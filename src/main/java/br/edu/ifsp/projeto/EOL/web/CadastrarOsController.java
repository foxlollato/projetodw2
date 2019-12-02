package br.edu.ifsp.projeto.EOL.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.projeto.EOL.model.Endereco;
import br.edu.ifsp.projeto.EOL.model.OrdemServico;
import br.edu.ifsp.projeto.EOL.model.Usuario;
import br.edu.ifsp.projeto.EOL.repositorio.EnderecoRepositorio;
import br.edu.ifsp.projeto.EOL.repositorio.OrdemServicoRepositorio;

@Controller
@RequestMapping("/cadastraros")
public class CadastrarOsController {

	@Autowired
	private OrdemServicoRepositorio repoOs;
	
	@Autowired
	private EnderecoRepositorio repoEnder;
	
	@GetMapping
	public String exibirForm(Model model) {
		model.addAttribute("os", new OrdemServico());
		model.addAttribute("endereco", new Endereco());
		return "cadastro-os";
	}
	
	@ModelAttribute
	public OrdemServico orderServico() {
		return new OrdemServico();
	}
	
	@ModelAttribute(name = "endereco")
	public Endereco endereco() {
		return new Endereco();
	}
	
	@ModelAttribute(name = "usuario")
	public Usuario usuario() {
		return new Usuario();
	}
	
	@PostMapping
	public String processarForm(@Valid Endereco endereco, OrdemServico os, Usuario usuario, Errors errors) {
		if (errors.hasErrors()) {
			return "cadastraros";
		}
		
		repoEnder.save(endereco);
		os.setCliente(usuario);
		os.setEndereco(endereco);
		repoOs.save(os);
		
		return "redirect:/";
	}
}
