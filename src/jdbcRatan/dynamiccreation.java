package jdbcRatan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class dynamiccreation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/RatanjavaPostgres","postgres","password123");
		Statement statement = connection.createStatement();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter table name");
		String tname = scanner.next();
		String q1 = "create table "+tname+"(eid int,ename varchar(30))";
		statement.executeUpdate(q1);
		while(true){
			System.out.println("enter eid");
		int eid = scanner.nextInt();
		System.out.println("enter ename");
		String ename = scanner.next();
		String q2 = "insert into "+tname+" values("+eid+", '"+ename+"')";
		System.out.println(q2);
		statement.executeUpdate(q2);
		System.out.println("Add  ore record s or no");
		String option = scanner.next();
		if(option.equals("no")){
			break;
			}
				
		}
		
		connection.close();

	}

}
