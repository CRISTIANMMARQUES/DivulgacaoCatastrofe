
package interfaces;

import entidade.Queimada.TipoQueimada;
import javax.swing.DefaultComboBoxModel;

public class PainelQueimada extends javax.swing.JPanel {

    public PainelQueimada() {
        initComponents();
    }
    
    public boolean isAtivo(){
        return ativoCheckBox.isSelected();
    }
    
    public void setAtivo(boolean ativo){
        ativoCheckBox.setSelected(ativo);
    }
    
    public String getDescricao(){
        String descricao = descricaoQueimadaTextArea.getText();
        if(descricao.isEmpty()) return null;
        else return descricao;
    }
    
    public void setDescricao(String descricao) {
        descricaoQueimadaTextArea.setText(descricao);
    }
    
    public void limparCampos(){
        grauComboBox.setSelectedIndex(-1);
        descricaoQueimadaTextArea.setText("");
        ativoCheckBox.setSelected(false);
    }
    
    public TipoQueimada getSelectedTipoQueimada(){
        Object tipo_queimada = grauComboBox.getSelectedItem();
        if (tipo_queimada != null) return (TipoQueimada) tipo_queimada;
        else return null;
    }
    
    public void setSelectedTipoQueimada(TipoQueimada tipo_queimada){
        grauComboBox.setSelectedItem(tipo_queimada);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grauInundaçãoLabel = new javax.swing.JLabel();
        grauComboBox = new javax.swing.JComboBox<>();
        descricaoLabel = new javax.swing.JLabel();
        ativoCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoQueimadaTextArea = new javax.swing.JTextArea();

        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(354, 184));

        grauInundaçãoLabel.setText("Tipo Queimada");

        grauComboBox.setModel(new DefaultComboBoxModel (TipoQueimada  .values()));

        descricaoLabel.setText("Descrição");

        ativoCheckBox.setText("Ativo");

        descricaoQueimadaTextArea.setColumns(20);
        descricaoQueimadaTextArea.setLineWrap(true);
        descricaoQueimadaTextArea.setRows(5);
        descricaoQueimadaTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descricaoQueimadaTextArea);

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
                    .addComponent(ativoCheckBox)
                    .addComponent(grauComboBox, 0, 242, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(17, 17, 17)
                .addComponent(ativoCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ativoCheckBox;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JTextArea descricaoQueimadaTextArea;
    private javax.swing.JComboBox<String> grauComboBox;
    private javax.swing.JLabel grauInundaçãoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
