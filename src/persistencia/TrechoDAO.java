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
	
	
	private TrechoDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into trecho values(?,?,?,?,?,?)");
		delete=conexao.prepareStatement("delete from trecho where cod_trecho=?");
		update=conexao.prepareStatement("update trecho set origem=?,destino=?,cod_assento=?,aero_origem=?,aero_destino=? where cod_trecho=?");
		select=conexao.prepareStatement("select *from trecho where cod_trecho=?");
		selectAll=conexao.prepareStatement("select *from trecho ");
		
		
	}
	
	public static TrechoDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new TrechoDAO();
		}
		return instance;
	}
	
	
	
	public void insert(Trecho trecho)throws InsertException{
		try {
			
			insert.setInt(1, trecho.getCod_trecho());
			insert.setInt(2, trecho.getOrigem());
			insert.setInt(3,trecho.getDestino());
			insert.setInt(4, trecho.getCod_assento());
			insert.setInt(4, trecho.getAero_origem());
			insert.setInt(4, trecho.getAero_destino());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir o trecho");
		}
	}
	
	public void delete(Trecho trecho)throws DeleteException{
		try {
			delete.setInt(1, trecho.getCod_trecho());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar o trecho");
		}
		
	}	
	
	public List<Trecho> selectAll() throws SelectException {
		List<Trecho> trechos=new ArrayList<Trecho>();
		Trecho trecho=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				trecho=new Trecho();
				trecho.setCod_trecho(rs.getInt("cod_trecho"));
				trecho.setOrigem(rs.getInt("origem"));
				trecho.setDestino(rs.getInt("destino"));
				trecho.setCod_assento(rs.getInt("cod_assento"));
				trecho.setAero_origem(rs.getInt("aero_origem"));
				trecho.setAero_destino(rs.getInt("aero_destino"));
				trechos.add(trecho);
			}
			return trechos;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o trecho");
		}
		
	}
	
	public void update(Trecho trecho)throws UpdateException{
		try {
			update.setInt(1, trecho.getOrigem());
			update.setInt(2, trecho.getDestino());
			update.setInt(3, trecho.getCod_assento());
			update.setInt(4, trecho.getAero_origem());
			update.setInt(5, trecho.getAero_destino());
			update.setInt(6, trecho.getCod_trecho());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar o trecho");
		}
		
	}
	
	public Trecho select(int cod) throws SelectException {
		Trecho trecho=null;
		
		try {
			select.setInt(1, cod);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				trecho=new Trecho();
				trecho.setCod_trecho(rs.getInt("cod_trecho"));
				trecho.setOrigem(rs.getInt("origem"));
				trecho.setDestino(rs.getInt("destino"));
				trecho.setCod_assento(rs.getInt("cod_assento"));
				trecho.setAero_origem(rs.getInt("aero_origem"));
				trecho.setAero_destino(rs.getInt("aero_destino"));
			}
			return trecho;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar O trecho");
		}
	}
	
	
	
	
}
