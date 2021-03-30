/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import models.Palavra;

/**
 * Determina regras para uma palavra ser salva no banco de dados.
 *
 * @author Tiago Enriquez Tachy
 */
public class PalavraRN {

    /**
     * Edita uma palavra.
     *
     * @param palavra
     * @return
     * @throws java.lang.Exception
     */
    public Palavra editar(Palavra palavra) throws Exception {
        String nome = palavra.getNome().toLowerCase();
        nome = nome.replace("á", "a");
        nome = nome.replace("ê", "a");
        nome = nome.replace("ã", "a");
        nome = nome.replace("ç", "c");
        nome = nome.replace("é", "e");
        nome = nome.replace("ê", "e");
        nome = nome.replace("í", "i");
        nome = nome.replace("ó", "o");
        nome = nome.replace("ô", "o");
        nome = nome.replace("õ", "o");
        nome = nome.replace("ú", "u");
        return new Palavra(palavra.getId(), nome);
    }

}
