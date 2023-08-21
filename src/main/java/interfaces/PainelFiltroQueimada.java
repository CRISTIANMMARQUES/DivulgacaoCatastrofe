
package interfaces;

import entidade.Queimada;

public class PainelFiltroQueimada extends javax.swing.JPanel {

    public PainelFiltroQueimada() {
        initComponents();
    }
    
    public Queimada.TipoQueimada getSelectedTipoQueimada(){
        Queimada.TipoQueimada tipo_queimada = null;
        if(tipo_queimadabuttonGroup.getSelection() != null) tipo_queimada = Queimada.TipoQueimada.values()
                [tipo_queimadabuttonGroup.getSelection().getMnemonic()];
        return tipo_queimada;
    }
    
    public void limparFiltros(){
        tipo_queimadabuttonGroup.clearSelection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_queimadabuttonGroup = new javax.swing.ButtonGroup();
        tipoQueimadaLabel = new javax.swing.JLabel();
        florestaRadioButton = new javax.swing.JRadioButton();
        urbanaRadioButton = new javax.swing.JRadioButton();
        canavialRadioButton = new javax.swing.JRadioButton();

        tipoQueimadaLabel.setText("Tipo Queimada");

        florestaRadioButton.setText("floresta");

        urbanaRadioButton.setText("urbana");

        canavialRadioButton.setText("canavial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tipoQueimadaLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canavialRadioButton)
                    .addComponent(urbanaRadioButton)
                    .addComponent(florestaRadioButton))
                .addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoQueimadaLabel)
                    .addComponent(florestaRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(urbanaRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(canavialRadioButton)
                .addContainerGap(179, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton canavialRadioButton;
    private javax.swing.JRadioButton florestaRadioButton;
    private javax.swing.JLabel tipoQueimadaLabel;
    private javax.swing.ButtonGroup tipo_queimadabuttonGroup;
    private javax.swing.JRadioButton urbanaRadioButton;
    // End of variables declaration//GEN-END:variables
}
