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
import model.Capivara;

/**
 *
 * @author(name= Guilherme de Liz do Nascimento, date= 07-23-2017)
 */
public class CapivaraListaJFrame extends JFrame{

    //Criação dos componentes da tela
    private JButton adicionar, alterar, excluir;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
    
    //Auxiliar para a interação do usuario
    private int linhaSelecionada = -1;
    
    public CapivaraListaJFrame() {
        criarTela();
        criarComponentes();
        popularModelo();
        definirPosicoes();
        definirClickDosBotoes();
        adicionarComponentes();
        
        tabela.getColumnModel().getColumn(3).setPreferredWidth(200);
    }
    /**
     * Metodo para criar tela de acordo com os padrões do projeto
     */
    public void criarTela() {
        setTitle("Save the Capivara - Capivara");
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
    * Metodo para criar os componentes da tela
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
     * Define os nomes das colunas 
     */
    private void adicionarCabecalhoModelo() {
        modelo.addColumn("Nome");
        modelo.addColumn("Peso");
        modelo.addColumn("Altura");
        modelo.addColumn("Classificacao da Natacao");
    }
    
    /**
     * Define as posicoes dos componentes na tela
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
     * Preenche a tabela com os registros de capivaras
     */
    private void popularModelo(){
        modelo.setRowCount(0);
        for (Capivara c : PrincipalJFrame.capivaras) {
            modelo.addRow(new Object[]{c.getNome(), c.getPeso() + " kg",
                c.getAltura(), c.getClassificacaoNatacao()});
        }
    }
    
    /**
     * Abre a tela de cadastro para o usuario adicionar um registro
     */
    private void acaoAdicionar(){
        CapivaraCadastroJFrame cadastro = new CapivaraCadastroJFrame();
    }
    
    /**
     * Abre a tela de alteracao para o usuario alterar um registro
     */
    private void acaoEditar() {
        if (linhaSelecionada > -1) {
            CapivaraCadastroJFrame cad = new CapivaraCadastroJFrame(linhaSelecionada);
        } else {
            Utilitarios.showMessage(Strings.CAPIVARA_NENHUM_SELECIONADO, Utilitarios.ICON_PENCIL);
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
            Utilitarios.showMessage(Strings.CAPIVARA_NENHUM_SELECIONADO, Utilitarios.ICON_TRASH);
        }
    }
    
    /**
     * Exclui registros de acordo com o valor passado como parametro, que 
     * representa uma linha selecionada pelo usuário.
     * 
     * @param linhaSelecionada 
     */
    private void excluirItem(int linhaSelecionada) {
        String nome = PrincipalJFrame.capivaras.get(linhaSelecionada).getNome();
        JLabel jLabel = new JLabel("Deseja apagar " + nome + "?");
        Utilitarios.definirCorPadrao(jLabel);
        int opcao = JOptionPane.showConfirmDialog(null, jLabel,
                "Cuidado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, Utilitarios.ICON_TRASH);

        if (opcao == JOptionPane.OK_OPTION) {
            PrincipalJFrame.capivaras.remove(linhaSelecionada);
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
