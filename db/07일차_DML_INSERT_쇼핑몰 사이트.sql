# 제품 분류를 등록하는 쿼리
INSERT INTO CATEGORY(CA_NAME) VALUES
('옷'),('모자'),('신발'),('악세서리'),('기타');

# 사용자 회원가입하는 쿼리
# ID : abc123 PW : abc123, Email : abc123@naver.com 번호 : 011-1234-5678
# ID : qwe123 PW : qwe123, Email : qwe123@naver.com 번호 : 011-1111-2222
INSERT INTO MEMBER (ME_ID, ME_PW, ME_EMAIL, ME_PHONE, ME_AUTHORITY, ME_FAIL) VALUES
('abc123', 'abc123', 'abc123@naver.com', '011-1234-5678', 'USER', 0),
('qwe123', 'qwe123', 'qwe123@naver.com', '011-1111-2222', 'USER', 0);
 