package com.yiiqng.ser;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userdao.userdao;
import com.yiqing.users.heibeicity;
import com.yiqing.users.info1;
import com.google.gson.Gson;
/**
 * Servlet implementation class lianxi2
 */
@WebServlet("/lianxi2")
public class lianxi2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lianxi2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/plain; charset=UTF-8");
			userdao userdao=new userdao();

			ArrayList<info1> info_list=userdao.findpro();
			
			

			HttpSession session = request.getSession();
			session.setAttribute("info_list",info_list);
			
			Gson gson = new Gson();
			
			String json = gson.toJson(info_list);
			
	
			response.getWriter().write(json);
	
	}

}
