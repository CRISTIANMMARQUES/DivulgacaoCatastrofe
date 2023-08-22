
package interfaces;

import entidade.Inundacao.TipoInundacao;
import javax.swing.DefaultComboBoxModel;

public class PainelInundacao extends javax.swing.JPanel {

    public PainelInundacao() {
        initComponents();
    }
    
    public boolean isAtivo(){
        return ativoCheckBox.isSelected();
    }
    
    public void setAtivo(boolean ativo){
        ativoCheckBox.setSelected(ativo);
    }
    
    public String getDescricao(){
        String descricao = descricaoInundacaoTextArea.getText();
        if(descricao.isEmpty()) return null;
        else return descricao;
    }
    
    public void setDescricao(String descricao) {
        descricaoInundacaoTextArea.setText(descricao);
    }
    
    public void limparCampos(){
        grauComboBox.setSelectedIndex(-1);
        descricaoInundacaoTextArea.setText("");
        ativoCheckBox.setSelected(false);
    }
    
    public TipoInundacao getSelectedTipoInundacao(){
        Object tipo_inundacao = grauComboBox.getSelectedItem();
        if (tipo_inundacao != null) return (TipoInundacao) tipo_inundacao;
        else return null;
    }
    
    public void setSelectedTipoInundacao(TipoInundacao tipo_inundacao){
        grauComboBox.setSelectedItem(tipo_inundacao);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grauInundaçãoLabel = new javax.swing.JLabel();
        grauComboBox = new javax.swing.JComboBox<>();
        descricaoLabel = new javax.swing.JLabel();
        ativoCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoInundacaoTextArea = new javax.swing.JTextArea();

        setMaximumSize(null);

        grauInundaçãoLabel.setText("Tipo Inundação");

        grauComboBox.setModel(new DefaultComboBoxModel (TipoInundacao.values()));

        descricaoLabel.setText("Descrição");

        ativoCheckBox.setText("Ativo");

        descricaoInundacaoTextArea.setColumns(20);
        descricaoInundacaoTextArea.setLineWrap(true);
        descricaoInundacaoTextArea.setRows(5);
        descricaoInundacaoTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descricaoInundacaoTextArea);

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
    private javax.swing.JTextArea descricaoInundacaoTextArea;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JComboBox<String> grauComboBox;
    private javax.swing.JLabel grauInundaçãoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
