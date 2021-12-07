package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Aeronave;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class AeronaveDAO {
	
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static AeronaveDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	private AeronaveDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into aeronave values(?,?,?)");
		delete=conexao.prepareStatement("delete from aeronave where cod=?");
		update=conexao.prepareStatement("update aeronave set nome=?,qtd_poltrona=? where cod=?");
		select=conexao.prepareStatement("select *from aeronave where cod=?");
		selectAll=conexao.prepareStatement("select *from aeronave ");
		newId=conexao.prepareStatement("select nextval('cod')");
		
	}
	
	public static AeronaveDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new AeronaveDAO();
		}
		return instance;
	}
}
