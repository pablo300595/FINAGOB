package proyecto.conexion.sql.server;

import Clases1.ImagenFondo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaAgenda extends javax.swing.JFrame {
    private String accion, id_actualizar,sql;
    private String mensaje;
    DefaultTableModel modelo;
    Conexion Conect;
    String campoconsulta;
    String regex;
    Pattern patron;

    public VentanaAgenda() {
        initComponents();
        this.setLocationRelativeTo(null);
        primeraCarga();
        accion= "Insertar"; 
        id_actualizar="";
        sql="";
        deshabilitar();
        campoconsulta="";
        jDesktopPane1.setBorder(new ImagenFondo());
        
    }
    /*
        Validación de campos usando un método para cada campo. 
        Se realizan evaluaciones con expresiones regulares.
    */
    public boolean validacionCorreo(String txt){
        String[] listaTextos=txt.split(",");
        regex = "[A-Za-z]+@[a-z]+\\.[a-z]+";
        patron = Pattern.compile(regex);
		for (String texto : listaTextos) {
			Matcher emparejador = patron.matcher(texto);
			boolean esCoincidente = emparejador.matches();
			if (esCoincidente) {
				return true;
			}
		}
        return false;
    }
    
    public boolean validacionNombre(String txt){
        regex = "(([a-zA-Z])+\u0020([a-zA-Z])+|([a-zA-Z])+)";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionApellido(String txt){
        regex = "(([a-zA-Z])+\u0020([a-zA-Z])+)";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionDepartamento(String txt){
        regex = "(([a-zA-Z])+)";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    
    
    public boolean validacionSecretaria(String txt){
        regex = "(([a-zA-Z])+)";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionTelefonoOficina(String txt){
        regex = "([0-9][0-9][0-9])-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
        patron = Pattern.compile(regex);
	Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionTelefonoCelular(String txt){
        regex = "([0-9][0-9][0-9])-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.matches();
        return esCoincidente;
    }
    
    public boolean validacionDomicilio(String txt){
        regex = "(([a-zA-Z])+)";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.find();
        return esCoincidente;
    }
    
    public boolean validacionDireccion(String txt){
        regex = "(([a-zA-Z])+)";
        patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(txt);
        boolean esCoincidente = emparejador.find();
        return esCoincidente;
    }
    
    private void primeraCarga(){
        String[] titulos={"Nombre","Apellido","Departamento","Telefono_Oficina",
        "Correo"};

        String[] registros= new String[5];
        modelo = new DefaultTableModel(null,titulos);
        try {
            //Mostrar registros en la tabla
            Conect = new Conexion();
            ResultSet consulta= Conect.primerCarga();
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
    
        //Metodo para deshabilitar componentes de interfaz
    private void deshabilitar(){
        accion="Insertar";
        textfield_nombre.setEnabled(false);
        textfield_apellido.setEnabled(false);
        textfield_departamento.setEnabled(false);
        textfield_direccion.setEnabled(false);
        textfield_secretaria.setEnabled(false);
        textfield_telefono_oficina.setEnabled(false);
        textfield_telefono_celular.setEnabled(false);
        textfield_correo.setEnabled(false);
        textarea_observaciones.setEnabled(false);
        textfield_domicilio.setEnabled(false);
        textfield_nombre.setText("");
        textfield_apellido.setText("");
        textfield_departamento.setText("");
        textfield_direccion.setText("");
        textfield_secretaria.setText("");
        textfield_telefono_oficina.setText("");
        textfield_telefono_celular.setText("");
        textfield_correo.setText("");
        textarea_observaciones.setText("");
        textfield_buscar.setText("");
        textfield_domicilio.setText("");
        textfield_nombre.requestFocus();
        button_guardar.setEnabled(false);
        button_borrar.setEnabled(false);
        button_cancelar.setEnabled(false);
 
    }
    //Método para habilitar componentes de interfaz
    public void habilitar(){
        accion="Insertar";
        textfield_nombre.setEnabled(true);
        textfield_apellido.setEnabled(true);
        textfield_departamento.setEnabled(true);
        textfield_direccion.setEnabled(true);
        textfield_secretaria.setEnabled(true);
        textfield_telefono_oficina.setEnabled(true);
        textfield_telefono_celular.setEnabled(true);
        textfield_correo.setEnabled(true);
        textarea_observaciones.setEnabled(true);
        textfield_domicilio.setEnabled(true);
        textfield_nombre.setText("");
        textfield_apellido.setText("");
        textfield_departamento.setText("");
        textfield_direccion.setText("");
        textfield_secretaria.setText("");
        textfield_telefono_oficina.setText("");
        textfield_telefono_celular.setText("");
        textfield_correo.setText("");
        textarea_observaciones.setText("");
        textfield_buscar.setText("");
        textfield_domicilio.setText("");
        textfield_nombre.requestFocus();
        button_guardar.setEnabled(true);
        button_borrar.setEnabled(true);
        button_cancelar.setEnabled(true);
    }
    
    //Metodo para cargar tabla de registros
    public void cargarTabla(String valor){
        String[] titulos={"Nombre","Apellido","Departamento","Telefono_Oficina",
        "Correo"};
        String[] registros= new String[5];
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
    
        //Metodo que inserta y modifica los datos
    private void insertarModificar(){
        String nom,ape,dep,dir,sec,dom,telof,telcel,corr,observ;
        nom = textfield_nombre.getText();
        ape = textfield_apellido.getText();
        dep = textfield_departamento.getText();
        dir = textfield_direccion.getText();
        sec = textfield_secretaria.getText();
        dom = textfield_domicilio.getText();
        telof = textfield_telefono_oficina.getText();
        telcel = textfield_telefono_celular.getText();
        corr = textfield_correo.getText();
        observ = textarea_observaciones.getText();
        try {
            System.out.println("Previo a conexion..."); 
            Conect = new Conexion(); 
            if(accion.equals("Insertar")){
                sql= "INSERT INTO Contacto( Nombre,Apellido,Departamento,Direccion,Secretaria,Domicilio,Telefono_oficina,Telefono_celular,Correo,Observaciones)"+" VALUES(?,?,?,?,?,?,?,?,?,?)";
                mensaje="Los datos se han insertado";
                deshabilitar();
            }
            
            if((accion.equals("Modificar"))){
                System.out.println("Estoy actualizando...");
                sql= "UPDATE Contacto SET Nombre = ?, Apellido = ?,Departamento = ?,Direccion = ?,Secretaria = ?, Domicilio = ?,Telefono_oficina = ?,Telefono_celular = ?,Correo = ?,Observaciones = ? WHERE Nombre = "+"'"+id_actualizar+"'";
                mensaje="Los datos se han actualizado";
                deshabilitar();
            }
            PreparedStatement pst=Conect.conexion.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, ape);
            pst.setString(3, dep);
            pst.setString(4, dir);
            pst.setString(5, sec);
            pst.setString(6, dom);
            pst.setString(7, telof);
            pst.setString(8, telcel);
            pst.setString(9, corr);
            pst.setString(10, observ);
           
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
            ResultSet consulta =Conect.Consultar2("Contacto", "Nombre", Id);
            //Recorre registros para mostrarlos
            while(consulta.next()){
                textfield_nombre.setText(consulta.getString("Nombre"));
                textfield_apellido.setText(consulta.getString("Apellido"));
                textfield_departamento.setText(consulta.getString("Departamento"));
                textfield_direccion.setText(consulta.getString("Direccion"));
                textfield_secretaria.setText(consulta.getString("Secretaria"));
                textfield_domicilio.setText(consulta.getString("Domicilio"));
                textfield_telefono_oficina.setText(consulta.getString("Telefono_oficina"));
                textfield_telefono_celular.setText(consulta.getString("Telefono_celular"));
                textfield_correo.setText(consulta.getString("Correo"));
                textarea_observaciones.setText(consulta.getString("Observaciones"));         
            }
            
        } catch (SQLException ex) {}
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textfield_nombre = new javax.swing.JTextField();
        textfield_apellido = new javax.swing.JTextField();
        textfield_departamento = new javax.swing.JTextField();
        textfield_direccion = new javax.swing.JTextField();
        textfield_secretaria = new javax.swing.JTextField();
        textfield_domicilio = new javax.swing.JTextField();
        textfield_telefono_oficina = new javax.swing.JTextField();
        textfield_telefono_celular = new javax.swing.JTextField();
        textfield_correo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textarea_observaciones = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_consulta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        textfield_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combobox_parametro = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        button_agregar = new javax.swing.JButton();
        button_borrar = new javax.swing.JButton();
        button_guardar = new javax.swing.JButton();
        button_cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Nombre");

        jLabel3.setText("Departamento");

        jLabel4.setText("Dirección");

        jLabel5.setText("Secretaría");

        jLabel6.setText("Domicilio");

        jLabel7.setText("Telefono Oficina");

        jLabel8.setText("Telefono Celular");

        jLabel9.setText("Correo Electrónico");

        jLabel10.setText("Observaciones");

        jLabel11.setText("Apellido");

        textarea_observaciones.setColumns(20);
        textarea_observaciones.setRows(5);
        jScrollPane2.setViewportView(textarea_observaciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textfield_apellido)
                                    .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfield_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfield_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textfield_secretaria, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(textfield_domicilio))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textfield_telefono_celular, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(textfield_telefono_oficina))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textfield_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(textfield_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textfield_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textfield_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textfield_secretaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textfield_domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textfield_telefono_oficina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textfield_telefono_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

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
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

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

        combobox_parametro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Departamento", "Direccion", "Secretaria", "Domicilio", "Telefono_oficina", "Telefono_celular", "Correo", "Observaciones" }));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1490261946_Search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combobox_parametro, 0, 400, Short.MAX_VALUE)
                    .addComponent(textfield_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(354, 354, 354))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combobox_parametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Fairview Regular", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText("AGENDA ELECTRONICA");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(552, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Correspondencia");
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

        jButton3.setText("Tramites");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

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

        button_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1490260266_Save.png"))); // NOI18N
        button_guardar.setText("Guardar");
        button_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_guardarActionPerformed(evt);
            }
        });

        button_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1490260321_Close_Icon.png"))); // NOI18N
        button_cancelar.setText("Cancelar");
        button_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(button_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(button_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_agregar)
                    .addComponent(button_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento al presionar un registro de la tabla
    private void table_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_consultaMouseClicked
        
        habilitar();
        int filas;
        String Id;
        accion="Modificar";
        filas= table_consulta.getSelectedRow();        
        Id=(String)modelo.getValueAt(filas,0);
        System.out.println("Valor ID= "+Id);
        id_actualizar =Id;
        cargarDatos(Id);
        
        
    }//GEN-LAST:event_table_consultaMouseClicked

    private void textfield_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_buscarActionPerformed
        
    }//GEN-LAST:event_textfield_buscarActionPerformed

    private void textfield_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_buscarKeyReleased
        campoconsulta=String.valueOf(combobox_parametro.getSelectedItem());
        System.out.println("Campo a consultar= "+campoconsulta);
        cargarTabla(textfield_buscar.getText());
    }//GEN-LAST:event_textfield_buscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaCorrespondencia jFrame= new VentanaCorrespondencia();
        jFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        deshabilitar();
    }//GEN-LAST:event_button_cancelarActionPerformed

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

    private void button_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agregarActionPerformed
        habilitar();
    }//GEN-LAST:event_button_agregarActionPerformed

    private void button_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_guardarActionPerformed
    //Comprobacion de campos al presionar guardar
    if(validacionNombre(textfield_nombre.getText())==false){
        JOptionPane.showMessageDialog(null,"El Nombre no es valido");
        return;
    }
    if(validacionCorreo(textfield_correo.getText())==false){
        JOptionPane.showMessageDialog(null,"El correo no es valido");
        return;
    }
     
    if(validacionApellido(textfield_apellido.getText())==false){
        JOptionPane.showMessageDialog(null,"El Apellido no es valido");
        return;
    } 
    if(validacionDepartamento(textfield_departamento.getText())==false){
        JOptionPane.showMessageDialog(null,"El Departamento no es valido");
        return;
    } 
    if(validacionSecretaria(textfield_secretaria.getText())==false){
        JOptionPane.showMessageDialog(null,"La secretaria no es valida");
        return;
    }
    if(validacionTelefonoOficina(textfield_telefono_oficina.getText())==false){
        JOptionPane.showMessageDialog(null,"El telefono de oficina no es valido");
        return;
    }
    if(validacionTelefonoCelular(textfield_telefono_celular.getText())==false){
        JOptionPane.showMessageDialog(null,"El telefono celular no es valido");
        return;
    }
    if(validacionDireccion(textfield_direccion.getText())==false){
        JOptionPane.showMessageDialog(null,"Direccion no valida");
        return;
    }
    if(validacionDomicilio(textfield_domicilio.getText())==false){
        JOptionPane.showMessageDialog(null,"Domicilio no valido");
        return;
    }    
    insertarModificar();                  
    }//GEN-LAST:event_button_guardarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        VentanaTramites jFrame= new VentanaTramites();
        jFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_agregar;
    private javax.swing.JButton button_borrar;
    private javax.swing.JButton button_cancelar;
    private javax.swing.JButton button_guardar;
    private javax.swing.JComboBox combobox_parametro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_consulta;
    private javax.swing.JTextArea textarea_observaciones;
    private javax.swing.JTextField textfield_apellido;
    private javax.swing.JTextField textfield_buscar;
    private javax.swing.JTextField textfield_correo;
    private javax.swing.JTextField textfield_departamento;
    private javax.swing.JTextField textfield_direccion;
    private javax.swing.JTextField textfield_domicilio;
    private javax.swing.JTextField textfield_nombre;
    private javax.swing.JTextField textfield_secretaria;
    private javax.swing.JTextField textfield_telefono_celular;
    private javax.swing.JTextField textfield_telefono_oficina;
    // End of variables declaration//GEN-END:variables
}
