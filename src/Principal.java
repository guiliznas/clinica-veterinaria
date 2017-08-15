
import control.Utilitarios;
import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.ImageIcon;
import view.PrincipalJFrame;

/**
 * Incia o programa
 *
 * @author(name= Guilherme de Liz do Nascimento, date= 07-23-2017)
 */
public class Principal {

    public static void main(String[] args) {
        /*       EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               Utilitarios.ICONE = new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage();
               Utilitarios.WALLPAPER = new ImageIcon(getClass().getResource("/imagens/wallpaper.jpg"));
               Utilitarios.ICON_ADD = new ImageIcon(getClass().getResource("/imagens/add.png"));
               Utilitarios.ICON_CANCEL = new ImageIcon(getClass().getResource("/imagens/cancel.png"));
               Utilitarios.ICON_PENCIL = new ImageIcon(getClass().getResource("/imagens/pencil.png"));
               Utilitarios.ICON_SAVE = new ImageIcon(getClass().getResource("/imagens/save.png"));
               Utilitarios.ICON_TRASH = new ImageIcon(getClass().getResource("/imagens/trash.png"));
               Utilitarios.ICON_DOG = new ImageIcon(getClass().getResource("/imagens/dog.png"));
               Utilitarios.ICON_CAT = new ImageIcon(getClass().getResource("/imagens/cat.png"));
               Utilitarios.ICON_CAPIVARA = new ImageIcon(getClass().getResource("/imagens/capivara.png"));
               Utilitarios.ICON_SAVE_HOVER = new ImageIcon(getClass().getResource("/imagens/save_hover.png"));
               Utilitarios.ICON_PENCIL_HOVER = new ImageIcon(getClass().getResource("/imagens/pencil_hover.png"));
               Utilitarios.ICON_CANCEL_HOVER = new ImageIcon(getClass().getResource("/imagens/cancel_hover.png"));
               
               PrincipalJFrame principalJFrame = new PrincipalJFrame();
               
           }
       });*/
        System.out.println(" Idade ");
        Scanner teclado = new Scanner(System.in);
        byte idade = Byte.parseByte(teclado.nextLine());
        System.out.println("");

        System.out.println("Informe Salário ");
        double salario = Double.parseDouble(teclado.nextLine());
        System.out.println("");

        System.out.println("Estado Civil ");
        short estadocivil = Short.parseShort(teclado.nextLine());
        System.out.println("");

        System.out.println("Caso nenhum ignore");
        String equalsIgnoreCase = String.parseString(teclado.nextLine());
        System.out.println("");

        if ((idade < 16) && (salario < 250.00) && (!estadocivil.equalsIgnoreCase("solteiro "))) {
            System.out.println("DESCONTO DE 75%");
        } else if ((idade < 23) && (salario < 463.21) && (!estadocivil.equalsIgnoreCase("casado "))) {
            System.out.println("DESCONTO DE 43%");
        } else if ((idade < 37) && (salario < 1400.00) && (!estadocivil.equalsIgnoreCase("viúvo "))) {
            System.out.println("DESCONTO DE 20%");
        } else if ((idade < 60) && (salario < 2300.00) && (!estadocivil.equalsIgnoreCase("União Estável"))) {
            System.out.println("DESCONTO DE 15%");
        } else if ((idade > 60) && (salario > 0) && (!estadocivil.equalsIgnoreCase("casado"))) {
            System.out.println("DESCONTO DE 39%");
        } else {
            System.out.println("Caso nem uma das opções não havera desconto!");
        }
    }
}
