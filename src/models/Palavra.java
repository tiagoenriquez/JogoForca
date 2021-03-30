/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * Guarda os atributos de uma palavra, constrói e obtem os dados de uma palavra.
 *
 * @author Tiago Enriquez Tachy
 */
public class Palavra {
    
    private int id;
    private final String nome;

    /**
     * Inicia palavra passando todos os atributos.
     *
     * @param id
     * @param nome
     * @throws java.lang.Exception
     */
    public Palavra(int id, String nome) throws Exception {
        this.id = id;
        this.nome = nome(nome);
    }

    /**
     * Inicia palavra passando somente o nome.
     *
     * @param nome
     * @throws java.lang.Exception
     */
    public Palavra(String nome) throws Exception {
        this.nome = nome(nome);
    }

    /**
     * Obtem o id da palavra.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Obtem o nome da palavra.
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Valida o nome da palavra apenas se não for vazio.
     *
     * @param nome
     * @return
     * @throws Exception
     */
    private String nome(String nome) throws Exception {
        if (!"".equals(nome)) {
            return nome;
        } else {
            throw new Exception("A palavra não pode ser nula.");
        }
    }
    
}
