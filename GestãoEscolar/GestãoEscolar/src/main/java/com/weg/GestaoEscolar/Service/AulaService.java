package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoRequestDtos;
import com.weg.GestaoEscolar.Dtos.AulaDtos.AulaRequestDtos;
import com.weg.GestaoEscolar.Dtos.AulaDtos.AulaResponseDtos;
import com.weg.GestaoEscolar.Model.Aula;
import com.weg.GestaoEscolar.Repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;

    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public Aula cadastrarAula(Aula aula) {
        try {
            if (aula.getTurma() == null) {
                throw new IllegalArgumentException("Turma não foi informada para o cadastro da aula.");
            }
            return aulaRepository.novaAulas(aula);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar aula no banco de dados: " + e.getMessage());
        }
    }

    public List<Aula> listarTodasAsAulas() {
        try {
            List<Aula> aulas = aulaRepository.listarAulas();
            if (aulas.isEmpty()) {
                throw new RuntimeException("A lista de aulas está vazia.");
            }
            return aulas;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todas as aulas.");
        }
    }

    public Aula listarAulaPorId(long id) {
        try {
            Aula aula = aulaRepository.buscarPorId(id);
            if (aula == null) {
                throw new RuntimeException("Aula não encontrada para o ID: " + id);
            }
            return aula;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar aula por ID.");
        }
    }

    public Aula atualizarAula(Aula aula, long id) {
        try {
            Aula aulaExistente = aulaRepository.buscarPorId(id);
            if (aulaExistente == null) {
                throw new RuntimeException("Impossível atualizar: Aula não encontrada.");
            }


            return aulaRepository.atualizarAulas(aula);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar os dados da aula.");
        }
    }

    public void deletarAula(long id) {

    }

    public AulaResponseDtos cadastrarAula(AlunoRequestDtos alunoRequestDtos) {
        return null;
    }

    public AulaResponseDtos atualizarAula(AulaRequestDtos aulaRequestDtos, int id) {
        return null;
    }
}