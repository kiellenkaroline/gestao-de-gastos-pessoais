public class ContaFisica  extends Pessoa{

    private int id;
    private double saldo;
    private String cpf;

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
        double saldoAtual = getSaldo();
        double valorDepositado = Transacao.getValor();

        if (valorDepositado <= saldoAtual) {
            double novoSaldo = saldoAtual - valorDepositado;
            setSaldo(novoSaldo);
            System.out.println("Saque realizado com sucesso");
        }else {
            System.out.println("Saldo insuficiênte");
        }

    }



    public void add(ContaFisica contas) {
    }
}
