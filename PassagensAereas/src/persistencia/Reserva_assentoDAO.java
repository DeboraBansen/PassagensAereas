package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Reserva_assento;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class Reserva_assentoDAO {
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static Reserva_assentoDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	private Reserva_assentoDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into reserva_assento values(?,?,?,?)");
		delete=conexao.prepareStatement("delete from reserva_assento where cod_assento=?");
		update=conexao.prepareStatement("update reserva_assento set data_reserva=?,num_poltrona=?,cod=? where cod_assento=?");
		select=conexao.prepareStatement("select *from reserva_assento where cod_assento=?");
		selectAll=conexao.prepareStatement("select *from reserva_assento ");
		newId=conexao.prepareStatement("select nextval('cod_assento')");
		
	}
	
	public static Reserva_assentoDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new Reserva_assentoDAO();
		}
		return instance;
	}
}
