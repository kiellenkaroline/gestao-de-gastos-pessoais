public class Main {
    public static void main(String[] args) {
        ContaFisica cf = new ContaFisica();
        Transacao t = new Transacao();
        Cadastro cd = new Cadastro();

        cd.cadastrarContaFisica();
        cf.depositarFisica(t);
        cf.sacarFisica(t);
    }

}

