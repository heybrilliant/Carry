<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Community</title>


<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>

<link href="${pageContext.request.contextPath}/css/community/community.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/community/bootstrap.css" rel="stylesheet" />


<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
  $(function(){
    $.ajax({
      type:'POST',
      url:'<c:url value="/community/boardlist"/>',
      success:function(result)
      {
        let json=JSON.parse(result);
        let res="";
        for(let i=0;i<json.length;i++)
        {
          res+="<tr>"
                  +"<td>"
                  +"<img src=http://www.kobis.or.kr"+json[i].thumbUrl+" width=30 height=30>"
                  +"</td>"
                  +"<td>"+json[i].movieNm+"</td>"
                  +"<td>"+json[i].director+"</td>"
                  +"<td>"+json[i].genre+"</td>"
                  +"<td>"+json[i].watchGradeNm+"</td></tr>";
        }
        $('#movie_list').html(res);
      }
    });

    $('span').click(function(){
      let no=$(this).attr("value");
      $.ajax({
        type:'POST',
        url:'movie_data.do',
        data:{"no":no},
        success:function(result)
        {
          let json=JSON.parse(result);
          let res="";
          for(let i=0;i<json.length;i++)
          {
            res+="<tr>"
                    +"<td>"
                    +"<img src=http://www.kobis.or.kr"+json[i].thumbUrl+" width=30 height=30>"
                    +"</td>"
                    +"<td>"+json[i].movieNm+"</td>"
                    +"<td>"+json[i].director+"</td>"
                    +"<td>"+json[i].genre+"</td>"
                    +"<td>"+json[i].watchGradeNm+"</td></tr>";
          }
          $('#movie_list').html(res);
        }
      });
    });
  })
</script>

</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	<!-- Contents -->
  <div class="contents_main">
    <div class="contents">
      <h1 class="title">
        <a href="<c:url value="/community/boardlist"/>">COMMUNITY</a>
      </h1>
      <nav class="community_nav">
        <ul>
          <li>
            <a href="<c:url value="/community/boardlist"/>">전체</a>
          </li>
          <li>
            <a class="menulink2" href="#">소통</a>
          </li>
          <li>
            <a class="menulink3" href="#">질문답변</a>
          </li>

          <a class="board_write" href="<c:url value="/community/write"/>">
            <img class="write_icon" img src="<c:url value="/images/icon/edit.png"/>" alt="img"></a>

          <!-- 정렬을 위해 왼쪽에 버튼 숨겨놓은 것 -->
          <button class="board_write2" type="button" onclick="">
            <img class="write_icon" src="/gym/images/icon/edit.png"></button>
        </ul>
      </nav>


      <div class="card_main">
        <c:forEach items="${boardList}" var="list">
        <div class="card">
          <div class="board_sidebar">
						<img class="profile_image"
                             img src="<c:url value="/images/icon/profile2.png"/>" alt="img">
						<div class="nickname">${list.postnick}</div>

          </div>
          <div class="board_main">
            <button class="title_btn" type="button" onclick="">${list.boardcategory}</button>
            <h2 class="board_title">
              <a href="<c:url value="/community/postContent"/>">${list.postname}</a>
            </h2>
            <p class="board_post">
              <a href="<c:url value="/community/postContent"/>">
                ${list.postcontent}</a>
            </p>
          <%--날짜, 조회수--%>
            <div class="board_bottom">
              <div class="write_date">

                  <li>
                    <img class="left_board_icon" img src="<c:url value="/images/icon/time.png"/>" alt="img">
                      <%--시간 데이터 포맷 변경--%>
                    <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.postdate}"/>
                  </li>
                  <li>
                    <img class="left_board_icon2"
                         img src="<c:url value="/images/icon/board.png"/>" alt="img">
                        ${list.postview}
                  </li>
              </div>
              <ul class="board_btn">

                <li>
                  <a href="#">
                    <img class="board_icon" img src="<c:url value="/images/icon/heart.png"/>" alt="img">2
                  </a>
                </li>
                <li>
                  <a href="#"><img class="board_icon" img src="<c:url value="/images/icon/speech-bubble.png"/>" alt="img">15</a>
                </li>
              </ul>
            </div>

          </div>


        </div>
        </c:forEach>
      </div>
      <nav aria-label="Page navigation example">
        <ul class="pagination pagination-sm justify-content-center">
          <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item"><a class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>
    </div>

  </div>
 

  <!-- Contents end -->
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	

