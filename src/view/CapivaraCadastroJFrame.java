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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.text.MaskFormatter;
import model.Capivara;

/**
 * Tela para o cadastro ou alteração de capivaras
 *
 * @author(name= Guilherme de Liz do Nascimento, date= 07-23-2017)
 */
public class CapivaraCadastroJFrame extends JFrame implements AcaoInterface {

    //Auxiliar para a interação com o usuario
    private int posicao = -1;

    //Cria componentes da tela
    private JButton jButtonCadastrar, jButtonAlterar, jButtonCancelar;
    private JPanel panelLeft, panelRight;
    private JSpinner jSpinnerQtdSelfiesParticipadas, jSpinnerQtdFilhote,
            jSpinnerQtdDentes, jSpinnerQtdGramaComeu;
    private JTextField jTextFieldAltura, jTextFieldNome, jTextFieldNomeCientifico,
            jTextFieldTrechoBeiraRioQueDorme, jTextFieldClassificacaoNatacao,
            jTextFieldRegistroIbama;
    private JFormattedTextField jFormattedTextFieldPeso;
    private JCheckBox jCheckBoxRegistradaIbama;

    /**
     * Construtor que agrupa métodos para a construção da tela
     */
    public CapivaraCadastroJFrame() {
        createWindow();
        createComponents();
        createBoundsOfComponents();
        defineOnClick();
        putComponentsOnWindow();
        jButtonAlterar.setVisible(false);
        jButtonCadastrar.setVisible(true);
    }

    /**
     * Construtor que executa os métodos para a definição da tela e preenche os
     * campos para a alteração dos dados pelo usuário.
     *
     * @param posicao
     */
    public CapivaraCadastroJFrame(int posicao) {
        this();
        this.posicao = posicao;
        setTitle("Save the Capivara - Capivara - Alterar");
        Capivara c = PrincipalJFrame.capivaras.get(posicao);
        jSpinnerQtdSelfiesParticipadas.setValue(c.getQtdSelfiesParticipadas());
        jTextFieldNome.setText(c.getNome());
        jTextFieldNomeCientifico.setText(c.getNomeCientifico());
        jFormattedTextFieldPeso.setText(Utilitarios.retornaTextoAdicionandoMascara(c.getPeso()));
        jTextFieldAltura.setText(String.valueOf(c.getAltura()));
        jSpinnerQtdFilhote.setValue(c.getQtdFilhote());
        jCheckBoxRegistradaIbama.setSelected(c.isRegistradaIbama());
        jTextFieldRegistroIbama.setText(String.valueOf(c.getRegistroIbama()));
        jTextFieldTrechoBeiraRioQueDorme.setText(c.getTrechoBeiraRioQueDorme());
        jSpinnerQtdGramaComeu.setValue(c.getQtdGramaComeu());
        jSpinnerQtdDentes.setValue(c.getQtdGramaComeu());
        jTextFieldClassificacaoNatacao.setText(c.getClassificacaoNatacao());

        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(true);
    }

    /**
     * Criação do JFrame de acordo com os padrões do projeto.
     */
    private void createWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension d = toolkit.getScreenSize();
        setSize(d);

        setLayout(null);
        setTitle("Save the Capivara - Capivara - Cadastro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setIconImage(Utilitarios.ICONE);

        setContentPane(new JLabel(Utilitarios.WALLPAPER));

        setVisible(true);
    }

    /**
     * Instância e definições basicas dos componentes da tela
     */
    private void createComponents() {
        jButtonAlterar = new JButton(Utilitarios.ICON_PENCIL);
        jButtonCadastrar = new JButton(Utilitarios.ICON_SAVE);
        jButtonCancelar = new JButton(Utilitarios.ICON_CANCEL);

        defineTransparencyToButton(jButtonCadastrar);
        defineTransparencyToButton(jButtonAlterar);
        defineTransparencyToButton(jButtonCancelar);

        panelLeft = new JPanel(null);
        panelRight = new JPanel(null);

        try {
            MaskFormatter mascara = new MaskFormatter("##,## Kg");
            jFormattedTextFieldPeso = new JFormattedTextField(mascara);
            Utilitarios.definirCorPadrao(jFormattedTextFieldPeso);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }

        jTextFieldNome = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldNome);
        jTextFieldAltura = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldAltura);
        jTextFieldNomeCientifico = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldNomeCientifico);
        jTextFieldTrechoBeiraRioQueDorme = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldTrechoBeiraRioQueDorme);
        jTextFieldClassificacaoNatacao = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldClassificacaoNatacao);
        jTextFieldRegistroIbama = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldRegistroIbama);

        jSpinnerQtdSelfiesParticipadas = new JSpinner(new SpinnerNumberModel(0, 0, 99999999, 1));
        Utilitarios.definirCorPadrao(jSpinnerQtdSelfiesParticipadas);
        jSpinnerQtdFilhote = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
        Utilitarios.definirCorPadrao(jSpinnerQtdFilhote);
        jSpinnerQtdDentes = new JSpinner(new SpinnerNumberModel(0, 0, 999999, 1));
        Utilitarios.definirCorPadrao(jSpinnerQtdDentes);
        jSpinnerQtdGramaComeu = new JSpinner(new SpinnerNumberModel(0, 0, 999999, 1));
        Utilitarios.definirCorPadrao(jSpinnerQtdGramaComeu);

        jCheckBoxRegistradaIbama = new JCheckBox("Registrado pelo Ibama");
        Utilitarios.definirCorPadrao(jCheckBoxRegistradaIbama);
        jCheckBoxRegistradaIbama.setOpaque(false);
    }

    /**
     * Define as posições dos componentes na tela
     */
    private void createBoundsOfComponents() {
        panelLeft.setBounds((this.getWidth() / 2) - 240, (this.getHeight() / 2) - 300, 240, 600);
        panelRight.setBounds((this.getWidth() / 2), (this.getHeight() / 2) - 300, 240, 600);
        panelLeft.setOpaque(false);
        panelRight.setOpaque(false);

        //Painel Esquerda
        createJLabelToUser("Selfies Participadas", 10, 10, 300, 25, 0);
        jSpinnerQtdSelfiesParticipadas.setBounds(10, 35, 150, 25);

        createJLabelToUser("Nome", 10, 63, 100, 25, 0);
        jTextFieldNome.setBounds(10, 88, 150, 25);

        createJLabelToUser("Nome Cientifico", 10, 115, 200, 25, 0);
        jTextFieldNomeCientifico.setBounds(10, 143, 150, 25);

        createJLabelToUser("Peso", 10, 168, 50, 25, 0);
        jFormattedTextFieldPeso.setBounds(10, 195, 150, 25);

        createJLabelToUser("Altura", 10, 222, 100, 25, 0);
        jTextFieldAltura.setBounds(10, 247, 150, 25);

        createJLabelToUser("Quantidade Filhotes", 10, 275, 200, 25, 0);
        jSpinnerQtdFilhote.setBounds(10, 300, 150, 25);

        jCheckBoxRegistradaIbama.setBounds(10, 327, 300, 25);

        createJLabelToUser("Numero Registro Ibama", 10, 352, 300, 25, 0);
        jTextFieldRegistroIbama.setBounds(10, 377, 150, 25);

        createJLabelToUser("Trecho Beira Rio que Dorme", 10, 402, 300, 25, 0);
        jTextFieldTrechoBeiraRioQueDorme.setBounds(10, 427, 150, 25);

        createJLabelToUser("Gramas que ja Comeu", 10, 455, 300, 25, 0);
        jSpinnerQtdGramaComeu.setBounds(10, 480, 150, 25);

        //Painel Direita
        createJLabelToUser("Quantidade de Dentes", 10, 10, 300, 25, 1);
        jSpinnerQtdDentes.setBounds(10, 35, 150, 25);

        createJLabelToUser("Classificacao da Natacao", 10, 63, 300, 25, 1);
        jTextFieldClassificacaoNatacao.setBounds(10, 88, 150, 25);

        jButtonCancelar.setBounds((panelRight.getWidth() - 47), (panelRight.getHeight() - 42), 40, 40);
        jButtonCadastrar.setBounds((panelRight.getWidth() - 88), (panelRight.getHeight() - 42), 40, 40);
        jButtonAlterar.setBounds((panelRight.getWidth() - 88), (panelRight.getHeight() - 42), 40, 40);
    }

    /**
     * Metodo para criar os JLabels com os padrões de projeto
     *
     * @param texto
     * @param x
     * @param y
     * @param width
     * @param height
     */
    private void createJLabelToUser(String texto, int x, int y, int width,
            int height, int posicao) {
        JLabel jLabel = new JLabel(texto);
        jLabel.setBounds(x, y, width, height);
        Utilitarios.definirCorPadrao(jLabel);
        switch (posicao) {
            case 0:
                panelLeft.add(jLabel);
                break;
            case 1:
                panelRight.add(jLabel);
                break;
        }
    }

    /**
     * Define as ações dos botoes.
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
     * Adiciona os componentes na tela.
     */
    private void putComponentsOnWindow() {
        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(false);

        panelRight.add(jButtonAlterar);
        panelRight.add(jButtonCadastrar);
        panelRight.add(jButtonCancelar);

        panelLeft.add(jSpinnerQtdSelfiesParticipadas);
        panelLeft.add(jTextFieldNome);
        panelLeft.add(jTextFieldNomeCientifico);
        panelLeft.add(jFormattedTextFieldPeso);
        panelLeft.add(jTextFieldAltura);
        panelLeft.add(jSpinnerQtdFilhote);
        panelLeft.add(jCheckBoxRegistradaIbama);
        panelLeft.add(jTextFieldRegistroIbama);
        panelLeft.add(jTextFieldTrechoBeiraRioQueDorme);
        panelLeft.add(jSpinnerQtdGramaComeu);

        panelRight.add(jSpinnerQtdDentes);
        panelRight.add(jTextFieldClassificacaoNatacao);

        add(panelLeft);
        add(panelRight);
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
     * Permite o cadastro de um registro
     */
    @Override
    public void acaoCadastrar() {
        if (jTextFieldNome.getText().trim().equals("")) {
            Utilitarios.showMessage(Strings.NOME_NAO_PODE_SER_VAZIO, Utilitarios.ICON_ADD);
            return;
        }
        Capivara c = new Capivara(
                (Integer) jSpinnerQtdSelfiesParticipadas.getValue(),
                Integer.parseInt(jTextFieldAltura.getText()),
                (Integer) jSpinnerQtdFilhote.getValue(),
                (Integer) jSpinnerQtdDentes.getValue(),
                jTextFieldNome.getText(),
                jTextFieldNomeCientifico.getText(),
                jTextFieldTrechoBeiraRioQueDorme.getText(),
                jTextFieldClassificacaoNatacao.getText(),
                Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso),
                jCheckBoxRegistradaIbama.isSelected(),
                Long.parseLong(jTextFieldRegistroIbama.getText()),
                (Integer) jSpinnerQtdGramaComeu.getValue()
        );
        PrincipalJFrame.capivaras.add(c);
        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(true);
        Utilitarios.showMessage(Strings.CAPIVARA_CADASTRADO_COM_SUCESSO, Utilitarios.ICON_ADD);
        this.dispose();
    }

    /**
     * Permite a alteração de um registro
     */
    @Override
    public void acaoAlterar() {
        Capivara c = new Capivara(
                (Integer) jSpinnerQtdSelfiesParticipadas.getValue(),
                Integer.parseInt(jTextFieldAltura.getText()),
                (Integer) jSpinnerQtdFilhote.getValue(),
                (Integer) jSpinnerQtdDentes.getValue(),
                jTextFieldNome.getText(),
                jTextFieldNomeCientifico.getText(),
                jTextFieldTrechoBeiraRioQueDorme.getText(),
                jTextFieldClassificacaoNatacao.getText(),
                Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso),
                jCheckBoxRegistradaIbama.isSelected(),
                Long.parseLong(jTextFieldRegistroIbama.getText()),
                (Integer) jSpinnerQtdGramaComeu.getValue()
        );
        PrincipalJFrame.capivaras.set(posicao, c);
        Utilitarios.showMessage("Capivara " + c.getNome() + " alterada c sucesso!", Utilitarios.ICON_PENCIL);
    }

    /**
     * Permite que o usuário desista da ação atual
     */
    @Override
    public void acaoCancelar() {
        this.dispose();
    }

}
