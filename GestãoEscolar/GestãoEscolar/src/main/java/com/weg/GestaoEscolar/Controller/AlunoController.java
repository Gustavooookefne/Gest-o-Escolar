package com.weg.GestaoEscolar.Controller;


import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoRequestDtos;
import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoResponseDtos;
import com.weg.GestaoEscolar.Model.Aluno;
import com.weg.GestaoEscolar.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoResponseDtos save(@RequestBody AlunoRequestDtos alunoRequestDtos){
        return alunoService.cadastrarAluno(alunoRequestDtos);
    }

    @GetMapping
    public List<Aluno> listarTodosOsAlunos (){
        return alunoService.listarTodosOsAlunos();
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable int id){
        return alunoService.buscarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponseDtos atualizarAlunos(@RequestBody AlunoRequestDtos alunoRequestDtos, @PathVariable int id){
        return alunoService.atualizarAluno(alunoRequestDtos, id);
    }

    @DeleteMapping("/{id}")
    public void deletarAlunos(@PathVariable int id){
        alunoService.deletarAluno(id);
    }



}
