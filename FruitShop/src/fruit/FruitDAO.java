package fruit;

import java.util.List;

public interface FruitDAO {
	boolean insertFruit(FruitVO fruit);
	FruitVO selectFruit(int fruitNo);
	List<FruitVO> selectAllFruits();
	boolean updateFruit(FruitVO newFruit);
	boolean deleteFruit(int fruitNo);
	
}
