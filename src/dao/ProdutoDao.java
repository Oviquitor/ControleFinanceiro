/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author andre
 */
public class ProdutoDao {

    java.sql.Connection con;

    public boolean gravar(Produto pro) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "insert into produto (codigoBarras,nome,unidade,preco) values ('"
                + pro.codigoBarras + "','"
                + pro.nome + "','"
                + pro.unidade + "','"
                + pro.preco
                + "')";

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

    public boolean remover(Produto pro) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "delete from produto where id=" + pro.id;

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

    public boolean alterar(Produto pro) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "update produto set "
                + " nome = '" + pro.nome + "',"
                + " codigobarras = '" + pro.codigoBarras + "',"
                + " unidade = '" + pro.unidade + "',"
                + " preco = '" + pro.preco + "'"
                + " where id= " + pro.id;

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

    public List<Produto> listar(String condicao) {
        //CRIA UMA LISTA DE PESSOAS 
        List<Produto> retorno = new ArrayList<>();

        //COMANDO DE SELEÇÃO
        String select = "select * from produto " + condicao;

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
                Produto pro = new Produto();
                pro.id = rs.getInt("id");
                pro.codigoBarras = rs.getString("codigoBarras");
                pro.nome = rs.getString("nome");
                pro.unidade = rs.getString("unidade");
                pro.preco = rs.getDouble("preco");

                //ADICIONA A PESSOA NA LISTA DE PESSOAS
                retorno.add(pro);
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

//    public Produto autenticar(String login, String senha) {
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
//                p = new Pessoa();
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

}
