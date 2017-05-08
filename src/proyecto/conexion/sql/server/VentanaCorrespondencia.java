/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.conexion.sql.server;

import Clases1.ImagenFondo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class VentanaCorrespondencia extends javax.swing.JFrame {
    private String accion, id_actualizar,urlOrigen,sql;
    private String mensaje,imgDestino,extension,genero,email,observaciones,imgbd;
    DefaultTableModel modelo;
    Conexion Conect;
    String campoconsulta;
    int ultimoIndiceSeleccionado;
    String regex;
    Pattern patron;
    
    public VentanaCorrespondencia() {
        initComponents();
        this.setLocationRelativeTo(null);
        System.out.println("Primera carga");
        primeraCarga();
        accion= "Insertar"; 
        id_actualizar="";
        urlOrigen="";
        sql="";
        observaciones="";
        ultimoIndiceSeleccionado = 0;
        System.out.println("Ha pasado la primer carga");
        deshabilitar();
        campoconsulta="";
        jDesktopPane1.setBorder(new ImagenFondo());
    }
    
    public boolean validacionImporte(String txt){
        String[] listaTextos=txt.split(",");
        regex = "([0-9])+";
        patron = Pattern.compile(regex);
		for (String texto : listaTextos) {
			Matcher emparejador = patron.matcher(texto);
			boolean esCoincidente = emparejador.find();
			if (esCoincidente) {
				return true;
			}
		}
        return false;
    }
    
    public boolean validacionFecha(String txt){
        String[] listaTextos=txt.split(",");
        regex = "[0-9][0-9][0-9][0-9]+-+[0-9][0-9]+-+[0-9][0-9]";
        patron = Pattern.compile(regex);
		for (String texto : listaTextos) {
			Matcher emparejador = patron.matcher(texto);
			boolean esCoincidente = emparejador.find();
			if (esCoincidente) {
				return true;
			}
		}
        return false;
    }
    
    public boolean validacionDependencia(String txt){
        String[] listaTextos=txt.split(",");
        regex = "([A-Za-z])+";
        patron = Pattern.compile(regex);
		for (String texto : listaTextos) {
			Matcher emparejador = patron.matcher(texto);
			boolean esCoincidente = emparejador.find();
			if (esCoincidente) {
				return true;
			}
		}
        return false;
    }
    
    public boolean validacionConcepto(String txt){
        String[] listaTextos=txt.split(",");
        regex = "([A-Za-z])+";
        patron = Pattern.compile(regex);
		for (String texto : listaTextos) {
			Matcher emparejador = patron.matcher(texto);
			boolean esCoincidente = emparejador.find();
			if (esCoincidente) {
				return true;
			}
		}
        return false;
    }
    
    public boolean validacionTurnado(String txt){
        String[] listaTextos=txt.split(",");
        regex = "([A-Za-z])+";
        patron = Pattern.compile(regex);
		for (String texto : listaTextos) {
			Matcher emparejador = patron.matcher(texto);
			boolean esCoincidente = emparejador.find();
			if (esCoincidente) {
				return true;
			}
		}
        return false;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textfield_oficio = new javax.swing.JTextField();
        textfield_dependencia = new javax.swing.JTextField();
        textfield_importe = new javax.swing.JTextField();
        textfield_concepto = new javax.swing.JTextField();
        textfield_turnado = new javax.swing.JTextField();
        textfield_fecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        combobox_original = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_consulta = new javax.swing.JTable();
        button_agregar = new javax.swing.JButton();
        button_borrar = new javax.swing.JButton();
        button_cancelar = new javax.swing.JButton();
        button_guardar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        textfield_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combobox_parametro = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 141, 113));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(102, 102, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(102, 102, 0)));

        jLabel1.setText("No. Oficio");

        jLabel3.setText("Importe");

        jLabel4.setText("Concepto");

        jLabel5.setText("Original");

        jLabel6.setText("Turnado a");

        jLabel7.setText("Fecha recibido");

        textfield_oficio.setEditable(false);

        jLabel11.setText("Dependencia");

        combobox_original.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "original", "copia" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textfield_dependencia)
                    .addComponent(textfield_oficio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfield_importe, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfield_concepto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(combobox_original, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textfield_turnado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(textfield_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_oficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_dependencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textfield_importe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textfield_concepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(textfield_turnado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(combobox_original, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(textfield_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 0), new java.awt.Color(102, 102, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(102, 153, 0)));

        table_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_consultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_consulta);

        button_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1490259852_add_user.png"))); // NOI18N
        button_agregar.setText("Agregar");
        button_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agregarActionPerformed(evt);
            }
        });

        button_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1490260029_remove_user.png"))); // NOI18N
        button_borrar.setText("Borrar");
        button_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_borrarActionPerformed(evt);
            }
        });

        button_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1490260321_Close_Icon.png"))); // NOI18N
        button_cancelar.setText("Cancelar");
        button_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelarActionPerformed(evt);
            }
        });

        button_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1490260266_Save.png"))); // NOI18N
        button_guardar.setText("Guardar");
        button_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_guardar)
                    .addComponent(button_agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(339, 339, 339))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_cancelar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(102, 102, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(102, 102, 0)));

        textfield_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_buscarActionPerformed(evt);
            }
        });
        textfield_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfield_buscarKeyReleased(evt);
            }
        });

        jLabel2.setText("Buscar");

        combobox_parametro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No_Oficio", "Dependencia", "Importe", "Concepto", "Turnado_A", "Fecha_De_Recibido" }));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1490261946_Search.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/oie_13305OIlPU0hG.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combobox_parametro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textfield_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(202, 202, 202)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combobox_parametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 0), new java.awt.Color(102, 102, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 102, 0)));
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 204));

        jLabel17.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("DOCUMENTOS DE CORRESPONDENCIA");

        jDesktopPane1.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 739, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(102, 102, 0));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rsz_aguila.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setForeground(new java.awt.Color(153, 153, 153));

        jButton4.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1494157185_document.png"))); // NOI18N
        jButton4.setText("Correspondencia");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4);

        jButton5.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1479878567_23.png"))); // NOI18N
        jButton5.setText("Trámites");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5);

        jButton1.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logout.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1);

        jButton2.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1479878437_phonebook.png"))); // NOI18N
        jButton2.setText("Agenda");
        jPanel8.add(jButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPane1))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDesktopPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void primeraCarga(){
        String[] titulos={"Dependencia","Importe","Concepto","Fecha"};

        String[] registros= new String[4];
        modelo = new DefaultTableModel(null,titulos);
        try {
            //Mostrar registros en la tabla
            Conect = new Conexion();
            ResultSet consulta= Conect.primerCarga1();
            while(consulta.next()){
                registros[0] = consulta.getString("Dependencia");
                registros[1] = consulta.getString("Importe");
                registros[2] = consulta.getString("Concepto");
                registros[3] = consulta.getString("Fecha_De_Recibido");
               
                modelo.addRow(registros);               
            }
            //Mostrar titulos de la tabla
            table_consulta.setModel(modelo);
            
        } catch (SQLException ex) {    
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    private void insertarModificar(){
        System.out.println("Empieza metodo modificar..."); 
        String nof,dep,imp,con,ori,tur,fec;
        nof = textfield_oficio.getText();
        dep = textfield_dependencia.getText();
        imp = textfield_importe.getText();
        con = textfield_concepto.getText();
        ori = combobox_original.getSelectedItem().toString();
        tur = textfield_turnado.getText();
        fec = textfield_fecha.getText();
        
        System.out.println("Previo a catch..."); 
        try {
            System.out.println("Previo a conexion..."); 
            Conect = new Conexion();
            System.out.println("Post conexion...");
            System.out.println("Accion: "+accion); 
            if(accion.equals("Insertar")){
                System.out.println("Estoy guardando nuevo...");
                sql= "INSERT INTO Correspondencia( Dependencia,Importe,Concepto,Original,Turnado_A,Fecha_De_Recibido)"+" VALUES(?,?,?,?,?,?)";
                mensaje="Los datos se han insertado";
                //metodo deshabilitar controles
                deshabilitar();
            }
            
            if((accion.equals("Modificar"))){
                System.out.println("Estoy actualizando...");
                sql= "UPDATE Correspondencia SET Dependencia = ?, Importe = ?,Concepto = ?,Original = ?,Turnado_A = ?, Fecha_De_Recibido = ?  WHERE Dependencia = "+"'"+id_actualizar+"'";
                mensaje="Los datos se han actualizado";
                //metodo deshabilitar controles
                System.out.println("Final de actualizacion...");
                deshabilitar();
            }
            PreparedStatement pst=Conect.conexion.prepareStatement(sql);

            
            pst.setString(1, dep);
            pst.setString(2, imp);
            pst.setString(3, con);
            pst.setString(4, ori);
            pst.setString(5, tur);
            pst.setString(6, fec);
           
           
            int n=pst.executeUpdate();
            System.out.println("Valor n= "+n);
            if(n>0){
                JOptionPane.showMessageDialog(null, mensaje);
                //metodo cargar tabla
                //cargarTabla("");
                primeraCarga();
            }
        } catch (SQLException ex) {
           System.out.println("Entró a catch...");
           JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    
    private void cargarDatos(String Id){
        try {
            Conect= new Conexion();
            ResultSet consulta =Conect.Consultar2("Correspondencia", "Dependencia", Id);
            //Recorre registros para mostrarlos
            while(consulta.next()){
                textfield_oficio.setText(consulta.getString("No_Oficio"));
                textfield_dependencia.setText(consulta.getString("Dependencia"));
                textfield_importe.setText(consulta.getString("Importe"));
                textfield_concepto.setText(consulta.getString("Concepto"));
                combobox_original.setSelectedIndex(ultimoIndiceSeleccionado);
                textfield_turnado.setText(consulta.getString("Turnado_A"));
                textfield_fecha.setText(consulta.getString("Fecha_De_Recibido"));
            }
            
        } catch (SQLException ex) {
            
        }
    }
    
    
    
    private void table_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_consultaMouseClicked

        habilitar();
        int filas;
        String Id;
        accion="Modificar";
        filas= table_consulta.getSelectedRow();

        Id=(String)modelo.getValueAt(filas,0);
        System.out.println("Valor ID= "+Id);
        //textfield_observaciones.setEnabled(false);
        id_actualizar =Id;
        cargarDatos(Id);
    }//GEN-LAST:event_table_consultaMouseClicked

    public void deshabilitar(){
        observaciones=" ";
        accion="Insertar";
        urlOrigen=" ";
        //label_foto.setIcon(null);
        textfield_oficio.setEnabled(false);
        textfield_dependencia.setEnabled(false);
        textfield_importe.setEnabled(false);
        textfield_concepto.setEnabled(false);
        combobox_original.setEnabled(false);
        textfield_turnado.setEnabled(false);
        textfield_fecha.setEnabled(false);
        
        textfield_oficio.setText("");
        textfield_dependencia.setText("");
        textfield_importe.setText("");
        textfield_concepto.setText("");
        combobox_original.setSelectedIndex(0);
        textfield_turnado.setText("");
        textfield_fecha.setText("");
        textfield_oficio.requestFocus();
        
        button_guardar.setEnabled(false);
        button_borrar.setEnabled(false);
        button_cancelar.setEnabled(false);
    }
    
    public void habilitar(){
        observaciones=" ";
        accion="Insertar";
        urlOrigen=" ";
        //label_foto.setIcon(null);
        
        textfield_oficio.setEnabled(true);
        textfield_dependencia.setEnabled(true);
        textfield_importe.setEnabled(true);
        textfield_concepto.setEnabled(true);
        combobox_original.setEnabled(true);
        textfield_turnado.setEnabled(true);
        textfield_fecha.setEnabled(true);
        
        textfield_oficio.setText("");
        textfield_dependencia.setText("");
        textfield_importe.setText("");
        textfield_concepto.setText("");
        combobox_original.setSelectedIndex(0);
        textfield_turnado.setText("");
        textfield_fecha.setText("");
        textfield_oficio.requestFocus();
        
        button_guardar.setEnabled(true);
        button_borrar.setEnabled(true);
        button_cancelar.setEnabled(true);
    }
    
    public void cargarTabla(String valor){
        String[] titulos={"Dependencia","Importe","Concepto","Fecha"};
        
        String[] registros= new String[4];
        modelo = new DefaultTableModel(null,titulos);
        try {
            //Mostrar registros en la tabla
            Conect = new Conexion();
            ResultSet consulta= Conect.Consultar1("Correspondencia",campoconsulta ,valor);
            while(consulta.next()){
                
                registros[0] = consulta.getString("Dependencia");
                registros[1] = consulta.getString("Importe");
                registros[2] = consulta.getString("Concepto");
                registros[3] = consulta.getString("Fecha_De_Recibido");
                modelo.addRow(registros);               
            }
            //Mostrar titulos de la tabla
            table_consulta.setModel(modelo);
            
        } catch (SQLException ex) {    
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    
    
    private void textfield_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_buscarActionPerformed

    }//GEN-LAST:event_textfield_buscarActionPerformed

    private void textfield_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_buscarKeyReleased
        campoconsulta=String.valueOf(combobox_parametro.getSelectedItem());
        System.out.println("Campo a consultar= "+campoconsulta);
        cargarTabla(textfield_buscar.getText());
    }//GEN-LAST:event_textfield_buscarKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        VentanaCorrespondencia a=new VentanaCorrespondencia();
        a.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        this.vt.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        VentanaLogin vl=new VentanaLogin();
        vl.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agregarActionPerformed
        habilitar();
    }//GEN-LAST:event_button_agregarActionPerformed

    private void button_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_borrarActionPerformed
        if(JOptionPane.YES_NO_OPTION==JOptionPane.showConfirmDialog(null,"Desea eliminar los registros "+"'","Eliminar registros",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)){
            System.out.println("Previo a mensaje y deshabilitacion");
            String Nombre=textfield_nombre.getText();
            mensaje="Los datos se han eliminado";
            deshabilitar();
            try {
                Conect = new Conexion();
                Conect.Eliminar("Contacto", "Nombre", Nombre);
                JOptionPane.showMessageDialog(null, mensaje);
                primeraCarga();
                JOptionPane.showMessageDialog(null, "se cargó tabla correctamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }else{deshabilitar();}
    }//GEN-LAST:event_button_borrarActionPerformed

    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        deshabilitar();
    }//GEN-LAST:event_button_cancelarActionPerformed

    private void button_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_guardarActionPerformed
        //Comprobacion de campos al presionar guardar
        if(validacionNombre(textfield_oficio.getText())==false){
            JOptionPane.showMessageDialog(null,"El Nombre no es valido");
            return;
        }
        if(validacionDepartamento((String)combobox_departamento.getSelectedItem())==false){
            JOptionPane.showMessageDialog(null,"El Departamento no es valido");
            return;
        }
        if(validacionSecretaria((String)combobox_secretaria.getSelectedItem())==false){
            JOptionPane.showMessageDialog(null,"La secretaria no es valida");
            return;
        }
        if(validacionTelefonoOficina(textfield_telefono_oficina.getText())==false){
            JOptionPane.showMessageDialog(null,"El telefono de oficina no es valido");
            return;
        }
        if(validacionApellido(textfield_apellido.getText())==false){
            JOptionPane.showMessageDialog(null,"El Apellido no es valido");
            return;
        }
        if(validacionDireccion((String)combobox_direccion.getSelectedItem())==false){
            JOptionPane.showMessageDialog(null,"Direccion no valida");
            return;
        }

        if(validacionDomicilio(textfield_domicilio.getText())==false){
            JOptionPane.showMessageDialog(null,"Domicilio no valido");
            return;
        }
        if(validacionTelefonoCelular(textfield_telefono_celular.getText())==false){
            JOptionPane.showMessageDialog(null,"El telefono celular no es valido");
            return;
        }
        if(validacionCorreo(textfield_correo.getText())==false){
            JOptionPane.showMessageDialog(null,"El correo no es valido");
            return;
        }

        insertarModificar();
    }//GEN-LAST:event_button_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCorrespondencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCorrespondencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_agregar;
    private javax.swing.JButton button_borrar;
    private javax.swing.JButton button_cancelar;
    private javax.swing.JButton button_guardar;
    private javax.swing.JComboBox combobox_original;
    private javax.swing.JComboBox combobox_parametro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_consulta;
    private javax.swing.JTextField textfield_buscar;
    private javax.swing.JTextField textfield_concepto;
    private javax.swing.JTextField textfield_dependencia;
    private javax.swing.JTextField textfield_fecha;
    private javax.swing.JTextField textfield_importe;
    private javax.swing.JTextField textfield_oficio;
    private javax.swing.JTextField textfield_turnado;
    // End of variables declaration//GEN-END:variables
}
