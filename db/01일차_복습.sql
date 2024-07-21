# 데이터 베이스 삭제
# 워크프에이스에서 DB명 우클릭 Drop Schema... 클릭 후 Drop now 클릭
drop database if exists ATM;

# 데이터 베이스 생성
# 워크벤치에서 Schemas 아래 공백에 우클릭 후 Create Schema 클릭 후 DB명 입력 후 Apply
create database if not exists ATM;

# 데이터베이스 수정 - 이름은 수정이 안됨. 문자 집합을 수정
# ALTER SCHEMA DB명 기본문자집합 바꿀문자집합 기본COLLATE 바꿀COLLATE;
# 워크스페이스에서 DB명에 호버하고 2번째 아이콘 클릭 후 원하는 문자집합과 collate를 선택 후 apply

# 데이터 베이스 선택
use atm;

# 테이블 삭제
drop table if exists atm.account;

# 테이블 생성
# 워크벤치에서 Tables 우클릭 Create table 클릭 후 속성과 옵션들을 선택해서 apply
# 외래키는 foreign 탭에서 작업
create table if not exists atm.account(
	accountNum int primary key auto_increment,
    password varchar(4) not null,
    name varchar(20) not null,
    balance int not null default 0,
    check(char_length(password) = 4),
    check(char_length(name) >= 2),
    check(balance >= 0)
);
drop table if exists atm.detail;
create table if not exists atm.detail(
	dataNum int primary key auto_increment,
    detail varchar(5) not null,
    money int not null default 0,
    date date not null,
    accountNum int not null,
    foreign key(accountNum) references account(accountNum)
		on delete cascade on update cascade
);

# 비밀번호가 0으로 시작하면 안됨 왜???
# insert
# 한 행(레코드)의 데이터를 추가할 때 사용
# 속성의 개수가 값의 개수가 같아야함
insert into atm.account(password, name, balance)
value(1234, '홍길동', 0);
insert into atm.account(password, name, balance)
values(4788, '나길동', 0),(5678, '고길동', 0);
insert into atm.account(password, name) value(7890, '김설현');
insert into atm.account(password, name) value(7770, '김설빈');
insert into atm.account(password, name) value(7777, '이승원');
insert into atm.account(password, name) value(1000, '송대국');
insert into atm.account(password, name) value(2000, '전지우');

# update
# 특정 행들의 값들을 변경할 때 사용
update atm.account set password = 3000 where account.accountNum = 1;
update atm.account set password = 6000 where name = '김설현';
# Ctrl + B 누르면 보기좋게 만들어줌
UPDATE atm.account 
SET 
    password = 4000
WHERE
    account.accountNum = 2;
# 워크 벤치에서는 안전하게 수정/삭제할 수 있게 하기 위해 기본키가 아닌 조건으로
# 수정/삭제하려고 하면 수정/삭제를 하지 못하도록 막음
# 해결방법 : Edit > Preferences... > SQL Editor 
#			> Safe updates 체크박스 해제 후 ok 클릭
UPDATE atm.account 
SET 
    password = 5000
WHERE
    account.name = '고길동';

# delete
# 특정 행들을 삭제할 때 사용 
delete from atm.account where accountNum = 5;
delete from atm.account where name = '이승원';
delete from atm.account;

# delete와 truncate의 차이
# delete는 데이터만 지우고 초기 설정은 그대로 유지 - 대표적으로 auto_increment 시작 숫자 유지
# truncate은 데이터 뿐만아니라 설정도 초기로 돌림 - auto_increment 숫자가 1에서 시작
# truncate은 다른 테이블이 참조하고 있는 경우 초기화가 안됨

insert into atm.account(password, name, balance)
value(1000, '홍길동', 10000);
insert into atm.detail(detail, money, date, accountNum)
value('출금', 5000, '2024-07-21', 1);
insert into atm.detail(detail, money, date, accountNum)
value('입금', 3000, '2024-07-21', 1);
delete from atm.detail;
insert into atm.detail(detail, money, date, accountNum)
value('출금', 5000, '2024-07-21', 1);
truncate table atm.detail;
insert into atm.detail(detail, money, date, accountNum)
value('출금', 5000, '2024-07-21', 1);