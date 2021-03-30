/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import compartilhamento.Global;
import services.PalavraService;

/**
 *
 * @author Tiago Enriquez Tachy
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private boolean configuracaoAberta = false;
    private PalavraService palavraService;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        this.palavraService = new PalavraService();
        initComponents();
        setLocationRelativeTo(this);
        inserirIcone();
        setLocationRelativeTo(buttonJogar);
    }

    /**
     * Informa o fechamento da tela de configuração.
     */
    public void fecharConfiguracao() {
        configuracaoAberta = false;
    }

    /**
     * Aciona o método que insere o ícone na barra de título.
     *
     * @throws Exception
     */
    private void inserirIcone() {
        try {
            new Global().logo(this);
        } catch (Exception exception) {
            Mensagem.erro(exception.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        buttonJogar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Forca");
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 191, 128));
        jPanel1.setPreferredSize(new java.awt.Dimension(2000, 1000));
        jPanel1.setRequestFocusEnabled(false);

        buttonJogar.setText("Entre no jogo");
        buttonJogar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jogar(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(buttonJogar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1737, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(buttonJogar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(855, Short.MAX_VALUE))
        );

        desktopPane.add(jPanel1);
        jPanel1.setBounds(0, 0, 2000, 1000);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Configuração");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Configuração de palavras");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configurar(evt);
            }
        });
        fileMenu.add(openMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acessa a janela de opção de jogo.
     *
     * @param evt
     */
    private void jogar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jogar
        boolean opcaoValida = false;
        while (!opcaoValida) {
            String opcao = Mensagem.selecionarJogo();
            if ("Digitar palavra".equals(opcao)) {
                new TelaJogo(Mensagem.resposta("Digite uma palavra para seu amigo tentar adivinhar.")).setVisible(true);
                this.dispose();
                opcaoValida = true;
            } else if ("Palavra aleatória".equals(opcao)) {
                try {
                    new TelaJogo(palavraService.sortear()).setVisible(true);
                    this.dispose();
                    opcaoValida = true;
                } catch (Exception exception) {
                    Mensagem.erro(exception.getMessage());
                }
                opcaoValida = true;
            } else {
                Mensagem.erro("Opção invalida");
            }
        }
    }//GEN-LAST:event_jogar

    /**
     * Abre a tela de configuração para inserção e correção de palavras no banco
     * de dados.
     *
     * @param evt
     */
    private void configurar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configurar
        if (!configuracaoAberta) {
            new TelaConfiguracao(this, null).setVisible(true);
            configuracaoAberta = true;
        }
    }//GEN-LAST:event_configurar

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonJogar;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    // End of variables declaration//GEN-END:variables

}
