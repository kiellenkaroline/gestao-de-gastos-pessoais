import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    private List<Pessoa> pessoas = new ArrayList<>();
    private List<ContaFisica> contas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public ContaFisica cadastrarContaFisica() {
        ContaFisica cf = new ContaFisica();
        MenuConta mc = new Scanner(System.in);

        public ContaFisica cadastrarContaFisica(){
            ContaFisica cf = new ContaFisica();
            MenuConta mc = new MenuConta();
        }

        System.out.println("Seja Bem Vindo ao Cadastro de Conta: ");
        System.out.println("Modalidade: Pessoa Fisica");

        System.out.print("Digite seu nome: ");
        cf.setNome(sc.nextLine());

        System.out.print("Digite sua senha:");
        cf.setSenha(sc.nextLine());

        System.out.print("Digite sua idade: ");
        cf.setIdade(sc.nextInt());

        System.out.print("Digite seu CPF: ");
        cf.setCpf(sc.next());

        contas.add(cf);

        System.out.println("Conta criada com sucesso!");
        System.out.println("Carregando Informacoes...");
        System.out.println("Dados da conta: ");
        System.out.println("Nome: " + cf.getNome());
        System.out.println("Idade: " + cf.getIdade());
        System.out.println("CPF: " + cf.getCpf());

        fazerLogin();

        return cf; //
    }

    public ContaFisica fazerLogin() {
        System.out.print("Digite seu CPF: ");
        String cpf = sc.next();
        System.out.print("Digite sua senha: ");
        String senha = sc.next();

        ContaFisica cf = verificacaoLogin(cpf, senha);
        MenuConta mc = new MenuConta();
        if (cf != null) {
            System.out.println("Login efetuado com sucesso!");
            // O bug estava aqui. mc.exibirMenuConta(sc);
        } else {
            System.out.println("CPF ou senha inválidos!");
            System.exit(0);
        }
        return cf;
    }

    public ContaFisica verificacaoLogin(String cpf, String senha) {
        for (ContaFisica cf : contas) {
            if (cf.getCpf().equals(cpf) && cf.getSenha().equals(senha)) {
                return cf;
            }
        }
        return null;
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void cadastraConta(ContaFisica conta) {
        contas.add(conta);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<ContaFisica> getContas() {
        return contas;
    }
}
