package jdbcRatan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreapredStatementTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/RatanjavaPostgres","postgres","password123");
		Statement statement = connection.createStatement();
		statement.executeUpdate("create table VendorDetails(Vendor_Id int,Vendor_Name varchar(30))");
		// insert data by using Prepared Statement
		PreparedStatement preparedStatement = connection.prepareStatement("insert into VendorDetails values(?,?)");
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter Vendor id");
			int Vid = scanner.nextInt();
			System.out.println("enter Vendor Name");
			String Vname = scanner.next();
			preparedStatement.setInt(1, Vid);
			preparedStatement.setString(2, Vname);
			preparedStatement.executeUpdate();
			
			System.out.println("Need to nsert more records yes/no");
			String option = scanner.next();
			if(option.equals("no")){
				break;
			}
		}
		connection.close();

	}

}
