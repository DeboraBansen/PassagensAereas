package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Voos;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaVoos extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Classe","Código data/hora","Código do trecho"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllVoos().size();
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
				return sistema.selectAllVoos().get(rowIndex).getCodVoo();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllVoos().get(rowIndex).getClasse();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllVoos().get(rowIndex).getCod_dtHora();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllVoos().get(rowIndex).getCod_trecho();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarVoos(Voos voos) throws InsertException, SelectException {
		sistema.inserirVoos(voos);
	}
	public void alterarVoos(Voos c) throws UpdateException {
		sistema.atualizarVoos(c);
		fireTableStructureChanged();

	}

	public void removerVoos(int id) throws DeleteException, SelectException {
		Voos c=new Voos();
		c.setCodVoo(id);
		for(Voos voo: sistema.selectAllVoos()) {
			if(voo.equals(c)) {
				c=voo;
			}
		}
		sistema.deleteVoos(c);
		fireTableStructureChanged();
	}
	

	public List<Voos> selectAllVoos() {
		try {
			return sistema.selectAllVoos();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Voos selectVoos(int id) {
		try {
			return sistema.selectVoos(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
