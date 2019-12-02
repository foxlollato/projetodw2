package br.edu.ifsp.projeto.EOL.web;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.projeto.EOL.model.Endereco;
import br.edu.ifsp.projeto.EOL.model.OrdemServico;
import br.edu.ifsp.projeto.EOL.model.Plano;
import br.edu.ifsp.projeto.EOL.model.Usuario;
import br.edu.ifsp.projeto.EOL.repositorio.EnderecoRepositorio;
import br.edu.ifsp.projeto.EOL.repositorio.OrdemServicoRepositorio;
import br.edu.ifsp.projeto.EOL.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping("/cadastraros")
public class CadastrarOsController {

	@Autowired
	private OrdemServicoRepositorio repoOs;
	
	@Autowired
	private EnderecoRepositorio repoEnder;
	
	@Autowired
	private UsuarioRepositorio repoUser;
	
	@GetMapping
	public String exibirForm(Model model) {
		model.addAttribute("os", new OrdemServico());
		model.addAttribute("endereco", new Endereco());
		model.addAttribute("planos", Arrays.asList(Plano.values()));
		return "cadastro-os";
	}
	
	@ModelAttribute(name = "os")
	public OrdemServico orderServico() {
		return new OrdemServico();
	}
	
	@ModelAttribute(name = "endereco")
	public Endereco endereco() {
		return new Endereco();
	}
	
	@ModelAttribute(name = "planos")
	public List<Plano> planos() {
		List<Plano> planos = Arrays.asList(Plano.values());
		return planos;
	}
	
	@PostMapping
	public String processarForm(@Valid Endereco endereco, OrdemServico os, Authentication authentication, Errors errors) {
		if (errors.hasErrors()) {
			return "cadastraros";
		}
		
		String username = authentication.getName();
		Usuario user = repoUser.findByUsername(username);
		
		repoEnder.save(endereco);
		os.setCliente(user);
		os.setEndereco(endereco);
		repoOs.save(os);
		
		return "redirect:/cadastraros";
	}
}
