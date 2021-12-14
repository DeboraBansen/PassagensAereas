package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Cidade;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class CidadeDAO {
	
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static CidadeDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	

	private CidadeDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into cidade values(?,?,?,?)");
		delete=conexao.prepareStatement("delete from cidade where cod_cid=?");
		update=conexao.prepareStatement("update cidade set cidade=?,estado=?,pais=? where cod_cid=?");
		select=conexao.prepareStatement("select *from cidade where cod_cid=?");
		selectAll=conexao.prepareStatement("select *from cidade ");
		newId=conexao.prepareStatement("select nextval('cod_cid')");
		
	}
	
	public static CidadeDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new CidadeDAO();
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
	
	public void insert(Cidade cidade)throws InsertException{
		try {
			
			insert.setInt(1, newId());
			insert.setString(2, cidade.getCidade());
			insert.setString(3,cidade.getEstado());
			insert.setString(4, cidade.getPais());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a cidade");
		}
	}
	
	public void delete(Cidade cidade)throws DeleteException{
		try {
			delete.setInt(1, cidade.getCod_cid());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar a cidade");
		}
		
	}	
	
	public List<Cidade> selectAll() throws SelectException {
		List<Cidade> cidades=new ArrayList<Cidade>();
		Cidade cidade=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				cidade=new Cidade();
				cidade.setCod_cid(rs.getInt("cod_cid"));
				cidade.setCidade(rs.getString("cidade"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setPais(rs.getString("pais"));
				cidades.add(cidade);
			}
			return cidades;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a cidade");
		}
		
	}
	
	public void update(Cidade cidade)throws UpdateException{
		try {
			update.setString(1, cidade.getCidade());
			update.setString(2, cidade.getEstado());
			update.setString(3, cidade.getPais());
			update.setInt(4, cidade.getCod_cid());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar cidade");
		}
		
	}
	
	public Cidade select(int cod_cid) throws SelectException {
		Cidade cidade=null;
		
		try {
			select.setInt(1, cod_cid);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				cidade=new Cidade();
				cidade.setCod_cid(rs.getInt("cod_cid"));
				cidade.setCidade(rs.getString("cidade"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setPais(rs.getString("pais"));
				
				
			}
			return cidade;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a cidade");
		}
	}
	
}
