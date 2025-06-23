package fruit.file;

public interface FileFruitDB {
	String DATA_FILE = "./data/fruitDB";
	void saveFruits();
	void loadFruits();
}
