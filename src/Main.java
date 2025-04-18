
public class Main {

	public static void main(String[] args) {
		String nome = "Dionny";
		String cpf = "12345678901";
		String telefone = "12976473244";

		Cliente dionny = new Cliente(nome, cpf, telefone);
		
		Conta cc = new ContaCorrente(dionny);
		Conta poupanca = new ContaPoupanca(dionny);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		poupanca.depositar(150);
		cc.depositar(200);
		cc.sacar(50);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		cc.exibirHistorico();
		poupanca.exibirDadosCliente();
	}

}
