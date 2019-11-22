package br.edu.ifsp.projeto.EOL.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="os")
public class OrdemServico {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Plano plano;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "instalador_id")
    private Usuario instalador;

    @CreationTimestamp
    private Date abertura;

    private Date execucao;

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getExecucao() {
        return execucao;
    }

    public void setExecucao(Date execucao) {
        this.execucao = execucao;
    }


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
