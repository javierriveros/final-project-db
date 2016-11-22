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
        field.setText("");
      }

      @Override
      public void focusLost(FocusEvent e) {
        field.setForeground(Color.decode("#9e9e9e"));
        field.setText(text);
      }
    });
  }
}
