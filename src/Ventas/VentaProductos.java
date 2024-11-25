/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;
import conexion.ConexionMysql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author sergi
 */
public class VentaProductos extends javax.swing.JFrame {
ConexionMysql con =new ConexionMysql();
//Creando un objeto en linea 16 de clase connection , para poder hacer uso de sus parametros 
Connection cn=con.conectar();

  public VentaProductos(JFrame parent) {
    timer.start();
    initComponents();
    this.setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("/imagenes/baner.png")).getImage());
    this.setResizable(false); // Para no permitir reajuste
    cargarProductos(); // Carga productos al iniciar form en la tabla

    comboProductos.addItemListener(e -> {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            cargarDatosProductoSeleccionado();
        }
    }); // Agrega el listener

    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Esto hace que solo se cierre la ventana de login

    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            // Al cerrar, muestra el formulario principal
            parent.setVisible(true);
        }
    });

    // Método de inicialización para la tabla
    DefaultTableModel model = new DefaultTableModel(
        new Object[]{"Clave", "Nombre", "Cantidad", "Precio", "Descripción", "Eliminar"},
        0 // Este 0 indica que inicialmente no hay filas
    );
    jTable1.setModel(model);

    // Configuración del editor de botón en la columna "Eliminar"
    jTable1.getColumnModel().getColumn(5).setCellEditor(new BotonEditar(new JCheckBox(), model));
    jTable1.getColumnModel().getColumn(5).setCellRenderer(new RenderizarBoton());
}

   public void cargarProductos() {
    // Asegúrate de que la conexión esté establecida
    if (cn == null) {
        System.out.println("La conexión a la base de datos no está establecida.");
        return;
    }

    try {
        // Consulta para obtener los productos
        String consulta = "SELECT nombre FROM producto";
        PreparedStatement ps = cn.prepareStatement(consulta); 
        ResultSet rs = ps.executeQuery();
        
        // Limpiar el ComboBox antes de llenarlo
        comboProductos.removeAllItems();
        
        
        
        // Agregar el placeholder como primer elemento
        comboProductos.addItem("Selecciona un producto");
        // Llenar el ComboBox con los resultados
        while (rs.next()) {
            String producto = rs.getString("nombre");
            comboProductos.addItem(producto);  // Añadir el nombre del producto
        }

        // Aplicar el autocompletado al JComboBox
        AutoCompleteDecorator.decorate(comboProductos);  // Esto habilita el autocompletado

        // Cerrar recursos
        rs.close();
        ps.close();
        
    } catch (Exception e) {
        // Manejo de errores, imprimiendo la excepción
        e.printStackTrace();  // Esto te ayudará a ver si algo está fallando
    }
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboProductos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombrep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPreciop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto:");
        jLabel4.setFocusTraversalPolicyProvider(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(comboProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        hora.setBackground(new java.awt.Color(0, 0, 0));
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hora.setOpaque(true);
        jPanel1.add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 130, 20));

        jLabel12.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Clave:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        txtClave.setEditable(false);
        txtClave.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtClave.setEnabled(false);
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 180, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre  producto:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtNombrep.setEditable(false);
        txtNombrep.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtNombrep.setEnabled(false);
        jPanel1.add(txtNombrep, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 180, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Precio  producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtPreciop.setEditable(false);
        txtPreciop.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtPreciop.setEnabled(false);
        jPanel1.add(txtPreciop, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 180, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad  disponible:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtCantidadp.setEditable(false);
        txtCantidadp.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtCantidadp.setEnabled(false);
        jPanel1.add(txtCantidadp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 180, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Descripcion:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtDescripcion.setEditable(false);
        txtDescripcion.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtDescripcion.setEnabled(false);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 180, -1));

        btnAgregar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, 20));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "Cantidad", "Precio", "Descripcion", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 160));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Subtotal:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Iva:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Total a pagar:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("Cambio:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, -1, -1));

        jTextField4.setText("jTextField4");
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 13, 113, -1));

        jTextField6.setText("jTextField6");
        jPanel3.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 113, -1));

        jTextField7.setText("jTextField7");
        jPanel3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 113, -1));

        jTextField9.setText("jTextField9");
        jPanel3.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 173, 113, -1));

        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jButton4.setText("Registrar venta");
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel14.setText("jLabel14");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 50, 20));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel15.setText("Efectivo:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jLabel16.setText("jLabel14");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 50, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 460, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void cargarDatosProductoSeleccionado() {
    try {
        String item = comboProductos.getSelectedItem().toString().trim();
        String query = "SELECT * FROM producto WHERE nombre=?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, item);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            txtClave.setText(rs.getString(1));
            txtNombrep.setText(rs.getString(2));
            txtPreciop.setText(" $ " + rs.getString(3) + " MXN ");
            txtCantidadp.setText(rs.getString(4));
            txtDescripcion.setText(rs.getString(5));
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron registros para mostrar", "Información", JOptionPane.ERROR_MESSAGE);
        }

        rs.close();
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error al cargar los datos del producto", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
// Obtener los datos del producto seleccionado

    String clave = txtClave.getText().trim();
    String nombre = txtNombrep.getText().trim();
    String precioStr = txtPreciop.getText().trim();
    String cantidadStr = jSpinner1.getValue().toString();
    String descripcion = txtDescripcion.getText().trim();

    // Validar que los campos requeridos no estén vacíos
    if (clave.isEmpty() || nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int  cantidadDisponible = Integer.parseInt( txtCantidadp.getText().toString());
    int cantidadIngresada= Integer.parseInt(cantidadStr);
    
    if(cantidadIngresada > cantidadDisponible){
        
JOptionPane.showMessageDialog(this, 
    "No contamos con las piezas solicitadas. La cantidad máxima es " + cantidadDisponible + ".","Error",JOptionPane.ERROR_MESSAGE);        
return;
    }
    // Validar que el precio y la cantidad sean números válidos
    double precio;
    int cantidad;
    try {
        precio = formatearPrecio(precioStr);
        cantidad = Integer.parseInt(cantidadStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio y la cantidad deben ser valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Calcular el total por el producto
    double total = precio * cantidad;

    // Agregar los datos a la tabla, con un valor "X" en la columna de eliminar
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.addRow(new Object[]{clave, nombre, cantidad, total, descripcion, "Eliminar"});

    // Limpiar los campos después de agregar
    limpiarCampos();
}                                         

private void limpiarCampos() {
    txtClave.setText("");
    txtNombrep.setText("");
    txtPreciop.setText("");
    txtDescripcion.setText("");
    txtCantidadp.setText("");
    jSpinner1.setValue(1);
    }//GEN-LAST:event_btnAgregarActionPerformed

    
     
    
    Timer timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener la hora actual
               String fechaHoraActual=null;
       fechaHoraActual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            // Actualizar el texto del JLabel
            hora.setText(fechaHoraActual);
        }

    });

    public double formatearPrecio(String txtPreciop){

String valorLimpio = txtPreciop.replaceAll("[$]|MXN|\\s+", "");
        
        
        return Double.parseDouble(valorLimpio);
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JLabel hora;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField txtCantidadp;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombrep;
    private javax.swing.JTextField txtPreciop;
    // End of variables declaration//GEN-END:variables
}
