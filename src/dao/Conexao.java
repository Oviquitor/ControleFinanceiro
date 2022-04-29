/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author andre
 */
public class Conexao {

    public java.sql.Connection conectar() {

        String host = "127.0.0.1";
        String banco = "controlefinanceiroasou";
        String porta = "3306";

        java.sql.Connection con = null;

        try {

            String url = "jdbc:mysql:" + "//" + host + ":" 
                    + porta + "/" + banco 
                    + "?characterEncoding=utf8";

            Class.forName("com.mysql.jdbc.Driver");
            con = java.sql.DriverManager.getConnection(
                    url, "root", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }

        return con;

    }

}
