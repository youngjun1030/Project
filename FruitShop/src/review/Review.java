package review;

import member.MemberVO;
import fruit.FruitVO;

public class Review {
    private MemberVO member;
    private FruitVO product;
    private String content;
    private int rating; // 1~5

    public Review(MemberVO member, FruitVO product, String content, int rating) {
        this.member = member;
        this.product = product;
        this.content = content;
        this.rating = rating;
    }

    public MemberVO getMember() {
        return member;
    }

    public FruitVO getProduct() {
        return product;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }
}