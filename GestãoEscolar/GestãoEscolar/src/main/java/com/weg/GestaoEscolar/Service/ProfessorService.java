package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Professor;
import com.weg.GestaoEscolar.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor cadastraProfessor(Professor professor) {
        try {
            if (professor.getDisiplina() == null || professor.getDisiplina().isEmpty()) {
                throw new IllegalArgumentException("A disciplina do professor deve ser informada.");
            }
            return professorRepository.salvarProfessor(professor);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar professor no banco: " + e.getMessage());
        }
    }

    public List<Professor> listarTodosOsProfessores() {
        try {
            List<Professor> professores = professorRepository.listarTodosOsProfessores();
            if (professores.isEmpty()) {
                throw new RuntimeException("Nenhum professor encontrado na lista.");
            }
            return professores;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar a lista de professores.");
        }
    }

    public Professor listarProfessorPorId(int id) {
        try {
            Professor professor = professorRepository.buscarPorId(id);
            if (professor == null) {
                throw new RuntimeException("Professor não encontrado para o ID: " + id);
            }
            return professor;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar professor por ID.");
        }
    }

    public Professor atualizarProfessor(Professor professor, int id) {
        try {
            Professor professorExistente = professorRepository.buscarPorId(id);
            if (professorExistente == null) {
                throw new RuntimeException("Impossível atualizar: Professor não encontrado.");
            }

            professorExistente.setNome(professor.getNome());
            professorExistente.setEmail(professor.getEmail());
            professorExistente.setDisiplina(professor.getDisiplina());

            professorRepository.salvarProfessor(professorExistente);
            return professorExistente;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar os dados do professor.");
        }
    }

    public void deletarProfessor(int id) {
        try {
            Professor professor = professorRepository.buscarPorId(id);
            if (professor == null) {
                throw new RuntimeException("Impossível deletar: Professor não encontrado.");
            }
            professorRepository.deletarProfessor(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o professor de ID " + id);
        }
    }
}