
package interfaces;

import entidade.VazamentoNuclear.TipoVazamentoNuclear;
import javax.swing.DefaultComboBoxModel;

public class PainelVazamentoNuclear extends javax.swing.JPanel {

    public PainelVazamentoNuclear() {
        initComponents();
    }
    
    public boolean isAtivo(){
        return ativoCheckBox.isSelected();
    }
    
    public void setAtivo(boolean ativo){
        ativoCheckBox.setSelected(ativo);
    }
    
    public String getDescricao(){
        String descricao = descricaoVazamentoNuclearTextArea.getText();
        if(descricao.isEmpty()) return null;
        else return descricao;
    }
    
    public void setDescricao(String descricao) {
        descricaoVazamentoNuclearTextArea.setText(descricao);
    }
    
    public void limparCampos(){
        grauComboBox.setSelectedIndex(-1);
        descricaoVazamentoNuclearTextArea.setText("");
        ativoCheckBox.setSelected(false);
    }
    
    public TipoVazamentoNuclear getSelectedVazamentoNuclear(){
        Object tipo_vazamento_nuclear = grauComboBox.getSelectedItem();
        if (tipo_vazamento_nuclear != null) return (TipoVazamentoNuclear) tipo_vazamento_nuclear;
        else return null;
    }
    
    public void setSelectedVazamentoNuclear(TipoVazamentoNuclear tipo_vazamento_nuclear){
        grauComboBox.setSelectedItem(tipo_vazamento_nuclear);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grauInundaçãoLabel = new javax.swing.JLabel();
        grauComboBox = new javax.swing.JComboBox<>();
        descricaoLabel = new javax.swing.JLabel();
        ativoCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoVazamentoNuclearTextArea = new javax.swing.JTextArea();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(354, 184));

        grauInundaçãoLabel.setText("Tipo Vazamento Nuclear");

        grauComboBox.setModel(new DefaultComboBoxModel (TipoVazamentoNuclear.values()));

        descricaoLabel.setText("Descrição");

        ativoCheckBox.setText("Ativo");

        descricaoVazamentoNuclearTextArea.setColumns(20);
        descricaoVazamentoNuclearTextArea.setLineWrap(true);
        descricaoVazamentoNuclearTextArea.setRows(5);
        descricaoVazamentoNuclearTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descricaoVazamentoNuclearTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grauInundaçãoLabel)
                    .addComponent(descricaoLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(grauComboBox, 0, 232, Short.MAX_VALUE)
                    .addComponent(ativoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grauInundaçãoLabel)
                    .addComponent(grauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descricaoLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ativoCheckBox)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ativoCheckBox;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JTextArea descricaoVazamentoNuclearTextArea;
    private javax.swing.JComboBox<String> grauComboBox;
    private javax.swing.JLabel grauInundaçãoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
