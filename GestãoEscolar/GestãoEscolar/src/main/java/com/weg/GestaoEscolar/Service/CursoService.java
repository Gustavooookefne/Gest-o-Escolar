package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoRequestDtos;
import com.weg.GestaoEscolar.Dtos.CursoDtos.CursoRequestDtos;
import com.weg.GestaoEscolar.Dtos.CursoDtos.CursoResponseDtos;
import com.weg.GestaoEscolar.Model.Curso;
import com.weg.GestaoEscolar.Repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso cadastrarCurso(Curso curso) {
        try {
            if (curso.getNomeCurso() == null || curso.getNomeCurso().isEmpty()) {
                throw new IllegalArgumentException("Nome do curso é obrigatório.");
            }
            return cursoRepository.novaCurso(curso);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar curso: " + e.getMessage());
        }
    }

    public List<Curso> listarTodosOsCursos() {
        try {
            List<Curso> cursos = cursoRepository.listarCurso();
            if (cursos.isEmpty()) {
                throw new RuntimeException("A lista de cursos está vazia.");
            }
            return cursos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar cursos.");
        }
    }

    public Curso listarPorId(int id) {
        try {
            Curso curso = cursoRepository.buscarPorId(id);
            if (curso == null) {
                throw new RuntimeException("Curso não encontrado com o ID: " + id);
            }
            return curso;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar curso por ID.");
        }
    }

    public Curso atualizarCurso(Curso curso, int id) {
        try {
            Curso cursoExistente = cursoRepository.buscarPorId(id);
            if (cursoExistente == null) {
                throw new RuntimeException("Não foi possível atualizar: Curso inexistente.");
            }

            cursoExistente.getNomeCurso(curso.getNomeCurso());
            cursoExistente.setCodigo(curso.getCodigo());

            cursoRepository.atualizarCurso(cursoExistente);
            return cursoExistente;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o curso.");
        }
    }

    public void deletarCurso(int id) {
        try {
            Curso curso = cursoRepository.buscarPorId(id);
            if (curso == null) {
                throw new RuntimeException("Não foi possível deletar: Curso não encontrado.");
            }
            cursoRepository.deletarCurso(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o curso de ID " + id);
        }
    }

    public Curso atualizarCurso(CursoRequestDtos cursoRequestDtos, int id) {
        return null;
    }

    public CursoResponseDtos cadastrarCurso(AlunoRequestDtos alunoRequestDtos) {
        return null;
    }
}