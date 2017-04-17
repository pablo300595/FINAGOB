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
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_consulta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        button_agregar = new javax.swing.JButton();
        button_borrar = new javax.swing.JButton();
        button_guardar = new javax.swing.JButton();
        button_cancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        textfield_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combobox_parametro = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("No. Oficio");

        jLabel3.setText("Importe");

        jLabel4.setText("Concepto");

        jLabel5.setText("Original");

        jLabel6.setText("Turnado a");

        jLabel7.setText("Fecha recibido");

        textfield_oficio.setEditable(false);

        jLabel11.setText("Dependencia");

        combobox_original.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "original", "copia" }));

        jLabel8.setText("yyyy-mm-dd");

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(combobox_original, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(19, 19, 19)
                        .addComponent(textfield_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textfield_turnado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(281, Short.MAX_VALUE))
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
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(textfield_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobox_original, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        button_agregar.setText("Agregar");
        button_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agregarActionPerformed(evt);
            }
        });

        button_borrar.setText("Borrar");
        button_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_borrarActionPerformed(evt);
            }
        });

        button_guardar.setText("Guardar");
        button_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_guardarActionPerformed(evt);
            }
        });

        button_cancelar.setText("Cancelar");
        button_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_agregar)
                    .addComponent(button_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_guardar)
                    .addComponent(button_cancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(button_borrar)
                .addGap(18, 18, 18)
                .addComponent(button_cancelar)
                .addGap(18, 18, 18)
                .addComponent(button_guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_agregar)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setText("Agenda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Fairview Regular", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText("Documentos de Correspondencia");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(463, 463, 463))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(44, 44, 44))
        );
        jDesktopPane1.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combobox_parametro, 0, 400, Short.MAX_VALUE)
                    .addComponent(textfield_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(354, 354, 354))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combobox_parametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaAgenda jFrame= new VentanaAgenda();//"Frame2" es el nombre que tu le pusiste a tu 2do jframe
        jFrame.setVisible(true);
        this.setVisible(false);    
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void button_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agregarActionPerformed
        habilitar();
    }//GEN-LAST:event_button_agregarActionPerformed

    private void button_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_borrarActionPerformed
        System.out.println("Activacion de evento");
        if(JOptionPane.YES_NO_OPTION==JOptionPane.showConfirmDialog(null,"Desea eliminar los registros "+"'","Eliminar registros",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)){
            System.out.println("Previo a mensaje y deshabilitacion");
            String Nombre=textfield_dependencia.getText();
            mensaje="Los datos se han eliminado";
            deshabilitar();
            try {
                Conect = new Conexion();
                //PreparedStatement pst=Conect.Eliminar("Correspondencia", "Dependencia", Nombre);
                Conect.Eliminar("Correspondencia", "Dependencia", Nombre);
                JOptionPane.showMessageDialog(null, mensaje);
                //cargarTabla("");
                primeraCarga();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }else{
            deshabilitar();
        }
    }//GEN-LAST:event_button_borrarActionPerformed

    private void button_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_guardarActionPerformed
        if(validacionImporte(textfield_importe.getText())==false){
        JOptionPane.showMessageDialog(null,"El importe no es valido");
        return;
        }
        if(validacionFecha(textfield_fecha.getText())==false){
        JOptionPane.showMessageDialog(null,"La fecha no es valida");
        return;
        }
        if(validacionDependencia(textfield_dependencia.getText())==false){
        JOptionPane.showMessageDialog(null,"La dependencia no es valida");
        return;
        }
        if(validacionConcepto(textfield_concepto.getText())==false){
        JOptionPane.showMessageDialog(null,"El concepto no es valido");
        return;
        }
        if(validacionTurnado(textfield_turnado.getText())==false){
        JOptionPane.showMessageDialog(null,"El turnado no es valido");
        return;
        }   
        
        insertarModificar();
    }//GEN-LAST:event_button_guardarActionPerformed

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
    
    
    
    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        deshabilitar();
    }//GEN-LAST:event_button_cancelarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textfield_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_buscarActionPerformed

    }//GEN-LAST:event_textfield_buscarActionPerformed

    private void textfield_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_buscarKeyReleased
        campoconsulta=String.valueOf(combobox_parametro.getSelectedItem());
        System.out.println("Campo a consultar= "+campoconsulta);
        cargarTabla(textfield_buscar.getText());
    }//GEN-LAST:event_textfield_buscarKeyReleased

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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
