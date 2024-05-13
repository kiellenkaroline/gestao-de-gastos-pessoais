import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaFisica cf = new ContaFisica();
        Transacao t = new Transacao();
        Cadastro cd = new Cadastro();
        Pessoa pessoa = new Pessoa();
        ContaFisica conta = new ContaFisica();

        System.out.println("Seja Bem Vindo ao Cadastro de Conta: ");
        System.out.println("Modalidade: Pessoa Fisica");

        System.out.print("Digite seu nome: ");
        cf.setNome(sc.nextLine());

        System.out.print("Digite sua idade: ");
        cf.setIdade(sc.nextInt());

        System.out.print("Digite seu CPF: ");
        cf.setCpf(sc.next());

        System.out.println("Conta criada com sucesso!");
        System.out.println("Carregando Informacoes...");
        System.out.println("Dados da conta: ");
        System.out.println("Nome: " + cf.getNome());
        System.out.println("Idade: " + cf.getIdade());
        System.out.println("CPF: " + cf.getCpf());

        cf.depositarFisica(t);
        cf.sacarFisica(t);
    }
}

