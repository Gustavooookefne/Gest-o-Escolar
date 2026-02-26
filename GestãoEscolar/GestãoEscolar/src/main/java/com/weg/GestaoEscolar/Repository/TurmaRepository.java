package com.weg.GestaoEscolar.Repository;

import com.weg.GestaoEscolar.Model.Curso;
import com.weg.GestaoEscolar.Model.Professor;
import com.weg.GestaoEscolar.Model.Turma;
import com.weg.GestaoEscolar.Utills.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {

    public Turma novaTurma(Turma turma) throws SQLException{
        String sql = """
                INSERT INTO turma
                (nomeTurma ,curso ,professor)
                VALUES
                (?,?,?)
                """;

        try (Connection conn = Conexao.connection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
             ps.setLong(1,turma.getId());
             ps.setString(2,turma.getNomeTurma());
             ps.setLong(3,turma.getCurso().getId());
             ps.setLong(4,turma.getProfessor().getId());

             ps.executeUpdate();

             try (ResultSet rs = ps.getGeneratedKeys()){
                 if(rs.next()){
                     turma.setId(rs.getLong(1));
                 }
             }
        }

        return turma;
    }

    public List<Turma> listarTurma() throws SQLException{
           List<Turma>turmas = new ArrayList<>();

           String sql = """
                   SELECT id
                   nomeTurma,
                   curso,
                   professor,
                   FROM curso
                   """;

           try (Connection conn = Conexao.connection();
           PreparedStatement psList = conn.prepareStatement(sql)){
               ResultSet rs = psList.executeQuery();
               while (rs.next()){
                   Turma turma = new Turma();
                   turma.setId(rs.getLong("id"));
                   turma.setNomeTurma(rs.getString("nomeCurso"));

                   Curso curso = new Curso();
                   curso.setId(rs.getLong("curso"));
                   turma.setCurso(curso);

                   Professor professor = new Professor();
                   professor.setId(rs.getLong("professor"));
                   turma.setProfessor(professor);

                   turmas.add(turma);
               }
           }
        return turmas;
    }

    public Turma buscarPorId(long id) throws SQLException{
           Turma turma = null;

           String sql = """
                   SELECT id,
                   nomeTurma,
                   curso,
                   professor,
                   FROM turma
                   WHERE id = ?
                   """;

           try (Connection conn = Conexao.connection();
                PreparedStatement psId = conn.prepareStatement(sql)){
                psId.setLong(1,id);
               try (ResultSet rs = psId.executeQuery()){
                   if(rs.next()){
                       turma = new Turma();
                       turma.setNomeTurma(rs.getString("nomeTurma"));
                       turma.setId(rs.getLong("id"));

                       Curso curso = new Curso();
                       curso.setId(rs.getLong("curso"));
                       turma.setCurso(curso);

                       Professor professor = new Professor();
                       professor.setId(rs.getLong("professor"));
                       turma.setProfessor(professor);
                   }
               }
           }

        return turma;
    }

    public Turma atualizarTurma(Turma turma, long id) throws SQLException{
            String sql = """
                    UPDATE turma
                    SET
                    nomeTurma
                    curso
                    professor
                    FROM turma
                    """;
            try (Connection conn = Conexao.connection();
            PreparedStatement psUPD = conn.prepareStatement(sql)){
                psUPD.setString(1,turma.getNomeTurma());
                psUPD.setLong(2,turma.getCurso().getId());
                psUPD.setLong(3,turma.getProfessor().getId());
                psUPD.setLong(4,id);

                psUPD.executeUpdate();
            }
        return turma;
    }

    public void deletarTurma(long id) throws SQLException{
        String sql = """
                DELETE FROM turma
                WHERE id = ?
                """;

        try (Connection conn = Conexao.connection();
        PreparedStatement psDel = conn.prepareStatement(sql)){
            psDel.setLong(1,id);

            psDel.executeUpdate();
        }
    }
}
