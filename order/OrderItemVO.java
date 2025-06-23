package order;

import java.io.Serializable;

public class OrderItemVO implements Serializable {
	private int fruitNo;
	private int quantity;
	private int price;
	
	public OrderItemVO(int fruitNo, int quantity, int price) {
		this.fruitNo = fruitNo;
		this.quantity = quantity;
		this.price = price;
	}

	public int getFruitNo() {
		return fruitNo;
	}

	public void setFruitNo(int fruitNo) {
		this.fruitNo = fruitNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\t***" + fruitNo + ", " + quantity + "(개), " + price + "(원)";
	}
	
	
}
