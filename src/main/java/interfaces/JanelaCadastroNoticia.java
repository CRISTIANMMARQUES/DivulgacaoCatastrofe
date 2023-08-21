
package interfaces;

import controle.ControladorCadastroNoticias;
import entidade.AgenciaNoticia;
import entidade.Catastrofe;
import entidade.Noticia;
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
        Noticia[] visoes = Noticia.getVisoes();
        for (Noticia visao : visoes) {
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
        dataHoraTextField.setText("");
    }
    
    private AgenciaNoticia getVisaoAgenciaNoticiaSelecionada(Noticia noticia) {
        // Lógica para obter a visão de agência de notícia selecionada com base na notícia
        AgenciaNoticia[] visoesAgencia = AgenciaNoticia.getVisoes();

        // Aqui você deve percorrer as visões para encontrar a correspondente à agência de notícia da notícia
        for (AgenciaNoticia visaoAgencia : visoesAgencia) {
            // Suponhamos que a notícia tenha uma referência para a agência de notícia associada:
            if (noticia.getAgenciaNoticia().getCnpj().equals(visaoAgencia.getCnpj())) {
                System.out.println(visaoAgencia);
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
                System.out.println(visaoCatastrofe);
                return visaoCatastrofe;
            }
        }

        return null; // Caso não seja encontrada uma correspondência
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
        agencias_cadastradasComboBox = new javax.swing.JComboBox<>();
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
        setPreferredSize(new java.awt.Dimension(700, 700));

        noticias_cadastradasLabel.setText("Notícias Cadastradas");

        noticias_cadastradasList.setModel(new DefaultListModel ());
        noticias_cadastradasScrollPane.setViewportView(noticias_cadastradasList);

        sequencialLabel.setText("Notícia");

        sequencialTextField.setEditable(false);
        sequencialTextField.setMaximumSize(null);
        sequencialTextField.setName(""); // NOI18N
        sequencialTextField.setPreferredSize(new java.awt.Dimension(110, 22));

        agencia_noticiaLabel.setText("Agencia de Notícia");

        catastrofesLabel.setText("Catastrofes");

        agencias_cadastradasComboBox.setModel(new DefaultComboBoxModel(agencias_cadastradas));

        catastrofes_cadastradasComboBox.setModel(new DefaultComboBoxModel(Catastrofe.getVisoes()));

        grau_urgenciaLabel.setText("Grau de Urgencia");

        grau_urgenciabuttonGroup.add(urgenteRadioButton);
        urgenteRadioButton.setMnemonic('U');
        urgenteRadioButton.setText("Urgente");

        grau_urgenciabuttonGroup.add(medioRadioButton);
        medioRadioButton.setMnemonic('M');
        medioRadioButton.setText("Medio");

        grau_urgenciabuttonGroup.add(baixoRadioButton);
        baixoRadioButton.setMnemonic('B');
        baixoRadioButton.setText("Baixo");

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
        limparCamposButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposButtonActionPerformed(evt);
            }
        });
        comandosPanel.add(limparCamposButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(noticias_cadastradasLabel)
                        .addGap(6, 6, 6)
                        .addComponent(noticias_cadastradasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(sequencialLabel)
                        .addGap(80, 80, 80)
                        .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(agencia_noticiaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(agencias_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(catastrofesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(catastrofes_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(grau_urgenciaLabel)
                        .addGap(27, 27, 27)
                        .addComponent(baixoRadioButton)
                        .addGap(8, 8, 8)
                        .addComponent(medioRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(urgenteRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(descricaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(descricaoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(dataHoraLabel)
                        .addGap(42, 42, 42)
                        .addComponent(dataHoraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(noticias_cadastradasLabel))
                    .addComponent(noticias_cadastradasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(sequencialLabel))
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(agencia_noticiaLabel))
                    .addComponent(agencias_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(catastrofesLabel))
                    .addComponent(catastrofes_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(grau_urgenciaLabel))
                    .addComponent(baixoRadioButton)
                    .addComponent(medioRadioButton)
                    .addComponent(urgenteRadioButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(descricaoLabel))
                    .addComponent(descricaoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(dataHoraLabel))
                    .addComponent(dataHoraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
                sequencialTextField.setText(visao.getSequencial() + "");
                agencias_cadastradasComboBox.setSelectedItem(getVisaoAgenciaNoticiaSelecionada(noticia));
                
                catastrofes_cadastradasComboBox.setSelectedItem(getVisaoCatastrofeSelecionada(noticia));
                String descricao = noticia.getDescricao();
                if (descricao == null) {
                    descricao = "";
                }else{
                    descricaoTextArea.setText(noticia.getDescricao());
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
        Object selectedValue = noticias_cadastradasList.getSelectedValue();
        String mensagem_erro = null;
        Noticia noticia = null;
        if (selectedValue instanceof Noticia) {
            Noticia visao = (Noticia) selectedValue;
            if (visao != null) {
                noticia = Noticia.buscarNoticias(visao.getSequencial());
                mensagem_erro = controlador.removerNoticia(noticia.getSequencial());
                if (noticia == null) {
                    mensagem_erro = "Noticia não cadastrado";
                }
            } else {
                mensagem_erro = "Nenhuma Noticia selecionada";
            }
            if (mensagem_erro == null) {
                modelo_lista_noticia.removeElement(visao);
                limparCampos();
            } else {
                informarErro(mensagem_erro);
            }
        } else {
            mensagem_erro = "Selected Value não é uma instancia de Noticia";
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_removerNoticiaButton

    private void limparCamposButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposButtonActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_limparCamposButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agencia_noticiaLabel;
    private javax.swing.JComboBox<String> agencias_cadastradasComboBox;
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
