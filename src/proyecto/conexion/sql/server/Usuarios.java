package proyecto.conexion.sql.server;

import Clases1.ImagenFondo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuarios extends javax.swing.JFrame {
    private String accion, id_actualizar,sql;
    private String mensaje;
    DefaultTableModel modelo;
    Conexion Conect;
    String campoconsulta;
    String regex;
    Pattern patron;
    
    
    public Usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        primeraCarga();
        accion= "Insertar"; 
        id_actualizar="";
        sql="";
        deshabilitar();
        campoconsulta="";
        //jDesktopPane1.setBorder(new ImagenFondo());
        System.out.println("Ok1");
    }
    
    public boolean validacionNombre(String txt){
        regex = "[A-Za-z]+ [\u0020][A-Za-z]+|[A-Za-z]+";
        patron = Pattern.compile(regex);
			Matcher emparejador = patron.matcher(txt);
			boolean esCoincidente = emparejador.matches();
			return esCoincidente;
		}
    
    public boolean validacionApellido(String txt){
        regex = "[A-Za-z]+ [\u0020][A-Za-z]+|[A-Za-z]+";
        patron = Pattern.compile(regex);
			Matcher emparejador = patron.matcher(txt);
			boolean esCoincidente = emparejador.matches();
			return esCoincidente;
    }
    
    public boolean validacionTelefono(String txt){
        regex = "([0-9][0-9][0-9])+-+[0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
        patron = Pattern.compile(regex);
			Matcher emparejador = patron.matcher(txt);
			boolean esCoincidente = emparejador.matches();
			return esCoincidente;
    }
    
    public boolean validacionContraseña(String txt){
        regex = "[A-Za-z0-9]+";
        patron = Pattern.compile(regex);
                        Matcher emparejador = patron.matcher(txt);
			boolean esCoincidente = emparejador.matches();
			return esCoincidente;
    }
    
    public boolean validacionUsuario(String txt){
        regex = "[A-Za-z0-9]+";
        patron = Pattern.compile(regex);
                        Matcher emparejador = patron.matcher(txt);
			boolean esCoincidente = emparejador.matches();
			return esCoincidente;
    }
    
    private void primeraCarga(){
        String[] titulos={"Nombre","Apellido","Telefono","NombreUsuario","Contraseña","TipoUsuario"};

        String[] registros= new String[6];
        modelo = new DefaultTableModel(null,titulos);
        try {
            //Mostrar registros en la tabla
            Conect = new Conexion();
            ResultSet consulta= Conect.primerCarga2();
            while(consulta.next()){
                registros[0] = consulta.getString("Nombre");
                registros[1] = consulta.getString("Apellido");
                registros[2] = consulta.getString("Telefono");
                registros[3] = consulta.getString("NombreUsuario");
                registros[4] = consulta.getString("Contraseña");
                registros[5] = consulta.getString("TipoUsuario");
                modelo.addRow(registros); 
                System.out.println("Ok2");
            }
            //Mostrar titulos de la tabla
            table_consulta.setModel(modelo);
            System.out.println("Ok3");
            
        } catch (SQLException ex) {    
            JOptionPane.showMessageDialog(null,ex);
        }
        System.out.println("Ok4");
    }
    
    private void deshabilitar(){
        accion="Insertar";
        txtNombres.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtContraseña1.setEnabled(false);
        txtContraseña2.setEnabled(false);
        ComboTipoUsuario.setEnabled(false);
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtUsuario.setText("");
        txtContraseña1.setText("");
        txtContraseña2.setText("");
        txtNombres.requestFocus();
        button_guardar.setEnabled(false);
        button_borrar.setEnabled(false);
        button_cancelar.setEnabled(false);
 System.out.println("Ok5");
    }
    
    public void habilitar(){
        accion="Insertar";
        txtNombres.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtContraseña1.setEnabled(true);
        txtContraseña2.setEnabled(true);
        ComboTipoUsuario.setEnabled(true);
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtUsuario.setText("");
        txtContraseña1.setText("");
        txtContraseña2.setText("");
        txtNombres.requestFocus();
        button_guardar.setEnabled(true);
        button_borrar.setEnabled(true);
        button_cancelar.setEnabled(true);
        System.out.println("Ok6");
    }
    
     //Metodo para cargar tabla de registros
    public void cargarTabla(String valor){
        String[] titulos={"Nombre","Apellido","Telefono","Nombre de Usuario",
        "Contraseña","Tipo de Usuario"};
        String[] registros= new String[6];
        modelo = new DefaultTableModel(null,titulos);
        try {
            //Mostrar registros en la tabla
            Conect = new Conexion();
            ResultSet consulta= Conect.Consultar1("Usuarios",campoconsulta ,valor);
            while(consulta.next()){
                registros[0] = consulta.getString("Nombre");
                registros[1] = consulta.getString("Apellido");
                registros[2] = consulta.getString("Telefono");
                registros[3] = consulta.getString("NombreUsuario");
                registros[4] = consulta.getString("Contraseña");
                registros[4] = consulta.getString("TipoUsuario");
                modelo.addRow(registros); 
                System.out.println("Ok7");
            }
            //Mostrar titulos de la tabla
            table_consulta.setModel(modelo);
            System.out.println("Ok8");
            
        } catch (SQLException ex) {    
            JOptionPane.showMessageDialog(null,ex);
        }
        System.out.println("Ok9");
    }
    
    private void cargarDatos(String Id){
        try {
            Conect= new Conexion();
            ResultSet consulta =Conect.Consultar2("Usuarios", "Nombre", Id);
            //Recorre registros para mostrarlos
            while(consulta.next()){
                txtNombres.setText(consulta.getString("Nombre"));
                txtApellidos.setText(consulta.getString("Apellido"));
                txtTelefono.setText(consulta.getString("Telefono"));
                txtUsuario.setText(consulta.getString("NombreUsuario"));
                txtContraseña1.setText(consulta.getString("Contraseña"));
                txtContraseña2.setText(consulta.getString("Contraseña"));
                ComboTipoUsuario.setSelectedItem(consulta.getString("TipoUsuario"));
                System.out.println("Ok10");
            }
            
        } catch (SQLException ex) {}
        System.out.println("Ok11");
    }
    
    private void insertarModificar(){
        String nom,ape,tel,nomUsu,contra,tipUsu;
        nom = txtNombres.getText();
        ape = txtApellidos.getText();
        tel = txtTelefono.getText();
        nomUsu = txtUsuario.getText();
        contra = txtContraseña1.getText();
        tipUsu = ComboTipoUsuario.getSelectedItem().toString();
        try {
            System.out.println("Previo a conexion..."); 
            Conect = new Conexion(); 
            if(accion.equals("Insertar")){
                sql= "INSERT INTO Usuarios( Nombre,Apellido,Telefono,NombreUsuario,Contraseña,TipoUsuario)"+" VALUES(?,?,?,?,?,?)";
                mensaje="Los datos se han insertado";
                deshabilitar();
            }
            
            if((accion.equals("Modificar"))){
                System.out.println("Estoy actualizando...");
                sql= "UPDATE Contacto SET Nombre = ?, Apellido = ?,Telefono = ?,NombreUsuario = ?,Contraseña = ?,TipoUsuario = ? WHERE Nombre = "+"'"+id_actualizar+"'";
                mensaje="Los datos se han actualizado";
                deshabilitar();
            }
            PreparedStatement pst=Conect.conexion.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, ape);
            pst.setString(3, tel);
            pst.setString(4, nomUsu);
            pst.setString(5, contra);
            pst.setString(6, tipUsu);
           
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        ComboTipoUsuario = new javax.swing.JComboBox();
        lblTipoUsuario1 = new javax.swing.JLabel();
        lblNombreUsuario1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña1 = new javax.swing.JPasswordField();
        lblContraseña1 = new javax.swing.JLabel();
        lblVcontraseña1 = new javax.swing.JLabel();
        txtContraseña2 = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        button_agregar = new javax.swing.JButton();
        button_borrar = new javax.swing.JButton();
        button_guardar = new javax.swing.JButton();
        button_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_consulta = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 0, 0)));

        lblNombres.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombres.setText("NOMBRE(S):");

        lblApellidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblApellidos.setText("APELLIDO(S):");

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefono.setText("TELEFONO:");

        ComboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONA EL TIPO ", "ADMINISTRADOR", "UsuarioFINAGOB" }));

        lblTipoUsuario1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTipoUsuario1.setText("TIPO DE USUARIO:");

        lblNombreUsuario1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombreUsuario1.setText("NOMBRE DE USUARIO:");

        lblContraseña1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblContraseña1.setText("CONTRASEÑA:");

        lblVcontraseña1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblVcontraseña1.setText("VERIFICA CONTRASEÑA:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNombres)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblApellidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidos)))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblTipoUsuario1))
                            .addComponent(lblNombreUsuario1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVcontraseña1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblContraseña1)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContraseña1)
                            .addComponent(txtContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(lblTelefono)
                        .addGap(17, 17, 17)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtContraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblContraseña1)
                        .addGap(18, 18, 18)
                        .addComponent(lblVcontraseña1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombres))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidos)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoUsuario1)
                            .addComponent(ComboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreUsuario1)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(button_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(button_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_agregar)
                    .addComponent(button_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        table_consulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0)));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escudo.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 1, 48)); // NOI18N
        jLabel13.setText("AGENDA ELECTRÓNICA");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FINAGOBLOGO.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel17.setText("USUARIOS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel14)
                .addGap(205, 205, 205)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel14))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel17))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 0, 0));
        jPanel9.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(51, 153, 0));
        jPanel10.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jButton1.setText("Cambiar de Cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(491, 491, 491)
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/oie_13305OIlPU0hG.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addGap(54, 54, 54)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agregarActionPerformed
        habilitar();
    }//GEN-LAST:event_button_agregarActionPerformed

    private void button_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_borrarActionPerformed
        if(JOptionPane.YES_NO_OPTION==JOptionPane.showConfirmDialog(null,"Desea eliminar los registros "+"'","Eliminar registros",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)){
            System.out.println("Previo a mensaje y deshabilitacion");
            String Nombre=txtNombres.getText();
            mensaje="Los datos se han eliminado";
            deshabilitar();
            try {
                Conect = new Conexion();
                Conect.Eliminar("Usuarios", "Nombre", Nombre);
                JOptionPane.showMessageDialog(null, mensaje);
                primeraCarga();
                JOptionPane.showMessageDialog(null, "se cargó tabla correctamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }else{deshabilitar();}
    }//GEN-LAST:event_button_borrarActionPerformed

    private void button_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_guardarActionPerformed
        //Comprobacion de campos al presionar guardar
        if(validacionNombre(txtNombres.getText())==false){
            JOptionPane.showMessageDialog(null,"El Nombre no es valido");
            return;
        }
        if(validacionApellido(txtApellidos.getText())==false){
            JOptionPane.showMessageDialog(null,"El Apellido no es valido");
            return;
        }
        if(validacionTelefono(txtTelefono.getText())==false){
            JOptionPane.showMessageDialog(null,"El telefono de oficina no es valido");
            return;
        }
        if(validacionUsuario(txtUsuario.getText()) ==false) {
            JOptionPane.showMessageDialog(null,"El Nombre de Usuario no es valido");
            return;
        }
        
        String contra1,contra2;
        contra1 = txtContraseña1.getText();
        contra2 = txtContraseña2.getText();
        if(contra1 == contra2){
            if(validacionContraseña(txtContraseña1.getText()) ==false) {
            JOptionPane.showMessageDialog(null,"La contraseña no es vaida");
            return;
        }
        } 
        if(contra1 != contra2){
            JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
            txtContraseña1.setText("");
            txtContraseña2.setText("");
            return;
        }
        
        
  
        insertarModificar();
    }//GEN-LAST:event_button_guardarActionPerformed

    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        deshabilitar();
    }//GEN-LAST:event_button_cancelarActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaAgenda jFrame= new VentanaAgenda();//"Frame2" es el nombre que tu le pusiste a tu 2do jframe
        jFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboTipoUsuario;
    private javax.swing.JButton button_agregar;
    private javax.swing.JButton button_borrar;
    private javax.swing.JButton button_cancelar;
    private javax.swing.JButton button_guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblContraseña1;
    private javax.swing.JLabel lblNombreUsuario1;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoUsuario1;
    private javax.swing.JLabel lblVcontraseña1;
    private javax.swing.JTable table_consulta;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtContraseña1;
    private javax.swing.JPasswordField txtContraseña2;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
