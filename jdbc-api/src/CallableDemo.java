import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
//		CallableStatement stmt = conn.prepareCall("{call get_name(?,?)}");
//		stmt.setInt(1, 101);
//		stmt.registerOutParameter(2, Types.VARCHAR);
//		stmt.execute();
//		System.out.println("Name: " + stmt.getString(2));
			
			CallableStatement stmt = conn.prepareCall("{? = call tax(?)}");
			stmt.setInt(2, 12000);
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.execute();
			System.out.println("Tax: " + stmt.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
