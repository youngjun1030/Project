package review;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import member.MemberVO;
import fruit.FruitVO;

public class ReviewService {
    private List<Review> reviews = new ArrayList<>();

    public void addReview(MemberVO member, FruitVO product, String content, int rating) {
        reviews.add(new Review(member, product, content, rating));
        System.out.println("리뷰가 등록되었습니다.");
    }

    public void viewReviewsByProduct(FruitVO product) {
        List<Review> productReviews = reviews.stream()
            .filter(r -> r.getProduct().equals(product))
            .collect(Collectors.toList());

        if (productReviews.isEmpty()) {
            System.out.println("해당 상품에 등록된 리뷰가 없습니다.");
        } else {
            System.out.println("▶ 상품 리뷰 목록:");
            for (Review r : productReviews) {
                System.out.printf("- %s (%d점): %s\n",
                    r.getMember().getUsername(), r.getRating(), r.getContent());
            }
        }
    }
}