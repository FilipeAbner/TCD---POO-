
package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.AutorDao;
import io.github.natansantoz.trabalho_classes.dao.EditoraDao;
import io.github.natansantoz.trabalho_classes.dao.ExemplarDao;
import io.github.natansantoz.trabalho_classes.dao.GeneroDao;
import io.github.natansantoz.trabalho_classes.dao.IdiomaDao;
import io.github.natansantoz.trabalho_classes.dao.LivroDao;
import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.Editora;
import io.github.natansantoz.trabalho_classes.entity.Exemplar;
import io.github.natansantoz.trabalho_classes.entity.Genero;
import io.github.natansantoz.trabalho_classes.entity.Idioma;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.util.ArrayList;

/**
 *
 * @author Natã
 */
public final class TelaLivrosNaoAdm extends javax.swing.JPanel {

    private static ArrayList<Livro> todosLivros;
    private static ArrayList<Autor> todosAutores;
    private static ArrayList<Exemplar> todosExemplares;
    private static ArrayList<Editora> todasEditoras;
    private static ArrayList<Idioma> todosIdiomas;
    private static ArrayList<Genero> todosGeneros;
        
        
    public TelaLivrosNaoAdm() {
        
        initComponents();

        carregarAtributosArrays();
        
        carregarCampos();
    }
    
        
    public void carregarAtributosArrays(){
                
        todosLivros =
            (ArrayList<Livro>) new LivroDao().localizarTodos();
        
        todosAutores =
            (ArrayList<Autor>) new AutorDao().localizarTodos();
        
        todosExemplares =
            (ArrayList<Exemplar>) new ExemplarDao().localizarTodos();
        
        todasEditoras =
            (ArrayList<Editora>) new EditoraDao().localizarTodos();
        
        todosIdiomas =
            (ArrayList<Idioma>) new IdiomaDao().localizarTodos();
        
        todosGeneros =
            (ArrayList<Genero>) new GeneroDao().localizarTodos();
    }
    
        
    public void carregarCampos(){
        
        for (int i = 0; i < todosLivros.size(); i++) {
            
            new LivroDao().realizarAssociacoes(todosLivros.get(i));
            
            String autores = "";
            
            for (Autor autor : todosLivros.get(i).getAutores()) {
                
                autores += todosLivros.get(i).getAutores().size() > 1 
                    ? autor.getNome() + ", "
                    : autor.getNome() + " ";
            }
            
            tabelaLivros.addRow(new Object[] { 
                
                todosLivros.get(i).getTitulo(), 
                autores, 
                todosLivros.get(i).getGenero().getGenero(), 
                todosLivros.get(i).getIdioma().getIdioma(), 
                todosLivros.get(i).getAnoDePublicacao(),
                
                new ExemplarDao().
                    localizarExemplaresNaoEmprestados(
                        todosLivros.get(i)).size()
            });
        } 

        
        for (int i = 0; i < todosAutores.size(); i++) {
            
            tabelaAutores.addRow(new Object[] { 
                
                todosAutores.get(i).getNome(), 
                todosAutores.get(i).getNascimento(), 
                todosAutores.get(i).getFalecimento() == null 
                    ? "" 
                    : todosAutores.get(i).getFalecimento() 
            
            });
        }
        
        
        for (int i = 0; i < todasEditoras.size(); i++) {

            tabelaEditoras.addRow(new Object[] { 
                
            todasEditoras.get(i).getNome(), 
            todasEditoras.get(i).getEmail(),
            todasEditoras.get(i).getTelefone(), 
            todasEditoras.get(i).getEndereco()
            
            });
        }
        
        for (int i = 0; i < todosIdiomas.size(); i++) {
            
            tabelaIdiomas.addRow(new Object[] { 
                
            todosIdiomas.get(i).getIdioma()
            
            });
        }

        for (int i = 0; i < todosGeneros.size(); i++) {
            
            tabelaGeneros.addRow(new Object[] { 
                
            todosGeneros.get(i).getGenero()
            
            });
        }
    }

    public static ArrayList<Livro> getTodosLivros() {
        return todosLivros;
    }

    public static void setTodosLivros(ArrayList<Livro> todosLivros) {
        TelaLivrosNaoAdm.todosLivros = todosLivros;
    }

    public static ArrayList<Autor> getTodosAutores() {
        return todosAutores;
    }

    public static void setTodosAutores(ArrayList<Autor> todosAutores) {
        TelaLivrosNaoAdm.todosAutores = todosAutores;
    }

    public static ArrayList<Exemplar> getTodosExemplares() {
        return todosExemplares;
    }

    public static void setTodosExemplares(ArrayList<Exemplar> todosExemplares) {
        TelaLivrosNaoAdm.todosExemplares = todosExemplares;
    }

    public static ArrayList<Editora> getTodasEditoras() {
        return todasEditoras;
    }

    public static void setTodasEditoras(ArrayList<Editora> todasEditoras) {
        TelaLivrosNaoAdm.todasEditoras = todasEditoras;
    }

    public static ArrayList<Idioma> getTodosIdiomas() {
        return todosIdiomas;
    }

    public static void setTodosIdiomas(ArrayList<Idioma> todosIdiomas) {
        TelaLivrosNaoAdm.todosIdiomas = todosIdiomas;
    }

    public static ArrayList<Genero> getTodosGeneros() {
        return todosGeneros;
    }

    public static void setTodosGeneros(ArrayList<Genero> todosGeneros) {
        TelaLivrosNaoAdm.todosGeneros = todosGeneros;
    }
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separadorUsuario = new javax.swing.JSeparator();
        lblEmprestimosEmCimaTabela = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaEditoras = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAutores = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaGeneros = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaIdiomas = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();

        separadorUsuario.setForeground(new java.awt.Color(153, 153, 153));

        setBackground(new java.awt.Color(20, 20, 20));
        setMinimumSize(new java.awt.Dimension(850, 605));
        setPreferredSize(new java.awt.Dimension(850, 605));

        lblEmprestimosEmCimaTabela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmprestimosEmCimaTabela.setText("Livros E Afins");

        jTabbedPane1.setBackground(new java.awt.Color(20, 20, 20));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tabelaLivros.setBackground(new java.awt.Color(30, 30, 30));
        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Gênero", "Idioma", "Ano de Publicação", "Disponíveis"
            }
        ));
        tabelaLivros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaLivros);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(944, 944, 944))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Livros", jPanel1);

        jPanel5.setBackground(new java.awt.Color(20, 20, 20));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tabelaEditoras.setBackground(new java.awt.Color(30, 30, 30));
        tabelaEditoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "E-mail", "Telefone", "Endereço"
            }
        ));
        jScrollPane4.setViewportView(tabelaEditoras);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(944, 944, 944))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Editoras", jPanel5);

        jPanel7.setBackground(new java.awt.Color(20, 20, 20));

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tabelaAutores.setBackground(new java.awt.Color(30, 30, 30));
        tabelaAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Nascimento", "Falecimento"
            }
        ));
        jScrollPane3.setViewportView(tabelaAutores);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(944, 944, 944))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Autores", jPanel7);

        jPanel9.setBackground(new java.awt.Color(20, 20, 20));

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tabelaGeneros.setBackground(new java.awt.Color(30, 30, 30));
        tabelaGeneros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gênero"
            }
        ));
        jScrollPane6.setViewportView(tabelaGeneros);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(944, 944, 944))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Gêneros", jPanel9);

        jPanel11.setBackground(new java.awt.Color(20, 20, 20));

        jPanel12.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tabelaIdiomas.setBackground(new java.awt.Color(30, 30, 30));
        tabelaIdiomas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idioma"
            }
        ));
        jScrollPane5.setViewportView(tabelaIdiomas);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(944, 944, 944))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Idiomas", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblEmprestimosEmCimaTabela)
                .addContainerGap(716, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblEmprestimosEmCimaTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblEmprestimosEmCimaTabela;
    private javax.swing.JSeparator separadorUsuario;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabelaAutores;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabelaEditoras;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabelaGeneros;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabelaIdiomas;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabelaLivros;
    // End of variables declaration//GEN-END:variables
}
