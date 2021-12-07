package dados;
import java.lang.StringBuilder;

public class Data_hora {
	private int cod;
	private  String data_che;
	private  String hora_che;
	private  String data_sai;
	private  String hora_sai;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod=cod;
	}
	
	public String getData_che() {
		return data_che;
	}
    public void setData_che(String data_che) {
		this.data_che=data_che;
	}
    
    public String getData_sai() {
		return data_sai;
	}
    public void setData_sai(String data_sai) {
		this.data_sai=data_sai;
	}
	
    public String getHora_che() {
		return hora_che;
	}
    public void setHora_che(String hora_che) {
		this.hora_che=hora_che;
	}
    
    public String getHora_sai() {
		return hora_sai;
	}
    public void setHora_sai(String hora_sai) {
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
