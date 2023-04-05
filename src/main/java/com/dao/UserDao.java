package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;





public class UserDao{
	
	static Connection con;  
	
	 public static Connection getConnection(){  
	        
	        try{  
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Database=jsp;encrypt=false","sa","Admin#123");  
	            return con;
	        }catch(Exception e){
	        	System.out.println(e);}  
	        return con;  
	    }  
	 
	 public static int save(User e){  
	        int status=0;  
	        try{  
	            Connection con=UserDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into UserData values(?,?,?)");
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getEmail());  
	            ps.setString(3,e.getPassword());  
	            
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
		
	
	 
	 public static List<User> GetDetail(){  
	        List<User> list=new ArrayList<User>();  
	          
	        try{  
	            Connection con=UserDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from UserData");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                User e=new User();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setEmail(rs.getString(3)); 
	                e.setPassword(rs.getString(4));  
	                 
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	 
	 public static int delete(User u){  
	        int status=0;  
	        try{  
	            Connection con=UserDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from UserData where id=?");  
	            ps.setInt(1,u.getId());  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){
	        	e.printStackTrace();
	        	}  
	          
	        return status;  
	    } 
	 public static int update(User u){  
		    int status=0;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement(  
		"update UserData set Name=? ,Email=? ,Password=? where id=?");  
		        ps.setString(1,u.getName());  
		        ps.setString(2,u.getEmail());  
		        ps.setString(3,u.getPassword());  
		       
		        ps.setInt(4,u.getId());  
		        status=ps.executeUpdate();  
		    }catch(Exception e){
		    	System.out.println(e);
		    	}  
		    return status;  
		}  
	 public static User getRecordById(int id){  
		    User u=null;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("select * from  UserData where id=?");  
		        ps.setInt(1,id);  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		            u=new User();  
		            u.setId(rs.getInt("id"));  
		            u.setName(rs.getString("Name"));  
		            u.setPassword(rs.getString("Email"));  
		            u.setEmail(rs.getString("Password"));  
		            
		        }  
		    }catch(Exception e){
		    	System.out.println(e);}  
		    return u;  
		}   

}
