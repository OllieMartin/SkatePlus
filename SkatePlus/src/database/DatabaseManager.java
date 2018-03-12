package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
INSERT INTO `VALUES_ROLLER_DANCE` (`code`, `name`, `base`, `plus_1`, `plus_2`, `plus_3`, `minus_1`, `minus_2`, `minus_3`) VALUES ('Tr1', 'Travelling Sequence Level 1', '2.5', '0.3', '0.6', '0.9', '-0.3', '-0.6', '-0.9');
INSERT INTO `VALUES_ROLLER_DANCE` (`code`, `name`, `base`, `plus_1`, `plus_2`, `plus_3`, `minus_1`, `minus_2`, `minus_3`) VALUES ('Tr2', 'Travelling Sequence Level 2', '3.5', '0.3', '0.6', '0.9', '-0.3', '-0.6', '-0.9');
INSERT INTO `VALUES_ROLLER_DANCE` (`code`, `name`, `base`, `plus_1`, `plus_2`, `plus_3`, `minus_1`, `minus_2`, `minus_3`) VALUES ('Tr3', 'Travelling Sequence Level 3', '4.5', '0.4', '0.8', '1.2', '-0.4', '-0.8', '-1.2');
INSERT INTO `VALUES_ROLLER_DANCE` (`code`, `name`, `base`, `plus_1`, `plus_2`, `plus_3`, `minus_1`, `minus_2`, `minus_3`) VALUES ('Tr4', 'Travelling Sequence Level 4', '6.0', '0.5', '1.0', '1.5', '-0.5', '-1.0', '-1.5');
 */

public class DatabaseManager {

	private static final String databaseName = "biscuitu_skateplus";

	public static void main(String args[]) {

		DatabaseManager.getInstance().getValuesRollerDance();

	}

	private static DatabaseManager instance;

	static {
		instance = new DatabaseManager();
	}

	public static DatabaseManager getInstance() {
		return DatabaseManager.instance;
	}

	/* END OF STATIC DECLARATIONS */

	private DatabaseManager() {
		// EMPTY
	}

	private void getValuesRollerDance() {

		Connection conn = null;

		try
		{

			String url = "jdbc:mysql://biscuitorg.uk:3306/biscuitu_skateplus";
			Class.forName ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection (url,"biscuitu_admin","revilo0071");
			System.out.println ("Database connection established");

			String query = "select * from VALUES_ROLLER_DANCE";
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next())  
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3));  


		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close ();
					System.out.println ("Database connection terminated");
				}
				catch (Exception e) { /* ignore close errors */ }
			}
		}

	}


	private void create() {

		Connection conn = null;

		try
		{

			String url = "jdbc:mysql://biscuitorg.uk:3306/biscuitu_skateplus";
			Class.forName ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection (url,"biscuitu_admin","revilo0071");
			System.out.println ("Database connection established");

			Statement s1 = conn.createStatement();
			int myResult2 = s1.executeUpdate("DROP TABLE test");

			Statement s = conn.createStatement();
			int myResult = s.executeUpdate("CREATE TABLE IF NOT EXISTS test ("
					+ "idNo INT(64) NOT NULL AUTO_INCREMENT,"
					+ "initials VARCHAR(3),"
					+ "PRIMARY KEY (`idNo`))");

			String insert = "insert into test (initials) values (?)";
			PreparedStatement pstmt=conn.prepareStatement(insert);  
			pstmt.setString(1, "OJM");
			pstmt.execute();

			PreparedStatement pstmt2 =conn.prepareStatement(insert);  
			pstmt2.setString(1, "ZAM");
			pstmt2.execute();

			String query = "select * from test";
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));  


		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close ();
					System.out.println ("Database connection terminated");
				}
				catch (Exception e) { /* ignore close errors */ }
			}
		}

	}

	public float query(String id, Col col) {

		float value = 0;

		// TODO value = database.query("SELECT " + col.toString() + " FROM SOV WHERE ID='" + id + "';";

		return value;

	}

}
