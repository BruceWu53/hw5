import java.util.*;
import javax.swing.event.*;

/**
   An invoice for a sale, consisting of line items.
*/
public class Invoice
{
   /**
      Constructs a blank invoice.
   */
   public Invoice()
   {
      items = new ArrayList<>();
      listeners = new ArrayList<>();
   }

  /**
      Adds an item to the invoice.
      @param item the item to add
   */
   public void addItem(LineItem item)
   {
	    boolean DEBUG = false; //set true for console command debugging
		// check to see if the item added is already in the ArrayList
		if (items.size() == 0) {
			items.add(item);
			// Notify all observers of the change to the invoice
			ChangeEvent event = new ChangeEvent(this);
			for (ChangeListener listener : listeners)
				 listener.stateChanged(event); 
			if (DEBUG) {
			System.out.println("Added: " + item.toString() + " to items\n");
			System.out.println("Quantity of " + item.toString() + ": " + items.get(0).getQuantity());
			}
			return;
		}
		
			if (item.compareTo(items.get(0)) == 1) {
				// if so, instead of adding it to ArrayList, increment the
				// quantity of that item
				item.incrementQuantity();
				ChangeEvent event = new ChangeEvent(this);
				for (ChangeListener listener : listeners) {
					 listener.stateChanged(event); 
				}
				if (DEBUG) {
					System.out.println("Added item was a duplicate: " + item.toString());
					System.out.println("Added: " + item.toString() + " +1. Total number of " + item.toString() + ": " + item.getQuantity());
				}
				return;
			} else if (item.compareTo(items.get(0)) == 0) { 
				// else, add it to ArrayList
				System.out.println("Size of array: " + items.size());
				if (items.size() == 1) {
				items.add(item);
				// Notify all observers of the change to the invoice
				ChangeEvent event = new ChangeEvent(this);
				for (ChangeListener listener : listeners) {
					 listener.stateChanged(event); 
				}
				if (DEBUG) {
					System.out.println(item.toString() + " was unique and successfully added to array ");
				}
				return;
				}
				if (item.compareTo(items.get(1)) == 1) {
					item.incrementQuantity();
					ChangeEvent event = new ChangeEvent(this);
					for (ChangeListener listener : listeners) {
						 listener.stateChanged(event); 
					}
					if (DEBUG) {
					System.out.println("Added item was a duplicate: " + item.toString());
					System.out.println("Added: " + item.toString() + " +1. Total number of " + item.toString() + ": " + item.getQuantity());
					}
				}
				}

			} 
		

   /**
      Adds a change listener to the invoice.
      @param listener the change listener to add
   */
   public void addChangeListener(ChangeListener listener)
   {
      listeners.add(listener);
   }

   /**
      Gets an iterator that iterates through the items.
      @return an iterator for the items
   */
   public Iterator<LineItem> getItems()
   {
      return new
         Iterator<LineItem>()
         {
            public boolean hasNext()
            {
               return current < items.size();
            }

            public LineItem next()
            {
               return items.get(current++);
            }

            public void remove()
            {
               throw new UnsupportedOperationException();
            }
            private int current = 0;
         };
   }

   public String format(InvoiceFormatter formatter)
   {
      String r = formatter.formatHeader();
      Iterator<LineItem> iter = getItems();
        while (iter.hasNext())
         r += formatter.formatLineItem(iter.next()) + "\n";
      return r + formatter.formatFooter();
   }

   private ArrayList<LineItem> items;
   private ArrayList<ChangeListener> listeners;
}
