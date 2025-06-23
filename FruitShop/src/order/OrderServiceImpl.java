package order;

import java.util.Date;
import java.util.List;

import fruit.FruitService;

public class OrderServiceImpl implements OrderService {
	
	private OrderDAO orderDAO;
	private FruitService fruitService;
	
	private final int COMPLETE = 10;
	
	public OrderServiceImpl(OrderDAO orderDAO, FruitService fruitService) {
		this.orderDAO = orderDAO;
		this.fruitService = fruitService;
	}

	@Override
	public boolean orderItems(OrderVO order) {

		// 1. 주문 정보 추가 (주문일, 배송상태, 배송완료일)
		order.setOrderDate(new Date());
		order.setStatus(COMPLETE);
		order.setDeliverDate(new Date());
				
		// 2. 도서 재고량 update
		for (OrderItemVO item : order.getOrderItemList()) {
			int fruitNo = item.getFruitNo();
			int newInstock = fruitService.detailFruitInfo(fruitNo).getInstock() - item.getQuantity();
			if (newInstock >= 0) {
				fruitService.updateFruitInstock(fruitNo, newInstock);
			} else {
				return false;
			}
		}
		
		// 3. 주문 정보 DB에 추가
		orderDAO.insertOrder(order);		
		return true;
	}

	@Override
	public List<OrderVO> listMyOrders(String memberId) {
		return orderDAO.selectOrdersOfMember(memberId);
	}

	@Override
	public List<OrderVO> listAllOrder() {
		return orderDAO.selectAllOrder();
	}

}
