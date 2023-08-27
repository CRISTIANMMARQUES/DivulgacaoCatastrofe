package interfaces;


public class PainelFiltroInundacao extends javax.swing.JPanel {

    public PainelFiltroInundacao() {
        initComponents();
    }
    
    public char getInundacaoAtiva(){
        char inundacao_ativa = 'X';
        
        if(inundacao_AtivabuttonGroup.getSelection() != null){
            inundacao_ativa = (char) inundacao_AtivabuttonGroup.getSelection().getMnemonic();
        }
        
        return inundacao_ativa;
    }
    
    public void limparFiltro(){
        inundacao_AtivabuttonGroup.clearSelection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inundacao_AtivabuttonGroup = new javax.swing.ButtonGroup();
        inundacaoAtivaLabel = new javax.swing.JLabel();
        simRadioButton = new javax.swing.JRadioButton();
        naoRadioButton = new javax.swing.JRadioButton();

        inundacaoAtivaLabel.setText("Inundação Ativa?");

        inundacao_AtivabuttonGroup.add(simRadioButton);
        simRadioButton.setMnemonic('T');
        simRadioButton.setText("Sim");

        inundacao_AtivabuttonGroup.add(naoRadioButton);
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
    private javax.swing.ButtonGroup inundacao_AtivabuttonGroup;
    private javax.swing.JRadioButton naoRadioButton;
    private javax.swing.JRadioButton simRadioButton;
    // End of variables declaration//GEN-END:variables
}
