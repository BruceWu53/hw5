/**
 * A decorator for an item that applies a discount.
 */
public class DiscountedItem implements LineItem {
	/**
	 * Constructs a discounted item.
	 * 
	 * @param item
	 *            the item to be discounted
	 * @param discount
	 *            the discount percentage
	 */
	public DiscountedItem(LineItem item, double discount) {
		this.item = item;
		this.discount = discount;
	}

	public double getPrice() {
		return item.getPrice() * (1 - discount / 100);
	}

	public String toString() {
		return item.toString() + " (Discount " + discount + "%)";
	}

	private LineItem item;
	private double discount;
	private int quantity = 1;

	public int compareTo(LineItem o) {
		String string1 = item.toString() + " (Discount " + discount + "%)";
		String string2 = o.toString();
		if ((item.toString() + " (Discount " + discount + "%)").equalsIgnoreCase(o.toString())) {
			System.out.println("String 1: " + string1);
			System.out.println("String 2: " + string2);
			System.out.println("strings are equal");
			return 1;
		} else {
			System.out.println("String 1: " + string1);
			System.out.println("String 2: " + string2);
			System.out.println("strings are not equal");
			return 0;
		}
	}

	public void incrementQuantity() {

		quantity++;
	}

	public int getQuantity() {
		return quantity;
	}

}