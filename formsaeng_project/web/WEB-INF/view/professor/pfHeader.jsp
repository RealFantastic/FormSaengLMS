<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/sideDropdown.css">
<%@page import="kh.semi.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
  <header id="sideBar" style="z-index: 4;">
  <% MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMemberVo"); %>
    <div class="side_container">
      <a href="./semitest.html" id="logo"><img src="<%= request.getContextPath() %>/resources/images/fromsaenglogo.png" alt="폼생대로고"></a>
      <a href="./semitest.html" id="uni_name"><img src="<%= request.getContextPath() %>/resources/images/name_logo.png" alt="폼생대학교"></a>
      <hr>
      <ul class="list_button">
        <li>
          <a href="<%=request.getContextPath()%>/pf/DashBoard">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-grid-3x2-gap-fill" viewBox="0 0 16 16">
              <path d="M1 4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V4zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V4zM1 9a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V9zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V9zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V9z"/>
            </svg>
            Dashboard
          </a>
        </li>
        <li>
          <a href="<%=request.getContextPath()%>/pf/message">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
              <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
            </svg>
            Message
          </a>
        </li>
        <li class="menu-v2">
          <a class="a" id="sub_menu">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
              <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
            </svg>
            Subject
          </a>
          	<ul class="submenu" id="sub">
			</ul>
        </li>
        <li>
          <a href="<%=request.getContextPath()%>/pf/calendar"> 
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-calendar-week" viewBox="0 0 16 16">
              <path d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-5 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>
              <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
            </svg>
            Calendar
          </a>
        </li>
      </ul>
         <div class="dropdown">
      <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
        <strong><%=ssvo.getName() %> 님</strong>
      </a>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
        <li><a class="dropdown-item" style="padding-top:2px; margin-bottom:1px;" href="<%=request.getContextPath()%>/pf/mypage">마이페이지</a></li>
        <li><hr class="dropdown-divider" style="margin:1px;"></li>
        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/pflogout">로그아웃</a></li>
      </ul>
    </div>
  </div>
  <% MemberVo mvo = (MemberVo) request.getSession().getAttribute("ssMemberVo"); %>
  <% String id = mvo.getId(); %>
       <script>
  $(document).ready(function(){
	//menu v2 ho
	/* $(".menu-v2").mouseover(function(){ 
			$(this).children(".submenu").show();
		}); */
 		/* $(".menu-v2").mouseleave(function(){ 
			$(this).children(".submenu").hide(); 
		}); */
		$(".menu-v2").on("click",function(){
			if($(".submenu").css('display') == 'none'){
				$(this).children(".submenu").show();	
			}else{
				$(this).children(".submenu").hide();	
			}
		})
		
		$(".template_container").on("click",function(){
			if($(".submenu").css('display') == 'block'){
				  $(".submenu").hide();
			};	
		});
		$("#sub_menu").click(function(){
			openSubMenu();
		})
		
		
	});
  
  	function openSubMenu(){
  		$.ajax({
  			url:"<%=request.getContextPath()%>/subMenu.ax",
  			type:"get",
  			dataType:"json",
  			success:function(result){
  				console.log("컨트롤러가 어디냐");
  				console.log(result[0]);
  				var temp = '<%=id %>';
  				console.log(temp);
  				console.log(temp.charAt(0));
  				if(result == null){
  					alert("과목신청부터좀 하고 와라");
  				}else{
  					var html = "";
  					
  					// 링크에 로그인한 사람이 교수인지 학생인지에 따라 각각 다른 url을 부여해야함.
  					if(temp.charAt(0) =='P'){
  						for(var i = 0; i < result.length; i++){
  							console.log(result[i].subCode);
  							//TODO result[i].subCode 값을 a태그 쿼리스트링으로 대입
	  						html+= "<li><a href='<%= request.getContextPath() %>/pf/week?s=" + result[i].subCode +"&n="+ result[i].subName + "'>" + result[i].subName + "</a></li>";
  						}
  						$("#sub").empty();
  						$("#sub").append(html);
  					}else if(temp.charAt(0) == 'S'){
  						for(var i = 0; i < result.length; i++){
  							console.log(result[i].subCode);
	  						html+= "<li><a href='<%= request.getContextPath() %>/st/week?s=" + result[i].subCode +"&n="+ result[i].subName + "'>" + result[i].subName + "</a></li>";
  						}
  						$("#sub").empty();
  						$("#sub").append(html);
  						
  					}
  				}
  			}
  		})
  	}
  
  </script> 
  </header>