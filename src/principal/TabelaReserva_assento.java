package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Reserva_assento;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaReserva_assento extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Data da reserva","Numero da Poltrona","Código do Aeronave"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllReserva_assento().size();
		} catch (SelectException e) {
			e.getMessage();
		}
		return 0;
	}

	public int getColumnCount() {
		return colunasAtributo.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: {
			try {
				return sistema.selectAllReserva_assento().get(rowIndex).getCod_assento();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllReserva_assento().get(rowIndex).getData_reserva();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllReserva_assento().get(rowIndex).getNum_poltrona();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllReserva_assento().get(rowIndex).getCod();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarReserva_assento(Reserva_assento reserva_assento) throws InsertException, SelectException {
		sistema.inserirReserva_assento(reserva_assento);
	}
	public void alterarReserva_assento(Reserva_assento c) throws UpdateException {
		sistema.atualizarReserva_assento(c);
		fireTableStructureChanged();

	}

	public void removerReserva_assento(int id) throws DeleteException, SelectException {
		Reserva_assento c=new Reserva_assento();
		c.setCod_assento(id);
		for(Reserva_assento reserva_assento: sistema.selectAllReserva_assento()) {
			if(reserva_assento.equals(c)) {
				c=reserva_assento;
			}
		}
		sistema.deleteReserva_assento(c);
		fireTableStructureChanged();
	}
	

	public List<Reserva_assento> selectAllReserva_assento() {
		try {
			return sistema.selectAllReserva_assento();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Reserva_assento selectReserva_assento(int id) {
		try {
			return sistema.selectReserva_assento(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
