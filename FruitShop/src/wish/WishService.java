package wish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import member.MemberVO;
import fruit.FruitVO;

public class WishService {
    private List<Wish> wishList = new ArrayList<>();

    public void addWish(MemberVO member, FruitVO product) {
        for (Wish wish : wishList) {
            if (wish.getMember().equals(member) && wish.getProduct().equals(product)) {
                System.out.println("이미 찜한 상품입니다.");
                return;
            }
        }
        wishList.add(new Wish(member, product));
        System.out.println("찜 목록에 추가되었습니다.");
    }

    public void viewWishList(MemberVO member) {
        List<Wish> memberWishes = wishList.stream()
            .filter(w -> w.getMember().equals(member))
            .collect(Collectors.toList());

        if (memberWishes.isEmpty()) {
            System.out.println("찜한 상품이 없습니다.");
        } else {
            System.out.println("▶ 찜한 상품 목록:");
            for (Wish wish : memberWishes) {
                FruitVO p = wish.getProduct();
                System.out.printf("- [%d] %s | ₩%,d\n",p.getFruitNo()
                        , p.getName(), p.getPrice());
            }
        }
    }
}