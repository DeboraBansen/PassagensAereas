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

	public void insert(Aeroporto aeroporto)throws InsertException{
		try {
			
			insert.setInt(1, newId());
			insert.setString(2, aeroporto.getNome());
			insert.setInt(3, aeroporto.getCod_cid());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a aeroporto");
		}
	}
	
	public void delete(Aeroporto aeroporto)throws DeleteException{
		try {
			delete.setInt(1, aeroporto.getCod());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar aeroporto");
		}
		
	}	
	
	public List<Aeroporto> selectAll() throws SelectException {
		List<Aeroporto> aeroportos=new ArrayList<Aeroporto>();
		Aeroporto aeroporto=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				aeroporto=new Aeroporto();
				aeroporto.setCod(rs.getInt("cod_aero"));
				aeroporto.setNome(rs.getString("nome"));
				aeroporto.setCod_cid(rs.getInt("cod_cid"));
				aeroportos.add(aeroporto);
			}
			return aeroportos;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a aeroportos");
		}
		
	}
	
	public void update(Aeroporto aeroporto)throws UpdateException{
		try {
			update.setString(1, aeroporto.getNome());
			update.setInt(2, aeroporto.getCod_cid());
			update.setInt(3, aeroporto.getCod());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar aeroporto");
		}
		
	}
	
	public Aeroporto select(int cod) throws SelectException {
		Aeroporto aeroporto=null;
		
		try {
			select.setInt(1, cod);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				aeroporto=new Aeroporto();
				aeroporto.setCod(rs.getInt("cod_aero"));
				aeroporto.setNome(rs.getString("nome"));
				aeroporto.setCod_cid(rs.getInt("cod_cid"));
				
			}
			return aeroporto;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a aeroporto");
		}
	}
	
	
	
}
