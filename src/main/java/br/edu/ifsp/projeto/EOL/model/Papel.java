package br.edu.ifsp.projeto.EOL.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "papeis")
public class Papel implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String papel;

    @SuppressWarnings("unused")
    public Papel() {
    	
    }

    public Papel(String papel) {
        this.papel = papel;
    }

    @Override
    public String getAuthority() {
        return papel;
    }

}
