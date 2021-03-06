package forms;

import java.awt.Color;
import source.conexion;

public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    
    conexion connect = new conexion();
    int x,y;
    static int id_vend;
    
    public MenuPrincipal(int id) {
        initComponents();
        id_vend = id;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cliente2 = new javax.swing.JButton();
        Cliente1 = new javax.swing.JButton();
        Cliente = new javax.swing.JButton();
        minimizar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        mover = new javax.swing.JButton();
        ColorBarra = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Prestamos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel2.setText("Peliculas / Ejemplares");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        Cliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/money.png"))); // NOI18N
        Cliente2.setBorderPainted(false);
        Cliente2.setContentAreaFilled(false);
        Cliente2.setName(""); // NOI18N
        Cliente2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/money2.png"))); // NOI18N
        Cliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cliente2ActionPerformed(evt);
            }
        });
        getContentPane().add(Cliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 170, 180));

        Cliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compact-disc.png"))); // NOI18N
        Cliente1.setBorderPainted(false);
        Cliente1.setContentAreaFilled(false);
        Cliente1.setName(""); // NOI18N
        Cliente1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compact-disc2.png"))); // NOI18N
        Cliente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cliente1MouseClicked(evt);
            }
        });
        Cliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cliente1ActionPerformed(evt);
            }
        });
        getContentPane().add(Cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 170, 190));

        Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        Cliente.setBorderPainted(false);
        Cliente.setContentAreaFilled(false);
        Cliente.setName(""); // NOI18N
        Cliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user2.png"))); // NOI18N
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        getContentPane().add(Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 170, 190));

        minimizar.setBackground(new java.awt.Color(46, 51, 58));
        minimizar.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        minimizar.setForeground(new java.awt.Color(255, 255, 255));
        minimizar.setText("-");
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

        cerrar.setBackground(new java.awt.Color(46, 51, 58));
        cerrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cerrar.setForeground(new java.awt.Color(255, 255, 255));
        cerrar.setText("X");
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
        getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 40));

        ColorBarra.setBackground(new java.awt.Color(46, 51, 58));
        ColorBarra.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        ColorBarra.setForeground(new java.awt.Color(255, 255, 255));
        ColorBarra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ColorBarra.setText(" Menu Principal");
        ColorBarra.setToolTipText("");
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
        fondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                fondoMouseMoved(evt);
            }
        });
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 480));

        jLabel3.setText("Clientes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseMoved
        cerrar.setBackground(new Color(46, 51, 58));
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_fondoMouseMoved

    private void ColorBarraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorBarraMouseMoved
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_ColorBarraMouseMoved

    private void minimizarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseMoved
        minimizar.setBackground(new Color(32, 178, 170));
        cerrar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_minimizarMouseMoved

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setExtendedState(ICONIFIED);
        minimizar.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_minimizarMouseClicked

    private void cerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseMoved
        cerrar.setBackground(Color.red);
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_cerrarMouseMoved

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        //this.dispose(); no utilizo el dispose para que termine losnhilos activos
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

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

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        Cliente ventana = new Cliente(id_vend);
        
        this.dispose();
        ventana.show();
        
    }//GEN-LAST:event_ClienteActionPerformed

    private void Cliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cliente1ActionPerformed

    private void Cliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cliente2ActionPerformed
        Prestamos ventana = new Prestamos(id_vend);
        this.dispose();
        ventana.setVisible(true);
    }//GEN-LAST:event_Cliente2ActionPerformed

    private void Cliente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cliente1MouseClicked
        Pelicula ventana = new Pelicula(id_vend);
        this.dispose();
        ventana.setVisible(true);
    }//GEN-LAST:event_Cliente1MouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal(id_vend).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cliente;
    private javax.swing.JButton Cliente1;
    private javax.swing.JButton Cliente2;
    private javax.swing.JLabel ColorBarra;
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton minimizar;
    private javax.swing.JButton mover;
    // End of variables declaration//GEN-END:variables
}
