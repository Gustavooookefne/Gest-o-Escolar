package com.weg.GestaoEscolar.Repository;

import com.weg.GestaoEscolar.Model.Aula;
import com.weg.GestaoEscolar.Model.Turma;
import com.weg.GestaoEscolar.Utills.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AulaRepository {

    public Aula novaAulas(Aula aula) throws SQLException {

        String sql = """
                INSERT INTO aula
                (turma dataHora assuntos)
                VALUES
                (?,?,?)
                """;

        try (Connection conn = Conexao.connection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
             ps.setLong(1,aula.getId());
             ps.setLong(2,aula.getTurma().getId());
             ps.setDate(3, Date.valueOf(aula.getDataHora()));
             ps.setString(4,aula.getAssuntos());

             ps.executeUpdate();
        }
        return aula;
    }

    public List<Aula> listarAulas() throws SQLException{
           List<Aula> aulas = new ArrayList<>();

           String sql = """
                   SELECT id
                   turma
                   dataHora
                   assunto
                   FROM aulas
                   """;

           try (Connection conn = Conexao.connection();
           PreparedStatement psList = conn.prepareStatement(sql)){
               ResultSet rs = psList.executeQuery();
               while (rs.next()){
                   Aula aula = new Aula();
                   aula.setAssuntos(rs.getString("assunto"));
                   aula.setId(rs.getLong("id"));

                   Turma turma = new Turma();
                   turma.setId(rs.getLong("turma"));
                   aula.setTurma(turma);

                   aula.setDataHora(rs.getDate("dataHora").toLocalDate());

                    aulas.add(aula);
               }
           }
        return aulas;
    }

    public Aula buscarPorId(long id) throws SQLException{
            Aula aula = null;

            String sql = """
                    SELECT id,
                    turma,
                    dataHora,
                    Assuntos,
                    FROM aulas
                    WHERE id = ?
                    """;

            try (Connection conn = Conexao.connection();
            PreparedStatement psId = conn.prepareStatement(sql)){
                psId.setLong(1,id);
                try (ResultSet rs = psId.executeQuery()){
                    if(rs.next()){
                        aula = new Aula();
                        aula.setAssuntos(rs.getString("assunto"));
                        aula.setId(rs.getLong("id"));

                        Turma turma = new Turma();
                        turma.setId(rs.getLong("turma"));
                        aula.setTurma(turma);

                        aula.setDataHora(rs.getDate("dataHora").toLocalDate());
                    }
                }
            }
        return null;
    }

    public Aula atualizarAulas(Aula aula, long id) throws SQLException{
            String sql = """
                    UPDATE aulas
                    SET 
                    turma = ?
                    dataHora = ?
                    assunto = ?
                    WHERE id = ?
                    """;

            try (Connection conn = Conexao.connection();
            PreparedStatement psUPD = conn.prepareStatement(sql)){
                psUPD.setString(1,aula.getAssuntos());
                psUPD.setLong(2,aula.getTurma().getId());
                psUPD.setDate(3, Date.valueOf(aula.getDataHora()));
                psUPD.setLong(4, aula.getId());
            }
        return aula;
    }

    public void deletarAulas(long id) throws SQLException{
        String sql = """
                DELETE FROM aula
                WHERE id = ?
                """;

        try (Connection conn = Conexao.connection();
        PreparedStatement psDel = conn.prepareStatement(sql)){
            psDel.setLong(1,id);

            psDel.executeUpdate();
        }
    }
}
