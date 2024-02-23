package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class DataBaseOperation {
	private static final String  insertQuery="insert into mcq_question values(?,?,?,?,?,?,?,?,?);";
	private static final String selectQueryForMCQ="select * from mcq_question where question_title=?";
	private static LinkedList<ModelSchema_DTO> add_data_linkedList=new LinkedList<ModelSchema_DTO>();
	
	public boolean addDataToDataBase(Connection connection ){
		try {
			PreparedStatement ps=connection.prepareStatement(insertQuery);
			for(ModelSchema_DTO ms:add_data_linkedList) {
				ps.setInt(1, ms.getQues_id());
				ps.setString(2, ms.getQuestion_title());
				ps.setString(3, ms.getQuestion());
				ps.setString(4,ms.getOpt1());
				ps.setString(5,ms.getOpt2());
				ps.setString(6,ms.getOpt3());
				ps.setString(7,ms.getOpt4());
				ps.setInt(8, ms.getAnskey());
				ps.setString(9, ms.getDiff_level());
				ps.addBatch();
			}
			ps.executeBatch();
			add_data_linkedList.removeAll(add_data_linkedList);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void add_to_list(ModelSchema_DTO ms) {
		add_data_linkedList.add(ms);
	}
	
	public ArrayList<ModelSchema_DTO> getdataFromDataset(Connection connection,String title) {
		try {
			PreparedStatement ps=connection.prepareStatement(selectQueryForMCQ);
			ps.setString(1,title);
			ResultSet rs=ps.executeQuery();
			ArrayList<ModelSchema_DTO> list=new ArrayList<ModelSchema_DTO>();
			ModelSchema_DTO ms;
			while(rs.next()) {
				ms=new ModelSchema_DTO();
				ms.setQues_id(rs.getInt(1));
				ms.setQuestion(rs.getString(3));
				ms.setOpt1(rs.getString(4));
				ms.setOpt2(rs.getString(5));
				ms.setOpt3(rs.getString(6));
				ms.setOpt4(rs.getString(7));
				ms.setAnskey(rs.getInt(8));
				ms.setDiff_level(rs.getString(9));
				list.add(ms);
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
