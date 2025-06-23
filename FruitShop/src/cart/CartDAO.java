package cart;

import java.util.List;

public interface CartDAO {
	boolean insertCartItem(CartItemVO item);
	CartItemVO selectCartItem(int fruitNo);
	List<CartItemVO> selectAllCartItem();
	boolean deleteCartItem(int fruitNo);
	boolean clear();
}
