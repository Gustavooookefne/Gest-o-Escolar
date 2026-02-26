package com.weg.GestaoEscolar.Repository;

import com.weg.GestaoEscolar.Model.Aluno;
import com.weg.GestaoEscolar.Model.Aula;
import com.weg.GestaoEscolar.Model.Nota;
import com.weg.GestaoEscolar.Utills.Conexao;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NotaRepository {

    public Nota novaNota(Nota nota) throws SQLException {
            String sql = """
                    INSERTO INTO nota
                    (aluno ,aula ,nota)
                    VALUES
                    (?,?,?)
                    """;

            try (Connection conn = Conexao.connection();
                 PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                    ps.setLong(1,nota.getId());
                    ps.setLong(2,nota.getAluno().getId());
                    ps.setLong(3,nota.getAula().getId());
                    ps.setDouble(4,nota.getNota());

                    ps.executeUpdate();

                    try (ResultSet rs = ps.getGeneratedKeys()){
                        if(rs.next()){
                            nota.setId(rs.getLong(1));
                        }
                    }
            }
        return nota;
    }

    public List<Nota> listarNota() throws SQLException{
           List<Nota>notas = new ArrayList<>();

           String sql = """
                   SELECT id
                   auluno
                   aula
                   nota
                   FROM nota
                   """;

           try (Connection conn = Conexao.connection();
           PreparedStatement psList = conn.prepareStatement(sql)){
               ResultSet rs = psList.executeQuery();
               while (rs.next()){
                   Nota nota = new Nota();
                   nota.setNota(rs.getDouble("nota"));
                   nota.setId(rs.getLong("id"));

                   Aluno aluno = new Aluno();
                   aluno.setId(rs.getLong("aluno"));
                   nota.setAluno(aluno);

                   Aula aula = new Aula();
                   aula.setId(rs.getLong("aula"));
                   nota.setAula(aula);

                   notas.add(nota);
               }
           }
        return notas;
    }

    public Nota buscarPorId(long id) throws SQLException{
        Nota nota = null;

        String sql = """
                SELECT id,
                aluno,
                aula,
                nota,
                FROM nota
                WHERE id = ?
                """;

        try (Connection conn = Conexao.connection();
        PreparedStatement psID = conn.prepareStatement(sql)){
            psID.setLong(1,id);
            try (ResultSet rs = psID.executeQuery()){
                if(rs.next()){
                    nota = new Nota();
                    nota.setNota(rs.getDouble("nota"));
                    nota.setId(rs.getLong("id"));

                    Aluno aluno = new Aluno();
                    aluno.setId(rs.getLong("aluno"));
                    nota.setAluno(aluno);

                    Aula aula = new Aula();
                    aula.setId(rs.getLong("aula"));
                    nota.setAula(aula);
                }
            }

        }
        return nota;
    }

    public Nota atualizarNota(Nota nota, long id) throws SQLException{
            String sql = """
                    UPDATE nota
                    SET
                    aluno = ? 
                    aula = ?
                    nota = ?
                    WHERE id = ?
                    """;

            try (Connection conn = Conexao.connection();
            PreparedStatement psUPD = conn.prepareStatement(sql)){
                psUPD.setDouble(1,nota.getNota());
                psUPD.setLong(2,nota.getAluno().getId());
                psUPD.setLong(3,nota.getAula().getId());
                psUPD.setLong(4,id);
            }
        return nota;
    }

    public void deletarNota(long id) throws SQLException{
        String sql = """
                DELETE FROM nota
                WHERE id = ?
                """;
        try (Connection conn = Conexao.connection();
        PreparedStatement psDEL = conn.prepareStatement(sql)){
            psDEL.setLong(1,id);
            psDEL.executeUpdate();
        }
    }
}
