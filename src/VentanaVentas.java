import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaVentas extends JFrame {
    private JTable tabla;
    private ProductoTableModel modelo;

    public VentanaVentas() {
        // Configuración de la ventana
        setTitle("Gestión de Ventas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuración del modelo y la tabla
        modelo = new ProductoTableModel();
        tabla = new JTable(modelo);

        // Configurar el editor y renderizador de la columna del botón
        int columnaEliminar = 2; // Columna donde irá el botón
        tabla.getColumnModel().getColumn(columnaEliminar).setCellEditor(new ButtonEditor(new JCheckBox(), modelo));
        tabla.getColumnModel().getColumn(columnaEliminar).setCellRenderer(new ButtonRenderer());

        // Agregar la tabla a un JScrollPane y configurar el JFrame
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaVentas());
    }
}

// Clase personalizada para el modelo de la tabla
class ProductoTableModel extends AbstractTableModel {
    private final String[] columnas = {"Producto", "Precio", "Eliminar"};
    private final List<Producto> productos;

    public ProductoTableModel() {
        productos = new ArrayList<>();
        productos.add(new Producto("Producto 1", 10.0));
        productos.add(new Producto("Producto 2", 20.0));
        productos.add(new Producto("Producto 3", 30.0));
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getNombre();
            case 1:
                return producto.getPrecio();
            case 2:
                return "Eliminar"; // Texto del botón
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2; // Solo la columna del botón es editable
    }

    public void eliminarFila(int rowIndex) {
        productos.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}

// Clase para representar un producto
class Producto {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

// Editor de celdas para la columna del botón
class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    private final JButton button;
    private final ProductoTableModel modelo;
    private int row;

    public ButtonEditor(JCheckBox checkBox, ProductoTableModel modelo) {
        this.modelo = modelo;
        this.button = new JButton("Eliminar");
        this.button.addActionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return "Eliminar";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.eliminarFila(row);
        fireEditingStopped();
    }
}

// Renderizador de celdas para la columna del botón
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "Eliminar" : value.toString());
        return this;
    }
}
