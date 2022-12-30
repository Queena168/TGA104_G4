package com.tibame.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;

import com.tibame.member.model.MemberVO;

@Order(value = 2)
@WebFilter(filterName = "MemberLoginFilter", urlPatterns = {"/"})
public class MemberLoginFilter extends HttpFilter implements Filter {
       
    
    private static final long serialVersionUID = 1L;
	private FilterConfig config;
    
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// 取得session
		HttpSession session = req.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		
		if(memberVO == null) {
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect("/front-end/member/login.jsp");
		}else {
			chain.doFilter(request, response);
		}
	}



}
