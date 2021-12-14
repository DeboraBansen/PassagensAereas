package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Passageiro;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class PassageiroDAO {

	@SuppressWarnings("unused")
	private Conexao conexao;
	private static PassageiroDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	private PassageiroDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into passageiro values(?,?)");
		delete=conexao.prepareStatement("delete from passageiro where cod_p=?");
		update=conexao.prepareStatement("update passageiro set nome=? where cod_p=?");
		select=conexao.prepareStatement("select *from passageiro where cod_p=?");
		selectAll=conexao.prepareStatement("select *from passageiro ");
		newId=conexao.prepareStatement("select nextval('cod_p')");
		
	}
	
	public static PassageiroDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new PassageiroDAO();
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

	public void insert(Passageiro passageiro)throws InsertException{
		try {
			
			insert.setInt(1, newId());
			insert.setString(2, passageiro.getNome());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a passageiro");
		}
	}
	
	public void delete(Passageiro passageiro)throws DeleteException{
		try {
			delete.setInt(1, passageiro.getCod_p());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar passageiro");
		}
		
	}	
	
	public List<Passageiro> selectAll() throws SelectException {
		List<Passageiro> passageiros=new ArrayList<Passageiro>();
		Passageiro passageiro=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				passageiro=new Passageiro();
				passageiro.setCod_p(rs.getInt("cod_p"));
				passageiro.setNome(rs.getString("nome"));
				passageiros.add(passageiro);
			}
			return passageiros;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o passageiro");
		}
		
	}
	
	public void update(Passageiro passageiro)throws UpdateException{
		try {
			update.setString(1, passageiro.getNome());
			update.setInt(2, passageiro.getCod_p());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar passageiro");
		}
		
	}
	
	public Passageiro select(int cod_p) throws SelectException {
		Passageiro passageiro=null;
		
		try {
			select.setInt(1, cod_p);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				passageiro=new Passageiro();
				passageiro.setCod_p(rs.getInt("cod_p"));
				passageiro.setNome(rs.getString("nome"));
				
				
			}
			return passageiro;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o passageiro");
		}
	}
	
}
