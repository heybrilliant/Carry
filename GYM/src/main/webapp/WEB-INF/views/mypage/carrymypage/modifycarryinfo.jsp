<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>GYM CARRY : 캐리 정보 수정</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

<link rel="stylesheet" href="/gym/css/mypage/style.css">
<link rel="stylesheet" href="/gym/css/mypage/modify.css">

<title>캐리 정보 수정</title>

</head>
<body>
<!-- header -->
<%@ include file="/WEB-INF/views/frame/header.jsp" %>

<!-- content S-->
<div class="wrap">
    <div class="container">
        <div class="form_txtInput">

            <form action="<c:url value="/mypage/update"/>" method="post">
                <!--캐리 프로필 영역-->
                <h1 class="sub_tit_txt">캐리 정보 수정</h1>
                <div class="edit_form">
               <%--     <div class="profile_form">
                        <img src="<c:url value="/images/icon/profile2.png"/>" alt="img">
                        <a href="<input type=" onclick="" name="carryphoto">프로필 사진 등록</a>
                    </div>--%>

                    <table>
                        <colgroup>
                            <col width="30%"/>
                            <col width="auto"/>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th><span>캐리 소개</span></th>
                            <td>
                                <form>
                                    <input id="introduce" type="text" name="crintro">
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <th><span>소속플레이스</span></th>
                            <td>
                                <div class="place">
                                  <%--  <button type="submit">
                                        <a href="#"><img src="<c:url value="/images/icon/search_icon.png"/>" alt="img"></a>
                                    </button>--%>
                                    <input type="text" placeholder="" name="crplace">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th><span>종목</span></th>
                            <div class="selectbox">
                                <td>
                                    <div class="selectbox">
                                        <input type="radio" value="헬스" id="health" name="crfield">
                                        <label
                                                for="health">헬스
                                        </label>
                                        <input type="radio" name="crfield"
                                               value="필라테스" id="pilates">
                                        <label
                                                for="pilates">필라테스
                                        </label>
                                        <input type="radio" name="crfield" value="요가" id="yoga">
                                        <label
                                                for="yoga">요가
                                        </label>
                                    </div>
                                </td>
                            </div>

                        </tr>

                        <%--<tr>
                            <th><span>전문 분야<br>
											<p>(중복선택 가능)</p>
									</span></th>
                            <td>
                                <div class="selectbox">
                                    <input type="checkbox" value="다이어트" id="diet">
                                    <label
                                            for="diet"> 다이어트
                                    </label>
                                    <input type="checkbox"
                                           value="근력강화" id="diet">
                                    <label for="dump">
                                        근력강화 </label>
                                    <input type="checkbox" value="체중증가" id="diet">
                                    <label
                                            for="diet"> 체중증가
                                    </label>
                                    <input type="checkbox"
                                           value="체형교정" id="diet">
                                    <label for="diet">
                                        체형교정
                                    </label>
                                    <input type="checkbox" value="재활/통증케어" id="diet">
                                    <label
                                            for="diet"> 재활/통증케어
                                    </label>
                                    <input type="checkbox"
                                           value="바디프로필" id="diet">
                                    <label for="diet">
                                        바디프로필
                                    </label>
                                    <input type="checkbox" value="대회준비" id="diet">
                                    <label
                                            for="diet"> 대회준비
                                    </label>
                                    <input type="checkbox" value="기타"
                                           id="diet">
                                    <label for="diet"> 기타
                                    </label>

                                    <!-- <input type="checkbox" value="다이어트">
                                다이어트 <input type="checkbox" value="근력 강화"> 근력
                                강화
                                <input type="checkbox" value="체중 증가"> 체중 증가 <input type="checkbox"
                                    value="체형 교정">
                                체형 교정
                                <input type="checkbox" value="재활/통증 케어">
                                재활/통증 케어 <input type="checkbox" value="바디프로필">
                                바디프로필 <input type="checkbox" value="대회 준비">
                                대회 준비 <input type="checkbox" value="기타"> 기타 -->
                                </div>
                            </td>
                        </tr>--%>

                        <tr>

                            <th><span>PT 이용금액 </span></th>
                            <td>

                                <input type="text" placeholder="1회 금액 (숫자만 입력해주세요)" name="proprice1">
                                <input type="text" placeholder="5회 금액 (숫자만 입력해주세요)" name="proprice2">
                                <input
                                        type="text" placeholder="10회 금액 (숫자만 입력해주세요)" name="proprice3">
                                <input
                                        type="text" placeholder="20회 금액 (숫자만 입력해주세요)" name="proprice4"></td>

                        </tr>

                        <tr>
                            <th><span>자격 및 경력<br>
											<p>(최대 5개까지 입력 가능합니다)</p>
									</span></th>
                            <td><input type="text" placeholder="자격 및 경력1" name="crcerti1">
                                <input
                                        type="text" placeholder="자격 및 경력2" name="crcerti2">
                                <input type="text"
                                       placeholder="자격 및 경력3" name="crcerti3">
                                <input
                                        type="text"
                                        placeholder="자격 및 경력4" name="crcerti4">
                                <input type="text"
                                       placeholder="자격 및 경력5" name="crcerti5"></td>
                        </tr>
                        <tr>
                            <th><span>바디프로필 업로드</span></th>
                            <td><input type="file" id="userphoto" value="업로드">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <input type="submit" value="수정">
            </form>
        </div>




        </div>
    </div>
    <!-- form_txtInput E -->
</div>
<!-- content E-->

<!-- footer -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>