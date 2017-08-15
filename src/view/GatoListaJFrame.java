package view;

import control.Strings;
import control.Utilitarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Gato;

/**
 * Classe que permite a visualização dos registros de gatos.
 * 
 * @author(name= Guilherme de Liz, date= 07-22-2017)
 */
public class GatoListaJFrame extends JFrame {

    //Criação dos componentes básicos da tela
    private JButton adicionar, alterar, excluir;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
    
    //Auxiliar para a interação com o usuario
    private int linhaSelecionada = -1;

    /**
     * Construtor que agrupa métodos para a criação da tela.
     */
    public GatoListaJFrame() {
        criarTela();
        criarComponentes();
        popularModelo();
        definirPosicoes();
        definirClickDosBotoes();
        adicionarComponentes();
    }

    /**
     * Criação da tela de acordo com os padrões do projeto
     */
    public void criarTela() {
        setTitle("Save the Capivara - Gato");
        setIconImage(Utilitarios.ICONE);
        setContentPane(new JLabel(Utilitarios.WALLPAPER));
        setSize(800, 490);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
                popularModelo();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

        setVisible(true);
    }

    /**
     * Instancia dos componentes da tela
     */
    private void criarComponentes() {
        adicionar = new JButton(Utilitarios.ICON_ADD);
        alterar = new JButton(Utilitarios.ICON_PENCIL);
        excluir = new JButton(Utilitarios.ICON_TRASH);

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        adicionarCabecalhoModelo();
        tabela = new JTable(modelo);
        Utilitarios.definirCorPadrao(tabela);
        Utilitarios.definirCorPadrao(tabela.getTableHeader());
        scroll = new JScrollPane(tabela);
        definirOnClickTabela();
    }

    /**
     * Definição dos nomes das colunas da tabela
     */
    private void adicionarCabecalhoModelo() {
        modelo.addColumn("Nome");
        modelo.addColumn("Dono");
        modelo.addColumn("Pedigree");
        modelo.addColumn("Olho Direito");
        modelo.addColumn("Olho Esquerdo");
    }

    /**
     * Define a posição dos componentes na tela
     */
    private void definirPosicoes() {
        adicionar.setBounds(664, 412, 40, 40);
        alterar.setBounds(704, 412, 40, 40);
        excluir.setBounds(744, 412, 40, 40);
        scroll.setBounds(10, 10, 775, 400);
    }

    /**
     * Adiciona componentes na tela
     */
    private void adicionarComponentes() {
        add(adicionar);
        add(alterar);
        add(excluir);
        add(scroll);
    }

    /**
     * Preenche as linhas da tabela com os registros de gatos
     */
    private void popularModelo() {
        modelo.setRowCount(0);
        for (Gato g : PrincipalJFrame.gatos) {
            String pedigree = g.isPedigree() ? "Sim" : "Nao";
            modelo.addRow(new Object[]{g.getNome(), g.getNomeDono(), pedigree,
                g.getCorOlhoDireito(), g.getCorOlhoEsquerdo()});
        }
    }

    /**
     * Abre a janela que permite um novo cadastro.
     */
    private void acaoAdicionar() {
        GatoCadastroJFrame cad = new GatoCadastroJFrame();
    }

    /**
     * Abre a janela que permite a edição de um cadastro existente.
     */
    private void acaoEditar() {
        if (linhaSelecionada > -1) {
            GatoCadastroJFrame cad = new GatoCadastroJFrame(linhaSelecionada);
        } else {
            Utilitarios.showMessage(Strings.GATO_NENHUM_SELECIONADO, Utilitarios.ICON_PENCIL);
        }
    }

    /**
     * Método para percorrer toda a seleção do usuário na tabela para a exclusão.
     */
    private void acaoExcluir() {
        int[] linhasSelecionadas = tabela.getSelectedRows();
        if (linhasSelecionadas.length > 0) {
            for (int i = linhasSelecionadas.length - 1; i > -1; i--) {
                int linhaSelecionada = linhasSelecionadas[i];
                excluirItem(linhaSelecionada);
            }
            tabela.clearSelection();
        } else {
            Utilitarios.showMessage(Strings.GATO_NENHUM_SELECIONADO, Utilitarios.ICON_TRASH);
        }
    }

    /**
     * Exclui registros de acordo com o valor passado como parametro, que 
     * representa uma linha selecionada pelo usuário.
     * 
     * @param linhaSelecionada 
     */
    private void excluirItem(int linhaSelecionada) {
        String nome = PrincipalJFrame.gatos.get(linhaSelecionada).getNome();
        JLabel jLabel = new JLabel("Deseja apagar " + nome + "?");
        Utilitarios.definirCorPadrao(jLabel);
        int opcao = JOptionPane.showConfirmDialog(null, jLabel,
                "Cuidado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, Utilitarios.ICON_TRASH);

        if (opcao == JOptionPane.OK_OPTION) {
            PrincipalJFrame.gatos.remove(linhaSelecionada);
            modelo.removeRow(linhaSelecionada);
            this.linhaSelecionada = -1;
            Utilitarios.showMessage("Removido " + nome + " c sucesso", Utilitarios.ICON_TRASH);
        }
    }

    /**
     * Define as ações dos botões.
     */
    private void definirClickDosBotoes() {
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoAdicionar();
            }
        });
        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoEditar();
            }
        });
        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoExcluir();
            }
        });
    }

    /**
     * Define as ações da tabela.
     */
    private void definirOnClickTabela() {
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                linhaSelecionada = tabela.getSelectedRow();
            }
        });
    }

}
