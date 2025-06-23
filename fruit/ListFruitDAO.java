package fruit;

import java.util.LinkedList;
import java.util.List;

public class ListFruitDAO implements FruitDAO {
	
	private List<FruitVO> fruitList = new LinkedList<FruitVO>();
	private int fruitSeq = 1; // 과일 번호 1씩 증가
	
	
	@Override
	public boolean insertFruit(FruitVO fruit) {
		fruit.setFruitNo(fruitSeq++); // 과일 번호 setter로 설정 후 ++
		fruitList.add(fruit);
		return true;
	}

	@Override
	public FruitVO selectFruit(int fruitNo) {
		for (FruitVO fruit : fruitList) {
			if (fruit.getFruitNo() == fruitNo) // 현재 과일 목록에 있는 과일들의 번호를 가져와 입력 받은 번호와 일치 하는 과일 return
				return fruit;
		}
		return null;
	}

	@Override
	public List<FruitVO> selectAllFruits() {
		return fruitList; // 과일 목록 출력
	}

	@Override
	public boolean updateFruit(FruitVO newFruit) {
		for (int i = 0; i < fruitList.size(); i++) {
			if (fruitList.get(i).getFruitNo() == newFruit.getFruitNo()) { // i(0)번 부터 해당하는 인덱스의 과일 번호를 입력받은 과일의 번호와 비교
				fruitList.set(i, newFruit); // 일치 하는 과일 정보 수정
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteFruit(int fruitNo) {
		for (FruitVO fruit : fruitList) {
			if (fruit.getFruitNo() == fruitNo) {
				fruitList.remove(fruit);
				return true;
			}
		}
		return false;
	}
	

}
