package jdbcRatan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class elephantsql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://ec2-54-225-119-223.compute-1.amazonaws.com:5432/dbqvcfns8rp1lc","qjublimtbqlglw","qjf_JkN5aauWSDjVlx8SUqF-k2");
			Statement statement = connection.createStatement();
			String createvendor = "create table Vendor(vid int,vname varchar(30),vstage varchar(30))";
			int statuscretevendor = statement.executeUpdate(createvendor);
			System.out.println("Table is ceate sucessfully -"+statuscretevendor);
			String insertinto1 = "insert into Vendor values(100,'HP','stage3')";
			String insertinto2 = "insert into Vendor values(101,'intel','stage3')";
			String insertinto3 = "insert into Vendor values(102,'sony','stage2')";
			statement.executeUpdate(insertinto1);
			statement.executeUpdate(insertinto2);
			statement.executeUpdate(insertinto3);
			System.out.println("Values are inserted in to table sucessfully");
			String selectstar = "select * from Vendor";
			ResultSet set=statement.executeQuery(selectstar);
			while (set.next()){
				System.out.println(set.getInt(1)+"---"+set.getString(2)+"---"+set.getString(3));
				}
			System.out.println("Data retrival is completed");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
