
package jdbcRatan;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/* Notes : install postgresql as per the https://www.youtube.com/watch?v=B6Ck6oCjszA
		 add jdbc driver for postgresql from https://jdbc.postgresql.org/download.html
		 add jar file in current jre system lib in the left	 */
public class jdbctest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/RatanjavaPostgres","postgres", "password123");
			System.out.println("Connection was established");
			//Statement st = con.createStatement();
			//String createquery = "create table emp(eid int,ename varchar(30),esal int)";
			//String createqueryEmpAddress = "create table empAddress(StreetName varchar(30), Country varchar(30),AptNo int)";
			//int resultcreate = st.executeUpdate(createqueryEmpAddress);
			//System.out.println("Table was created sucessfully --"+resultcreate);
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
	}

}
