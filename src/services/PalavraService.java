/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.PalavraDao;
import models.Palavra;
import rn.PalavraRN;

/**
 * Aciona métodos de persistência e busca no banco de dados.
 *
 * @author Tiago Enriquez Tachy
 */
public class PalavraService {

    /**
     * Obtem uma palavra editada e a manda para inserção no banco de dados.
     *
     * @param palavra
     * @throws Exception
     */
    public void inserir(Palavra palavra) throws Exception {
        new PalavraDao().inserir(new PalavraRN().editar(palavra));
    }

    /**
     * Obtem uma palavra editada e a manda para correção no banco de dados.
     *
     * @param palavra
     * @throws Exception
     */
    public void corrigir(Palavra palavra) throws Exception {
        new PalavraDao().corrigir(new PalavraRN().editar(palavra));
    }

    /**
     * Manda uma palavra para exclusão do banco de dados.
     *
     * @param palavra
     * @throws Exception
     */
    public void excluir(Palavra palavra) throws Exception {
        new PalavraDao().excluir(palavra);
    }

    /**
     * Aciona a busca por uma palavra com um id passado como parâmetro.
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Palavra procurar(int id) throws Exception {
        return new PalavraDao().procurar(id);
    }

    /**
     * Aciona a busca por uma palavra com um nome passado como parâmetro.
     *
     * @param nome
     * @return
     * @throws Exception
     */
    public Palavra procurar(String nome) throws Exception {
        return new PalavraDao().procurar(nome);
    }

    /**
     * Aciona a contagem de palavras gravadas no banco de dados.
     *
     * @return
     * @throws Exception
     */
    public int contar() throws Exception {
        return new PalavraDao().contar();
    }

    /**
     * Sorteia uma palavra.
     *
     * @return
     * @throws Exception
     */
    public String sortear() throws Exception {
        return procurar((int) (Math.random() * contar() + 1)).getNome();
    }

}
