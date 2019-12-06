package br.edu.ifsp.projeto.EOL.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.projeto.EOL.model.InstaladorOs;
import br.edu.ifsp.projeto.EOL.model.OrdemServico;
import br.edu.ifsp.projeto.EOL.model.Usuario;
import br.edu.ifsp.projeto.EOL.repositorio.OrdemServicoRepositorio;
import br.edu.ifsp.projeto.EOL.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping("/osfechadasprazo")
public class NumeroOsFechadasPrazoController {
	
	@Autowired
	private UsuarioRepositorio repoUser;
	
	@Autowired
	private OrdemServicoRepositorio repoOs;
	
	@GetMapping
	public String exibirForm(Model model) {
		List<InstaladorOs> lista = trazerTodosInstaladoresOss(repoUser.findAllInstaladores());
		model.addAttribute("lista", lista);
		return "painel-os-fechadas-prazo-instalador";
	}
	
	private List<InstaladorOs> trazerTodosInstaladoresOss(List<Usuario> instaladores) {
		List<InstaladorOs> lista = new ArrayList<InstaladorOs>();
		
		if(instaladores != null) {
			for(Usuario instalador : instaladores) {
				InstaladorOs instaladorOs = new InstaladorOs();
				List<OrdemServico> oss = repoOs.findAllClosedByInstalador(instalador.getId()); 
				instaladorOs.setInstalador(instalador);
				instaladorOs.setOss(oss);
				lista.add(instaladorOs);
			}
		}
		
		return lista;
	}
}
