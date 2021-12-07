package dados;
import java.lang.StringBuilder;

public class Reserva_assento {
	private int cod_assento;
	private String data_reserva;
	private int num_poltrona;
	private int cod_aero;
	
	public int getCod_assento() {
		return cod_assento;
	}
	public String getData_reserva() {
		return data_reserva;
	}
	public int getNum_poltrona() {
		return num_poltrona;
	}
	public int getCod_aero() {
		return cod_aero;
	}
	
	public void setCod_assento(int cod_assento) {
		this.cod_assento=cod_assento;
	}
	public void setData_reserva(String data_reserva) {
		this.data_reserva=data_reserva;
	}
	public void setNum_poltrona(int num_poltrona) {
		this.num_poltrona=num_poltrona;
	}
	public void setCod_aero(int cod_aero) {
		this.cod_aero=cod_aero;
	}
	
	public String toString() {
		StringBuilder reserva_assento=new StringBuilder();
		
		reserva_assento.append("\tCódigo : "+this.cod_assento+" \n");
		reserva_assento.append("\tData Reserva : "+this.data_reserva+" \n");
		reserva_assento.append("\tNúmero de Poltronas : "+this.num_poltrona+" \n");
		reserva_assento.append("\tCódigo da Aeronave : "+this.cod_aero+" \n");
		
		return reserva_assento.toString();
	}
}
