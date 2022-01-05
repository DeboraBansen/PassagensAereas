package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Aeronave;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class AeronaveDAO {
	
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static AeronaveDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	//private PreparedStatement newId;
	
	private AeronaveDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into aeronave values(?,?,?)");
		delete=conexao.prepareStatement("delete from aeronave where cod=?");
		update=conexao.prepareStatement("update aeronave set nome=?,qtd_poltrona=? where cod=?");
		select=conexao.prepareStatement("select *from aeronave where cod=?");
		selectAll=conexao.prepareStatement("select *from aeronave ");
		//newId=conexao.prepareStatement("select nextval('novo_cod_aeronave')");//verificar isso talvez o indice sequence ta bugando
		
	}
	
	public static AeronaveDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new AeronaveDAO();
		}
		return instance;
	}
	
	/*public int newId()throws SelectException{
		try {
			ResultSet rs=newId.executeQuery();
			//if(rs.getInt(int)) {
				return rs.getInt(1);
			//}
			//else {
				//return 0;
			//}
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel criar novo id");
		}
	}*/

	public void insert(Aeronave aeronave)throws InsertException{
		try {
			//aeronave.setCod(newId());
			insert.setInt(1,aeronave.getCod());
			insert.setString(2, aeronave.getNome());
			insert.setInt(3, aeronave.getQtd_poltrona());
			
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("problema no insert");
		}
	}
	
	public void delete(Aeronave aeronave)throws DeleteException{
		try {
			delete.setInt(1, aeronave.getCod());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar aeronave");
		}
		
	}	
	
	public List<Aeronave> selectAll() throws SelectException {
		List<Aeronave> aeronaves=new ArrayList<Aeronave>();
		Aeronave aeronave=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				aeronave=new Aeronave();
				aeronave.setCod(rs.getInt("cod"));
				aeronave.setNome(rs.getString("nome"));
				aeronave.setQtd_poltrona(rs.getInt("qtd_poltrona"));
				aeronaves.add(aeronave);
			}
			return aeronaves;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a aeronave");
		}
		
	}
	
	public void update(Aeronave aeronave)throws UpdateException{
		try {
			update.setString(1, aeronave.getNome());
			update.setInt(2, aeronave.getQtd_poltrona());
			update.setInt(3, aeronave.getCod());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar aeronave");
		}
		
	}
	
	public Aeronave select(int cod) throws SelectException {
		Aeronave aeronave=null;
		
		try {
			select.setInt(1, cod);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				aeronave=new Aeronave();
				aeronave.setCod(rs.getInt("cod"));
				aeronave.setNome(rs.getString("nome"));
				aeronave.setQtd_poltrona(rs.getInt("qtd_poltrona"));
				
			}
			return aeronave;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a aeronave");
		}
	}
	
	
}
