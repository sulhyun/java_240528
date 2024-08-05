USE CGV;

# 등록된 모든 영화를 조회하는 쿼리
SELECT * FROM MOVIE;

# 등록된 모든 영화를 조회하는 쿼리(장르도 함께 검색, 장르 때문에 같은 영화 제목이 여러번 나옴)
SELECT MO_TITLE, MG_GE_NAME
FROM 
	MOVIE
JOIN 
	MOVIE_GENRE ON MO_NUM = MG_MO_NUM;

# 장르가 액션인 영화를 조회하는 쿼리
# 방법 1)
SELECT MO_TITLE, MG_GE_NAME
FROM 
	MOVIE
JOIN 
	MOVIE_GENRE ON MO_NUM = MG_MO_NUM
WHERE MG_GE_NAME = '액션';

# 방법 2)
SELECT *
FROM 
	MOVIE
WHERE MO_NUM IN(
SELECT MG_MO_NUM 
FROM 
    MOVIE_GENRE 
WHERE MG_GE_NAME = '액션');

# 장르가 액션으로 등록된 영화 수를 조회하는 쿼리
SELECT MG_GE_NAME, COUNT(MG_MO_NUM)
FROM 
	MOVIE_GENRE
WHERE MG_GE_NAME = '액션'
GROUP BY MG_GE_NAME;

# 모든 장르에 등록된 영화 수를 죄회하는 쿼리(단, 영화가 등록되지 않은 장르들은 조회가 X)
SELECT MG_GE_NAME, COUNT(MG_MO_NUM)
FROM
	MOVIE_GENRE
GROUP BY MG_GE_NAME;

# 모든 장르에 등록된 영화 수를 죄회하는 쿼리(단, 영화가 등록되지 않은 장드들은 조회가 O)
SELECT GE_NAME, COUNT(MG_MO_NUM)
FROM
	MOVIE_GENRE
RIGHT JOIN
	GENRE ON MG_GE_NAME = GE_NAME
GROUP BY GE_NAME;

# 등록된 영화를 이름순으로 6개 조회하는 쿼리(내림차순, 1페이지)
SELECT MO_TITLE
FROM
	MOVIE
ORDER BY MO_TITLE DESC
LIMIT 0, 6;

# 등록된 영화를 이름순으로 6개 조회하는 쿼리(내림차순, 1페이지)
SELECT MO_TITLE
FROM
	MOVIE
ORDER BY MO_TITLE DESC
LIMIT 6, 6;

# 데드풀과 울버린을 관람한 관객수를 조회하는 쿼리
SELECT '데드풀과 울버린' 영화제목, SUM(TI_ADULT + TI_TEENAGER) 관객수
FROM
	TICKETING
JOIN 
	SCHEDULE ON TI_SD_NUM = SD_NUM
WHERE SD_MO_NUM = (
SELECT MO_NUM
FROM
	MOVIE
WHERE MO_TITLE = '데드풀과 울버린')
GROUP BY SD_MO_NUM;

# 영화별 관객수를 조회하는 쿼리
SELECT MO_TITLE 영화제목, SUM(TI_ADULT + TI_TEENAGER) 관객수
FROM
	TICKETING
RIGHT JOIN 
	SCHEDULE ON TI_SD_NUM = SD_NUM
RIGHT JOIN
	MOVIE ON SD_MO_NUM = MO_NUM
GROUP BY MO_NUM;

# 데드풀과 울버린 영화 상영시간을 조회하는 쿼리
# 내 쿼리)
SELECT '데드풀과 울버린' 영화제목, SD_DATE 상영날짜, SD_TIME 상영시간
FROM 
	SCHEDULE
WHERE SD_MO_NUM = (
SELECT MO_NUM
FROM MOVIE
WHERE MO_TITLE = '데드풀과 울버린');

# 강사님 쿼리)
SELECT *
FROM
	SCHEDULE
WHERE SD_MO_NUM IN(
SELECT MO_NUM
FROM
	MOVIE
WHERE MO_TITLE = '데드풀과 울버린');

# 데드풀과 울버린 영화 상영시간을 조회하느 쿼리(7/27 오후 상영시간을 조회)
SELECT MO_TITLE 영화제목, SD_DATE 상영날짜, SD_TIME 상영시간
FROM 
	SCHEDULE
JOIN
	MOVIE ON SD_MO_NUM = MO_NUM
WHERE MO_TITLE = '데드풀과 울버린' 
	AND SD_DATE = '2024-07-27'
	AND SD_TIME > '12:00:00';

# 2번 상영시간에 예약된 좌석을 조회하는 쿼리
SELECT SE_NAME
FROM
	TICKETING_LIST
JOIN
	TICKETING ON TL_TI_NUM = TI_NUM
JOIN 
	SEAT ON TL_SE_NUM = SE_NUM
WHERE TI_SD_NUM = 2;

# 2번 상영시간에 예약 가능한 좌석을 조회하는 쿼리
SELECT SE_NAME
FROM 
	SCHEDULE
JOIN 
	SCREEN ON SD_SC_NUM = SC_NUM
JOIN 
	SEAT ON SC_NUM = SE_SC_NUM
WHERE SD_NUM = 2 AND SE_NAME NOT IN(
SELECT SE_NAME
FROM
	TICKETING_LIST
JOIN
	TICKETING ON TL_TI_NUM = TI_NUM
JOIN 
	SEAT ON TL_SE_NUM = SE_NUM
WHERE TI_SD_NUM = 2
);

# 휴 잭맨이 참여한 영화 목록을 조회하는 쿼리
SELECT MO_TITLE
FROM 
	MOVIE
JOIN
	CASTING ON CS_MO_NUM = MO_NUM
JOIN 
	`CHARACTER` ON CH_NUM = CS_CH_NUM
JOIN
	PERSON ON PS_NUM = CH_PS_NUM
WHERE PS_NAME = '휴 잭맨';

# CGV강남에서 상영했거나 상영중, 상영예정인 영화들을 조회하는 쿼리
SELECT DISTINCT MO_TITLE
FROM 
	MOVIE
JOIN 
	SCHEDULE ON SD_MO_NUM = MO_NUM
JOIN 
	(SELECT * FROM SCREEN WHERE SC_TH_NUM = (
    SELECT TH_NUM FROM THEATER WHERE TH_NAME = 'CGV강남')) SC 
    ON SD_SC_NUM = SC_NUM;

USE COMMUNITY;
# 게시글을 조회하는 쿼리(번호 내림차순, 3개, 1페이지)
SELECT *
FROM
	POST
ORDER BY PO_NUM DESC
LIMIT 0, 3;

# 게시글 제목에 '구'가 들어가는 게시글을 조회하는 쿼리(번호 내림차순, 3개, 1페이지)
SELECT *
FROM 
	POST
WHERE PO_TITLE LIKE CONCAT('%', '구', '%')
ORDER BY PO_NUM DESC
LIMIT 0, 3;

# 축구 커뮤니티에 등록된 게시글을 조회하는 쿼리(커뮤니티 번호가 2번)
SELECT *
FROM 
	POST
WHERE PO_CO_NUM = 2;

# 1번 게시글의 댓글들을 조회하는 쿼리(단, 대댓은 댓글 다음에 와야 함)
/*
댓글1
	- 댓글 1-1
    - 댓글 1-2
    - 댓글 1-3
댓글2
*/
# 내 쿼리)
SELECT CM_CONTENT
FROM
	COMMENT
WHERE CM_PO_NUM = 1
ORDER BY CM_NUM;

# 강사님 쿼리)
SELECT *
FROM
	COMMENT
WHERE CM_PO_NUM = 1
ORDER BY CM_ORI_NUM, CM_NUM;

# 1번 게시글을 댓글 1페이지를 조회하는 쿼리(한 페이지에 5개)
SELECT *
FROM
	COMMENT
WHERE CM_PO_NUM = 1
ORDER BY CM_ORI_NUM, CM_NUM
LIMIT 0, 5;

# 게시글을 조회(조회수가 많은 순으로 조회)
SELECT *
FROM
	POST
ORDER BY PO_VIEW DESC;

# 게시글을 조회(조회수가 많은 순으로 조회, 조회순으로 했을 때 3위 게시글까지 조회, RANK()를 이용)
# 윈도우 함수를 WHERE에 직접 사용할 수 없어서 검색 결과를 하나의 테이블처럼 처리해야 함
SELECT *
FROM 
	(SELECT RANK() OVER(ORDER BY PO_VIEW DESC) 순위, POST.* FROM POST) PO
WHERE '순위' <= 3;