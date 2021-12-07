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
}
