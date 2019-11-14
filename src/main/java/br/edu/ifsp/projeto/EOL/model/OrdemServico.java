package br.edu.ifsp.projeto.EOL.model;

import javax.persistence.*;

@Entity
@Table(name="os")
public class OrdemServico {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Usuario cliente;

    private Plano plano;

    @OneToOne
    private Endereco endereco;

    private Usuario instalador;

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getInstalador() {
        return instalador;
    }

    public void setInstalador(Usuario instalador) {
        this.instalador = instalador;
    }
}
