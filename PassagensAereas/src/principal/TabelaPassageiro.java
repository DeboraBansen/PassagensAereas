package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Passageiro;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaPassageiro extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Nome"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllPassageiro().size();
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
				return sistema.selectAllPassageiro().get(rowIndex).getCod_p();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllPassageiro().get(rowIndex).getNome();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarPassageiro(Passageiro passageiro) throws InsertException, SelectException {
		sistema.inserirPassageiro(passageiro);
	}
	public void alterarPassageiro(Passageiro c) throws UpdateException {
		sistema.atualizarPassageiro(c);
		fireTableStructureChanged();

	}

	public void removerPassageiro(int id) throws DeleteException, SelectException {
		Passageiro c=new Passageiro();
		c.setCod_p(id);
		for(Passageiro passageiro: sistema.selectAllPassageiro()) {
			if(passageiro.equals(c)) {
				c=passageiro;
			}
		}
		sistema.deletePassageiro(c);
		fireTableStructureChanged();
	}
	

	public List<Passageiro> selectAllPassageiro() {
		try {
			return sistema.selectAllPassageiro();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Passageiro selectPassageiro(int id) {
		try {
			return sistema.selectPassageiro(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
