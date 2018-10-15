/**
 * A product with a price and description.
 */
public class Product implements LineItem {
	/**
	 * Constructs a product.
	 * 
	 * @param description
	 *            the description
	 * @param price
	 *            the price
	 */
	public Product(String description, double price) {
		this.description = description;
		this.price = price;
	}

	public int compareTo(LineItem L) {
		if (this.description == L.toString()) {
			return 1;
		} else
			return 0;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	private String description;
	private double price;
	private int quantity = 1;

	public void incrementQuantity() {
		quantity++;
	}

}
