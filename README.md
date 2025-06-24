# 목차

    1. 패키지 설명
    2. Use-case Diagram
    3. 콘솔 시연 영상
    4. 코드리뷰 결과

## 과일 판매 쇼핑몰(FruitShop) 패키지 설명

![image](https://github.com/user-attachments/assets/bcc80097-343d-46cf-8bbf-73849664ea35)


app : 프로그램의 시작점인 main 메서드, 콘솔에 메뉴 출력 (예: 1. 상품 조회, 2. 장바구니 보기 등), 사용자의 입력에 따라 적절한 Service 호출.

cart : 장바구니에 과일 담기, 장바구니 비우기와 같은 장바구니와 관련된 기능들을 담고 있는 패키지.

fruit : 과일 목록 조회, 과일 등록, 과일 삭제, 과일 이름 검색,  과일 가격순 정렬과 같은 과일 과일과 관련된 기능들을 담고 있는 패키지.

member : 회원가입, 로그인 등 회원과 관련된 기능을 담당하는 패키지.

order : 주문(Order) 과 관련된 모든 기능을 담당하는 패키지.

review : 리뷰 작성, 리뷰 보기와 같은 기능들을 담고 있는 패키지.

wish : 찜하기, 찜 목록 보기와 같은 기능들이 담고 있는 패키지.

## Use-case Diagram
![image](https://github.com/user-attachments/assets/54a2cab9-03ac-4259-ba99-ff4b442fe558)


## 콘솔 시연 영상

![FruitShop – FruitShopConsoleApp java 2025-06-24 20-22-57](https://github.com/user-attachments/assets/cfc45724-5586-4525-85cd-a0f64fe33806)


## 코드리뷰 결과 [수정 완료]

![image](https://github.com/user-attachments/assets/b85acc9d-35eb-475a-b406-4a437b9430e0)

addItem2Cart -> addItemToCart [수정]

![image](https://github.com/user-attachments/assets/d5fb44c7-62a4-4009-bf04-172c71c0a712)

장바구니 도서 담기 -> 장바구니 과일 담기 [수정]

![image](https://github.com/user-attachments/assets/b052619a-fb36-42fb-bf78-69926a7f4eea)

없는 도서 입니다. -> 없는 과일 입니다. [수정]

![image](https://github.com/user-attachments/assets/e6d7eb60-7a39-4c9e-91c0-338fbf832e9b)

장바구니의 모든 도서를 삭제하시겠습니까? -> 장바구니의 모든 과일을 삭제하시겠습니까? [수정]
