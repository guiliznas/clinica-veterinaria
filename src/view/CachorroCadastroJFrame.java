package view;

import control.Strings;
import control.Utilitarios;
import interfaces.AcaoInterface;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.Cachorro;

/**
 * Permite cadastro e alteração de cachorros
 *
 * @author (name=Guilherme de Liz, date=07-17-2017)
 */
public class CachorroCadastroJFrame extends JFrame implements AcaoInterface {

    //Auxiliar para a edição de um objeto
    private int posicao = -1;
    
    //Componentes da tela
    private JTextField jTextFieldNome, jTextFieldTamanho;
    private JFormattedTextField jFormattedTextFieldPeso;
    private JRadioButton jRadioButtonFemea, jRadioButtonMacho, jRadioButtonVivo,
            jRadioButtonMorto;
    private JComboBox jComboBoxRaca;
    private JButton jButtonCadastrar, jButtonAlterar, jButtonCancelar;
    private ButtonGroup btSexo, btEstadoAtual;
    private JPanel panel;

    /**
     * Construtor que define os componentes na tela.
     */
    public CachorroCadastroJFrame() {
        createWindow();
        createComponents();
        createBoundsOfComponents();
        defineOnClick();
        putComponentsOnWindow();
        jButtonAlterar.setVisible(false);
        jButtonCadastrar.setVisible(true);
    }

    /**
     * Construtor que além de definir os componentes na tela, preenche os campos,
     * para o usuário editar as informações de um objeto.
     * 
     * @param posicao 
     */
    public CachorroCadastroJFrame(int posicao) {
        this();
        this.posicao = posicao;
        setTitle("Save the Capivara - Cachorro - Alterar");
        Cachorro c = PrincipalJFrame.cachorros.get(posicao);
        jTextFieldNome.setText(c.getNome());
        jComboBoxRaca.setSelectedItem(c.getRaca());
        jTextFieldTamanho.setText(String.valueOf(c.getTamanho()));

        jFormattedTextFieldPeso.setText(Utilitarios.retornaTextoAdicionandoMascara(c.getPeso()));

        if (c.isVivo()) {
            jRadioButtonVivo.setSelected(true);
        } else {
            jRadioButtonMorto.setSelected(true);
        }
        if (c.getSexo() == 'F') {
            jRadioButtonFemea.setSelected(true);
        } else {
            jRadioButtonMacho.setSelected(true);
        }
        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(true);

    }

    /**
     * Criar a janela para o usuario ter interacao
     */
    private void createWindow() {
        //Definindo como em tela cheia
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension d = toolkit.getScreenSize();
        setSize(d);

        //Definições padrões
        setLayout(null);
        setTitle("Save the Capivara - Cachorro - Cadastro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setIconImage(Utilitarios.ICONE);

        setContentPane(new JLabel(Utilitarios.WALLPAPER));

        setVisible(true);
    }

    /**
     * Criar a instancia dos componentes para interacao
     */
    private void createComponents() {
        jTextFieldNome = new JTextField();
        jTextFieldTamanho = new JTextField();

        jButtonAlterar = new JButton(Utilitarios.ICON_PENCIL);
        jButtonCadastrar = new JButton(Utilitarios.ICON_SAVE);
        jButtonCancelar = new JButton(Utilitarios.ICON_CANCEL);

        defineTransparencyToButton(jButtonCadastrar);
        defineTransparencyToButton(jButtonAlterar);
        defineTransparencyToButton(jButtonCancelar);

        jRadioButtonFemea = new JRadioButton("Femea");
        jRadioButtonMacho = new JRadioButton("Macho");
        jRadioButtonVivo = new JRadioButton("Vivo");
        jRadioButtonMorto = new JRadioButton("Morto");

        jRadioButtonFemea.setOpaque(false);
        jRadioButtonMorto.setOpaque(false);
        jRadioButtonVivo.setOpaque(false);
        jRadioButtonMacho.setOpaque(false);

        try {
            MaskFormatter mascara = new MaskFormatter("##,## Kg");
            jFormattedTextFieldPeso = new JFormattedTextField(mascara);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }

        validateDoubleSelectionJRadioButton();

        jComboBoxRaca = new JComboBox();
        popularJComboBoxRaca();

        panel = new JPanel(null);
    }

    /**
     * Cria a acao de alguns componentes
     */
    private void defineOnClick() {
        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoCadastrar();
            }
        });
        jButtonAlterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoAlterar();
            }
        });
        jButtonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoCancelar();
            }
        });

        jButtonCadastrar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButtonCadastrar.setIcon(Utilitarios.ICON_SAVE_HOVER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButtonCadastrar.setIcon(Utilitarios.ICON_SAVE);
            }
        });
        jButtonAlterar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButtonAlterar.setIcon(Utilitarios.ICON_PENCIL_HOVER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButtonAlterar.setIcon(Utilitarios.ICON_PENCIL);
            }
        });
        jButtonCancelar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButtonCancelar.setIcon(Utilitarios.ICON_CANCEL_HOVER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButtonCancelar.setIcon(Utilitarios.ICON_CANCEL);
            }
        });
    }

    /**
     * Adiciona os componentes na tela
     */
    private void putComponentsOnWindow() {
        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(false);

        panel.add(jTextFieldNome);
        panel.add(jTextFieldTamanho);

        panel.add(jRadioButtonFemea);
        panel.add(jRadioButtonMacho);
        panel.add(jRadioButtonVivo);
        panel.add(jRadioButtonMorto);

        panel.add(jButtonCadastrar);
        panel.add(jButtonAlterar);
        panel.add(jButtonCancelar);

        panel.add(jComboBoxRaca);

        panel.add(jFormattedTextFieldPeso);

        add(panel);
    }

    /**
     * Define posicao/tamanho dos componentes
     */
    private void createBoundsOfComponents() {
        panel.setBounds((this.getWidth() / 2) - 95, (this.getHeight() / 2) - 200, 200, 400);
        panel.setOpaque(false);

        createJLabelToUser("Nome", 10, 10, 100, 20);
        jTextFieldNome.setBounds(10, 33, 180, 25);
        Utilitarios.definirCorPadrao(jTextFieldNome);

        createJLabelToUser("Tamanho (cm)", 10, 60, 150, 22);
        jTextFieldTamanho.setBounds(10, 85, 180, 25);
        Utilitarios.definirCorPadrao(jTextFieldTamanho);

        createJLabelToUser("Raca", 10, 112, 100, 22);
        jComboBoxRaca.setBounds(10, 134, 180, 25);
        Utilitarios.definirCorPadrao(jComboBoxRaca);

        createJLabelToUser("Sexo", 10, 161, 60, 20);
        jRadioButtonFemea.setBounds(10, 181, 100, 25);
        Utilitarios.definirCorPadrao(jRadioButtonFemea);
        jRadioButtonMacho.setBounds(110, 181, 100, 25);
        Utilitarios.definirCorPadrao(jRadioButtonMacho);

        createJLabelToUser("Estado Atual", 10, 208, 120, 20);
        jRadioButtonVivo.setBounds(10, 230, 100, 25);
        Utilitarios.definirCorPadrao(jRadioButtonVivo);

        jRadioButtonMorto.setBounds(110, 230, 100, 25);
        Utilitarios.definirCorPadrao(jRadioButtonMorto);

        createJLabelToUser("Peso", 10, 257, 140, 20);
        jFormattedTextFieldPeso.setBounds(10, 280, 100, 25);
        Utilitarios.definirCorPadrao(jFormattedTextFieldPeso);

        jButtonCancelar.setBounds((panel.getWidth() - 47), 320, 40, 40);
        jButtonCadastrar.setBounds((panel.getWidth() - 88), 320, 40, 40);
        jButtonAlterar.setBounds((panel.getWidth() - 88), 320, 40, 40);
    }

    /**
     * Metodo para criar os JLabels
     *
     * @param texto
     * @param x
     * @param y
     * @param width
     * @param height
     */
    private void createJLabelToUser(String texto, int x, int y, int width, int height) {
        JLabel jLabel = new JLabel(texto);
        jLabel.setBounds(x, y, width, height);
        Utilitarios.definirCorPadrao(jLabel);
        panel.add(jLabel);
    }

    /**
     * Permite que apenas um JRadioButton seja selecionado por vez
     */
    private void validateDoubleSelectionJRadioButton() {
        btSexo = new ButtonGroup();
        btSexo.add(jRadioButtonFemea);
        btSexo.add(jRadioButtonMacho);

        btEstadoAtual = new ButtonGroup();
        btEstadoAtual.add(jRadioButtonVivo);
        btEstadoAtual.add(jRadioButtonMorto);
    }

    /**
     * Definir opcoes do combo box das racas
     */
    private void popularJComboBoxRaca() {
        String[] racas = {"Pinscher", "RND", "Boxer", "Pastor Alemao", "Doberman",
            "Shih-Tzu", "Pug", "Dalmata", "Labrador"};
        Arrays.sort(racas);
        jComboBoxRaca.setModel(new DefaultComboBoxModel(racas));
        jComboBoxRaca.setSelectedIndex(-1);
    }

    /**
     * Definir a transparencia do componente passado como parametro
     *
     * @param jButton
     */
    private void defineTransparencyToButton(JButton jButton) {
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
    }

    /**
     * Permite que o usuario faca o cadastro de um objeto
     */
    @Override
    public void acaoCadastrar() {
        if (jTextFieldNome.getText().equals("")) {
            Utilitarios.showMessage(Strings.NOME_NAO_PODE_SER_VAZIO, Utilitarios.ICON_ADD);
            return;
        }

        // Obtem os dados dos campos, adaptando as mascaras
        Cachorro c = new Cachorro(
                jTextFieldNome.getText(),
                jComboBoxRaca.getSelectedItem().toString(),
                Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso),
                (jRadioButtonFemea.isSelected() ? 'F' : 'M'),
                jRadioButtonVivo.isSelected(),
                Integer.parseInt(jTextFieldTamanho.getText())
        );
        PrincipalJFrame.cachorros.add(c);
        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(true);
        Utilitarios.showMessage(Strings.CACHORRO_CADASTRADO_COM_SUCESSO, Utilitarios.ICON_ADD);
        this.dispose();
    }

    /**
     * Permite a alteração de um objeto
     */
    @Override
    public void acaoAlterar() {
        Cachorro c = new Cachorro();
        c.setNome(jTextFieldNome.getText());
        c.setRaca(jComboBoxRaca.getSelectedItem().toString());
        c.setSexo(jRadioButtonFemea.isSelected() ? 'F' : 'M');
        c.setVivo(!jRadioButtonMorto.isSelected());
        int tam = Integer.parseInt(jTextFieldTamanho.getText());
        c.setTamanho(tam);
        c.setPeso(Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso));

        PrincipalJFrame.cachorros.set(posicao, c);
        Utilitarios.showMessage("Cachorro " + c.getNome() + " alterado c sucesso!", Utilitarios.ICON_PENCIL);
    }

    /**
     * Permite que o usuario desista da ação atual
     */
    @Override
    public void acaoCancelar() {
        this.dispose();
    }

}