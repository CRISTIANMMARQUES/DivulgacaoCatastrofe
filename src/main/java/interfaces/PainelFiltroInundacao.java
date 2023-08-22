package interfaces;


public class PainelFiltroInundacao extends javax.swing.JPanel {

    public PainelFiltroInundacao() {
        initComponents();
    }
    
    public char getInundacaoAtiva(){
        char inundacao_ativa = 'x';
        if(inundacaoAtivabuttonGroup.getSelection() != null){
            switch(inundacaoAtivabuttonGroup.getSelection().getMnemonic()){
                case 0: inundacao_ativa = 'S'; break;
                case 1: inundacao_ativa = 'N';
            }
        }
        return inundacao_ativa;
    }
    
    public void limparFiltro(){
        inundacaoAtivabuttonGroup.clearSelection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inundacaoAtivabuttonGroup = new javax.swing.ButtonGroup();
        inundacaoAtivaLabel = new javax.swing.JLabel();
        simRadioButton = new javax.swing.JRadioButton();
        naoRadioButton = new javax.swing.JRadioButton();

        inundacaoAtivaLabel.setText("Inundação Ativa?");

        inundacaoAtivabuttonGroup.add(simRadioButton);
        simRadioButton.setMnemonic('T');
        simRadioButton.setText("Sim");

        inundacaoAtivabuttonGroup.add(naoRadioButton);
        naoRadioButton.setMnemonic('F');
        naoRadioButton.setText("Nao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(inundacaoAtivaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simRadioButton)
                .addGap(18, 18, 18)
                .addComponent(naoRadioButton)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inundacaoAtivaLabel)
                    .addComponent(simRadioButton)
                    .addComponent(naoRadioButton))
                .addContainerGap(246, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel inundacaoAtivaLabel;
    private javax.swing.ButtonGroup inundacaoAtivabuttonGroup;
    private javax.swing.JRadioButton naoRadioButton;
    private javax.swing.JRadioButton simRadioButton;
    // End of variables declaration//GEN-END:variables
}
