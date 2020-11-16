package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//�α��� ���� �˻� ���ͼ��� 
// /loginCheck/**  ��ٱ���, ����������, ��ٱ��Ͽ��� ����, ���� ��������, �ֹ� �� ȸ������ �޴����� �� ����
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" ====== preHandle ���� ====== ");
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			response.sendRedirect("../loginForm"); // servlet-context.xml ���� ��ϵ� loginForm.jsp �� �̵�
			return false; // �� �� �۾����� ���� ����.
		} else {
			return true; // �α��� ������ �ִ� ��� ���� �۾� ��� ����
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(" ====== postHandle ���� ====== ");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(" ====== afterCompletion ���� ====== ");
	}


}
