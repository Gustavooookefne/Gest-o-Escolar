package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoRequestDtos;
import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoResponseDtos;
import com.weg.GestaoEscolar.Model.Aluno;
import com.weg.GestaoEscolar.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        try {
            if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
                throw new IllegalArgumentException("Aluno não possui nome");
            }

            return alunoRepository.novoAluno(aluno);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public List<Aluno> listarTodosOsAlunos() {
        try {
            List<Aluno> alunos = alunoRepository.listarTodosOsAlunos();
            if (alunos.isEmpty()) {
                throw new RuntimeException("A lista está vazia");
            }
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos.");
        }
    }

    public Aluno buscarAlunoPorId(long id) {
        try {
            Aluno aluno = alunoRepository.listarPorId(id);
            if (aluno == null) {
                throw new RuntimeException("Aluno não encontrado com o ID: " + id);
            }
            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar aluno.");
        }
    }

    public Aluno atualizarAluno(Aluno aluno, long id) {
        try {
            Aluno alunoExistente = alunoRepository.listarPorId(id);
            if (alunoExistente == null) {
                throw new RuntimeException("Aluno não encontrado para atualização");
            }

            alunoExistente.setNome(aluno.getNome());

            return alunoRepository.atualizarAluno(alunoExistente);
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro ao atualizar o aluno.");
        }
    }

    public void deletarAluno(long id) {
        try {
            Aluno aluno = alunoRepository.listarPorId(id);
            if (aluno == null) {
                throw new RuntimeException("Aluno não encontrado para exclusão");
            }
            alunoRepository.deletarAluno(id);
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro ao deletar o aluno de ID " + id);
        }
    }

    public AlunoResponseDtos cadastrarAluno(AlunoRequestDtos alunoRequestDtos) {
        return null;
    }

    public AlunoResponseDtos atualizarAluno(AlunoRequestDtos alunoRequestDtos, int id) {
        return null;
    }
}