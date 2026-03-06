package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Nota;
import com.weg.GestaoEscolar.Repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public Nota cadastrarNovaNota(Nota nota) {
        try {
            if (nota == null) {
                throw new IllegalArgumentException("Os dados da nota não podem ser nulos.");
            }
            if (nota.getNota() < 0 || nota.getNota() > 10) {
                throw new IllegalArgumentException("O valor da nota deve estar entre 0 e 10.");
            }
            return notaRepository.novaNota(nota);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar nota no banco de dados: " + e.getMessage());
        }
    }

    public List<Nota> listarTodasAsNotas() {
        try {
            List<Nota> notas = notaRepository.listarNota();
            if (notas.isEmpty()) {
                throw new RuntimeException("Nenhuma nota encontrada.");
            }
            return notas;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar a lista de notas.");
        }
    }

    public Nota listarNotasPorId(int id) {
        try {
            Nota nota = notaRepository.buscarPorId(id);
            if (nota == null) {
                throw new RuntimeException("Nota não encontrada para o ID: " + id);
            }
            return nota;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar nota por ID.");
        }
    }

    public List<Nota> listarNotasPorAluno(int alunoId) {
        return notaRepository.listarNota(alunoId);
    }

    public Nota atualizarNota(Nota nota, int id) {
        try {
            Nota notaExistente = notaRepository.buscarPorId(id);
            if (notaExistente == null) {
                throw new RuntimeException("Impossível atualizar: Nota inexistente.");
            }

            notaExistente.setNota(nota.getNota());
            notaExistente.setAula(nota.getAula());
            notaExistente.setAula(nota.getAula());

            notaRepository.atualizarNota(notaExistente);
            return notaExistente;
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro ao atualizar a nota.");
        }
    }

    public void deletarNota(int id) {
        try {
            Nota nota = notaRepository.buscarPorId(id);
            if (nota == null) {
                throw new RuntimeException("Impossível deletar: Nota não encontrada.");
            }
            notaRepository.deletarNota(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a nota de ID " + id);
        }
    }
}