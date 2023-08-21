
package interfaces;

import entidade.AgenciaNoticia;
import entidade.Catastrofe;
import interfaces.PainelFiltroInundacao;

public class JanelaPesquisaNoticias extends javax.swing.JFrame {
    
    AgenciaNoticia[] agencia_noticias_cadastradas;
    Catastrofe[] catastrofes_cadastradas;
    PainelFiltroInundacao filtro_inundacaoPainel;
    PainelFiltroQueimada filtro_queimadaPainel;
    PainelFiltroVazamentoNuclear filtro_vazamento_nuclearPainel;
    public JanelaPesquisaNoticias() {
        agencia_noticias_cadastradas = AgenciaNoticia.getVisoes();
        catastrofes_cadastradas = Catastrofe.getVisoes();
        initComponents();
        filtro_inundacaoPainel = new PainelFiltroInundacao();
        filtro_queimadaPainel = new PainelFiltroQueimada();
        filtro_vazamento_nuclearPainel = new PainelFiltroVazamentoNuclear();
        filtro_noticiasTabbedPane.addTab("Filtro de Inundação", filtro_vazamento_nuclearPainel);
        filtro_noticiasTabbedPane.addTab("Filtro de Queimada", filtro_vazamento_nuclearPainel);
        filtro_noticiasTabbedPane.addTab("Filtro de Vazamento Nuclear", filtro_vazamento_nuclearPainel);
//        limparFiltros(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comandosPanel = new javax.swing.JPanel();
        limpar_FiltrosButton = new javax.swing.JButton();
        filtro_noticiasTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        limpar_FiltrosButton.setText("Limpar Filtros");
        limpar_FiltrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpar_FiltrosButton(evt);
            }
        });

        javax.swing.GroupLayout comandosPanelLayout = new javax.swing.GroupLayout(comandosPanel);
        comandosPanel.setLayout(comandosPanelLayout);
        comandosPanelLayout.setHorizontalGroup(
            comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comandosPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(limpar_FiltrosButton)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        comandosPanelLayout.setVerticalGroup(
            comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comandosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limpar_FiltrosButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        filtro_noticiasTabbedPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comandosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filtro_noticiasTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(filtro_noticiasTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpar_FiltrosButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar_FiltrosButton
        
    }//GEN-LAST:event_limpar_FiltrosButton

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JTabbedPane filtro_noticiasTabbedPane;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpar_FiltrosButton;
    // End of variables declaration//GEN-END:variables
}
