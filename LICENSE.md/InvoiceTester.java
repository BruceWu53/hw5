import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
   A program that tests the invoice classes.
*/
public class InvoiceTester
{
   public static void main(String[] args)
   {
      final Invoice invoice = new Invoice();
      final InvoiceFormatter formatter = new SimpleFormatter();

      // This text area will contain the formatted invoice
      final JTextArea textArea = new JTextArea(20, 40);
      textArea.setEnabled(false);

      // When the invoice changes, update the text area
      invoice.addChangeListener(event ->
         textArea.setText(invoice.format(formatter)));

      // Add line items to a combo box
      final JComboBox combo = new JComboBox();
      Product hammer = new Product("Hammer", 19.95);
      Product nails = new Product("Assorted nails", 9.95);
      combo.addItem(hammer);
      Bundle bundle = new Bundle();
      bundle.add(hammer);
      bundle.add(nails);
      combo.addItem(new DiscountedItem(bundle, 10));
      
      JTextField numberOfItems = new JTextField(5);
      // Make a button for adding the currently selected
      // item to the invoice
      JButton addButton = new JButton("Add");
      addButton.addActionListener(event ->
         {
       	  String input = numberOfItems.getText();
       	  for(int i = 0; i < Integer.parseInt(input); i++) {
           LineItem item = (LineItem) combo.getSelectedItem();
            invoice.addItem(item);
       	  }
         });

      // Put the combo box and the add button into a panel
      JPanel panel = new JPanel();
      panel.add(combo);
      panel.add(numberOfItems);
      panel.add(addButton);

      // Add the text area and panel to the frame
      JFrame frame = new JFrame();
      frame.add(new JScrollPane(textArea),
         BorderLayout.CENTER);
      frame.add(panel, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
