package proyecto.conexion.sql.server;

import Clases1.ImagenFondo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaTramites extends javax.swing.JFrame {
    private String accion, id_actualizar,sql;
    private String mensaje;
    DefaultTableModel modelo;
    Conexion Conect;
    String campoconsulta;
    
    String regex;
    Pattern patron;
    int contador;

    public VentanaTramites() {
        initComponents();
        contador=0;
        this.setLocationRelativeTo(null);
        primeraCarga();
        accion= "Insertar"; 
        id_actualizar="";
        sql="";
        deshabilitar();
        campoconsulta="";
        //jDesktopPane1.setBorder(new ImagenFondo());
        
    }
    /*
        Validación de campos usando un método para cada campo. 
        Se realizan evaluaciones con expresiones regulares.
    */
    public boolean validacionDF(String txt){
        regex = "(([0-9]{4})/([0-9]{2}))|(S\u002FN)";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionFolio(String txt){
        regex = "([0-9]{4})";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionBeneficiario(String txt){
        regex = "(([A-Z]{1,20})\u0020([A-Z]{1,20}))|([A-Z]{1,20})";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionConcepto(String txt){
        regex = "((([A-Z]|\u0020){1,50}))";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionDocumentoTipo(String txt){
        regex = "((([A-Z]|\u0020){1,20}))";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
        

    public boolean validacionDocumentoNo(String txt){
        regex = "((([0-9]){4,6}))";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionDocumentoImporte(String txt){
        regex = "(([0-9]){1,20}\\.(([0-9]){1,20}))";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    /*public boolean validacionAreaFecha(String txt){
        regex = "([0-9]{4}-[0-9]{2}-[0-9]{2})";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }*/
    
    public boolean validacionAreaCaja(String txt){
        regex = "(CAJA 1|CAJA 2|CAJA 3| CAJA 4)";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionAreaRecibido(String txt){
        regex = "([A-Z]{1,15}\u0025[A-Z]{1,15})|([A-Z]{1,15})";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    /*public boolean validacionTesoreriaFecha(String txt){
        regex = "([0-9]{4}\u002D[0-9]{2}\u002D[0-9]{2})";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }*/
    public boolean validacionTesoreriaNombre(String txt){
        regex = "([A-Z]{1,15}\u0025[A-Z]{1,15})|([A-Z]{1,15})";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    
    
    public void primeraCarga(){
        String[] titulos={"DF","folio","beneficiario","concepto","tipo_documento",};

        String[] registros= new String[5];
        modelo = new DefaultTableModel(null,titulos);
        try {
            //Mostrar registros en la tabla
            Conect = new Conexion();
            ResultSet consulta= Conect.primerCarga3();
            while(consulta.next()){
                registros[0] = consulta.getString("D_F");
                registros[1] = consulta.getString("folio");
                registros[2] = consulta.getString("beneficiario");
                registros[3] = consulta.getString("concepto");
                registros[4] = consulta.getString("tipo_documento");
                modelo.addRow(registros);               
            }
            //Mostrar titulos de la tabla
            table_consulta.setModel(modelo);
            
        } catch (SQLException ex) {    
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textfield_DF = new javax.swing.JTextField();
        textfield_folio = new javax.swing.JTextField();
        textfield_beneficiario = new javax.swing.JTextField();
        textfield_caja_area = new javax.swing.JTextField();
        textfield_tipo_documento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textfield_no_documento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        textfield_importe_documento = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textfield_recibido_area = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textfield_nombre_tesoreria = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textfield_fecha_tesoreria = new com.toedter.calendar.JDateChooser();
        textfield_concepto = new javax.swing.JComboBox();
        textfield_fecha_area = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_consulta = new javax.swing.JTable();
        button_agregar = new javax.swing.JButton();
        button_borrar = new javax.swing.JButton();
        button_cancelar = new javax.swing.JButton();
        button_guardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 51, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("D.F.");

        jLabel3.setText("Folio");

        jLabel5.setText("Beneficiario");

        jLabel6.setText("Fecha");

        jLabel7.setText("Concepto");

        jLabel8.setText("Caja");

        jLabel9.setText("Tipo");

        jLabel10.setText("No");

        jLabel15.setText("Importe");

        jLabel16.setText("Recibido por");

        jLabel17.setText("Fecha");

        jLabel18.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Documento");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Área Ejecutora");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Tesorería Recibido");

        textfield_fecha_tesoreria.setDateFormatString("yyyy-MM-dd");

        textfield_concepto.setEditable(true);
        textfield_concepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_conceptoActionPerformed(evt);
            }
        });

        textfield_fecha_area.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel17)
                            .addComponent(jLabel9))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textfield_DF, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(textfield_folio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textfield_tipo_documento, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfield_fecha_tesoreria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(textfield_fecha_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel18))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(textfield_no_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textfield_nombre_tesoreria, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textfield_caja_area, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textfield_recibido_area, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(textfield_importe_documento, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textfield_beneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textfield_concepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel4)
                    .addComponent(jLabel19)
                    .addComponent(jLabel11))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(textfield_DF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(textfield_folio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(textfield_beneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(textfield_concepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textfield_tipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(textfield_no_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(textfield_importe_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(textfield_caja_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(textfield_recibido_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(textfield_nombre_tesoreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addComponent(textfield_fecha_tesoreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textfield_fecha_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        button_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        button_agregar.setText("Agregar");
        button_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agregarActionPerformed(evt);
            }
        });

        button_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(button_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(button_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 102, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1202, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setForeground(new java.awt.Color(153, 153, 153));

        jButton4.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1494157185_document.png"))); // NOI18N
        jButton4.setText("Correspondencia");
        jPanel11.add(jButton4);

        jButton5.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1479878567_23.png"))); // NOI18N
        jButton5.setText("Trámites");
        jPanel11.add(jButton5);

        jButton1.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logout.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton1);

        jButton2.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1479878437_phonebook.png"))); // NOI18N
        jButton2.setText("Agenda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton2);

        jPanel6.setBackground(new java.awt.Color(102, 51, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Calibri Light", 1, 32)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 0));
        jLabel20.setText("TRAMITES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/report.png"))); // NOI18N
        jButton3.setText("Reporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(3, 3, 3))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(609, 609, 609)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Metodo que inserta y modifica los datos
    private void insertarModificar(){
        String df,folio,ben,con,tipo_doc,tipo_no,tipo_imp,area_fec,area_fecY,area_fecM,area_fecD,area_caja,
                area_recib,tesoreria_fecY,tesoreria_fecM,tesoreria_fecD,tesoreria_fec,tesoreria_nom;
        int id_contacto;
        df = textfield_DF.getText();
        folio = textfield_folio.getText();
        ben = textfield_beneficiario.getText();
        con = (String)textfield_concepto.getSelectedItem();
        
        tipo_doc=textfield_tipo_documento.getText();
        tipo_no=textfield_no_documento.getText();
        tipo_imp=textfield_importe_documento.getText();
        
        area_caja=textfield_caja_area.getText();
        area_recib=textfield_recibido_area.getText();
        tesoreria_fecY=textfield_fecha_tesoreria.getCalendar().get(Calendar.YEAR)+"";
        tesoreria_fecM=textfield_fecha_tesoreria.getCalendar().get(Calendar.MONTH)+"";
        tesoreria_fecD=textfield_fecha_tesoreria.getCalendar().get(Calendar.DAY_OF_MONTH)+"";
        tesoreria_fec=tesoreria_fecY+"-"+tesoreria_fecM+"-"+tesoreria_fecD;
        
        area_fecY=textfield_fecha_area.getCalendar().get(Calendar.YEAR)+"";
        area_fecM=textfield_fecha_area.getCalendar().get(Calendar.MONTH)+"";
        area_fecD=textfield_fecha_area.getCalendar().get(Calendar.DAY_OF_MONTH)+"";
        area_fec=area_fecY+"-"+area_fecM+"-"+area_fecD;
        System.out.println(tesoreria_fec);
        tesoreria_nom=textfield_nombre_tesoreria.getText();
        id_contacto=contador;
        
        try {
            System.out.println("Previo a conexion..."); 
            Conect = new Conexion(); 
            if(accion.equals("Insertar")){
                sql= "INSERT INTO tramite(D_F,folio,beneficiario,concepto,tipo_documento,no_documento,importe_documento,fecha_area,caja_area,recibido_area,fecha_tesoreria,nombre_tesoreria)"+" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                mensaje="Los datos se han insertado";
                
            }
            
            if((accion.equals("Modificar"))){
                System.out.println("Estoy actualizando...");
                sql= "UPDATE tramite SET D_F = ?, folio= ?,beneficiario= ?,concepto= ?,tipo_documento= ?, no_documento= ?,importe_documento= ?,fecha_area= ?,caja_area = ?,recibido_area= ?,fecha_tesoreria=?,nombre_tesoreria=? WHERE folio = "+"'"+id_actualizar+"'";
                mensaje="Los datos se han actualizado";
         
            }
            PreparedStatement pst=Conect.conexion.prepareStatement(sql);
            pst.setString(1, df);
            pst.setString(2, folio);
            pst.setString(3, ben);
            pst.setString(4, con);
            pst.setString(5, tipo_doc);
            pst.setString(6, tipo_no);
            pst.setString(7, tipo_imp);
            pst.setString(8, area_fec);
            pst.setString(9, area_caja);
            pst.setString(10, area_recib);
            pst.setString(11, tesoreria_fec);
            pst.setString(12, tesoreria_nom);
            
           
            int n=pst.executeUpdate();
            System.out.println("Valor n= "+n);
            if(n>0){
                JOptionPane.showMessageDialog(null, mensaje);
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
            ResultSet consulta =Conect.Consultar2("tramite", "folio", Id);
            //Recorre registros para mostrarlos
            while(consulta.next()){
                textfield_DF.setText(consulta.getString("D_F"));
                textfield_folio.setText(consulta.getString("folio"));
                textfield_beneficiario.setText(consulta.getString("beneficiario"));
                textfield_concepto.getEditor().setItem(consulta.getString("concepto"));
                textfield_tipo_documento.setText(consulta.getString("tipo_documento"));
                textfield_no_documento.setText(consulta.getString("no_documento"));
                textfield_importe_documento.setText(consulta.getString("importe_documento"));
                textfield_fecha_area.setDate(Date.valueOf(consulta.getString("fecha_area")));
                textfield_caja_area.setText(consulta.getString("caja_area"));
                textfield_recibido_area.setText(consulta.getString("recibido_area"));
                textfield_fecha_tesoreria.setDate(Date.valueOf(consulta.getString("fecha_tesoreria")));
                textfield_nombre_tesoreria.setText(consulta.getString("nombre_tesoreria"));           
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
        
        Id=(String)modelo.getValueAt(filas,1);
        System.out.println("Valor ID= "+Id);

        id_actualizar =Id;
        cargarDatos(Id);
    }//GEN-LAST:event_table_consultaMouseClicked

    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        deshabilitar();
    }//GEN-LAST:event_button_cancelarActionPerformed

    private void button_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_borrarActionPerformed
        System.out.println("Activacion de evento");
        if(JOptionPane.YES_NO_OPTION==JOptionPane.showConfirmDialog(null,"Desea eliminar los registros "+"'","Eliminar registros",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)){
            System.out.println("Previo a mensaje y deshabilitacion");
            String Nombre=textfield_folio.getText();
            mensaje="Los datos se han eliminado";
            deshabilitar();
            try {
                Conect = new Conexion();
                //PreparedStatement pst=Conect.Eliminar("tramite", "folio", Nombre);
                Conect.Eliminar("tramite", "folio", Nombre);
                JOptionPane.showMessageDialog(null, mensaje);
                
                primeraCarga();
                JOptionPane.showMessageDialog(null, "se cargó tabla correctamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }else{
            deshabilitar();
        }
    }//GEN-LAST:event_button_borrarActionPerformed

    private void button_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agregarActionPerformed
        habilitar();
    }//GEN-LAST:event_button_agregarActionPerformed

    private void button_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_guardarActionPerformed
    if(validacionDF(textfield_DF.getText())==false){
        JOptionPane.showMessageDialog(null,"Número DF no válido");
        return;
    }
    if(validacionFolio(textfield_folio.getText())==false){
        JOptionPane.showMessageDialog(null,"El Folio no es valido");
        return;
    } 
    if(validacionBeneficiario(textfield_beneficiario.getText())==false){
        JOptionPane.showMessageDialog(null,"El nombre de beneficiario u entidad no cumple con las reglas de nombre");
        return;
    } 
    if(validacionConcepto(textfield_beneficiario.getText())==false){
        JOptionPane.showMessageDialog(null,"El concepto escrito es no válido");
        return;
    }
    if(validacionDocumentoTipo(textfield_tipo_documento.getText())==false){
        JOptionPane.showMessageDialog(null,"El tipo de documento no es valido");
        return;
    }
    if(validacionDocumentoNo(textfield_no_documento.getText())==false){
        JOptionPane.showMessageDialog(null,"El número de documento no es valido");
        return;
    }
   
    if(validacionDocumentoImporte(textfield_importe_documento.getText())==false){
        JOptionPane.showMessageDialog(null,"El importe no es válido");
        return;
    }
    /*if(validacionAreaFecha(textfield_fecha_area.getDateFormatString())==false){
        JOptionPane.showMessageDialog(null,"La fecha de área no es válida");
        return;
    }*/
    if(validacionAreaCaja(textfield_caja_area.getText())==false){
        JOptionPane.showMessageDialog(null,"La caja no es válida");
        return;
    }
    if(validacionAreaRecibido(textfield_recibido_area.getText())==false){
        JOptionPane.showMessageDialog(null,"El nombre de recibido no es válido");
        return;
    }
    /*if(validacionTesoreriaFecha(textfield_fecha_tesoreria.getDateFormatString())==false){
        JOptionPane.showMessageDialog(null,"La fecha no es válida");
        return;
    }*/
    if(validacionTesoreriaNombre(textfield_nombre_tesoreria.getText())==false){
        JOptionPane.showMessageDialog(null,"El nombre no es válido");
        return;
    } 
    insertarModificar();                  
    }//GEN-LAST:event_button_guardarActionPerformed

    private void textfield_conceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_conceptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_conceptoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentanaAgenda va=new VentanaAgenda();
        va.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        VentanaLogin vl1=new VentanaLogin();
        vl1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    //Metodo para deshabilitar componentes de interfaz
    public void deshabilitar(){
        accion="Insertar";
        textfield_DF.setEnabled(false);
        textfield_folio.setEnabled(false);
        textfield_beneficiario.setEnabled(false);
        textfield_concepto.setEnabled(true);
        textfield_tipo_documento.setEnabled(false);
        textfield_caja_area.setEnabled(false);
        textfield_no_documento.setEnabled(false);
        textfield_importe_documento.setEnabled(false);
        textfield_fecha_area.setEnabled(false);
        textfield_caja_area.setEnabled(false);
        textfield_recibido_area.setEnabled(false);
        textfield_fecha_tesoreria.setEnabled(false);
        textfield_nombre_tesoreria.setEnabled(false);
        textfield_concepto.setEnabled(false);
       
        textfield_DF.setText("");
        textfield_folio.setText("");
        textfield_beneficiario.setText("");
        textfield_concepto.getEditor().setItem("NINGUNO");
        textfield_tipo_documento.setText("");
        textfield_caja_area.setText("");
        textfield_no_documento.setText("");
        textfield_importe_documento.setText("");       
        textfield_caja_area.setText("");
        textfield_recibido_area.setText("");
        textfield_nombre_tesoreria.setText("");
        textfield_DF.requestFocus();
        button_guardar.setEnabled(false);
        button_borrar.setEnabled(false);
        button_cancelar.setEnabled(false);
 
    }
    //Método para habilitar componentes de interfaz
    public void habilitar(){
        accion="Insertar";
        
        textfield_DF.setEnabled(true);
        textfield_folio.setEnabled(true);
        textfield_beneficiario.setEnabled(true);
        textfield_concepto.setEnabled(true);
        textfield_tipo_documento.setEnabled(true);
        textfield_caja_area.setEnabled(true);
        textfield_no_documento.setEnabled(true);
        textfield_importe_documento.setEnabled(true);
        textfield_fecha_area.setEnabled(true);
        textfield_caja_area.setEnabled(true);
        textfield_recibido_area.setEnabled(true);
        textfield_fecha_tesoreria.setEnabled(true);
        textfield_nombre_tesoreria.setEnabled(true);
        textfield_concepto.setEnabled(true);
        
        textfield_DF.setText("");
        textfield_folio.setText("");
        textfield_beneficiario.setText("");
        textfield_concepto.getEditor().setItem("NINGUNO");
        textfield_tipo_documento.setText("");
        textfield_caja_area.setText("");
        textfield_no_documento.setText("");
        textfield_importe_documento.setText("");
        textfield_caja_area.setText("");
        textfield_recibido_area.setText("");
        textfield_nombre_tesoreria.setText("");
        textfield_DF.requestFocus();
        button_guardar.setEnabled(true);
        button_borrar.setEnabled(true);
        button_cancelar.setEnabled(true);
    }
    
    //Metodo para cargar tabla de registros
    public void cargarTabla(String valor){
        String[] titulos={"Nombre","Apellido","Departamento","Telefono_Oficina",
        "Correo"};
        String[] registros= new String[6];
        modelo = new DefaultTableModel(null,titulos);
        try {
            //Mostrar registros en la tabla
            Conect = new Conexion();
            ResultSet consulta= Conect.Consultar1("Contacto",campoconsulta ,valor);
            while(consulta.next()){
                registros[0] = consulta.getString("Nombre");
                registros[1] = consulta.getString("Apellido");
                registros[2] = consulta.getString("Departamento");
                registros[3] = consulta.getString("Telefono_oficina");
                registros[4] = consulta.getString("Correo");
                modelo.addRow(registros);               
            }
            //Mostrar titulos de la tabla
            table_consulta.setModel(modelo);
            
        } catch (SQLException ex) {    
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(VentanaTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaTramites().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_agregar;
    private javax.swing.JButton button_borrar;
    private javax.swing.JButton button_cancelar;
    private javax.swing.JButton button_guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_consulta;
    private javax.swing.JTextField textfield_DF;
    private javax.swing.JTextField textfield_beneficiario;
    private javax.swing.JTextField textfield_caja_area;
    private javax.swing.JComboBox textfield_concepto;
    private com.toedter.calendar.JDateChooser textfield_fecha_area;
    private com.toedter.calendar.JDateChooser textfield_fecha_tesoreria;
    private javax.swing.JTextField textfield_folio;
    private javax.swing.JTextField textfield_importe_documento;
    private javax.swing.JTextField textfield_no_documento;
    private javax.swing.JTextField textfield_nombre_tesoreria;
    private javax.swing.JTextField textfield_recibido_area;
    private javax.swing.JTextField textfield_tipo_documento;
    // End of variables declaration//GEN-END:variables
}
