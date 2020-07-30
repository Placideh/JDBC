import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class SelectTest{
	public static void main(String[] args) {
		String link="jdbc:mysql://127.0.0.1:3306/myperson";
		String user="root";
		String password="toor";
		String QUERY="SELECT * FROM person";
		try(Connection conn=DriverManager.getConnection(link,user,password)){
			PreparedStatement statement=conn.prepareStatement(QUERY);
			ResultSet result=statement.executeQuery();
			int count=0;
			while (result.next()) {
				String output="User #%d:%d-%s-%d-%s-%s";
				int id=result.getInt(1);
				String name=result.getString(2);
				int age=result.getInt(3);
				String location=result.getString(4);
				String job=result.getString(5);
				System.out.println(String.format(output,++count,id,name,age,location,job));
				
			}
		}catch(SQLException e){
			System.err.format("SQLSTATE:%s\n%s",e.getSQLState(),e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}