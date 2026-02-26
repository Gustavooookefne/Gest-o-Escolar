package com.weg.GestaoEscolar.Repository;

import com.weg.GestaoEscolar.Model.Professor;
import com.weg.GestaoEscolar.Utills.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProfessorRepository {

    public Professor salvarProfessor(Professor professor)throws SQLException{
            String sql = """
                    INSERT INTO professor
                    (nome ,email ,disiplina)
                    VALUES
                    (?,?,?)
                    """;

            try (Connection conn = Conexao.connection();
                 PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                 ps.setLong(1,professor.getId());
                 ps.setString(2,professor.getNome());
                 ps.setString(3,professor.getEmail());
                 ps.setString(4,professor.getDisiplina());

                 try (ResultSet rs = ps.getGeneratedKeys()){
                     professor.setId(rs.getLong(1));
                 }
            }

        return professor;
    }

    public List<Professor> listarTodosOsProfessores()throws SQLException{
           List<Professor>professors = new ArrayList<>();

           String sql = """
                   SELECET id,
                   nome,
                   email,
                   disiplina,
                   FROM professor
                   """;

           try (Connection conn = Conexao.connection();
           PreparedStatement psList = conn.prepareStatement(sql)){
               ResultSet rs = psList.executeQuery();
               while (rs.next()){
                   Professor professor = new Professor();
                   professor.setId(rs.getLong("id"));
                   professor.setNome(rs.getString("nome"));
                   professor.setEmail(rs.getString("email"));
                   professor.setDisiplina(rs.getString("disiplina"));

                   professors.add(professor);

               }
           }
        return professors;
    }

    public Professor buscarPorId(long id)throws SQLException{
            Professor professor = null;
            String sql = """
                    SELECT id,
                    nome,
                    email,
                    disiplina,
                    FROM professor,
                    WHERE id = ?
                    """;
            try (Connection conn = Conexao.connection();
            PreparedStatement psId = conn.prepareStatement(sql)){
                psId.setLong(1,id);
                try (ResultSet rs = psId.executeQuery()){
                    if(rs.next()){
                        professor = new Professor();
                        professor.setId(rs.getLong("id"));
                        professor.setNome(rs.getString("nome"));
                        professor.setEmail(rs.getString("email"));
                        professor.setDisiplina(rs.getString("disiplina"));

                    }
                }
            }
        return professor;
    }

    public Professor atualizarProfessor(Professor professor, long id)throws SQLException{
            String sql = """
                    UPDATE professor
                    SET
                    nome = ?
                    email = ?
                    disiplina = ?
                    FROM professor
                    WHERE id = ?
                    """;
            try (Connection conn = Conexao.connection();
            PreparedStatement psAt = conn.prepareStatement(sql)){
                psAt.setString(1,professor.getNome());
                psAt.setString(2,professor.getEmail());
                psAt.setString(3,professor.getDisiplina());
                psAt.setLong(4,id);
            }

        return professor;
    }

    public void deletarProfessor(long id)throws SQLException{
        String sql = """
                DELETE FROM professor
                WHERE id = ?
                """;
        try (Connection conn = Conexao.connection();
        PreparedStatement psDel = conn.prepareStatement(sql)){
            psDel.setLong(1,id);
            psDel.executeUpdate();
        }
    }
}
