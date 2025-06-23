package fruit.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fruit.FruitVO;
import fruit.HashMapFruitDAO;

public class TextFileHashMapFruitDAO extends HashMapFruitDAO implements FileFruitDB {

	private String dataFilename = DATA_FILE + ".txt";
	private final String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";
			
	@Override
	public void saveFruits() {
		
		try (
			FileWriter fw = new FileWriter(dataFilename);
			PrintWriter pw = new PrintWriter(fw);
		) {
			
			for (FruitVO fruit : fruitDB.values()) {
				pw.println(fruit.getFruitNo());
				pw.println(fruit.getName());
				pw.println(fruit.getFarm());
				pw.println(fruit.getCountry());
				pw.println(fruit.getPrice());
				pw.println(fruit.getInstock());
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				pw.println(sdf.format(fruit.getRegdate()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
	}

	@Override
	public void loadFruits() {

		try ( FileReader fr = new FileReader(dataFilename);
			  BufferedReader br = new BufferedReader(fr);
		) {
			
			while (br.ready()) {
				int fruitNo = Integer.parseInt(br.readLine());
				String name = br.readLine().strip();
				String farm = br.readLine().strip();
				String  country = br.readLine().strip();
				int price = Integer.parseInt(br.readLine());
				int instock = Integer.parseInt(br.readLine());
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				Date regdate = sdf.parse(br.readLine());
				
				fruitDB.put(fruitNo, new FruitVO(fruitNo, name, farm, country, price, instock, regdate));
				
				if (fruitSeq <= fruitNo) fruitSeq = fruitNo + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("[로딩] " + dataFilename + "이 없습니다.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}

}
