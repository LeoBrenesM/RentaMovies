/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import source.conexion;

public class Prestamos extends javax.swing.JFrame {
    
    int x,y, codigoo = -1, codigon = -3, factura = 0;
    static int id_vend;
    java.sql.Date fecha_nacc;
    String fact = "";
    int monto;
    conexion connect = new conexion();
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();
    DefaultTableModel dtmClientes = new DefaultTableModel();
    DefaultTableModel dtmFacturas = new DefaultTableModel();
    
    
    public Prestamos(int id) {
        connect.conectarse();
        
        initComponents();
        this.setLocationRelativeTo(null);

        String [] titulo = new String[]{"Codigo", "Nombre", "Fecha de Nacimiento"};
        dtm.setColumnIdentifiers(titulo);
        jTable2.setModel(dtm);
        
        String [] titulo2 = new String[]{"Id de ejemplar", "Nombre de pelicula"};
        dtm2.setColumnIdentifiers(titulo2);
        jTable1.setModel(dtm2);
        id_vend = id;
        
        String [] tituloC = new String[]{"Codigo", "Nombre", "Fecha de Nacimiento"};
        dtmClientes.setColumnIdentifiers(titulo);
        clientes.setModel(dtmClientes);
        
        String [] tituloF = new String[]{"Id_factura","Fecha Devolucion","Monto"};
        dtmFacturas.setColumnIdentifiers(tituloF);
        facturas_clientes.setModel(dtmFacturas);
        
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
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTituloB = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        clientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        facturas_clientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        mover = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        minimizar1 = new javax.swing.JButton();
        minimizar = new javax.swing.JButton();
        ColorBarra = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RentaMovies");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(250, 250, 250));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(190, 200, 200));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Candara", 1, 35)); // NOI18N
        jLabel2.setText(" 1+n");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 470, 90));

        jLabel17.setText("Nombre de pelicula");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, 20));

        jLabel18.setBackground(new java.awt.Color(200, 220, 220));
        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(70, 70, 70));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Ejemplar");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel18.setOpaque(true);
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 30));

        txtTituloB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTituloBKeyReleased(evt);
            }
        });
        jPanel5.add(txtTituloB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 360, -1));

        jButton2.setText("Agregar Linea");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 140, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 220));

        jPanel6.setBackground(new java.awt.Color(190, 200, 200));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 470, 90));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 35)); // NOI18N
        jLabel1.setText(" 1");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, -1));

        jLabel19.setText("Nombre");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 50, 20));

        jLabel20.setBackground(new java.awt.Color(200, 220, 220));
        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(70, 70, 70));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cliente");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel20.setOpaque(true);
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 30));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        jPanel6.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 360, -1));

        jButton1.setText("Crear Factura");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 140, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 220));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("LISTO");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 100, 50));

        jTabbedPane1.addTab("Factura", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(190, 200, 200));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(clientes);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 470, 150));

        jLabel3.setFont(new java.awt.Font("Candara", 1, 35)); // NOI18N
        jLabel3.setText(" 1");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, -1));

        jLabel21.setText("Nombre cliente");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 20));

        jLabel22.setBackground(new java.awt.Color(200, 220, 220));
        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(70, 70, 70));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Devolver  disco");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel22.setOpaque(true);
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 30));

        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombre1KeyReleased(evt);
            }
        });
        jPanel7.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 360, -1));

        facturas_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        facturas_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facturas_clientesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(facturas_clientes);

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 470, 190));

        jLabel6.setText("Facturas");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 530));

        jTabbedPane1.addTab("Devolucion", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 600, 600));

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
        getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 40));

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
        getContentPane().add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 60, 40));

        minimizar1.setBackground(new java.awt.Color(46, 51, 58));
        minimizar1.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        minimizar1.setForeground(new java.awt.Color(255, 255, 255));
        minimizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return.png"))); // NOI18N
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
        getContentPane().add(minimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 60, 40));

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
        getContentPane().add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 60, 40));

        ColorBarra.setBackground(new java.awt.Color(46, 51, 58));
        ColorBarra.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        ColorBarra.setForeground(new java.awt.Color(255, 255, 255));
        ColorBarra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ColorBarra.setText(" Gestion de Prestamos");
        ColorBarra.setToolTipText("");
        ColorBarra.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        ColorBarra.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ColorBarra.setOpaque(true);
        ColorBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ColorBarraMouseMoved(evt);
            }
        });
        getContentPane().add(ColorBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 40));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        fondo.setOpaque(true);
        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                fondoMouseMoved(evt);
            }
        });
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseMoved
        cerrar.setBackground(new Color(46, 51, 58));
        minimizar.setBackground(new Color(46, 51, 58));
        Icon foto = new ImageIcon(getClass().getResource("/img/return.png"));
        minimizar1.setIcon(foto);
    }//GEN-LAST:event_fondoMouseMoved

    private void ColorBarraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorBarraMouseMoved
        minimizar.setBackground(new Color(46, 51, 58));
    }//GEN-LAST:event_ColorBarraMouseMoved

    private void moverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moverMouseDragged
        this.setLocation(this.getLocation().x + evt.getX()-x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_moverMouseDragged

    private void moverMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moverMouseMoved
        minimizar.setBackground(new Color(46, 51, 58));
        Icon foto = new ImageIcon(getClass().getResource("/img/return.png"));
        minimizar1.setIcon(foto);
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
        Icon foto = new ImageIcon(getClass().getResource("/img/return.png"));
        minimizar1.setIcon(foto);
    }//GEN-LAST:event_minimizarMouseMoved

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setExtendedState(ICONIFIED);
        minimizar.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_minimizarMouseClicked

    private void txtTituloBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloBKeyReleased
        ArrayList<source.ejemplar_pelicula> iPeliculas = new ArrayList<>();
        iPeliculas = connect.busqueda_de_ejemplares_disponibles(txtTituloB.getText().toUpperCase());
        dtm2.setRowCount(0);
        
        for (source.ejemplar_pelicula iPeli : iPeliculas) {
            dtm2.addRow(new Object[]{
                iPeli.getCodigo_ejemplar(),
                iPeli.getNombre_peli(),
            });
        }
        
    }//GEN-LAST:event_txtTituloBKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int algo = jTable1.getSelectedRow();
        String bus = "" + dtm2.getValueAt(algo, 0);
        codigoo = Integer.parseInt(bus);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int algo = jTable2.getSelectedRow();
        String bus = "" + dtm.getValueAt(algo, 0);
        codigon = Integer.parseInt(bus);
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        ArrayList<source.Cliente> resultado = new ArrayList<>();
        resultado = connect.buscarCl(txtNombre.getText().toUpperCase());
        
        dtm.setRowCount(0);
        
        for(source.Cliente client : resultado) {
            dtm.addRow(new Object[]{
                client.getCodigo(),
                client.getNombre_cliente(),
                client.getFecha_nac().toString()
            });
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (codigon != -3 && factura == 0) {
            if (connect.agregarFact(id_vend, codigon)) {
                fact += " - FACTURA - \n"
                        + "Cliente: " + codigon + "\n"
                        + "Codigo de Vendedor: " + id_vend;
                codigon = -3;
                factura = 1;
                JOptionPane.showMessageDialog(null, "Factura Creada correctamente");
            } else{
                JOptionPane.showMessageDialog(null, "No creada correctamente");
            }
        } else{
            JOptionPane.showMessageDialog(null, "No creada correctamente");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (codigoo != -1 && factura == 1) {
            source.Factura ifac = new source.Factura();
            ifac = connect.ultimaFac();
            if (connect.agregarLinea(ifac.getId_factura(), codigoo)) {
                JOptionPane.showMessageDialog(null, "Linea agregada!");
            } else{
                JOptionPane.showMessageDialog(null, "Linea NO agregada!");
            }
        } else{
            JOptionPane.showMessageDialog(null, "O factura no creada o ejemplar no seleccionado");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void txtNombre1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyReleased
        ArrayList<source.Cliente> resultado = new ArrayList<>();
        resultado = connect.buscarCl(txtNombre1.getText().toUpperCase());
        
        dtmClientes.setRowCount(0);
        
        for(source.Cliente client : resultado) {
            dtmClientes.addRow(new Object[]{
                client.getCodigo(),
                client.getNombre_cliente(),
                client.getFecha_nac().toString()
            });
        }
    }//GEN-LAST:event_txtNombre1KeyReleased

    private void clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesMouseClicked
        int fila = clientes.getSelectedRow();
        int codigo = (int) dtmClientes.getValueAt(fila, 0);
        
        ArrayList<source.Factura> iFacturas = connect.buscaFacturas(codigo);
        dtmFacturas.setRowCount(0);
        for(source.Factura ifac : iFacturas){
            dtmFacturas.addRow(new Object[]{
                ifac.getId_factura(),
                ifac.getFecha_devolucion().toString(),
                ifac.getTotal()
            });
        }
        
    }//GEN-LAST:event_clientesMouseClicked

    private void facturas_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facturas_clientesMouseClicked
        int fila = facturas_clientes.getSelectedRow();
        int codigo = (int) dtmFacturas.getValueAt(fila,0);
        
        if (connect.devuelveFactura(factura)) {
            JOptionPane.showMessageDialog(null, "Factura devuelta correctamente");
        } else{
            JOptionPane.showMessageDialog(null, "Factura NO devuelta correctamente");
        }
    }//GEN-LAST:event_facturas_clientesMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void minimizar1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizar1MouseMoved
        minimizar.setBackground(new Color(46, 51, 58));
        Icon foto = new ImageIcon(getClass().getResource("/img/return2.png"));
        minimizar1.setIcon(foto);
    }//GEN-LAST:event_minimizar1MouseMoved

    private void minimizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizar1MouseClicked
        MenuPrincipal ventana = new MenuPrincipal(id_vend);
        this.dispose();
        ventana.setVisible(true);
    }//GEN-LAST:event_minimizar1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if (factura == 1) {
            JOptionPane.showMessageDialog(null,"Factura guardada correctamente");
            factura = 0;
        }else{
            JOptionPane.showMessageDialog(null,"Factura NO guardada correctamente");
        }
        
    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos(id_vend).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ColorBarra;
    private javax.swing.JButton cerrar;
    private javax.swing.JTable clientes;
    private javax.swing.JTable facturas_clientes;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton minimizar;
    private javax.swing.JButton minimizar1;
    private javax.swing.JButton mover;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtTituloB;
    // End of variables declaration//GEN-END:variables
}
