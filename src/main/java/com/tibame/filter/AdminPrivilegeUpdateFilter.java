package com.tibame.filter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.admin.model.AdminVO;


@WebFilter("/AdminPrivilegeUpdateFilter")
public class AdminPrivilegeUpdateFilter implements Filter {
       
	private FilterConfig config;

	public void init(FilterConfig config) {
		this.config = config;
	}
	
    public void destroy() {
    	config = null;
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// 儲存錯誤訊息
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		
		// 取得session
		HttpSession session = req.getSession();
		// 從session判斷admin的權限是不是1，權限為1才能進到其他adimin的修改頁面
		AdminVO adminVO = (AdminVO) session.getAttribute("adminVO");
		//System.out.println("adminVO.getAdminPrivilege():  " + adminVO.getAdminPrivilege());
		String str = adminVO.getAdminPrivilege();
		
		if(!"1".equals(str)) {  // admin權限不為1時，不給進其他admin修改頁面
			errorMsgs.add("權限不足 無法修改");
//			res.sendRedirect(req.getContextPath() + "/back-end/admin/listAllAdmin.jsp");
			RequestDispatcher failureView = req.getRequestDispatcher("/back-end/admin/listAllAdmin.jsp");
			failureView.forward(request, response);
		}
		
		// pass the request along the filter chain, admin權限為1進入AdminServlet
		chain.doFilter(request, response);
	}




}
