public class Saque {
    private Conta conta;
    private boolean realizado;

    public Saque(Conta conta) {
        this.conta = conta;
        this.realizado = false;
    }

    public void executarSaque(double valor) {
        if (!realizado) {
            if (conta.sacar(valor)) {
                System.out.println("Saque de R$" + valor + " realizado com sucesso!");
                realizado = true;
            } else {
                System.out.println("Não foi possível realizar o saque. Saldo insuficiente.");
            }
        } else {
            System.out.println("Este saque já foi realizado anteriormente.");
        }
    }

