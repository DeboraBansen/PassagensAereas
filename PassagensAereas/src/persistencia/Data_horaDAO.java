package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Data_hora;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class Data_horaDAO {
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static Data_horaDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	private Data_horaDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into data_hora values(?,?,?,?,?)");
		delete=conexao.prepareStatement("delete from data_hora where cod=?");
		update=conexao.prepareStatement("update data_hora set data_che=?,hora_che=?,data_sai=?,hora_sai=? where cod=?");
		select=conexao.prepareStatement("select *from data_hora where cod=?");
		selectAll=conexao.prepareStatement("select *from data_hora ");
		newId=conexao.prepareStatement("select nextval('cod')");
		
	}
	
	public static Data_horaDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new Data_horaDAO();
		}
		return instance;
	}
	
	public int newId()throws SelectException{
		try {
			ResultSet rs=newId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return 0;
			}
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel criar novo id");
		}
	}
	
	public void insert(Data_hora data_hora)throws InsertException{
		try {
			
			insert.setInt(1, newId());
			insert.setString(2, data_hora.getData_che());
			insert.setString(3,data_hora.getHora_che());
			insert.setString(4, data_hora.getData_sai());
			insert.setString(5, data_hora.getHora_sai());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a data e hora");
		}
	}
	
	public void delete(Data_hora data_hora)throws DeleteException{
		try {
			delete.setInt(1, data_hora.getCod());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar data_hora");
		}
		
	}	
	
	public List<Data_hora> selectAll() throws SelectException {
		List<Data_hora> data_horas=new ArrayList<Data_hora>();
		Data_hora data_hora=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				data_hora=new Data_hora();
				data_hora.setCod(rs.getInt("cod"));
				data_hora.setData_che(rs.getString("data_che"));
				data_hora.setHora_che(rs.getString("hora_che"));
				data_hora.setData_sai(rs.getString("data_sai"));
				data_hora.setHora_sai(rs.getString("hora_sai"));
				data_horas.add(data_hora);
			}
			return data_horas;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a data_hora");
		}
		
	}
	
	public void update(Data_hora data_hora)throws UpdateException{
		try {
			update.setString(1, data_hora.getData_che());
			update.setString(2, data_hora.getHora_che());
			update.setString(3, data_hora.getData_sai());
			update.setString(4, data_hora.getHora_sai());
			update.setInt(5, data_hora.getCod());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar data_hora");
		}
		
	}
	
	public Data_hora select(int cod) throws SelectException {
		Data_hora data_hora=null;
		
		try {
			select.setInt(1, cod);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				data_hora=new Data_hora();
				data_hora.setCod(rs.getInt("cod"));
				data_hora.setData_che(rs.getString("data_che"));
				data_hora.setHora_che(rs.getString("hora_che"));
				data_hora.setData_sai(rs.getString("data_sai"));
				data_hora.setHora_sai(rs.getString("hora_sai"));
				
			}
			return data_hora;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o data_hora");
		}
	}
	
	
	
}
