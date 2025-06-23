package fruit;

import java.util.List;

public class YJFruitService implements FruitService {
	
	private FruitDAO fruitDAO;
	
	public YJFruitService(FruitDAO fruitDAO) {
		this.fruitDAO = fruitDAO;
	}

	@Override
	public boolean registFruit(FruitVO fruit) {
		return fruitDAO.insertFruit(fruit);
	}

	@Override
	public List<FruitVO> listFruits() {
		return fruitDAO.selectAllFruits();
	}

	@Override
	public FruitVO detailFruitInfo(int fruitNo) {
		return fruitDAO.selectFruit(fruitNo);
	}

	@Override
	public boolean updateFruitPrice(int fruitNo, int price) {
		FruitVO fruit = fruitDAO.selectFruit(fruitNo);
		
		if (fruit != null) {
			fruit.setPrice(price);
			fruitDAO.updateFruit(fruit);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateFruitInstock(int fruitNo, int instock) {
		FruitVO fruit = fruitDAO.selectFruit(fruitNo);
		
		if (fruit != null) {
			fruit.setInstock(instock);
			fruitDAO.updateFruit(fruit);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeFruit(int fruitNo) {
		/*
		FruitVO fruit = fruitDAO.selectFruit(fruitNo);
		
		if (fruit != null) {
			fruitDAO.deleteFruit(fruitNo);
			return true;
		}
		return false;
		*/
		return fruitDAO.deleteFruit(fruitNo);
	}
	
	

}
