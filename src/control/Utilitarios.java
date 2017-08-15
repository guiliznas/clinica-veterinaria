package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Classe utilizada para centralizar recursos utilizados em todo o projeto,
 * como icones, fontes, cores e métodos de conversão.
 * 
 * @author(name= Guilherme de Liz do Nascimento, date= 07-23-2017)
 */
public class Utilitarios {

    //Criação das variaveis de icones
    public static Image ICONE;
    public static ImageIcon WALLPAPER, ICON_ADD, ICON_CANCEL, ICON_PENCIL,
            ICON_SAVE, ICON_TRASH, ICON_DOG, ICON_CAT, ICON_CAPIVARA, 
            ICON_CANCEL_HOVER, ICON_SAVE_HOVER, ICON_PENCIL_HOVER;
    
    //Padronização de cor e fonte
    public static final Font MY_FONT = new Font("Century Gothic", 1, 16);
    public static final Color MY_FONT_COLOR = Color.decode("#212121");
    
    /**
     * Remove a mascara do campo de peso
     *
     * @param campo
     *
     * @return valor do campo do peso sem mascara
     */
    public static float retornarValorDoPesoSemMascara(JFormattedTextField campo) {
        String pesoString = campo.getText();
        pesoString = pesoString.replace(" Kg", "");
        pesoString = pesoString.replace(",", ".");
        return Float.parseFloat(pesoString);
    }

    /**
     * Adiciona a mascarao ao valor
     * 
     * @param valor
     * 
     * @return peso com mascara
     */
    public static String retornaTextoAdicionandoMascara(float valor) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        String texto = numberFormat.format(valor);
        if (valor < 10) {
            texto = "0" + texto;
        }
        texto += " Kg";
        return texto;
    }
    
    /**
     * Define a fonte e a cor do texto de um componente de acordo com os padrões
     * do projeto.
     * 
     * @param c
     */
    public static void definirCorPadrao(Component c){
        c.setFont(Utilitarios.MY_FONT);
        c.setForeground(Utilitarios.MY_FONT_COLOR);
    }
    
    /**
     * Mostra uma mensagem com um JOptionPane, utilizando o design padrão do
     * projeto.
     * 
     * @param txt
     * @param icon 
     */
    public static void showMessage(String txt, ImageIcon icon){
        JLabel jLabel = new JLabel(txt);
        definirCorPadrao(jLabel);
        JOptionPane.showMessageDialog(null, jLabel, "Aviso", JOptionPane.WARNING_MESSAGE, icon);
    }
}
