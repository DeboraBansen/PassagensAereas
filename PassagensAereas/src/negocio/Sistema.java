package negocio;
import java.sql.SQLException;
import java.util.List;
import dados.*;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import persistencia.*;

public class Sistema {
	private static Sistema instance=null;
	private AeronaveDAO aeronaveDAO;
	private AeroportoDAO aeroportoDAO;
	private CidadeDAO cidadeDAO;
	private Data_horaDAO data_horaDAO;
	private PassageiroDAO passageiroDAO;
	private Reserva_assentoDAO reserva_assentoDAO;
	private ReservaDAO reservaDAO;
	private TrechoDAO trechoDAO;
	private VoosDAO voosDAO;
	
	private Sistema(String senha)throws ClassNotFoundException,SQLException,SelectException{
		Conexao.setSenha(senha);
		aeronaveDAO=AeronaveDAO.getInstance();
		aeroportoDAO=AeroportoDAO.getInstance();
		cidadeDAO=CidadeDAO.getInstance();
		data_horaDAO=Data_horaDAO.getInstance();
		passageiroDAO=PassageiroDAO.getInstance();
		reserva_assentoDAO=Reserva_assentoDAO.getInstance();
		reservaDAO=ReservaDAO.getInstance();
		trechoDAO=TrechoDAO.getInstance();
		voosDAO=VoosDAO.getInstance();
	}
	
	public static Sistema getInstance(String senha)  {
		if(instance==null) {
			try {
				instance=new Sistema(senha);
			} catch (ClassNotFoundException | SQLException | SelectException e) {
				System.out.print("sistema deu erro");
				e.getMessage();
			}
		}
		return instance;
	}
	//hswyqft
	public void inserirAeronave(Aeronave p)throws InsertException,SelectException{
		aeronaveDAO.insert(p);
	}
	public void inserirAeroporto(Aeroporto m)throws InsertException,SelectException{
		aeroportoDAO.insert(m);
	}
	public void inserirCidade(Cidade c)throws InsertException,SelectException{
		cidadeDAO.insert(c);
	}
	public void inserirData_hora(Data_hora c)throws InsertException,SelectException{
		data_horaDAO.insert(c);
	}
	public void inserirPassageiro(Passageiro c)throws InsertException,SelectException{
		passageiroDAO.insert(c);
	}
	public void inserirReserva_assento(Reserva_assento c)throws InsertException,SelectException{
		reserva_assentoDAO.insert(c);
	}
	public void inserirReserva(Reserva c)throws InsertException,SelectException{
		reservaDAO.insert(c);
	}
	public void inserirTrecho(Trecho c)throws InsertException,SelectException{
		trechoDAO.insert(c);
	}
	public void inserirVoos(Voos c)throws InsertException,SelectException{
		voosDAO.insert(c);
	}
	
	public List<Aeronave> selectAllAeronave() throws SelectException{
		return aeronaveDAO.selectAll();
	}
	public List<Aeroporto> selectAllAeroporto() throws SelectException{
		return aeroportoDAO.selectAll();
	}
	public List<Cidade> selectAllCidade() throws SelectException{
		return cidadeDAO.selectAll();
	}
	public List<Data_hora> selectAllData_hora() throws SelectException{
		return data_horaDAO.selectAll();
	}
	public List<Passageiro> selectAllPassageiro() throws SelectException{
		return passageiroDAO.selectAll();
	}
	public List<Reserva_assento> selectAllReserva_assento() throws SelectException{
		return reserva_assentoDAO.selectAll();
	}
	public List<Reserva> selectAllReserva() throws SelectException{
		return reservaDAO.selectAll();
	}
	public List<Trecho> selectAllTrecho() throws SelectException{
		return trechoDAO.selectAll();
	}
	public List<Voos> selectAllVoos() throws SelectException{
		return voosDAO.selectAll();
	}
	

	public Aeronave selectAeronave(int id) throws SelectException {
		return aeronaveDAO.select(id);
	}
	public Aeroporto selectAeroporto(int id) throws SelectException {
		return aeroportoDAO.select(id);
	}
	public Cidade selectCidade(int id) throws SelectException {
		return cidadeDAO.select(id);
	}
	public Data_hora selectData_hora(int id) throws SelectException {
		return data_horaDAO.select(id);
	}
	public Passageiro selectPassageiro(int id) throws SelectException {
		return passageiroDAO.select(id);
	}
	public Reserva_assento selectReserva_assento(int id) throws SelectException {
		return reserva_assentoDAO.select(id);
	}
	public Reserva selectReserva(int id) throws SelectException {
		return reservaDAO.select(id);
	}
	public Trecho selectTrecho(int id) throws SelectException {
		return trechoDAO.select(id);
	}
	public Voos selectVoos(int id) throws SelectException {
		return voosDAO.select(id);
	}
	
	
	public void deleteAeronave(Aeronave p)throws DeleteException{
		aeronaveDAO.delete(p);
	}
	public void deleteAeroporto(Aeroporto m)throws DeleteException{
		aeroportoDAO.delete(m);
	}
	public void deleteCidade(Cidade c)throws DeleteException{
		cidadeDAO.delete(c);
	}
	public void deleteData_hora(Data_hora p)throws DeleteException{
		data_horaDAO.delete(p);
	}
	public void deletePassageiro(Passageiro m)throws DeleteException{
		passageiroDAO.delete(m);
	}
	public void deleteReserva_assento(Reserva_assento c)throws DeleteException{
		reserva_assentoDAO.delete(c);
	}
	public void deleteReserva(Reserva p)throws DeleteException{
		reservaDAO.delete(p);
	}
	public void deleteTrecho(Trecho m)throws DeleteException{
		trechoDAO.delete(m);
	}
	public void deleteVoos(Voos c)throws DeleteException{
		voosDAO.delete(c);
	}
	
	
	public void atualizarAeronave(Aeronave m)throws UpdateException{
		aeronaveDAO.update(m);
	}
	public void atualizarAeroporto(Aeroporto c)throws UpdateException{
		aeroportoDAO.update(c);
	}
	public void atualizarCidade(Cidade c)throws UpdateException{
		cidadeDAO.update(c);
	}
	public void atualizarData_hora(Data_hora p)throws UpdateException{
		data_horaDAO.update(p);
	}
	public void atualizarPassageiro(Passageiro m)throws UpdateException{
		passageiroDAO.update(m);
	}
	public void atualizarReserva_assento(Reserva_assento c)throws UpdateException{
		reserva_assentoDAO.update(c);
	}
	public void atualizarReserva(Reserva p)throws UpdateException{
		reservaDAO.update(p);
	}
	public void atualizarTrecho(Trecho c)throws UpdateException{
		trechoDAO.update(c);
	}
	public void atualizarVoos(Voos p)throws UpdateException{
		voosDAO.update(p);
	}
	
}
