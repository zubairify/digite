import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) {
		String sql1 = "INSERT INTO customer VALUES (777, 'Frank','Florida',1200)";
		String sql2 = "UPDATE customer SET limit=5000 WHERE cust_id=901";
		String sql3 = "DELETE FROM customer WHERE cust=101";
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			
			conn.setAutoCommit(false); // setting auto-commit off
			stmt.executeBatch();	// Executing all 3 queries in one go
			conn.commit();	// Commit the transaction
			System.out.println("Transaction successful");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("Transaction failed due to..");
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
