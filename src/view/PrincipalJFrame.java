package view;

import control.Utilitarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import model.*;

/**
 * Tela inicial que permite o usuário selecionar com qual animal pretende
 * trabalhar.
 *
 * @author(name= Guilherme de Liz do Nascimento, date= 07-23-2017)
 */
public class PrincipalJFrame extends JFrame {

    //Criação dos componentes
    private JButton listaCachorro, listaGato, listaCapivara;
    public static ArrayList<Cachorro> cachorros;
    public static ArrayList<Gato> gatos;
    public static ArrayList<Capivara> capivaras;

    /**
     * Construtor que reune os métodos para a criação da tela e as instâncias
     * basicas.
     */
    public PrincipalJFrame() {
        cachorros = new ArrayList<>();
        gatos = new ArrayList<>();
        capivaras = new ArrayList<>();
        definirComoSeraATela();
        criarBotoes();
        popularListaCachorro();
        popularListaGato();
        popularListaCapivara();
        setResizable(false);
        setVisible(true);
    }

    /**
     * Define as caracteristicas da tela de acordo com os padrões do projeto
     */
    public void definirComoSeraATela() {
        setIconImage(Utilitarios.ICONE);
        setContentPane(new JLabel(Utilitarios.WALLPAPER));
        setTitle("Save the Capivara");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Cria os botoes para a interação com o usuário.
     */
    private void criarBotoes() {
        listaCachorro = new JButton("Lista de Cachorros", Utilitarios.ICON_DOG);
        Utilitarios.definirCorPadrao(listaCachorro);
        listaCachorro.setBounds(95, 10, 300, 100);
        listaCachorro.setVerticalAlignment(SwingConstants.TOP);
        listaCachorro.setVerticalTextPosition(SwingConstants.BOTTOM);
        listaCachorro.setHorizontalTextPosition(SwingConstants.CENTER);
        listaCachorro.setIconTextGap(10);
        listaCachorro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CachorroListaJFrame cachorroListaJFrame = new CachorroListaJFrame();

            }
        });
        listaCachorro.setFocusPainted(false);
        add(listaCachorro);

        listaGato = new JButton("Lista de Gatos", Utilitarios.ICON_CAT);
        Utilitarios.definirCorPadrao(listaGato);
        listaGato.setBounds(95, 120, 300, 100);
        listaGato.setVerticalAlignment(SwingConstants.TOP);
        listaGato.setVerticalTextPosition(SwingConstants.BOTTOM);
        listaGato.setHorizontalTextPosition(SwingConstants.CENTER);
        listaGato.setIconTextGap(10);
        listaGato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GatoListaJFrame gatoListaJFrame = new GatoListaJFrame();
            }
        });
        listaGato.setFocusPainted(false);
        add(listaGato);

        listaCapivara = new JButton("Lista de Capivaras", Utilitarios.ICON_CAPIVARA);
        Utilitarios.definirCorPadrao(listaCapivara);
        listaCapivara.setBounds(95, 230, 300, 100);
        listaCapivara.setVerticalAlignment(SwingConstants.TOP);
        listaCapivara.setVerticalTextPosition(SwingConstants.BOTTOM);
        listaCapivara.setHorizontalTextPosition(SwingConstants.CENTER);
        listaCapivara.setIconTextGap(10);
        listaCapivara.setFocusPainted(false);
        listaCapivara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CapivaraListaJFrame capivaraListaJFrame = new CapivaraListaJFrame();
            }
        });
        add(listaCapivara);
    }

    /**
     * Adiciona registros padrões de cachorros
     */
    private void popularListaCachorro() {
        Cachorro cachorro = new Cachorro();
        cachorro.setNome("Cachos alaranjados");
        cachorro.setRaca("Pug");
        cachorro.setPeso(6.00f);
        cachorro.setSexo('M');
        cachorro.setVivo(false);
        cachorro.setTamanho(15);
        cachorros.add(cachorro);

        Cachorro dog = new Cachorro("Late nao morde", "Pinscher", 2.5f, 'F', false, 20);
        cachorros.add(dog);

        Cachorro labrador = new Cachorro("Marley", "Labrador", 30f, 'M', true, 100);
        cachorros.add(labrador);
    }

    /**
     * Adiciona registros padrões de gatos
     */
    private void popularListaGato() {
        Gato g = new Gato(7, 30, 50, 3, 2550, 3, 2, "Rosa", "Rosa", "Rosa", "Rosa", "Azul", "Castanho", "Branco", "Fred", "Desconhecido", "Pouco", "Fon", "Jose", 3.5f, 'C', true, true, true, true, true);
        gatos.add(g);

        Gato g2 = new Gato(7, 30, 50, 3, 2550, 3, 2, "Rosa", "Rosa", "Rosa", "Rosa", "Azul", "Castanho", "Branco", "Fred", "Desconhecido", "Pouco", "Fon", "Jose", 3.5f, 'C', true, true, true, true, true);
        g2.setPedigree(false);
        g2.setNomeDono("Marco");
        g2.setNome("Mimo");
        g2.setCorOlhoDireito("Vermelho");
        g2.setCorOlhoEsquerdo("Red");
        gatos.add(g2);
    }

    /**
     * Adiciona registros padrões de capivaras
     */
    private void popularListaCapivara() {
        Capivara c = new Capivara(150, 50, 3, 500, "Mariane", "Capivarus Locus", "Logo ali", "Muito boa", 15.2f, true, 169831792, 1002592);
        capivaras.add(c);
        
        Capivara c2 = new Capivara(150, 50, 3, 500, "Mariane", "Capivarus Locus", "Logo ali", "Muito boa", 15.2f, true, 169831792, 1002592);
        c2.setNome("Claudio");
        c2.setPeso(25.45f);
        c2.setAltura(70);
        c2.setClassificacaoNatacao("Oq eh nadar?");
        capivaras.add(c2);
    }

}
