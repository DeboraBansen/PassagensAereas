package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Reserva;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class ReservaDAO {
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static ReservaDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	private ReservaDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into reserva values(?,?,?,?)");
		delete=conexao.prepareStatement("delete from reserva where cod_res=?");
		update=conexao.prepareStatement("update reserva set prazo_validade=?,cod_voo=?,cod_p=? where cod_res=?");
		select=conexao.prepareStatement("select *from reserva where cod_res=?");
		selectAll=conexao.prepareStatement("select *from reserva ");
		newId=conexao.prepareStatement("select nextval('cod_res')");
		
	}
	
	public static ReservaDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new ReservaDAO();
		}
		return instance;
	}
}
