package resources;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author javier
 */
public class Personalization {
  public static void addPlaceholder(javax.swing.JTextField field, String text) {
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
}
