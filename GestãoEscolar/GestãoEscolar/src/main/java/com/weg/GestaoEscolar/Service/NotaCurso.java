package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Nota;
import com.weg.GestaoEscolar.Repository.NotaRepository;

import java.sql.SQLException;
import java.util.List;

public class NotaCurso {
    NotaRepository notaRepository = new NotaRepository();

    public Nota cadastrarNovaNota(Nota nota) throws SQLException {

        if (nota == null) {

            throw new RuntimeException("Não foi possivel cadastrar Nota");
        }
        return notaRepository.novaNota(nota);
    }

    public List<Nota> listarTodasAsNotas()throws SQLException{

           List<Nota> notas = notaRepository.listarNota();

           if(notas.isEmpty()){

               throw new RuntimeException("lista não encontrada");
           }

        return notas;
    }

    public Nota listarNotasPorId(long id)throws SQLException{

           Nota nota = notaRepository.buscarPorId(id);

           if(nota == null){

               throw  new RuntimeException("lista não encontrada");

           }


        return nota;
    }

    public Nota atualizarNota(Nota nota, long id)throws SQLException{

            Nota notas = notaRepository.buscarPorId(id);

            if(notas == null){

                throw new RuntimeException("Nota não encontrada");
            }

        return notaRepository.atualizarNota(nota);
    }

    public void deletarNota(long id)throws SQLException{

            Nota nota = notaRepository.buscarPorId(id);

            if(nota == null){

                throw new RuntimeException("Nota não encontrada");
            }
    }
}
