
package interfaces;

import controle.ControladorCadastroAgenciaNoticia;
import entidade.AgenciaNoticia;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaCadastroAgenciasNoticia extends javax.swing.JFrame {
    
    ControladorCadastroAgenciaNoticia controlador;
    DefaultListModel modelo_lista_agencias;
    
    public JanelaCadastroAgenciasNoticia(ControladorCadastroAgenciaNoticia controlador) {
        this.controlador = controlador;
        initComponents();
        inicializarListaAgencias();
        limparCampos();
    }
    private void inicializarListaAgencias() {
        modelo_lista_agencias = (DefaultListModel)agencias_cadastradasList.getModel();
        AgenciaNoticia[] visoes = AgenciaNoticia.getVisoes();
        for (AgenciaNoticia visao : visoes)modelo_lista_agencias.addElement(visao);
    }
    private void limparCampos() {
        cnpjTextField.setText("");
        nomeTextField.setText("");
        enderecoTextField.setText("");
        estadoTextField.setText("");
        paisTextField.setText("");
        tipo_agencia_noticiaButtonGroup.clearSelection();
    }
    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    private AgenciaNoticia obterAgenciaNoticiaInformada() {
        
        String cnpj = cnpjTextField.getText();

        String nome = nomeTextField.getText();
        if (nome.isEmpty()) {
            return null;
        }
        
        String endereco = enderecoTextField.getText();
        if (endereco.isEmpty()) {
            endereco = null;
        }
        
        String estado = estadoTextField.getText();
        if (estado.isEmpty()) {
            estado = null;
        }
        
        String pais = paisTextField.getText();
        if (pais.isEmpty()) {
            pais = null;
        }
        
        char tipo_agencia_noticia = 'x';
        if(tipo_agencia_noticiaButtonGroup.getSelection() != null){
            tipo_agencia_noticia = (char) tipo_agencia_noticiaButtonGroup.getSelection().getMnemonic();
        }else return null;

        return new AgenciaNoticia(cnpj, nome, endereco, estado, pais, tipo_agencia_noticia);
    }   
    private void selecionarTipoAgenciaNoticiaRadioButton(char tipo_agencia_noticia){
        switch(tipo_agencia_noticia){
            case 'M':municipalRadioButton.setSelected(true);break;
            case 'E':estadualRadioButton.setSelected(true);break;
            case 'N':nacionalRadioButton.setSelected(true);break;
            case 'I':internacionalRadioButton.setSelected(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tipo_agencia_noticiaButtonGroup = new javax.swing.ButtonGroup();
        agencias_cadastradasScrollPane = new javax.swing.JScrollPane();
        agencias_cadastradasList = new javax.swing.JList();
        cnpjLabel = new javax.swing.JLabel();
        cnpjTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        enderecoLabel = new javax.swing.JLabel();
        enderecoTextField = new javax.swing.JTextField();
        estadoLabel = new javax.swing.JLabel();
        estadoTextField = new javax.swing.JTextField();
        paisLabel = new javax.swing.JLabel();
        paisTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        tipo_agencia_noticiaLabel = new javax.swing.JLabel();
        tipo_agencia_noticiaPanel = new javax.swing.JPanel();
        municipalRadioButton = new javax.swing.JRadioButton();
        estadualRadioButton = new javax.swing.JRadioButton();
        nacionalRadioButton = new javax.swing.JRadioButton();
        internacionalRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Agencias");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        agencias_cadastradasList.setModel(new DefaultListModel ());
        agencias_cadastradasList.setToolTipText("Teste");
        agencias_cadastradasList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        agencias_cadastradasScrollPane.setViewportView(agencias_cadastradasList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 409;
        gridBagConstraints.ipady = 93;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 103);
        getContentPane().add(agencias_cadastradasScrollPane, gridBagConstraints);

        cnpjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cnpjLabel.setText("Cnpj");
        cnpjLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 85, 0, 0);
        getContentPane().add(cnpjLabel, gridBagConstraints);

        cnpjTextField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 405;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 103);
        getContentPane().add(cnpjTextField, gridBagConstraints);

        nomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nomeLabel.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 52, 0, 0);
        getContentPane().add(nomeLabel, gridBagConstraints);

        nomeTextField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 405;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 103);
        getContentPane().add(nomeTextField, gridBagConstraints);

        enderecoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        enderecoLabel.setText("Endereço");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 46, 0, 0);
        getContentPane().add(enderecoLabel, gridBagConstraints);

        enderecoTextField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 405;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 103);
        getContentPane().add(enderecoTextField, gridBagConstraints);

        estadoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estadoLabel.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 46, 0, 0);
        getContentPane().add(estadoLabel, gridBagConstraints);

        estadoTextField.setColumns(4);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 69;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        getContentPane().add(estadoTextField, gridBagConstraints);

        paisLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        paisLabel.setText("País");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        getContentPane().add(paisLabel, gridBagConstraints);

        paisTextField.setColumns(4);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        getContentPane().add(paisTextField, gridBagConstraints);

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirAgenciaNoticiaButton(evt);
            }
        });
        comandosPanel.add(inserirButton);

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarAgenciaNoticiaButton(evt);
            }
        });
        comandosPanel.add(consultarButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarAgenciaNoticiaButton(evt);
            }
        });
        comandosPanel.add(alterarButton);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerAgenciaButton(evt);
            }
        });
        comandosPanel.add(removerButton);

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonlimparCamposButton(evt);
            }
        });
        comandosPanel.add(limparButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 109, 0, 0);
        getContentPane().add(comandosPanel, gridBagConstraints);

        tipo_agencia_noticiaLabel.setText("Tipo de Agencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 25, 0, 0);
        getContentPane().add(tipo_agencia_noticiaLabel, gridBagConstraints);

        tipo_agencia_noticiaPanel.setPreferredSize(new java.awt.Dimension(300, 30));

        tipo_agencia_noticiaButtonGroup.add(municipalRadioButton);
        municipalRadioButton.setMnemonic('M');
        municipalRadioButton.setText("Municipal");
        tipo_agencia_noticiaPanel.add(municipalRadioButton);

        tipo_agencia_noticiaButtonGroup.add(estadualRadioButton);
        estadualRadioButton.setMnemonic('E');
        estadualRadioButton.setText("Estadual");
        tipo_agencia_noticiaPanel.add(estadualRadioButton);

        tipo_agencia_noticiaButtonGroup.add(nacionalRadioButton);
        nacionalRadioButton.setMnemonic('N');
        nacionalRadioButton.setText("Nacional");
        tipo_agencia_noticiaPanel.add(nacionalRadioButton);

        tipo_agencia_noticiaButtonGroup.add(internacionalRadioButton);
        internacionalRadioButton.setMnemonic('I');
        internacionalRadioButton.setText("Internacional");
        tipo_agencia_noticiaPanel.add(internacionalRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 89;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 103);
        getContentPane().add(tipo_agencia_noticiaPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirAgenciaNoticiaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirAgenciaNoticiaButton
        AgenciaNoticia agenciaNoticia = obterAgenciaNoticiaInformada();
        String mensagem_erro = null;
        if(agenciaNoticia != null) mensagem_erro = controlador.inserirAgenciaNoticia(agenciaNoticia);
        else mensagem_erro = "Algum atributo da Catastrofe não foi informado";
        if (mensagem_erro == null){
            String cnpj = agenciaNoticia.getCnpj();
            agenciaNoticia.setCnpj(cnpj);
            modelo_lista_agencias.addElement(agenciaNoticia.getVisao());
            agencias_cadastradasList.setSelectedIndex(modelo_lista_agencias.size() -1);
            limparCampos();
            //cnpjTextField.setText("" + cnpj);
        }
        else informarErro(mensagem_erro);
    }//GEN-LAST:event_inserirAgenciaNoticiaButton

    private void consultarAgenciaNoticiaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarAgenciaNoticiaButton
        Object selectedValue = agencias_cadastradasList.getSelectedValue();
        String mensagem_erro = null;
        AgenciaNoticia agencia_noticia = null;
        //selecionarTipoAgenciaNoticiaRadioButton(agencia_noticia.getTipo_agencia_noticia());
        if (selectedValue instanceof AgenciaNoticia) {
            AgenciaNoticia visao = (AgenciaNoticia) selectedValue;
            if (visao != null) {
                agencia_noticia = AgenciaNoticia.buscarAgenciaNoticia(visao.getCnpj());
                selecionarTipoAgenciaNoticiaRadioButton(agencia_noticia.getTipo_agencia_noticia());
                if (agencia_noticia == null) mensagem_erro = "Agencia de Noticia não cadastrada";
            } else mensagem_erro = "Nenhuma agencia de noticía cadastrada";
            if (mensagem_erro == null) {
                cnpjTextField.setText(agencia_noticia.getCnpj());
                nomeTextField.setText(agencia_noticia.getNome());
                String endereco = agencia_noticia.getEndereco();
                if (endereco == null) {
                    endereco = "";
                }
                enderecoTextField.setText(endereco);
                String estado = agencia_noticia.getEstado();
                if (estado == null) {
                    estado = "";
                }
                estadoTextField.setText(estado);
                String pais = agencia_noticia.getPais();
                if (pais == null) {
                    pais = "";
                }
                paisTextField.setText(pais);
            } else
                informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarAgenciaNoticiaButton

    private void alterarAgenciaNoticiaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarAgenciaNoticiaButton
        AgenciaNoticia agencia_noticia = obterAgenciaNoticiaInformada();
        String mensagem_erro = null;
        if(agencia_noticia != null) mensagem_erro = controlador.alterarAgenciaNoticia(agencia_noticia);
        else mensagem_erro = "Algum atributo do evento não foi informado";
        if(mensagem_erro == null){
            Object selectedValue = agencias_cadastradasList.getSelectedValue();
            if (selectedValue instanceof AgenciaNoticia) {
                AgenciaNoticia visao = (AgenciaNoticia) selectedValue;
                if (visao != null) {
                    visao.setNome(agencia_noticia.getNome());
                    agencias_cadastradasList.updateUI();
                }
            }
        }else informarErro(mensagem_erro);
    }//GEN-LAST:event_alterarAgenciaNoticiaButton

    private void removerAgenciaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerAgenciaButton
        Object selectedValue = agencias_cadastradasList.getSelectedValue();
        String mensagem_erro = null;
        AgenciaNoticia agencia_noticia = null;
        if (selectedValue instanceof AgenciaNoticia) {
            AgenciaNoticia visao = (AgenciaNoticia) selectedValue;
            if (visao != null) {
                agencia_noticia = AgenciaNoticia.buscarAgenciaNoticia(visao.getCnpj());
                mensagem_erro = controlador.removerAgenciaNoticia(agencia_noticia.getCnpj());
                if(agencia_noticia == null) mensagem_erro = "Agencia não cadastrado";
            }else mensagem_erro = "Nenhuma Agencia de Noticia selecionada";
            if(mensagem_erro == null){
                modelo_lista_agencias.removeElement(visao);
                limparCampos();
            }else informarErro(mensagem_erro);
        }else {
            mensagem_erro = "Selected Value não é uma instancia de Agencia Noticia";
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_removerAgenciaButton

    private void limparButtonlimparCamposButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonlimparCamposButton
        limparCampos();
    }//GEN-LAST:event_limparButtonlimparCamposButton

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList agencias_cadastradasList;
    private javax.swing.JScrollPane agencias_cadastradasScrollPane;
    private javax.swing.JButton alterarButton;
    private javax.swing.JLabel cnpjLabel;
    private javax.swing.JTextField cnpjTextField;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel enderecoLabel;
    private javax.swing.JTextField enderecoTextField;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JTextField estadoTextField;
    private javax.swing.JRadioButton estadualRadioButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JRadioButton internacionalRadioButton;
    private javax.swing.JButton limparButton;
    private javax.swing.JRadioButton municipalRadioButton;
    private javax.swing.JRadioButton nacionalRadioButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel paisLabel;
    private javax.swing.JTextField paisTextField;
    private javax.swing.JButton removerButton;
    private javax.swing.ButtonGroup tipo_agencia_noticiaButtonGroup;
    private javax.swing.JLabel tipo_agencia_noticiaLabel;
    private javax.swing.JPanel tipo_agencia_noticiaPanel;
    // End of variables declaration//GEN-END:variables
}
