package jdbcRatan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class batchupdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/RatanjavaPostgres","postgres","password123");
			Statement statement = connection.createStatement();
			statement.addBatch("create table VendorLocal(vid int,vname varchar(30),vstage varchar(30))");
			statement.addBatch("insert into VendorLocal values(100,'HP','stage3')");
			statement.addBatch("insert into VendorLocal values(101,'HP','stage3')");
			statement.addBatch("insert into VendorLocal values(102,'HP','stage3')");
			int [] x = statement.executeBatch();
			for(int xx : x){
				System.out.println(xx);
			}
			
			connection.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
