<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>GYM CARRY : 캐리 정보 수정</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

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

            <form action="<c:url value="/mypage/update"/>" method="post" enctype="multipart/form-data">
                <!--캐리 프로필 영역-->
                <h1 class="sub_tit_txt">캐리 정보 수정</h1>
                <div class="edit_form">

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
                                    <textarea class="crintro" id="introduce" type="text" name="crintro" required>
                                        <c:out value="${carry.crintro}" />
                                    </textarea>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <th><span>소속플레이스</span></th>
                            <td>
                                <div class="place">
                                    <input type="text" placeholder="" name="crplace" ${carry.crplace} required>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th><span>종목</span></th>
                            <div class="selectbox">
                                <td>
                                    <div class="selectbox">
                                    	<label for="health">헬스 
                                        	<input type="radio" value="헬스" id="health" name="crfield">
                                        </label>
										<label for="pilates">필라테스 
                                       		<input type="radio" name="crfield" value="필라테스" id="pilates">
                                        </label>
                                        <label for="yoga">요가 
                                      		<input type="radio" name="crfield" value="요가" id="yoga">
                                        </label>
                                    </div>
                                </td>
                            </div>

                        </tr>

                        <tr>
                            <th><span>전문 분야</span></th>
                            <td>
                                <div class="selectbox">
                                	<label for="diet">다이어트 
                                    	<input type="radio" value="다이어트" id="diet" name="crdepart">
                                  	</label>
									<label for="dump">근력강화 
                                    	<input type="radio" value="근력강화" id="dump" name="crdepart">
                                    </label>
 									<label for="weight_gain"> 체중증가 
                                    	<input type="radio" value="체중증가" id="weight_gain" name="crdepart">
                                   	</label>
									<label for="bodyfix"> 체형교정 
                                    	<input type="radio" value="체형교정" id="bodyfix" name="crdepart">
                                    </label>
									<label for="rehabilitation"> 재활/통증케어
                                    	<input type="radio" value="재활/통증케어" id="rehabilitation" name="crdepart">
                                    </label>
									<label for="body_profile"> 바디프로필 
                                    	<input type="radio" value="바디프로필" id="body_profile" name="crdepart">
                                    </label>
									<label for="competition"> 대회준비 
                                    	<input type="radio" value="대회준비" id="competition" name="crdepart">
                                    </label>
									<label for="etc"> 기타 
                                    	<input type="radio" value="기타" id="etc" name="crdepart">
                                    </label>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <th><span>PT 이용금액 </span></th>
                            <td>
                                <input type="text" placeholder="1회 금액 (숫자만 입력해주세요)" name="proprice1" required>
                                <input type="text" placeholder="5회 금액 (숫자만 입력해주세요)" name="proprice2" required>
                                <input type="text" placeholder="10회 금액 (숫자만 입력해주세요)" name="proprice3" required>
                                <input type="text" placeholder="20회 금액 (숫자만 입력해주세요)" name="proprice4" required>
                            </td>
                        </tr>

                        <tr>
                            <th><span>자격 및 경력<br>
                                <p>(최대 5개까지 입력 가능합니다)</p></span>
                            </th>
                            <td><input type="text" placeholder="자격 및 경력1" name="crcerti1" value="${carryCerti.crcerti1}">
                                <input type="text" placeholder="자격 및 경력2" name="crcerti2" value="${carryCerti.crcerti2}">
                                <input type="text" placeholder="자격 및 경력3" name="crcerti3" value="${carryCerti.crcerti3}">
                                <input type="text" placeholder="자격 및 경력4" name="crcerti4" value="${carryCerti.crcerti4}">
                                <input type="text" placeholder="자격 및 경력5" name="crcerti5" value="${carryCerti.crcerti5}">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="crbfphoto">바디프로필 업로드</label>
                            </th>
                            <td>
                                <input type="file" value="사진업로드" class="profilebtn" name="crbfphoto" id="crbfphoto" onclick=document.all.file.click(); >
                            </td>
                        </tr>
                        </tbody>
                        <input type="hidden" name="cridx" id="cridx" value="${cridx}">
                        <input type="hidden" name="oldcrbfphoto" value="${crbfphoto}">

                    </table>

                    <div class="bodyprofile_photo">
                        <img src="<c:url value="/uploadfile/${carry.crbfphoto}"/>">
                    </div>
                    <div class="select_img"><img src="" /></div>

                        <script>
                            function readInputFile(input) {
                                if (input.files && input.files[0]) {
                                    var reader = new FileReader;
                                    reader.onload = function (data) {
                                        $(".profilebtn").html("<img src=" + data.target.result + ">");
                                    }
                                    reader.readAsDataURL(this.files[0]);
                                }
                            }

                            $(".profilebtn").on('change', function(){
                                readInputFile(this);
                            });
                        </script>


                    </div>
                <div class="btn_wrap2">
                <input class="btn_update" type="submit" value="수정">
                </div>
                <div class="btn_wrap2">
                    <a href="javascript:window.history.back();">취소</a>
                </div>
            </form>
        </div>


    </div>
</div>
<!-- form_txtInput E -->
</body>
<!-- content E-->

<!-- footer -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>