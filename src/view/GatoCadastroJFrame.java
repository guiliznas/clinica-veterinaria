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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;
import model.Gato;

/**
 * Tela para o cadastro ou alteração de gatos
 *
 * @author(name= Guilherme de Liz, date= 07-22-2017)
 */
public class GatoCadastroJFrame extends JFrame implements AcaoInterface {

    //Auxiliar para a interação com o usuario
    private int posicao = -1;

    //Cria componentes da tela
    private JButton jButtonCadastrar, jButtonAlterar, jButtonCancelar;
    private JPanel panelLeft, panelRight, panelCenter;
    private JTextField jTextFieldNome, jTextFieldNomeDono, jTextFieldOlhoDireito,
            jTextFieldOlhoEsquerdo;
    private JTextField jTextFieldCorPataTraseiraEsquerda, jTextFieldCorPataTraseiraDireita,
            jTextFieldCorPataFrontalEsquerda, jTextFieldCorPataFrontalDireita;
    private JTextField jTextFieldCorOlhoEsquerdo, jTextFieldCorOlhoDireito;
    private JTextField jTextFieldComprimento, jTextFieldAltura, jTextFieldRaca,
            jTextFieldNivelPreguica, jTextFieldCorPelo, jTextFieldMarcaRacao,
            jTextFieldIdade;
    private JFormattedTextField jFormattedTextFieldPeso;
    private JCheckBox jCheckBoxPedigree, jCheckBoxFazTosa, jCheckBoxFezCirurgia,
            jCheckBoxTeveFilhote, jCheckBoxCastrado;
    private JSpinner jSpinnerQtdVidas, jSpinnerQtdFiosPelo, jSpinnerQtdCirurgias,
            jSpinnerQtdFilhotes;
    private JRadioButton jRadioFemea, jRadioMacho;
    private ButtonGroup btSexo;

    /**
     * Construtor que agrupa métodos para a construção da tela
     */
    public GatoCadastroJFrame() {
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
    public GatoCadastroJFrame(int posicao) {
        this();
        this.posicao = posicao;
        setTitle("Save the Capivara - Gato - Alterar");
        Gato g = PrincipalJFrame.gatos.get(posicao);
        jSpinnerQtdVidas.setValue(g.getQtdVidas());
        jTextFieldComprimento.setText(String.valueOf(g.getComprimento()));
        jTextFieldAltura.setText(String.valueOf(g.getAltura()));
        jTextFieldIdade.setText(String.valueOf(g.getIdade()));
        jSpinnerQtdFiosPelo.setValue(g.getQtdFiosPelo());
        jSpinnerQtdCirurgias.setValue(g.getQtdCirurgia());
        jSpinnerQtdFilhotes.setValue(g.getQtdFilhotes());
        jTextFieldCorPataTraseiraDireita.setText(g.getCorPataTraseiraDireita());
        jTextFieldCorPataTraseiraEsquerda.setText(g.getCorPataTraseiraEsquerda());
        jTextFieldCorPataFrontalDireita.setText(g.getCorPataFrontalDireita());
        jTextFieldCorPataFrontalEsquerda.setText(g.getCorPataFrontalEsquerda());
        jTextFieldCorOlhoDireito.setText(g.getCorOlhoDireito());
        jTextFieldCorOlhoEsquerdo.setText(g.getCorOlhoEsquerdo());
        jTextFieldCorPelo.setText(g.getCorPelo());
        jTextFieldNome.setText(g.getNome());
        jTextFieldRaca.setText(g.getRaca());
        jTextFieldNivelPreguica.setText(g.getNivelPreguica());
        jTextFieldMarcaRacao.setText(g.getMarcaRacao());
        jTextFieldNomeDono.setText(g.getNomeDono());
        jFormattedTextFieldPeso.setText(Utilitarios.retornaTextoAdicionandoMascara(g.getPeso()));
        if (g.getSexo() == 'F') {
            jRadioFemea.setSelected(true);
        } else if (g.getSexo() == 'M') {
            jRadioMacho.setSelected(true);
        }
        jCheckBoxFazTosa.setSelected(g.isFazTosa());
        jCheckBoxFezCirurgia.setSelected(g.isFezCirurgia());
        jCheckBoxPedigree.setSelected(g.isPedigree());
        jCheckBoxTeveFilhote.setSelected(g.isTeveFilhote());
        jCheckBoxCastrado.setSelected(g.isCastrado());

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
        setTitle("Save the Capivara - Gato - Cadastro");
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
        panelCenter = new JPanel(null);

        jTextFieldNome = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldNome);
        jTextFieldNomeDono = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldNomeDono);
        jTextFieldOlhoDireito = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldOlhoDireito);
        jTextFieldOlhoEsquerdo = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldOlhoEsquerdo);
        jTextFieldCorPataTraseiraEsquerda = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldCorPataTraseiraEsquerda);
        jTextFieldCorPataTraseiraDireita = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldCorPataTraseiraDireita);
        jTextFieldCorPataFrontalEsquerda = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldCorPataFrontalEsquerda);
        jTextFieldCorPataFrontalDireita = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldCorPataFrontalDireita);
        jTextFieldCorOlhoEsquerdo = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldCorOlhoEsquerdo);
        jTextFieldCorOlhoDireito = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldCorOlhoDireito);
        jTextFieldComprimento = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldComprimento);
        jTextFieldAltura = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldAltura);
        jTextFieldRaca = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldRaca);
        jTextFieldNivelPreguica = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldNivelPreguica);
        jTextFieldCorPelo = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldCorPelo);
        jTextFieldMarcaRacao = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldMarcaRacao);
        jTextFieldIdade = new JTextField();
        Utilitarios.definirCorPadrao(jTextFieldIdade);

        try {
            MaskFormatter mascara = new MaskFormatter("##,## Kg");
            jFormattedTextFieldPeso = new JFormattedTextField(mascara);
            Utilitarios.definirCorPadrao(jFormattedTextFieldPeso);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }

        jCheckBoxPedigree = new JCheckBox("Pedigree");
        Utilitarios.definirCorPadrao(jCheckBoxPedigree);
        jCheckBoxPedigree.setOpaque(false);
        jCheckBoxFazTosa = new JCheckBox("Faz Tosa");
        Utilitarios.definirCorPadrao(jCheckBoxFazTosa);
        jCheckBoxFazTosa.setOpaque(false);
        jCheckBoxFezCirurgia = new JCheckBox("Fez Cirurgia");
        Utilitarios.definirCorPadrao(jCheckBoxFezCirurgia);
        jCheckBoxFezCirurgia.setOpaque(false);
        jCheckBoxTeveFilhote = new JCheckBox("Tem Filhotes");
        Utilitarios.definirCorPadrao(jCheckBoxTeveFilhote);
        jCheckBoxTeveFilhote.setOpaque(false);
        jCheckBoxCastrado = new JCheckBox("Castrado");
        Utilitarios.definirCorPadrao(jCheckBoxCastrado);
        jCheckBoxCastrado.setOpaque(false);

        jSpinnerQtdVidas = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        ((NumberEditor) jSpinnerQtdVidas.getEditor()).getTextField().setEditable(false);
        Utilitarios.definirCorPadrao(jSpinnerQtdVidas);
        jSpinnerQtdFiosPelo = new JSpinner(new SpinnerNumberModel(0, 0, 999999, 1));
        Utilitarios.definirCorPadrao(jSpinnerQtdFiosPelo);
        jSpinnerQtdCirurgias = new JSpinner(new SpinnerNumberModel(1, 1, 999999, 1));
        Utilitarios.definirCorPadrao(jSpinnerQtdCirurgias);
        jSpinnerQtdFilhotes = new JSpinner(new SpinnerNumberModel(1, 1, 9999, 1));
        Utilitarios.definirCorPadrao(jSpinnerQtdFilhotes);

        jRadioFemea = new JRadioButton("Femea");
        jRadioMacho = new JRadioButton("Macho");
        Utilitarios.definirCorPadrao(jRadioFemea);
        Utilitarios.definirCorPadrao(jRadioMacho);
        jRadioFemea.setOpaque(false);
        jRadioMacho.setOpaque(false);
        btSexo = new ButtonGroup();
        btSexo.add(jRadioFemea);
        btSexo.add(jRadioMacho);
    }

    /**
     * Define as posições dos componentes na tela
     */
    private void createBoundsOfComponents() {
        //Definição dos paineis para organização
        panelLeft.setBounds((this.getWidth() / 2) - 451, (this.getHeight() / 2) - 300, 300, 600);
        panelLeft.setOpaque(false);
        panelRight.setBounds((this.getWidth() / 2) + 151, (this.getHeight() / 2) - 300, 300, 600);
        panelRight.setOpaque(false);
        panelCenter.setBounds((this.getWidth() / 2) - 150, (this.getHeight() / 2) - 300, 300, 600);
        panelCenter.setOpaque(false);

        //Painel da esquerda
        createJLabelToUser("Nome", 10, 10, 100, 25, 0);
        jTextFieldNome.setBounds(10, 35, 150, 25);

        createJLabelToUser("Nome do Dono", 10, 63, 150, 25, 0);
        jTextFieldNomeDono.setBounds(10, 88, 150, 25);

        jCheckBoxPedigree.setBounds(10, 115, 100, 25);

        createJLabelToUser("Cor do Olho Direito", 10, 143, 200, 25, 0);
        jTextFieldOlhoDireito.setBounds(10, 168, 150, 25);

        createJLabelToUser("Cor do Olho Esquerdo", 10, 195, 200, 25, 0);
        jTextFieldOlhoEsquerdo.setBounds(10, 220, 150, 25);

        createJLabelToUser("Quantidade de Vidas", 10, 247, 200, 25, 0);
        jSpinnerQtdVidas.setBounds(10, 273, 100, 25);

        createJLabelToUser("Cor da Pata Traseira Esquerda", 10, 300, 250, 25, 0);
        jTextFieldCorPataTraseiraEsquerda.setBounds(10, 325, 150, 25);

        createJLabelToUser("Cor da Pata Traseira Direita", 10, 352, 300, 25, 0);
        jTextFieldCorPataTraseiraDireita.setBounds(10, 377, 150, 25);

        createJLabelToUser("Cor da Pata Frontal Esquerda", 10, 402, 300, 25, 0);
        jTextFieldCorPataFrontalEsquerda.setBounds(10, 427, 150, 25);

        createJLabelToUser("Cor da Pata Frontal Direita", 10, 455, 300, 25, 0);
        jTextFieldCorPataFrontalDireita.setBounds(10, 480, 150, 25);

        //Painel central
        createJLabelToUser("Cor do Olho Esquerdo", 10, 10, 200, 25, 1);
        jTextFieldCorOlhoEsquerdo.setBounds(10, 35, 150, 25);

        createJLabelToUser("Cor do Olho Direito", 10, 63, 200, 25, 1);
        jTextFieldCorOlhoDireito.setBounds(10, 88, 150, 25);

        createJLabelToUser("Comprimento (cm)", 10, 115, 150, 25, 1);
        jTextFieldComprimento.setBounds(10, 143, 150, 25);

        createJLabelToUser("Altura (cm)", 10, 168, 150, 25, 1);
        jTextFieldAltura.setBounds(10, 195, 150, 25);

        createJLabelToUser("Peso", 10, 222, 100, 25, 1);
        jFormattedTextFieldPeso.setBounds(10, 247, 150, 25);

        createJLabelToUser("Raça", 10, 275, 100, 25, 1);
        jTextFieldRaca.setBounds(10, 300, 150, 25);

        createJLabelToUser("Nivel de Preguiça", 10, 327, 200, 25, 1);
        jTextFieldNivelPreguica.setBounds(10, 352, 150, 25);

        createJLabelToUser("Cor do Pêlo", 10, 380, 200, 25, 1);
        jTextFieldCorPelo.setBounds(10, 405, 150, 25);

        createJLabelToUser("Quantidade de Fios no Pêlo", 10, 433, 300, 25, 1);
        jSpinnerQtdFiosPelo.setBounds(10, 458, 150, 25);

        //Painel da Direita
        jCheckBoxFazTosa.setBounds(10, 10, 150, 25);

        createJLabelToUser("Marca da Ração", 10, 37, 200, 25, 2);
        jTextFieldMarcaRacao.setBounds(10, 62, 150, 25);

        jCheckBoxFezCirurgia.setBounds(10, 90, 150, 25);

        createJLabelToUser("Quantidade de Cirurgias", 10, 117, 250, 25, 2);
        jSpinnerQtdCirurgias.setBounds(10, 142, 150, 25);

        createJLabelToUser("Sexo", 10, 170, 100, 25, 2);
        jRadioFemea.setBounds(10, 195, 80, 25);
        jRadioMacho.setBounds(90, 195, 80, 25);

        jCheckBoxTeveFilhote.setBounds(10, 222, 150, 25);

        createJLabelToUser("Quantidade de Filhotes", 10, 247, 250, 25, 2);
        jSpinnerQtdFilhotes.setBounds(10, 272, 150, 25);

        jCheckBoxCastrado.setBounds(10, 300, 150, 25);

        createJLabelToUser("Idade", 10, 327, 150, 25, 2);
        jTextFieldIdade.setBounds(10, 352, 150, 25);

        jButtonCancelar.setBounds((panelRight.getWidth() - 47), (panelRight.getHeight() - 42), 40, 40);
        jButtonCadastrar.setBounds((panelRight.getWidth() - 88), (panelRight.getHeight() - 42), 40, 40);
        jButtonAlterar.setBounds((panelRight.getWidth() - 88), (panelRight.getHeight() - 42), 40, 40);
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

        panelLeft.add(jSpinnerQtdVidas);
        panelCenter.add(jSpinnerQtdFiosPelo);
        panelRight.add(jSpinnerQtdCirurgias);
        panelRight.add(jSpinnerQtdFilhotes);

        panelLeft.add(jTextFieldNome);
        panelLeft.add(jTextFieldNomeDono);
        panelLeft.add(jTextFieldOlhoDireito);
        panelLeft.add(jTextFieldOlhoEsquerdo);
        panelLeft.add(jTextFieldCorPataTraseiraEsquerda);
        panelLeft.add(jTextFieldCorPataTraseiraDireita);
        panelLeft.add(jTextFieldCorPataFrontalEsquerda);
        panelLeft.add(jTextFieldCorPataFrontalDireita);
        panelCenter.add(jTextFieldCorOlhoDireito);
        panelCenter.add(jTextFieldCorOlhoEsquerdo);
        panelCenter.add(jTextFieldComprimento);
        panelCenter.add(jTextFieldAltura);
        panelCenter.add(jTextFieldRaca);
        panelCenter.add(jTextFieldNivelPreguica);
        panelCenter.add(jTextFieldCorPelo);
        panelRight.add(jTextFieldMarcaRacao);
        panelRight.add(jTextFieldIdade);

        panelCenter.add(jFormattedTextFieldPeso);

        panelLeft.add(jCheckBoxPedigree);
        panelRight.add(jCheckBoxFazTosa);
        panelRight.add(jCheckBoxFezCirurgia);
        panelRight.add(jCheckBoxTeveFilhote);
        panelRight.add(jCheckBoxCastrado);

        panelRight.add(jRadioFemea);
        panelRight.add(jRadioMacho);

        add(panelLeft);
        add(panelRight);
        add(panelCenter);
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
                panelCenter.add(jLabel);
                break;
            case 2:
                panelRight.add(jLabel);
                break;
        }
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
        if (jTextFieldNome.getText().equals("")) {
            Utilitarios.showMessage(Strings.NOME_NAO_PODE_SER_VAZIO, Utilitarios.ICON_ADD);
            return;
        }

        Gato g = new Gato(
                (Integer) jSpinnerQtdVidas.getValue(),
                Integer.parseInt(jTextFieldComprimento.getText()),
                Integer.parseInt(jTextFieldAltura.getText()),
                Integer.parseInt(jTextFieldIdade.getText()),
                (Integer) jSpinnerQtdFiosPelo.getValue(),
                (Integer) jSpinnerQtdCirurgias.getValue(),
                (Integer) jSpinnerQtdFilhotes.getValue(),
                jTextFieldCorPataTraseiraDireita.getText(),
                jTextFieldCorPataTraseiraEsquerda.getText(),
                jTextFieldCorPataFrontalDireita.getText(),
                jTextFieldCorPataFrontalEsquerda.getText(),
                jTextFieldCorOlhoDireito.getText(),
                jTextFieldCorOlhoEsquerdo.getText(),
                jTextFieldCorPelo.getText(),
                jTextFieldNome.getText(),
                jTextFieldRaca.getText(),
                jTextFieldNivelPreguica.getText(),
                jTextFieldMarcaRacao.getText(),
                jTextFieldNomeDono.getText(),
                Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso),
                (jRadioFemea.isSelected() ? 'F'
                        : (jRadioMacho.isSelected()) ? 'M' : null),
                jCheckBoxFazTosa.isSelected(),
                jCheckBoxFezCirurgia.isSelected(),
                jCheckBoxPedigree.isSelected(),
                jCheckBoxTeveFilhote.isSelected(),
                jCheckBoxCastrado.isSelected()
        );
        PrincipalJFrame.gatos.add(g);
        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(true);
        Utilitarios.showMessage(Strings.GATO_CADASTRADO_COM_SUCESSO, Utilitarios.ICON_ADD);
        this.dispose();
    }

    /**
     * Permite a alteração de um registro
     */
    @Override
    public void acaoAlterar() {
        Gato g = new Gato(
                (Integer) jSpinnerQtdVidas.getValue(),
                Integer.parseInt(jTextFieldComprimento.getText()),
                Integer.parseInt(jTextFieldAltura.getText()),
                Integer.parseInt(jTextFieldIdade.getText()),
                (Integer) jSpinnerQtdFiosPelo.getValue(),
                (Integer) jSpinnerQtdCirurgias.getValue(),
                (Integer) jSpinnerQtdFilhotes.getValue(),
                jTextFieldCorPataTraseiraDireita.getText(),
                jTextFieldCorPataTraseiraEsquerda.getText(),
                jTextFieldCorPataFrontalDireita.getText(),
                jTextFieldCorPataFrontalEsquerda.getText(),
                jTextFieldCorOlhoDireito.getText(),
                jTextFieldCorOlhoEsquerdo.getText(),
                jTextFieldCorPelo.getText(),
                jTextFieldNome.getText(),
                jTextFieldRaca.getText(),
                jTextFieldNivelPreguica.getText(),
                jTextFieldMarcaRacao.getText(),
                jTextFieldNomeDono.getText(),
                Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso),
                (jRadioFemea.isSelected() ? 'F'
                        : (jRadioMacho.isSelected()) ? 'M' : null),
                jCheckBoxFazTosa.isSelected(),
                jCheckBoxFezCirurgia.isSelected(),
                jCheckBoxPedigree.isSelected(),
                jCheckBoxTeveFilhote.isSelected(),
                jCheckBoxCastrado.isSelected()
        );
        PrincipalJFrame.gatos.set(posicao, g);
        Utilitarios.showMessage("Gato " + g.getNome() + " alterado c sucesso!", Utilitarios.ICON_PENCIL);
    }

    /**
     * Permite que o usuário desista da ação atual
     */
    @Override
    public void acaoCancelar() {
        this.dispose();
    }

}