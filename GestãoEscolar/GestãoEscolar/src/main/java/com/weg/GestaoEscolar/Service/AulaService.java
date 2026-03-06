package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Aula;
import com.weg.GestaoEscolar.Repository.AulaRepository;

import java.sql.SQLException;
import java.util.List;

public class AulaService {
    AulaRepository aulaRepository = new AulaRepository();

    public Aula cadastrarAlula(Aula aula)throws SQLException{
        if(aula.getTurma() == null){
            throw new SQLException("Turma não foi cadastrada");
        }
        return aulaRepository.novaAulas(aula);
    }

    public List<Aula> listarTodasAsAulas()throws SQLException{
        List<Aula> aulas = aulaRepository.listarAulas();
        if(aulas.isEmpty()){
            throw new SQLException("Lista esta vazia");
        }

        return aulas;
    }

    public Aula listarAulaPorId(int id)throws SQLException{
        Aula aula = aulaRepository.buscarPorId(id);
        if(aula == null){
            throw new RuntimeException("Lista esta vizia");
        }
        return aula;
    }

    public Aula atualizarAula(Aula aula, int id)throws SQLException{
        Aula aulas = aulaRepository.buscarPorId(id);
        if(aulas == null){
            throw new RuntimeException("Aula não encontrada");
        }
        return aulaRepository.atualizarAulas(aula);
    }

    public void deletarAula(int id)throws SQLException{
        Aula aula = aulaRepository.buscarPorId(id);
        if(aula == null){
            throw new RuntimeException("Aula não encontrada");
        }
        aulaRepository.deletarAulas(id);
    }
}
