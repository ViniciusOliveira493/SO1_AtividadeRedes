package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
	public static void main(String[] args) {
		RedesController rc = new RedesController();
		int escolha = 0;
		while (escolha!=9) {
			escolha = Integer.parseInt(JOptionPane.showInputDialog
					("Digite 1 para obter os Apadtadores de rede \n"
	                  + "Digite 2 para testar o ping \n"
	                  + "Digite 9 para encerrar"));
			switch (escolha) {
			case 1:
				JOptionPane.showMessageDialog(null, rc.ip());
				break;
			case 2:
				JOptionPane.showMessageDialog(null, rc.ping());
				break;	
			case 9:
				System.exit(0);
				break;	
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida !");
				break;
			}
			
		}
		
		
	}
}
