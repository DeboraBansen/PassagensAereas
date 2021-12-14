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
	
	public void insert(Reserva reserva)throws InsertException{
		try {
			
			insert.setInt(1, newId());
			insert.setString(2, reserva.getDta_validade());
			insert.setInt(3,reserva.getCod_voo());
			insert.setInt(4, reserva.getCod_p());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a reserva");
		}
	}
	
	public void delete(Reserva reserva)throws DeleteException{
		try {
			delete.setInt(1, reserva.getCod_res());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar reserva");
		}
		
	}	
	
	public List<Reserva> selectAll() throws SelectException {
		List<Reserva> reservas=new ArrayList<Reserva>();
		Reserva reserva=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				reserva=new Reserva();
				reserva.setCod_res(rs.getInt("cod_res"));
				reserva.setDta_validade(rs.getString("prazo_validade"));
				reserva.setCod_voo(rs.getInt("cod_voo"));
				reserva.setCod_p(rs.getInt("cod_p"));
				reservas.add(reserva);
			}
			return reservas;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a reserva");
		}
		
	}
	
	public void update(Reserva reserva)throws UpdateException{
		try {
			update.setString(1, reserva.getDta_validade());
			update.setInt(2, reserva.getCod_voo());
			update.setInt(3, reserva.getCod_p());
			update.setInt(4, reserva.getCod_res());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar reserva");
		}
		
	}
	
	public Reserva select(int cod) throws SelectException {
		Reserva reserva=null;
		
		try {
			select.setInt(1, cod);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				reserva=new Reserva();
				reserva.setCod_res(rs.getInt("cod_res"));
				reserva.setDta_validade(rs.getString("prazo_validade"));
				reserva.setCod_voo(rs.getInt("cod_voo"));
				reserva.setCod_p(rs.getInt("cod_p"));
				
			}
			return reserva;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a reserva");
		}
	}
	
	
	
}
