/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Tiago Enriquez Tachy
 */
public class Jogo {

    private int acertos;
    private int chances;
    private final String palavra;
    private char[] palavraSecreta;
    private int erros;
    private boolean vitoria;
    

    /**
     * Inicializa o Jogo da Forca.
     *
     * @param palavra
     */
    public Jogo(String palavra) {
        this.acertos = 0;
        this.chances = 6;
        this.palavra = palavra;
        this.palavraSecreta = palavraSecreta(palavra);
        this.erros = 0;
        this.vitoria = false;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getChances() {
        return chances;
    }

    public String getPalavra() {
        return palavra;
    }

    public char[] getPalavraSecreta() {
        return palavraSecreta;
    }

    public int getErros() {
        return erros;
    }

    public boolean isVitoria() {
        return vitoria;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    public void setPalavraSecreta(char[] palavraSecreta) {
        this.palavraSecreta = palavraSecreta;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public void setVitoria(boolean vitoria) {
        this.vitoria = vitoria;
    }

    /**
     * Obtem a String com traços com o número de letras da palavra escolhida ou
     * sorteada.
     *
     * @param palavra
     * @return
     */
    private char[] palavraSecreta(String palavra) {
        char[] palavraSecreta = new char[palavra.length()];
        for (int i = 0; i < palavra.length(); i++) {
            palavraSecreta[i] = '-';
        }
        return palavraSecreta;
    }

}
