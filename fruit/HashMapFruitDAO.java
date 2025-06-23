package fruit;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapFruitDAO implements FruitDAO {
	
	protected Map<Integer, FruitVO> fruitDB = new HashMap<>();
	protected int fruitSeq = 1;

	@Override
	public boolean insertFruit(FruitVO fruit) {
		fruit.setFruitNo(fruitSeq++);
		fruit.setRegdate(new Date());
		fruitDB.put(fruit.getFruitNo(), fruit);
		return true;
	}

	@Override
	public FruitVO selectFruit(int fruitNo) {
		return fruitDB.get(fruitNo);
	}

	@Override
	public List<FruitVO> selectAllFruits() {
		return new ArrayList<>(fruitDB.values());
	}

	@Override
	public boolean updateFruit(FruitVO newFruit) {
		fruitDB.put(newFruit.getFruitNo(), newFruit);
		return true;
	}

	@Override
	public boolean deleteFruit(int fruitNo) {
		return fruitDB.remove(fruitNo) != null;
	}

}
