package resources;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javier
 */
public class Util {
  public static void addPlaceholder(javax.swing.JTextField field, String text) {
    field.setText(text);
    field.setForeground(Color.decode("#9e9e9e"));
    
    field.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        field.setForeground(Color.BLACK);
        field.setText((field.getText().length() > 0 && !field.getText().equals(text)) ? field.getText() : "");
      }

      @Override
      public void focusLost(FocusEvent e) {
        field.setForeground(field.getText().length() > 0 ? Color.BLACK : Color.decode("#9e9e9e"));
        field.setText(field.getText().length() > 0 ? field.getText() : text);
      }
    });
  }
  
  public static void clearTable(DefaultTableModel model) {
    for (int i = 0; i < model.getRowCount(); i++) {
      model.removeRow(i);
      i-=1;
    }
  }
  
  public static boolean hasText(String text) {
    return text.replaceAll(" ", "").length() > 0;
  }
  
  public static boolean isNumeric(String text) {
    try {
      Integer.parseInt(text);
      return true;
    } catch(NumberFormatException e) {
      return false;
    }
  }
  
  public static int getPKFromCombo(javax.swing.JComboBox combo) {
    return Integer.parseInt(combo.getSelectedItem().toString().split("-")[0]);
  }
  
  public static void showWarning(javax.swing.JFrame frame, String message) {
    JOptionPane.showMessageDialog(frame, message, "Warning", JOptionPane.WARNING_MESSAGE);
    
  }
}
