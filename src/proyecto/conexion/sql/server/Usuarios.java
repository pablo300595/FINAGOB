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

        jPanel1 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        button_agregar = new javax.swing.JButton();
        button_borrar = new javax.swing.JButton();
        button_guardar = new javax.swing.JButton();
        button_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_consulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombres))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelefono)
                            .addComponent(lblApellidos))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTipoUsuario1)
                    .addComponent(lblNombreUsuario1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ComboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblContraseña1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVcontraseña1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContraseña1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtContraseña2))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombres)
                    .addComponent(lblTipoUsuario1)
                    .addComponent(ComboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseña1)
                    .addComponent(txtContraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos)
                    .addComponent(lblNombreUsuario1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVcontraseña1)
                    .addComponent(txtContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
