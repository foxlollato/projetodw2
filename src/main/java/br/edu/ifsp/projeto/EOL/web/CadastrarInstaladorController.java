package br.edu.ifsp.projeto.EOL.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.projeto.EOL.model.Papel;
import br.edu.ifsp.projeto.EOL.model.Usuario;
import br.edu.ifsp.projeto.EOL.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping("/cadastrarinstalador")
public class CadastrarInstaladorController {
	
	@Autowired
	private UsuarioRepositorio repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public String registro() {
		return "cadastro-instalador";
	}
	
	@PostMapping
	public String processarRegistro(Usuario usuario) {
		usuario.addPapel(new Papel("ROLE_INSTALADOR"));
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		repo.save(usuario);
		
		return "redirect:/login";
	}
}
