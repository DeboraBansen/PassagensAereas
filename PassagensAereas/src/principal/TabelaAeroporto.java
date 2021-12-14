package principal;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import dados.Aeroporto;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaAeroporto extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunasAtributo= {"Código","Nome","Código da Cidade"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	public int getRowCount() {
		try {
			return sistema.selectAllAeroporto().size();
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
				return sistema.selectAllAeroporto().get(rowIndex).getCod();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllAeroporto().get(rowIndex).getNome();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllAeroporto().get(rowIndex).getCod_cid();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarAeroporto(Aeroporto aeroporto) throws InsertException, SelectException {
		sistema.inserirAeroporto(aeroporto);
	}
	public void alterarAeroporto(Aeroporto c) throws UpdateException {
		sistema.atualizarAeroporto(c);
		fireTableStructureChanged();

	}

	public void removerAeroporto(int id) throws DeleteException, SelectException {
		Aeroporto c=new Aeroporto();
		c.setCod(id);
		for(Aeroporto aeroporto: sistema.selectAllAeroporto()) {
			if(aeroporto.equals(c)) {
				c=aeroporto;
			}
		}
		sistema.deleteAeroporto(c);
		fireTableStructureChanged();
	}
	

	public List<Aeroporto> selectAllConsulta() {
		try {
			return sistema.selectAllAeroporto();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Aeroporto selectAeroporto(int id) {
		try {
			return sistema.selectAeroporto(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
