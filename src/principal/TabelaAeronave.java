package principal;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import dados.Aeronave;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaAeronave extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Nome","Quantidade de Poltrona"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllAeronave().size();
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
				return sistema.selectAllAeronave().get(rowIndex).getCod();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllAeronave().get(rowIndex).getNome();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllAeronave().get(rowIndex).getQtd_poltrona();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarAeronave(Aeronave aeronave) throws InsertException, SelectException {
		sistema.inserirAeronave(aeronave);
	}
	public void alterarAeronave(Aeronave c) throws UpdateException {
		sistema.atualizarAeronave(c);
		fireTableStructureChanged();

	}

	public void removerAeronave(int id) throws DeleteException, SelectException {
		Aeronave c=new Aeronave();
		c.setCod(id);
		for(Aeronave aeronave: sistema.selectAllAeronave()) {
			if(aeronave.equals(c)) {
				c=aeronave;
			}
		}
		sistema.deleteAeronave(c);
		fireTableStructureChanged();
	}
	

	public List<Aeronave> selectAllAeronave() {
		try {
			return sistema.selectAllAeronave();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Aeronave selectAeronave(int id) {
		try {
			return sistema.selectAeronave(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
