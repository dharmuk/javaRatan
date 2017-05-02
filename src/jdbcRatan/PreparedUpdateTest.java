package jdbcRatan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedUpdateTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/RatanjavaPostgres","postgres","password123");
		PreparedStatement preparedStatement = connection.prepareStatement("update VendorDetails set Vendor_Name=? where Vendor_Name =?");
		preparedStatement.setString(1, "ratannew");
		preparedStatement.setString(2, "ratan");
		preparedStatement.executeUpdate();
		
		/*PreparedStatement preparedStatement2 = connection.prepareStatement("delete from VendorDetails where Vendor_Name=? ");
		preparedStatement2.setString(1, "raj");
		preparedStatement2.executeUpdate();
		preparedStatement2.setString(1, "rajee");
		preparedStatement2.executeUpdate();*/
		
		PreparedStatement preparedStatement3 = connection.prepareStatement("select * from VendorDetails");
		ResultSet set = preparedStatement3.executeQuery();
		while(set.next()){
			System.out.println(set.getString(2)+"------"+set.getInt(1));
		}
		connection.close();
		
		

	}

}
