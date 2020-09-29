package com.yiiqng.ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.userdao.*;
import com.yiqing.users.*;
import com.google.gson.Gson;
import java.util.*;
/**
 * Servlet implementation class lianxi33
 */
@WebServlet("/lianxi33")
public class lianxi33 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lianxi33() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		userdao userdao=new userdao();
		String Province = request.getParameter("City");
		
		System.out.println(Province);
		System.out.println("wen");
		
		ArrayList<info1> list = userdao.findcit(Province);
		for(info1 data:list)
		{
			System.out.println(data.getCity()+data.getDead_num());
			
		}
        Gson gson = new Gson();
        String json = gson.toJson(list);
        
        response.getWriter().write(json);
	}

}
