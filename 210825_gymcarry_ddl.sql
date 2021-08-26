
CREATE TABLE `MEMBER` (
  `MEMIDX` int NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `MEMEMAIL` varchar(40) NOT NULL COMMENT '이메일',
  `MEMPW` varchar(30) NOT NULL COMMENT '비밀번호',
  `MEMNAME` varchar(50) NOT NULL COMMENT '이름',
  `MEMNICK` varchar(50) NOT NULL COMMENT '닉네임',
  `MEMPHONE` varchar(50) NOT NULL COMMENT '핸드폰번호',
  `MEMBIRTH` int NOT NULL COMMENT '생년월일',
  `MEMGENDER` varchar(5) NOT NULL COMMENT '성별',
  `MEMPHOTO` varchar(30) DEFAULT 'photo.png' COMMENT '회원사진',
  PRIMARY KEY (`MEMIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원';


CREATE TABLE `MEMBERBODYINFO` (
  `MEMO` mediumtext COMMENT '타입',
  `MEMDATE` timestamp NULL DEFAULT NULL COMMENT '날짜',
  `MEMIDX` int NOT NULL COMMENT '회원번호',
  KEY `FK_MEMBER_TO_MEMBERBODYINFO` (`MEMIDX`),
  CONSTRAINT `FK_MEMBER_TO_MEMBERBODYINFO` FOREIGN KEY (`MEMIDX`) REFERENCES `MEMBER` (`MEMIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원바디기록';



CREATE TABLE `BOARD` (
  `POSTIDX` int NOT NULL AUTO_INCREMENT COMMENT '게시글IDX',
  `POSTNAME` varchar(255) NOT NULL COMMENT '제목',
  `POSTCONTENT` mediumtext NOT NULL COMMENT '글내용',
  `POSTNICK` varchar(50) NOT NULL COMMENT '닉네임',
  `MEMIDX` int NOT NULL COMMENT '회원번호',
  `UPLOADFILE` mediumblob COMMENT '첨부파일',
  `POSTDATE` timestamp NOT NULL COMMENT '작성일자',
  `POSTVIEW` int NOT NULL COMMENT '조회수',
  `POSTLIKE` int DEFAULT NULL COMMENT '좋아요갯수',
  `BOARDCATEGORY` varchar(50) NOT NULL COMMENT '말머리',
  PRIMARY KEY (`POSTIDX`),
  KEY `FK_MEMBER_TO_BOARD` (`MEMIDX`),
  CONSTRAINT `FK_MEMBER_TO_BOARD` FOREIGN KEY (`MEMIDX`) REFERENCES `MEMBER` (`MEMIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='게시판';


CREATE TABLE `BOARDCOMMENT` (
  `COMMENTIDX` int NOT NULL AUTO_INCREMENT COMMENT '댓글IDX',
  `POSTIDX` int NOT NULL COMMENT '게시글IDX',
  `COMMENTNICK` varchar(50) NOT NULL COMMENT '닉네임',
  `COMMENTCONTENT` mediumtext NOT NULL COMMENT '댓글내용',
  `COMMENTDATE` timestamp NOT NULL COMMENT '댓글작성일자',
  PRIMARY KEY (`COMMENTIDX`),
  KEY `FK_BOARD_TO_BOARDCOMMENT` (`POSTIDX`),
  CONSTRAINT `FK_BOARD_TO_BOARDCOMMENT` FOREIGN KEY (`POSTIDX`) REFERENCES `BOARD` (`POSTIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='게시판댓글';


CREATE TABLE `PLACE` (
  `PLACEIDX` int NOT NULL AUTO_INCREMENT COMMENT '플레이스IDX',
  `PLACENAME` varchar(50) NOT NULL COMMENT '플레이스이름',
  `OPENHOUR` mediumtext NOT NULL COMMENT '운영시간',
  `PARKING` mediumtext NOT NULL COMMENT '주차시설',
  `PLACEADDRESS` mediumtext NOT NULL COMMENT '플레이스주소',
  `PLACEPHONE` mediumtext NOT NULL COMMENT '플레이스번호',
  PRIMARY KEY (`PLACEIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='플레이스';



CREATE TABLE `CARRY` (
  `CRIDX` int NOT NULL AUTO_INCREMENT COMMENT '캐리IDX',
  `CRPHOTO` varchar(30) default 'photo.png' COMMENT '캐리사진',
  `CRID` varchar(30) NOT NULL COMMENT '캐리아이디',
  `CRPW` varchar(30) NOT NULL COMMENT '비밀번호',
  `CRNAME` varchar(50) NOT NULL COMMENT '캐리실명',
  `CRNICK` varchar(50) NOT NULL COMMENT '캐리닉네임',
  `CRGENDER` varchar(5) NOT NULL COMMENT '성별',
  `CRPHONE` varchar(50) NOT NULL COMMENT '캐리연락처',
  `CRINTRO` mediumtext COMMENT '소갯말',
  `CRDEPART` mediumtext COMMENT '전문분야',
  `CRFIELD` mediumtext COMMENT '종목',
  `CRCERTI1` mediumtext COMMENT '자격및경력1',
  `CRCERTI2` mediumtext COMMENT '자격및경력2',
  `CRCERTI3` mediumtext COMMENT '자격및경력3',
  `CRCERTI4` mediumtext COMMENT '자격및경력4',
  `CRCERTI5` mediumtext COMMENT '자격및경력5',
  `PROPRICE1` int NOT NULL COMMENT '수업1회가격',
  `PROPRICE5` int NOT NULL COMMENT '수업5회가격',
  `PROPRICE10` int NOT NULL COMMENT '수업10회가격',
  `PROPRICE20` int NOT NULL COMMENT '수업20회가격',
  `FACEORNOT` tinyint(1) NOT NULL COMMENT '비대면&대면',
  `PLACENAME` varchar(255) DEFAULT NULL COMMENT '소속플레이스',
  `PLACEIDX` int DEFAULT NULL COMMENT '플레이스IDX',
  PRIMARY KEY (`CRIDX`),
  KEY `FK_PLACE_TO_CARRY` (`PLACEIDX`),
  CONSTRAINT `FK_PLACE_TO_CARRY` FOREIGN KEY (`PLACEIDX`) REFERENCES `PLACE` (`PLACEIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='캐리정보';



CREATE TABLE `CARRYREVIEW` (
  `REVIEWIDX` int NOT NULL AUTO_INCREMENT COMMENT '리뷰IDX',
  `REVIEWCONTENT` mediumtext COMMENT '리뷰내용',
  `CRIDX` int DEFAULT NULL COMMENT '캐리IDX',
  `MEMIDX` int DEFAULT NULL COMMENT '회원번호',
  PRIMARY KEY (`REVIEWIDX`),
  KEY `FK_CARRY_TO_CARRYREVIEW` (`CRIDX`),
  KEY `FK_MEMBER_TO_CARRYREVIEW` (`MEMIDX`),
  CONSTRAINT `FK_CARRY_TO_CARRYREVIEW` FOREIGN KEY (`CRIDX`) REFERENCES `CARRY` (`CRIDX`),
  CONSTRAINT `FK_MEMBER_TO_CARRYREVIEW` FOREIGN KEY (`MEMIDX`) REFERENCES `MEMBER` (`MEMIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='캐리상세페이지 리뷰댓글';



CREATE TABLE `CHATLIST` (
  `CHATIDX` int NOT NULL auto_increment COMMENT '채팅방번호',
  `CRIDX` int NOT NULL COMMENT '캐리번호',
  `MEMIDX` int NOT NULL COMMENT '회원번호',
  PRIMARY KEY (`CHATIDX`),
  KEY `FK_CARRY_TO_CHATLIST` (`CRIDX`),
  KEY `FK_MEMBER_TO_CHATLIST` (`MEMIDX`),
  CONSTRAINT `FK_CARRY_TO_CHATLIST` FOREIGN KEY (`CRIDX`) REFERENCES `CARRY` (`CRIDX`),
  CONSTRAINT `FK_MEMBER_TO_CHATLIST` FOREIGN KEY (`MEMIDX`) REFERENCES `MEMBER` (`MEMIDX`)
);



CREATE TABLE `CHATROOM` (
  `MESSAGEIDX` int NOT NULL AUTO_INCREMENT COMMENT '메세지 번호',
  `CHATIDX` int NOT NULL COMMENT '채팅방번호',
  `CHATCONTENT` mediumtext NOT NULL COMMENT '대화내용',
  `CHATDATE` timestamp NOT NULL COMMENT '대화시간',
  `CRIDX` int NOT NULL COMMENT '캐리번호',
  `MEMIDX` int NOT NULL COMMENT '회원번호',
  `CONTENTTYPE` INT DEFAULT 0 COMMENT '0=유저대화, 1=캐리대화',
  `CHATPOSITION` INT DEFAULT 0 COMMENT '0=방에서 안나감, 1=방에서나감',
  `CHATREAD` INT DEFAULT 0 COMMENT '0=읽지않음, 1=읽음',
  PRIMARY KEY (`MESSAGEIDX`),
  KEY `FK_CARRY_TO_CHATROOM` (`CRIDX`),
  KEY `FK_MEMBER_TO_CHATROOM` (`MEMIDX`),
  KEY `FK_CHATLIST_TO_CHATROOM` (`CHATIDX`),
  CONSTRAINT `FK_CARRY_TO_CHATROOM` FOREIGN KEY (`CRIDX`) REFERENCES `CARRY` (`CRIDX`),
  CONSTRAINT `FK_CHATLIST_TO_CHATROOM` FOREIGN KEY (`CHATIDX`) REFERENCES `CHATLIST` (`CHATIDX`),
  CONSTRAINT `FK_MEMBER_TO_CHATROOM` FOREIGN KEY (`MEMIDX`) REFERENCES `MEMBER` (`MEMIDX`)
);


CREATE TABLE `LIKELIST` (
  `LIKEIDX` int NOT NULL AUTO_INCREMENT COMMENT '좋아요IDX',
  `MEMIDX` int DEFAULT NULL COMMENT '회원번호',
  `CRIDX` int DEFAULT NULL COMMENT '캐리IDX',
  `LIKECHECK` tinyint(1) DEFAULT NULL COMMENT '좋아요체크',
  PRIMARY KEY (`LIKEIDX`),
  KEY `FK_MEMBER_TO_LIKELIST` (`MEMIDX`),
  KEY `FK_CARRY_TO_LIKELIST` (`CRIDX`),
  CONSTRAINT `FK_CARRY_TO_LIKELIST` FOREIGN KEY (`CRIDX`) REFERENCES `CARRY` (`CRIDX`),
  CONSTRAINT `FK_MEMBER_TO_LIKELIST` FOREIGN KEY (`MEMIDX`) REFERENCES `MEMBER` (`MEMIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='찜한리스트';





-- 추후 테이블 추가 예정(결제 테이블)

-- CREATE TABLE `PAYMENT` (
--   `PAYIDX` int NOT NULL AUTO_INCREMENT COMMENT '결제번호',
--   `PAYPRICE` int NOT NULL COMMENT '결제금액',
--   `PAYDATE` timestamp NOT NULL COMMENT '결제날짜',
--   `MEMIDX` int NOT NULL COMMENT '회원번호',
--   `PAYNAME` varchar(10) NOT NULL COMMENT '결제자명',
--   `PAYPHONE` varchar(20) NOT NULL COMMENT '결제자연락처',
--   PRIMARY KEY (`PAYIDX`),
--   KEY `FK_MEMBER_TO_PAYMENT` (`MEMIDX`),
--   CONSTRAINT `FK_MEMBER_TO_PAYMENT` FOREIGN KEY (`MEMIDX`) REFERENCES `MEMBER` (`MEMIDX`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='결제';


