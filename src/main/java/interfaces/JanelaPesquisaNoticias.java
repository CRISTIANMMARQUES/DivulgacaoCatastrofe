
package interfaces;

import entidade.AgenciaNoticia;
import entidade.Catastrofe;
import entidade.Noticia;
import entidade.Queimada.TipoQueimada;
import entidade.VazamentoNuclear.TipoVazamentoNuclear;
import interfaces.PainelFiltroInundacao;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class JanelaPesquisaNoticias extends javax.swing.JFrame {
    
    AgenciaNoticia[] agencia_noticias_cadastradas;
    Catastrofe[] catastrofes_cadastradas;
    PainelFiltroInundacao filtro_inundacaoPainel;
    PainelFiltroQueimada filtro_queimadaPainel;
    PainelFiltroVazamentoNuclear filtro_vazamento_nuclearPainel;
    
    public JanelaPesquisaNoticias() {
        agencia_noticias_cadastradas = AgenciaNoticia.getVisoes();
        catastrofes_cadastradas = Catastrofe.getVisoes();
        initComponents();
        catastrofes_cadastradasComboBox.setSelectedIndex(-1);
        agencia_noticiasComboBox.setSelectedIndex(-1);
        filtro_inundacaoPainel = new PainelFiltroInundacao();
        filtro_queimadaPainel = new PainelFiltroQueimada();
        filtro_vazamento_nuclearPainel = new PainelFiltroVazamentoNuclear();
        filtro_noticiasTabbedPane.addTab("Filtro de Inundação", filtro_inundacaoPainel);
        filtro_noticiasTabbedPane.addTab("Filtro de Queimada", filtro_queimadaPainel);
        filtro_noticiasTabbedPane.addTab("Filtro de Vazamento Nuclear", filtro_vazamento_nuclearPainel);
    }
    
    private Timestamp getDataMinima(){
        Timestamp data_minima = null;
        String data_minima_str = data_minima_noticiaTextField.getText();
        if (!data_minima_str.isEmpty()) {
            String[] data_minima_partes = data_minima_str.split("/");
            String dia = data_minima_partes[0];
            String mes = data_minima_partes[1];
            String ano = data_minima_partes[2];
            if ((dia.length() == 2) && (mes.length() == 2) && (ano.length() == 4)) {
                data_minima_str = ano + "-" + mes + "-" + dia + " 00:00:00"; // Adiciona espaço e hora
                data_minima = Timestamp.valueOf(data_minima_str);
            }
        }
        return data_minima;
    }
    
    private void mostrarNoticiasSelecionadas(ArrayList<Noticia> noticias){
        boolean primeira_noticia = true;
        
        for(Noticia noticia: noticias){
            if(primeira_noticia){
                pesquisasTextArea.append(noticia.toStringFull());
                primeira_noticia = false;
            }else pesquisasTextArea.append("\n"+noticia.toStringFull());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grau_urgenciabuttonGroup = new javax.swing.ButtonGroup();
        comandosPanel = new javax.swing.JPanel();
        limparFiltros = new javax.swing.JButton();
        limparNoticiasSelecionadas = new javax.swing.JButton();
        pesquisarNoticiaButton = new javax.swing.JButton();
        filtro_noticiasTabbedPane = new javax.swing.JTabbedPane();
        filtro_catastrofePanel = new javax.swing.JPanel();
        catastrofes_cadastradasComboBox = new javax.swing.JComboBox<>();
        catastrofes_cadastradasLabel = new javax.swing.JLabel();
        filtro_agencias_noticiasPanel = new javax.swing.JPanel();
        agencia_noticiasLabel = new javax.swing.JLabel();
        agencia_noticiasComboBox = new javax.swing.JComboBox<>();
        filtroNoticiasPanel = new javax.swing.JPanel();
        grau_urgenciaLabel = new javax.swing.JLabel();
        baixoRadioButton = new javax.swing.JRadioButton();
        medioRadioButton = new javax.swing.JRadioButton();
        urgenteRadioButton = new javax.swing.JRadioButton();
        data_minimaLabel = new javax.swing.JLabel();
        data_minima_noticiaTextField = new javax.swing.JTextField();
        avaliacoesSelecionadasPanel = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        pesquisasTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        limparFiltros.setText("Limpar Filtros");
        limparFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFiltros(evt);
            }
        });
        comandosPanel.add(limparFiltros);

        limparNoticiasSelecionadas.setText("Limpar Noticias Selecionadas");
        limparNoticiasSelecionadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparNoticiasSelecionadas(evt);
            }
        });
        comandosPanel.add(limparNoticiasSelecionadas);

        pesquisarNoticiaButton.setText("Pesquisar");
        pesquisarNoticiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarNoticia(evt);
            }
        });
        comandosPanel.add(pesquisarNoticiaButton);

        filtro_noticiasTabbedPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filtro_catastrofePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Catastrofe"));

        catastrofes_cadastradasComboBox.setModel(new DefaultComboBoxModel(catastrofes_cadastradas));

        catastrofes_cadastradasLabel.setText("Catastrofes");

        javax.swing.GroupLayout filtro_catastrofePanelLayout = new javax.swing.GroupLayout(filtro_catastrofePanel);
        filtro_catastrofePanel.setLayout(filtro_catastrofePanelLayout);
        filtro_catastrofePanelLayout.setHorizontalGroup(
            filtro_catastrofePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtro_catastrofePanelLayout.createSequentialGroup()
                .addComponent(catastrofes_cadastradasLabel)
                .addGap(18, 18, 18)
                .addComponent(catastrofes_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        filtro_catastrofePanelLayout.setVerticalGroup(
            filtro_catastrofePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtro_catastrofePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(filtro_catastrofePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catastrofes_cadastradasLabel)
                    .addComponent(catastrofes_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        filtro_agencias_noticiasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Agencia Noticia"));

        agencia_noticiasLabel.setText("Agencias Noticias");

        agencia_noticiasComboBox.setModel(new DefaultComboBoxModel(agencia_noticias_cadastradas));

        javax.swing.GroupLayout filtro_agencias_noticiasPanelLayout = new javax.swing.GroupLayout(filtro_agencias_noticiasPanel);
        filtro_agencias_noticiasPanel.setLayout(filtro_agencias_noticiasPanelLayout);
        filtro_agencias_noticiasPanelLayout.setHorizontalGroup(
            filtro_agencias_noticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtro_agencias_noticiasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agencia_noticiasLabel)
                .addGap(18, 18, 18)
                .addComponent(agencia_noticiasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        filtro_agencias_noticiasPanelLayout.setVerticalGroup(
            filtro_agencias_noticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtro_agencias_noticiasPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(filtro_agencias_noticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agencia_noticiasLabel)
                    .addComponent(agencia_noticiasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        filtroNoticiasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Noticia"));
        filtroNoticiasPanel.setToolTipText("Teste");

        grau_urgenciaLabel.setText("Grau Urgencia");

        grau_urgenciabuttonGroup.add(baixoRadioButton);
        baixoRadioButton.setMnemonic('B');
        baixoRadioButton.setText("Baixo");

        grau_urgenciabuttonGroup.add(medioRadioButton);
        medioRadioButton.setMnemonic('M');
        medioRadioButton.setText("Medio");

        grau_urgenciabuttonGroup.add(urgenteRadioButton);
        urgenteRadioButton.setMnemonic('U');
        urgenteRadioButton.setText("Urgente");

        data_minimaLabel.setText("Data Mínima");

        javax.swing.GroupLayout filtroNoticiasPanelLayout = new javax.swing.GroupLayout(filtroNoticiasPanel);
        filtroNoticiasPanel.setLayout(filtroNoticiasPanelLayout);
        filtroNoticiasPanelLayout.setHorizontalGroup(
            filtroNoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtroNoticiasPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(filtroNoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtroNoticiasPanelLayout.createSequentialGroup()
                        .addComponent(grau_urgenciaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(baixoRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(medioRadioButton)
                        .addGap(39, 39, 39)
                        .addComponent(urgenteRadioButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtroNoticiasPanelLayout.createSequentialGroup()
                        .addComponent(data_minimaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(data_minima_noticiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        filtroNoticiasPanelLayout.setVerticalGroup(
            filtroNoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtroNoticiasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtroNoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grau_urgenciaLabel)
                    .addComponent(baixoRadioButton)
                    .addComponent(medioRadioButton)
                    .addComponent(urgenteRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(filtroNoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data_minimaLabel)
                    .addComponent(data_minima_noticiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        avaliacoesSelecionadasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliações Selecionadas"));

        pesquisasTextArea.setColumns(20);
        pesquisasTextArea.setRows(5);
        ScrollPane.setViewportView(pesquisasTextArea);

        javax.swing.GroupLayout avaliacoesSelecionadasPanelLayout = new javax.swing.GroupLayout(avaliacoesSelecionadasPanel);
        avaliacoesSelecionadasPanel.setLayout(avaliacoesSelecionadasPanelLayout);
        avaliacoesSelecionadasPanelLayout.setHorizontalGroup(
            avaliacoesSelecionadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avaliacoesSelecionadasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );
        avaliacoesSelecionadasPanelLayout.setVerticalGroup(
            avaliacoesSelecionadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avaliacoesSelecionadasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comandosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(filtro_catastrofePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filtroNoticiasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filtro_agencias_noticiasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filtro_noticiasTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(avaliacoesSelecionadasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filtro_catastrofePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro_agencias_noticiasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filtro_noticiasTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(filtroNoticiasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avaliacoesSelecionadasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparFiltros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFiltros
        catastrofes_cadastradasComboBox.setSelectedIndex(-1);
        agencia_noticiasComboBox.setSelectedIndex(-1);
        grau_urgenciabuttonGroup.clearSelection();
        filtro_inundacaoPainel.limparFiltro();
        filtro_queimadaPainel.limparFiltros();
        filtro_vazamento_nuclearPainel.limparFiltros();
        data_minima_noticiaTextField.setText("");
    }//GEN-LAST:event_limparFiltros

    private void limparNoticiasSelecionadas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparNoticiasSelecionadas

        pesquisasTextArea.setText("");
        
    }//GEN-LAST:event_limparNoticiasSelecionadas

    private void pesquisarNoticia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarNoticia
        
        int chave_catastrofe = -1;
        if(catastrofes_cadastradasComboBox.getSelectedItem() != null)
            chave_catastrofe = ((Catastrofe) catastrofes_cadastradasComboBox.getSelectedItem()).getSequencial();
        
        String chave_agencia_noticia = null;
        if(agencia_noticiasComboBox.getSelectedItem() != null)
            chave_agencia_noticia = ((AgenciaNoticia) agencia_noticiasComboBox.getSelectedItem()).getCnpj();
        
        char grau_urgencia = 'X';
        if(grau_urgenciabuttonGroup.getSelection() != null){grau_urgencia = (char) grau_urgenciabuttonGroup.getSelection().getMnemonic();}
        
        char inundacao_ativo = 'X';
        
        TipoQueimada tipo_queimada_enum = null;
        
        TipoVazamentoNuclear tipo_vazamento_nuclear = null;
        
        int indice_aba_selecionada = filtro_noticiasTabbedPane.getSelectedIndex();
        
        if(indice_aba_selecionada == 0){
            inundacao_ativo = filtro_inundacaoPainel.getInundacaoAtiva();
        }else 
            if(indice_aba_selecionada == 1){
            tipo_queimada_enum = filtro_queimadaPainel.getSelectedTipoQueimada();
        }else 
                if(indice_aba_selecionada == 2){
            tipo_vazamento_nuclear = filtro_vazamento_nuclearPainel.getSelectedTipoVazamentoNuclear();
        }
        
        Timestamp data_minima = getDataMinima();
        
        ArrayList<Noticia> noticias = Noticia.pesquisaNoticia(chave_agencia_noticia, chave_catastrofe, grau_urgencia, 
                inundacao_ativo, tipo_queimada_enum, tipo_vazamento_nuclear, data_minima);
        
        mostrarNoticiasSelecionadas(noticias);
    }//GEN-LAST:event_pesquisarNoticia

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JComboBox<String> agencia_noticiasComboBox;
    private javax.swing.JLabel agencia_noticiasLabel;
    private javax.swing.JPanel avaliacoesSelecionadasPanel;
    private javax.swing.JRadioButton baixoRadioButton;
    private javax.swing.JComboBox<String> catastrofes_cadastradasComboBox;
    private javax.swing.JLabel catastrofes_cadastradasLabel;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JLabel data_minimaLabel;
    private javax.swing.JTextField data_minima_noticiaTextField;
    private javax.swing.JPanel filtroNoticiasPanel;
    private javax.swing.JPanel filtro_agencias_noticiasPanel;
    private javax.swing.JPanel filtro_catastrofePanel;
    private javax.swing.JTabbedPane filtro_noticiasTabbedPane;
    private javax.swing.JLabel grau_urgenciaLabel;
    private javax.swing.ButtonGroup grau_urgenciabuttonGroup;
    private javax.swing.JButton limparFiltros;
    private javax.swing.JButton limparNoticiasSelecionadas;
    private javax.swing.JRadioButton medioRadioButton;
    private javax.swing.JButton pesquisarNoticiaButton;
    private javax.swing.JTextArea pesquisasTextArea;
    private javax.swing.JRadioButton urgenteRadioButton;
    // End of variables declaration//GEN-END:variables
}
