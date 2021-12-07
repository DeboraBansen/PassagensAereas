package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Aeroporto;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class AeroportoDAO {
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static AeroportoDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	private AeroportoDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into aeroporto values(?,?,?)");
		delete=conexao.prepareStatement("delete from aeroporto where cod_aero=?");
		update=conexao.prepareStatement("update aeroporto set nome=?,cod_cid=? where cod_aero=?");
		select=conexao.prepareStatement("select *from aeroporto where cod_aero=?");
		selectAll=conexao.prepareStatement("select *from aeroporto ");
		newId=conexao.prepareStatement("select nextval('cod_aero')");
		
	}
	
	public static AeroportoDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new AeroportoDAO();
		}
		return instance;
	}
}
