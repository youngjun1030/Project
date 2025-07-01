# 과일 판매 쇼핑몰(FruitShop)

### 자바를 사용해서 강의시간동안 배운 내용들로 교수님과 함께 BookMartConsoleApp을 개발했고 BookMartConsoleApp을 내용을 토대로 자바 첫 프로젝트인 FruitshopConsoleApp에 대한 설명입니다.

자바를 배운지 3개월 후에 처음 개발한 프로젝트인 만큼 부족한 기능, 놓친 코드, 예외처리 등이 있지만 쇼핑몰 사용해본 사용자 입장에서 요구사항 명세서(기능, 비기능)를 작성해서 그 안의 요구사항들을 토대로 쇼핑몰에 있어야 하는 필수적인 기능(회원가입, 로그인, 주문)에 더불어 리뷰, 과일검색, 별점과 같은 기능 등등 구현되어 있으면 사용자 입장에서 편리한 기능들도 개발했지만 어디까지나 Console에서만 돌아가는 코드이기 때문에 2학기에는 웹과 DB에 연동하여 실제 쇼핑몰 다운 프로젝트로 완성시킬 예정입니다.
개발은 Eclipse에서 진행 했으며, 각 패키지들 마다 VO 클래스, DAO, Service 인터페이스가 포함되어 있고 코드는 전부 카멜타입 명명규칙을 활용했습니다.

# 메서드 명명 규칙

### BookMartConsoleApp 메서드 명명 규칙

• 메뉴를 보여주고 사용자의 메뉴 입력을 받아 기능을 수행하는 메서드 → contolOOOMenu(), OOO은 메뉴이름

‣ 예) controlAdminMenu()

• 메뉴 선택 시 해당 메뉴 수행 메서드 → menuOOO(), OOO은 메뉴 항목 이름

‣ 예) menuLogin()

---

### DAO 메서드 명명 규칙

• insert, select, update, delete와 같이 SQL 용어 사용

• 예) insertMember(), selectMember()

---

### 데이터를 다루는 메서드명에 데이터명 사용시
  
• 데이터 한 개가 대상인 경우 단수 사용 (예) removeMember

• 데이터 여러 개가 대상인 경우 복수 사용 (예) listMembers

### 기타 메서드는 영어문장과 유사하게 명명

---

## 자료구조 명명 규칙

- HashMap을 사용하는 자료구조는 OOODB, List를 사용하는 자료구조는 OOOList

## 코드 내에 특정 데이터값 (literal)을 직접 사용하지 않고 상수를 정의하여 사용

---

# 목차

    1. 요구사항 명세서
    2. 패키지 설명
    3. Use-case Diagram
    4. Activity Diagram
    5. 콘솔 시연 영상
    6. 코드리뷰 결과

# 요구사항 명세서

## 작성중입니다..

# 과일 판매 쇼핑몰(FruitShop) 패키지 설명

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

# Use-case Diagram

![image](https://github.com/user-attachments/assets/54a2cab9-03ac-4259-ba99-ff4b442fe558)


# Activity Diagram

![image](https://github.com/user-attachments/assets/2ffbc4db-257f-4357-aed9-875dbd5df6ef)


# 콘솔 시연 영상

## 회원 메뉴

https://github.com/user-attachments/assets/e767d6cd-0623-4459-9aeb-107aff0007f2

https://github.com/user-attachments/assets/095411ae-3d3f-479c-9059-46e075b7196b


## 관지라 메뉴

https://github.com/user-attachments/assets/2e000805-5854-4074-b798-79d57eabef8b


# 코드리뷰 결과

![image](https://github.com/user-attachments/assets/47b45f0d-d9bb-4c35-be1f-d81d33eb7128)

![image](https://github.com/user-attachments/assets/b14c7748-f813-4f00-9169-35735142937f)


![image](https://github.com/user-attachments/assets/ee636e0e-80aa-4e31-a372-e1157d71ad18)

#### addItem2Cart -> addItemToCart [수정]

![image](https://github.com/user-attachments/assets/c8e26b68-cbd8-48a4-a6ff-e7b28eb768fb)

#### 장바구니 도서 담기 -> 장바구니 과일 담기 [수정]

![image](https://github.com/user-attachments/assets/a40f0240-3873-4508-b0a4-553b33f0adc0)

#### 없는 도서 입니다. -> 없는 과일 입니다. [수정]

![image](https://github.com/user-attachments/assets/523a16fc-fe3e-4ffd-bb09-928f79fc2ee9)

#### 장바구니의 모든 도서를 삭제하시겠습니까? -> 장바구니의 모든 과일을 삭제하시겠습니까? [수정]
