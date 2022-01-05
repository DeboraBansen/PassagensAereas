package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dados.*;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class Passagem extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painel=new JPanel();
	private JScrollPane painelScrollTabela =new JScrollPane();
	
	//cadastrar aeronave
	private TabelaAeronave tabelaAeronave=new TabelaAeronave();
	private JTable mostrarAeronave;
	private JPanel painelCadastrarAeronave=new JPanel();	
	private JLabel nomeAeronave=new JLabel("Digite o nome da aeronave:");
	private JLabel qtd_poltrona=new JLabel("Digite a quantidade de poltronas:");
	private JTextField textoNomeAeronave =new JTextField();
	private JTextField textoQtdPoltronaAeronave =new JTextField();
	private JButton botaoAdicionarAeronave=new JButton("Cadastrar Aeronave");
	private JButton botaoMostrarAeronave=new JButton("Mostrar Aeronave");
	private JButton botaoOk=new JButton("OK");
	
	//alterar aeronave
	private JPanel painelAlterarAeronave=new JPanel();
	private JPanel painelAltera=new JPanel();
	private JLabel escolhaIdAeronave=new JLabel("Escolha o id da aeronave que deseja alterar:");
	private JTextField textoIdAeronave =new JTextField();
	private JButton botaoOkAlterarAeronave=new JButton("OK");
	private JLabel nomeAeronaveAlterar=new JLabel("Digite o nome do medico:");
	private JLabel poltronaAeronaveAlterar=new JLabel("Digite a idade do medico:");
	private JTextField textoNomeAeronaveAlterar =new JTextField();
	private JTextField textopoltronaAeronaveAlterar =new JTextField();
	private JButton botaoAlterarAeronave=new JButton("Alterar Aeronave");
	private JButton botaoAeronaveAlterado=new JButton("Alterar");
	
	//deletar aeronave
	private JButton botaoRemoverAeronave=new JButton("Remover Aeronave");
	private JTextField textoIdRemoverAeronave =new JTextField();
	private JLabel escolhaIdRemoverAeronave=new JLabel("Escolha o id da aeronave que deseja remover:");
	private JPanel painelRemoverAeronave=new JPanel();
	private JButton botaoOkRemove=new JButton("OK");
	
	//cadastrar passageiro
	private JButton botaoMostrarPassageiro=new JButton("Mostrar Passageiro");
	private JTable mostrarPassageiro;
	private TabelaPassageiro tabelaPassageiro=new TabelaPassageiro();
	private JPanel painelCadastrarPassageiro=new JPanel();
	private JLabel nomePassageiro=new JLabel("Digite o nome do passageiro:");
	private JTextField textoNomePassageiro =new JTextField();
	private JButton botaoOkPassageiro=new JButton("OK");
	private JButton botaoAdicionarPassageiro=new JButton("Cadastrar Passageiro");
	
	//alterar passageiro
	private JPanel painelAlterarPassageiro=new JPanel();
	private JPanel painelAlteraPassageiro=new JPanel();
	private JLabel escolhaIdPassageiro=new JLabel("Escolha o id do passageiro que deseja alterar:");
	private JTextField textoIdPassageiro =new JTextField();
	private JButton botaoOkAlterarPassageiro=new JButton("OK");
	private JLabel nomePassageiroAlterar=new JLabel("Digite o nome do passageiro:");
	private JTextField textoNomePassageiroAlterar =new JTextField();
	private JButton botaoAlterarPassageiro=new JButton("Alterar Passageiro");
	private JButton botaoPassageiroAlterado=new JButton("Alterar");
	
	//remover passageiro
	private JButton botaoRemoverPassageiro=new JButton("Remover Passageiro");
	private JTextField textoIdRemoverPassageiro =new JTextField();
	private JLabel escolhaIdRemoverPassageiro=new JLabel("Escolha o id do passageiro que deseja remover:");
	private JPanel painelRemoverPassageiro=new JPanel();
	private JButton botaoOkRemovePassageiro=new JButton("OK");
	
	//cadastrar aeroporto
	private JButton botaoMostrarAeroporto=new JButton("Mostrar Aeroporto");
	private JTable mostrarAeroporto;
	private TabelaAeroporto tabelaAeroporto=new TabelaAeroporto();
	private JPanel painelCadastrarAeroporto=new JPanel();
	private JLabel nomeAeroporto=new JLabel("Digite o nome do Aeroporto:");
	private JTextField textoNomeAeroporto =new JTextField();
	private JLabel cod_cidAeroporto=new JLabel("Digite o código da cidade do Aeroporto:");
	private JTextField textoCod_cidAeroporto =new JTextField();
	private JButton botaoOkAeroporto=new JButton("OK");
	private JButton botaoAdicionarAeroporto=new JButton("Cadastrar Aeroporto");
	
	//alterar aeroporto
	private JPanel painelAlterarAeroporto=new JPanel();
	private JPanel painelAlteraAeroporto=new JPanel();
	private JLabel escolhaIdAeroporto=new JLabel("Escolha o id do Aeroporto que deseja alterar:");
	private JTextField textoIdAeroporto =new JTextField();
	private JButton botaoOkAlterarAeroporto=new JButton("OK");
	private JLabel nomeAeroportoAlterar=new JLabel("Digite o nome do Aeroporto:");
	private JTextField textoNomeAeroportoAlterar =new JTextField();
	private JLabel cod_cidAeroportoAlterar=new JLabel("Digite o codigo da cidade do Aeroporto:");
	private JTextField textoCod_cidAeroportoAlterar =new JTextField();
	private JButton botaoAlterarAeroporto=new JButton("Alterar Aeroporto");
	private JButton botaoAeroportoAlterado=new JButton("Alterar");
	
	//remover aeroporto
	private JButton botaoRemoverAeroporto=new JButton("Remover Aeroporto");
	private JTextField textoIdRemoverAeroporto =new JTextField();
	private JLabel escolhaIdRemoverAeroporto=new JLabel("Escolha o id do Aeroporto que deseja remover:");
	private JPanel painelRemoverAeroporto=new JPanel();
	private JButton botaoOkRemoveAeroporto=new JButton("OK");
	
	//cadastrar cidade
	private JButton botaoMostrarCidade=new JButton("Mostrar Cidade");
	private JTable mostrarCidade;
	private TabelaCidade tabelaCidade=new TabelaCidade();
	private JPanel painelCadastrarCidade=new JPanel();
	private JLabel nomeCidade=new JLabel("Digite o nome da cidade:");
	private JTextField textoNomeCidade =new JTextField();
	private JLabel nomeEstado=new JLabel("Digite o nome do Estado:");
	private JTextField textoNomeEstado =new JTextField();
	private JLabel nomePais=new JLabel("Digite o nome do Pais:");
	private JTextField textoNomePais =new JTextField();
	private JButton botaoOkCidade=new JButton("OK");
	private JButton botaoAdicionarCidade=new JButton("Cadastrar Cidade");
	
	//alterar cidade
	private JPanel painelAlterarCidade=new JPanel();
	private JPanel painelAlteraCidade=new JPanel();
	private JLabel escolhaIdCidade=new JLabel("Escolha o id da cidade que deseja alterar:");
	private JTextField textoIdCidade =new JTextField();
	private JButton botaoOkAlterarCidade=new JButton("OK");
	private JLabel nomeCidadeAlterar=new JLabel("Digite o nome da cidade:");
	private JTextField textoNomeCidadeAlterar =new JTextField();
	private JLabel nomeEstadoAlterar=new JLabel("Digite o nome do Estado:");
	private JTextField textoNomeEstadoAlterar =new JTextField();
	private JLabel nomePaisAlterar=new JLabel("Digite o nome do Pais:");
	private JTextField textoNomePaisAlterar =new JTextField();
	private JButton botaoAlterarCidade=new JButton("Alterar Cidade");
	private JButton botaoCidadeAlterado=new JButton("Alterar");
	
	//remover cidade
	private JButton botaoRemoverCidade=new JButton("Remover Cidade");
	private JTextField textoIdRemoverCidade =new JTextField();
	private JLabel escolhaIdRemoverCidade=new JLabel("Escolha o id da cidade que deseja remover:");
	private JPanel painelRemoverCidade=new JPanel();
	private JButton botaoOkRemoveCidade=new JButton("OK");
	
	//cadastrar reserva
	private JButton botaoMostrarReserva=new JButton("Mostrar Reserva");
	private JTable mostrarReserva;
	private TabelaReserva tabelaReserva=new TabelaReserva();
	private JPanel painelCadastrarReserva=new JPanel();
	private JLabel data_validadeReserva=new JLabel("Digite a data de validade da Reserva:");
	private JTextField textodata_validadeReserva =new JTextField();
	private JLabel cod_pReserva=new JLabel("Digite o codigo do passageiro da Reserva:");
	private JTextField textoCod_pReserva =new JTextField();
	private JLabel cod_vooReserva=new JLabel("Digite o codigo do voo da Reserva:");
	private JTextField textoCod_vooReserva =new JTextField();
	private JButton botaoOkReserva=new JButton("OK");
	private JButton botaoAdicionarReserva=new JButton("Cadastrar Reserva");
	
	//alterar reserva
	private JPanel painelAlterarReserva=new JPanel();
	private JPanel painelAlteraReserva=new JPanel();
	private JLabel escolhaIdReserva=new JLabel("Escolha o id da Reserva que deseja alterar:");
	private JTextField textoIdReserva =new JTextField();
	private JButton botaoOkAlterarReserva=new JButton("OK");
	private JLabel data_validadeReservaAlterar=new JLabel("Digite a data de validade da Reserva:");
	private JTextField textoData_validadeAlterar =new JTextField();
	private JLabel cod_pReservaAlterar=new JLabel("Digite o codigo do passageiro da Reserva:");
	private JTextField textoCod_pAlterar =new JTextField();
	private JLabel cod_vooReservaAlterar=new JLabel("Digite o codigo do voo da Reserva:");
	private JTextField textoCod_vooAlterar =new JTextField();
	private JButton botaoAlterarReserva=new JButton("Alterar Reserva");
	private JButton botaoReservaAlterado=new JButton("Alterar");
	
	//remover reserva
	private JButton botaoRemoverReserva=new JButton("Remover Reserva");
	private JTextField textoIdRemoverReserva =new JTextField();
	private JLabel escolhaIdRemoverReserva=new JLabel("Escolha o id da reserva que deseja remover:");
	private JPanel painelRemoverReserva=new JPanel();
	private JButton botaoOkRemoveReserva=new JButton("OK");
	
	//cadastrar voo
	private JButton botaoMostrarVoo=new JButton("Mostrar Voo");
	private JTable mostrarVoo;
	private TabelaVoos tabelaVoo=new TabelaVoos();
	private JPanel painelCadastrarVoo=new JPanel();
	private JLabel classeVoo=new JLabel("Digite a classe do voo:");
	private JTextField textoClasseVoo =new JTextField();
	private JLabel cod_dthoraVoo=new JLabel("Digite o codigo da data e hora do voo:");
	private JTextField textoCod_dthoraVoo =new JTextField();
	private JLabel cod_trechoVoo=new JLabel("Digite o codigo do trecho do voo:");
	private JTextField textoCod_trechoVoo =new JTextField();
	private JButton botaoOkVoo=new JButton("OK");
	private JButton botaoAdicionarVoo=new JButton("Cadastrar Voo");
	
	//alterar voo
	private JPanel painelAlterarVoo=new JPanel();
	private JPanel painelAlteraVoo=new JPanel();
	private JLabel escolhaIdVoo=new JLabel("Escolha o id do voo que deseja alterar:");
	private JTextField textoIdVoo =new JTextField();
	private JButton botaoOkAlterarVoo=new JButton("OK");
	private JLabel classeVooAlterar=new JLabel("Digite a classe do voo para alterar:");
	private JTextField textoClasseVooAlterar =new JTextField();
	private JLabel cod_dthoraVooAlterar=new JLabel("Digite o codigo da data e hora do voo para alterar:");
	private JTextField textoCod_dthoraVooAlterar =new JTextField();
	private JLabel cod_trechoVooAlterar=new JLabel("Digite o codigo do trecho do voo para alterar:");
	private JTextField textoCod_trechoVooAlterar =new JTextField();
	private JButton botaoAlterarVoo=new JButton("Alterar Voo");
	private JButton botaoVooAlterado=new JButton("Alterar");
	
	//remover voo
	private JButton botaoRemoverVoo=new JButton("Remover Voo");
	private JTextField textoIdRemoverVoo =new JTextField();
	private JLabel escolhaIdRemoverVoo=new JLabel("Escolha o id do voo que deseja remover:");
	private JPanel painelRemoverVoo=new JPanel();
	private JButton botaoOkRemoveVoo=new JButton("OK");
	
	//cadastrar reserva_assento
	private JButton botaoMostrarReserva_assento=new JButton("MostrarRes_Assento");
	private JTable mostrarReserva_assento;
	private TabelaReserva_assento tabelaReserva_assento=new TabelaReserva_assento();
	private JPanel painelCadastrarReserva_assento=new JPanel();
	private JLabel num_poltrReserva_assento=new JLabel("Digite o numero da poltrona da reserva de assento:");
	private JTextField textoNum_poltronaReserva_assento =new JTextField();
	private JLabel data_resReserva_assento=new JLabel("Digite a data da reserva do assento:");
	private JTextField textodata_resReserva_assento =new JTextField();
	private JLabel cod_aeroReserva_assento=new JLabel("Digite o codigo da aeronave:");
	private JTextField textocod_aeroReserva_assento =new JTextField();
	private JButton botaoOkReserva_assento=new JButton("OK");
	private JButton botaoAdicionarReserva_assento=new JButton("Reservar Assento");
	
	//alterar reserva_assento
	private JPanel painelAlterarReserva_assento=new JPanel();
	private JPanel painelAlteraReserva_assento=new JPanel();
	private JLabel escolhaIdReserva_assento=new JLabel("Escolha o id da Reserva de assento que deseja alterar:");
	private JTextField textoIdReserva_assento =new JTextField();
	private JButton botaoOkAlterarReserva_assento=new JButton("OK");
	private JLabel num_poltrReserva_assentoAlterar=new JLabel("Digite o numero da poltrona da reserva de assento:");
	private JTextField textoNum_poltronaAlterar =new JTextField();
	private JLabel data_resReserva_assentoAlterar=new JLabel("Digite a data da reserva do assento:");
	private JTextField textoData_reservaAlterar =new JTextField();
	private JLabel cod_aeroReserva_assentoAlterar=new JLabel("Digite o codigo da aeronave:");
	private JTextField textoCod_aeroAlterar =new JTextField();
	private JButton botaoAlterarReserva_assento=new JButton("AlterarRes_Assento");
	private JButton botaoReserva_assentoAlterado=new JButton("Alterar");
	
	//remover reserva_assento
	private JButton botaoRemoverReserva_assento=new JButton("RemoveRes_assento");
	private JTextField textoIdRemoverReserva_assento =new JTextField();
	private JLabel escolhaIdRemoverReserva_assento=new JLabel("Escolha o id da Reserva de assento que deseja remover:");
	private JPanel painelRemoverReserva_assento=new JPanel();
	private JButton botaoOkRemoveReserva_assento=new JButton("OK");
	
	//cadastrar trecho
	private JButton botaoMostrarTrecho=new JButton("Mostrar Trecho");
	private JTable mostrarTrecho;
	private TabelaTrecho tabelaTrecho=new TabelaTrecho();
	private JPanel painelCadastrarTrecho=new JPanel();
	private JLabel origemTrecho=new JLabel("Digite o codigo de origem do trecho:");
	private JTextField textoOrigemTrecho =new JTextField();
	private JLabel destinoTrecho=new JLabel("Digite o codigo de destino do trecho:");
	private JTextField textoDestinoTrecho =new JTextField();
	private JLabel cod_assentoTrecho=new JLabel("Digite o codigo da reserva de assento do trecho:");
	private JTextField textoCod_assentoTrecho =new JTextField();
	private JLabel aero_origemTrecho=new JLabel("Digite o codigo do aeroporto de origem do trecho:");
	private JTextField textoAero_origemTrecho =new JTextField();
	private JLabel aero_destinoTrecho=new JLabel("Digite o codigo do aeroporto de destino do trecho:");
	private JTextField textoAero_destinoTrecho =new JTextField();
	private JButton botaoOkTrecho=new JButton("OK");
	private JButton botaoAdicionarTrecho=new JButton("Cadastrar Trecho");
	
	//alterar trecho
	private JPanel painelAlterarTrecho=new JPanel();
	private JPanel painelAlteraTrecho=new JPanel();
	private JLabel escolhaIdTrecho=new JLabel("Escolha o id do Trecho que deseja alterar:");
	private JTextField textoIdTrecho =new JTextField();
	private JButton botaoOkAlterarTrecho=new JButton("OK");
	private JLabel origemTrechoAlterar=new JLabel("Digite o codigo de origem do trecho:");
	private JTextField textoOrigemTrechoAlterar =new JTextField();
	private JLabel destinoTrechoAlterar=new JLabel("Digite o codigo de destino do trecho:");
	private JTextField textoDestinoTrechoAlterar =new JTextField();
	private JLabel cod_assentoTrechoAlterar=new JLabel("Digite o codigo da reserva de assento do trecho:");
	private JTextField textoCod_assentoTrechoAlterar =new JTextField();
	private JLabel aero_origemTrechoAlterar=new JLabel("Digite o codigo do aeroporto de origem do trecho:");
	private JTextField textoAero_origemTrechoAlterar =new JTextField();
	private JLabel aero_destinoTrechoAlterar=new JLabel("Digite o codigo do aeroporto de destino do trecho:");
	private JTextField textoAero_destinoTrechoAlterar =new JTextField();
	private JButton botaoAlterarTrecho=new JButton("Alterar Trecho");
	private JButton botaoTrechoAlterado=new JButton("Alterar");
	
	//remover trecho
	private JButton botaoRemoverTrecho=new JButton("Remover Trecho");
	private JTextField textoIdRemoverTrecho =new JTextField();
	private JLabel escolhaIdRemoverTrecho=new JLabel("Escolha o id do Trecho que deseja remover:");
	private JPanel painelRemoverTrecho=new JPanel();
	private JButton botaoOkRemoveTrecho=new JButton("OK");
	
	//cadastrar data_hora
	private JButton botaoMostrarData_hora=new JButton("Mostrar Data_hora");
	private JTable mostrarData_hora;
	private TabelaData_hora tabelaData_hora=new TabelaData_hora();
	private JPanel painelCadastrarData_hora=new JPanel();
	private JLabel dt_cheData_hora=new JLabel("Digite a data da chegada do voo:");
	private JTextField textoDt_cheData_hora =new JTextField();
	private JLabel hora_cheData_hora=new JLabel("Digite a hora da chegada do voo:");
	private JTextField textoHora_cheData_hora =new JTextField();
	private JLabel dt_saiData_hora=new JLabel("Digite a data da saida do voo:");
	private JTextField textoDt_saiData_hora =new JTextField();
	private JLabel hora_saiData_hora=new JLabel("Digite a hora da saida do voo:");
	private JTextField textoHora_saiData_hora =new JTextField();
	private JButton botaoOkData_hora=new JButton("OK");
	private JButton botaoAdicionarData_hora=new JButton("Cadastrar Data_hora");
	
	//alterar data_hora
	private JPanel painelAlterarData_hora=new JPanel();
	private JPanel painelAlteraData_hora=new JPanel();
	private JLabel escolhaIdData_hora=new JLabel("Escolha o id da Data_hora que deseja alterar:");
	private JTextField textoIdData_hora =new JTextField();
	private JButton botaoOkAlterarData_hora=new JButton("OK");
	private JLabel dt_cheData_horaAlterar=new JLabel("Digite a data da chegada do voo:");
	private JTextField textoDt_cheData_horaAlterar =new JTextField();
	private JLabel hora_cheData_horaAlterar=new JLabel("Digite a hora da chegada do voo:");
	private JTextField textoHora_cheData_horaAlterar =new JTextField();
	private JLabel dt_saiData_horaAlterar=new JLabel("Digite a data da saida do voo:");
	private JTextField textoDt_saiData_horaAlterar =new JTextField();
	private JLabel hora_saiData_horaAlterar=new JLabel("Digite a hora da saida do voo:");
	private JTextField textoHora_saiData_horaAlterar =new JTextField();
	private JButton botaoAlterarData_hora=new JButton("Alterar Data_hora");
	private JButton botaoData_horaAlterado=new JButton("Alterar");
	
	//remover data_hora
	private JButton botaoRemoverData_hora=new JButton("Remover Data_hora");
	private JTextField textoIdRemoverData_hora =new JTextField();
	private JLabel escolhaIdRemoverData_hora=new JLabel("Escolha o id da Data_hora que deseja remover:");
	private JPanel painelRemoverData_hora=new JPanel();
	private JButton botaoOkRemoveData_hora=new JButton("OK");
		

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Passagem() {
		setTitle("Passagem Aéreas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1200, 700);
		
		setContentPane(painel);
		painel.setLayout(null);
		
		///////////////painelScrollTabela------------------------------------------------
		painelScrollTabela.setBounds(390, 30, 700, 500);
		painel.add(painelScrollTabela);
		//////////////painel-------------------------
		//botoes da aeronave
		botaoMostrarAeronave.setBounds(200, 370, 157, 25);
		painel.add(botaoMostrarAeronave);
		botaoAlterarAeronave.setBounds(30, 370, 157, 25);
		painel.add(botaoAlterarAeronave);
		botaoAdicionarAeronave.setBounds(30, 400, 157, 25);
		painel.add(botaoAdicionarAeronave);
		botaoRemoverAeronave.setBounds(200, 400, 157, 25);
		painel.add(botaoRemoverAeronave);
		
		//botoes do trecho
		botaoMostrarTrecho.setBounds(200, 580, 157, 25);
		painel.add(botaoMostrarTrecho);
		botaoAdicionarTrecho.setBounds(30, 610, 157, 25);
		painel.add(botaoAdicionarTrecho);
		botaoAlterarTrecho.setBounds(30, 580, 157, 25);
		painel.add(botaoAlterarTrecho);
		botaoRemoverTrecho.setBounds(200, 610, 157, 25);
		painel.add(botaoRemoverTrecho);
		
		//botoes da data_hora
		botaoMostrarData_hora.setBounds(200, 510, 157, 25);
		painel.add(botaoMostrarData_hora);
		botaoAdicionarData_hora.setBounds(30, 540, 157, 25);
		painel.add(botaoAdicionarData_hora);
		botaoAlterarData_hora.setBounds(30, 510, 157, 25);
		painel.add(botaoAlterarData_hora);
		botaoRemoverData_hora.setBounds(200, 540, 157, 25);
		painel.add(botaoRemoverData_hora);
		
		//botoes do reserva_assento
		botaoMostrarReserva_assento.setBounds(200, 440, 157, 25);
		painel.add(botaoMostrarReserva_assento);
		botaoAdicionarReserva_assento.setBounds(30, 470, 157, 25);
		painel.add(botaoAdicionarReserva_assento);
		botaoAlterarReserva_assento.setBounds(30, 440, 157, 25);
		painel.add(botaoAlterarReserva_assento);
		botaoRemoverReserva_assento.setBounds(200, 470, 157, 25);
		painel.add(botaoRemoverReserva_assento);
		
		//botoes do passageiro
		botaoMostrarPassageiro.setBounds(200, 300, 157, 25);
		painel.add(botaoMostrarPassageiro);
		botaoAdicionarPassageiro.setBounds(30, 330, 157, 25);
		painel.add(botaoAdicionarPassageiro);
		botaoAlterarPassageiro.setBounds(30, 300, 157, 25);
		painel.add(botaoAlterarPassageiro);
		botaoRemoverPassageiro.setBounds(200, 330, 157, 25);
		painel.add(botaoRemoverPassageiro);
		
		//botoes do aeroporto
		botaoMostrarAeroporto.setBounds(200, 230, 157, 25);
		painel.add(botaoMostrarAeroporto);
		botaoAdicionarAeroporto.setBounds(30, 260, 157, 25);
		painel.add(botaoAdicionarAeroporto);
		botaoAlterarAeroporto.setBounds(30, 230, 157, 25);
		painel.add(botaoAlterarAeroporto);
		botaoRemoverAeroporto.setBounds(200, 260, 157, 25);
		painel.add(botaoRemoverAeroporto);
		
		//botoes da cidade
		botaoMostrarCidade.setBounds(200, 160, 157, 25);
		painel.add(botaoMostrarCidade);
		botaoAdicionarCidade.setBounds(30, 190, 157, 25);
		painel.add(botaoAdicionarCidade);
		botaoAlterarCidade.setBounds(30, 160, 157, 25);
		painel.add(botaoAlterarCidade);
		botaoRemoverCidade.setBounds(200, 190, 157, 25);
		painel.add(botaoRemoverCidade);
		
		//botoes do reserva
		botaoMostrarReserva.setBounds(200, 20, 157, 25);
		painel.add(botaoMostrarReserva);
		botaoAdicionarReserva.setBounds(30, 50, 157, 25);
		painel.add(botaoAdicionarReserva);
		botaoAlterarReserva.setBounds(30, 20, 157, 25);
		painel.add(botaoAlterarReserva);
		botaoRemoverReserva.setBounds(200, 50, 157, 25);
		painel.add(botaoRemoverReserva);
		
		//botoes do voo
		botaoMostrarVoo.setBounds(200, 90, 157, 25);
		painel.add(botaoMostrarVoo);
		botaoAdicionarVoo.setBounds(30, 120, 157, 25);
		painel.add(botaoAdicionarVoo);
		botaoAlterarVoo.setBounds(30, 90, 157, 25);
		painel.add(botaoAlterarVoo);
		botaoRemoverVoo.setBounds(200, 120, 157, 25);
		painel.add(botaoRemoverVoo);

		///////////////////////////////////A E R O N A V E///////////////////////////////////////////////////////////////////////
        //Mostrar Aeronave----------------------------------------------------------------------------------------------------------
		mostrarAeronave=new JTable(tabelaAeronave);
		mostrarAeronave.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mostrarAeronave.getColumnModel().getColumn(0).setMaxWidth(40);
		mostrarAeronave.getColumnModel().getColumn(1).setPreferredWidth(150);
		mostrarAeronave.getColumnModel().getColumn(2).setPreferredWidth(40);

		botaoMostrarAeronave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabela.setViewportView(mostrarAeronave);
			}
		});
		painelScrollTabela.setViewportView(mostrarAeronave);
		
		//Cadastrar Aeronave--------------------------------------------------------------------------------------------------------
		painelCadastrarAeronave.setBounds(30, 30, 300, 300);
		painelCadastrarAeronave.setLayout(null);
		
		nomeAeronave.setBounds(30, 20, 200, 15);
		painelCadastrarAeronave.add(nomeAeronave);
		textoNomeAeronave.setBounds(30, 40, 200, 20);
		painelCadastrarAeronave.add(textoNomeAeronave);
		
		qtd_poltrona.setBounds(30, 60, 200, 15);
		painelCadastrarAeronave.add(qtd_poltrona);
		textoQtdPoltronaAeronave.setBounds(30, 80, 200, 20);
		painelCadastrarAeronave.add(textoQtdPoltronaAeronave);
		
	
		botaoOk.setBounds(80, 230, 100, 20);
		painelCadastrarAeronave.add(botaoOk);
		
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				try {
					Aeronave m=new Aeronave();
					m.setNome(textoNomeAeronave.getText());
					m.setQtd_poltrona(Integer.parseInt(textoQtdPoltronaAeronave.getText()));
					
					tabelaAeronave.adicionarAeronave(m);
					
				} catch (InsertException | SelectException |NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro no passagem", JOptionPane.ERROR_MESSAGE);
				}

				textoNomeAeronave.setText("");
				textoQtdPoltronaAeronave.setText("");
				
				
			}
		});
		
		botaoAdicionarAeronave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabela.setViewportView(painelCadastrarAeronave);
					
			}
		});
	//Alterar Aeronave-----------------------------------------------------------------------------------------------------------------
		
			painelAltera.setBounds(30, 30, 300, 300);
			painelAltera.setLayout(null);
			
			nomeAeronaveAlterar.setBounds(30, 20, 200, 15);
			painelAltera.add(nomeAeronaveAlterar);
			textoNomeAeronaveAlterar.setBounds(30, 40, 200, 20);
			painelAltera.add(textoNomeAeronaveAlterar);
			
			poltronaAeronaveAlterar.setBounds(30, 60, 200, 15);
			painelAltera.add(poltronaAeronaveAlterar);
			textopoltronaAeronaveAlterar.setBounds(30, 80, 200, 20);
			painelAltera.add(textopoltronaAeronaveAlterar);
			
			
			
			botaoAeronaveAlterado.setBounds(80, 230, 100, 20);
			painelAltera.add(botaoAeronaveAlterado);
			
			botaoAeronaveAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Aeronave m=new Aeronave();
						m.setCod(Integer.parseInt(textoIdAeronave.getText()));
						m.setNome(textoNomeAeronaveAlterar.getText());
						m.setQtd_poltrona(Integer.parseInt(textopoltronaAeronaveAlterar.getText()));
						
						tabelaAeronave.alterarAeronave(m);
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar aeronave", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarAeronave);	
					
				}
			});
	
	//painel pega id da aeronave  que vai ser alterado
		
			painelAlterarAeronave.setBounds(30, 30, 300, 300);
			painelAlterarAeronave.setLayout(null);
			
			escolhaIdAeronave.setBounds(20, 20, 300, 15);
			painelAlterarAeronave.add(escolhaIdAeronave);
			textoIdAeronave.setBounds(30, 50, 200, 25);
			painelAlterarAeronave.add(textoIdAeronave);
			
			botaoOkAlterarAeronave.setBounds(80, 90, 100, 20);
			painelAlterarAeronave.add(botaoOkAlterarAeronave);
			
			
			botaoOkAlterarAeronave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoNomeAeronaveAlterar.setText(tabelaAeronave.selectAeronave(Integer.parseInt(textoIdAeronave.getText())).getNome());
						textopoltronaAeronaveAlterar.setText(String.valueOf(tabelaAeronave.selectAeronave(Integer.parseInt(textoIdAeronave.getText())).getQtd_poltrona()));
						
						painelScrollTabela.setViewportView(painelAltera);
						
						tabelaAeronave.selectAeronave(Integer.parseInt(textoIdAeronave.getText())).setCod(tabelaAeronave.selectAeronave(Integer.parseInt(textoIdAeronave.getText())).getCod());
						tabelaAeronave.selectAeronave(Integer.parseInt(textoIdAeronave.getText())).setNome(textoNomeAeronaveAlterar.getText());
						
						
						tabelaAeronave.alterarAeronave(tabelaAeronave.selectAeronave(Integer.parseInt(textoIdAeronave.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar aeronave", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarAeronave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarAeronave);		
				}
			});
			
			//deletar aeronave
			painelRemoverAeronave.setBounds(30, 30, 300, 300);
			painelRemoverAeronave.setLayout(null);
			
			escolhaIdRemoverAeronave.setBounds(20, 20, 300, 15);
			painelRemoverAeronave.add(escolhaIdRemoverAeronave);
			textoIdRemoverAeronave.setBounds(30, 50, 200, 25);
			painelRemoverAeronave.add(textoIdRemoverAeronave);
			
			botaoOkRemove.setBounds(80, 90, 100, 20);
			painelRemoverAeronave.add(botaoOkRemove);
			
			botaoOkRemove.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaAeronave.removerAeronave(Integer.parseInt(textoIdRemoverAeronave.getText()));
						painelScrollTabela.setViewportView(mostrarAeronave);
						textoIdRemoverAeronave.setText("");
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover aeronave", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverAeronave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverAeronave);
				}
			});
			///////////////////////////P A S S A G E I R O//////////////////////////////////////////////////////////////////////////////
			 //Mostrar passageiro-----------------------------------------------------------------------------------------------------
			mostrarPassageiro=new JTable(tabelaPassageiro);
			mostrarPassageiro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarPassageiro.getColumnModel().getColumn(0).setMaxWidth(40);
			mostrarPassageiro.getColumnModel().getColumn(1).setPreferredWidth(150);
			
			botaoMostrarPassageiro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(mostrarPassageiro);
				}
			});
			painelScrollTabela.setViewportView(mostrarPassageiro);
			
			//Cadastrar Passageiro------------------------------------------------------------------------------------------------------
			painelCadastrarPassageiro.setBounds(30, 30, 300, 300);
			painelCadastrarPassageiro.setLayout(null);
			
			nomePassageiro.setBounds(30, 20, 200, 15);
			painelCadastrarPassageiro.add(nomePassageiro);
			textoNomePassageiro.setBounds(30, 40, 200, 20);
			painelCadastrarPassageiro.add(textoNomePassageiro);
		
			botaoOkPassageiro.setBounds(80, 230, 100, 20);
			painelCadastrarPassageiro.add(botaoOkPassageiro);
			
			botaoOkPassageiro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Passageiro m=new Passageiro();
						m.setNome(textoNomePassageiro.getText());
						
						tabelaPassageiro.adicionarPassageiro(m);
					} catch (InsertException | SelectException |NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar passageiro", JOptionPane.ERROR_MESSAGE);
					}

					textoNomePassageiro.setText("");
					
				}
			});
			
			botaoAdicionarPassageiro.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelCadastrarPassageiro);
						
				}
			});
			
			//Alterar Passageiro-----------------------------------------------------------------------------------------------------------------
			
			painelAlteraPassageiro.setBounds(30, 30, 300, 300);
			painelAlteraPassageiro.setLayout(null);
			
			nomePassageiroAlterar.setBounds(30, 20, 200, 15);
			painelAlteraPassageiro.add(nomePassageiroAlterar);
			textoNomePassageiroAlterar.setBounds(30, 40, 200, 20);
			painelAlteraPassageiro.add(textoNomePassageiroAlterar);
			
			botaoPassageiroAlterado.setBounds(80, 230, 100, 20);
			painelAlteraPassageiro.add(botaoPassageiroAlterado);
			
			botaoPassageiroAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Passageiro m=new Passageiro();
						m.setCod_p(Integer.parseInt(textoIdPassageiro.getText()));
						m.setNome(textoNomePassageiroAlterar.getText());
						
						tabelaPassageiro.alterarPassageiro(m);
						
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar passageiro", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarPassageiro);	
					
				}
			});
	
	//painel pega id da passageiro  que vai ser alterado
		
			painelAlterarPassageiro.setBounds(30, 30, 300, 300);
			painelAlterarPassageiro.setLayout(null);
			
			escolhaIdPassageiro.setBounds(20, 20, 300, 15);
			painelAlterarPassageiro.add(escolhaIdPassageiro);
			textoIdPassageiro.setBounds(30, 50, 200, 25);
			painelAlterarPassageiro.add(textoIdPassageiro);
			
			botaoOkAlterarPassageiro.setBounds(80, 90, 100, 20);
			painelAlterarPassageiro.add(botaoOkAlterarPassageiro);
			
			
			botaoOkAlterarPassageiro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoNomePassageiroAlterar.setText(tabelaPassageiro.selectPassageiro(Integer.parseInt(textoIdPassageiro.getText())).getNome());
						
						painelScrollTabela.setViewportView(painelAlteraPassageiro);
						
						tabelaPassageiro.selectPassageiro(Integer.parseInt(textoIdPassageiro.getText())).setCod_p(tabelaPassageiro.selectPassageiro
								(Integer.parseInt(textoIdPassageiro.getText())).getCod_p());
						tabelaPassageiro.selectPassageiro(Integer.parseInt(textoIdPassageiro.getText())).setNome(textoNomePassageiroAlterar.getText());
						
						
						tabelaPassageiro.alterarPassageiro(tabelaPassageiro.selectPassageiro(Integer.parseInt(textoIdPassageiro.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar isso passageiro", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarPassageiro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarPassageiro);		
				}
			});
			
			//deletar passageiro
			painelRemoverPassageiro.setBounds(30, 30, 300, 300);
			painelRemoverPassageiro.setLayout(null);
			
			escolhaIdRemoverPassageiro.setBounds(20, 20, 300, 15);
			painelRemoverPassageiro.add(escolhaIdRemoverPassageiro);
			textoIdRemoverPassageiro.setBounds(30, 50, 200, 25);
			painelRemoverPassageiro.add(textoIdRemoverPassageiro);
			
			botaoOkRemovePassageiro.setBounds(80, 90, 100, 20);
			painelRemoverPassageiro.add(botaoOkRemovePassageiro);
			
			botaoOkRemovePassageiro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaPassageiro.removerPassageiro(Integer.parseInt(textoIdRemoverPassageiro.getText()));
						painelScrollTabela.setViewportView(mostrarPassageiro);
						textoIdRemoverPassageiro.setText("");
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover passageiro", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverPassageiro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverPassageiro);
				}
			});
			
			///////////////////////////A E R O P O R T O//////////////////////////////////////////////////////////////////////////////
			 //Mostrar aeroporto-----------------------------------------------------------------------------------------------------
			mostrarAeroporto=new JTable(tabelaAeroporto);
			mostrarAeroporto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarAeroporto.getColumnModel().getColumn(0).setMaxWidth(80);
			mostrarAeroporto.getColumnModel().getColumn(1).setPreferredWidth(150);
			mostrarAeroporto.getColumnModel().getColumn(2).setPreferredWidth(150);
			
			botaoMostrarAeroporto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(mostrarAeroporto);
				}
			});
			painelScrollTabela.setViewportView(mostrarAeroporto);
			
			//Cadastrar aeroporto------------------------------------------------------------------------------------------------------
			painelCadastrarAeroporto.setBounds(30, 30, 300, 300);
			painelCadastrarAeroporto.setLayout(null);
			
			nomeAeroporto.setBounds(30, 20, 290, 15);
			painelCadastrarAeroporto.add(nomeAeroporto);
			textoNomeAeroporto.setBounds(30, 40, 200, 20);
			painelCadastrarAeroporto.add(textoNomeAeroporto);
			
			cod_cidAeroporto.setBounds(30, 90, 290, 15);
			painelCadastrarAeroporto.add(cod_cidAeroporto);
			textoCod_cidAeroporto.setBounds(30, 120, 200, 20);
			painelCadastrarAeroporto.add(textoCod_cidAeroporto);
		
			botaoOkAeroporto.setBounds(80, 230, 100, 20);
			painelCadastrarAeroporto.add(botaoOkAeroporto);
			
			botaoOkAeroporto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Aeroporto m=new Aeroporto();
						m.setCod_cid(Integer.parseInt(textoCod_cidAeroporto.getText()));
						m.setNome(textoNomeAeroporto.getText());
						
						
						tabelaAeroporto.adicionarAeroporto(m);
						
					} catch (InsertException | SelectException |NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar Aeroporto", JOptionPane.ERROR_MESSAGE);
					}

					textoNomeAeroporto.setText("");
					textoCod_cidAeroporto.setText("");
					
				}
			});
			
			botaoAdicionarAeroporto.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelCadastrarAeroporto);
						
				}
			});
			
			//Alterar aeroporto-----------------------------------------------------------------------------------------------------------------
			
			painelAlteraAeroporto.setBounds(30, 30, 300, 300);
			painelAlteraAeroporto.setLayout(null);
			
			nomeAeroportoAlterar.setBounds(30, 20, 200, 15);
			painelAlteraAeroporto.add(nomeAeroportoAlterar);
			textoNomeAeroportoAlterar.setBounds(30, 40, 200, 20);
			painelAlteraAeroporto.add(textoNomeAeroportoAlterar);
			
			cod_cidAeroportoAlterar.setBounds(30, 60, 250, 15);
			painelAlteraAeroporto.add(cod_cidAeroportoAlterar);
			textoCod_cidAeroportoAlterar.setBounds(30, 80, 200, 20);
			painelAlteraAeroporto.add(textoCod_cidAeroportoAlterar);
			
			botaoAeroportoAlterado.setBounds(80, 230, 100, 20);
			painelAlteraAeroporto.add(botaoAeroportoAlterado);
			
			botaoAeroportoAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Aeroporto m=new Aeroporto();
						m.setCod(Integer.parseInt(textoIdAeroporto.getText()));
						m.setCod_cid(Integer.parseInt(textoCod_cidAeroportoAlterar.getText()));
						m.setNome(textoNomeAeroportoAlterar.getText());
						tabelaAeroporto.alterarAeroporto(m);
						
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar Aeroporto", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarAeroporto);	
					
				}
			});
	
	//painel pega id do aeroporto  que vai ser alterado
		
			painelAlterarAeroporto.setBounds(30, 30, 300, 300);
			painelAlterarAeroporto.setLayout(null);
			
			escolhaIdAeroporto.setBounds(20, 20, 300, 15);
			painelAlterarAeroporto.add(escolhaIdAeroporto);
			textoIdAeroporto.setBounds(30, 50, 200, 25);
			painelAlterarAeroporto.add(textoIdAeroporto);
			
			botaoOkAlterarAeroporto.setBounds(80, 90, 100, 20);
			painelAlterarAeroporto.add(botaoOkAlterarAeroporto);
			
			
			botaoOkAlterarAeroporto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoNomeAeroportoAlterar.setText(tabelaAeroporto.selectAeroporto(Integer.parseInt(textoIdAeroporto.getText())).getNome());
						textoCod_cidAeroportoAlterar.setText(String.valueOf(tabelaAeroporto.selectAeroporto(Integer.parseInt(textoIdAeroporto.getText())).getCod_cid()));
						
						painelScrollTabela.setViewportView(painelAlteraAeroporto);
						
						tabelaAeroporto.selectAeroporto(Integer.parseInt(textoIdAeroporto.getText())).setCod(tabelaAeroporto.selectAeroporto(Integer.parseInt(textoIdAeroporto.getText())).getCod());
						tabelaAeroporto.selectAeroporto(Integer.parseInt(textoIdAeroporto.getText())).setCod_cid(Integer.parseInt(textoIdAeroporto.getText()));
						tabelaAeroporto.selectAeroporto(Integer.parseInt(textoIdAeroporto.getText())).setNome(textoNomeAeroportoAlterar.getText());
						
						tabelaAeroporto.alterarAeroporto(tabelaAeroporto.selectAeroporto(Integer.parseInt(textoIdAeroporto.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar isso Aeroporto", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarAeroporto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarAeroporto);		
				}
			});
			
			//deletar aeroporto
			painelRemoverAeroporto.setBounds(30, 30, 300, 300);
			painelRemoverAeroporto.setLayout(null);
			
			escolhaIdRemoverAeroporto.setBounds(20, 20, 300, 15);
			painelRemoverAeroporto.add(escolhaIdRemoverAeroporto);
			textoIdRemoverAeroporto.setBounds(30, 50, 200, 25);
			painelRemoverAeroporto.add(textoIdRemoverAeroporto);
			
			botaoOkRemoveAeroporto.setBounds(80, 90, 100, 20);
			painelRemoverAeroporto.add(botaoOkRemoveAeroporto);
			
			botaoOkRemoveAeroporto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaAeroporto.removerAeroporto(Integer.parseInt(textoIdRemoverAeroporto.getText()));
						painelScrollTabela.setViewportView(mostrarAeroporto);
						textoIdRemoverAeroporto.setText("");
						
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover Aeroporto", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverAeroporto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverAeroporto);
				}
			});
			///////////////////////////C I D A D E//////////////////////////////////////////////////////////////////////////////
			 //Mostrar Cidade-----------------------------------------------------------------------------------------------------
			mostrarCidade=new JTable(tabelaCidade);
			mostrarCidade.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarCidade.getColumnModel().getColumn(0).setMaxWidth(40);
			mostrarCidade.getColumnModel().getColumn(1).setPreferredWidth(150);
			mostrarCidade.getColumnModel().getColumn(2).setPreferredWidth(200);
			mostrarCidade.getColumnModel().getColumn(3).setPreferredWidth(150);
			botaoMostrarCidade.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(mostrarCidade);
				}
			});
			painelScrollTabela.setViewportView(mostrarCidade);
			
			//Cadastrar Cidade------------------------------------------------------------------------------------------------------
			painelCadastrarCidade.setBounds(30, 30, 300, 300);
			painelCadastrarCidade.setLayout(null);
			
			nomeCidade.setBounds(30, 20, 200, 15);
			painelCadastrarCidade.add(nomeCidade);
			textoNomeCidade.setBounds(30, 40, 200, 20);
			painelCadastrarCidade.add(textoNomeCidade);
			
			nomeEstado.setBounds(30, 70, 200, 15);
			painelCadastrarCidade.add(nomeEstado);
			textoNomeEstado.setBounds(30, 90, 200, 20);
			painelCadastrarCidade.add(textoNomeEstado);
			
			nomePais.setBounds(30, 110, 200, 15);
			painelCadastrarCidade.add(nomePais);
			textoNomePais.setBounds(30, 130, 200, 20);
			painelCadastrarCidade.add(textoNomePais);
		
			botaoOkCidade.setBounds(80, 230, 100, 20);
			painelCadastrarCidade.add(botaoOkCidade);
			
			botaoOkCidade.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Cidade m=new Cidade();
						m.setCidade(textoNomeCidade.getText());
						m.setEstado(textoNomeEstado.getText());
						m.setPais(textoNomePais.getText());
						
						tabelaCidade.adicionarCidade(m);
						
					} catch (InsertException | SelectException |NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar Cidade", JOptionPane.ERROR_MESSAGE);
					}

					textoNomeCidade.setText("");
					textoNomeEstado.setText("");
					textoNomePais.setText("");
					
				}
			});
			
			botaoAdicionarCidade.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelCadastrarCidade);
						
				}
			});
			
			//Alterar cidade-----------------------------------------------------------------------------------------------------------------
			
			painelAlteraCidade.setBounds(30, 30, 300, 300);
			painelAlteraCidade.setLayout(null);
			
			nomeCidadeAlterar.setBounds(30, 20, 200, 15);
			painelAlteraCidade.add(nomeCidadeAlterar);
			textoNomeCidadeAlterar.setBounds(30, 40, 200, 20);
			painelAlteraCidade.add(textoNomeCidadeAlterar);
			
			nomeEstadoAlterar.setBounds(30, 60, 200, 15);
			painelAlteraCidade.add(nomeEstadoAlterar);
			textoNomeEstadoAlterar.setBounds(30, 80, 200, 20);
			painelAlteraCidade.add(textoNomeEstadoAlterar);
			
			nomePaisAlterar.setBounds(30, 100, 200, 15);
			painelAlteraCidade.add(nomePaisAlterar);
			textoNomePaisAlterar.setBounds(30, 120, 200, 20);
			painelAlteraCidade.add(textoNomePaisAlterar);
			
			botaoCidadeAlterado.setBounds(80, 230, 100, 20);
			painelAlteraCidade.add(botaoCidadeAlterado);
			
			botaoCidadeAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Cidade m=new Cidade();
						m.setCod_cid(Integer.parseInt(textoIdCidade.getText()));
						m.setCidade(textoNomeCidadeAlterar.getText());
						m.setEstado(textoNomeEstadoAlterar.getText());
						m.setPais(textoNomePaisAlterar.getText());
						tabelaCidade.alterarCidade(m);
						
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar Cidade", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarCidade);	
					
				}
			});
	
	//painel pega id da Cidade  que vai ser alterado
		
			painelAlterarCidade.setBounds(30, 30, 300, 300);
			painelAlterarCidade.setLayout(null);
			
			escolhaIdCidade.setBounds(20, 20, 300, 15);
			painelAlterarCidade.add(escolhaIdCidade);
			textoIdCidade.setBounds(30, 50, 200, 25);
			painelAlterarCidade.add(textoIdCidade);
			
			botaoOkAlterarCidade.setBounds(80, 90, 100, 20);
			painelAlterarCidade.add(botaoOkAlterarCidade);
			
			
			botaoOkAlterarCidade.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoNomeCidadeAlterar.setText(tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())).getCidade());
						textoNomeEstadoAlterar.setText(tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())).getEstado());
						textoNomePaisAlterar.setText(tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())).getPais());
						
						painelScrollTabela.setViewportView(painelAlteraCidade);
						
						tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())).setCod_cid(tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())).getCod_cid());
						tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())).setCidade(textoNomeCidadeAlterar.getText());
						tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())).setEstado(textoNomeEstadoAlterar.getText());
						tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())).setPais(textoNomePaisAlterar.getText());
						
						tabelaCidade.alterarCidade(tabelaCidade.selectCidade(Integer.parseInt(textoIdCidade.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar isso Cidade", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarCidade.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarCidade);		
				}
			});
			
			//deletar Cidade
			painelRemoverCidade.setBounds(30, 30, 300, 300);
			painelRemoverCidade.setLayout(null);
			
			escolhaIdRemoverCidade.setBounds(20, 20, 300, 15);
			painelRemoverCidade.add(escolhaIdRemoverCidade);
			textoIdRemoverCidade.setBounds(30, 50, 200, 25);
			painelRemoverCidade.add(textoIdRemoverCidade);
			
			botaoOkRemoveCidade.setBounds(80, 90, 100, 20);
			painelRemoverCidade.add(botaoOkRemoveCidade);
			
			botaoOkRemoveCidade.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaCidade.removerCidade(Integer.parseInt(textoIdRemoverCidade.getText()));
						painelScrollTabela.setViewportView(mostrarCidade);
						textoIdRemoverCidade.setText("");
						
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover Cidade", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverCidade.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverCidade);
				}
			});
			///////////////////////////D A T A _ H O R A//////////////////////////////////////////////////////////////////////////////
			 //Mostrar Data_hora-----------------------------------------------------------------------------------------------------
			mostrarData_hora=new JTable(tabelaData_hora);
			mostrarData_hora.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarData_hora.getColumnModel().getColumn(0).setMaxWidth(40);
			mostrarData_hora.getColumnModel().getColumn(1).setPreferredWidth(150);
			mostrarData_hora.getColumnModel().getColumn(2).setPreferredWidth(150);
			mostrarData_hora.getColumnModel().getColumn(3).setPreferredWidth(150);
			mostrarData_hora.getColumnModel().getColumn(4).setPreferredWidth(150);
			
			botaoMostrarData_hora.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(mostrarData_hora);
				}
			});
			painelScrollTabela.setViewportView(mostrarData_hora);
			
			//Cadastrar Data_hora------------------------------------------------------------------------------------------------------
			painelCadastrarData_hora.setBounds(30, 30, 300, 300);
			painelCadastrarData_hora.setLayout(null);
			
			dt_cheData_hora.setBounds(30, 20, 200, 15);
			painelCadastrarData_hora.add(dt_cheData_hora);
			textoDt_cheData_hora.setBounds(30, 40, 200, 20);
			painelCadastrarData_hora.add(textoDt_cheData_hora);
			
			hora_cheData_hora.setBounds(30, 70, 200, 15);
			painelCadastrarData_hora.add(hora_cheData_hora);
			textoHora_cheData_hora.setBounds(30, 90, 200, 20);
			painelCadastrarData_hora.add(textoHora_cheData_hora);
			
			dt_saiData_hora.setBounds(30, 110, 200, 15);
			painelCadastrarData_hora.add(dt_saiData_hora);
			textoDt_saiData_hora.setBounds(30, 130, 200, 20);
			painelCadastrarData_hora.add(textoDt_saiData_hora);
			
			hora_saiData_hora.setBounds(30, 150, 200, 15);
			painelCadastrarData_hora.add(hora_saiData_hora);
			textoHora_saiData_hora.setBounds(30, 170, 200, 20);
			painelCadastrarData_hora.add(textoHora_saiData_hora);
		
			botaoOkData_hora.setBounds(80, 230, 100, 20);
			painelCadastrarData_hora.add(botaoOkData_hora);
			
			botaoOkData_hora.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Data_hora m=new Data_hora();
						m.setData_che(Date.valueOf(textoDt_cheData_hora.getText()));
						m.setHora_che(Time.valueOf(textoHora_cheData_hora.getText()));
						m.setData_sai(Date.valueOf(textoDt_saiData_hora.getText()));
						m.setHora_sai(Time.valueOf(textoHora_saiData_hora.getText()));
						tabelaData_hora.adicionarData_hora(m);
						
					} catch (InsertException | SelectException |NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar Data_hora", JOptionPane.ERROR_MESSAGE);
					}

					textoDt_cheData_hora.setText("");
					textoHora_cheData_hora.setText("");
					textoDt_saiData_hora.setText("");
					textoHora_saiData_hora.setText("");
					
				}
			});
			
			botaoAdicionarData_hora.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelCadastrarData_hora);
						
				}
			});
			
			//Alterar Data_hora-----------------------------------------------------------------------------------------------------------------
			
			painelAlteraData_hora.setBounds(30, 30, 300, 300);
			painelAlteraData_hora.setLayout(null);
			
			dt_cheData_horaAlterar.setBounds(30, 20, 200, 15);
			painelAlteraData_hora.add(dt_cheData_horaAlterar);
			textoDt_cheData_horaAlterar.setBounds(30, 40, 200, 20);
			painelAlteraData_hora.add(textoDt_cheData_horaAlterar);
			
			hora_cheData_horaAlterar.setBounds(30, 60, 200, 15);
			painelAlteraData_hora.add(hora_cheData_horaAlterar);
			textoHora_cheData_horaAlterar.setBounds(30, 80, 200, 20);
			painelAlteraData_hora.add(textoHora_cheData_horaAlterar);
			
			dt_saiData_horaAlterar.setBounds(30, 100, 200, 15);
			painelAlteraData_hora.add(dt_saiData_horaAlterar);
			textoDt_saiData_horaAlterar.setBounds(30, 120, 200, 20);
			painelAlteraData_hora.add(textoDt_saiData_horaAlterar);
			
			hora_saiData_horaAlterar.setBounds(30, 140, 200, 15);
			painelAlteraData_hora.add(hora_saiData_horaAlterar);
			textoHora_saiData_horaAlterar.setBounds(30, 160, 200, 20);
			painelAlteraData_hora.add(textoHora_saiData_horaAlterar);
			
			botaoData_horaAlterado.setBounds(80, 230, 100, 20);
			painelAlteraData_hora.add(botaoData_horaAlterado);
			
			botaoData_horaAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Data_hora m=new Data_hora();
						m.setCod(Integer.parseInt(textoIdData_hora.getText()));
						m.setData_che(Date.valueOf(textoDt_cheData_horaAlterar.getText()));
						m.setHora_che(Time.valueOf(textoHora_cheData_horaAlterar.getText()));
						m.setData_sai(Date.valueOf(textoDt_saiData_horaAlterar.getText()));
						m.setHora_sai(Time.valueOf(textoHora_saiData_horaAlterar.getText()));
						tabelaData_hora.alterarData_hora(m);
						
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar Data_hora", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarData_hora);	
					
				}
			});
	
	//painel pega id da Data_hora  que vai ser alterado
		
			painelAlterarData_hora.setBounds(30, 30, 300, 300);
			painelAlterarData_hora.setLayout(null);
			
			escolhaIdData_hora.setBounds(20, 20, 300, 15);
			painelAlterarData_hora.add(escolhaIdData_hora);
			textoIdData_hora.setBounds(30, 50, 200, 25);
			painelAlterarData_hora.add(textoIdData_hora);
			
			botaoOkAlterarData_hora.setBounds(80, 90, 100, 20);
			painelAlterarData_hora.add(botaoOkAlterarData_hora);
			
			
			botaoOkAlterarData_hora.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoDt_cheData_horaAlterar.setText(String.valueOf(tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).getData_che()));
						textoHora_cheData_horaAlterar.setText(String.valueOf(tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).getHora_che()));
						textoDt_saiData_horaAlterar.setText(String.valueOf(tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).getData_sai()));
						textoHora_saiData_horaAlterar.setText(String.valueOf(tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).getHora_sai()));
						
						painelScrollTabela.setViewportView(painelAlteraData_hora);
						
						tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).setCod(tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).getCod());
						tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).setData_che(Date.valueOf(textoDt_cheData_horaAlterar.getText()));
						tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).setHora_che(Time.valueOf(textoHora_cheData_horaAlterar.getText()));
						tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).setData_sai(Date.valueOf(textoDt_saiData_horaAlterar.getText()));
						tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())).setHora_sai(Time.valueOf(textoHora_saiData_horaAlterar.getText()));
						
						tabelaData_hora.alterarData_hora(tabelaData_hora.selectData_hora(Integer.parseInt(textoIdData_hora.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar isso Data_hora", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarData_hora.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarData_hora);		
				}
			});
			
			//deletar Data_hora
			painelRemoverData_hora.setBounds(30, 30, 300, 300);
			painelRemoverData_hora.setLayout(null);
			
			escolhaIdRemoverData_hora.setBounds(20, 20, 300, 15);
			painelRemoverData_hora.add(escolhaIdRemoverData_hora);
			textoIdRemoverData_hora.setBounds(30, 50, 200, 25);
			painelRemoverData_hora.add(textoIdRemoverData_hora);
			
			botaoOkRemoveData_hora.setBounds(80, 90, 100, 20);
			painelRemoverData_hora.add(botaoOkRemoveData_hora);
			
			botaoOkRemoveData_hora.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaData_hora.removerData_hora(Integer.parseInt(textoIdRemoverData_hora.getText()));
						painelScrollTabela.setViewportView(mostrarData_hora);
						textoIdRemoverData_hora.setText("");
						
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover Data_hora", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverData_hora.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverData_hora);
				}
			});
			///////////////////////////R E S E R V A _ A S S E N T O//////////////////////////////////////////////////////////////////////////////
			 //Mostrar Reserva_assento-----------------------------------------------------------------------------------------------------
			mostrarReserva_assento=new JTable(tabelaReserva_assento);
			mostrarReserva_assento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarReserva_assento.getColumnModel().getColumn(0).setPreferredWidth(150);
			mostrarReserva_assento.getColumnModel().getColumn(1).setPreferredWidth(150);
			mostrarReserva_assento.getColumnModel().getColumn(2).setPreferredWidth(150);
			mostrarReserva_assento.getColumnModel().getColumn(3).setPreferredWidth(150);
			
			botaoMostrarReserva_assento.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(mostrarReserva_assento);
				}
			});
			painelScrollTabela.setViewportView(mostrarReserva_assento);
			
			//Cadastrar Reserva_assento------------------------------------------------------------------------------------------------------
			painelCadastrarReserva_assento.setBounds(30, 30, 300, 300);
			painelCadastrarReserva_assento.setLayout(null);
			
			data_resReserva_assento.setBounds(30, 20, 250, 15);
			painelCadastrarReserva_assento.add(data_resReserva_assento);
			textodata_resReserva_assento.setBounds(30, 40, 200, 20);
			painelCadastrarReserva_assento.add(textodata_resReserva_assento);
			
			num_poltrReserva_assento.setBounds(30, 70, 300, 15);
			painelCadastrarReserva_assento.add(num_poltrReserva_assento);
			textoNum_poltronaReserva_assento.setBounds(30, 90, 200, 20);
			painelCadastrarReserva_assento.add(textoNum_poltronaReserva_assento);
			
			cod_aeroReserva_assento.setBounds(30, 110, 250, 15);
			painelCadastrarReserva_assento.add(cod_aeroReserva_assento);
			textocod_aeroReserva_assento.setBounds(30, 130, 200, 20);
			painelCadastrarReserva_assento.add(textocod_aeroReserva_assento);
		
			botaoOkReserva_assento.setBounds(80, 230, 100, 20);
			painelCadastrarReserva_assento.add(botaoOkReserva_assento);
			
			botaoOkReserva_assento.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Reserva_assento m=new Reserva_assento();
						m.setData_reserva(Date.valueOf(textodata_resReserva_assento.getText()));
						m.setNum_poltrona(Integer.parseInt(textoNum_poltronaReserva_assento.getText()));
						m.setCod(Integer.parseInt(textocod_aeroReserva_assento.getText()));
						
						tabelaReserva_assento.adicionarReserva_assento(m);
						
					} catch (InsertException | SelectException |NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar Reserva_assento", JOptionPane.ERROR_MESSAGE);
					}

					textodata_resReserva_assento.setText("");
					textoNum_poltronaReserva_assento.setText("");
					textocod_aeroReserva_assento.setText("");
					
				}
			});
			
			botaoAdicionarReserva_assento.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelCadastrarReserva_assento);
						
				}
			});
			
			//Alterar Reserva_assento-----------------------------------------------------------------------------------------------------------------
			
			painelAlteraReserva_assento.setBounds(30, 30, 300, 300);
			painelAlteraReserva_assento.setLayout(null);
			
			data_resReserva_assentoAlterar.setBounds(30, 20, 200, 15);
			painelAlteraReserva_assento.add(data_resReserva_assentoAlterar);
			textoData_reservaAlterar.setBounds(30, 40, 200, 20);
			painelAlteraReserva_assento.add(textoData_reservaAlterar);
			
			num_poltrReserva_assentoAlterar.setBounds(30, 60, 200, 15);
			painelAlteraReserva_assento.add(num_poltrReserva_assentoAlterar);
			textoNum_poltronaAlterar.setBounds(30, 80, 200, 20);
			painelAlteraReserva_assento.add(textoNum_poltronaAlterar);
			
			cod_aeroReserva_assentoAlterar.setBounds(30, 100, 200, 15);
			painelAlteraReserva_assento.add(cod_aeroReserva_assentoAlterar);
			textoCod_aeroAlterar.setBounds(30, 120, 200, 20);
			painelAlteraReserva_assento.add(textoCod_aeroAlterar);
			
			botaoReserva_assentoAlterado.setBounds(80, 230, 100, 20);
			painelAlteraReserva_assento.add(botaoReserva_assentoAlterado);
			
			botaoReserva_assentoAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Reserva_assento m=new Reserva_assento();
						m.setCod_assento(Integer.parseInt(textoIdReserva_assento.getText()));
						m.setData_reserva(Date.valueOf(textoData_reservaAlterar.getText()));
						m.setNum_poltrona(Integer.parseInt(textoNum_poltronaAlterar.getText()));
						m.setCod(Integer.parseInt(textoCod_aeroAlterar.getText()));
						tabelaReserva_assento.alterarReserva_assento(m);
						
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar Reserva_assento", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarReserva_assento);	
					
				}
			});
	
	//painel pega id da Reserva_assento  que vai ser alterado
		
			painelAlterarReserva_assento.setBounds(30, 30, 300, 300);
			painelAlterarReserva_assento.setLayout(null);
			
			escolhaIdReserva_assento.setBounds(20, 20, 350, 15);
			painelAlterarReserva_assento.add(escolhaIdReserva_assento);
			textoIdReserva_assento.setBounds(30, 50, 200, 25);
			painelAlterarReserva_assento.add(textoIdReserva_assento);
			
			botaoOkAlterarReserva_assento.setBounds(80, 90, 100, 20);
			painelAlterarReserva_assento.add(botaoOkAlterarReserva_assento);
			
			
			botaoOkAlterarReserva_assento.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoData_reservaAlterar.setText(String.valueOf(tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())).getData_reserva()));
						textoNum_poltronaAlterar.setText(String.valueOf(tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())).getNum_poltrona()));
						textoCod_aeroAlterar.setText(String.valueOf(tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())).getCod()));
						
						painelScrollTabela.setViewportView(painelAlteraReserva_assento);
						
						tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())).setCod_assento(tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())).getCod_assento());
						tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())).setData_reserva(Date.valueOf(textoData_reservaAlterar.getText()));
						tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())).setNum_poltrona(Integer.parseInt(textoNum_poltronaAlterar.getText()));
						tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())).setCod(Integer.parseInt(textoCod_aeroAlterar.getText()));
						
						tabelaReserva_assento.alterarReserva_assento(tabelaReserva_assento.selectReserva_assento(Integer.parseInt(textoIdReserva_assento.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar isso Reserva_assento", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarReserva_assento.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarReserva_assento);		
				}
			});
			
			//deletar Reserva_assento
			painelRemoverReserva_assento.setBounds(30, 30, 300, 300);
			painelRemoverReserva_assento.setLayout(null);
			
			escolhaIdRemoverReserva_assento.setBounds(20, 20, 350, 15);
			painelRemoverReserva_assento.add(escolhaIdRemoverReserva_assento);
			textoIdRemoverReserva_assento.setBounds(30, 50, 200, 25);
			painelRemoverReserva_assento.add(textoIdRemoverReserva_assento);
			
			botaoOkRemoveReserva_assento.setBounds(80, 90, 100, 20);
			painelRemoverReserva_assento.add(botaoOkRemoveReserva_assento);
			
			botaoOkRemoveReserva_assento.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaReserva_assento.removerReserva_assento(Integer.parseInt(textoIdRemoverReserva_assento.getText()));
						painelScrollTabela.setViewportView(mostrarReserva_assento);
						textoIdRemoverReserva_assento.setText("");
						
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover Reserva_assento", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverReserva_assento.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverReserva_assento);
				}
			});
			
			///////////////////////////R E S E R V A//////////////////////////////////////////////////////////////////////////////
			 //Mostrar Reserva-----------------------------------------------------------------------------------------------------
			mostrarReserva=new JTable(tabelaReserva);
			mostrarReserva.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarReserva.getColumnModel().getColumn(0).setPreferredWidth(150);
			mostrarReserva.getColumnModel().getColumn(1).setPreferredWidth(150);
			mostrarReserva.getColumnModel().getColumn(2).setPreferredWidth(150);
			mostrarReserva.getColumnModel().getColumn(3).setPreferredWidth(150);
			
			botaoMostrarReserva.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(mostrarReserva);
				}
			});
			painelScrollTabela.setViewportView(mostrarReserva);
			
			//Cadastrar Reserva-----------------------------------------------------------------------------------------------------
			painelCadastrarReserva.setBounds(30, 30, 300, 300);
			painelCadastrarReserva.setLayout(null);
			
			data_validadeReserva.setBounds(30, 20, 250, 15);
			painelCadastrarReserva.add(data_validadeReserva);
			textodata_validadeReserva.setBounds(30, 40, 200, 20);
			painelCadastrarReserva.add(textodata_validadeReserva);
			
			cod_pReserva.setBounds(30, 70, 300, 15);
			painelCadastrarReserva.add(cod_pReserva);
			textoCod_pReserva.setBounds(30, 90, 200, 20);
			painelCadastrarReserva.add(textoCod_pReserva);
			
			cod_vooReserva.setBounds(30, 110, 250, 15);
			painelCadastrarReserva.add(cod_vooReserva);
			textoCod_vooReserva.setBounds(30, 130, 200, 20);
			painelCadastrarReserva.add(textoCod_vooReserva);
		
			botaoOkReserva.setBounds(80, 230, 100, 20);
			painelCadastrarReserva.add(botaoOkReserva);
			
			botaoOkReserva.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Reserva m=new Reserva();
						m.setDta_validade(Date.valueOf(textodata_validadeReserva.getText()));
						
						m.setCod_p(Integer.parseInt(textoCod_pReserva.getText()));
						m.setCod_voo(Integer.parseInt(textoCod_vooReserva.getText()));
						
						tabelaReserva.adicionarReserva(m);
						
					} catch (InsertException | SelectException |NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar Reserva", JOptionPane.ERROR_MESSAGE);
					}

					textodata_validadeReserva.setText("");
					textoCod_pReserva.setText("");
					textoCod_vooReserva.setText("");
					
				}
			});
			
			botaoAdicionarReserva.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelCadastrarReserva);
						
				}
			});
			
			//Alterar Reserva-----------------------------------------------------------------------------------------------------------------
			
			painelAlteraReserva.setBounds(30, 30, 300, 300);
			painelAlteraReserva.setLayout(null);
			
			data_validadeReservaAlterar.setBounds(30, 20, 200, 15);
			painelAlteraReserva.add(data_validadeReservaAlterar);
			textoData_validadeAlterar.setBounds(30, 40, 200, 20);
			painelAlteraReserva.add(textoData_validadeAlterar);
			
			cod_pReservaAlterar.setBounds(30, 60, 200, 15);
			painelAlteraReserva.add(cod_pReservaAlterar);
			textoCod_pAlterar.setBounds(30, 80, 200, 20);
			painelAlteraReserva.add(textoCod_pAlterar);
			
			cod_vooReservaAlterar.setBounds(30, 100, 200, 15);
			painelAlteraReserva.add(cod_vooReservaAlterar);
			textoCod_vooAlterar.setBounds(30, 120, 200, 20);
			painelAlteraReserva.add(textoCod_vooAlterar);
			
			botaoReservaAlterado.setBounds(80, 230, 100, 20);
			painelAlteraReserva.add(botaoReservaAlterado);
			
			botaoReservaAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Reserva m=new Reserva();
						m.setCod_res(Integer.parseInt(textoIdReserva.getText()));
						m.setDta_validade(Date.valueOf(textoData_validadeAlterar.getText()));
						m.setCod_p(Integer.parseInt(textoCod_pAlterar.getText()));
						m.setCod_voo(Integer.parseInt(textoCod_vooAlterar.getText()));
						tabelaReserva.alterarReserva(m);
						
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar Reserva", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarReserva);	
					
				}
			});
	
	//painel pega id da Reserva  que vai ser alterado
		
			painelAlterarReserva.setBounds(30, 30, 300, 300);
			painelAlterarReserva.setLayout(null);
			
			escolhaIdReserva.setBounds(20, 20, 350, 15);
			painelAlterarReserva.add(escolhaIdReserva);
			textoIdReserva.setBounds(30, 50, 200, 25);
			painelAlterarReserva.add(textoIdReserva);
			
			botaoOkAlterarReserva.setBounds(80, 90, 100, 20);
			painelAlterarReserva.add(botaoOkAlterarReserva);
			
			
			botaoOkAlterarReserva.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoData_validadeAlterar.setText(String.valueOf(tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())).getDta_validade()));
						textoCod_pAlterar.setText(String.valueOf(tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())).getCod_p()));
						textoCod_vooAlterar.setText(String.valueOf(tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())).getCod_voo()));
						
						painelScrollTabela.setViewportView(painelAlteraReserva);
						
						tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())).setCod_res(tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())).getCod_res());
						tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())).setDta_validade(Date.valueOf(textoData_validadeAlterar.getText()));
						tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())).setCod_p(Integer.parseInt(textoCod_pAlterar.getText()));
						tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())).setCod_voo(Integer.parseInt(textoCod_vooAlterar.getText()));
						
						tabelaReserva.alterarReserva(tabelaReserva.selectReserva(Integer.parseInt(textoIdReserva.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar isso Reserva", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarReserva.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarReserva);		
				}
			});
			
			//deletar Reserva
			painelRemoverReserva.setBounds(30, 30, 300, 300);
			painelRemoverReserva.setLayout(null);
			
			escolhaIdRemoverReserva.setBounds(20, 20, 350, 15);
			painelRemoverReserva.add(escolhaIdRemoverReserva);
			textoIdRemoverReserva.setBounds(30, 50, 200, 25);
			painelRemoverReserva.add(textoIdRemoverReserva);
			
			botaoOkRemoveReserva.setBounds(80, 90, 100, 20);
			painelRemoverReserva.add(botaoOkRemoveReserva);
			
			botaoOkRemoveReserva.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaReserva.removerReserva(Integer.parseInt(textoIdRemoverReserva.getText()));
						painelScrollTabela.setViewportView(mostrarReserva);
						textoIdRemoverReserva.setText("");
						
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover Reserva", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverReserva.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverReserva);
				}
			});
			///////////////////////////T R E C H O//////////////////////////////////////////////////////////////////////////////
			 //Mostrar Trecho-----------------------------------------------------------------------------------------------------
			mostrarTrecho=new JTable(tabelaTrecho);
			mostrarTrecho.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarTrecho.getColumnModel().getColumn(0).setPreferredWidth(100);
			mostrarTrecho.getColumnModel().getColumn(1).setPreferredWidth(150);
			mostrarTrecho.getColumnModel().getColumn(2).setPreferredWidth(150);
			mostrarTrecho.getColumnModel().getColumn(3).setPreferredWidth(150);
			mostrarTrecho.getColumnModel().getColumn(4).setPreferredWidth(150);
			mostrarTrecho.getColumnModel().getColumn(5).setPreferredWidth(150);
			
			botaoMostrarTrecho.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(mostrarTrecho);
				}
			});
			painelScrollTabela.setViewportView(mostrarTrecho);
			
			//Cadastrar Voo-----------------------------------------------------------------------------------------------------
			painelCadastrarTrecho.setBounds(30, 30, 300, 300);
			painelCadastrarTrecho.setLayout(null);
			
			origemTrecho.setBounds(30, 20, 250, 15);
			painelCadastrarTrecho.add(origemTrecho);
			textoOrigemTrecho.setBounds(30, 40, 200, 20);
			painelCadastrarTrecho.add(textoOrigemTrecho);
			
			destinoTrecho.setBounds(30, 70, 300, 15);
			painelCadastrarTrecho.add(destinoTrecho);
			textoDestinoTrecho.setBounds(30, 90, 200, 20);
			painelCadastrarTrecho.add(textoDestinoTrecho);
			
			cod_assentoTrecho.setBounds(30, 110, 250, 15);
			painelCadastrarTrecho.add(cod_assentoTrecho);
			textoCod_assentoTrecho.setBounds(30, 130, 200, 20);
			painelCadastrarTrecho.add(textoCod_assentoTrecho);
			
			aero_origemTrecho.setBounds(30, 150, 250, 15);
			painelCadastrarTrecho.add(aero_origemTrecho);
			textoAero_origemTrecho.setBounds(30, 170, 200, 20);
			painelCadastrarTrecho.add(textoAero_origemTrecho);
			
			aero_destinoTrecho.setBounds(30, 190, 300, 15);
			painelCadastrarTrecho.add(aero_destinoTrecho);
			textoAero_destinoTrecho.setBounds(30, 210, 200, 20);
			painelCadastrarTrecho.add(textoAero_destinoTrecho);
		
			botaoOkTrecho.setBounds(80, 230, 100, 20);
			painelCadastrarTrecho.add(botaoOkTrecho);
			
			botaoOkTrecho.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Trecho m=new Trecho();
						m.setOrigem(Integer.parseInt(textoOrigemTrecho.getText()));
						m.setDestino(Integer.parseInt(textoDestinoTrecho.getText()));
						m.setCod_assento(Integer.parseInt(textoCod_assentoTrecho.getText()));
						m.setAero_origem(Integer.parseInt(textoAero_origemTrecho.getText()));
						m.setAero_destino(Integer.parseInt(textoAero_destinoTrecho.getText()));
						
						tabelaTrecho.adicionarTrecho(m);
						
					} catch (InsertException | SelectException |NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar trecho", JOptionPane.ERROR_MESSAGE);
					}

					textoOrigemTrecho.setText("");
					textoDestinoTrecho.setText("");
					textoCod_assentoTrecho.setText("");
					textoAero_origemTrecho.setText("");
					textoAero_destinoTrecho.setText("");
				}
			});
			
			botaoAdicionarTrecho.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelCadastrarTrecho);
						
				}
			});
			
			//Alterar trecho-----------------------------------------------------------------------------------------------------------------
			
			painelAlteraTrecho.setBounds(30, 30, 300, 300);
			painelAlteraTrecho.setLayout(null);
			
			origemTrechoAlterar.setBounds(30, 20, 200, 15);
			painelAlteraTrecho.add(origemTrechoAlterar);
			textoOrigemTrechoAlterar.setBounds(30, 40, 200, 20);
			painelAlteraTrecho.add(textoOrigemTrechoAlterar);
			
			destinoTrechoAlterar.setBounds(30, 60, 270, 15);
			painelAlteraTrecho.add(destinoTrechoAlterar);
			textoDestinoTrechoAlterar.setBounds(30, 80, 200, 20);
			painelAlteraTrecho.add(textoDestinoTrechoAlterar);
			
			cod_assentoTrechoAlterar.setBounds(30, 100, 290, 15);
			painelAlteraTrecho.add(cod_assentoTrechoAlterar);
			textoCod_assentoTrechoAlterar.setBounds(30, 120, 200, 20);
			painelAlteraTrecho.add(textoCod_assentoTrechoAlterar);
			
			aero_origemTrechoAlterar.setBounds(30, 140, 290, 15);
			painelAlteraTrecho.add(aero_origemTrechoAlterar);
			textoAero_origemTrechoAlterar.setBounds(30, 160, 200, 20);
			painelAlteraTrecho.add(textoAero_origemTrechoAlterar);
			
			aero_destinoTrechoAlterar.setBounds(30, 180, 290, 15);
			painelAlteraTrecho.add(aero_destinoTrechoAlterar);
			textoAero_destinoTrechoAlterar.setBounds(30, 200, 200, 20);
			painelAlteraTrecho.add(textoAero_destinoTrechoAlterar);
			
			botaoTrechoAlterado.setBounds(80, 230, 100, 20);
			painelAlteraTrecho.add(botaoTrechoAlterado);
			
			botaoTrechoAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Trecho m=new Trecho();
						m.setCod_trecho(Integer.parseInt(textoIdTrecho.getText()));
						m.setOrigem(Integer.parseInt(textoOrigemTrechoAlterar.getText()));
						m.setDestino(Integer.parseInt(textoDestinoTrechoAlterar.getText()));
						m.setCod_assento(Integer.parseInt(textoCod_assentoTrechoAlterar.getText()));
						m.setAero_origem(Integer.parseInt(textoAero_origemTrechoAlterar.getText()));
						m.setAero_destino(Integer.parseInt(textoAero_destinoTrechoAlterar.getText()));
						tabelaTrecho.alterarTrecho(m);
						
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar trecho", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarTrecho);	
					
				}
			});
	
	//painel pega id do trecho  que vai ser alterado
		
			painelAlterarTrecho.setBounds(30, 30, 300, 300);
			painelAlterarTrecho.setLayout(null);
			
			escolhaIdTrecho.setBounds(20, 20, 350, 15);
			painelAlterarTrecho.add(escolhaIdTrecho);
			textoIdTrecho.setBounds(30, 50, 200, 25);
			painelAlterarTrecho.add(textoIdTrecho);
			
			botaoOkAlterarTrecho.setBounds(80, 90, 100, 20);
			painelAlterarTrecho.add(botaoOkAlterarTrecho);
			
			
			botaoOkAlterarTrecho.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoOrigemTrechoAlterar.setText(String.valueOf(tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).getOrigem()));
						textoDestinoTrechoAlterar.setText(String.valueOf(tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).getDestino()));
						textoCod_assentoTrechoAlterar.setText(String.valueOf(tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).getCod_assento()));
						textoAero_origemTrechoAlterar.setText(String.valueOf(tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).getAero_origem()));
						textoAero_destinoTrechoAlterar.setText(String.valueOf(tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).getAero_destino()));
						
						painelScrollTabela.setViewportView(painelAlteraTrecho);
						
						tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).setCod_trecho(tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).getCod_trecho());
						
						tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).setOrigem(Integer.parseInt(textoOrigemTrechoAlterar.getText()));
						tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).setDestino(Integer.parseInt(textoDestinoTrechoAlterar.getText()));
						tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).setCod_assento(Integer.parseInt(textoCod_assentoTrechoAlterar.getText()));
						tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).setAero_origem(Integer.parseInt(textoAero_origemTrechoAlterar.getText()));
						tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())).setAero_destino(Integer.parseInt(textoAero_destinoTrechoAlterar.getText()));
						
						tabelaTrecho.alterarTrecho(tabelaTrecho.selectTrecho(Integer.parseInt(textoIdTrecho.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar isso Trecho", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarTrecho.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarTrecho);		
				}
			});
			
			//deletar Trecho
			painelRemoverTrecho.setBounds(30, 30, 300, 300);
			painelRemoverTrecho.setLayout(null);
			
			escolhaIdRemoverTrecho.setBounds(20, 20, 350, 15);
			painelRemoverTrecho.add(escolhaIdRemoverTrecho);
			textoIdRemoverTrecho.setBounds(30, 50, 200, 25);
			painelRemoverTrecho.add(textoIdRemoverTrecho);
			
			botaoOkRemoveTrecho.setBounds(80, 90, 100, 20);
			painelRemoverTrecho.add(botaoOkRemoveTrecho);
			
			botaoOkRemoveTrecho.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaTrecho.removerTrecho(Integer.parseInt(textoIdRemoverTrecho.getText()));
						painelScrollTabela.setViewportView(mostrarTrecho);
						textoIdRemoverTrecho.setText("");
						
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover Trecho", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverTrecho.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverTrecho);
				}
			});
			
			
			///////////////////////////V O O S//////////////////////////////////////////////////////////////////////////////
			 //Mostrar Voo-----------------------------------------------------------------------------------------------------
			mostrarVoo=new JTable(tabelaVoo);
			mostrarVoo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarVoo.getColumnModel().getColumn(0).setPreferredWidth(150);
			mostrarVoo.getColumnModel().getColumn(1).setPreferredWidth(150);
			mostrarVoo.getColumnModel().getColumn(2).setPreferredWidth(150);
			mostrarVoo.getColumnModel().getColumn(3).setPreferredWidth(150);
			
			botaoMostrarVoo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(mostrarVoo);
				}
			});
			painelScrollTabela.setViewportView(mostrarVoo);
			
			//Cadastrar Voo-----------------------------------------------------------------------------------------------------
			painelCadastrarVoo.setBounds(30, 30, 300, 300);
			painelCadastrarVoo.setLayout(null);
			
			classeVoo.setBounds(30, 20, 250, 15);
			painelCadastrarVoo.add(classeVoo);
			textoClasseVoo.setBounds(30, 40, 200, 20);
			painelCadastrarVoo.add(textoClasseVoo);
			
			cod_dthoraVoo.setBounds(30, 70, 300, 15);
			painelCadastrarVoo.add(cod_dthoraVoo);
			textoCod_dthoraVoo.setBounds(30, 90, 200, 20);
			painelCadastrarVoo.add(textoCod_dthoraVoo);
			
			cod_trechoVoo.setBounds(30, 110, 250, 15);
			painelCadastrarVoo.add(cod_trechoVoo);
			textoCod_trechoVoo.setBounds(30, 130, 200, 20);
			painelCadastrarVoo.add(textoCod_trechoVoo);
		
			botaoOkVoo.setBounds(80, 230, 100, 20);
			painelCadastrarVoo.add(botaoOkVoo);
			
			botaoOkVoo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Voos m=new Voos();
						m.setCod_dtHora(Integer.parseInt(textoCod_dthoraVoo.getText()));
						m.setCod_trecho(Integer.parseInt(textoCod_trechoVoo.getText()));
						m.setClasse(textoClasseVoo.getText());
						
						tabelaVoo.adicionarVoos(m);
						
					} catch (InsertException | SelectException |NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar voo", JOptionPane.ERROR_MESSAGE);
					}

					textoClasseVoo.setText("");
					textoCod_dthoraVoo.setText("");
					textoCod_trechoVoo.setText("");
					
				}
			});
			
			botaoAdicionarVoo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelCadastrarVoo);
						
				}
			});
			
			//Alterar voo-----------------------------------------------------------------------------------------------------------------
			
			painelAlteraVoo.setBounds(30, 30, 300, 300);
			painelAlteraVoo.setLayout(null);
			
			classeVooAlterar.setBounds(30, 20, 200, 15);
			painelAlteraVoo.add(classeVooAlterar);
			textoClasseVooAlterar.setBounds(30, 40, 200, 20);
			painelAlteraVoo.add(textoClasseVooAlterar);
			
			cod_dthoraVooAlterar.setBounds(30, 60, 270, 15);
			painelAlteraVoo.add(cod_dthoraVooAlterar);
			textoCod_dthoraVooAlterar.setBounds(30, 80, 200, 20);
			painelAlteraVoo.add(textoCod_dthoraVooAlterar);
			
			cod_trechoVooAlterar.setBounds(30, 100, 290, 15);
			painelAlteraVoo.add(cod_trechoVooAlterar);
			textoCod_trechoVooAlterar.setBounds(30, 120, 200, 20);
			painelAlteraVoo.add(textoCod_trechoVooAlterar);
			
			botaoVooAlterado.setBounds(80, 230, 100, 20);
			painelAlteraVoo.add(botaoVooAlterado);
			
			botaoVooAlterado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Voos m=new Voos();
						m.setCodVoo(Integer.parseInt(textoIdVoo.getText()));
						m.setCod_dtHora(Integer.parseInt(textoCod_dthoraVooAlterar.getText()));
						m.setCod_trecho(Integer.parseInt(textoCod_trechoVooAlterar.getText()));
						m.setClasse(textoClasseVooAlterar.getText());
						tabelaVoo.alterarVoos(m);
						
					} catch (UpdateException|NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar voo", JOptionPane.ERROR_MESSAGE);
					}
					
					painelScrollTabela.setViewportView(mostrarVoo);	
					
				}
			});
	
	//painel pega id do voo  que vai ser alterado
		
			painelAlterarVoo.setBounds(30, 30, 300, 300);
			painelAlterarVoo.setLayout(null);
			
			escolhaIdVoo.setBounds(20, 20, 350, 15);
			painelAlterarVoo.add(escolhaIdVoo);
			textoIdVoo.setBounds(30, 50, 200, 25);
			painelAlterarVoo.add(textoIdVoo);
			
			botaoOkAlterarVoo.setBounds(80, 90, 100, 20);
			painelAlterarVoo.add(botaoOkAlterarVoo);
			
			
			botaoOkAlterarVoo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						textoClasseVooAlterar.setText(tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())).getClasse());
						textoCod_dthoraVooAlterar.setText(String.valueOf(tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())).getCod_dtHora()));
						textoCod_trechoVooAlterar.setText(String.valueOf(tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())).getCod_trecho()));
						
						painelScrollTabela.setViewportView(painelAlteraVoo);
						
						tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())).setCodVoo(tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())).getCodVoo());
						
						tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())).setCod_dtHora(Integer.parseInt(textoCod_dthoraVooAlterar.getText()));
						tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())).setCod_trecho(Integer.parseInt(textoCod_trechoVooAlterar.getText()));
						tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())).setClasse(textoClasseVooAlterar.getText());
						tabelaVoo.alterarVoos(tabelaVoo.selectVoos(Integer.parseInt(textoIdVoo.getText())));
						
					} catch (NumberFormatException | UpdateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar isso Voo", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarVoo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarVoo);		
				}
			});
			
			//deletar Voo
			painelRemoverVoo.setBounds(30, 30, 300, 300);
			painelRemoverVoo.setLayout(null);
			
			escolhaIdRemoverVoo.setBounds(20, 20, 350, 15);
			painelRemoverVoo.add(escolhaIdRemoverVoo);
			textoIdRemoverVoo.setBounds(30, 50, 200, 25);
			painelRemoverVoo.add(textoIdRemoverVoo);
			
			botaoOkRemoveVoo.setBounds(80, 90, 100, 20);
			painelRemoverVoo.add(botaoOkRemoveVoo);
			
			botaoOkRemoveVoo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						tabelaVoo.removerVoos(Integer.parseInt(textoIdRemoverVoo.getText()));
						painelScrollTabela.setViewportView(mostrarVoo);
						textoIdRemoverVoo.setText("");
						
					} catch (NumberFormatException | SelectException | DeleteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover voo", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			botaoRemoverVoo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelRemoverVoo);
				}
			});
			
			
}
		
	
	public static void main(String[] args) {
		Passagem frame=new Passagem();
		frame.setVisible(true);

	}
}
