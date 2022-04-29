/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Movimentos;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import model.Util;

/**
 *
 * @author andre
 */
public class MovimentosDao {

    java.sql.Connection con;

    public boolean gravar(Movimentos m) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "insert into movimentos"
                + "(data,id_pessoa,valor,tipo, obs, id_usuario) values ("
                + "'" + dataFormatoSql(m.data) + "',"
                + m.id_pessoa + ","
                + m.valor + ","
                + "'" + m.tipo + "',"
                + "'" + m.obs + "',"
                + m.id_usuario
                + ")";

        //CONECTA AO BANCO
        this.con = new Conexao().conectar();

        try {
            //CRIA UM STATEMENT
            java.sql.Statement stmt = con.createStatement();

            //EXCUTA COMANDO
            stmt.executeUpdate(comando);

            //RETORNA VERDADEIRO
            retorno = true;
        } catch (java.sql.SQLException e) {
            throw new java.lang.RuntimeException(e.getMessage());
        }

        //FECHA A CONEXÃO
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new java.lang.RuntimeException("erro fechar");
        }

        //RETORNA A LISTA
        return retorno;

    }

    public boolean remover(Movimentos m) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "delete from movimentos where id=" + m.id;

        //CONECTA AO BANCO
        this.con = new Conexao().conectar();

        try {
            //CRIA UM STATEMENT
            java.sql.Statement stmt = con.createStatement();

            //EXCUTA COMANDO
            stmt.executeUpdate(comando);

            //RETORNA VERDADEIRO
            retorno = true;
        } catch (java.sql.SQLException e) {
            throw new java.lang.RuntimeException(e.getMessage());
        }

        //FECHA A CONEXÃO
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new java.lang.RuntimeException("erro fechar");
        }

        //RETORNA A LISTA
        return retorno;

    }

    public boolean alterar(Movimentos m) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "update movimentos set "
                + " data = '" + dataFormatoSql(m.data) + "',"
                + " id_pessoa = " + m.id_pessoa + ","
                + " valor = " + m.valor + ","
                + " tipo = '" + m.tipo + "',"
                + " obs = '" + m.obs + "',"
                + " id_usuario = " + m.id_usuario
                + " where id= " + m.id;

        //CONECTA AO BANCO
        this.con = new Conexao().conectar();

        try {
            //CRIA UM STATEMENT
            java.sql.Statement stmt = con.createStatement();

            //EXCUTA COMANDO
            stmt.executeUpdate(comando);

            //RETORNA VERDADEIRO
            retorno = true;
        } catch (java.sql.SQLException e) {
            throw new java.lang.RuntimeException(e.getMessage());
        }

        //FECHA A CONEXÃO
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new java.lang.RuntimeException("erro fechar");
        }

        //RETORNA A LISTA
        return retorno;

    }

    public List<Movimentos> listar(String condicao) {
        //CRIA UMA LISTA DE PESSOAS 
        List<Movimentos> retorno = new ArrayList<>();

        //COMANDO DE SELEÇÃO
        String select = "select p.nome as nome_pessoa, m.* from movimentos m "
                + " join pessoa p on p.id=m.id_pessoa "
                + condicao;

        //CONECTA AO BANCO
        this.con = new Conexao().conectar();

        try {
            //CRIA UM STATEMENT
            java.sql.Statement stmt = con.createStatement();

            //EXECUTA O COMANDO
            java.sql.ResultSet rs = stmt.executeQuery(select);

            //PERCORRE OS RESULTADOS
            while (rs.next()) {
                //CRIA UMA NOVA PESSOA
                Movimentos m = new Movimentos();
                m.id = rs.getInt("id");
                m.data = dataFormatPadrao(rs.getDate("data"));
                m.id_pessoa = rs.getInt("id_pessoa");
                m.valor = rs.getDouble("valor");
                m.tipo = rs.getString("tipo");
                m.id_usuario = rs.getInt("id_usuario");
                m.nome_pessoa = rs.getString("nome_pessoa");
                m.obs = rs.getString("obs");

                //ADICIONA A PESSOA NA LISTA DE PESSOAS
                retorno.add(m);
            }
        } catch (java.sql.SQLException e) {
            throw new java.lang.RuntimeException("erro na selecao");
        }

        //FECHA A CONEXÃO
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new java.lang.RuntimeException("erro fechar");
        }

        //RETORNA A LISTA
        return retorno;

    }
    
     public Double saldo(int id_usuario, String dataInicial) {
        //CRIA UMA LISTA DE PESSOAS 
        Double retorno = 0.0;

        //COMANDO DE SELEÇÃO
        String select = " select " 
                + " sum(case when tipo='C' then valor else valor*-1 end) as saldo"
                + " from movimentos where 1=1 "
                + (dataInicial !=null ? " and data < '"+dataInicial+"' " : "")
                + " and id_usuario=" + id_usuario;

        //CONECTA AO BANCO
        this.con = new Conexao().conectar();

        try {
            //CRIA UM STATEMENT
            java.sql.Statement stmt = con.createStatement();

            //EXECUTA O COMANDO
            java.sql.ResultSet rs = stmt.executeQuery(select);

            //PERCORRE OS RESULTADOS
            while (rs.next()) {
                //CRIA UMA NOVA PESSOA
                retorno = rs.getDouble("saldo");
                
            }
        } catch (java.sql.SQLException e) {
            throw new java.lang.RuntimeException("erro na selecao");
        }

        //FECHA A CONEXÃO
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new java.lang.RuntimeException("erro fechar");
        }

        //RETORNA A LISTA
        return retorno;

    }

//    public Pessoa autenticar(String login, String senha) {
//        Pessoa p = null;
//
//        //COMANDO DE SELEÇÃO
//        String select = "select * from pessoa "
//                + " where login='" + login + "' "
//                + " and senha='" + senha + "' ";
//
//        //CONECTA AO BANCO
//        this.con = new Conexao().conectar();
//
//        try {
//            //CRIA UM STATEMENT
//            java.sql.Statement stmt = con.createStatement();
//
//            //EXECUTA O COMANDO
//            java.sql.ResultSet rs = stmt.executeQuery(select);
//
//            //PERCORRE OS RESULTADOS
//            while (rs.next()) {
//                p = new Movimentos();
//                p.id = rs.getInt("id");
//                p.nome = rs.getString("nome");
//
//                p.tipo = rs.getString("tipo");
//                p.login = rs.getString("login");
//                p.senha = rs.getString("senha");
//
//            }
//        } catch (java.sql.SQLException e) {
//            throw new java.lang.RuntimeException("erro na selecao");
//        }
//
//        //FECHA A CONEXÃO
//        try {
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new java.lang.RuntimeException("erro fechar");
//        }
//
//        return p;
//    }

    public static String dataFormatoSql(String data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSql = new SimpleDateFormat("yyyy-MM-dd");
                
        Date date = null;

        try {
            date = (Date) formatter.parse(data);
        } catch (ParseException ex) {

        }
        return formatoSql.format(date);
    }
    
    public static String dataFormatPadrao(Date date) {
        SimpleDateFormat fomatoSQL = new SimpleDateFormat("dd/MM/yyyy");
        return fomatoSQL.format(date);
    }
    
    

}
