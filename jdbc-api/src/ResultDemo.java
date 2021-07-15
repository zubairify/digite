import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDemo {

	public static void main(String[] args) {
		String sql = "SELECT * FROM customer";
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			for(int c=1; c<= meta.getColumnCount(); c++)
				System.out.print(meta.getColumnLabel(c) + "\t");
			System.out.println();
			
			while(rs.next()) {
				for(int c=1; c<= meta.getColumnCount(); c++)
					System.out.println(rs.getString(c) + "\t");
				System.out.println();
			}
			
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
