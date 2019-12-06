package br.edu.ifsp.projeto.EOL.model;

import java.util.List;

public class InstaladorOs {
	
	private Usuario instalador;
	
	private List<OrdemServico> oss;

	private int tamanhoLista;
	
	
	public Usuario getInstalador() {
		return instalador;
	}

	public void setInstalador(Usuario instalador) {
		this.instalador = instalador;
	}

	public List<OrdemServico> getOss() {
		return oss;
	}

	public void setOss(List<OrdemServico> oss) {
		this.oss = oss;
		this.tamanhoLista = oss.size();
	}

	public int getTamanhoLista() {
		return tamanhoLista;
	}

	public void setTamanhoLista(int tamanhoLista) {
		this.tamanhoLista = tamanhoLista;
	}
	
}
