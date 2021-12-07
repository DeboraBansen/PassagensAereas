package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Trecho;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class TrechoDAO {
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static TrechoDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	private TrechoDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into trecho values(?,?,?,?,?,?)");
		delete=conexao.prepareStatement("delete from trecho where cod_trecho=?");
		update=conexao.prepareStatement("update trecho set origem=?,destino=?,cod_assento=?,aero_origem=?,aero_destino=? where cod_trecho=?");
		select=conexao.prepareStatement("select *from trecho where cod_trecho=?");
		selectAll=conexao.prepareStatement("select *from trecho ");
		newId=conexao.prepareStatement("select nextval('cod_trecho')");
		
	}
	
	public static TrechoDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new TrechoDAO();
		}
		return instance;
	}
}
