package app;

import java.util.ArrayList;
import java.util.List;

import cart.CartItemVO;
import cart.CartService;
import cart.CartServiceImpl;
import cart.HashMapCartDAO;
import fruit.FruitService;
import fruit.FruitVO;
import fruit.YJFruitService;
import fruit.file.ObjFileHashMapFruitDAO;
import member.MemberService;
import member.MemberVO;
import member.ObjFileHashMapMemberDAO;
import member.YJMemberService;
import order.ObjFileHashMapOrderDAO;
import order.OrderItemVO;
import order.OrderService;
import order.OrderServiceImpl;
import order.OrderVO;


public class FruitShopConsoleApp {
	
	String[] startMenuList = {"종료", "과일 목록", "로그인", "회원가입"};
	String[] adminMenuList = {"로그아웃", "과일 목록", "과일 등록", "과일 정보 수정", "과일 삭제", "회원 목록", "주문 목록"};
	String[] memberMenuList = {"로그아웃", "과일 목록", "과일 검색", "과일 가격 정렬", "과일 주문", "주문 목록", "장바구니 과일 담기", "장바구니 보기", "내 정보"};
	String[] cartMenuList = {"돌아가기", "과일 주문", "과일 삭제", "장바구니 비우기"};
	String[] myInfoMenuList = {"돌아가기", "비밀번호 변경", "회원 탈퇴"};
	
	final String ADMIN_ID = "admin";
	final String ADMIN_PWD = "1234";
	final String ADMIN_NAME = "관리자";
	
	final String CONFIRM = "yes";
	

	FruitService fs = new YJFruitService(new ObjFileHashMapFruitDAO());
	MemberService ms = new YJMemberService(new ObjFileHashMapMemberDAO());
	OrderService os = new OrderServiceImpl(new ObjFileHashMapOrderDAO(), fs);
	CartService cs = new CartServiceImpl(new HashMapCartDAO());

	
	MemberVO loggedMember;
	
	MyAppReader input = new MyAppReader();
	
	public static void main(String[] args) {
		FruitShopConsoleApp app = new FruitShopConsoleApp();
		app.displayWelcome();
		app.controlStartMenu();
	}
	
	private void displayWelcome() {
		System.out.println("***********************************");
		System.out.println("*  Welcome to Youngjun Fruit Shop  *");
		System.out.println("***********************************");
	}

	private void controlStartMenu() {
		int menu;
		do {
			menu = selectMenu(startMenuList);
			
			switch (menu) {
			case 1: menuFruitList(); break;
			case 2: menuLogin(); break;
			case 3: menuSignUp(); break;
			case 0: menuExit(); break;
			default : menuWrongNumber();
			}
			
		} while (menu != 0);
		
	}
	
	private void menuWrongNumber() {
		System.out.println("없는 메뉴입니다.");
		
	}
	
	private void menuExit() {
		System.out.println("Youngjun Fruit Shop 서비스를 종료합니다.");
		
	}
	
	private void menuFruitList() {
		System.out.println("*** 과일 목록 ***");
		displayFruitList();
	}
	
	private void displayFruitList() {
		List<FruitVO> fruitList = fs.listFruits();
		System.out.println("---------------------------------------");
		if (fruitList.isEmpty()) {
			System.out.println("등록된 과일이 없습니다.");
		} else {
		for (FruitVO fruit : fruitList) {
			System.out.println(fruit);
			}	
		}
		
		System.out.println("---------------------------------------");
	}
	
	private void menuLogin() {
		System.out.println("*** 로그인 ***");
		String id = input.readString(">> id : ");
		String password = input.readString(">> password : ");
		
		// 관리자 -> 관리자 메뉴
		if (id.equals(ADMIN_ID) && password.equals(ADMIN_PWD)) {
			loggedMember = new MemberVO(ADMIN_ID, ADMIN_PWD, ADMIN_NAME);
			System.out.println("관리자 모드로 변경합니다.");
			controlAdminMenu();
		} else {
			// 회원 -> 회원 메뉴
			loggedMember = ms.login(id, password);
			
			if (loggedMember != null) {
				System.out.println("[로그인] " + loggedMember.getUsername() + "님 안녕하세요.");
				controlMemberMenu();
			} else {
				// 아니면
				System.out.println("로그인을 하지 못했습니다.");
			}
		}
		
	}
	
	private void controlMemberMenu() {
		int menu;
		do {
			menu = selectMenu(memberMenuList);
			// "로그아웃", "과일 목록", "과일 검색", "과일 가격 정렬", "과일 주문", "주문 목록", "장바바구니 과일 담기", "장바구니 보기", "내 정보"
			switch (menu) {
			case 1 : menuFruitList(); break;
			case 2 : menuSearchFruit(); break;
			case 3 : menuSortFruitByPrice(); break;
			case 4 : menuFruitOrder(); break;
			case 5 : menuOrderList(); break;
			case 6 : menuAddFruit2Cart(); break;
			case 7 : menuCartView(); break;
			case 8 : menuMyInfo(); break;
			case 0 : menuLogout(); break;
			default : menuWrongNumber();
			}
		} while (menu != 0);

	}
	
	private void menuSortFruitByPrice() {
	    System.out.println("과일 가격 정렬");
	    int sel = Integer.parseInt(input.readString("1. 가격 오름차순 | 2. 가격 내림차순 선택: "));
	    boolean asc = (sel == 1);
	    List<FruitVO> list = fs.sortFruitsByPrice(asc);
	    list.forEach(System.out::println);
	}

	private void menuSearchFruit() {
	    System.out.println("과일 검색");
	    String keyword = input.readString("검색할 과일 이름 키워드: ");
	    List<FruitVO> list = fs.searchFruitsByName(keyword);
	    list.forEach(System.out::println);
	}


	private void menuFruitOrder() {
		System.out.println("*** 과일 주문 ***");
		displayAvailableFruitList();
		int fruitNo = input.readInt(">> 과일 번호 : ");
		FruitVO fruit = fs.detailFruitInfo(fruitNo);
	
		if (fruit == null) {
			System.out.println("없는 과일 입니다.");
			return;
		}
		
		int quantity = input.readInt(">> 주문량 (" + fruit.getInstock() + "개 이내) : ");
		if (quantity > fruit.getInstock()) {
			System.out.println("주문량이 재고량보다 큽니다.");
			return;
		}
		
		// 주문 과일 목록
		List<OrderItemVO> orderItemList = new ArrayList<>();
		int price = fruit.getPrice() * quantity;
		orderItemList.add(new OrderItemVO(fruitNo, quantity, price));
		
		// 주문 정보 생성
		OrderVO order = new OrderVO(loggedMember.getId(), orderItemList, price);
		// 배송 정보 추가
		setDeliveryInfo();
		order.setMobile(loggedMember.getMobile());
		order.setAddress(loggedMember.getAddress());
		
		if (os.orderItems(order)) {
			System.out.println("주문이 완료되었습니다.");
			System.out.println("배송이 완료되었습니다.");
		} else {
			System.out.println("주문을 하지 못했습니다.");
		}
	}
	
	private void setDeliveryInfo() {
		if (loggedMember.getMobile() == null) {
			System.out.println("*** 배송 정보 입력 ***");
			
			String mobile = input.readString(">> 모바일 번호 : ");
			String email = input.readString(">> 이메일 주소 : ");
			String address = input.readString(">> 주소 : ");
			
			loggedMember.setMobile(mobile);
			loggedMember.setEmail(email);
			loggedMember.setAddress(address);
			
			ms.addMemberInfo(loggedMember.getId(), mobile, email, address);
			//loggedMember = ms.detailMemberInfo(loggedMember.getId());
			
		}
	}
	
	private void displayAvailableFruitList() {
		List<FruitVO> fruitList = fs.listFruits();
		System.out.println("---------------------------------------");
		if (fruitList.isEmpty()) {
			System.out.println("주문 가능한 과일이 없습니다.");
		} else {
			int count = 0;
			for (FruitVO fruit : fruitList) {
				if (fruit.getInstock() > 0) {
					System.out.println(fruit);
					count++;
				}
			}
			if (count == 0) 
				System.out.println("주문 가능한 과일이 없습니다.");
		}
		System.out.println("---------------------------------------");	
		
	}
	
	private void menuAddFruit2Cart() {
		System.out.println("*** 장바구니에 과일 담기 ***");
		
		displayAvailableFruitList();
		int fruitNo = input.readInt(">> 과일 번호 : ");
		FruitVO fruit = fs.detailFruitInfo(fruitNo);
		
		if (fruit == null) {
			System.out.println("없는 과일 입니다.");
			return;
		}
		
		int quantity = input.readInt(">> 주문량 (" + fruit.getInstock() + "개 이내) : ");
		if (quantity > fruit.getInstock()) {
			System.out.println("주문량이 재고량보다 큽니다.");
			return;
		}
		
		// 이미 장바구니에 있는지 확인
		// 없으면, 장바구니에 넣기
		if (cs.getCartItemInfo(fruitNo) == null) {
			cs.addItem2Cart(new CartItemVO(fruitNo, quantity));
			System.out.println("장바구니에 추가했습니다.");
		} else {
			System.out.println("이미 장바구니에 있는 과일입니다.");
		}
		
		
	}
	
	private void menuCartView() {
		System.out.println("*** 장바구니 보기 ***");
		displayCartItemList();
		
		if (!cs.isCartEmpty())
			controlCartMenu();
		
	}

	private void displayCartItemList() {

		if (cs.isCartEmpty()) {
			System.out.println("장바구니가 비어 있습니다.");
			
		} else {
			System.out.println("---------------------------------------");	
			for (CartItemVO item : cs.listCartItems()) {
				System.out.println(item);
			}
			System.out.println("---------------------------------------");	
			
		}
		
	
		
	}
	
	private void controlCartMenu() {
		int menu;
		do {
			menu = selectMenu(cartMenuList);
			// "돌아가기", "비밀번호 변경", "회원 탈퇴"
			switch (menu) {
			case 1 : menuCartOrder(); break;
			case 2 : menuCartFruitDelete(); break;
			case 3 : menuCartClear();
			case 0 : break;
			default : menuWrongNumber();
			}
		} while (menu != 0 && !cs.isCartEmpty());
		
	}
	
	private void menuCartOrder() {
		System.out.println("*** 장바구니 과일 주문 ***");
		displayCartItemList();
		
		// 주문 과일 목록
		List<OrderItemVO> orderItemList = new ArrayList<>();
		int totalPrice = 0;
		for (CartItemVO item : cs.listCartItems()) {
			FruitVO fruit = fs.detailFruitInfo(item.getFruitNo());
			int price = fruit.getPrice() * item.getQuantity();
			totalPrice += fruit.getPrice() * item.getFruitNo();
			orderItemList.add(
					new OrderItemVO(item.getFruitNo(), item.getQuantity(), price)
			);
		}
				
		// 주문 정보 생성
		OrderVO order = new OrderVO(loggedMember.getId(), orderItemList, totalPrice);
		
		// 배송 정보 추가
		setDeliveryInfo();
		order.setMobile(loggedMember.getMobile());
		order.setAddress(loggedMember.getAddress());
		
		displayOrderInfo(order);
		
		String confirm = input.readString(">> 위와 같은 내용을 주문 및 결제를 진행하시겠습니까? ('"
									+ CONFIRM + "'이면 주문 실행) : ");
		if (confirm.equals(CONFIRM)) {
			if (os.orderItems(order)) {
				cs.clearCart();
				System.out.println("주문이 완료되었습니다.");
				System.out.println("배송이 완료되었습니다.");
			} else {
				System.out.println("주문을 하지 못했습니다.");
			}
		} else {
			System.out.println("주문이 취소되었습니다.");
		}
				
	}
	
	private void displayOrderInfo(OrderVO order) {
		System.out.println(order);
		
	}

	private void menuCartFruitDelete() {
		System.out.println("*** 장바구니 과일 삭제 ***");
		displayCartItemList();
		int fruitNo = input.readInt(">> 과일 번호 : ");
		CartItemVO item = cs.getCartItemInfo(fruitNo);
		if (item == null) {
			System.out.println("없는 과일입니다.");
		} else {
			cs.removeCartItem(fruitNo);
			System.out.println("장바구니에서 과일을 삭제하였습니다.");
		}
		displayCartItemList();
	}

	private void menuCartClear() {
		System.out.println("*** 장바구니 비우기 ***");
		String confirm = input.readString(">> 장바구니의 모든 과일을 삭제하시겠습니까? ('" + CONFIRM + "'이면 삭제) : ");
		if (confirm.equals(CONFIRM)) {
			cs.clearCart();
			System.out.println("장바구니의 모든 과일을 삭제하였습니다.");
		} else {
			System.out.println("장바구니 비우기가 취소되었습니다.");
		}
		
		
	}
	
	private void menuMyInfo() {
		System.out.println("*** 내 정보 ***");
		System.out.println(loggedMember);
		
		controlMyInfoMenu();
	}

	private void controlMyInfoMenu() {
		int menu;
		do {
			menu = selectMenu(myInfoMenuList);
			// "돌아가기", "비밀번호 변경", "회원 탈퇴"
			switch (menu) {
			case 1 : menuUpatePassword(); break;
			case 2 : menuMemberExit(); break;
			case 0 : break;
			default : menuWrongNumber();
			}
		} while (menu != 0 && loggedMember != null);
		
	}

	private void menuUpatePassword() {
		System.out.println("*** 비밀번호 수정 ***");
		String oldPassword = input.readString(">> 기존 비밀번호 : ");
		String newPassword = input.readString(">> 새 비밀번호 : ");
		if (ms.updatePassword(loggedMember.getId(), oldPassword, newPassword)) {
			System.out.println("[비밀번호 수정] 비밀번호를 수정했습니다.");
		} else {
			System.out.println("[비밀번호 수정 실패] 비밀번호 수정에 실패했습니다.");
		}
	}

	private void menuMemberExit() {
		System.out.println("*** 회원 탈퇴 ***");
		String password = input.readString(">> 비밀번호 : ");
		if (ms.removeMember(loggedMember.getId(), password)) {
			System.out.println("[회원 탈퇴] 회원정보, 주문정보를 삭제하였습니다. 그동안 서비스를 이용해 주셔서 감사합니다.");
			loggedMember = null;
		} else {
			System.out.println("[회원 탈퇴 실패] 회원 탈퇴 처리에 실패했습니다.");
		}
		
	}
	
	private void controlAdminMenu() {
		int menu;
		do {
			menu = selectMenu(adminMenuList);
			// "로그아웃", "과일 목록", "과일 등록", "과일 정보 수정", "과일 삭제", "회원 목록", "주문 목록"
			switch (menu) {
			case 1: menuFruitList(); break;
			case 2: menuFruitRegist(); break;
			case 3: menuFruitUpdate(); break;
			case 4: menuFruitRemove(); break;
			case 5: menuMemberList(); break;
			case 6: menuOrderList(); break;
			case 0: menuLogout(); break;
			default : menuWrongNumber();
			}
			
		} while (menu != 0 && loggedMember != null);
		
	}
	
	private void menuFruitRegist() {
		
		System.out.println("*** 과일 등록 ***");
		String name = input.readString(">> 과일 이름 : ");
		String farm = input.readString(">> 농장 : ");
		String country = input.readString(">> 원산지 : ");
		int price = input.readInt(">> 가격 : ");
		int instock = input.readInt(">> 재고량 : ");
		
		if (fs.registFruit(new FruitVO(name, farm, country, price, instock))) {
			System.out.println("과일을 등록했습니다.");
			displayFruitList();
		} else {
			System.out.println("과일 등록에 실패했습니다.");
		}
		
	}
	
	private void menuFruitUpdate() {
		System.out.println("*** 과일 정보 수정 ***");
		displayFruitList();
		int fruitNo = input.readInt(">> 과일 번호 :");
		
		int select = input.readInt(">> 수정할 정보 선택 (1. 가격, 2. 재고량) : ");
		if (select == 1) { // 가격
			int price = input.readInt(">> 새 가격 : ");
			if (fs.updateFruitPrice(fruitNo, price)) {
				System.out.println("[과일 정보 수정] 가격을 수정하였습니다.");
			} else {
				System.out.println("[과일 정보 수정 오류] 없는 과일입니다.");
			}
			
		} else if (select == 2) {// 재고량
			int instock = input.readInt(">> 새 재고량 :");
			if (fs.updateFruitInstock(fruitNo, instock)) {
				System.out.println("[과일 정보 수정] 재고량을 수정하였습니다.");
			} else {
				System.out.println("[과일 정보 수정 오류] 없는 과일입니다.");
			}
		} else {
			System.out.println("[과일 정보 수정 취소] 지원하지 않는 기능입니다.");
		}
		
	}
	
	private void menuFruitRemove() {
		System.out.println("*** 과일 삭제 ***");
		displayFruitList();
		int fruitNo = input.readInt(">> 과일 번호 :");
		String confirm = input.readString("선택한 과일을 삭제하시겠습니까? ('" + CONFIRM + "'를 입력하면 실행) : ");
		if (confirm.equals(CONFIRM)) {
			if (fs.removeFruit(fruitNo)) {
				System.out.println("[과일 삭제] 과일을 삭제했습니다.");
			} else {
				System.out.println("[과일 삭제 오류] 없는 과일입니다.");
			}
		} else {
			System.out.println("[과일 삭제 취소] 과일 삭제를 취소했습니다.");
		}
	}

	private void menuMemberList() {
		System.out.println("*** 회원 목록 ***");
		System.out.println("---------------------------------------");
		List<MemberVO> memberList = ms.listMembers();
		if (memberList.isEmpty()) {
			System.out.println("회원이 없습니다.");
		} else {
			for (MemberVO member : memberList) {
				System.out.println(member);
			}
		}
		System.out.println("---------------------------------------");
		
	}
	
	private void menuOrderList() {
		if (loggedMember.getId().equals(ADMIN_ID)) {
			System.out.println(os.listAllOrder());
		} else {
			System.out.println(os.listMyOrders(loggedMember.getId()));
		}
		
	}

	private void menuLogout() {
		
		System.out.println("[로그아웃] " + loggedMember.getUsername() + "님, 안녕히 가십시오.");
		loggedMember = null;
		
	}

	private void menuSignUp() {
		System.out.println("*** 회원 가입 ***");
		String id = input.readString(">> id : ");
		String password = input.readString(">> password : ");
		String username = input.readString(">> username : ");
		
		if (ms.registMember(new MemberVO(id, password, username))) {
			System.out.println("회원 가입이 완료되었습니다. 서비스 이용을 위한 로그인 해주세요.");
		} else {
			System.out.println("회원 가입에 실패하였습니다.");
		}
		
	}
	
	private int selectMenu(String[] menuList) {

		System.out.println("-------------------------------");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(i + ". " + menuList[i]);
		}
		System.out.println("0. " + menuList[0]);
		System.out.println("-------------------------------");
		return input.readInt(">> 메뉴 선택 : ");
	}
	
}
