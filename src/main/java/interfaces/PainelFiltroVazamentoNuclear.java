
package interfaces;

import entidade.VazamentoNuclear;

public class PainelFiltroVazamentoNuclear extends javax.swing.JPanel {

    public PainelFiltroVazamentoNuclear() {
        initComponents();
    }
    
    public VazamentoNuclear.TipoVazamentoNuclear getSelectedTipoVazamentoNuclear() {
        VazamentoNuclear.TipoVazamentoNuclear tipo_vazamento_nuclear = null;
        
        if(tipo_vazamento_nuclearbuttonGroup.getSelection() != null){
            if (reator_nuclearRadioButton.isSelected()) {
                tipo_vazamento_nuclear = VazamentoNuclear.TipoVazamentoNuclear.reator_nuclear;
            }
            if (laboratorio_pesquisaRadioButton.isSelected()) {
                tipo_vazamento_nuclear = VazamentoNuclear.TipoVazamentoNuclear.laboratorio_pesquisa;
            }
            if (rejeitos_radioativoRadioButton.isSelected()) {
                tipo_vazamento_nuclear = VazamentoNuclear.TipoVazamentoNuclear.rejeitos_radioativo;
            }          
        }
        return tipo_vazamento_nuclear;
    }

    public void limparFiltros() {
        tipo_vazamento_nuclearbuttonGroup.clearSelection();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_vazamento_nuclearbuttonGroup = new javax.swing.ButtonGroup();
        tipo_vazamento_nuclearLabel = new javax.swing.JLabel();
        reator_nuclearRadioButton = new javax.swing.JRadioButton();
        laboratorio_pesquisaRadioButton = new javax.swing.JRadioButton();
        rejeitos_radioativoRadioButton = new javax.swing.JRadioButton();

        tipo_vazamento_nuclearLabel.setText("Tipo Vazamento Nuclear");

        tipo_vazamento_nuclearbuttonGroup.add(reator_nuclearRadioButton);
        reator_nuclearRadioButton.setText("reator_nuclear");

        tipo_vazamento_nuclearbuttonGroup.add(laboratorio_pesquisaRadioButton);
        laboratorio_pesquisaRadioButton.setText("laboratorio_pesquisa");

        tipo_vazamento_nuclearbuttonGroup.add(rejeitos_radioativoRadioButton);
        rejeitos_radioativoRadioButton.setText("rejeitos_radioativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tipo_vazamento_nuclearLabel)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rejeitos_radioativoRadioButton)
                    .addComponent(laboratorio_pesquisaRadioButton)
                    .addComponent(reator_nuclearRadioButton))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo_vazamento_nuclearLabel)
                    .addComponent(reator_nuclearRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laboratorio_pesquisaRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rejeitos_radioativoRadioButton)
                .addContainerGap(188, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton laboratorio_pesquisaRadioButton;
    private javax.swing.JRadioButton reator_nuclearRadioButton;
    private javax.swing.JRadioButton rejeitos_radioativoRadioButton;
    private javax.swing.JLabel tipo_vazamento_nuclearLabel;
    private javax.swing.ButtonGroup tipo_vazamento_nuclearbuttonGroup;
    // End of variables declaration//GEN-END:variables
}
