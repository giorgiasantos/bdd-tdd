package com.example.bddtdd.controller;

import com.example.bddtdd.model.Aluno;
import com.example.bddtdd.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAll(){
        return alunoService.getAll();
    }

    @PostMapping
    public Aluno create (Aluno aluno){
        return alunoService.create(aluno);
    }
}
