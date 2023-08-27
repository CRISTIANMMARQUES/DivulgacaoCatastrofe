
package interfaces;

import entidade.Queimada;

public class PainelFiltroQueimada extends javax.swing.JPanel {

    public PainelFiltroQueimada() {
        initComponents();
    }
    
    public Queimada.TipoQueimada getSelectedTipoQueimada(){
        Queimada.TipoQueimada tipo_queimada = null;
        
        if(tipo_queimadabuttonGroup.getSelection() != null){
            if (florestaRadioButton.isSelected()) {
                tipo_queimada = Queimada.TipoQueimada.floresta;
            }
            if (urbanaRadioButton.isSelected()) {
                tipo_queimada = Queimada.TipoQueimada.urbana;
            }
            if (canavialRadioButton.isSelected()) {
                tipo_queimada = Queimada.TipoQueimada.canavial;
            }          
        }
            //tipo_queimada = Queimada.TipoQueimada.values()[tipo_queimadabuttonGroup.getSelection().getMnemonic()];
        
        System.out.println(tipo_queimada);
        return tipo_queimada;
    }
    
//    public int getSelectedTipoQueimada() {
//        int tipoQueimadaInt = -1; // Valor padrão caso nenhum tipo seja selecionado
//
//        if (florestaRadioButton.isSelected()) {
//            tipoQueimadaInt = 0;
//        } else if (urbanaRadioButton.isSelected()) {
//            tipoQueimadaInt = 1;
//        } else if (canavialRadioButton.isSelected()) {
//            tipoQueimadaInt = 2;
//        }
//
//        return tipoQueimadaInt;
//    }
    
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

        tipo_queimadabuttonGroup.add(florestaRadioButton);
        florestaRadioButton.setText("floresta");

        tipo_queimadabuttonGroup.add(urbanaRadioButton);
        urbanaRadioButton.setText("urbana");

        tipo_queimadabuttonGroup.add(canavialRadioButton);
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
