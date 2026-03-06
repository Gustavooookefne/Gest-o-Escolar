package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Professor;
import com.weg.GestaoEscolar.Repository.ProfessorRepository;

import java.sql.SQLException;
import java.util.List;

public class ProfessorService {
    ProfessorRepository professorRepository = new ProfessorRepository();

    public Professor cadastraProfessor(Professor professor) throws SQLException{

            if(professor.getDisiplina().isEmpty()){

                throw new RuntimeException("Professor não cadastrado");
            }

        return professorRepository.salvarProfessor(professor);
    }

    public List<Professor> listarTodosOsProfessores() throws SQLException{

           List<Professor> professors = professorRepository.listarTodosOsProfessores();

           if(professors.isEmpty()){

               throw new RuntimeException("Lista não encontrada");
           }
        return professors;
    }

    public Professor listarProfessorPorId(Long id) throws SQLException{

           Professor professor = professorRepository.buscarPorId(id);

           if(professor == null){

               throw new RuntimeException("Lista não encontrada");
           }

        return professor;
    }

    public Professor atualizarProfessor(Professor professor, Long id) throws SQLException{

           Professor professors = professorRepository.buscarPorId(id);

           if(professor == null){

               throw new RuntimeException("Professor não encontrado");
           }
        return professorRepository.atualizarProfessor(professor);
    }

    public void deletarProfessor(Long id) throws SQLException{

           Professor professor = professorRepository.buscarPorId(id);

           if(professor == null){

               throw new RuntimeException("Professor não encontrado");
           }
           professorRepository.deletarProfessor(id);
    }
}
