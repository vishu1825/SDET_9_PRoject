package com.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ExecuteNonSelectQueryTest2 {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		 int result=0;
			try {
				//step 1 : rigester the database 
			      Driver mysqlDriverR = new Driver();
			      DriverManager.registerDriver(mysqlDriverR);
			  
				//step 2 : connect to database 
			        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			      
				//step 3 : create a statement ref
			       Statement stat = con.createStatement();
			       
			       
				//step 4: execute Query
			       result=  stat.executeUpdate("insert into project values('TY_PROJ_301', 'deepak', '10/4/2020','jdbc', 'Completed', 10)");
			           if(result==1) {
			        	   System.out.println("student successfully creted..!");
			           } 
			             
			      
			}catch (Exception e) {
				if(result==0) {
					System.err.println("student is not created");
				}
					System.out.println(result);
			}finally {
					//step 5: close the conection
				 con.close();
				 System.out.println("close");
			}
        
	}

}
