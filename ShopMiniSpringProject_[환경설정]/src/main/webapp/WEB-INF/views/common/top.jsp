<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- if,each ���� ����ϱ����� -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!-- el�±׿� jstl�±׸� ����ϸ�, �پ��� ��� ��밡�� -->

<!-- ��ȸ���޴� -->
<c:if test="${empty login }">
	<a href="LoginServlet">�α���</a>&nbsp;
<a href="CartListServlet">��ٱ���</a>&nbsp;
<a href="MemberUIServlet">ȸ������</a>&nbsp;
</c:if>

<!-- ȸ������޴�  -->
<c:if test="${!empty login }"><!-- ���ǿ��� �α��� ���� �˻��� �α��� �� ��� -->
	�ȳ��ϼ��� ? ${login.username }��! <br>
	<a href="LoginServlet">�α���</a>&nbsp;
	<a href="CartListServlet">��ٱ���</a>&nbsp;
	<a href="MemberUIServlet">ȸ������</a>&nbsp;
</c:if>