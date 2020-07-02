package com.jluque;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.jluque.model.Usuario;
import com.jluque.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void crearUsuarioTest() {

		Usuario us = new Usuario();
		us.setId(4);
		us.setNombre("user");
		// codificamos el pass con el bean de SecurityConfig
		us.setClave(encoder.encode("123")); 

		Usuario retorno = repo.save(us);

		assertTrue(retorno.getClave().equals(us.getClave()));
	}

}
