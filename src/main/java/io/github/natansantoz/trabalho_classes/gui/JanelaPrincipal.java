
package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.dao.ConexaoBd;
import io.github.natansantoz.trabalho_classes.dao.EmprestimoDao;
import io.github.natansantoz.trabalho_classes.dao.LivroDao;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import io.github.natansantoz.trabalho_classes.entity.Usuario;
import io.github.natansantoz.trabalho_classes.gui.componentes.ModeloCartao;
import io.github.natansantoz.trabalho_classes.gui.componentes.Tabela;
import io.github.natansantoz.trabalho_classes.util.Util;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Natã
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    private static JanelaPrincipal instance;
    private static Usuario usuarioEstatico;
    private static JPanel panelAtual;
    private static JPanel panelCentralEstatico;
    
    private boolean attPanelbtnInicio;
    private boolean attPanelbtnLivros;
    private boolean attPanelbtnClientes;
    private boolean attPanelbtnemprestimos;
    private boolean attPanelbtnUsuarios;
    private boolean attPanelbtnRelatorio;
    private boolean attPanelbtnSair;
    
    public JanelaPrincipal(Usuario usuario) {
        
        this();
        usuarioEstatico = usuario;
        
        labelSaudacao.setText("Olá, " + usuario.getNome());
        
        TelaInicio panelInicioStartup = new TelaInicio();
        inicializarCartoesETabelaPanelInicio(usuario, panelInicioStartup);
        mudarTela(panelInicioStartup);
            
        panelCentralEstatico = panelCentral;
    }
    
    
    public static void mudarTelaEstatico(JComponent tela){
        
        panelCentralEstatico.removeAll();
        panelCentralEstatico.add(tela);
        panelCentralEstatico.repaint();
        panelCentralEstatico.revalidate();
    }
    
    public void mudarTela(JComponent tela){
        
        panelCentral.removeAll();
        panelCentral.add(tela);
        panelCentral.repaint();
        panelCentral.revalidate();
    }
    
    public void mudarTab(JPanel tab, JInternalFrame tela){
        
        tab.removeAll();
        tab.add(tela);
        tab.repaint();
        tab.revalidate();
        anexarJanela(tela);
    }
    
    public void inicializarCartoesETabelaPanelInicio(
        Usuario usuario, TelaInicio panelInicio) {
        
        Cliente cliente = 
            new ClienteDao().localizarPorId(usuario.getId());        
        
        if(!usuario.isAdministrador()) {

            ArrayList<Livro> livrosDoCliente =
                (ArrayList<Livro>) 
                    new LivroDao().localizarLivrosdeCliente(cliente);
        
            
            ModeloCartao m1 = new ModeloCartao();

            m1.setTitulo("Livros: ");
            m1.setDescricao("Descrição");

            m1.setValor(Integer.toString(livrosDoCliente.size()));
            
            m1.setIcone(new ImageIcon(
                    getClass().getResource(
                        "/Images/icons8_book_stack_30px.png")));
            
            panelInicio.returnCartao1().setDados(m1);
            
            
            
            ModeloCartao m2 = new ModeloCartao();

            m2.setTitulo("Empréstimos: ");
            m2.setDescricao("Descrição");

            ArrayList<Emprestimo> emprestimosDoCliente = (ArrayList<Emprestimo>) 
                new EmprestimoDao()
                    .localizarEmprestimosPorCliente(cliente);
                    
            
            
            m2.setValor(Integer.toString(emprestimosDoCliente.size()));


            m2.setIcone(new ImageIcon(
                    getClass().getResource(
                        "/Images/icons8_contract_30px.png")));
        
            panelInicio.returnCartao2().setDados(m2);

            Tabela tabelaInferior = panelInicio.returnTabela();
        
            
            DateTimeFormatter formatador
                = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
            
            
            for (Emprestimo emprestimo : emprestimosDoCliente) {
                
                new EmprestimoDao().realizarAssociacoes(emprestimo);
                
                tabelaInferior.addRow(new Object[]{
                
                emprestimo.getId().toString(),
                    
                Util.formatarCPF(emprestimo.getCliente().getCpf()),
                
                emprestimo.getExemplar().getLivro(),
                emprestimo.getExemplar(),
                
                emprestimo.getDataEmprestimo().format(formatador),
                emprestimo.getDataLimiteDevolucao().format(formatador),
                emprestimo.getMulta().compareTo(BigDecimal.ZERO) == 1
                ? "R$ " + emprestimo.getMulta().toString().replace(".", ",") 
                        + "0"
                : "",
                emprestimo.getDataDevolvido() != null
                ? emprestimo.getDataDevolvido().format(formatador)
                : "",
                emprestimo.getMulta().compareTo(BigDecimal.ZERO) == 0 
                    || emprestimo.getDataDevolvido() != null
                ? "OK" : "Pendente"

                });
                
            }
            
            panelInicio.returnLblEmprestimosEmCimaTabela()
                    .setText("Seus Empréstimos");
            
            return;
        }
        
        
        /*Se é admin*/
        ModeloCartao m2 = new ModeloCartao();

            m2.setTitulo("Empréstimos: ");
            m2.setDescricao("Descrição");

            ArrayList<Emprestimo> todosEmprestimos = (ArrayList<Emprestimo>) 
                new EmprestimoDao()
                    .localizarTodos();
            
            m2.setValor(Integer.toString(todosEmprestimos.size()));


            m2.setIcone(new ImageIcon(
                    getClass().getResource(
                        "/Images/icons8_contract_30px.png")));
        
            panelInicio.returnCartao2().setDados(m2);

            
            Tabela tabelaInferior = panelInicio.returnTabela();
        
            DateTimeFormatter formatador
                = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
            
            for (Emprestimo emprestimo : todosEmprestimos) {
                
                new EmprestimoDao().realizarAssociacoes(emprestimo);
                
                tabelaInferior.addRow(new Object[]{
                
                emprestimo.getId().toString(),
                    
                Util.formatarCPF(emprestimo.getCliente().getCpf()),
                
                emprestimo.getExemplar().getLivro(),
                emprestimo.getExemplar(),
                
                emprestimo.getDataEmprestimo().format(formatador),
                emprestimo.getDataLimiteDevolucao().format(formatador),
                emprestimo.getMulta().compareTo(BigDecimal.ZERO) == 1
                ? "R$ " + emprestimo.getMulta().toString().replace(".", ",") 
                        + "0"
                : "",
                emprestimo.getDataDevolvido() != null
                ? emprestimo.getDataDevolvido().format(formatador)
                : "",
                emprestimo.getMulta().compareTo(BigDecimal.ZERO) == 0 
                    || emprestimo.getDataDevolvido() != null
                ? "OK" : "Pendente"

                });
            }
    }
    
    public JanelaPrincipal() {
        initComponents();

        Area shape1 = new Area(
            new RoundRectangle2D
                .Double(0, 0, getWidth(), getHeight(), 30, 30));
        
        Area shape2 = new Area(
            new Rectangle(0, getHeight()-30, getWidth(), 100));
        
        shape1.add(shape2);
        this.setShape(shape1);
        
        setShape(
            new RoundRectangle2D
                .Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public static JanelaPrincipal getInstance() {
        if (instance == null) {
            instance = new JanelaPrincipal();
        }

        return instance;
    }
    
    public static void setInstance(JanelaPrincipal janela){
        instance = janela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelEsquerdoDark = new javax.swing.JPanel();
        panelBotaoInicio = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelbtnLivros = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelbtnClientes = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panelEmprestimos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        panelbtnUsuarios = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        labelSaudacao = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        separadorUsuario = new javax.swing.JSeparator();
        panelbtnSair = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        panelbtnRelatorio = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        panelAreaPrincipal = new javax.swing.JPanel();
        lblMinimizar = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1100, 650));
        setMinimumSize(new java.awt.Dimension(1100, 650));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(30, 31, 37));
        jPanel1.setMaximumSize(new java.awt.Dimension(1100, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 650));

        panelEsquerdoDark.setBackground(new java.awt.Color(6, 19, 37));
        panelEsquerdoDark.setPreferredSize(new java.awt.Dimension(225, 100));

        panelBotaoInicio.setBackground(new java.awt.Color(6, 19, 37));
        panelBotaoInicio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelBotaoInicioMouseMoved(evt);
            }
        });
        panelBotaoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBotaoInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBotaoInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBotaoInicioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBotaoInicioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelBotaoInicioMouseReleased(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 230, 230));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_home_20px.png"))); // NOI18N
        jLabel4.setText(" Início");

        javax.swing.GroupLayout panelBotaoInicioLayout = new javax.swing.GroupLayout(panelBotaoInicio);
        panelBotaoInicio.setLayout(panelBotaoInicioLayout);
        panelBotaoInicioLayout.setHorizontalGroup(
            panelBotaoInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotaoInicioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotaoInicioLayout.setVerticalGroup(
            panelBotaoInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotaoInicioLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelbtnLivros.setBackground(new java.awt.Color(6, 19, 37));
        panelbtnLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelbtnLivrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbtnLivrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelbtnLivrosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelbtnLivrosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelbtnLivrosMouseReleased(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(230, 230, 230));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_bookmark_20px.png"))); // NOI18N
        jLabel5.setText(" Livros");

        javax.swing.GroupLayout panelbtnLivrosLayout = new javax.swing.GroupLayout(panelbtnLivros);
        panelbtnLivros.setLayout(panelbtnLivrosLayout);
        panelbtnLivrosLayout.setHorizontalGroup(
            panelbtnLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbtnLivrosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelbtnLivrosLayout.setVerticalGroup(
            panelbtnLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbtnLivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelbtnClientes.setBackground(new java.awt.Color(6, 19, 37));
        panelbtnClientes.setPreferredSize(new java.awt.Dimension(193, 50));
        panelbtnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelbtnClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbtnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelbtnClientesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelbtnClientesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelbtnClientesMouseReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(230, 230, 230));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_people_20px_1.png"))); // NOI18N
        jLabel10.setText(" Clientes");
        jLabel10.setPreferredSize(new java.awt.Dimension(142, 20));

        javax.swing.GroupLayout panelbtnClientesLayout = new javax.swing.GroupLayout(panelbtnClientes);
        panelbtnClientes.setLayout(panelbtnClientesLayout);
        panelbtnClientesLayout.setHorizontalGroup(
            panelbtnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbtnClientesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelbtnClientesLayout.setVerticalGroup(
            panelbtnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbtnClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelEmprestimos.setBackground(new java.awt.Color(6, 19, 37));
        panelEmprestimos.setPreferredSize(new java.awt.Dimension(193, 50));
        panelEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEmprestimosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelEmprestimosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelEmprestimosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelEmprestimosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelEmprestimosMouseReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(230, 230, 230));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_contract_20px.png"))); // NOI18N
        jLabel11.setText(" Empréstimos");
        jLabel11.setPreferredSize(new java.awt.Dimension(142, 20));

        javax.swing.GroupLayout panelEmprestimosLayout = new javax.swing.GroupLayout(panelEmprestimos);
        panelEmprestimos.setLayout(panelEmprestimosLayout);
        panelEmprestimosLayout.setHorizontalGroup(
            panelEmprestimosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmprestimosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelEmprestimosLayout.setVerticalGroup(
            panelEmprestimosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmprestimosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelbtnUsuarios.setBackground(new java.awt.Color(6, 19, 37));
        panelbtnUsuarios.setPreferredSize(new java.awt.Dimension(200, 50));
        panelbtnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelbtnUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbtnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelbtnUsuariosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelbtnUsuariosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelbtnUsuariosMouseReleased(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(26, 28, 41));
        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(230, 230, 230));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_person_20px.png"))); // NOI18N
        jLabel8.setText(" Usuários");

        javax.swing.GroupLayout panelbtnUsuariosLayout = new javax.swing.GroupLayout(panelbtnUsuarios);
        panelbtnUsuarios.setLayout(panelbtnUsuariosLayout);
        panelbtnUsuariosLayout.setHorizontalGroup(
            panelbtnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbtnUsuariosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelbtnUsuariosLayout.setVerticalGroup(
            panelbtnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        labelSaudacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelSaudacao.setText("Olá,");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_50px_2.png"))); // NOI18N

        separadorUsuario.setForeground(new java.awt.Color(153, 153, 153));

        panelbtnSair.setBackground(new java.awt.Color(6, 19, 37));
        panelbtnSair.setPreferredSize(new java.awt.Dimension(200, 50));
        panelbtnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelbtnSairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbtnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelbtnSairMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelbtnSairMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelbtnSairMouseReleased(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(26, 28, 41));
        jLabel13.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(230, 230, 230));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_enter_20px.png"))); // NOI18N
        jLabel13.setText(" Sair");

        javax.swing.GroupLayout panelbtnSairLayout = new javax.swing.GroupLayout(panelbtnSair);
        panelbtnSair.setLayout(panelbtnSairLayout);
        panelbtnSairLayout.setHorizontalGroup(
            panelbtnSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbtnSairLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(143, 143, 143))
        );
        panelbtnSairLayout.setVerticalGroup(
            panelbtnSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panelbtnRelatorio.setBackground(new java.awt.Color(6, 19, 37));
        panelbtnRelatorio.setPreferredSize(new java.awt.Dimension(200, 50));
        panelbtnRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelbtnRelatorioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbtnRelatorioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelbtnRelatorioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelbtnRelatorioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelbtnRelatorioMouseReleased(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(26, 28, 41));
        jLabel14.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(230, 230, 230));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_file_20px_1.png"))); // NOI18N
        jLabel14.setText(" Relatórios");

        javax.swing.GroupLayout panelbtnRelatorioLayout = new javax.swing.GroupLayout(panelbtnRelatorio);
        panelbtnRelatorio.setLayout(panelbtnRelatorioLayout);
        panelbtnRelatorioLayout.setHorizontalGroup(
            panelbtnRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbtnRelatorioLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelbtnRelatorioLayout.setVerticalGroup(
            panelbtnRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelEsquerdoDarkLayout = new javax.swing.GroupLayout(panelEsquerdoDark);
        panelEsquerdoDark.setLayout(panelEsquerdoDarkLayout);
        panelEsquerdoDarkLayout.setHorizontalGroup(
            panelEsquerdoDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotaoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelbtnLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelEmprestimos, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addComponent(panelbtnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addComponent(panelbtnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addGroup(panelEsquerdoDarkLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelEsquerdoDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separadorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEsquerdoDarkLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSaudacao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(panelbtnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addComponent(panelbtnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );
        panelEsquerdoDarkLayout.setVerticalGroup(
            panelEsquerdoDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEsquerdoDarkLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelEsquerdoDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(panelEsquerdoDarkLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelSaudacao)))
                .addGap(26, 26, 26)
                .addComponent(separadorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelbtnLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelbtnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelbtnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelbtnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelbtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        panelAreaPrincipal.setBackground(new java.awt.Color(20, 20, 20));

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_subtract_20px.png"))); // NOI18N
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        lblFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_close_20px_1.png"))); // NOI18N
        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });

        panelCentral.setBackground(new java.awt.Color(10, 10, 10));
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelAreaPrincipalLayout = new javax.swing.GroupLayout(panelAreaPrincipal);
        panelAreaPrincipal.setLayout(panelAreaPrincipalLayout);
        panelAreaPrincipalLayout.setHorizontalGroup(
            panelAreaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAreaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAreaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelAreaPrincipalLayout.createSequentialGroup()
                        .addGap(0, 795, Short.MAX_VALUE)
                        .addComponent(lblMinimizar)
                        .addGap(18, 18, 18)
                        .addComponent(lblFechar)))
                .addGap(16, 16, 16))
        );
        panelAreaPrincipalLayout.setVerticalGroup(
            panelAreaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAreaPrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelAreaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechar)
                    .addComponent(lblMinimizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelEsquerdoDark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelAreaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEsquerdoDark, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addComponent(panelAreaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setState(JanelaPrincipal.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void panelBotaoInicioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotaoInicioMouseMoved
    }//GEN-LAST:event_panelBotaoInicioMouseMoved

    private void panelBotaoInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotaoInicioMouseEntered
        panelBotaoInicio.setBackground(new Color(6,28,49));
        attPanelbtnInicio = true;
    }//GEN-LAST:event_panelBotaoInicioMouseEntered

    private void panelBotaoInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotaoInicioMouseExited
        panelBotaoInicio.setBackground(new Color(6,19,37));
        attPanelbtnInicio = false;
    }//GEN-LAST:event_panelBotaoInicioMouseExited

    private void panelbtnLivrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnLivrosMouseEntered
        panelbtnLivros.setBackground(new Color(6,28,49));
        attPanelbtnLivros = true;
    }//GEN-LAST:event_panelbtnLivrosMouseEntered

    private void panelbtnLivrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnLivrosMouseExited
        panelbtnLivros.setBackground(new Color(6,19,37));
        attPanelbtnLivros = false;
    }//GEN-LAST:event_panelbtnLivrosMouseExited

    private void panelbtnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnClientesMouseEntered
        panelbtnClientes.setBackground(new Color(6,28,49));
        attPanelbtnClientes = true;
    }//GEN-LAST:event_panelbtnClientesMouseEntered

    private void panelbtnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnClientesMouseExited

        panelbtnClientes.setBackground(new Color(6,19,37));
        attPanelbtnClientes = false;
    }//GEN-LAST:event_panelbtnClientesMouseExited

    private void panelEmprestimosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEmprestimosMouseEntered
        panelEmprestimos.setBackground(new Color(6,28,49));
        attPanelbtnemprestimos = true;
    }//GEN-LAST:event_panelEmprestimosMouseEntered

    private void panelEmprestimosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEmprestimosMouseExited

        panelEmprestimos.setBackground(new Color(6,19,37));
        attPanelbtnemprestimos = false;
    }//GEN-LAST:event_panelEmprestimosMouseExited

    private void panelbtnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsuariosMouseEntered
        panelbtnUsuarios.setBackground(new Color(6,28,49));
        attPanelbtnUsuarios = true;
    }//GEN-LAST:event_panelbtnUsuariosMouseEntered

    private void panelbtnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsuariosMouseExited
        panelbtnUsuarios.setBackground(new Color(6,19,37));
        attPanelbtnUsuarios = false;
    }//GEN-LAST:event_panelbtnUsuariosMouseExited

    private void panelbtnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsuariosMouseClicked

        if(!usuarioEstatico.isAdministrador()){
            
            JOptionPane.showMessageDialog(
                    null, "Você não possui acesso a essa área.");
            
            return;
        }      
        
        TelaUsuarios telaUsuarios = new TelaUsuarios();
        mudarTela(telaUsuarios);
        panelAtual = telaUsuarios;
    }//GEN-LAST:event_panelbtnUsuariosMouseClicked

    private void panelBotaoInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotaoInicioMouseClicked
        TelaInicio novoPanelInicio = new TelaInicio();
        inicializarCartoesETabelaPanelInicio(usuarioEstatico, novoPanelInicio);
        mudarTela(novoPanelInicio);
        panelAtual = novoPanelInicio;
    }//GEN-LAST:event_panelBotaoInicioMouseClicked

    private void panelBotaoInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotaoInicioMousePressed
        panelBotaoInicio.setBackground(new Color(6,23,44));
    }//GEN-LAST:event_panelBotaoInicioMousePressed

    private void panelBotaoInicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotaoInicioMouseReleased
        if(attPanelbtnInicio){
            
            panelBotaoInicio.setBackground(new Color(6,28,49));
        }
    }//GEN-LAST:event_panelBotaoInicioMouseReleased

    private void panelbtnLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnLivrosMouseClicked
        
        if(!usuarioEstatico.isAdministrador()){
            
            TelaLivrosNaoAdm telaLivros = new TelaLivrosNaoAdm();
            mudarTela(telaLivros);
            panelAtual = telaLivros;
            
            return;
        }
        
        TelaLivros telaLivros = new TelaLivros();
        mudarTela(telaLivros);
        panelAtual = telaLivros;
    }//GEN-LAST:event_panelbtnLivrosMouseClicked

    private void panelbtnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnClientesMouseClicked
        if(!usuarioEstatico.isAdministrador()){
            
            JOptionPane.showMessageDialog(
                    null, "Você não possui acesso a essa área.");
            
            return;
            
        }
        
        TelaClientes telaCliente = new TelaClientes();
        mudarTela(telaCliente);
        panelAtual = telaCliente;
    }//GEN-LAST:event_panelbtnClientesMouseClicked

    private void panelbtnLivrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnLivrosMousePressed
        panelbtnLivros.setBackground(new Color(6,23,44));
        
    }//GEN-LAST:event_panelbtnLivrosMousePressed

    private void panelbtnLivrosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnLivrosMouseReleased
        if(attPanelbtnLivros){
            
            panelbtnLivros.setBackground(new Color(6,28,49));
        }
    }//GEN-LAST:event_panelbtnLivrosMouseReleased

    private void panelbtnClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnClientesMousePressed
        
        panelbtnClientes.setBackground(new Color(6,23,44));
    }//GEN-LAST:event_panelbtnClientesMousePressed

    private void panelbtnClientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnClientesMouseReleased
        if(attPanelbtnClientes){
            
            panelbtnClientes.setBackground(new Color(6,28,49));
        }
    }//GEN-LAST:event_panelbtnClientesMouseReleased

    private void panelEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEmprestimosMouseClicked
        if(!usuarioEstatico.isAdministrador()){
            
            JOptionPane.showMessageDialog(
                    null, "Você não possui acesso a essa área.");
            
            return;
            
        }
        
        TelaEmprestimos telaLivros = new TelaEmprestimos(usuarioEstatico);
        mudarTela(telaLivros);
        panelAtual = telaLivros;
    }//GEN-LAST:event_panelEmprestimosMouseClicked

    private void panelbtnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnSairMouseClicked
        io.github.
            natansantoz.
                trabalho_classes.gui.Login.rotinaMain();
        dispose();
    }//GEN-LAST:event_panelbtnSairMouseClicked

    private void panelbtnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnSairMouseEntered
        panelbtnSair.setBackground(new Color(6,28,49));
        
    }//GEN-LAST:event_panelbtnSairMouseEntered

    private void panelbtnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnSairMouseExited
        panelbtnSair.setBackground(new Color(6,19,37));
    }//GEN-LAST:event_panelbtnSairMouseExited

    private void panelbtnSairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnSairMousePressed
        panelbtnSair.setBackground(new Color(6,23,44));
    }//GEN-LAST:event_panelbtnSairMousePressed

    private void panelbtnSairMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnSairMouseReleased
        if(attPanelbtnSair){
            
            panelbtnSair.setBackground(new Color(6,28,49));
        }
    }//GEN-LAST:event_panelbtnSairMouseReleased

    private void panelEmprestimosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEmprestimosMousePressed
        panelEmprestimos.setBackground(new Color(6,23,44));
    }//GEN-LAST:event_panelEmprestimosMousePressed

    private void panelEmprestimosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEmprestimosMouseReleased
        if(attPanelbtnemprestimos){
            
            panelEmprestimos.setBackground(new Color(6,28,49));
        }
    }//GEN-LAST:event_panelEmprestimosMouseReleased

    private void panelbtnUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsuariosMousePressed
        panelbtnUsuarios.setBackground(new Color(6,23,44));
    }//GEN-LAST:event_panelbtnUsuariosMousePressed

    private void panelbtnUsuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsuariosMouseReleased
        if(attPanelbtnUsuarios){
            
            panelbtnUsuarios.setBackground(new Color(6,28,49));
        }
    }//GEN-LAST:event_panelbtnUsuariosMouseReleased

    private void panelbtnRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnRelatorioMouseClicked
        if(!usuarioEstatico.isAdministrador()){
            
            JOptionPane.showMessageDialog(
                    null, "Você não possui acesso a essa área.");
            
            return;
        }
        
        TelaRelatorios telaRelatorios = new TelaRelatorios();
        mudarTela(telaRelatorios);
        panelAtual = telaRelatorios;
    }//GEN-LAST:event_panelbtnRelatorioMouseClicked

    private void panelbtnRelatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnRelatorioMouseEntered
        panelbtnRelatorio.setBackground(new Color(6,28,49));
        attPanelbtnRelatorio = true;
    }//GEN-LAST:event_panelbtnRelatorioMouseEntered

    private void panelbtnRelatorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnRelatorioMouseExited
        panelbtnRelatorio.setBackground(new Color(6,19,37));
        attPanelbtnRelatorio = false;
    }//GEN-LAST:event_panelbtnRelatorioMouseExited

    private void panelbtnRelatorioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnRelatorioMousePressed
        panelbtnRelatorio.setBackground(new Color(6,23,44));
    }//GEN-LAST:event_panelbtnRelatorioMousePressed

    private void panelbtnRelatorioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnRelatorioMouseReleased
        if(attPanelbtnRelatorio){
            
            panelbtnRelatorio.setBackground(new Color(6,28,49));
        }
    }//GEN-LAST:event_panelbtnRelatorioMouseReleased
    
    private void anexarJanela(JInternalFrame janela) {
        if (janela == null) {
            return;
        }

        janela.setVisible(true);

        try {
            janela.setIcon(false);

            janela.setSelected(true);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }

        janela.toFront();
    }
    
    
    private JInternalFrame criaJanelaRelatorioTab(String caminho) {

        try (InputStream in = getClass().getResourceAsStream(caminho)) {

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(in, null, ConexaoBd.getConexao());

            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            JInternalFrame relat
                    = InternaTelaTelatorios.getInstance();
            
            relat.setContentPane(
                    jasperViewer.getContentPane());

            BasicInternalFrameUI basicInternalFrameUI = 
                    ((javax.swing.plaf.basic.BasicInternalFrameUI) relat.getUI());
            
            for (MouseListener listener : basicInternalFrameUI.getNorthPane()
                    .getMouseListeners()) {
                
                basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
            }


            return relat;

        } catch (IOException | JRException ex) {
            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelSaudacao;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JPanel panelAreaPrincipal;
    private javax.swing.JPanel panelBotaoInicio;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelEmprestimos;
    private javax.swing.JPanel panelEsquerdoDark;
    private javax.swing.JPanel panelbtnClientes;
    private javax.swing.JPanel panelbtnLivros;
    private javax.swing.JPanel panelbtnRelatorio;
    private javax.swing.JPanel panelbtnSair;
    private javax.swing.JPanel panelbtnUsuarios;
    private javax.swing.JSeparator separadorUsuario;
    // End of variables declaration//GEN-END:variables

}
