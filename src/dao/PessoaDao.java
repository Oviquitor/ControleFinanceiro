/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author andre
 */
public class PessoaDao {

    java.sql.Connection con;

    public boolean gravar(Pessoa p) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "insert into pessoa (nome,tipo,login,senha) values ('"
                + p.nome + "','"
                + p.tipo + "','"
                + p.login + "','"
                + p.senha
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

    public boolean remover(Pessoa p) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "delete from pessoa where id=" + p.id;

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

    public boolean alterar(Pessoa p) {
        //CRIA UM RETORNO
        boolean retorno = false;

        //COMANDO PARA GRAVAR PESSOA
        String comando = "update pessoa set "
                + " nome = '" + p.nome + "',"
                + " tipo = '" + p.tipo + "',"
                + " login = '" + p.login + "',"
                + " senha = '" + p.senha + "'"
                + " where id= " + p.id;

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

    public List<Pessoa> listar(String condicao) {
        //CRIA UMA LISTA DE PESSOAS 
        List<Pessoa> retorno = new ArrayList<>();

        //COMANDO DE SELEÇÃO
        String select = "select * from pessoa " + condicao;

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
                Pessoa p = new Pessoa();
                p.id = rs.getInt("id");
                p.nome = rs.getString("nome");

                p.tipo = rs.getString("tipo");
                p.login = rs.getString("login");
                p.senha = rs.getString("senha");

                //ADICIONA A PESSOA NA LISTA DE PESSOAS
                retorno.add(p);
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

    public Pessoa autenticar(String login, String senha) {
        Pessoa p = null;

        //COMANDO DE SELEÇÃO
        String select = "select * from pessoa "
                + " where login='" + login + "' "
                + " and senha='" + senha + "' ";

        //CONECTA AO BANCO
        this.con = new Conexao().conectar();

        try {
            //CRIA UM STATEMENT
            java.sql.Statement stmt = con.createStatement();

            //EXECUTA O COMANDO
            java.sql.ResultSet rs = stmt.executeQuery(select);

            //PERCORRE OS RESULTADOS
            while (rs.next()) {
                p = new Pessoa();
                p.id = rs.getInt("id");
                p.nome = rs.getString("nome");

                p.tipo = rs.getString("tipo");
                p.login = rs.getString("login");
                p.senha = rs.getString("senha");

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

        return p;
    }

}
