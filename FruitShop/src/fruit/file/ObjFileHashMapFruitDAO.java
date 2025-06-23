package fruit.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Map;

import fruit.FruitVO;
import fruit.HashMapFruitDAO;

public class ObjFileHashMapFruitDAO extends HashMapFruitDAO implements FileFruitDB {

	private String dataFilename = DATA_FILE + ".obj";
	
	public ObjFileHashMapFruitDAO() {
		loadFruits();
	}
	
	@Override
	public void saveFruits() {
		try (
				FileOutputStream fos = new FileOutputStream(dataFilename);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
					
			) {
				oos.writeObject(fruitDB);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	

	@Override
	public void loadFruits() {
		
		try (
			FileInputStream fis = new FileInputStream(dataFilename);
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			
			fruitDB = (Map<Integer, FruitVO>)ois.readObject();
			fruitSeq = Collections.max(fruitDB.keySet()) + 1;
			
		} catch (FileNotFoundException e) {
			System.out.println("[DB로딩] " + dataFilename + "가 없습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean insertFruit(FruitVO fruit) {
		boolean result = super.insertFruit(fruit);
		if (result) saveFruits();
		return result;
	}

	@Override
	public boolean updateFruit(FruitVO newFruit) {
		boolean result = super.updateFruit(newFruit);
		if (result) saveFruits();
		return result;
	}
	
	@Override
	public boolean deleteFruit(int fruitNo) {
		boolean result = super.deleteFruit(fruitNo);
		if (result) saveFruits();
		return result;
	}



}
