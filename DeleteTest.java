import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest{
	public static void main(String[] args) {
		String link="jdbc:mysql://127.0.0.1:3306/myperson";
		String user="root";
		String password="toor";
		String QUERY="DELETE FROM person WHERE id=21172 ";

		try(Connection conn=DriverManager.getConnection(link,user,password)){
			PreparedStatement statement=conn.prepareStatement(QUERY);
			/*statement.setInt(1,21128);
			statement.setString(2,"Milka");
			statement.setInt(3,22);
			statement.setString(4,"Musanze");
			statement.setString(5,"Finance");*/

			int count=statement.executeUpdate();
			if (count>0) {
				System.out.println("Data Deleted!!");
				
			}else{
				System.out.println("Error In QUERY");
			}

			
		}catch(SQLException e){
			System.err.format("SQLSTATE %s\n %s:",e.getSQLState(),e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}