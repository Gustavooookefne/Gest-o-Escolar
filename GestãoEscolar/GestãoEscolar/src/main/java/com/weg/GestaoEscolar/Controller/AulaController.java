package com.weg.GestaoEscolar.Controller;


import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoRequestDtos;
import com.weg.GestaoEscolar.Dtos.AulaDtos.AulaRequestDtos;
import com.weg.GestaoEscolar.Dtos.AulaDtos.AulaResponseDtos;
import com.weg.GestaoEscolar.Model.Aula;
import com.weg.GestaoEscolar.Service.AulaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")

public class AulaController {

    private final AulaService aulaService;

    public AulaController(AulaService aulaService){
        this.aulaService = aulaService;
    }

    @PostMapping
    public AulaResponseDtos salvar(@RequestBody AlunoRequestDtos alunoRequestDtos){
           return aulaService.cadastrarAula(alunoRequestDtos);
    }

    @GetMapping
    public List<Aula> buscarTodasAsAulas(){
           return aulaService.listarTodasAsAulas();
    }

    @GetMapping
    public Aula buscarPorId(@PathVariable int id){
           return aulaService.listarAulaPorId(id);
    }

    @PutMapping
    public AulaResponseDtos atualizarAula(@RequestBody AulaRequestDtos aulaRequestDtos, @PathVariable int id){
           return aulaService.atualizarAula(aulaRequestDtos, id);
    }

    @DeleteMapping
    public void deletarAula(@PathVariable int id){
        aulaService.deletarAula(id);
    }

}
