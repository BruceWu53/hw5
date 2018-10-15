/**
   A line item in an invoice.
*/
public interface LineItem extends Comparable<LineItem>
{
   /**
      Gets the price of this line item.
      @return the price
   */
   double getPrice();
   /**
      Gets the description of this line item.
      @return the description
   */   
   String toString();
   /**
    * Increments the number of LineItems by 1
    */
   void incrementQuantity();
   /**
    * Gets the total number of LineItems
    * @return the quantity
    */
   int getQuantity();
}
