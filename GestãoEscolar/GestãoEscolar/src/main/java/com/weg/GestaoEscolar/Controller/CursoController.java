package com.weg.GestaoEscolar.Controller;


import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoRequestDtos;
import com.weg.GestaoEscolar.Dtos.CursoDtos.CursoRequestDtos;
import com.weg.GestaoEscolar.Dtos.CursoDtos.CursoResponseDtos;
import com.weg.GestaoEscolar.Model.Aula;
import com.weg.GestaoEscolar.Model.Curso;
import com.weg.GestaoEscolar.Service.AulaService;
import com.weg.GestaoEscolar.Service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @PostMapping
    public CursoResponseDtos salvar(@RequestBody AlunoRequestDtos alunoRequestDtos){
        return cursoService.cadastrarCurso(alunoRequestDtos);
    }

    @GetMapping
    public List<Curso> buscarTodosOsCursos(){
        return cursoService.listarTodosOsCursos();
    }

    @GetMapping
    public Curso buscarPorId(@PathVariable int id){
        return cursoService.listarPorId(id);
    }

    @GetMapping
    public Curso atualizarCurso (@RequestBody CursoRequestDtos cursoRequestDtos, @PathVariable int id){
        return cursoService.atualizarCurso(cursoRequestDtos, id);
    }

    @DeleteMapping void deletarCurso(@PathVariable int id){
        cursoService.deletarCurso(id);
    }
}
