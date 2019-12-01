package br.edu.ifsp.projeto.EOL.seguranca;

import org.springframework.security.crypto.password.PasswordEncoder;

public class DummyPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {
    	return new StringBuilder(rawPassword).reverse().toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(encode(rawPassword));
    }

}
