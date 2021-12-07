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
}
