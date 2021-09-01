
ALTER TABLE test AUTO_INCREMENT=1;


insert into gymcarry.place values (null, '핏블리짐 부천점','07:00~23:00', '주차가능', '부천시 석천로 389 굿모닝빌딩 B3F', '032-123-4567');
insert into gymcarry.place values (null, '스타일짐 신촌점','06:00~21:30', '주차가능', '서울시 마포구 96-3 에이타운 2F', '02-3456-7890');

insert into gymcarry.crcertification values ('1', '자격 및 경력1', '자격 및 경력2', '자격 및 경력3', '자격 및 경력4', '자격 및 경력5');
insert into gymcarry.crcertification values ('2', '저쩌고', '저쩌고2', '저쩌고3', '저쩌고4', '저쩌고5');

insert into gymcarry.crprice values ('1', '49000', '230000', '460000', '930000');
insert into gymcarry.crprice values ('2', '48000', '245000', '473000', '952000');



insert into gymcarry.carry values
(null,
'kimcarry@gmail.com',
'carry1234',
'김자바',
'김캐리',
'남자',
'010-1234-1234',
'안녕하세요. 김캐리입니다자기소개입니다.안녕하세요. 김캐리입니다자기소개입니다.안녕하세요. 김캐리입니다자기소개입니다.안녕하세요. 김캐리입니다자기소개입니다.안녕하세요. 김캐리입니다자기소개입니다.안녕하세요. 김캐리입니다자기소개입니다.',
'체력증진, 다이어트',
'헬스',
'1',
'핏블리짐 부천점',
'1');

insert into gymcarry.carry values
(null,
default,
'choicarry@gmail.com',
'1111',
'최자바',
'최캐리',
'여자',
'010-1234-1234',
'안녕하세요. 최캐리입니다자기소개입니다.안녕하세요. 최캐리입니다자기소개입니다.안녕하세요. 최캐리입니다자기소개입니다. 최캐리입니다자기소개입니다',
'다이어트',
'헬스',
'1',
'1');

insert into gymcarry.carry values
(null,
default,
'leecarry@gmail.com',
'1111',
'이자바',
'이캐리',
'여자',
'010-1234-1234',
'안녕하세요. 자기소개입니다',
'바디프로필',
'헬스',
'1',
'2');



insert into gymcarry.member values (null, 'test@test.com', '1111', '김회원', '김', '010-5555-5555', '990101', '여자', default);
insert into gymcarry.member values (null, 'cool@test.com', '1111', '박회원', '박박', '010-3333-3333', '940315', '남자', default);


insert into gymcarry.carryreview values (null, '리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다.', '3', '2');
insert into gymcarry.carryreview values (null, '리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다.', '4', '1');

insert into gymcarry.payment values (null, sysdate(), '1', '황지원', '010-2315-2568', '2', '20', '952000', '1')