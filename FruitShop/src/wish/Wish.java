package wish;

import member.MemberVO;
import fruit.FruitVO;

public class Wish {
    private MemberVO member;
    private FruitVO product;

    public Wish(MemberVO member, FruitVO product) {
        this.member = member;
        this.product = product;
    }

    public MemberVO getMember() {
        return member;
    }

    public FruitVO getProduct() {
        return product;
    }
}