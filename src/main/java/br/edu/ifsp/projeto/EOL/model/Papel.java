package br.edu.ifsp.projeto.EOL.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "papeis")
public class Papel implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String papel;

    @SuppressWarnings("unused")
    private Papel() {}

    public Papel(String papel) {
        this.papel = papel;
    }

    @Override
    public String getAuthority() {
        return papel;
    }

}
