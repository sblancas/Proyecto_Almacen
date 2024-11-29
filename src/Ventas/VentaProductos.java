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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
String usuarioVenta="";
// Declarar una variable para mantener el total acumulado
private double totalAcumulado = 0.0;
private int cantidadAcumulado = 0;


  public VentaProductos(JFrame parent,String rol, String usuario) {
    timer.start();
    initComponents();
    this.setLocationRelativeTo(null);
    this.setTitle( "Bienvenido " + rol+": "+usuario+ "!");
    usuarioVenta=usuario;
    this.setResizable(false); // Para no permitir reajuste
    setIconImage(new ImageIcon(getClass().getResource("/imagenes/baner.png")).getImage());
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
}

  private void reiniciarVenta() {
  
      if (Integer.parseInt(txtCantidadp.getText())==0) {
          cargarProductos();
      }
      // Reinicia los campos y valores relacionados con la venta
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Vaciar la tabla

    totalAcumulado = 0.0; // Reinicia el total acumulado
    lblTotal.setText("$0.00"); // Actualiza el label del total acumulado

    jEfectivo.setText(""); // Limpia el campo de efectivo ingresado
    jTextField6.setText(""); // Limpia el campo de cambio
    cantidadProductos.setText("");
    cantidadAcumulado = 0;

}
   public void cargarProductos() {
   // Recargar los productos disponibles en el ComboBox
    DefaultComboBoxModel modeloComboBox = (DefaultComboBoxModel) comboProductos.getModel();
    modeloComboBox.removeAllElements();

    // Cargar nuevamente los productos que tienen cantidad > 0
    String query = "SELECT * FROM producto WHERE cantidad > 0";
    try {
        PreparedStatement ps = cn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            String nombreProducto = rs.getString("nombre");
            modeloComboBox.addElement(nombreProducto);  // Agregar producto al ComboBox
        }
// Seleccionar el primer elemento (solo si el ComboBox no está vacío)
        if (comboProductos.getItemCount() > 0) {
            comboProductos.setSelectedIndex(0); // Selecciona el primer producto automáticamente
            cargarDatosProductoSeleccionado();  // Cargar los datos para el primer producto
        }
        // Aplicar el autocompletado al JComboBox
        AutoCompleteDecorator.decorate(comboProductos);  // Esto habilita el autocompletado

        // Cerrar recursos
         rs.close();
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al recargar los productos.", "Error", JOptionPane.ERROR_MESSAGE);
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
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        lblTotal = new javax.swing.JTextField();
        btnRegistrarVenta = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jEfectivo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cantidadProductos = new javax.swing.JTextField();

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
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, 30));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, -1));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "Cantidad", "Precio", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 160));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Total a pagar:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        jTextField6.setEditable(false);
        jPanel3.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 80, -1));

        lblTotal.setEditable(false);
        jPanel3.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 113, 20));

        btnRegistrarVenta.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnRegistrarVenta.setText("Registrar venta");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, 150, 50));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel15.setText("Efectivo:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));
        jPanel3.add(jEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 80, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("Cantidad Productos");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        cantidadProductos.setEditable(false);
        jPanel3.add(cantidadProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 113, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 460, 180));

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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
// Guardar el producto seleccionado antes de cualquier cambio
    String productoSeleccionado = comboProductos.getSelectedItem().toString();

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

    // Validar la cantidad disponible
    int cantidadDisponible = Integer.parseInt(txtCantidadp.getText().trim());
    int cantidadIngresada = Integer.parseInt(cantidadStr);

    
    if (cantidadIngresada > cantidadDisponible) {
        
        if(cantidadDisponible == 0){
            JOptionPane.showMessageDialog(this, 
            "No contamos con piezas disponibles en el inventario.", 
            "Error", JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        JOptionPane.showMessageDialog(this, 
            "No contamos con las piezas solicitadas. La cantidad máxima es " + cantidadDisponible + ".", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar que el precio y la cantidad sean números válidos
    double precio;
    int cantidad;
    try {
        precio = formatearPrecio(precioStr); // Convierte el precio a formato decimal usando tu método
        cantidad = Integer.parseInt(cantidadStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio y la cantidad deben ser valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Calcular el total por el producto
    double total = precio * cantidad;

    // Insertar el registro al inicio de la tabla
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.insertRow(0, new Object[]{clave, nombre, cantidad, total, descripcion});
    
    // Actualizar el total acumulado
    totalAcumulado += total;
    cantidadAcumulado +=cantidad;
    lblTotal.setText(String.format("$%.2f", totalAcumulado));
    cantidadProductos.setText(String.valueOf(cantidadAcumulado));

    // Reducir la cantidad del producto en la base de datos
    reducirCantidadProducto(clave, cantidad);

    // Limpiar los campos después de agregar el producto
    limpiarCampos();

    // Cargar nuevamente los datos del producto seleccionado
    cargarDatosProductoSeleccionado();  // Este método recarga la información con la nueva cantidad

    // Restaurar la selección del ComboBox
    comboProductos.setSelectedItem(productoSeleccionado);
    }
    
    
    public int obtenerCantidadDeInventario(String clave) {
    int cantidad = 0; // Inicializamos la cantidad como 0 por defecto
    String query = "SELECT cantidad FROM producto WHERE id = ?";
    
    try {
        PreparedStatement ps = cn.prepareStatement(query); // Usamos la conexión existente
        ps.setString(1, clave); // Pasamos la clave como parámetro
        ResultSet rs = ps.executeQuery(); // Ejecutamos la consulta
        
        if (rs.next()) {
            cantidad = rs.getInt("cantidad"); // Obtenemos la cantidad si existe el registro
        }
        
        rs.close(); // Cerramos el ResultSet
        ps.close(); // Cerramos el PreparedStatement
    } catch (SQLException e) {
        e.printStackTrace(); // Manejo básico de errores
        JOptionPane.showMessageDialog(null, "Error al obtener la cantidad del producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    return cantidad; // Devolvemos la cantidad obtenida
}

    private void reducirCantidadProducto(String clave, int cantidad) {
     try {
        // Reducir la cantidad en la base de datos
        String query = "UPDATE producto SET cantidad = cantidad - ? WHERE id = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setInt(1, cantidad);  // Restamos la cantidad del producto
        ps.setString(2, clave);   // Filtramos por la clave del producto
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Cantidad actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al reducir la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   

// Método auxiliar para limpiar los campos de entrada
private void limpiarCampos() {
    txtClave.setText("");
    txtNombrep.setText("");
    txtPreciop.setText("");
    txtCantidadp.setText("");
    txtDescripcion.setText("");
    jSpinner1.setValue(1);  // Resetear el spinner
    comboProductos.setSelectedIndex(0);  // Resetear el combo
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = jTable1.getSelectedRow();

    // Verificar si se ha seleccionado una fila válida
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener el valor de la clave del producto que se va a eliminar
    String clave = (String) jTable1.getValueAt(filaSeleccionada, 0);  // Asumiendo que la clave está en la primera columna

    // Obtener la cantidad del producto que se va a eliminar
    int cantidad = (int) jTable1.getValueAt(filaSeleccionada, 2);  // Asumiendo que la cantidad está en la tercera columna

    // Obtener el total del producto que se va a eliminar
    double totalEliminado = (double) jTable1.getValueAt(filaSeleccionada, 3);  // Asumiendo que el total está en la cuarta columna

    // Eliminar el producto de la tabla
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.removeRow(filaSeleccionada);

    // Actualizar la cantidad del producto en la base de datos
    incrementarCantidadEnBaseDeDatos(clave, cantidad);

    // Actualizar el total acumulado
    totalAcumulado -= totalEliminado;  // Restamos el total eliminado
    cantidadAcumulado-=cantidad;
    lblTotal.setText(String.format("$%.2f", totalAcumulado));
    cantidadProductos.setText(String.valueOf(cantidadAcumulado));

    // Recargar el producto con la nueva cantidad
    recargarProductoSeleccionado(clave);  // Llamamos al método para actualizar el producto con la cantidad actualizada

    // Si después de eliminar la fila, la tabla ya no tiene productos, mostramos un mensaje adecuado
    if (jTable1.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No hay productos en la tabla.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }    }//GEN-LAST:event_jButton1ActionPerformed

    private void recargarProductoSeleccionado(String clave) {
    // Cargar los datos del producto con la nueva cantidad desde la base de datos
    try {
        String query = "SELECT * FROM producto WHERE id=?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, clave);
        ResultSet rs = ps.executeQuery(); 

        if (rs.next()) {
            // Obtener la nueva cantidad después de la eliminación
            int nuevaCantidad = rs.getInt("cantidad");
            
            // Actualizar los campos de texto con la nueva cantidad y la información del producto
            txtCantidadp.setText(String.valueOf(nuevaCantidad));
            // También puedes actualizar otros campos de texto si es necesario
            txtNombrep.setText(rs.getString("nombre"));
            txtPreciop.setText(" $ " + rs.getString("precio") + " MXN ");
            txtDescripcion.setText(rs.getString("descripcion"));
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron registros para este producto", "Error", JOptionPane.ERROR_MESSAGE);
        }

        rs.close();
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al recargar los datos del producto", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void incrementarCantidadEnBaseDeDatos(String clave, int cantidad) {
        
     if (clave == null || clave.isEmpty()) {
        System.err.println("Clave nula o vacía, no se puede actualizar el inventario.");
        return;
    }

    if (cantidad <= 0) {
        System.err.println("Cantidad inválida (" + cantidad + "), no se actualiza el inventario.");
        return;
    }

    // Consulta para actualizar la cantidad en la base de datos
    String updateQuery = "UPDATE producto SET cantidad = cantidad + ? WHERE id = ?";

    try {
        // Iniciar la transacción
        cn.setAutoCommit(false);

        // Preparar la consulta con parámetros
        try (PreparedStatement ps = cn.prepareStatement(updateQuery)) {
            ps.setInt(1, cantidad);  // Incrementar la cantidad
            ps.setString(2, clave);  // Filtrar por clave del producto

            // Ejecutar la consulta
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cantidad actualizada correctamente: Clave=" + clave + ", Cantidad=" + cantidad);
            } else {
                System.err.println("Error: No se encontró un producto con la clave especificada: " + clave);
                JOptionPane.showMessageDialog(null,
                        "No se encontró el producto con clave: " + clave,
                        "Error", JOptionPane.ERROR_MESSAGE);

                // Si el producto no existe, lanzar excepción para forzar rollback
                throw new SQLException("Producto no encontrado: clave=" + clave);
            }
        }

        // Confirmar la transacción
        cn.commit();
        System.out.println("Transacción completada con éxito para la clave: " + clave);

    } catch (SQLException e) {
        try {
            // Revertir los cambios si ocurre un error
            cn.rollback();
            System.err.println("Error en la transacción. Se realizó un rollback.");
            e.printStackTrace();
        } catch (SQLException rollbackEx) {
            System.err.println("Error al intentar realizar el rollback.");
            rollbackEx.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,
                "Error al actualizar el inventario: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            // Restaurar el estado predeterminado de auto-commit
            cn.setAutoCommit(true);
        } catch (SQLException ex) {
            System.err.println("Error al restaurar el auto-commit.");
            ex.printStackTrace();
        }
    }
}
    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
 try {
        // Verificar si el campo de efectivo está vacío
        if (jEfectivo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingrese efectivo antes de registrar la venta.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución
        }

        // Validar que el efectivo ingresado sea un número válido
        double efectivo;
        try {
            efectivo = Double.parseDouble(jEfectivo.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingrese un valor numérico válido para el efectivo.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución
        }

        // Confirmar si desea registrar la venta
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que deseas registrar la venta?",
                "Confirmar Venta", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.NO_OPTION) {
            // Preguntar si desea agregar otro producto
            int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Deseas agregar otro producto?",
                    "Agregar Producto", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                // El usuario desea agregar otro producto
                JOptionPane.showMessageDialog(this,
                        "Puedes agregar otro producto.",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                return; // No limpiar nada
            }

            // Cancelar la venta y devolver los productos al inventario
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int rowCount = model.getRowCount();

            // Devolver los productos al inventario
            for (int i = 0; i < rowCount; i++) {
                Object claveObj = model.getValueAt(i, 0); // Clave del producto
                Object cantidadObj = model.getValueAt(i, 2); // Cantidad comprada

                if (claveObj != null && cantidadObj != null) {
                    try {
                        String clave = claveObj.toString();
                        int cantidad = Integer.parseInt(cantidadObj.toString());
                        incrementarCantidadEnBaseDeDatos(clave, cantidad); // Actualizar inventario
                    } catch (NumberFormatException e) {
                        System.err.println("Datos inválidos en la fila " + i + ": " + e.getMessage());
                    }
                }
            }

            // Reiniciar venta al cancelar
            reiniciarVenta();

            JOptionPane.showMessageDialog(this,
                    "Venta cancelada, inventario actualizado correctamente.",
                    "Cancelación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            cargarDatosProductoSeleccionado();
            return;
        }

        // Registrar la venta
        String totalText = lblTotal.getText().replace("$", "").trim();
        double total = formatearPrecio(totalText);

        if (efectivo < total) {
            JOptionPane.showMessageDialog(this,
                    "El efectivo ingresado no es suficiente para cubrir el total.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        double cambio = efectivo - total;
        jTextField6.setText(String.format("%.2f", cambio));

        JOptionPane.showMessageDialog(this,
                "¡Venta registrada exitosamente!",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        insertarVenta(cantidadAcumulado,total,hora.getText(),usuarioVenta);

        // Reiniciar venta al registrar
        reiniciarVenta();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Por favor, ingrese valores numéricos válidos.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

       }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    public void insertarVenta(int cantidad,double total,String fecha, String usuario) {

        try {
            String query = "INSERT INTO ventas(cantidad_productos,total_compra,fecha_compra,usuario)values('" + cantidad + "','"+total+"','" + fecha + "','" + usuario + "')";
            PreparedStatement ps;
            ps = cn.prepareStatement(query);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
               // JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL INSERTAR EN BASE DE DATOS","",JOptionPane.ERROR_MESSAGE);
        }

    }
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
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JTextField cantidadProductos;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JLabel hora;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jEfectivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField lblTotal;
    private javax.swing.JTextField txtCantidadp;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombrep;
    private javax.swing.JTextField txtPreciop;
    // End of variables declaration//GEN-END:variables
}
