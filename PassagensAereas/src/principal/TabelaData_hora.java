package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Data_hora;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaData_hora extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Data chegada","Hora chegada","Data saída","Hora saída"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllData_hora().size();
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
				return sistema.selectAllData_hora().get(rowIndex).getCod();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllData_hora().get(rowIndex).getData_che();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllData_hora().get(rowIndex).getHora_che();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllData_hora().get(rowIndex).getData_sai();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 4: {
			try {
				return sistema.selectAllData_hora().get(rowIndex).getHora_sai();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarData_hora(Data_hora data_hora) throws InsertException, SelectException {
		sistema.inserirData_hora(data_hora);
	}
	public void alterarData_hora(Data_hora c) throws UpdateException {
		sistema.atualizarData_hora(c);
		fireTableStructureChanged();

	}

	public void removerData_hora(int id) throws DeleteException, SelectException {
		Data_hora c=new Data_hora();
		c.setCod(id);
		for(Data_hora data_hora: sistema.selectAllData_hora()) {
			if(data_hora.equals(c)) {
				c=data_hora;
			}
		}
		sistema.deleteData_hora(c);
		fireTableStructureChanged();
	}
	

	public List<Data_hora> selectAllData_hora() {
		try {
			return sistema.selectAllData_hora();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Data_hora selectData_hora(int id) {
		try {
			return sistema.selectData_hora(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
