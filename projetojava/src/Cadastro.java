import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    private List<Pessoa> pessoas = new ArrayList<>();
    private List<ContaFisica> contas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public ContaFisica cadastrarContaFisica() {
        ContaFisica cf = new ContaFisica();

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

        return cf; //
    }

    public void cadastrarPessoa( Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public void cadastraConta(ContaFisica contas){
        contas.add(contas);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<ContaFisica> getContas() {
        return contas;
    }

}
