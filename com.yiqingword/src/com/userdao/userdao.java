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
	//�鿴������Ϣ
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
					rs=psts.executeQuery();//��¼���صĽ��
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} 
			return list;
		}
	
		//�鿴������Ϣwhere Date ='%" + Date + "%'
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
							rs=psts.executeQuery();//��¼���صĽ��
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
								if((rs.getString("Province")).equals("����������")){
									flag=1;
								}
								if(flag==1)
									break;
							}
							
							DBUtil.close(rs, psts, con);
							return list;
						} catch (SQLException e) {
							// TODO �Զ����ɵ� catch ��
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
							rs=psts.executeQuery();//��¼���صĽ��
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
							// TODO �Զ����ɵ� catch ��
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
							rs=psts.executeQuery();//��¼���صĽ��
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
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						} 
					return list;
				}
	
	
	
	
	
	
	
	
	
	
	
/*
	//��¼���ڵ������˺ŵļ���ж�
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
	//�鿴������Ϣ
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
				rs=psts.executeQuery();//��¼���صĽ��
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} 
		return list;
	}
	//��ʾ�����޸���Ϣʹ��
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
	
	//�����û���Ϣ
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
	//��������
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
	//�����û�id
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
	
	//���ӿγ�
	public boolean addclass(int teacherid,String classkind,int number)
	 {
			
			String sql = "insert into classtea(teacherid,classkind,number)"
					+ "values('"  + teacherid + "','" + classkind+ "','"  + number + "')";
			Connection conn = DBUtil.getConn();//���÷����������ݿ�
			Statement state = null;//����һ��Statement������ִ�о�̬��SQL���
			//Statement�������Ѿ��������ݿ������Ϸ��;�̬��SQL���
			boolean f = false;
			int a = 0 ;
			
			try {       //���Ӵ������ڵĴ���
				state = conn.createStatement();//����������
				a = state.executeUpdate(sql);
				//ִ��ָ���ĸ������SQl��䣬�����ز������������ֵ
			} catch (Exception e) {     //�������
				e.printStackTrace();
			} finally {
				//�ر�z	����
				DBUtil.close(state, conn);
			}
			
			if (a > 0) {
				f = true;
			}
			return f;
		}
	
	
	//�鿴��ʦ�γ�
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
					rs=psts.executeQuery();//��¼���صĽ��
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} 
			return list;
		}
	
	//ɾ���γ�
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
		//���Ŀγ�����
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
	//�õ��γ̶�Ӧ����ʦ
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
	
	//��ʾ����
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
					rs=psts.executeQuery();//��¼���صĽ��
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} 
			return list;
		}
		


//�ҵ�����ϵ��
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
//ѧ��ѡ��
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
				rs=psts.executeQuery();//��¼���صĽ��
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} 
		return list;
	}
	
//����ѧ��ѡ��
	public void addstdclass(int teacherid,int studentid,int classkindid)
	 {	
			String sql = "insert into classnow(teacherid,studentid,classkindid)"
					+ "values('"  + teacherid + "','" + studentid+ "','"  + classkindid + "')";
			Connection conn = DBUtil.getConn();//���÷����������ݿ�
			Statement state = null;//����һ��Statement������ִ�о�̬��SQL���
			//Statement�������Ѿ��������ݿ������Ϸ��;�̬��SQL���
			boolean f = false;
			int a = 0 ;
			
			try {       //���Ӵ������ڵĴ���
				state = conn.createStatement();//����������
				a = state.executeUpdate(sql);
				//ִ��ָ���ĸ������SQl��䣬�����ز������������ֵ
			} catch (Exception e) {     //�������
				e.printStackTrace();
			} finally {
				//�ر�z	����
				DBUtil.close(state, conn);
			}
		}
	
	//��ʾѧ����ѡ��
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
					rs=psts.executeQuery();//��¼���صĽ��
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} 
			return list;
		}
		//�����û�
		public boolean addnewuser(user user1)
		 {
				
				String sql = "insert into user(username,password,sex,role,birth,bianhao)"
						+ "values('"  + user1.getUsername() + "','" + user1.getPassword()+ "','"  + user1.getSex() + "','"  + user1.getRole() + "','" + user1.getBirth()+ "','"  + user1.getBianhao() + "')";
				Connection conn = DBUtil.getConn();//���÷����������ݿ�
				Statement state = null;//����һ��Statement������ִ�о�̬��SQL���
				//Statement�������Ѿ��������ݿ������Ϸ��;�̬��SQL���
				boolean f = false;
				int a = 0 ;
				
				try {       //���Ӵ������ڵĴ���
					state = conn.createStatement();//����������
					a = state.executeUpdate(sql);
					//ִ��ָ���ĸ������SQl��䣬�����ز������������ֵ
				} catch (Exception e) {     //�������
					e.printStackTrace();
				} finally {
					//�ر�z	����
					DBUtil.close(state, conn);
				}
				
				if (a > 0) {
					f = true;
				}
				return f;
			}
		//ȫ���û���Ϣ
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
					rs=psts.executeQuery();//��¼���صĽ��
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} 
			return list;
		}
		//����Ա�����û���Ϣ
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
