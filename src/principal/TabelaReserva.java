package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Reserva;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaReserva extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Data de Validade","Código do passageiro","Código do Voo"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllReserva().size();
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
				return sistema.selectAllReserva().get(rowIndex).getCod_res();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllReserva().get(rowIndex).getDta_validade();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllReserva().get(rowIndex).getCod_p();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllReserva().get(rowIndex).getCod_voo();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarReserva(Reserva reserva) throws InsertException, SelectException {
		sistema.inserirReserva(reserva);
	}
	public void alterarReserva(Reserva c) throws UpdateException {
		sistema.atualizarReserva(c);
		fireTableStructureChanged();

	}

	public void removerReserva(int id) throws DeleteException, SelectException {
		Reserva c=new Reserva();
		c.setCod_res(id);
		for(Reserva reserva: sistema.selectAllReserva()) {
			if(reserva.equals(c)) {
				c=reserva;
			}
		}
		sistema.deleteReserva(c);
		fireTableStructureChanged();
	}
	

	public List<Reserva> selectAllReserva() {
		try {
			return sistema.selectAllReserva();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Reserva selectReserva(int id) {
		try {
			return sistema.selectReserva(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
