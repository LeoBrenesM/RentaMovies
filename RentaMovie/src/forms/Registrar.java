/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.Color;
import java.awt.event.KeyEvent;
import source.conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author lbren
 */
public class Registrar extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    conexion connect = new conexion();
    int x,y;
    
    public Registrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        connect.conectarse();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblcontra = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lblcontra1 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        lblnum = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JScrollPane();
        txtDireccion1 = new javax.swing.JTextArea();
        lblfecha = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtanno = new javax.swing.JTextField();
        mover = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        minimizar1 = new javax.swing.JButton();
        minimizar = new javax.swing.JButton();
        ColorBarra = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setBackground(new java.awt.Color(150, 200, 220));
        btnRegistrar.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseMoved(evt);
            }
        });
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 160, 40));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        jLabel1.setText("Correo / Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 30));

        txtUser.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(195, 195, 216));
        txtUser.setText("ej.user@example.com");
        txtUser.setToolTipText("");
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 180, 30));

        lblcontra.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        lblcontra.setText("Contraseña");
        getContentPane().add(lblcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 90, 30));

        txtPass.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        txtPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 180, 30));

        lblcontra1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        lblcontra1.setText("Confirmar contraseña");
        getContentPane().add(lblcontra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 160, 30));

        txtPass1.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        txtPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPass1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPass1KeyReleased(evt);
            }
        });
        getContentPane().add(txtPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 180, 30));

        lblnum.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        lblnum.setText("Numero cell");
        getContentPane().add(lblnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 100, 30));
        getContentPane().add(txtnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 160, 30));

        lblnombre.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        lblnombre.setText("Nombre");
        getContentPane().add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, 30));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 160, 30));

        lblDireccion.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        lblDireccion.setText("Direccion");
        getContentPane().add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 90, 30));

        txtDireccion1.setColumns(15);
        txtDireccion1.setRows(5);
        txtdireccion.setViewportView(txtDireccion1);

        getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 280, 170));

        lblfecha.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        lblfecha.setText("Fecha de Nacimiento");
        getContentPane().add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 170, 30));

        txtDia.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        txtDia.setText("21");
        getContentPane().add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 40, 30));

        txtMes.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        txtMes.setText("11");
        txtMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesActionPerformed(evt);
            }
        });
        getContentPane().add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 40, 30));

        txtanno.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        txtanno.setText("2000");
        getContentPane().add(txtanno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 60, 30));

        mover.setBackground(new java.awt.Color(46, 51, 58));
        mover.setBorderPainted(false);
        mover.setContentAreaFilled(false);
        mover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        mover.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                moverMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                moverMouseMoved(evt);
            }
        });
        mover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                moverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moverMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                moverMousePressed(evt);
            }
        });
        getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 40));

        cerrar.setBackground(new java.awt.Color(46, 51, 58));
        cerrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cerrar.setForeground(new java.awt.Color(255, 255, 255));
        cerrar.setText("X");
        cerrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cerrar.setBorderPainted(false);
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cerrarMouseMoved(evt);
            }
        });
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        getContentPane().add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 60, 40));

        minimizar1.setBackground(new java.awt.Color(46, 51, 58));
        minimizar1.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        minimizar1.setForeground(new java.awt.Color(255, 255, 255));
        minimizar1.setText("a");
        minimizar1.setBorder(null);
        minimizar1.setBorderPainted(false);
        minimizar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                minimizar1MouseMoved(evt);
            }
        });
        minimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizar1MouseClicked(evt);
            }
        });
        getContentPane().add(minimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 60, 40));

        minimizar.setBackground(new java.awt.Color(46, 51, 58));
        minimizar.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        minimizar.setForeground(new java.awt.Color(255, 255, 255));
        minimizar.setText("-");
        minimizar.setBorder(null);
        minimizar.setBorderPainted(false);
        minimizar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                minimizarMouseMoved(evt);
            }
        });
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        getContentPane().add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 60, 40));

        ColorBarra.setBackground(new java.awt.Color(46, 51, 58));
        ColorBarra.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        ColorBarra.setForeground(new java.awt.Color(255, 255, 255));
        ColorBarra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ColorBarra.setText(" Registrar Vendedor");
        ColorBarra.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        ColorBarra.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ColorBarra.setOpaque(true);
        ColorBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ColorBarraMouseMoved(evt);
            }
        });
        getContentPane().add(ColorBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 40));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                fondoMouseMoved(evt);
            }
        });
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        txtUser.setForeground(new Color(0,0,0));
        txtUser.setText("");
    }//GEN-LAST:event_txtUserMouseClicked

    private void moverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moverMouseDragged
        this.setLocation(this.getLocation().x + evt.getX()-x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_moverMouseDragged

    private void moverMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moverMouseMoved
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_moverMouseMoved

    private void moverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moverMouseClicked
        minimizar.setBackground(new Color(46, 51, 58));
        x=this.getX();
        y=this.getY();
    }//GEN-LAST:event_moverMouseClicked

    private void moverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moverMouseEntered
        mover.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_moverMouseEntered

    private void moverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moverMouseExited
        mover.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_moverMouseExited

    private void moverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moverMousePressed
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_moverMousePressed

    private void cerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseMoved
        cerrar.setBackground(Color.red);
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_cerrarMouseMoved

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        //this.dispose(); no utilizo el dispose para que termine losnhilos activos
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    private void minimizarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseMoved
        minimizar.setBackground(new Color(32, 178, 170));
        cerrar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_minimizarMouseMoved

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setExtendedState(ICONIFIED);
        minimizar.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_minimizarMouseClicked

    private void ColorBarraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorBarraMouseMoved
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_ColorBarraMouseMoved

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        
    }//GEN-LAST:event_txtPassKeyPressed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        if (connect.registrar( txtPass1.getText(), Integer.parseInt(txtDia.getText()),Integer.parseInt(txtMes.getText())
                    , Integer.parseInt(txtanno.getText()), txtUser.getText(), txtNombre.getText(),
                    Integer.parseInt(txtnum.getText()), txtDireccion1.getText())) {
            
            JOptionPane.showMessageDialog(null, "Registrado Correctamente");
            this.dispose();
            Login ventana = new Login();
            ventana.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null, "No Registrado Correctamente");
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void fondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseMoved
        cerrar.setBackground(new Color(46, 51, 58));
        minimizar.setBackground(new Color(46, 51, 58));
        btnRegistrar.setBackground(new Color(150,200,220));
    }//GEN-LAST:event_fondoMouseMoved

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPass1KeyPressed

    private void txtMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesActionPerformed

    private void txtPass1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyReleased
        if (txtPass.getText().equals(txtPass1.getText())) {
            txtPass1.setBackground(new Color(116,255,116));
        } else{
            txtPass1.setBackground(new Color(255,128,128));
        }
    }//GEN-LAST:event_txtPass1KeyReleased

    private void minimizar1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizar1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizar1MouseMoved

    private void minimizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizar1MouseClicked
        Login ventana = new Login();
        this.dispose();
        ventana.setVisible(true);        
    }//GEN-LAST:event_minimizar1MouseClicked

    private void btnRegistrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseMoved
        btnRegistrar.setBackground(new Color(125,175,195));
    }//GEN-LAST:event_btnRegistrarMouseMoved

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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Registrar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ColorBarra;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblcontra;
    private javax.swing.JLabel lblcontra1;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblnum;
    private javax.swing.JButton minimizar;
    private javax.swing.JButton minimizar1;
    private javax.swing.JButton mover;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextArea txtDireccion1;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtanno;
    private javax.swing.JScrollPane txtdireccion;
    private javax.swing.JTextField txtnum;
    // End of variables declaration//GEN-END:variables
}
