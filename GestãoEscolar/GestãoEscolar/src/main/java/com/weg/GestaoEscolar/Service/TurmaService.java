package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Turma;
import com.weg.GestaoEscolar.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Turma cadastrarTurma(Turma turma) {
        try {
            if (turma.getProfessor() == null) {
                throw new IllegalArgumentException("O nome da turma não pode estar vazio.");
            }
            return turmaRepository.novaTurma(turma);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar turma no banco de dados: " + e.getMessage());
        }
    }

    public List<Turma> listarTodasAsTurmas() {
        try {
            List<Turma> turmas = turmaRepository.listarTurma();
            if (turmas.isEmpty()) {
                throw new RuntimeException("A lista de turmas está vazia.");
            }
            return turmas;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar turmas.");
        }
    }

    public Turma listarTurmaPorId(int id) {
        try {
            Turma turma = turmaRepository.buscarPorId(id);
            if (turma == null) {
                throw new RuntimeException("Turma não encontrada para o ID: " + id);
            }
            return turma;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar turma por ID.");
        }
    }

    public Turma atualizarTurma(Turma turma, int id) {
        try {
            Turma turmaExistente = turmaRepository.buscarPorId(id);
            if (turmaExistente == null) {
                throw new RuntimeException("Impossível atualizar: Turma não encontrada.");
            }
            
            turmaExistente.setProfessor(turma.getProfessor());
            turmaExistente.setCurso(turma.getCurso());
            turmaExistente.setId(turma.getId());

            turmaRepository.atualizarTurma(turmaExistente);
            return turmaExistente;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar os dados da turma.");
        }
    }

    public void deletarTurma(int id) {
        try {
            Turma turma = turmaRepository.buscarPorId(id);
            if (turma == null) {
                throw new RuntimeException("Impossível deletar: Turma não encontrada.");
            }
            turmaRepository.deletarTurma(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a turma de ID " + id);
        }
    }
    

    public void adicionarAlunoATurma(Turma turmaAluno) {
        try {
            turmaRepository.novaTurma(turmaAluno);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao vincular aluno à turma.");
        }
    }

    public List<Turma> listarAlunosDaTurma(int turmaId) {
        try {
            return turmaRepository.listarTurma();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar alunos da turma.");
        }
    }
}