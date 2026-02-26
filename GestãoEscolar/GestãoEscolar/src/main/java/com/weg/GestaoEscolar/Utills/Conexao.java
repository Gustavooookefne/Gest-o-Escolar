package com.weg.GestaoEscolar.Utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "";
    private static final String USER = "root";
    private static final String PASSW = "root";

    public static Connection connection()throws SQLException{
        return DriverManager.getConnection(URL ,USER ,PASSW);
    }
}
