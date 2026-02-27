package com.weg.GestaoEscolar.Repository;

import com.weg.GestaoEscolar.Model.Curso;
import com.weg.GestaoEscolar.Utills.Conexao;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CursoRepository {

    public Curso novaCurso(Curso curso) throws SQLException {
            String sql = """
                    INSERT INTO curso
                    (nomeCurso, codigo)
                    VALUES
                    (?,?)
                    """;

            try (Connection conn = Conexao.connection();
                 PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                 ps.setLong(1, curso.getId());
                 ps.setString(2,curso.getNomeCurso());
                 ps.setInt(3,curso.getCodigo());

                 ps.executeUpdate();

                 try (ResultSet rs = ps.getGeneratedKeys()){
                     if(rs.next()){
                         curso.setId(rs.getLong(1));
                     }
                 }
            }
        return curso;
    }

    public List<Curso> listarCurso() throws SQLException{
           List<Curso> cursos = new ArrayList<>();

           String sql = """
                   SELECT id,
                   nomeCurso,
                   codigo,
                   FROM curso
                   """;

           try (Connection conn = Conexao.connection();
                PreparedStatement psList = conn.prepareStatement(sql)){
                ResultSet rs = psList.executeQuery();
                while (rs.next()){
                    Curso curso = new Curso();
                    curso.setNomeCurso(rs.getString("nomeCurso"));
                    curso.setCodigo(rs.getInt("codigo"));
                    curso.setId(rs.getLong("id"));

                    cursos.add(curso);
                }
           }

        return cursos;
    }

    public Curso buscarPorId(long id) throws SQLException{
            Curso curso = null;

            String sql = """
                    SELECT id,
                    nomeCurso,
                    codigo,
                    FROM curso
                    WHERE id = ?
                    """;

            try (Connection conn = Conexao.connection();
            PreparedStatement psID = conn.prepareStatement(sql)){
                psID.setLong(1,id);

                try (ResultSet rs = psID.executeQuery()){
                    if(rs.next()){
                        curso = new Curso();
                        curso.setNomeCurso(rs.getString("nomeCurso"));
                        curso.setCodigo(rs.getInt("codigo"));
                        curso.setId(rs.getLong("id"));
                    }
                }
            }


        return curso;
    }

    public Curso atualizarCurso(Curso curso, long id) throws SQLException{
            String sql = """
                    UPDATE curso
                    SET 
                    nomeCurso = ?
                    codigo = ?
                    WHERE id = ?
                    """;

            try (Connection conn = Conexao.connection();
            PreparedStatement psUPD = conn.prepareStatement(sql)){
                psUPD.setLong(1,curso.getId());
                psUPD.setString(2,curso.getNomeCurso());
                psUPD.setInt(3,curso.getCodigo());

                psUPD.executeUpdate();
            }
        return curso;
    }

    public void deletarCurso(long id) throws SQLException{
        String sql = """
                DELETE FROM curso
                WHERE id = ?
                """;

        try (Connection conn = Conexao.connection();
        PreparedStatement psDEL = conn.prepareStatement(sql)){

            psDEL.setLong(1,id);
            psDEL.executeUpdate();

        }
    }
}
