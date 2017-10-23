
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Entrar
 */
public class DIUImageThreshold extends javax.swing.JFrame {
    private ThresholdDialog th;

    /**
     * Creates new form DIUImageThreshold
     */
    public DIUImageThreshold() {
        initComponents();
        try {
            setIconImage(ImageIO.read(new File("./src/icons/ulpgc.png")));
        } catch (IOException ex) {
            Logger.getLogger(DIUImageThreshold.class.getName()).log(Level.SEVERE, null, ex);
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

        imagePanel = new ImagePanel();
        MenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editorMenu = new javax.swing.JMenu();
        editMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DIUshop");
        setIconImages(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setBackground(new java.awt.Color(255, 255, 255));
        openMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open_2.png"))); // NOI18N
        openMenuItem.setMnemonic('c');
        openMenuItem.setText("Open...");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        saveMenuItem.setText("Save...");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);
        fileMenu.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitMenuItem.setText("Exit...");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        MenuBar.add(fileMenu);

        editorMenu.setText("Edit");

        editMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        editMenuItem.setText("Apply Threshold...");
        editMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuItemActionPerformed(evt);
            }
        });
        editorMenu.add(editMenuItem);

        MenuBar.add(editorMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setText("About us...");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        MenuBar.add(helpMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        JFileChooser fc = new JFileChooser(".");
        fc.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));
        int open = fc.showOpenDialog(rootPane);
        if (open == JFileChooser.APPROVE_OPTION) {
            imagePanel.setImage(fc.getSelectedFile());
            this.setSize(imagePanel.getWidth(), imagePanel.getHeight());
        }
        if (th != null) {
            th.dispose();
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        if (imagePanel.getImage() == null) {
            JOptionPane.showMessageDialog(rootPane,
                    "No hay imagen cargada",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        JFileChooser fc = new JFileChooser(".");
        int save = fc.showSaveDialog(rootPane);
        if (save == JFileChooser.APPROVE_OPTION) {
            BufferedImage image = imagePanel.getImage();
            File file = fc.getSelectedFile();
            try {
                ImageIO.write(image, "jpg", file);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane,
                        "No se pudo guardar la imagen",
                        "error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        exitConfirmationDialog();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exitConfirmationDialog();
    }//GEN-LAST:event_formWindowClosing

    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed
        if (imagePanel.getImage() == null) {
            JOptionPane.showMessageDialog(rootPane,
                    "No hay imagen cargada",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        th = new ThresholdDialog(this, false);
        th.setLocation(this.getWidth(), 0);
        th.setVisible(true);
    }//GEN-LAST:event_editMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(rootPane,
                    "Version 1.0.0.0.0.1 \n\n Developers:\n Gabriel García Buey \n "
                            + "Juan Francisco Pérez Caballero",
                    "About Us",
                    JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(DIUImageThreshold.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DIUImageThreshold.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DIUImageThreshold.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DIUImageThreshold.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DIUImageThreshold().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JMenu editorMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private ImagePanel imagePanel;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    private void exitConfirmationDialog(){
        int confirmDialog = JOptionPane.showConfirmDialog(rootPane,
                "¿De verdad quieres salir?",
                "Salir",
                JOptionPane.YES_NO_OPTION);
        if (confirmDialog == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }
}
