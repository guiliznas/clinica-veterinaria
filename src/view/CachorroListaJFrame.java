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
import model.Cachorro;

/**
 * Permite a visualização dos registros de cachorros
 * 
 * @author(name= Guilherme de Liz do Nascimento, date= 07-23-2017)
 */
public class CachorroListaJFrame extends JFrame {

    //Criação dos componentes da tela
    private JButton adicionar, alterar, excluir;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
    
    //Auxiliar para a interação do usuario
    private int linhaSelecionada = -1;

    /**
     * Contrutor que reune os métodos para preencher a tela
     */
    public CachorroListaJFrame() {
        criarTela();
        criarComponentes();
        popularModelo();
        definirPosicoes();
        definirClickDosBotoes();
        adicionarComponentes();
    }

    /**
     * Inicia o JFrame com as definições seguindo os padrões do projeto
     */
    public void criarTela() {
        setTitle("Save the Capivara - Cachorro");
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
     * Instancia os componentes para a interação do usuario.
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
     * Define o nome das colunas da tabela. 
     */
    private void adicionarCabecalhoModelo() {
        modelo.addColumn("Nome");
        modelo.addColumn("Raca");
        modelo.addColumn("Peso");
        modelo.addColumn("Sexo");
        modelo.addColumn("Estado Atual");
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
     * Adiciona os componentes na tela
     */
    private void adicionarComponentes() {
        add(adicionar);
        add(alterar);
        add(excluir);
        add(scroll);
    }

    /**
     * Adiciona as linhas na tabela, de acordo com os registros de cachorros
     *
     * @author Guilherme de Liz
     */
    private void popularModelo() {
        modelo.setRowCount(0);
        for (int i = 0; i < PrincipalJFrame.cachorros.size(); i++) {
            Cachorro cacho = PrincipalJFrame.cachorros.get(i);
            String estadoAtual = cacho.isVivo() ? "Vivo" : "Morto";
            String sexo = (Character.toUpperCase(cacho.getSexo()) == 'M') ? "Macho"
                    : Character.toUpperCase(cacho.getSexo()) == 'F' ? "Femea" : "Nao definido";
            modelo.addRow(new Object[]{cacho.getNome(), cacho.getRaca(), cacho.getPeso() + " kg",
                sexo, estadoAtual});
        }
    }

    /**
     * Abre a tela para o cadastro de um novo objeto
     */
    private void acaoAdicionar() {
        CachorroCadastroJFrame cadastro = new CachorroCadastroJFrame();
    }

    /**
     * Abre a tela para a alteração de um objeto existente
     */
    private void acaoEditar() {
        if (linhaSelecionada > -1) {
            CachorroCadastroJFrame cad = new CachorroCadastroJFrame(linhaSelecionada);
        } else {
            Utilitarios.showMessage(Strings.CACHORRO_NENHUM_SELECIONADO, Utilitarios.ICON_PENCIL);
        }
    }

    /**
     * Confere multipla seleção para a exclusão de objetos
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
            Utilitarios.showMessage(Strings.CACHORRO_NENHUM_SELECIONADO, Utilitarios.ICON_TRASH);
        }
    }

    /**
     * Exclui o objeto da lista de acordo com o parametro.
     * 
     * @param linhaSelecionada 
     */
    private void excluirItem(int linhaSelecionada) {
        String nome = PrincipalJFrame.cachorros.get(linhaSelecionada).getNome();
        JLabel jLabel = new JLabel("Deseja apagar " + nome + "?");
        Utilitarios.definirCorPadrao(jLabel);
        int opcao = JOptionPane.showConfirmDialog(null, jLabel,
                "Cuidado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, Utilitarios.ICON_TRASH);

        if (opcao == JOptionPane.OK_OPTION) {
            PrincipalJFrame.cachorros.remove(linhaSelecionada);
            modelo.removeRow(linhaSelecionada);
            this.linhaSelecionada = -1;
            Utilitarios.showMessage("Removido " + nome + " c sucesso", Utilitarios.ICON_TRASH);
        }

    }

    /**
     * Define ações dos botões
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
     * Define ações da tabela
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