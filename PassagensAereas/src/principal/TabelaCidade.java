package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Cidade;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaCidade extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Cidade","Estado","País"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllCidade().size();
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
				return sistema.selectAllCidade().get(rowIndex).getCod_cid();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllCidade().get(rowIndex).getCidade();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllCidade().get(rowIndex).getEstado();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllCidade().get(rowIndex).getPais();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarCidade(Cidade cidade) throws InsertException, SelectException {
		sistema.inserirCidade(cidade);
	}
	public void alterarCidade(Cidade c) throws UpdateException {
		sistema.atualizarCidade(c);
		fireTableStructureChanged();

	}

	public void removerCidade(int id) throws DeleteException, SelectException {
		Cidade c=new Cidade();
		c.setCod_cid(id);
		for(Cidade cidade: sistema.selectAllCidade()) {
			if(cidade.equals(c)) {
				c=cidade;
			}
		}
		sistema.deleteCidade(c);
		fireTableStructureChanged();
	}
	

	public List<Cidade> selectAllCidade() {
		try {
			return sistema.selectAllCidade();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Cidade selectCidade(int id) {
		try {
			return sistema.selectCidade(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
