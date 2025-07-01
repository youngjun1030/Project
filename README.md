# 과일 판매 쇼핑몰(FruitShop)

# 프로젝트 내용



# 목차

    1. 패키지 설명
    2. Use-case Diagram
    3. Activity Diagram
    4. 콘솔 시연 영상
    5. 코드리뷰 결과

## 과일 판매 쇼핑몰(FruitShop) 패키지 설명

![image](https://github.com/user-attachments/assets/fb257908-256f-4f49-a4c9-2acbf58dc31b)
app : 프로그램의 시작점인 main 메서드, 콘솔에 메뉴 출력 (예: 1. 상품 조회, 2. 장바구니 보기 등), 사용자의 입력에 따라 적절한 Service 호출.

![image](https://github.com/user-attachments/assets/a8be9f9e-9d82-4fdf-afe7-bfdcc6ee6a97)
cart : 장바구니에 과일 담기, 장바구니 비우기와 같은 장바구니와 관련된 기능들을 담는 패키지.

![image](https://github.com/user-attachments/assets/e315d498-baf7-49ea-be0b-067f01e254bf)
fruit : 과일 목록 조회, 과일 등록, 과일 삭제, 과일 이름 검색,  과일 가격순 정렬과 같은 과일 과일과 관련된 기능들을 담는 패키지.

![image](https://github.com/user-attachments/assets/30e296f1-33a7-46ad-a0a1-6a0b49920eda)
fruit.file : 과일 데이터를 파일로 저장하거나 불러오는 DAO 클래스들을 담는 패키지.
 
![image](https://github.com/user-attachments/assets/05f7ed94-e06d-4a6c-baed-d67edd5aaea4)
member : 회원가입, 로그인 등 회원과 관련된 기능들을 담는 패키지.

![image](https://github.com/user-attachments/assets/19d0b92a-255c-4477-b687-89d2f4913001)
order : 주문(Order) 과 관련된 모든 기능을 담는 패키지.

![image](https://github.com/user-attachments/assets/049dd598-28f0-4a64-ad2f-1b0cac8f3016)
review : 리뷰 작성, 리뷰 보기와 같은 기능들을 담는 패키지.

![image](https://github.com/user-attachments/assets/ead71ae4-dd2d-47c5-b825-98c653aad4d6)
wish : 찜하기, 찜 목록 보기와 같은 기능들을 담는 패키지.

## Use-case Diagram

![image](https://github.com/user-attachments/assets/54a2cab9-03ac-4259-ba99-ff4b442fe558)


## Activity Diagram

![image](https://github.com/user-attachments/assets/2ffbc4db-257f-4357-aed9-875dbd5df6ef)


## 콘솔 시연 영상

### 회원 메뉴

https://github.com/user-attachments/assets/e767d6cd-0623-4459-9aeb-107aff0007f2

https://github.com/user-attachments/assets/095411ae-3d3f-479c-9059-46e075b7196b


### 관지라 메뉴

https://github.com/user-attachments/assets/2e000805-5854-4074-b798-79d57eabef8b


## 코드리뷰 결과 [수정 완료]

![image](https://github.com/user-attachments/assets/ee636e0e-80aa-4e31-a372-e1157d71ad18)

#### addItem2Cart -> addItemToCart [수정]

![image](https://github.com/user-attachments/assets/c8e26b68-cbd8-48a4-a6ff-e7b28eb768fb)

#### 장바구니 도서 담기 -> 장바구니 과일 담기 [수정]

![image](https://github.com/user-attachments/assets/a40f0240-3873-4508-b0a4-553b33f0adc0)

#### 없는 도서 입니다. -> 없는 과일 입니다. [수정]

![image](https://github.com/user-attachments/assets/523a16fc-fe3e-4ffd-bb09-928f79fc2ee9)

#### 장바구니의 모든 도서를 삭제하시겠습니까? -> 장바구니의 모든 과일을 삭제하시겠습니까? [수정]
