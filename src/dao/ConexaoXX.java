package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoXX {

    public static Connection abrirConexao() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String servidor = "127.0.0.1";
            String database = "controlefinanceiroasou";
            String porta = "3306";

            String bd_url = "jdbc:mysql://" + servidor + ":" + porta + "/" + database + "?useTimezone=true&serverTimezone=UTC";

            String usuario = "root";
            String senha = "1234";

            return DriverManager.getConnection(bd_url, usuario, senha);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public static void fechar(Connection con, Statement stmt, ResultSet rs) throws Exception {

        try {

            if (rs != null) {rs.close();}
            if (stmt != null) {stmt.close();}
            if (con != null) {con.close();}

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    
    public static void fecharConexao(Connection con, Statement stmt, ResultSet rs) throws Exception{
        fechar(con,stmt,rs);
    }
    
    public static void fecharConexao(Connection con, Statement stmt) throws Exception{
        fechar(con,stmt,null);
    }
    
    public static void fecharConexao(Connection con) throws Exception{
        fechar(con,null,null);
    }
    
    

}