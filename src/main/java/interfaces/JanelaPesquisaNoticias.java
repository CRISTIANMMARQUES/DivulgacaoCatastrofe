
package interfaces;

import entidade.AgenciaNoticia;
import entidade.Catastrofe;
import interfaces.PainelFiltroInundacao;

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
        filtro_inundacaoPainel = new PainelFiltroInundacao();
        filtro_queimadaPainel = new PainelFiltroQueimada();
        filtro_vazamento_nuclearPainel = new PainelFiltroVazamentoNuclear();
        filtro_noticiasTabbedPane.addTab("Filtro de Inundação", filtro_inundacaoPainel);
        filtro_noticiasTabbedPane.addTab("Filtro de Queimada", filtro_queimadaPainel);
        filtro_noticiasTabbedPane.addTab("Filtro de Vazamento Nuclear", filtro_vazamento_nuclearPainel);
//        limparFiltros(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grau_urgenciabuttonGroup = new javax.swing.ButtonGroup();
        comandosPanel = new javax.swing.JPanel();
        limpar_FiltrosButton = new javax.swing.JButton();
        limpar_noticias_selecionadasButton = new javax.swing.JButton();
        filtro_noticiasTabbedPane = new javax.swing.JTabbedPane();
        filtro_catastrofePanel = new javax.swing.JPanel();
        catastrofes_cadastradasComboBox = new javax.swing.JComboBox<>();
        catastrofes_cadastradasLabel = new javax.swing.JLabel();
        filtro_agencias_noticiasPanel = new javax.swing.JPanel();
        agencia_noticiasLabel = new javax.swing.JLabel();
        agencia_noticiasComboBox = new javax.swing.JComboBox<>();
        ScrollPane = new javax.swing.JScrollPane();
        pesquisasTextArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        baixoRadioButton = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        limpar_FiltrosButton.setText("Limpar Filtros");
        limpar_FiltrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpar_FiltrosButton(evt);
            }
        });

        limpar_noticias_selecionadasButton.setText("Limpar Noticias Selecionadas");
        limpar_noticias_selecionadasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpar_noticias_selecionadasButton(evt);
            }
        });

        javax.swing.GroupLayout comandosPanelLayout = new javax.swing.GroupLayout(comandosPanel);
        comandosPanel.setLayout(comandosPanelLayout);
        comandosPanelLayout.setHorizontalGroup(
            comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comandosPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(limpar_FiltrosButton)
                .addGap(18, 18, 18)
                .addComponent(limpar_noticias_selecionadasButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        comandosPanelLayout.setVerticalGroup(
            comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comandosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpar_FiltrosButton)
                    .addComponent(limpar_noticias_selecionadasButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        filtro_noticiasTabbedPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filtro_catastrofePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Catastrofe"));

        catastrofes_cadastradasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        agencia_noticiasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout filtro_agencias_noticiasPanelLayout = new javax.swing.GroupLayout(filtro_agencias_noticiasPanel);
        filtro_agencias_noticiasPanel.setLayout(filtro_agencias_noticiasPanelLayout);
        filtro_agencias_noticiasPanelLayout.setHorizontalGroup(
            filtro_agencias_noticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtro_agencias_noticiasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agencia_noticiasLabel)
                .addGap(18, 18, 18)
                .addComponent(agencia_noticiasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        pesquisasTextArea.setColumns(20);
        pesquisasTextArea.setRows(5);
        ScrollPane.setViewportView(pesquisasTextArea);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Noticia"));
        jPanel1.setToolTipText("Teste");

        jLabel1.setText("Grau Urgencia");

        grau_urgenciabuttonGroup.add(baixoRadioButton);
        baixoRadioButton.setText("Baixo");

        grau_urgenciabuttonGroup.add(jRadioButton2);
        jRadioButton2.setText("Medio");

        grau_urgenciabuttonGroup.add(jRadioButton3);
        jRadioButton3.setText("Urgente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(baixoRadioButton)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(39, 39, 39)
                .addComponent(jRadioButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(baixoRadioButton)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comandosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(filtro_agencias_noticiasPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filtro_catastrofePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filtro_noticiasTabbedPane)
                    .addComponent(ScrollPane)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(filtro_catastrofePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtro_agencias_noticiasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtro_noticiasTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpar_FiltrosButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar_FiltrosButton
        catastrofes_cadastradasComboBox.setSelectedIndex(-1);
        agencia_noticiasComboBox.setSelectedIndex(-1);
        filtro_inundacaoPainel.limparFiltro();
        filtro_queimadaPainel.limparFiltros();
        filtro_vazamento_nuclearPainel.limparFiltros();
    }//GEN-LAST:event_limpar_FiltrosButton

    private void limpar_noticias_selecionadasButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar_noticias_selecionadasButton
        // TODO add your handling code here:
        pesquisasTextArea.setText("");
    }//GEN-LAST:event_limpar_noticias_selecionadasButton

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JComboBox<String> agencia_noticiasComboBox;
    private javax.swing.JLabel agencia_noticiasLabel;
    private javax.swing.JRadioButton baixoRadioButton;
    private javax.swing.JComboBox<String> catastrofes_cadastradasComboBox;
    private javax.swing.JLabel catastrofes_cadastradasLabel;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JPanel filtro_agencias_noticiasPanel;
    private javax.swing.JPanel filtro_catastrofePanel;
    private javax.swing.JTabbedPane filtro_noticiasTabbedPane;
    private javax.swing.ButtonGroup grau_urgenciabuttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JButton limpar_FiltrosButton;
    private javax.swing.JButton limpar_noticias_selecionadasButton;
    private javax.swing.JTextArea pesquisasTextArea;
    // End of variables declaration//GEN-END:variables
}
