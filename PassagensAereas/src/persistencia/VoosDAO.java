package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Voos;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class VoosDAO {
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static VoosDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	private VoosDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into voos values(?,?,?,?)");
		delete=conexao.prepareStatement("delete from voos where cod_voo=?");
		update=conexao.prepareStatement("update voos set classe=?,cod=?,cod_trecho=? where cod_voo=?");
		select=conexao.prepareStatement("select *from voos where cod_voo=?");
		selectAll=conexao.prepareStatement("select *from voos ");
		newId=conexao.prepareStatement("select nextval('cod_voo')");
		
	}
	
	public static VoosDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new VoosDAO();
		}
		return instance;
	}
}
