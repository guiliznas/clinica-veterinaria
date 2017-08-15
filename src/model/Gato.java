package model;

/**
 *
 * @author(name= Guilherme de Liz do Nascimento, date= 07-21-2017)
 */
public class Gato {
    //Atributos
    private int qtdVidas, comprimento, altura, idade, qtdFiosPelo, qtdCirurgia, qtdFilhotes;
    private String corPataTraseiraDireita, corPataTraseiraEsquerda, corPataFrontalDireita,
            corPataFrontalEsquerda, corOlhoDireito, corOlhoEsquerdo, corPelo;
    private String nome, raca, nivelPreguica, marcaRacao, nomeDono;
    private float peso;
    private char sexo;
    private boolean fazTosa, fezCirurgia, pedigree, teveFilhote, castrado;

    /**
     * Construtor com todos os atributos da classe
     * 
     * @param qtdVidas
     * @param comprimento
     * @param altura
     * @param idade
     * @param qtdFiosPelo
     * @param qtdCirurgia
     * @param qtdFilhotes
     * @param corPataTraseiraDireita
     * @param corPataTraseiraEsquerda
     * @param corPataFrontalDireita
     * @param corPataFrontalEsquerda
     * @param corOlhoDireito
     * @param corOlhoEsquerdo
     * @param corPelo
     * @param nome
     * @param raca
     * @param nivelPreguica
     * @param marcaRacao
     * @param nomeDono
     * @param peso
     * @param sexo
     * @param fazTosa
     * @param fezCirurgia
     * @param pedigree
     * @param teveFilhote
     * @param castrado 
     */
    public Gato(int qtdVidas, int comprimento, int altura, int idade, int qtdFiosPelo, int qtdCirurgia, int qtdFilhotes, String corPataTraseiraDireita, String corPataTraseiraEsquerda, String corPataFrontalDireita, String corPataFrontalEsquerda, String corOlhoDireito, String corOlhoEsquerdo, String corPelo, String nome, String raca, String nivelPreguica, String marcaRacao, String nomeDono, float peso, char sexo, boolean fazTosa, boolean fezCirurgia, boolean pedigree, boolean teveFilhote, boolean castrado) {
        this.qtdVidas = qtdVidas;
        this.comprimento = comprimento;
        this.altura = altura;
        this.idade = idade;
        this.qtdFiosPelo = qtdFiosPelo;
        this.qtdCirurgia = qtdCirurgia;
        this.qtdFilhotes = qtdFilhotes;
        this.corPataTraseiraDireita = corPataTraseiraDireita;
        this.corPataTraseiraEsquerda = corPataTraseiraEsquerda;
        this.corPataFrontalDireita = corPataFrontalDireita;
        this.corPataFrontalEsquerda = corPataFrontalEsquerda;
        this.corOlhoDireito = corOlhoDireito;
        this.corOlhoEsquerdo = corOlhoEsquerdo;
        this.corPelo = corPelo;
        this.nome = nome;
        this.raca = raca;
        this.nivelPreguica = nivelPreguica;
        this.marcaRacao = marcaRacao;
        this.nomeDono = nomeDono;
        this.peso = peso;
        this.sexo = sexo;
        this.fazTosa = fazTosa;
        this.fezCirurgia = fezCirurgia;
        this.pedigree = pedigree;
        this.teveFilhote = teveFilhote;
        this.castrado = castrado;
    }

    /**
     * Construtor vazio
     */
    public Gato() {
    }

    public int getQtdVidas() {
        return qtdVidas;
    }

    public void setQtdVidas(int qtdVidas) {
        this.qtdVidas = qtdVidas;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQtdFiosPelo() {
        return qtdFiosPelo;
    }

    public void setQtdFiosPelo(int qtdFiosPelo) {
        this.qtdFiosPelo = qtdFiosPelo;
    }

    public int getQtdCirurgia() {
        return qtdCirurgia;
    }

    public void setQtdCirurgia(int qtdCirurgia) {
        this.qtdCirurgia = qtdCirurgia;
    }

    public int getQtdFilhotes() {
        return qtdFilhotes;
    }

    public void setQtdFilhotes(int qtdFilhotes) {
        this.qtdFilhotes = qtdFilhotes;
    }

    public String getCorPataTraseiraDireita() {
        return corPataTraseiraDireita;
    }

    public void setCorPataTraseiraDireita(String corPataTraseiraDireita) {
        this.corPataTraseiraDireita = corPataTraseiraDireita;
    }

    public String getCorPataTraseiraEsquerda() {
        return corPataTraseiraEsquerda;
    }

    public void setCorPataTraseiraEsquerda(String corPataTraseiraEsquerda) {
        this.corPataTraseiraEsquerda = corPataTraseiraEsquerda;
    }

    public String getCorPataFrontalDireita() {
        return corPataFrontalDireita;
    }

    public void setCorPataFrontalDireita(String corPataFrontalDireita) {
        this.corPataFrontalDireita = corPataFrontalDireita;
    }

    public String getCorPataFrontalEsquerda() {
        return corPataFrontalEsquerda;
    }

    public void setCorPataFrontalEsquerda(String corPataFrontalEsquerda) {
        this.corPataFrontalEsquerda = corPataFrontalEsquerda;
    }

    public String getCorOlhoDireito() {
        return corOlhoDireito;
    }

    public void setCorOlhoDireito(String corOlhoDireito) {
        this.corOlhoDireito = corOlhoDireito;
    }

    public String getCorOlhoEsquerdo() {
        return corOlhoEsquerdo;
    }

    public void setCorOlhoEsquerdo(String corOlhoEsquerdo) {
        this.corOlhoEsquerdo = corOlhoEsquerdo;
    }

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNivelPreguica() {
        return nivelPreguica;
    }

    public void setNivelPreguica(String nivelPreguica) {
        this.nivelPreguica = nivelPreguica;
    }

    public String getMarcaRacao() {
        return marcaRacao;
    }

    public void setMarcaRacao(String marcaRacao) {
        this.marcaRacao = marcaRacao;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isFazTosa() {
        return fazTosa;
    }

    public void setFazTosa(boolean fazTosa) {
        this.fazTosa = fazTosa;
    }

    public boolean isFezCirurgia() {
        return fezCirurgia;
    }

    public void setFezCirurgia(boolean fezCirurgia) {
        this.fezCirurgia = fezCirurgia;
    }

    public boolean isPedigree() {
        return pedigree;
    }

    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }

    public boolean isTeveFilhote() {
        return teveFilhote;
    }

    public void setTeveFilhote(boolean teveFilhote) {
        this.teveFilhote = teveFilhote;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
    
}
