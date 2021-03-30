/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Jogo;

/**
 *
 * @author Tiago Enriquez Tachy
 */
public class JogoService {

    /**
     * Confere se a letra existe na palavra e chama os métodos para cada
     * condição.
     *
     * @param letra
     * @param jogo
     * @return
     */
    public Jogo conferirLetra(char letra, Jogo jogo) {
        boolean acerto = false;
        int acertos = jogo.getAcertos();
        int chances = jogo.getChances();
        int erros = jogo.getErros();
        String palavra = jogo.getPalavra();
        char[] palavraSecreta = jogo.getPalavraSecreta();
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra && palavraSecreta[i] == '-') {
                palavraSecreta[i] = letra;
                acerto = true;
                acertos++;
            }
        }
        if (!acerto) {
            chances--;
            erros++;
        }
        return atualizarJogo(jogo, acertos, chances, erros, palavraSecreta);
    }

    /**
     * Atualiza as informações do jogo.
     *
     * @param jogo
     * @param acertos
     * @param chances
     * @param palavraSecreta
     * @return
     */
    private Jogo atualizarJogo(Jogo jogo, int acertos, int chances, int erros, char[] palavraSecreta) {
        jogo.setAcertos(acertos);
        jogo.setChances(chances);
        jogo.setErros(erros);
        jogo.setPalavraSecreta(palavraSecreta);
        return jogo;
    }

    /**
     * Calcula e retorna as percentagens de acertos e vitórias.
     *
     * @param jogos
     * @param jogo
     * @return
     */
    public Object[] obterPercentagens(List<Jogo> jogos, Jogo jogo) {
        jogos.add(jogo);
        int acertos = 0;
        int erros = 0;
        int vitorias = 0;
        for (Jogo j : jogos) {
            acertos += j.getAcertos();
            erros += j.getErros();
            if (j.isVitoria()) {
                vitorias++;
            }
        }
        Object[] percentagens = new Object[2];
        percentagens[0] = acertos * 100 / (acertos + erros);
        percentagens[1] = vitorias * 100 / jogos.size();
        return percentagens;
    }

}
