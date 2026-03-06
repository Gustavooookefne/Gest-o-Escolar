package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Turma;
import com.weg.GestaoEscolar.Repository.TurmaRepository;

import java.sql.SQLException;
import java.util.List;

public class TurmaService {
    TurmaRepository turmaRepository = new TurmaRepository();

    public Turma cadastrarTurma(Turma turma) throws SQLException{

        if(turma.getProfessor() == null){

            throw new RuntimeException("Turma não foi cadastrada");
        }

        return turmaRepository.novaTurma(turma);
    }

    public List<Turma> listarTodasAsTurmas() throws SQLException{

           List<Turma> turmas = turmaRepository.listarTurma();

           if(turmas.isEmpty()){

               throw new RuntimeException("lista não encontrada");
           }
        return turmas;
    }

    public Turma listarTurmaPorId(Long id) throws SQLException{

            Turma turma = turmaRepository.buscarPorId(id);

            if(turma == null){

                throw new RuntimeException("lista não encontrada");
            }
        return turma;
    }

    public Turma atualizarTurma(Turma turma, Long id)throws SQLException{

        Turma turmas = turmaRepository.buscarPorId(id);

        if(turmas == null){

            throw new RuntimeException("Turma não encontrada");
        }
        return turmaRepository.atualizarTurma(turma);
    }

    public void deletarTurma(Long id)throws SQLException {

        Turma turmas = turmaRepository.buscarPorId(id);

        if (turmas == null) {

            throw new RuntimeException("Turma não encontrada");
        }
         turmaRepository.deletarTurma(id);
    }
}
