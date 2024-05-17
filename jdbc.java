package com.javatodatabase;

//imports suitable packages
		import java.sql.Connection;   
		import java.sql.DriverManager; 
		import java.sql.ResultSet; 
		import java.sql.Statement;
		  
public class jdbcprogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
// Database URL
    String url="jdbc:mysql://localhost:3306/"; 
		        
// Database username
    String username="root";
		        
// Database password
    String password="root"; 
		        
// Try block
    try { 
	  
    	Connection con= DriverManager.getConnection(url,username,password); // Establish connection

// Check connection success
    if(con !=null) 
    {    
	 System.out.println("JDBC Connected Successfull....,"); 
    } else {
	 System.out.println("JDBC Connection is Failed....,"); 
    }
		            
    Statement statement=con.createStatement(); // Create statement
		            
    String createDB="create database Employeess"; // Create database query
    String useDB="use Employeess"; // Use database query
    String createTable="create table emptable(empcode int,empname varchar(50),empage int, esalary int)"; // Create table query
    String select="select*from emptable"; // Select query
    String insert= // Insert data query
    		"""
    		insert into emptable values 
    		(101,'Jenny',25,10000),
            (102,'Jacky',30,10000),
		    (103,'Joe',20,10000),
		    (104,'John',40,10000),
		    (105,'Shameer',25,10000);
		               
		    """;
		           
 // Execute create database query
  statement.execute(createDB);      
  
 //Execute use database query 
  statement.execute(useDB);      
  
 //Execute create table query
  statement.execute(createTable);   
  
 //Execute insert data query
statement.execute(insert);           

// Execute select query
 ResultSet rs=statement.executeQuery(select); 
		            
    System.out.println("\n------------------TABLE-DETAILS----------------------");
		            
    // Print data
		          
     while(rs.next()) 
   { 
    	 // Iterate over result set
		 System.out.println(rs.getInt("empcode")+"  "+rs.getString("empname")+"  "+rs.getInt("empage")+"  "+rs.getInt("esalary")); 
		          
   }
    // Close connection          
		 con.close();                  
		                
   }
    catch (Exception e)
   { 
    e.printStackTrace(); 
   }
 }
		    
}


/* OUTPUT
 * 
 * JDBC Connection Successfull....,

------------------TABLE-DETAILS----------------------

101  Jenny   25  10000
102  Jacky   30  10000
103  Joe     20  10000
104  John    40  10000
105  Shameer 25  10000
 * 
 */
 

}