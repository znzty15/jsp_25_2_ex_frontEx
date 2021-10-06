package com.javaGG.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControl
 */
@WebServlet("/*.do")//확장자 패턴으로 매핑 -> 모든 클라이언트 요청이 FrontControl로 집중됨
public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("Front Controller가 실행됨");
        
        String uri  = request.getRequestURI();
        //System.out.println(uri);
        String conpath = request.getContextPath();
        //System.out.println(conpath);
        String command = uri.substring(conpath.length());
        System.out.println(command);
        
        if(command.equals("/insert.do")) {
           System.out.println("insert command 호출");           
        }else if(command.equals("/delete.do")){
           System.out.println("delete command 호출");
        }else if(command.equals("/update.do")){
           System.out.println("update command 호출");
        }
     }
}
