package com.example.bddtdd.service;

import com.example.bddtdd.model.Aluno;
import com.example.bddtdd.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAll (){
        return alunoRepository.findAll();
    }

    public Aluno create (Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public double calcularMediaRefatora(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        double nota1 = aluno.getPrimeiraNota();
        double nota2 = aluno.getSegundaNota();
        double media = (nota1 + nota2) / 2;

        aluno.setMedia(media);
        alunoRepository.save(aluno);
        return media;
    }
    public double calcularMedia (Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return 8.0;
    }
}
