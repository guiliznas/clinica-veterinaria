
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
        EventQueue.invokeLater(new Runnable() {
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
        });

    }
}
