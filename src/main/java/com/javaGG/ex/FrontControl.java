package com.javaGG.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")  /** 어노케이션 "/FrontControl"->"*.do"로변경 */
//확장자 패턴으로 매핑->모든 클라인언트 요청이 FrontControl로 집중됨

public class FrontControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public FrontControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	/** 액션두 라는 메서드를 만들어서 */
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("불러왓니?");
		
		String uri1 = request.getRequestURI();
		System.out.println(uri1);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String command = uri1.substring(conPath.length());
		
		if(command.equals("/insert.do")) {
			System.out.println("insert 호출");
		} else if(command.equals("/delete.do")) {
			System.out.println("delete 호출");
		} else if(command.equals("/update.do")) {
			System.out.println("update 호출");
		}
	}
}