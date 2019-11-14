package br.edu.ifsp.projeto.EOL.model;

import javax.persistence.*;

@Entity
@Table(name="os")
public class OrdemServico {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Usuario cliente;

    private Usuario instalador;
}
