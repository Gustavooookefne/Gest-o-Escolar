package com.weg.GestaoEscolar.Repository;

import com.weg.GestaoEscolar.Model.Aluno;
import com.weg.GestaoEscolar.Utills.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    public Aluno novoAluno(Aluno aluno)throws SQLException{
        String sql = """
                INSERT INTO aluno
                (nome ,email ,matricula ,dataNacimento)
                VALUES
                (?,?,?,?)
                """;

        try (Connection conn = Conexao.connection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
             ps.setLong(1, aluno.getId());
             ps.setString(2, aluno.getNome());
             ps.setString(3, aluno.getEmail());
             ps.setInt(4, aluno.getMatricula());
             ps.setString(5, aluno.getDataNacimento());

             ps.executeUpdate();

             try (ResultSet rs = ps.getGeneratedKeys()){
                 if(rs.next()){
                     aluno.setId(rs.getLong(1));
                 }
             }

        }
        return aluno;
    }

    public List<Aluno> listarTodosOsAlunos()throws SQLException{
           List<Aluno>alunos = new ArrayList<>();

           String sql = """
                   SELECT id,
                   nome,
                   email,
                   matricula,
                   dataNacimento,
                   FROM aluno
                   """;

           try (Connection conn = Conexao.connection();
           PreparedStatement psList = conn.prepareStatement(sql)){
               ResultSet rs = psList.executeQuery();
               while (rs.next()){
                   Aluno aluno = new Aluno();
                   aluno.setId(rs.getLong("id"));
                   aluno.setNome(rs.getString("nome"));
                   aluno.setEmail(rs.getString("email"));
                   aluno.setMatricula(rs.getInt("matricula"));
                   aluno.setDataNacimento(rs.getString("dataNacimento"));

                   alunos.add(aluno);
               }
           }

        return alunos;
    }

    public Aluno listarPorId(long id)throws SQLException{
           Aluno aluno = null;

           String sql = """
                   SELECT id,
                   nome,
                   email,
                   matricula,
                   dataNacimento,
                   FROM aluno
                   WHERE id = ?
                   """;
        try (Connection conn = Conexao.connection();
             PreparedStatement psId = conn.prepareStatement(sql)){

             psId.setLong(1,id);
            try (ResultSet rs = psId.executeQuery()){
                if(rs.next()){
                    aluno = new Aluno();
                    aluno.setNome(rs.getString("nome"));
                    aluno.setEmail(rs.getString("email"));
                    aluno.setMatricula(rs.getInt("matricula"));
                    aluno.setDataNacimento(rs.getString("dataNacional"));
                    aluno.setId(rs.getLong("id"));
                }
            }

        }

        return aluno;
    }

    public Aluno atualizarAluno(Aluno aluno, long id)throws SQLException{
            String sql = """
                    UPDATE aluno
                    SET
                    nome = ?
                    email = ?
                    matricula = ?
                    dataNacimento = ?
                    WHERE id = ?
                    """;

        try (Connection conn = Conexao.connection();
             PreparedStatement psUPD = conn.prepareStatement(sql)){
             psUPD.setString(1, aluno.getNome());
             psUPD.setString(2, aluno.getEmail());
             psUPD.setInt(3, aluno.getMatricula());
             psUPD.setString(4, aluno.getDataNacimento());
             psUPD.setLong(5, id);

             psUPD.executeUpdate();
        }


        return aluno;
    }

    public void deletarAluno(long id)throws SQLException{
        String sql = """
                DELETE FROM aluno
                WHERE id = ?
                """;
        try (Connection conn = Conexao.connection();
        PreparedStatement psDel = conn.prepareStatement(sql)){
            psDel.setLong(1, id);
            psDel.executeUpdate();
        }
    }
}
