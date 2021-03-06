<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:if test="${empty login}">
	<!-- 로그인 키안에 있는 값 확인 -->
	<a href="loginForm">로그인</a>&nbsp;
	<a href="loginCheck/CartList">장바구니</a>&nbsp;<!-- 비회원상태이므로 loginCheck 인터셉터에 따라 로그인폼으로 이동하게 된다. -->
	<a href="memberForm">회원가입</a>&nbsp; <!-- xml에 등록된 주소를 찾아간다.  -->
</c:if>


<c:if test="${! empty login}"><!-- 로그인 된 경우 -->
	안녕하세요${login.username}님!<br><!-- key값 . 멤버변수 -->
	<a href="loginCheck/logout">로그아웃</a>&nbsp;<!-- LoginController로 이동 -->
	<a href="loginCheck/myPage">mypage</a>&nbsp;
	<a href="loginCheck/cartList">장바구니</a>&nbsp;
</c:if>











