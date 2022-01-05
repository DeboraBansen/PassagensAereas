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

	
	private VoosDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into voos values(?,?,?,?)");
		delete=conexao.prepareStatement("delete from voos where cod_voo=?");
		update=conexao.prepareStatement("update voos set classe=?,cod=?,cod_trecho=? where cod_voo=?");
		select=conexao.prepareStatement("select *from voos where cod_voo=?");
		selectAll=conexao.prepareStatement("select *from voos ");
	
		
	}
	
	public static VoosDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new VoosDAO();
		}
		return instance;
	}
	
	
	public void insert(Voos voo)throws InsertException{
		try {
			
			insert.setInt(1, voo.getCodVoo());
			insert.setString(2, voo.getClasse());
			insert.setInt(3,voo.getCod_dtHora());
			insert.setInt(4, voo.getCod_trecho());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir o voo");
		}
	}
	
	public void delete(Voos voo)throws DeleteException{
		try {
			delete.setInt(1, voo.getCodVoo());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar o voo");
		}
		
	}	
	
	public List<Voos> selectAll() throws SelectException {
		List<Voos> voos=new ArrayList<Voos>();
		Voos voo=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				voo=new Voos();
				voo.setCodVoo(rs.getInt("cod_voo"));
				voo.setClasse(rs.getString("classe"));
				voo.setCod_dtHora(rs.getInt("cod"));
				voo.setCod_trecho(rs.getInt("cod_trecho"));
				voos.add(voo);
			}
			return voos;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o voo");
		}
		
	}
	
	public void update(Voos voo)throws UpdateException{
		try {
			update.setString(1, voo.getClasse());
			update.setInt(2, voo.getCod_dtHora());
			update.setInt(3, voo.getCod_trecho());
			update.setInt(4, voo.getCodVoo());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar o voo");
		}
		
	}
	
	public Voos select(int cod) throws SelectException {
		Voos voo=null;
		
		try {
			select.setInt(1, cod);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				voo=new Voos();
				voo.setCodVoo(rs.getInt("cod_voo"));
				voo.setClasse(rs.getString("classe"));
				voo.setCod_dtHora(rs.getInt("cod"));
				voo.setCod_trecho(rs.getInt("cod_trecho"));
				
			}
			return voo;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o voo");
		}
	}
	
	
	
}
