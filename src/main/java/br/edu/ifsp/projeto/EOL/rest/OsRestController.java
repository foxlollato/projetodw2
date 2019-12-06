package br.edu.ifsp.projeto.EOL.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.projeto.EOL.model.OrdemServico;
import br.edu.ifsp.projeto.EOL.model.Usuario;
import br.edu.ifsp.projeto.EOL.repositorio.OrdemServicoRepositorio;
import br.edu.ifsp.projeto.EOL.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping(path = "/api")
public class OsRestController {

	@Autowired
	private UsuarioRepositorio repoUser;
	
	@Autowired
	private OrdemServicoRepositorio repoOs;
	
	@GetMapping("/osabertas")
	public ModelAndView exibirForm(Model model) {
		List<OrdemServico> oss = repoOs.findAllOpen();
		model.addAttribute("oss", oss);
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("painel-instalador-os-aberta");
	    return modelAndView;
	}
	
	@GetMapping("/osalocadas")
	public ModelAndView exibirForm(Model model, Authentication authentication) {
		String username = authentication.getName();
		Usuario user = repoUser.findByUsername(username);
		List<OrdemServico> oss = repoOs.findAllOsAbertasByInstalador(user.getId());
		model.addAttribute("oss", oss);
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("painel-instalador-os-executada");
	    return modelAndView;
	}
	
	
	@PostMapping(path = "/alocaros/{id}", consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrdemServico post(@PathVariable("id") Long id, Authentication authentication) {
		OrdemServico os = repoOs.findById(id).get();
		String username = authentication.getName();
		Usuario user = repoUser.findByUsername(username);
		
		os.setInstalador(user);
		repoOs.save(os);
		return os;
	}
	
	@PostMapping(path = "/executaros/{id}", consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrdemServico post(@PathVariable("id") Long id) {
		OrdemServico os = repoOs.findById(id).get();		
		os.setExecucao(new Date());
		repoOs.save(os);
		return os;
	}
	
}
