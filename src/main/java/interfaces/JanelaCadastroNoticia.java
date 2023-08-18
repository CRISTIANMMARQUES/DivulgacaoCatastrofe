
package interfaces;

import controle.ControladorCadastroNoticias;
import entidade.AgenciaNoticia;
import entidade.Catastrofe;
import entidade.Noticia;
import entidade.Noticia.GrauUrgencia;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaCadastroNoticia extends javax.swing.JFrame {
    
    ControladorCadastroNoticias controlador;
    DefaultListModel modelo_lista_noticia;
    AgenciaNoticia[] agencias_cadastradas;
    Catastrofe[] catastrofes_cadastradas;
    
    
    public JanelaCadastroNoticia(ControladorCadastroNoticias controlador) {
        this.controlador = controlador;
        agencias_cadastradas = AgenciaNoticia.getVisoes();
        catastrofes_cadastradas = Catastrofe.getVisoes();
        initComponents();
        inicializarListaNoticias();
        limparCampos(null);
    }
    
    private void inicializarListaNoticias() {
        modelo_lista_noticia = (DefaultListModel)noticias_cadastradasList.getModel();
        AgenciaNoticia[] visoes = AgenciaNoticia.getVisoes();
        for (AgenciaNoticia visao : visoes) {
            modelo_lista_noticia.addElement(visao);
        }
    }
    
    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private Noticia obterNoticiaInformada(){
        String sequencial_str = sequencialTextField.getText();
        
        //String sequencial = sequencialTextField.getText();
        
        int sequencial = 0;
        if(!sequencial_str.isEmpty()){
            sequencial = Integer.parseInt(sequencial_str);
        }
        
        String descricao = descricaoTextArea.getText();
        if(descricao.isEmpty()){
            return null;
        }
        
        AgenciaNoticia visao_agencia_noticia = (AgenciaNoticia) agencias_cadastradasComboBox.getSelectedItem();
        if(visao_agencia_noticia == null){
            return null;
        }
        
        Catastrofe visao_catastrofes = (Catastrofe) catastrofes_cadastradasComboBox.getSelectedItem();
        if (visao_catastrofes == null) {
            return null;
        }
        
        GrauUrgencia grau_urgencia = null;
        if (grau_urgenciabuttonGroup.getSelection() != null) {
            grau_urgencia = GrauUrgencia.values()[grau_urgenciabuttonGroup.getSelection().getMnemonic()];
        }
        
        Timestamp data_hora = new Timestamp(Calendar.getInstance().getTimeInMillis());
        
        return new Noticia(sequencial, descricao, visao_agencia_noticia, visao_catastrofes, grau_urgencia, data_hora);
    }
    
    private Noticia obtemNoticiaInformada(){
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grau_urgenciabuttonGroup = new javax.swing.ButtonGroup();
        noticias_cadastradasLabel = new javax.swing.JLabel();
        noticias_cadastradasScrollPane = new javax.swing.JScrollPane();
        noticias_cadastradasList = new javax.swing.JList<>();
        sequencialLabel = new javax.swing.JLabel();
        sequencialTextField = new javax.swing.JTextField();
        agencia_noticiaLabel = new javax.swing.JLabel();
        catastrofesLabel = new javax.swing.JLabel();
        agencias_cadastradasComboBox = new javax.swing.JComboBox();
        catastrofes_cadastradasComboBox = new javax.swing.JComboBox<>();
        grau_urgenciaLabel = new javax.swing.JLabel();
        urgenteRadioButton = new javax.swing.JRadioButton();
        mediaRadioButton = new javax.swing.JRadioButton();
        baixaRadioButton = new javax.swing.JRadioButton();
        descricaoLabel = new javax.swing.JLabel();
        descricaoScrollPane = new javax.swing.JScrollPane();
        descricaoTextArea = new javax.swing.JTextArea();
        dataHoraLabel = new javax.swing.JLabel();
        dataHoraTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirNoticiaButton = new javax.swing.JButton();
        consultarNoticiaButton = new javax.swing.JButton();
        removerNoticiaButton = new javax.swing.JButton();
        alterarNoticiaButton = new javax.swing.JButton();
        limparCamposButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Notícia");

        noticias_cadastradasLabel.setText("Notícias Cadastradas");

        noticias_cadastradasList.setModel(new DefaultListModel ());
        noticias_cadastradasScrollPane.setViewportView(noticias_cadastradasList);

        sequencialLabel.setText("Notícia");

        sequencialTextField.setEditable(false);

        agencia_noticiaLabel.setText("Agencia de Notícia");

        catastrofesLabel.setText("Catastrofes");

        agencias_cadastradasComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        catastrofes_cadastradasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        grau_urgenciaLabel.setText("Grau de Urgencia");

        grau_urgenciabuttonGroup.add(urgenteRadioButton);
        urgenteRadioButton.setText("Urgente");

        grau_urgenciabuttonGroup.add(mediaRadioButton);
        mediaRadioButton.setText("Media");

        grau_urgenciabuttonGroup.add(baixaRadioButton);
        baixaRadioButton.setText("Baixa");

        descricaoLabel.setText("Descrição");

        descricaoTextArea.setColumns(20);
        descricaoTextArea.setRows(5);
        descricaoTextArea.setMaximumSize(null);
        descricaoTextArea.setMinimumSize(null);
        descricaoTextArea.setPreferredSize(new java.awt.Dimension(200, 100));
        descricaoScrollPane.setViewportView(descricaoTextArea);
        descricaoTextArea.getAccessibleContext().setAccessibleName("");

        dataHoraLabel.setText("Registrado em");

        dataHoraTextField.setEditable(false);

        inserirNoticiaButton.setText("Inserir");
        inserirNoticiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirNoticiaButton(evt);
            }
        });
        comandosPanel.add(inserirNoticiaButton);

        consultarNoticiaButton.setText("Consultar");
        consultarNoticiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarNoticiaButtonActionPerformed(evt);
            }
        });
        comandosPanel.add(consultarNoticiaButton);

        removerNoticiaButton.setText("Remover");
        comandosPanel.add(removerNoticiaButton);

        alterarNoticiaButton.setText("Alterar");
        alterarNoticiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarNoticiaButtonActionPerformed(evt);
            }
        });
        comandosPanel.add(alterarNoticiaButton);

        limparCamposButton.setText("Limpar");
        comandosPanel.add(limparCamposButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descricaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataHoraLabel))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataHoraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descricaoScrollPane)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agencia_noticiaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(agencias_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(catastrofesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grau_urgenciaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(urgenteRadioButton)
                                .addGap(6, 6, 6)
                                .addComponent(mediaRadioButton)
                                .addGap(6, 6, 6)
                                .addComponent(baixaRadioButton))
                            .addComponent(catastrofes_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noticias_cadastradasLabel)
                            .addComponent(sequencialLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noticias_cadastradasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(noticias_cadastradasLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(noticias_cadastradasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sequencialLabel)
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agencia_noticiaLabel)
                    .addComponent(agencias_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catastrofesLabel)
                    .addComponent(catastrofes_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(grau_urgenciaLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(urgenteRadioButton)
                        .addComponent(mediaRadioButton)
                        .addComponent(baixaRadioButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(descricaoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(descricaoLabel)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataHoraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataHoraLabel))
                .addGap(18, 18, 18)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarNoticiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarNoticiaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultarNoticiaButtonActionPerformed

    private void alterarNoticiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarNoticiaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alterarNoticiaButtonActionPerformed

    private void inserirNoticiaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirNoticiaButton
        Noticia noticia = obterNoticiaInformada();
        String mensagem_erro = null;
        if(noticia != null) mensagem_erro = controlador.inserirNoticia(noticia);
        else mensagem_erro = "Campos faltando no cadastro de Noticia";
        if(mensagem_erro == null){
            int sequencial = Noticia.ultimoSequencial();
            noticia.setSequencial(sequencial);
            modelo_lista_noticia.addElement(noticia.getVisao);
            noticias_cadastradasList.setSelectedIndex(modelo_lista_noticia.size() -1);
            sequencialTextField.setText("" + sequencial);
            dataHoraTextField.setText(Noticia.formatarDataHora(noticia.getDataHora().toString()));
        }else informarErro(mensagem_erro);
    }//GEN-LAST:event_inserirNoticiaButton

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agencia_noticiaLabel;
    private javax.swing.JComboBox agencias_cadastradasComboBox;
    private javax.swing.JButton alterarNoticiaButton;
    private javax.swing.JRadioButton baixaRadioButton;
    private javax.swing.JLabel catastrofesLabel;
    private javax.swing.JComboBox<String> catastrofes_cadastradasComboBox;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarNoticiaButton;
    private javax.swing.JLabel dataHoraLabel;
    private javax.swing.JTextField dataHoraTextField;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JScrollPane descricaoScrollPane;
    private javax.swing.JTextArea descricaoTextArea;
    private javax.swing.JLabel grau_urgenciaLabel;
    private javax.swing.ButtonGroup grau_urgenciabuttonGroup;
    private javax.swing.JButton inserirNoticiaButton;
    private javax.swing.JButton limparCamposButton;
    private javax.swing.JRadioButton mediaRadioButton;
    private javax.swing.JLabel noticias_cadastradasLabel;
    private javax.swing.JList<String> noticias_cadastradasList;
    private javax.swing.JScrollPane noticias_cadastradasScrollPane;
    private javax.swing.JButton removerNoticiaButton;
    private javax.swing.JLabel sequencialLabel;
    private javax.swing.JTextField sequencialTextField;
    private javax.swing.JRadioButton urgenteRadioButton;
    // End of variables declaration//GEN-END:variables
}
