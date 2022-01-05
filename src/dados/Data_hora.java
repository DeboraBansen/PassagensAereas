package dados;
import java.lang.StringBuilder;
import java.sql.Date;
import java.sql.Time;

public class Data_hora {
	private int cod;
	private  Date data_che;
	private  Time hora_che;
	private  Date data_sai;
	private  Time hora_sai;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod=cod;
	}
	
	@SuppressWarnings("exports")
	public Date getData_che() {
		return data_che;
	}
    public void setData_che(@SuppressWarnings("exports") Date data_che) {
		this.data_che=data_che;
	}
    
    @SuppressWarnings("exports")
	public Date getData_sai() {
		return data_sai;
	}
    public void setData_sai(@SuppressWarnings("exports") Date data_sai) {
		this.data_sai=data_sai;
	}
	
    @SuppressWarnings("exports")
	public Time getHora_che() {
		return hora_che;
	}
    public void setHora_che(@SuppressWarnings("exports") Time hora_che) {
		this.hora_che=hora_che;
	}
    
    @SuppressWarnings("exports")
	public Time getHora_sai() {
		return hora_sai;
	}
    public void setHora_sai(@SuppressWarnings("exports") Time hora_sai) {
		this.hora_sai=hora_sai;
	}
    
    public String toString() {
		StringBuilder data_hora=new StringBuilder();
		
		data_hora.append("\tCódigo : "+this.cod+" \n");
		data_hora.append("\t Data Chegada : "+this.data_che+" \n");
		data_hora.append("\t Hora Chegada : "+this.hora_che+" \n");
		data_hora.append("\t Data Saída : "+this.data_sai+" \n");
		data_hora.append("\t Hora Saída : "+this.hora_sai+" \n");
		
		
		return data_hora.toString();
	}
}
