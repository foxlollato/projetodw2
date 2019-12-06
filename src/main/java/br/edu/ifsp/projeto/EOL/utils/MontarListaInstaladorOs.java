package br.edu.ifsp.projeto.EOL.utils;

import java.util.List;

import br.edu.ifsp.projeto.EOL.model.InstaladorOs;
import br.edu.ifsp.projeto.EOL.model.OrdemServico;
import br.edu.ifsp.projeto.EOL.model.Usuario;

public class MontarListaInstaladorOs {

	public static InstaladorOs montarLista(Usuario instalador, List<OrdemServico> oss) {
		InstaladorOs instaladorOs = new InstaladorOs();
		instaladorOs.setInstalador(instalador);
		instaladorOs.setOss(oss);
		return instaladorOs;
	}
}
