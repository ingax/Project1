package ers.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMaker;
import ers.beans.Forms;
import ers.dao.FormsDao;

public class FormsDaoImpl implements FormsDao{
	public List<Forms> getAllForms(){
		List<Forms> forms = new ArrayList<>();
		try (Connection conn = ConnectionMaker.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ers_forms");
			while(rs.next()) {
				forms.add(new Forms(rs.getInt("form_id"),
						rs.getFloat("amount"),
						rs.getString("reason"), 
						rs.getString("decision"),
						rs.getString("employee_id"),
						rs.getString("manager_id")));
			}
			System.out.println("Printing forms: " + forms);
			return forms;
		}catch (SQLException err) {
			err.printStackTrace();
		}
		return null;
	}
	
	public Forms getFormById(int form_id) {
		return null;
	}
	public Forms createForm(Forms f) {
		try(Connection conn = ConnectionMaker.getConnection()){
			System.out.println("Inside createform try block");
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO ers_forms VALUES (?, ?, ?, ?");
			
			stmt.setInt(1, f.getForm_id());
			stmt.setFloat(3, f.getAmount());
			stmt.setString(4, f.getReason());
			stmt.setString(6,  f.getDecisionMade());
			stmt.setString(7, f.getEmployee_id());
			stmt.setString(8, f.getManager_id());
			
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted == 1)
				System.out.println("row inserted");
				return f;
		} catch (SQLException err) {
			err.printStackTrace();
		}
		return new Forms();
	}
	public Forms updateForm(Forms updateForm) {
		return null;
	}
	public long deleteForm(Forms... deleteForm) {
		return 0;
	}
}
