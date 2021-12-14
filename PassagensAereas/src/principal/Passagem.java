package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dados.*;
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
	private JPanel painelAeronaveAltera=new JPanel();
	private JButton botaoAlterarAeronave=new JButton("Alterar Aeronave");
	private JButton botaoAeronaveAlterado=new JButton("Alterar");
	
	//cadastrar passageiro
	private JButton botaoMostrarPassageiro=new JButton("Mostrar Passageiro");
	private JTable mostrarPassageiro;
	private TabelaPassageiro tabelaPassageiro=new TabelaPassageiro();
	private JPanel painelCadastrarPassageiro=new JPanel();
	private JLabel nomePassageiro=new JLabel("Digite o nome da passageiro:");
	private JTextField textoNomePassageiro =new JTextField();
	private JButton botaoOkPassageiro=new JButton("OK");
	private JButton botaoAdicionarPassageiro=new JButton("Cadastrar Passageiro");
	
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
		botaoMostrarAeronave.setBounds(30, 400, 157, 25);
		painel.add(botaoMostrarAeronave);
		botaoAdicionarAeronave.setBounds(30, 500, 157, 25);
		painel.add(botaoAdicionarAeronave);
		botaoMostrarPassageiro.setBounds(30, 350, 157, 25);
		painel.add(botaoMostrarPassageiro);
		botaoAdicionarPassageiro.setBounds(30, 300, 157, 25);
		painel.add(botaoAdicionarPassageiro);
		
		///////////////////////////////////A E R O N A V E///////////////////////////////////////////////////////////////////////
        //Mostrar Aeronave----------------------------------------------------------------------------------------------------------
		mostrarAeronave=new JTable(tabelaAeronave);
		mostrarAeronave.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mostrarAeronave.getColumnModel().getColumn(0).setMaxWidth(40);
		mostrarAeronave.getColumnModel().getColumn(1).setPreferredWidth(150);
		mostrarAeronave.getColumnModel().getColumn(2).setPreferredWidth(40);
		//mostrarAeronave.getColumnModel().getColumn(3).setPreferredWidth(90);
		//mostrarAeronave.getColumnModel().getColumn(4).setPreferredWidth(130);
		//mostrarAeronave.getColumnModel().getColumn(5).setPreferredWidth(150);
		
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
		botaoAlterarAeronave.setBounds(30, 450, 157, 25);
		painel.add(botaoAlterarAeronave);
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
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar medico", JOptionPane.ERROR_MESSAGE);
					}
					
							
					
				}
			});
			
	    	
			
			botaoAlterarAeronave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelScrollTabela.setViewportView(painelAlterarAeronave);		
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
			
}
		
	
	public static void main(String[] args) {
		Passagem frame=new Passagem();
		frame.setVisible(true);

	}
}
