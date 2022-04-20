<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
    crossorigin="anonymous"></script>
	<style>
	.logoimg{
		display: flex;
    	align-items: center;
	}
	.fromsaenglogo{
		width: 100px;
	}
	.logo{
		width: 100px;
	}
	
	.button{
	float:right;
	position: relative;
    right: 100px;
	}
	.mypage{
	background-color: rgb(22,160,134);
    border: none;
    color: white;
    text-align: center;
    font-size: 14px;
    padding: 10px;
    margin: 4px;
    width: 110px;
    }
    .lms{
    background-color: rgb(22,160,134);
    border: none;
    color: white;
    text-align: center;
    font-size: 14px;
    padding: 10px;
    margin: 4px;
    width: 110px;
    }
    
    .title{
    position: relative;
    left: 100px;
    }
    
    .notice_search{
	float:right;
	position: relative;
    right: 100px;
    }
    .sortation{
    height: 35px;
    width: 60px;
    }
    .search_input{
	width: 180px;
    height: 30px;
    }
    .search_button{
    padding: 4px;
    }
    .notice_list{
    text-align:center;
    border: 1px solid;
    margin: 0 0 0 100px;
    width: 183.5vh;
    height: 50vh;
    }
    .list_title{
    display:grid;
   	grid-template-columns: 300px 50px 100px;
	grid-template-rows: 200px 50px;
	

    }

    .add_delete{
	position: relative;
    left: 100px;
    }
    .notice_add{
    text-align: center;
    font-size: 14px;
    padding: 5px;
    margin: 10px 10px 0 0;
    }
    .notice_delete{
    text-align: center;
    font-size: 14px;
    padding: 5px;
    margin: 10px 10px 0 10px;
    }

    </style>
</head>

<body>
	<div class="logoimg">
		<img src="./resources/images/fromsaenglogo.png" class="fromsaenglogo">
		<img src="./resources/images/logo.png" class="logo">
	</div>
	
	<div class="button">
		<button class="mypage">마이페이지</button>
		<button class="lms">LMS바로가기</button>
	</div>
	
	<div>
		<h1 class="title">공지사항</h1>
	</div>
	
	<div class="notice_search">
		<select name="notice" class="sortation">
			<option value="제목">제목</option>
			<option value="내용">내용</option>
		</select>
		<input type="text" placeholder="공지사항 검색" class="search_input">
		<button class="search_button">검색</button>
	</div>
	<br><br><br>
	<div class="notice_list">
		<span>NO</span>
		<span>제목</span>
		<span>작성자</span>
		<span>작성일자</span>
	</div>
	
	<div class="add_delete">
		<button class="notice_add">공지사항 추가</button>
		<button class="notice_delete">공지사항 삭제</button>
	</div>


</body>
</html>