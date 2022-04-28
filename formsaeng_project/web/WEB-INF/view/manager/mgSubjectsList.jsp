<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/SubjectsList.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 - 수강신청</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
    <script src="./resources/js/jquery-3.6.0.js"></script>
</head>
<body>
    <header>
        <div class="header_container">
            <div class="header_wrapper">
                <div class="univ_logo">
                    <a href="#"><img class="logo2" src="<%=request.getContextPath() %>/resources/images/fromsaenglogo.png" alt="폼생대로고"></a>
                    <a href="#"><img class="logo1" src="<%=request.getContextPath() %>/resources/images/name_logo.png" alt="폼생대학교"></a>
                </div>
                <div class="move_page_buttons">
                    <button class="btn btn-success" id="myPage">마이 페이지</button>
                    <button class="btn btn-success" id="move_lms">LMS 바로가기</button>
                </div>
            </div>
        </div>
    </header>
    <section id="subjects">
        <div class="content_title">
            <div class="title_name">
                <h2 class="font5">추가한 과목 목록</h2>
            </div>
            <div class="search">
                <select class="select_design font2" name="search" id="requirement">
                    <option class="option_design font2" value="dept">학과 검색</option>
                    <option class="option_design font2" value="name">과목 검색</option>
                    <option class="option_design font2" value="type">이수구분 검색</option>
                    <option class="option_design font2" value="grade">학년 검색</option>
                </select>
                <input type="text" class="form-control search_input" id="search_word" name="search_word" placeholder="검색어를 입력하세요">
                <button type="button" class="btn btn-secondary">검색</button>
            </div>  
        </div>
        <div class="subject_list_container">
            <table class="table">
                <thead>
                  <tr>
                    <th scope="col"><input type="checkbox" name="allCheck" id="all"></th>
                    <th scope="col">과목명</th>
                    <th scope="col">학점</th>
                    <th scope="col">과목 구분</th>
                    <th scope="col">담당 교수</th>
                    <th scope="col">강의실명</th>
                    <th scope="col">강의 교시</th>
                  </tr>
                </thead>
                <tbody>
                    <!-- TODO 스크립트릿,EL로 받아올 예정 -->
                  <tr>
                    <th scope="row"><input type="checkbox" name="checkRow" id="checkRow"></th>
                    <th scope="row">합주실기</th>
                    <td>3</td>
                    <td>전필</td>
                    <td>홍샛별</td>
                    <td>(폼)합주실307호</td>
                    <td>화:01,02,03,04</td>
                  </tr>
              </table>
        </div>
    </section>
</body>
</html>