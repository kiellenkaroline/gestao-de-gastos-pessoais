import java.util.Scanner;

public class ContaFisica  extends Pessoa{
    Scanner sc = new Scanner(System.in);
    private int id;
    private double saldo;
    private String cpf;
    private Transacao transacao;
    private String senha;

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
    }

    public void sacarFisica(Transacao transacao) {
        System.out.println("Quanto voce deseja sacar? ");
        transacao.setValor(sc.nextDouble());

        double saldoAtual = getSaldo();
        double valorDepositado = Transacao.getValor();

        if (valorDepositado <= saldoAtual) {
            System.out.println("Descricao do pagamento: ");
            transacao.setDescricao(sc.next());
            System.out.println("Coloque a data de pagamento: ");
            transacao.setData(sc.next());
            double novoSaldo = saldoAtual - valorDepositado;
            setSaldo(novoSaldo);
            System.out.println("Saque realizado com sucesso");
            System.out.println("Saldo Atual: " + getSaldo());
            System.out.println("Descricao: " + transacao.getDescricao());
            System.out.println("Data do saque: " + transacao.getData());
            System.out.println("Valor do saque: " + valorDepositado);
        }else {
            System.out.println("Saldo insuficiênte!");
            System.out.println("Digite um valor valido.");
            sacarFisica(transacao);
        }
    }



    public void add(ContaFisica contas) {
    }
}
