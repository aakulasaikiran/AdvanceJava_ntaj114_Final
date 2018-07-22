package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import com.nt.bo.BookBO;

public class BookSearchDAOImpl implements BookSearchDAO {
  private static final String SEARCH_BOOKS_BY_CATEGORY="SELECT BOOKID,BOOKNAME,AUTHOR,STATUS,CATEGORY FROM BOOK_DETAILS WHERE CATEGORY=?";
  private static Properties props;
  static{
	  ResourceBundle bundle=null;
		Set<String> keys=null;
		
		//locate properties file
		bundle=ResourceBundle.getBundle("com/nt/commons/jdbc");
		//get keys of properties file
		keys=bundle.keySet();
		//Strore  Proeprties file content to java.util.Properties class object
		props=new Properties();
		for(String key:keys){
			props.put(key,bundle.getString(key));
		}//for  
	  
  }
    public Connection getConnection()throws Exception{
    	Connection con=null;
    	//register driver
    	Class.forName(props.getProperty("jdbc.driver"));
    	//establish the connection
    	con=DriverManager.getConnection(props.getProperty("jdbc.url"),props.getProperty("jdbc.user"),props.getProperty("jdbc.pwd"));
    	return con;
    }
  
    @Override
	public List<BookBO> search(String category)throws Exception {
    	PreparedStatement ps=null;
    	Connection con=null;
    	ResultSet rs=null;
    	List<BookBO> listBO=null;
    	BookBO bo=null;
    	//get Jdbc Connection
    	con=getConnection();
		//create PreparedStatement object
    	ps=con.prepareStatement(SEARCH_BOOKS_BY_CATEGORY);
    	//set values to Query params
    	ps.setString(1, category);
    	//Execute SQL Query in Db s/w
    	rs=ps.executeQuery();
    	//Copy Result records to ArrayList elements
    	listBO=new ArrayList();
    	while(rs.next()){
    		//copy each record to BO class object
    		bo=new BookBO();
    		bo.setBookId(rs.getInt(1));
    		bo.setBookName(rs.getString(2));
    		bo.setAuthor(rs.getString(3));
    		bo.setStatus(rs.getString(4));
    		bo.setCategory(rs.getString(5));
    		//add each BookBO object ArrayList
    		listBO.add(bo);
    	}//while
		return listBO;
	}//method
    
}//class
