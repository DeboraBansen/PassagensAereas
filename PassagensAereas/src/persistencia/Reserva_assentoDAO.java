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
	
	public void insert(Reserva_assento reserva_assento)throws InsertException{
		try {
			
			insert.setInt(1, newId());
			insert.setString(2, reserva_assento.getData_reserva());
			insert.setInt(3,reserva_assento.getNum_poltrona());
			insert.setInt(4, reserva_assento.getCod_aero());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a reserva de assento");
		}
	}
	
	public void delete(Reserva_assento reserva_assento)throws DeleteException{
		try {
			delete.setInt(1, reserva_assento.getCod_assento());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar reserva_assento");
		}
		
	}	
	
	public List<Reserva_assento> selectAll() throws SelectException {
		List<Reserva_assento> reserva_assentos=new ArrayList<Reserva_assento>();
		Reserva_assento reserva_assento=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				reserva_assento=new Reserva_assento();
				reserva_assento.setCod_assento(rs.getInt("cod_assento"));
				reserva_assento.setData_reserva(rs.getString("data_reserva"));
				reserva_assento.setNum_poltrona(rs.getInt("num_poltrona"));
				reserva_assento.setCod_aero(rs.getInt("cod"));
				reserva_assentos.add(reserva_assento);
			}
			return reserva_assentos;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a reserva_assento");
		}
		
	}
	
	public void update(Reserva_assento reserva_assento)throws UpdateException{
		try {
			update.setString(1, reserva_assento.getData_reserva());
			update.setInt(2, reserva_assento.getNum_poltrona());
			update.setInt(3, reserva_assento.getCod_aero());
			update.setInt(4, reserva_assento.getCod_assento());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar reserva_assento");
		}
		
	}
	
	public Reserva_assento select(int cod) throws SelectException {
		Reserva_assento reserva_assento=null;
		
		try {
			select.setInt(1, cod);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				reserva_assento=new Reserva_assento();
				reserva_assento.setCod_assento(rs.getInt("cod"));
				reserva_assento.setData_reserva(rs.getString("data_reserva"));
				reserva_assento.setNum_poltrona(rs.getInt("num_poltrona"));
				reserva_assento.setCod_aero(rs.getInt("cod"));
				
			}
			return reserva_assento;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a reserva de assento");
		}
	}
	
	
	
}
