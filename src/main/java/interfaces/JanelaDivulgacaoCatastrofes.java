
package interfaces;

import controle.ControladorCadastroAgenciaNoticia;
import controle.ControladorCadastroCatastrofes;
import javax.swing.JOptionPane;
import persistencia.BD;

public class JanelaDivulgacaoCatastrofes extends javax.swing.JFrame {
    
    public JanelaDivulgacaoCatastrofes() {
        BD.criarConexão();
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        divulgacao_catastrofesMenuBar = new javax.swing.JMenuBar();
        catastrofeMenu = new javax.swing.JMenu();
        cadastro_catastrofeMenuItem = new javax.swing.JMenuItem();
        agenciaNoticiaMenu = new javax.swing.JMenu();
        cadastro_agenciaNoticiaMenuItem = new javax.swing.JMenuItem();
        localizacaoMenu = new javax.swing.JMenu();
        cadastro_localizacaoMenuItem = new javax.swing.JMenuItem();
        pesquisar_localizacaoMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DE CATASTROFES");
        setName(""); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                terminarSistema(evt);
            }
        });

        catastrofeMenu.setText("Catastrofe");

        cadastro_catastrofeMenuItem.setText("Cadastrar");
        cadastro_catastrofeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarCatastrofe(evt);
            }
        });
        catastrofeMenu.add(cadastro_catastrofeMenuItem);

        divulgacao_catastrofesMenuBar.add(catastrofeMenu);

        agenciaNoticiaMenu.setText("Agencia de Noticía");

        cadastro_agenciaNoticiaMenuItem.setText("Cadastrar");
        cadastro_agenciaNoticiaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAgenciaNoticia(evt);
            }
        });
        agenciaNoticiaMenu.add(cadastro_agenciaNoticiaMenuItem);

        divulgacao_catastrofesMenuBar.add(agenciaNoticiaMenu);

        localizacaoMenu.setText("Localização");

        cadastro_localizacaoMenuItem.setText("Cadastrar");
        cadastro_localizacaoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarLocalizacao(evt);
            }
        });
        localizacaoMenu.add(cadastro_localizacaoMenuItem);

        pesquisar_localizacaoMenuItem.setText("Pesquisar");
        pesquisar_localizacaoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarLocalizacao(evt);
            }
        });
        localizacaoMenu.add(pesquisar_localizacaoMenuItem);

        divulgacao_catastrofesMenuBar.add(localizacaoMenu);

        setJMenuBar(divulgacao_catastrofesMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarCatastrofe(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarCatastrofe
        new ControladorCadastroCatastrofes();
    }//GEN-LAST:event_cadastrarCatastrofe

    private void terminarSistema(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_terminarSistema
        BD.fechaConexão();
        System.exit(0);
    }//GEN-LAST:event_terminarSistema

    private void cadastrarLocalizacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarLocalizacao
        informarServiçoIndisponível();
    }//GEN-LAST:event_cadastrarLocalizacao

    private void pesquisarLocalizacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarLocalizacao
        informarServiçoIndisponível();
    }//GEN-LAST:event_pesquisarLocalizacao

    private void cadastrarAgenciaNoticia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAgenciaNoticia
        new ControladorCadastroAgenciaNoticia();
    }//GEN-LAST:event_cadastrarAgenciaNoticia

    private void informarServiçoIndisponível(){
        JOptionPane.showMessageDialog(this,"Serviço Indisponivel", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]) {
        BD.criarConexão();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaDivulgacaoCatastrofes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu agenciaNoticiaMenu;
    private javax.swing.JMenuItem cadastro_agenciaNoticiaMenuItem;
    private javax.swing.JMenuItem cadastro_catastrofeMenuItem;
    private javax.swing.JMenuItem cadastro_localizacaoMenuItem;
    private javax.swing.JMenu catastrofeMenu;
    private javax.swing.JMenuBar divulgacao_catastrofesMenuBar;
    private javax.swing.JMenu localizacaoMenu;
    private javax.swing.JMenuItem pesquisar_localizacaoMenuItem;
    // End of variables declaration//GEN-END:variables
}
