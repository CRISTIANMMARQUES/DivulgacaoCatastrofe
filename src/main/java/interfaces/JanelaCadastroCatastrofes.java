package interfaces;

import controle.ControladorCadastroCatastrofes;
import entidade.Catastrofe;
import entidade.Inundacao;
import entidade.Inundacao.TipoInundacao;
import entidade.Queimada;
import entidade.Queimada.TipoQueimada;
import entidade.VazamentoNuclear;
import entidade.VazamentoNuclear.TipoVazamentoNuclear;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class JanelaCadastroCatastrofes extends javax.swing.JFrame {
    
    ControladorCadastroCatastrofes controlador;
    Catastrofe[] catastrofes_cadastradas;
    PainelInundacao inundacao_painel;
    PainelQueimada queimada_painel;
    PainelVazamentoNuclear vazamento_nuclear_painel;

    public JanelaCadastroCatastrofes(ControladorCadastroCatastrofes controlador) {
        this.controlador = controlador;
        catastrofes_cadastradas = Catastrofe.getVisoes();
        initComponents();
        inundacao_painel = new PainelInundacao();
        queimada_painel = new PainelQueimada();
        vazamento_nuclear_painel = new PainelVazamentoNuclear();
        catastrofeTabbedPane.addTab("Inundação", inundacao_painel);
        catastrofeTabbedPane.addTab("Queimada", queimada_painel);
        catastrofeTabbedPane.addTab("Vazamento Nuclear", vazamento_nuclear_painel);
        limparCampos();
    }
    private void limparCampos() {
        catastrofes_cadComboBox.setSelectedIndex(-1);
        sequencialTextField.setText("");
        nomeTextField.setText("");
        dataTextField.setText("");
        localizacaoTextField.setText("");
        inundacao_painel.limparCampos();
        queimada_painel.limparCampos();
        vazamento_nuclear_painel.limparCampos();
    }
    private Catastrofe obterCatastrofeInformado(){
        Catastrofe catastrofe = null;
        int indice_aba_selecionada = catastrofeTabbedPane.getSelectedIndex();
        String sequencial_str = sequencialTextField.getText();
        Integer sequencial = 0;
        if (!sequencial_str.isEmpty()) {
            sequencial = Integer.parseInt(sequencial_str);
        }
        //Campo Obrigatório
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) {
            return null;
        }
        //Campo Obrigatório
        String data = dataTextField.getText();
        if (data.isEmpty()) {
            return null;
        }
        String localizacao = localizacaoTextField.getText();
        if (localizacao.isEmpty())
            localizacao = null;
        
                switch(indice_aba_selecionada){
            case 0:
                TipoInundacao tipo_inundacao = inundacao_painel.getSelectedTipoInundacao();
                if(tipo_inundacao == null) return null;
                String descricao = inundacao_painel.getDescricao();
                boolean ativo = inundacao_painel.isAtivo();
                catastrofe = new Inundacao(sequencial, nome, data, localizacao, tipo_inundacao, descricao, ativo);
                break;
            case 1:
                TipoQueimada tipo_queimada = queimada_painel.getSelectedTipoQueimada(); 
                if(tipo_queimada == null) return null;
                descricao = queimada_painel.getDescricao();
                boolean ativo1 = queimada_painel.isAtivo();
                catastrofe = new Queimada(sequencial, nome, data, localizacao, tipo_queimada, descricao, ativo1);
                break;
            case 2:
                TipoVazamentoNuclear tipo_vazamento_nuclear = vazamento_nuclear_painel.getSelectedVazamentoNuclear();
                if(tipo_vazamento_nuclear == null) return null;
                descricao = vazamento_nuclear_painel.getDescricao();
                boolean ativo2 = vazamento_nuclear_painel.isAtivo();
                catastrofe = new VazamentoNuclear(sequencial, nome, data, localizacao, tipo_vazamento_nuclear, descricao, ativo2);
                break;
        }
        return catastrofe;
    }
    private Catastrofe getVisaoAlterada(Integer sequencial) {
        for (Catastrofe visao : catastrofes_cadastradas) {
            if (visao.getSequencial().equals(sequencial)) {
                return visao;
            }
        }
        return null;
    }
    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastroPanel = new javax.swing.JPanel();
        catastrofesCadastradasLabel = new javax.swing.JLabel();
        sequencialLabel = new javax.swing.JLabel();
        sequencialTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        dataLabel = new javax.swing.JLabel();
        dataTextField = new javax.swing.JTextField();
        localizacaoLabel = new javax.swing.JLabel();
        localizacaoTextField = new javax.swing.JTextField();
        catastrofes_cadComboBox = new javax.swing.JComboBox();
        comandosPanel = new javax.swing.JPanel();
        inserirCatastrofeButton = new javax.swing.JButton();
        consultarCatastrofesButton = new javax.swing.JButton();
        alterarCatastrofesButton = new javax.swing.JButton();
        removerCatastrofesButton = new javax.swing.JButton();
        limpaCamposButton = new javax.swing.JButton();
        catastrofeTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Catastrofe");
        setMaximumSize(null);

        cadastroPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        cadastroPanel.setPreferredSize(new java.awt.Dimension(450, 300));

        catastrofesCadastradasLabel.setText("Catastrofes Cadastradas");
        catastrofesCadastradasLabel.setMaximumSize(null);
        catastrofesCadastradasLabel.setMinimumSize(null);

        sequencialLabel.setText("Sequencial");
        sequencialLabel.setMaximumSize(null);
        sequencialLabel.setMinimumSize(null);

        sequencialTextField.setEditable(false);
        sequencialTextField.setMaximumSize(null);
        sequencialTextField.setMinimumSize(null);
        sequencialTextField.setPreferredSize(null);

        nomeLabel.setText("Nome");
        nomeLabel.setMaximumSize(null);
        nomeLabel.setMinimumSize(null);

        nomeTextField.setMaximumSize(null);
        nomeTextField.setMinimumSize(null);
        nomeTextField.setName(""); // NOI18N
        nomeTextField.setPreferredSize(null);

        dataLabel.setText("Data");
        dataLabel.setMaximumSize(null);
        dataLabel.setMinimumSize(null);

        dataTextField.setMaximumSize(null);
        dataTextField.setMinimumSize(null);
        dataTextField.setPreferredSize(new java.awt.Dimension(15, 22));

        localizacaoLabel.setText("Localização");
        localizacaoLabel.setMaximumSize(null);
        localizacaoLabel.setMinimumSize(null);

        localizacaoTextField.setMaximumSize(null);
        localizacaoTextField.setMinimumSize(null);
        localizacaoTextField.setPreferredSize(new java.awt.Dimension(100, 22));

        catastrofes_cadComboBox.setModel(new DefaultComboBoxModel(catastrofes_cadastradas));

        javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
        cadastroPanel.setLayout(cadastroPanelLayout);
        cadastroPanelLayout.setHorizontalGroup(
            cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanelLayout.createSequentialGroup()
                        .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addComponent(localizacaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(localizacaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastroPanelLayout.createSequentialGroup()
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastroPanelLayout.createSequentialGroup()
                                        .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastroPanelLayout.createSequentialGroup()
                                        .addComponent(catastrofesCadastradasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(catastrofes_cadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26))
                    .addGroup(cadastroPanelLayout.createSequentialGroup()
                        .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addComponent(dataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addComponent(sequencialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        cadastroPanelLayout.setVerticalGroup(
            cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catastrofesCadastradasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catastrofes_cadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sequencialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localizacaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localizacaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        inserirCatastrofeButton.setText("Inserir");
        inserirCatastrofeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirCatastrofeButton(evt);
            }
        });
        comandosPanel.add(inserirCatastrofeButton);

        consultarCatastrofesButton.setText("Consultar");
        consultarCatastrofesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarCatastrofesButton(evt);
            }
        });
        comandosPanel.add(consultarCatastrofesButton);

        alterarCatastrofesButton.setText("Alterar");
        alterarCatastrofesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarCatastrofesButton(evt);
            }
        });
        comandosPanel.add(alterarCatastrofesButton);

        removerCatastrofesButton.setText("Remover");
        removerCatastrofesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerCatastrofesButton(evt);
            }
        });
        comandosPanel.add(removerCatastrofesButton);

        limpaCamposButton.setText("Limpar");
        limpaCamposButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpaCamposButton(evt);
            }
        });
        comandosPanel.add(limpaCamposButton);

        catastrofeTabbedPane.setMaximumSize(null);
        catastrofeTabbedPane.setPreferredSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comandosPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cadastroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(catastrofeTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(catastrofeTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirCatastrofeButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirCatastrofeButton
        Catastrofe catastrofe = obterCatastrofeInformado();
        String mensagem_erro = null;
        if (catastrofe != null) {
            mensagem_erro = controlador.inserirCatastrofe(catastrofe);
        } else {
            mensagem_erro = "Algum atributo da queimada não foi informado";
        }

        if (mensagem_erro == null) {
            int sequencial = Catastrofe.ultimoSequencial();
            catastrofe.setSequencial(sequencial);
            Catastrofe visao = catastrofe.getVisao();
            catastrofes_cadComboBox.addItem(visao);
            catastrofes_cadComboBox.setSelectedItem(catastrofes_cadComboBox.getItemAt(catastrofes_cadComboBox.getItemCount() - 1));
            limparCampos();
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_inserirCatastrofeButton

    private void consultarCatastrofesButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarCatastrofesButton
        Catastrofe visao = (Catastrofe) catastrofes_cadComboBox.getSelectedItem();
        Catastrofe catastrofe = null;
        String mensagem_erro = null;
        if (visao != null) {
            catastrofe = Catastrofe.buscarCatastrofe(visao.getSequencial());
            if (catastrofe == null)mensagem_erro = "Catastrofe não cadastrada";
        } else mensagem_erro = "Nenhuma Catastrofe selecionada";
        if (mensagem_erro == null) {
            sequencialTextField.setText(catastrofe.getSequencial() + "");
            nomeTextField.setText(catastrofe.getNome());
            dataTextField.setText(catastrofe.getData());
            localizacaoTextField.setText(catastrofe.getLocalizacao());
        }else informarErro(mensagem_erro);
        if (catastrofe instanceof Inundacao) {
            catastrofeTabbedPane.setSelectedIndex(0);
            Inundacao inundacao = (Inundacao) catastrofe;
            inundacao_painel.setSelectedTipoInundacao(inundacao.getTipoInundacao());
            inundacao_painel.setDescricao(inundacao.getDescricao());
            inundacao_painel.setAtivo(inundacao.isAtivo());

        } else if (catastrofe instanceof Queimada) {
            catastrofeTabbedPane.setSelectedIndex(1);
            Queimada queimada = (Queimada) catastrofe;
            queimada_painel.setSelectedTipoQueimada(queimada.getTipoQueimada());
            queimada_painel.setDescricao(queimada.getDescricao());
            queimada_painel.setAtivo(queimada.isAtivo());
        } else if (catastrofe instanceof VazamentoNuclear) {
            catastrofeTabbedPane.setSelectedIndex(2);
            VazamentoNuclear vazamento_nuclear = (VazamentoNuclear) catastrofe;
            vazamento_nuclear_painel.setSelectedVazamentoNuclear(vazamento_nuclear.getTipoVazamentoNuclear());
            vazamento_nuclear_painel.setDescricao(vazamento_nuclear.getDescricao());
            vazamento_nuclear_painel.setAtivo(vazamento_nuclear.isAtivo());
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarCatastrofesButton

    private void alterarCatastrofesButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarCatastrofesButton
        Catastrofe catastrofe = obterCatastrofeInformado();
        String mensagem_erro = null;
        if (catastrofe != null) {
            mensagem_erro = controlador.alterarCatastrofe(catastrofe);
        } else {
            mensagem_erro = "Algum atributo do evento não foi informado";
        }
        if (mensagem_erro == null) {
            Catastrofe visao = getVisaoAlterada(catastrofe.getSequencial());
            if (visao != null) {
                visao.setNome(catastrofe.getNome());
                catastrofes_cadComboBox.updateUI();
                catastrofes_cadComboBox.setSelectedItem(visao);
            }
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_alterarCatastrofesButton

    private void removerCatastrofesButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerCatastrofesButton
       Catastrofe visao = (Catastrofe) catastrofes_cadComboBox.getSelectedItem();
       String mensagem_erro = null;
        if (visao != null) {
            mensagem_erro = controlador.removerCatastrofe(visao.getSequencial());
            limparCampos();
        } else {
            mensagem_erro = "Nenhuma queimada cadastrada";
        }
        if (mensagem_erro == null) {
            catastrofes_cadComboBox.removeItem(visao);
            if (catastrofes_cadastradas.length > 1) {
                catastrofes_cadComboBox.setSelectedIndex(0);
            } else {
                catastrofes_cadComboBox.setSelectedIndex(-1);
            }
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_removerCatastrofesButton

    private void limpaCamposButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpaCamposButton
        inundacao_painel.limparCampos();
        queimada_painel.limparCampos();
        vazamento_nuclear_painel.limparCampos();
        limparCampos();
    }//GEN-LAST:event_limpaCamposButton

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarCatastrofesButton;
    private javax.swing.JPanel cadastroPanel;
    private javax.swing.JTabbedPane catastrofeTabbedPane;
    private javax.swing.JLabel catastrofesCadastradasLabel;
    private javax.swing.JComboBox catastrofes_cadComboBox;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarCatastrofesButton;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JTextField dataTextField;
    private javax.swing.JButton inserirCatastrofeButton;
    private javax.swing.JButton limpaCamposButton;
    private javax.swing.JLabel localizacaoLabel;
    private javax.swing.JTextField localizacaoTextField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton removerCatastrofesButton;
    private javax.swing.JLabel sequencialLabel;
    private javax.swing.JTextField sequencialTextField;
    // End of variables declaration//GEN-END:variables
}
