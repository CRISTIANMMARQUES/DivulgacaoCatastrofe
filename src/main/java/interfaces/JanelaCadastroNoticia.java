
package interfaces;

import controle.ControladorCadastroNoticias;
import entidade.AgenciaNoticia;
import entidade.Catastrofe;
import entidade.Noticia;
import entidade.Noticia.GrauUrgencia;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
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
        limparCampos();
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
        
        char grau_urgencia = 'x';
        if(grau_urgenciabuttonGroup.getSelection() != null){
            grau_urgencia = (char) grau_urgenciabuttonGroup.getSelection().getMnemonic();
        }else return null;
        
        Timestamp data_hora = new Timestamp(Calendar.getInstance().getTimeInMillis());
        
        return new Noticia(sequencial, descricao, visao_agencia_noticia, visao_catastrofes, grau_urgencia, data_hora);
    }
    
    private Noticia obtemNoticiaInformada(){
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if(!sequencial_str.isEmpty())sequencial = Integer.parseInt(sequencial_str);
        AgenciaNoticia visao_agencia_noticia = (AgenciaNoticia) agencias_cadastradasComboBox.getSelectedItem();
        if(visao_agencia_noticia == null) return null;
        Catastrofe visao_catastrofes = (Catastrofe)catastrofes_cadastradasComboBox.getSelectedItem();
        if(visao_catastrofes == null) return null;
        char grau_urgencia = 'x';
        if(grau_urgenciabuttonGroup.getSelection() != null){
            grau_urgencia = (char) grau_urgenciabuttonGroup.getSelection().getMnemonic();
        }else return null;
        String descricao = descricaoTextArea.getText();
        if(descricao.isEmpty()) return null;
        Timestamp data_hora = new Timestamp(Calendar.getInstance().getTimeInMillis());
        return new Noticia(sequencial, descricao, visao_agencia_noticia, visao_catastrofes, grau_urgencia, data_hora);
    }
    
    private void selecionarGrauUrgenciaRadioButton(char grau_urgencia) {
        switch (grau_urgencia) {
            case 'B':
                baixoRadioButton.setSelected(true);
                break;
            case 'M':
                medioRadioButton.setSelected(true);
                break;
            case 'U':
                urgenteRadioButton.setSelected(true);
                break;
        }
    }
    
    private void limparCampos() {
        descricaoTextArea.setText("");
        sequencialTextField.setText("");
        agencias_cadastradasComboBox.setSelectedIndex(-1);
        catastrofes_cadastradasComboBox.setSelectedIndex(-1);
        grau_urgenciabuttonGroup.clearSelection();
    }
    
    private AgenciaNoticia getVisaoAgenciaNoticiaSelecionada(Noticia noticia) {
        // Lógica para obter a visão de agência de notícia selecionada com base na notícia
        AgenciaNoticia[] visoesAgencia = AgenciaNoticia.getVisoes();

        // Aqui você deve percorrer as visões para encontrar a correspondente à agência de notícia da notícia
        for (AgenciaNoticia visaoAgencia : visoesAgencia) {
            // Suponhamos que a notícia tenha uma referência para a agência de notícia associada:
            if (noticia.getAgenciaNoticia().getCnpj().equals(visaoAgencia.getCnpj())) {
                return visaoAgencia;
            }
        }

        return null; // Caso não seja encontrada uma correspondência
    }
    
    private Catastrofe getVisaoCatastrofeSelecionada(Noticia noticia) {
        // Lógica para obter a visão de agência de notícia selecionada com base na notícia
        Catastrofe[] visoesCatastrofe = Catastrofe.getVisoes();

        // Aqui você deve percorrer as visões para encontrar a correspondente à agência de notícia da notícia
        for (Catastrofe visaoCatastrofe : visoesCatastrofe) {
            // Suponhamos que a notícia tenha uma referência para a agência de notícia associada:
            if (noticia.getCatastrofe().getSequencial().equals(visaoCatastrofe.getSequencial())){
                return visaoCatastrofe;
            }
        }

        return null; // Caso não seja encontrada uma correspondência
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        medioRadioButton = new javax.swing.JRadioButton();
        baixoRadioButton = new javax.swing.JRadioButton();
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
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        noticias_cadastradasLabel.setText("Notícias Cadastradas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(88, 12, 0, 0);
        getContentPane().add(noticias_cadastradasLabel, gridBagConstraints);

        noticias_cadastradasList.setModel(new DefaultListModel ());
        noticias_cadastradasScrollPane.setViewportView(noticias_cadastradasList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 402;
        gridBagConstraints.ipady = 115;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 64);
        getContentPane().add(noticias_cadastradasScrollPane, gridBagConstraints);

        sequencialLabel.setText("Notícia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 12, 0, 0);
        getContentPane().add(sequencialLabel, gridBagConstraints);

        sequencialTextField.setEditable(false);
        sequencialTextField.setColumns(1000);
        sequencialTextField.setMaximumSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 8, 0, 0);
        getContentPane().add(sequencialTextField, gridBagConstraints);

        agencia_noticiaLabel.setText("Agencia de Notícia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        getContentPane().add(agencia_noticiaLabel, gridBagConstraints);

        catastrofesLabel.setText("Catastrofes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 12, 0, 0);
        getContentPane().add(catastrofesLabel, gridBagConstraints);

        agencias_cadastradasComboBox.setModel(new DefaultComboBoxModel(AgenciaNoticia.getVisoes()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 143;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 8, 0, 0);
        getContentPane().add(agencias_cadastradasComboBox, gridBagConstraints);

        catastrofes_cadastradasComboBox.setModel(new DefaultComboBoxModel(Catastrofe.getVisoes()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 141;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 8, 0, 0);
        getContentPane().add(catastrofes_cadastradasComboBox, gridBagConstraints);

        grau_urgenciaLabel.setText("Grau de Urgencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 12, 0, 0);
        getContentPane().add(grau_urgenciaLabel, gridBagConstraints);

        grau_urgenciabuttonGroup.add(urgenteRadioButton);
        urgenteRadioButton.setMnemonic('U');
        urgenteRadioButton.setText("Urgente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(urgenteRadioButton, gridBagConstraints);

        grau_urgenciabuttonGroup.add(medioRadioButton);
        medioRadioButton.setMnemonic('M');
        medioRadioButton.setText("Medio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 8, 0, 0);
        getContentPane().add(medioRadioButton, gridBagConstraints);

        grau_urgenciabuttonGroup.add(baixoRadioButton);
        baixoRadioButton.setMnemonic('B');
        baixoRadioButton.setText("Baixo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 8, 0, 0);
        getContentPane().add(baixoRadioButton, gridBagConstraints);

        descricaoLabel.setText("Descrição");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 12, 0, 0);
        getContentPane().add(descricaoLabel, gridBagConstraints);

        descricaoTextArea.setColumns(20);
        descricaoTextArea.setRows(5);
        descricaoTextArea.setMaximumSize(null);
        descricaoTextArea.setMinimumSize(null);
        descricaoTextArea.setPreferredSize(new java.awt.Dimension(200, 100));
        descricaoScrollPane.setViewportView(descricaoTextArea);
        descricaoTextArea.getAccessibleContext().setAccessibleName("");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 400;
        gridBagConstraints.ipady = 101;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 8, 0, 64);
        getContentPane().add(descricaoScrollPane, gridBagConstraints);

        dataHoraLabel.setText("Registrado em");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 12, 0, 0);
        getContentPane().add(dataHoraLabel, gridBagConstraints);

        dataHoraTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 123;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 8, 0, 0);
        getContentPane().add(dataHoraTextField, gridBagConstraints);

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
                consultarNoticiaButton(evt);
            }
        });
        comandosPanel.add(consultarNoticiaButton);

        removerNoticiaButton.setText("Remover");
        removerNoticiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerNoticiaButton(evt);
            }
        });
        comandosPanel.add(removerNoticiaButton);

        alterarNoticiaButton.setText("Alterar");
        alterarNoticiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarNoticiaButton(evt);
            }
        });
        comandosPanel.add(alterarNoticiaButton);

        limparCamposButton.setText("Limpar");
        comandosPanel.add(limparCamposButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 38, 0);
        getContentPane().add(comandosPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarNoticiaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarNoticiaButton
        // TODO add your handling code here:
        Object selectedValue = noticias_cadastradasList.getSelectedValue();
        String mensagem_erro = null;
        Noticia noticia = null;
        if (selectedValue instanceof Noticia) {
            Noticia visao = (Noticia) selectedValue;
            if (visao != null) {
                noticia = Noticia.buscarNoticias(visao.getSequencial());
                selecionarGrauUrgenciaRadioButton(noticia.getGrauUrgencia());
                if (noticia == null) {
                    mensagem_erro = "Noticia não cadastrada";
                }
            } else {
                mensagem_erro = "Nenhuma noticia cadastrada";
            }
            if (mensagem_erro == null) {
                agencias_cadastradasComboBox.setSelectedItem(getVisaoAgenciaNoticiaSelecionada(noticia));
                catastrofes_cadastradasComboBox.setSelectedItem(getVisaoCatastrofeSelecionada(noticia));
                String descricao = noticia.getDescricao();
                if (descricao == null) {
                    descricao = "";
                }
                dataHoraTextField.setText(Noticia.formatarDataHora(noticia.getDataHora().toString()));
            } else {
                informarErro(mensagem_erro);
            }
        }

    }//GEN-LAST:event_consultarNoticiaButton

    private void alterarNoticiaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarNoticiaButton
        // TODO add your handling code here:
        Noticia noticia = obtemNoticiaInformada();
        String mensagem_erro = null;
        if(noticia != null){
            mensagem_erro = controlador.alterarNoticia(noticia);
        }
        else mensagem_erro = "Algum atributo da Noticia não foi informado";
        if(mensagem_erro != null) informarErro(mensagem_erro);
    }//GEN-LAST:event_alterarNoticiaButton

    private void inserirNoticiaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirNoticiaButton
        Noticia noticia = obterNoticiaInformada();
        String mensagem_erro = null;
        if(noticia != null) mensagem_erro = controlador.inserirNoticia(noticia);
        else mensagem_erro = "Campos faltando no cadastro de Noticia";
        if(mensagem_erro == null){
            int sequencial = Noticia.ultimoSequencial();
            noticia.setSequencial(sequencial);
            modelo_lista_noticia.addElement(noticia.getVisao());
            noticias_cadastradasList.setSelectedIndex(modelo_lista_noticia.size() -1);
            sequencialTextField.setText("" + sequencial);
            dataHoraTextField.setText(Noticia.formatarDataHora(noticia.getDataHora().toString()));
        }else informarErro(mensagem_erro);
    }//GEN-LAST:event_inserirNoticiaButton

    private void removerNoticiaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerNoticiaButton
        // TODO add your handling code here:
        
    }//GEN-LAST:event_removerNoticiaButton

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agencia_noticiaLabel;
    private javax.swing.JComboBox agencias_cadastradasComboBox;
    private javax.swing.JButton alterarNoticiaButton;
    private javax.swing.JRadioButton baixoRadioButton;
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
    private javax.swing.JRadioButton medioRadioButton;
    private javax.swing.JLabel noticias_cadastradasLabel;
    private javax.swing.JList<String> noticias_cadastradasList;
    private javax.swing.JScrollPane noticias_cadastradasScrollPane;
    private javax.swing.JButton removerNoticiaButton;
    private javax.swing.JLabel sequencialLabel;
    private javax.swing.JTextField sequencialTextField;
    private javax.swing.JRadioButton urgenteRadioButton;
    // End of variables declaration//GEN-END:variables
}
