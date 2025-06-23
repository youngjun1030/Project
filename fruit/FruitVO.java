package fruit;

import java.io.Serializable;
import java.util.Date;

public class FruitVO implements Serializable {

	private int fruitNo;
	private String name;
	private String farm;
	private String country;
	private int price;
	private int instock;
	private Date regdate;
	
	public FruitVO (int fruitNo, String name, String farm, String country, int price, int instock, Date regdate) {
		this.fruitNo = fruitNo;
		this.name = name;
		this.farm = farm;
		this.country = country;
		this.price = price;
		this.instock = instock;
		this.regdate = regdate;
	}
	
	public FruitVO(String name, String farm, String country, int price, int instock) {
		this(-1, name, farm, country, price, instock, null);
	}

	@Override
	public String toString() {
		return "[" + fruitNo + ", " + name + ", " + farm + ", " + country + ", " + country + ", " + price +
				 ", " + instock + "]";
	}

	public int getFruitNo() {
		return fruitNo;
	}

	public void setFruitNo(int fruitNo) {
		this.fruitNo = fruitNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFarm() {
		return farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
