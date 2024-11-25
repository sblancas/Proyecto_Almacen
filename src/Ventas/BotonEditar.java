/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;
// Editor de celdas para la columna del botón


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class BotonEditar extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean clicked;
    private JTable table;
    private DefaultTableModel model;

    public BotonEditar(JCheckBox checkBox, DefaultTableModel model) {
        super(checkBox);
        this.model = model;

        button = new JButton();
        button.setOpaque(true);

        // Evento cuando se hace clic en el botón
        button.addActionListener(new ActionListener() {
 @Override
public void actionPerformed(ActionEvent e) {
    // Verificar si hay filas en el modelo
    if (model.getRowCount() > 0) {
        // Obtener el índice de la fila seleccionada
        int selectedRow = table.getSelectedRow();

        // Verificar si la fila seleccionada es válida
        if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
            // Eliminar la fila seleccionada
            model.removeRow(selectedRow);
            System.out.println("Fila eliminada en índice: " + selectedRow);

            // Verificar si aún hay filas en la tabla después de la eliminación
            if (model.getRowCount() > 0) {
                // Si la fila eliminada no es la última, mantener la selección en la siguiente fila
                if (selectedRow < model.getRowCount()) {
                    table.setRowSelectionInterval(selectedRow, selectedRow); // Seleccionar la misma fila
                } else {
                    // Si la fila eliminada es la última, seleccionar la fila anterior
                    table.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
                }
            } else {
                // Si ya no hay filas, deseleccionar cualquier fila (evitar selección inválida)
                table.clearSelection();
            }
        } else {
            // Si la fila seleccionada no es válida
            System.err.println("Fila seleccionada inválida.");
        }
    } else {
        // Si no hay filas en la tabla
        System.err.println("No hay filas en la tabla para eliminar.");
    }

    clicked = true;
    fireEditingStopped(); // Detener la edición si hay filas
}
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;

        label = (value != null) ? value.toString() : "Eliminar";
        button.setText(label);
        clicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        clicked = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
