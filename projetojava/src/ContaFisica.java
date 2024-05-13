import java.util.Scanner;

public class ContaFisica  extends Pessoa{

    private int id;
    private double saldo;
    private String cpf;
    private Transacao transacao;

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
        double valorDepositado = Transacao.getValor();
        double novoSaldo = saldoAtual + valorDepositado;
        setSaldo(novoSaldo);
    }

    public void sacarFisica(Transacao transacao) {
        Scanner sc = new Scanner(System.in);

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
            System.out.println("Novo saldo: " + getSaldo());
            System.out.println("Descricao: " + transacao.getDescricao());
            System.out.println("Data do saque: " + transacao.getData());
            System.out.println("Valor do saque: " + valorDepositado);
        }else {
            System.out.println("Saldo insuficiênte");
        }

    }



    public void add(ContaFisica contas) {
    }
}
