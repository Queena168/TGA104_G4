package com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.VerifyCode;


@WebServlet("/ValiImgServlet")
public class ValiImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ValiImgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//禁止瀏覽器快取驗證碼
        response.setDateHeader("Expires",-1);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        //生成驗證碼
        VerifyCode vc = new VerifyCode();
        //輸出驗證碼
        vc.drawImage(response.getOutputStream());
        //獲取驗證碼的值，儲存到session中
        String valistr = vc.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("valistr",valistr);
        //列印到控制檯
        System.out.println("valistr:" + valistr);
	}

}
