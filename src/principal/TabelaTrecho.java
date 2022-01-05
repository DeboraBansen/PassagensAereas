package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Trecho;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaTrecho extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Código Cidade de origem","Código Cidade de destino",
			"Código do assento","Código Aeroporto de origem","Código Aeroporto de destino"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllTrecho().size();
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
				return sistema.selectAllTrecho().get(rowIndex).getCod_trecho();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllTrecho().get(rowIndex).getOrigem();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllTrecho().get(rowIndex).getDestino();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllTrecho().get(rowIndex).getCod_assento();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 4: {
			try {
				return sistema.selectAllTrecho().get(rowIndex).getAero_origem();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 5: {
			try {
				return sistema.selectAllTrecho().get(rowIndex).getAero_destino();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarTrecho(Trecho trecho) throws InsertException, SelectException {
		sistema.inserirTrecho(trecho);
	}
	public void alterarTrecho(Trecho c) throws UpdateException {
		sistema.atualizarTrecho(c);
		fireTableStructureChanged();

	}

	public void removerTrecho(int id) throws DeleteException, SelectException {
		Trecho c=new Trecho();
		c.setCod_trecho(id);
		for(Trecho trecho: sistema.selectAllTrecho()) {
			if(trecho.equals(c)) {
				c=trecho;
			}
		}
		sistema.deleteTrecho(c);
		fireTableStructureChanged();
	}
	

	public List<Trecho> selectAllTrecho() {
		try {
			return sistema.selectAllTrecho();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Trecho selectTrecho(int id) {
		try {
			return sistema.selectTrecho(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
