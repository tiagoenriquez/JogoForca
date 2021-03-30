/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Palavra;
import util.Conexao;

/**
 * Persiste e recupera dados do banco de dados.
 *
 * @author Tiago Enriquez Tachy
 */
public class PalavraDao {

    Connection conexao;

    /**
     * Constrói um objeto que persiste e recupera dados do banco de dados.
     *
     * @throws Exception
     */
    public PalavraDao() throws Exception {
        try {
            this.conexao = Conexao.getConnection();
        } catch (Exception exception) {
            throw new Exception("Erro na conexao com o banco de dados");
        }
    }

    /**
     * Insere uma palavra no banco de dados.
     *
     * @param palavra
     * @throws Exception
     */
    public void inserir(Palavra palavra) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        if (palavra == null) {
            throw new Exception("Impossível inserir dados nulos.");
        }
        try {
            conexao = this.conexao;
            preparedStatement = conexao.prepareStatement("insert into palavras(nome) values (?)");
            preparedStatement.setString(1, palavra.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            throw new Exception("Erro na inserção da palavra no banco de dados.");
        } finally {
            Conexao.closeConnection(conexao, preparedStatement);
        }
    }

    /**
     * Corrige uma palavra no banco de dados.
     *
     * @param palavra
     * @throws Exception
     */
    public void corrigir(Palavra palavra) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        if (palavra == null) {
            throw new Exception("Impossível corrigir dados nulos.");
        }
        try {
            conexao = this.conexao;
            preparedStatement = conexao.prepareStatement("update palavras set nome = ? where id = ?");
            preparedStatement.setString(1, palavra.getNome());
            preparedStatement.setInt(2, palavra.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            throw new Exception("Erro na correção da palavra no banco de dados.");
        } finally {
            Conexao.closeConnection(conexao, preparedStatement);
        }
    }

    /**
     * Exclui uma palavra do banco de dados.
     *
     * @param palavra
     * @throws Exception
     */
    public void excluir(Palavra palavra) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        if (palavra == null) {
            throw new Exception("Impossível deletar dados nulos.");
        }
        try {
            conexao = this.conexao;
            preparedStatement = conexao.prepareStatement("delete from palavras where id = ?");
            preparedStatement.setInt(1, palavra.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            throw new Exception("Erro na exclusão da palavra no banco de dados.");
        } finally {
            Conexao.closeConnection(conexao, preparedStatement);
        }
    }

    /**
     * Procura uma palavra no banco de dados que tem o id passado como
     * parâmetro.
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Palavra procurar(int id) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conexao = this.conexao;
            preparedStatement = conexao.prepareStatement("select * from palavras where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new Exception("Palavra não encontrada");
            }
            return new Palavra(id, resultSet.getString("nome"));
        } catch (Exception exception) {
            throw new Exception("Erro na localização da palavra.");
        } finally {
            Conexao.closeConnection(conexao, preparedStatement, resultSet);
        }
    }

    /**
     * Procura uma palavra no banco de dados que tem o nome passado como
     * parâmetro.
     *
     * @param nome
     * @return
     * @throws Exception
     */
    public Palavra procurar(String nome) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conexao = this.conexao;
            preparedStatement = conexao.prepareStatement("select * from palavras where nome = ?");
            preparedStatement.setString(1, nome);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new Exception("Palavra não encontrada");
            }
            return new Palavra(resultSet.getInt("id"), nome);
        } catch (Exception exception) {
            throw new Exception("Erro na localização da palavra.");
        } finally {
            Conexao.closeConnection(conexao, preparedStatement, resultSet);
        }
    }

    /**
     * Conta a quantidade de palavras gravadas no banco de dados.
     *
     * @return
     * @throws Exception
     */
    public int contar() throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conexao = this.conexao;
            preparedStatement = conexao.prepareStatement("select count(*) as quantidade from palavras");
            resultSet = preparedStatement.executeQuery();
            int quantidade = 0;
            while (resultSet.next()) {
                quantidade = resultSet.getInt("quantidade");
            }
            return quantidade;
        } catch (SQLException sQLException) {
            throw new Exception("Erro na contagem das palavras");
        } finally {
            Conexao.closeConnection(conexao, preparedStatement, resultSet);
        }
    }

}
