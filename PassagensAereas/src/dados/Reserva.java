package dados;
import java.lang.StringBuilder;

public class Reserva {
	private int cod_res;
	private String data_validade;
	private int cod_p;
	private int cod_voo;
	
	public int getCod_res() {
		return cod_res;
	}
	public String getDta_validade() {
		return data_validade;
	}
	public int getCod_p() {
		return cod_p;
	}
	public int getCod_voo() {
		return cod_voo;
	}
	
	public void setCod_res(int cod_res) {
		this.cod_res=cod_res;
	}
	public void setDta_validade(String dta_validade) {
		this.data_validade=dta_validade;
	}
	public void setCod_p(int cod_p) {
		this.cod_p=cod_p;
	}
	public void setCod_voo(int cod_voo) {
		this.cod_voo=cod_voo;
	}
	
	public String toString() {
		StringBuilder reserva=new StringBuilder();
		
		reserva.append("\tCódigo : "+this.cod_res+" \n");
		reserva.append("\tData Validade : "+this.data_validade+" \n");
		reserva.append("\tCódigo Passageiro : "+this.cod_p+" \n");
		reserva.append("\tCódigo do Voo : "+this.cod_voo+" \n");
		
		return reserva.toString();
	}
}
