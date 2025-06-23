package cart;

public class CartItemVO {

	private int fruitNo;
	private int quantity;
	
	public CartItemVO(int fruitNo, int quantity) {
		this.fruitNo = fruitNo;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "[" + fruitNo + "번 과일, " + quantity + "개]";
	}
	
	
}
