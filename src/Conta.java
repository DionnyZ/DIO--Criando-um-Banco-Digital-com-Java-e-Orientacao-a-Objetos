
import java.util.ArrayList;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected ArrayList<String> extrato = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		extrato.add("Saque: " + valor + " | Saldo: " + saldo);
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		extrato.add("Deposito: " + valor + " | Saldo: " + saldo);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		saldo -= valor;
		contaDestino.depositar(valor);
		extrato.add("Transferência: " + valor + " | Saldo: " + saldo);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	protected void exibirHistorico() {
		System.out.println("=========== Histórico ===========");
		for (String item : extrato) {
			System.out.println(item);	
		}
		System.out.println("=================================");
	}

	protected void exibirDadosCliente() {
		System.out.println("======= Dados do Cliente ========");
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("=================================");
	}
}
