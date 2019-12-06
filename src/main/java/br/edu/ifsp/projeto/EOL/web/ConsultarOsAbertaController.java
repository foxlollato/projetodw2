package br.edu.ifsp.projeto.EOL.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.projeto.EOL.model.OrdemServico;
import br.edu.ifsp.projeto.EOL.model.Usuario;
import br.edu.ifsp.projeto.EOL.repositorio.OrdemServicoRepositorio;
import br.edu.ifsp.projeto.EOL.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping("/os")
public class ConsultarOsAbertaController {
	
	@Autowired
	private UsuarioRepositorio repoUser;
	
	@Autowired
	private OrdemServicoRepositorio repoOs;
	
	@GetMapping
	public String exibirForm(Model model) {
		List<OrdemServico> oss = repoOs.findAllOpen();
		model.addAttribute("oss", oss);
		return "painel-instalador-os-aberta";
	}
	
    @GetMapping("/alocar/{id}")
    public String alocar(@PathVariable Long id, Authentication authentication){
		OrdemServico os = repoOs.findById(id).get();
		String username = authentication.getName();
		Usuario user = repoUser.findByUsername(username);
		
		os.setInstalador(user);
		repoOs.save(os);
        
		return "redirect:/os";
    }
	
}
