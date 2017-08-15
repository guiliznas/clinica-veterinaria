package model;

/**
 *
 * @author(name= Guilherme de Liz do Nascimento, date= 07-21-2017)
 */
public class Capivara {
    //Atributos
    private int qtdSelfiesParticipadas, altura, qtdFilhote, qtdDentes;
    private String nome, nomeCientifico, trechoBeiraRioQueDorme, classificacaoNatacao;
    private float peso;
    private boolean registradaIbama;
    private long registroIbama, qtdGramaComeu;

    /**
     * Contrutor com todos os atributos da classe
     * 
     * @param qtdSelfiesParticipadas
     * @param altura
     * @param qtdFilhote
     * @param qtdDentes
     * @param nome
     * @param nomeCientifico
     * @param trechoBeiraRioQueDorme
     * @param classificacaoNatacao
     * @param peso
     * @param registradaIbama
     * @param registroIbama
     * @param qtdGramaComeu 
     */
    public Capivara(int qtdSelfiesParticipadas, int altura, int qtdFilhote, int qtdDentes, String nome, String nomeCientifico, String trechoBeiraRioQueDorme, String classificacaoNatacao, float peso, boolean registradaIbama, long registroIbama, long qtdGramaComeu) {
        this.qtdSelfiesParticipadas = qtdSelfiesParticipadas;
        this.altura = altura;
        this.qtdFilhote = qtdFilhote;
        this.qtdDentes = qtdDentes;
        this.nome = nome;
        this.nomeCientifico = nomeCientifico;
        this.trechoBeiraRioQueDorme = trechoBeiraRioQueDorme;
        this.classificacaoNatacao = classificacaoNatacao;
        this.peso = peso;
        this.registradaIbama = registradaIbama;
        this.registroIbama = registroIbama;
        this.qtdGramaComeu = qtdGramaComeu;
    }

    /**
     * Construtor vazio
     */
    public Capivara() {
    }

    public int getQtdSelfiesParticipadas() {
        return qtdSelfiesParticipadas;
    }

    public void setQtdSelfiesParticipadas(int qtdSelfiesParticipadas) {
        this.qtdSelfiesParticipadas = qtdSelfiesParticipadas;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getQtdFilhote() {
        return qtdFilhote;
    }

    public void setQtdFilhote(int qtdFilhote) {
        this.qtdFilhote = qtdFilhote;
    }

    public int getQtdDentes() {
        return qtdDentes;
    }

    public void setQtdDentes(int qtdDentes) {
        this.qtdDentes = qtdDentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getTrechoBeiraRioQueDorme() {
        return trechoBeiraRioQueDorme;
    }

    public void setTrechoBeiraRioQueDorme(String trechoBeiraRioQueDorme) {
        this.trechoBeiraRioQueDorme = trechoBeiraRioQueDorme;
    }

    public String getClassificacaoNatacao() {
        return classificacaoNatacao;
    }

    public void setClassificacaoNatacao(String classificacaoNatacao) {
        this.classificacaoNatacao = classificacaoNatacao;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isRegistradaIbama() {
        return registradaIbama;
    }

    public void setRegistradaIbama(boolean registradaIbama) {
        this.registradaIbama = registradaIbama;
    }

    public long getRegistroIbama() {
        return registroIbama;
    }

    public void setRegistroIbama(long registroIbama) {
        this.registroIbama = registroIbama;
    }

    public long getQtdGramaComeu() {
        return qtdGramaComeu;
    }

    public void setQtdGramaComeu(long qtdGramaComeu) {
        this.qtdGramaComeu = qtdGramaComeu;
    }
    
}
