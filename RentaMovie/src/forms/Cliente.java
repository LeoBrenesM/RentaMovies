/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import source.conexion;

/**
 *
 * @author lbren
 */
public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    
    int x,y;
    conexion connect = new conexion();
    DefaultTableModel dtm = new DefaultTableModel();
    
    
    public Cliente() {
        connect.conectarse();
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        String [] titulo = new String[]{"Codigo", "Nombre", "Fecha de Nacimiento"};
        dtm.setColumnIdentifiers(titulo);
        jTable1.setModel(dtm);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Registrar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre_Buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        txtAnno = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        mover = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        minimizar = new javax.swing.JButton();
        ColorBarra = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(46, 150, 161));

        Registrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Registrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("buscar por nombre:");
        Registrar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 32));

        txtNombre_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_BuscarActionPerformed(evt);
            }
        });
        txtNombre_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombre_BuscarKeyReleased(evt);
            }
        });
        Registrar.add(txtNombre_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 80, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "fecha nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        Registrar.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 550, 130));

        jTabbedPane1.addTab("Actualizar", Registrar);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Año");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 30, -1));
        jPanel2.add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 30, -1));
        jPanel2.add(txtAnno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 40, -1));
        jPanel2.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 30, -1));

        jLabel4.setText("Fecha Nacimiento");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel5.setText("Dia");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 20, -1));

        jLabel6.setText("Mes");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 30, -1));

        txtCorreo.setName(""); // NOI18N
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 140, -1));

        jLabel7.setText("Correo");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane1.setViewportView(txtDireccion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 250, -1));

        jLabel8.setText("direccion");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel9.setText("nombre");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 140, -1));

        jLabel10.setText("numero");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));
        jPanel2.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 140, -1));

        jButton1.setText("Registrar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        jTabbedPane1.addTab("Registrar", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 600, 390));

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
        ColorBarra.setText(" Gestion de Clientes");
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseMoved
        cerrar.setBackground(new Color(46, 51, 58));
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_fondoMouseMoved

    private void ColorBarraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorBarraMouseMoved
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_ColorBarraMouseMoved

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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        /*
        int dia,int mes,int anno,String mail, String nombre, int num, String direccion
        */
        
        if (connect.registrarC(Integer.parseInt(txtDia.getText()), Integer.parseInt(txtMes.getText()),
                Integer.parseInt(txtAnno.getText()), txtCorreo.getText(), txtNombre.getText(),
                Integer.parseInt(txtNumero.getText()), txtDireccion.getText())) {
            JOptionPane.showMessageDialog(null, "Cliente registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no registrado");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtNombre_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_BuscarActionPerformed

    private void txtNombre_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_BuscarKeyReleased
        ArrayList<source.Cliente> resultado = new ArrayList<>();
        resultado = connect.buscarCl(txtNombre_Buscar.getText().toUpperCase());
        dtm.setRowCount(0);
        for(source.Cliente client : resultado) {
            if (client.getNombre_cliente() != null) {
                dtm.addRow(new Object[]{
                    client.getCodigo(),
                    client.getNombre_cliente(),
                    client.getFecha_nac().toString()
                });
            }
        }
        
    }//GEN-LAST:event_txtNombre_BuscarKeyReleased

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ColorBarra;
    private javax.swing.JPanel Registrar;
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton minimizar;
    private javax.swing.JButton mover;
    private javax.swing.JTextField txtAnno;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre_Buscar;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
