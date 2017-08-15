package interfaces;

/**
 * Interface para padronizar os métodos de ação das telas de cadastro.
 * 
 * @author(name= Guilherme de Liz do Nascimento, date= 07-23-2017)
 */
public interface AcaoInterface {
    //Ação excutada quando o botão de cadastro é selecionado
    public void acaoCadastrar();
    //Ação excutada quando o botão de alteração é selecionado
    public void acaoAlterar();
    //Ação excutada quando o botão de cancelar é selecionado
    public void acaoCancelar();
}
