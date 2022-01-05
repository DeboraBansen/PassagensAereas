package dados;
import java.lang.StringBuilder;
import java.sql.Date;

public class Reserva {
	private int cod_res;
	private Date prazo_validade;
	private int cod_p;
	private int cod_voo;
	
	public int getCod_res() {
		return cod_res;
	}
	@SuppressWarnings("exports")
	public Date getDta_validade() {
		return prazo_validade;
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
	public void setDta_validade(@SuppressWarnings("exports") Date date) {
		this.prazo_validade=date;
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
		reserva.append("\tData Validade : "+this.prazo_validade+" \n");
		reserva.append("\tCódigo Passageiro : "+this.cod_p+" \n");
		reserva.append("\tCódigo do Voo : "+this.cod_voo+" \n");
		
		return reserva.toString();
	}
}
