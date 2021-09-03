
ALTER TABLE test AUTO_INCREMENT=1;

delete from crprice where cridx=7;

insert into place values (null, '핏블리짐 부천점','07:00~23:00', '주차가능', '부천시 석천로 389 굿모닝빌딩 B3F', '032-123-4567');
insert into place values (null, '스타일짐 신촌점','06:00~21:30', '주차가능', '서울시 마포구 96-3 에이타운 2F', '02-3456-7890');

insert into crcertification values ('1', '용인대학교 졸업', '유도 4단', '2급 생활체육지도자 자격', '스포츠 마사지 1급 자격', '독일 BALLance junior EXPERT');
insert into crcertification values ('2', '저쩌고', '저쩌고2', '저쩌고3', '저쩌고4', '저쩌고5');
insert into crcertification values ('3', '저쩌고3', '저쩌고2', '저쩌고3', '저쩌고4', '저쩌고5');
insert into crcertification values ('4', '저쩌고4', '저쩌고2', '저쩌고3', '저쩌고4', '저쩌고5');
insert into crcertification values ('5', '생활스포츠지도사 자격증 2급', '유소년스포츠지도사 2급', '라이프가드(인명구조요원)', '재활 운동처방사 수료', 'CPR 응급처치 수료');
insert into crcertification values ('6', 'YMCA 라이프가드 자격증', '스포츠 마사지 1급', '재활 운동처방사 수료', 'I.F.S.H 퍼스널트레이너 1급', '키네시오 테이핑 2급');
insert into crcertification values ('7', '2급 생활스포츠 지도사', '소도구 트레이닝 교육수료', '폼롤러테라피 코어트레이닝 교육이수', '웨이트 트레이닝 교육이수', '근 골격계 해부학 이수');

insert into crprice (cridx, procount, proprice)
values
('1', '1', '49000'),
('1', '5', '240000'),
('1', '10', '430000'),
('1', '20', '945000'),
('2', '1', '45000'),
('2', '5', '247000'),
('2', '10', '470000'),
('2', '20', '970000'),
('3', '1', '48500'),
('3', '5', '262000'),
('3', '20', '920000'),

('4', '1', '50000'),
('4', '5', '240000'),
('4', '10', '450000'),
('4', '20', '970000'),

('5', '1', '55000'),
('5', '5', '300000'),
('5', '10', '515000'),
('5', '20', '1030000'),
('6', '1', '51000'),
('6', '5', '290000'),
('6', '10', '440000'),
('6', '20', '905000'),
('7', '1', '50000'),
('7', '5', '270000'),
('7', '10', '460000'),
('7', '20', '930000')
;


-- insert into crprice values ('1', '1', '49000');
-- insert into crprice values ('1', '5', '240000');
-- insert into crprice values ('1', '10', '430000');
-- insert into crprice values ('1', '20', '940000');


insert into carry values
(null,
default,
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
'1');

insert into carry values
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

insert into carry values
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

insert into carry values
(null,
default,
'apple@gmail.com',
'1111',
'홍길동',
'홍',
'남자',
'010-1234-1234',
'안녕하세요. 자기소개입니다자기소개입니다자기소개입니다자기소개입니다자기소개입니다 자기소개입니다자기소개입니다자기소개입니다',
'대회 준비',
'헬스',
'1',
'2');



insert into member values (null, 'test@test.com', '1111', '김회원', '김', '010-5555-5555', '990101', '여자', default);
insert into member values (null, 'cool@test.com', '1111', '박회원', '박박', '010-3333-3333', '940315', '남자', default);


insert into carryreview values (null, '리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다.', '3', '2');
insert into carryreview values (null, '리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다리뷰입니다.', '4', '1');

insert into payment values (null, sysdate(), '1', '황지원', '010-2315-2568', '2', '20', '952000', '1');




update crcertification set crcerti1='용인대학교 졸업', crcerti2='유도 4단', crcerti3='2급 생활체육지도자 자격', crcerti4='스포츠 마사지 1급 자격', crcerti5='독일 BALLance junior EXPERT'
where cridx=1;

update crcertification set crcerti1='경기대학교 사회체육학과 졸업', crcerti2='생활스포츠지도사 2급', crcerti3='다이어트 프로그래머 수료', crcerti4='한국인재교육원 재활치료사 자격증', crcerti5='CPR 응급처치 수료'
where cridx=2;

update crcertification set crcerti1='스포츠마사지 1급', crcerti2='사단법인 체형관리사3급 자격 수료', crcerti3='재활 운동처방사 수료', crcerti4='CPR 응급처치 수료', crcerti5='키네시오 테이핑2급'
where cridx=3;

update crcertification set crcerti1='생활체육 지도사 자격2급', crcerti2='KPEA Prehab Exercise 교육 수료', crcerti3='심폐소생술 교육 수료', crcerti4='CPR 응급처치 수료', crcerti5='수상안전요원 Life Guard 자격'
where cridx=4;

