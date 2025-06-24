package fruit;

import java.util.List;

public interface FruitService {

	boolean registFruit(FruitVO fruit);
	List<FruitVO> listFruits();
	FruitVO detailFruitInfo(int fruitNo);
	boolean updateFruitPrice(int fruitNo, int price);
	boolean updateFruitInstock(int fruitNo, int instock);
	boolean removeFruit(int fruitNo);
	List<FruitVO> searchFruitsByName(String keyword);
	List<FruitVO> sortFruitsByPrice(boolean asc);
}
