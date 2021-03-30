/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;

/**
 * Mostra as mais diversas telas de mensagem exibidas no programa.
 *
 * @author Tiago Enriquez Tachy
 */
public class Mensagem {

    /**
     * Mostra uma caixa na qual o usuário pode escolher como deseja obter a
     * palavra.
     *
     * @return
     */
    public static String selecionarJogo() {
        Object[] opcao = {"Digitar palavra", "Palavra aleatória"};
        return (String) JOptionPane.showInputDialog(null, "Selecione modo de obtenção de palavra.\n", "Seleção", JOptionPane.PLAIN_MESSAGE, null,
                opcao, "Palavra aleatória");
    }

    /**
     * Mostra uma janela com um comando e retorna a resposta que o usuário dá ao
     * comando.
     *
     * @param comando
     * @return
     */
    public static String resposta(String comando) {
        return (String) JOptionPane.showInputDialog(comando);
    }

    /**
     * Mostra janela com mensagem de erro.
     *
     * @param mensagem
     */
    public static void erro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mostra uma janela com mensagem de operação bem sucedida.
     *
     * @param mensagem
     */
    public static void sucesso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Operação bem sucedida", JOptionPane.INFORMATION_MESSAGE);
    }

}
