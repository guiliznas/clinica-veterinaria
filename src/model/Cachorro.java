
package model;

/**
 * 
 * @author(name= Guilherme de Liz do Nascimento, date= 07-23-2017)
 */
public class Cachorro {
    //atributos -> caracteristicas
    private String nome, raca;
    private float peso;
    private char sexo;
    private boolean vivo;
    private int tamanho;

    /**
     * Construtor com todos os atributos da classe
     * 
     * @param nome
     * @param raca
     * @param peso
     * @param sexo
     * @param vivo
     * @param tamanho 
     */
    public Cachorro(String nome, String raca, float peso, char sexo, boolean vivo, int tamanho) {
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.sexo = sexo;
        this.vivo = vivo;
        this.tamanho = tamanho;
    }

    /**
     * Construtor vazio
     */
    public Cachorro() {
    }
   
    //metodos que permitem acessar os atributos private
    public String getNome() {
        return nome;
    }

    public float getPeso() {
        return peso;
    }

    public boolean isVivo() {
        return vivo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public char getSexo() {
        return sexo;
    }

    public String getRaca() {
        return raca;
    }

    //Metodos para alterar atributos private
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
}
