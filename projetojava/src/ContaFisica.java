import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ContaFisica  extends Pessoa{
    Scanner sc = new Scanner(System.in);
    private int id;
    private double saldo;
    private String cpf;
    private Transacao transacao;
    private String senha;
    private List<String>historicoTransacoes;

    private double totalDeposito;
    private double totalSaque;


    public ContaFisica(){
        saldo = 0.0;
        historicoTransacoes = new ArrayList<>();
        totalDeposito = 0.0;
        totalSaque = 0.0;
    }
    public void depositar(double valor) {
        if (valor > 0){
            saldo += valor;
            totalDeposito += valor;
        }
    }
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo){
            saldo -= valor;
            totalSaque += valor;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositarFisica(Transacao transacao) {
        double saldoAtual = getSaldo();

        System.out.print("Quanto voce deseja depositar? ");
        transacao.setValor(sc.nextDouble());

        double valorDepositado = Transacao.getValor();

        if (valorDepositado > 0) {
            double novoSaldo = saldoAtual + valorDepositado;
            setSaldo(novoSaldo);
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Novo saldo: " + getSaldo());
        } else {
            System.out.println("Valor inserido incorretamente");
            depositarFisica(transacao);
        }
        if (valorDepositado > 0){
            saldo += valorDepositado;
            totalDeposito += valorDepositado;
        }
        historicoTransacoes.add("Valor depositado de: R$ "+ valorDepositado);
    }

    public void sacarFisica(Transacao transacao) {
        System.out.println("Quanto voce deseja sacar? ");
        transacao.setValor(sc.nextDouble());

        double saldoAtual = getSaldo();
        double valorDeSaque= Transacao.getValor();

        if (valorDeSaque <= saldoAtual) {
            System.out.println("Descricao do pagamento: ");
            transacao.setDescricao(sc.next());
            System.out.println("Coloque a data de pagamento: ");
            transacao.setData(sc.next());
            double novoSaldo = saldoAtual - valorDeSaque;
            setSaldo(novoSaldo);
            System.out.println("Saque realizado com sucesso");
            System.out.println("Saldo Atual: " + getSaldo());
            System.out.println("Descricao: " + transacao.getDescricao());
            System.out.println("Data do saque: " + transacao.getData());
            System.out.println("Valor do saque: " + valorDeSaque);
        }else {
            System.out.println("Saldo insuficiênte!");
            System.out.println("Digite um valor valido.");
            sacarFisica(transacao);
        }
        if (valorDeSaque > 0 && valorDeSaque <= saldo){
            saldo -= valorDeSaque;
            totalSaque += valorDeSaque;
        }

        historicoTransacoes.add("Valor do saque de: R$ "+ valorDeSaque);
    }

    public void exibirHistoricoTransacoes(){
        System.out.println("Histórido de transações: ");
        for(String transacao: historicoTransacoes){
            System.out.println(transacao);
        }
        System.out.println("------------------------------");
        System.out.println("Total de Depósitos: R$ "+ totalDeposito);
        System.out.println("Total de Saques: R$ "+ totalSaque);
        System.out.println("------------------------------");


    }



    public void add(ContaFisica contas) {
    }
}
