USE UNIVERSITY;

# 등록된 강의를 조회하는 쿼리
SELECT * FROM LECTURE;

# 교수 번호가 2024123001인 교수님이 강의하는 강의를 조회하는 쿼리
SELECT * 
FROM 
	LECTURE
WHERE LE_PR_NUM = '2024123001'; 

# 학번이 2024123001인 학생이 수강하는 강의를 조회하는 쿼리
SELECT *
FROM
	LECTURE
JOIN 
	COURSE ON CO_LE_NUM = LE_NUM
WHERE CO_ST_NUM = '2024123001';

# 전공 필수인 강의를 조회하는 쿼리
SELECT *
FROM
	LECTURE
WHERE LE_MAJOR = '전공 필수';
# 컴퓨터공학 학생들이 수강하는 강의들을 조회하는 쿼리
# 방법 1)
SELECT *
FROM
	LECTURE
JOIN
	COURSE ON CO_LE_NUM = LE_NUM
JOIN
	STUDENT ON ST_NUM = CO_ST_NUM
WHERE ST_MAJOR = '컴퓨터공학';

# 방법 2)
SELECT DISTINCT LECTURE.*
FROM
	LECTURE
JOIN
	COURSE ON CO_LE_NUM = LE_NUM
WHERE CO_ST_NUM IN(SELECT ST_NUM FROM STUDENT WHERE ST_MAJOR = '컴퓨터공학');