package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Aluno;
import com.weg.GestaoEscolar.Repository.AlunoRepository;

import java.sql.SQLException;
import java.util.List;

public class AlunoService {
    AlunoRepository alunoRepository = new AlunoRepository();



    public Aluno cadastrarAluno (Aluno aluno)throws SQLException{
        if(aluno.getNome().isEmpty()){
            throw new RuntimeException("Aluno não possui nome");
        }
        return alunoRepository.novoAluno(aluno);
    }

    public List<Aluno> listarTodosOsAlunos()throws SQLException{
           List<Aluno>alunos = alunoRepository.listarTodosOsAlunos();
           if(alunos.isEmpty()){
           throw new RuntimeException("A lista esta vazia");
           }
        return alunos;
    }

    public Aluno buscarAlunoPorId(long id)throws SQLException{
           Aluno aluno = alunoRepository.listarPorId(id);
           if(aluno == null){
               throw new RuntimeException("A lista esta vazia");
           }
        return aluno;
    }

    public Aluno atualizarAluno(Aluno aluno, long id)throws SQLException{
           Aluno alunos = alunoRepository.listarPorId(id);
           if(alunos == null){
               throw new RuntimeException("Aluno não encontrado");
           }

        return alunoRepository.atualizarAluno(alunos);
    }

    public void deletarAluno(long id)throws SQLException{
        Aluno aluno = alunoRepository.listarPorId(id);
        if(aluno == null){
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepository.deletarAluno(id);
    }
}


