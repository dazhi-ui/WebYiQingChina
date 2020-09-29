package com.userdao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yiiqng.DBUtil.*;

import com.yiqing.users.*;

public class userdao 
{       
	//查看个人信息
		public static ArrayList<info1> findDate(String Date) 
		{
			// TODO Auto-generated method stub
			String sql = "select * from info4 ";
			ArrayList<info1> list =new ArrayList<info1>();
			Connection con=null;
			PreparedStatement psts=null;
			ResultSet rs=null;
				try  
				{
					con=DBUtil.getConn();
					psts=con.prepareStatement(sql);
					rs=psts.executeQuery();//记录返回的结果
					while(rs.next())
					{
						info1 user1=new info1();
						user1.setProvince(rs.getString("Province"));
						user1.setConfirmed_num(rs.getString("Confirmed_num"));
						user1.setCured_num(rs.getString("Cured_num"));
						user1.setDead_num(rs.getString("Dead_num"));
						user1.setCity(rs.getString("City"));
						user1.setDate(rs.getString("Date"));
						list.add(user1);
					}
					
					DBUtil.close(rs, psts, con);
					return list;
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} 
			return list;
		}
	
		//查看个人信息where Date ='%" + Date + "%'
				public static ArrayList<info1> find() 
				{
					// TODO Auto-generated method stub
					String sql = "select * from info3";
					ArrayList<info1> list =new ArrayList<info1>();
					Connection con=null;
					PreparedStatement psts=null;
					int flag=0;
					ResultSet rs=null;
						try  
						{
							con=DBUtil.getConn();
							psts=con.prepareStatement(sql);
							rs=psts.executeQuery();//记录返回的结果
							while(rs.next())
							{
								info1 user1=new info1();
								user1.setProvince(rs.getString("Province"));
								user1.setConfirmed_num(rs.getString("Confirmed_num"));
								user1.setCured_num(rs.getString("Cured_num"));
								user1.setDead_num(rs.getString("Dead_num"));
								user1.setCity(rs.getString("City"));
								user1.setDate(rs.getString("Date"));
								list.add(user1);
								if((rs.getString("Province")).equals("西藏自治区")){
									flag=1;
								}
								if(flag==1)
									break;
							}
							
							DBUtil.close(rs, psts, con);
							return list;
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} 
					return list;
				}
			///////////////////////////////////////////////shengshengehnsg
				public static ArrayList<info1> findpro() 
				{
					// TODO Auto-generated method stub
					String sql = "select * from info4";
					ArrayList<info1> list =new ArrayList<info1>();
					Connection con=null;
					PreparedStatement psts=null;
					int flag=0;
					ResultSet rs=null;
						try  
						{
							con=DBUtil.getConn();
							psts=con.prepareStatement(sql);
							rs=psts.executeQuery();//记录返回的结果
							while(rs.next())
							{
								info1 user1=new info1();
								user1.setProvince(rs.getString("Province"));
								user1.setConfirmed_num(rs.getString("Confirmed_num"));
								user1.setCured_num(rs.getString("Cured_num"));
								user1.setDead_num(rs.getString("Dead_num"));
								user1.setCity(rs.getString("City"));
								user1.setDate(rs.getString("Date"));
								user1.setYisi_num(rs.getString("Yisi_num"));
								list.add(user1);
							
							}
							
							DBUtil.close(rs, psts, con);
							return list;
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} 
					return list;
				}
				
			
				public static ArrayList<info1> findcit(String Province) 
				{
					// TODO Auto-generated method stub
					String sql = "select * from info3 where Province ='" +Province+ "'";
					ArrayList<info1> list =new ArrayList<info1>();
					Connection con=null;
					PreparedStatement psts=null;
					ResultSet rs=null;
						try  
						{
							con=DBUtil.getConn();
							psts=con.prepareStatement(sql);
							rs=psts.executeQuery();//记录返回的结果
							while(rs.next())
							{
								info1 user1=new info1();
								user1.setProvince(rs.getString("Province"));
								user1.setConfirmed_num(rs.getString("Confirmed_num"));
								user1.setCured_num(rs.getString("Cured_num"));
								user1.setDead_num(rs.getString("Dead_num"));
								user1.setCity(rs.getString("City"));
								user1.setDate(rs.getString("Date"));
								user1.setYisi_num(rs.getString("Yisi_num"));
								list.add(user1);
							}
							
							DBUtil.close(rs, psts, con);
							return list;
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} 
					return list;
				}
	
	
	
	
	
	
	
	
	
	
	
/*
	//登录窗口的密码账号的检测判断
	public boolean checkuser(String username,String password,String role) {
		// TODO Auto-generated method stub
		String sql;
	
			sql = "select * from user where ";
			sql += "username = '" + username + "'and role = '"+role+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		String password2 = "@";
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				password2 = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		Boolean wen=false;
		if(password2.equals(password))
			wen=true;
		return wen;
	}
	//查看个人信息
	public static ArrayList<user> lookmessage(String username) 
	{
		// TODO Auto-generated method stub
		String sql = "select * from user where username ='" +username+ "'";
		ArrayList<user> list =new ArrayList<user>();
		Connection con=null;
		PreparedStatement psts=null;
		ResultSet rs=null;
			try 
			{
				con=DBUtil.getConn();
				psts=con.prepareStatement(sql);
				rs=psts.executeQuery();//记录返回的结果
				while(rs.next())
				{
					user user1=new user();
					user1.setUsername(rs.getString("username"));
					user1.setPassword(rs.getString("password"));
					user1.setBianhao(rs.getString("bianhao"));
					user1.setBirth(rs.getString("birth"));
					user1.setRole(rs.getString("role"));
					user1.setSex(rs.getString("sex"));
					user1.setId(rs.getInt("id"));
					list.add(user1);
				}
				
				DBUtil.close(rs, psts, con);
				return list;
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
		return list;
	}
	//显示个人修改信息使用
	public user getmessagebyid(int id) {
		String sql = "select * from user where id ='" +id+ "'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			user user1=new user();
			if(rs.next())
			{
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("password"));
				user1.setBianhao(rs.getString("bianhao"));
				user1.setBirth(rs.getString("birth"));
				user1.setRole(rs.getString("role"));
				user1.setSex(rs.getString("sex"));
				user1.setId(rs.getInt("id"));
			}
			return user1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return null;
	}
	
	//更新用户信息
	public boolean theupdata(int id,user user1) 
	{
		String sql="update user set username='" + user1.getUsername() + "', password='" + user1.getPassword() + "', birth='" + user1.getBirth() + "', sex='" + user1.getSex() + "', bianhao='" + user1.getBianhao() + "'where id='" +id + "'";
		 Connection conn = DBUtil.getConn();
	        Statement state = null;
	        int a=0;
	        try {
	            state = conn.createStatement();
	            a = state.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(state, conn);
	        }
	        if(a>0)
	        	return true;
	        return false;
	}
	//更改密码
	public boolean updatapassword(String username ,String  password) 
	{
		String sql="update user set password='" + password + "'where username='" +username + "'";
		 Connection conn = DBUtil.getConn();
	        Statement state = null;
	        int a=0;
	        try {
	            state = conn.createStatement();
	            a = state.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.close(state, conn);
	        }
	        if(a>0)
	        	return true;
	        return false;
	}
	//查找用户id
	public int findid(String username) {
		// TODO Auto-generated method stub
		String sql;
	
			sql = "select * from user where ";
			sql += "username = '" + username + "'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		int id=0;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				id =rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		
		return id;
	}
	
	//增加课程
	public boolean addclass(int teacherid,String classkind,int number)
	 {
			
			String sql = "insert into classtea(teacherid,classkind,number)"
					+ "values('"  + teacherid + "','" + classkind+ "','"  + number + "')";
			Connection conn = DBUtil.getConn();//调用方法连接数据库
			Statement state = null;//创建一个Statement对象来执行静态的SQL语句
			//Statement用于在已经建立数据库连接上发送静态的SQL语句
			boolean f = false;
			int a = 0 ;
			
			try {       //监视大括号内的代码
				state = conn.createStatement();//上面的是详解
				a = state.executeUpdate(sql);
				//执行指定的更新类的SQl语句，并返回操作结果的整型值
			} catch (Exception e) {     //捕获错误
				e.printStackTrace();
			} finally {
				//关闭z	连接
				DBUtil.close(state, conn);
			}
			
			if (a > 0) {
				f = true;
			}
			return f;
		}
	
	
	//查看老师课程
		public static ArrayList<classtea> searchclass(int teacherid) 
		{
			// TODO Auto-generated method stub
			String sql = "select * from classtea where teacherid ='" +teacherid+ "'";
			ArrayList<classtea> list =new ArrayList<classtea>();
			Connection con=null;
			PreparedStatement psts=null;
			ResultSet rs=null;
				try 
				{
					con=DBUtil.getConn();
					psts=con.prepareStatement(sql);
					rs=psts.executeQuery();//记录返回的结果
					while(rs.next())
					{
						classtea user1=new classtea();
						user1.setNumber(rs.getInt("number"));
						user1.setClasskind(rs.getString("classkind"));
						user1.setId(rs.getInt("id"));
						list.add(user1);
					}
					DBUtil.close(rs, psts, con);
					return list;
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} 
			return list;
		}
	
	//删除课程
		public boolean deleteclass (int id) {
		     boolean f = false;
			 String sql = "delete from classtea where id='" + id + "'";
			 Connection conn = DBUtil.getConn();
			 Statement state = null;
			 int a = 0;      
			 try {
			  state = conn.createStatement();
			  a = state.executeUpdate(sql);
			      } catch (SQLException e) {
			             e.printStackTrace();
			      }
			      finally {
			      DBUtil.close(state, conn);
			     }
			        
			       if (a > 0) {
			             f = true;
			         }
			         return f;
			    } 
		//更改课程名字
		public boolean updataclassname(int  id ,String  classkind) 
		{
			String sql="update classtea set classkind='" + classkind + "'where id='" +id + "'";
			 Connection conn = DBUtil.getConn();
		        Statement state = null;
		        int a=0;
		        try {
		            state = conn.createStatement();
		            a = state.executeUpdate(sql);
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            DBUtil.close(state, conn);
		        }
		        if(a>0)
		        	return true;
		        return false;
		}
	//得到课程对应的老师
		public int getteaid(int id) {
			// TODO Auto-generated method stub
			String sql;
		
				sql = "select * from classtea where ";
				sql += "id = '" + id + "'";
			Connection conn = DBUtil.getConn();
			Statement state = null;
			ResultSet rs = null;
			int  teacherid = 0;
			try {
				state = conn.createStatement();
				rs = state.executeQuery(sql);
				while (rs.next()) {
					teacherid = rs.getInt("teacherid");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(rs, state, conn);
			}
			return teacherid;
		}
	
	//显示名单
		public static ArrayList<classnow> searchstd(int teacherid,int classkindid) 
		{
			// TODO Auto-generated method stub
			String sql = "select * from classnow where teacherid ='" +teacherid+ "'and classkindid='"+classkindid+"'";
			ArrayList<classnow> list =new ArrayList<classnow>();
			Connection con=null;
			PreparedStatement psts=null;
			ResultSet rs=null;
				try 
				{
					con=DBUtil.getConn();
					psts=con.prepareStatement(sql);
					rs=psts.executeQuery();//记录返回的结果
					while(rs.next())
					{
						classnow user1=new classnow();
						user1.setStudentid(rs.getInt("studentid"));
						user1.setClasskindid(rs.getInt("classkindid"));
						user1.setTeacherid(rs.getInt("teacherid"));
						user1.setId(rs.getInt("id"));
						list.add(user1);
					}
					DBUtil.close(rs, psts, con);
					return list;
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} 
			return list;
		}
		


//找到名字系列
	public String findusername(int id) {
		// TODO Auto-generated method stub
		String sql;
	
			sql = "select * from user where ";
			sql += "id = '" + id + "'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		String username = "@";
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return username;
	}
	public String findclassname(int id) {
		// TODO Auto-generated method stub
		String sql;
	
			sql = "select * from classtea where ";
			sql += "id = '" + id + "'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		String classkind = "@";
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				classkind = rs.getString("classkind");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return classkind;
	}
//学生选课
	public static ArrayList<classtea> stucheckclass() 
	{
		// TODO Auto-generated method stub
		String sql = "select * from classnow ";
		ArrayList<classtea> list =new ArrayList<classtea>();
		Connection con=null;
		PreparedStatement psts=null;
		ResultSet rs=null;
			try 
			{
				con=DBUtil.getConn();
				psts=con.prepareStatement(sql);
				rs=psts.executeQuery();//记录返回的结果
				while(rs.next())
				{
					classtea user1=new classtea();
					user1.setId(rs.getInt("id"));
					user1.setTeacherid(rs.getInt("teacherid"));
					user1.setClasskind(rs.getString("classkind"));
					user1.setNumber(rs.getInt("number"));
					list.add(user1);
				}
				DBUtil.close(rs, psts, con);
				return list;
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
		return list;
	}
	
//增加学生选课
	public void addstdclass(int teacherid,int studentid,int classkindid)
	 {	
			String sql = "insert into classnow(teacherid,studentid,classkindid)"
					+ "values('"  + teacherid + "','" + studentid+ "','"  + classkindid + "')";
			Connection conn = DBUtil.getConn();//调用方法连接数据库
			Statement state = null;//创建一个Statement对象来执行静态的SQL语句
			//Statement用于在已经建立数据库连接上发送静态的SQL语句
			boolean f = false;
			int a = 0 ;
			
			try {       //监视大括号内的代码
				state = conn.createStatement();//上面的是详解
				a = state.executeUpdate(sql);
				//执行指定的更新类的SQl语句，并返回操作结果的整型值
			} catch (Exception e) {     //捕获错误
				e.printStackTrace();
			} finally {
				//关闭z	连接
				DBUtil.close(state, conn);
			}
		}
	
	//显示学生已选课
		public static ArrayList<classnow> lookstdclass(int studentid) 
		{
			// TODO Auto-generated method stub
			String sql = "select * from classnow where studentid='"+studentid+"'";
			ArrayList<classnow> list =new ArrayList<classnow>();
			Connection con=null;
			PreparedStatement psts=null;
			ResultSet rs=null;
				try 
				{
					con=DBUtil.getConn();
					psts=con.prepareStatement(sql);
					rs=psts.executeQuery();//记录返回的结果
					while(rs.next())
					{
						classnow user1=new classnow();
						user1.setId(rs.getInt("id"));
						user1.setTeacherid(rs.getInt("teacherid"));
						user1.setClasskindid(rs.getInt("classkindid"));
						user1.setStudentid(rs.getInt("studentid"));
						list.add(user1);
					}
					DBUtil.close(rs, psts, con);
					return list;
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} 
			return list;
		}
		//增加用户
		public boolean addnewuser(user user1)
		 {
				
				String sql = "insert into user(username,password,sex,role,birth,bianhao)"
						+ "values('"  + user1.getUsername() + "','" + user1.getPassword()+ "','"  + user1.getSex() + "','"  + user1.getRole() + "','" + user1.getBirth()+ "','"  + user1.getBianhao() + "')";
				Connection conn = DBUtil.getConn();//调用方法连接数据库
				Statement state = null;//创建一个Statement对象来执行静态的SQL语句
				//Statement用于在已经建立数据库连接上发送静态的SQL语句
				boolean f = false;
				int a = 0 ;
				
				try {       //监视大括号内的代码
					state = conn.createStatement();//上面的是详解
					a = state.executeUpdate(sql);
					//执行指定的更新类的SQl语句，并返回操作结果的整型值
				} catch (Exception e) {     //捕获错误
					e.printStackTrace();
				} finally {
					//关闭z	连接
					DBUtil.close(state, conn);
				}
				
				if (a > 0) {
					f = true;
				}
				return f;
			}
		//全部用户信息
		public static ArrayList<user> showalluser() 
		{
			// TODO Auto-generated method stub
			String sql = "select * from user ";
			ArrayList<user> list =new ArrayList<user>();
			Connection con=null;
			PreparedStatement psts=null;
			ResultSet rs=null;
				try 
				{
					con=DBUtil.getConn();
					psts=con.prepareStatement(sql);
					rs=psts.executeQuery();//记录返回的结果
					while(rs.next())
					{
						user user1=new user();
						user1.setId(rs.getInt("id"));
						user1.setUsername(rs.getString("username"));
						user1.setPassword(rs.getString("password"));
						user1.setBianhao(rs.getString("bianhao"));
						user1.setBirth(rs.getString("birth"));
						user1.setRole(rs.getString("role"));
						user1.setSex(rs.getString("sex"));
						list.add(user1);
					}
					DBUtil.close(rs, psts, con);
					return list;
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} 
			return list;
		}
		//管理员更新用户信息
		public boolean theupdataadmit(int id,user user1) 
		{
			String sql="update user set username='" + user1.getUsername() + "', password='" + user1.getPassword() + "', birth='" + user1.getBirth() + "', sex='" + user1.getSex() + "', bianhao='" + user1.getBianhao() + "', role='" + user1.getRole() + "'where id='" +id + "'";
			 Connection conn = DBUtil.getConn();
		        Statement state = null;
		        int a=0;
		        try {
		            state = conn.createStatement();
		            a = state.executeUpdate(sql);
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            DBUtil.close(state, conn);
		        }
		        if(a>0)
		        	return true;
		        return false;
		}
		*/
}
