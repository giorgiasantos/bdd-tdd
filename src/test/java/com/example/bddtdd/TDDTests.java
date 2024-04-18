package com.example.bddtdd;

import com.example.bddtdd.model.Aluno;
import com.example.bddtdd.repository.AlunoRepository;
import com.example.bddtdd.service.AlunoService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootTest
class TDDTests {

	@TestConfiguration
	static class alunoTestConfig{
		@Bean
		public AlunoService alunoService(){
			return new AlunoService();
		}
	}

	@Autowired
	private AlunoService alunoService;

	@MockBean
	private AlunoRepository alunoRepository;

	@BeforeEach
	public void setup(){
		Aluno aluno = new Aluno(1L, "Fulano", "História", 7.0,9.0);
		Mockito.when(alunoRepository.findById(aluno.getId())).thenReturn(Optional.of(aluno));
	}


	@Test
	void calcularMedia() {
		Long id = 1L;
		double media = alunoService.calcularMedia(id);
		Assertions.assertEquals(media, 8.0);

	}

	@Test
	void calcularMediaMetodoRefatorado() {
		Long id = 1L;
		double media = alunoService.calcularMediaRefatora(id);
		Assertions.assertEquals(media, 8.0);

	}

}
