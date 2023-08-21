
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
        filtro_inundacaoTabbedPane.addTab("Filtro de Inundação", filtro_vazamento_nuclearPainel);
        filtro_queimadaTabbedPane.addTab("Filtro de Queimada", filtro_vazamento_nuclearPainel);
        filtro_vazamento_nuclearTabbedPane.addTab("Filtro de Vazamento Nuclear", filtro_vazamento_nuclearPainel);
        limparFiltros(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        limparFiltrosButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        limparFiltrosButton.setText("Limpar Filtros");
        limparFiltrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFiltrosButton(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(limparFiltrosButton)
                .addContainerGap(269, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limparFiltrosButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparFiltrosButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFiltrosButton
        
    }//GEN-LAST:event_limparFiltrosButton

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limparFiltrosButton;
    // End of variables declaration//GEN-END:variables
}
