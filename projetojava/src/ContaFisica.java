import java.util.*;

public class ContaFisica  extends Pessoa {
    Scanner sc = new Scanner(System.in);
    private int id;
    private double saldo;
    private String cpf;
    private String senha;
    private List<String> historicoTransacoes;
    private List<Double> categoriaSaude,categoriaMoradia,categoriaLazer,categoriaTransporte,categoriaAlimentacao;
    private int categoriaId;
    private double totalSaude, totalMoradia, totalLazer, totalTransporte, totalAlimentacao;
    private double totalDeposito;
    private double totalSaque;
    private double meta, poupanca;

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public int getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public ContaFisica() {
        saldo = 0.0;
        categoriaSaude = new ArrayList<>();
        categoriaMoradia = new ArrayList<>();
        categoriaLazer = new ArrayList<>();
        categoriaTransporte = new ArrayList<>();
        categoriaAlimentacao = new ArrayList<>();
        historicoTransacoes = new ArrayList<>();
        totalDeposito = 0.0;
        totalSaque = 0.0;
        totalSaude = 0.0;
        totalMoradia = 0.0;
        totalLazer = 0.0;
        totalTransporte = 0.0;
        totalAlimentacao = 0.0;
        poupanca = 0.0;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public void exibirInformacoes() {
        System.out.println("------------------------------");
        System.out.println("Informacoes sobre a conta:");
        System.out.println("------------------------------");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("CPF: " + getCpf());
    }
    public void definirMeta() {
        System.out.println("Defina o valor de sua meta financeira: ");
        setMeta(sc.nextDouble());
    }
    public void metaFinanceira() {
        System.out.println("------------------------------");
        System.out.println("Metas Financeiras:");
        System.out.println("------------------------------");
        System.out.println("Objetivo Financeiro: " + getMeta());
        System.out.println("Poupanca: " + poupanca);
        System.out.println("Faltam R$ " + (meta - poupanca) + " para atingir sua Meta Financeira" );
    }
    public void exibirOpcoesCategorias() {
        System.out.println("\nMenu Conta:");
        System.out.println("1 - Saude");
        System.out.println("2 - Moradia");
        System.out.println("3 - Lazer");
        System.out.println("4 - Transporte");
        System.out.println("5 - Alimentacao");
        System.out.println("6 - Poupanca");
        System.out.println("0 - Sair");


    }

    private String obterDescricaoCategoria(int categoriaId) {
        return switch (categoriaId) {
            case 1 -> "Saúde";
            case 2 -> "Moradia";
            case 3 -> "Lazer";
            case 4 -> "Transporte";
            case 5 -> "Alimentação";
            case 6 -> "Poupanca";
            default -> "Categoria inválida";
        };
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
        if (valorDepositado > 0) {
            totalDeposito += valorDepositado;
        }

        historicoTransacoes.add("Valor depositado de: R$ " + valorDepositado);
    }

    public void sacarFisica(Transacao transacao) {
        System.out.println("Quanto voce deseja sacar? ");
        transacao.setValor(sc.nextDouble());

        double saldoAtual = getSaldo();
        double valorDeSaque = Transacao.getValor();

        if (valorDeSaque <= saldoAtual) {
            exibirOpcoesCategorias();
            setCategoriaId(sc.nextInt());
            String descricaoCategoria = obterDescricaoCategoria(categoriaId);
            transacao.setDescricao(descricaoCategoria);
            double novoSaldo = saldoAtual - valorDeSaque;
            setSaldo(novoSaldo);
            System.out.println("Saque realizado com sucesso");
            System.out.println("Saldo Atual: " + getSaldo());
            System.out.println("Categoria: " + obterDescricaoCategoria(categoriaId));
            System.out.println("Data do saque: " + transacao.getDataFormatada());
            System.out.println("Valor do saque: " + valorDeSaque);
        } else {
            System.out.println("Saldo insuficiênte!");
            System.out.println("Digite um valor valido.");
            sacarFisica(transacao);
        }
        if (valorDeSaque > 0 && valorDeSaque <= saldoAtual) {
            totalSaque += valorDeSaque;
        }
        if (categoriaId == 1) {
            categoriaSaude.add(valorDeSaque);
            totalSaude += valorDeSaque;
        } else if (categoriaId == 2) {
            categoriaMoradia.add(valorDeSaque);
            totalMoradia += valorDeSaque;
        } else if (categoriaId == 3) {
            categoriaLazer.add(valorDeSaque);
            totalLazer += valorDeSaque;
        } else if (categoriaId == 4) {
            categoriaTransporte.add(valorDeSaque);
            totalTransporte += valorDeSaque;
        } else if (categoriaId == 5) {
            categoriaAlimentacao.add(valorDeSaque);
            totalAlimentacao += valorDeSaque;
        } else if (categoriaId ==6) {
            poupanca += valorDeSaque;
        }
        historicoTransacoes.add("Valor do saque de: R$ " + valorDeSaque);
    }

    public void exibirHistoricoTransacoes() {
        System.out.println("------------------------------");
        System.out.println("Total de Depósitos: R$ " + totalDeposito);
        System.out.println("Total de Saques: R$ " + totalSaque);
        System.out.println("------------------------------");
        System.out.println("Histórido de transações: ");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }
    public void exibirPorCategoria() {
        System.out.println("------------------------------");
        System.out.println("Relatório de gastos por categoria: ");
        System.out.println("------------------------------");
        System.out.println("Gastos com Saúde: ");
        for (Double catSaude : categoriaSaude) {
            System.out.println(catSaude);
        }
        System.out.println("Total gasto com Saúde: " + totalSaude);
        System.out.println("------------------------------");
        System.out.println("Gastos com Moradia: ");
        for (Double catMoradia : categoriaMoradia) {
            System.out.println(catMoradia);
        }
        System.out.println("Total gasto com Moradia: " + totalMoradia);
        System.out.println("------------------------------");
        System.out.println("Gastos com Lazer: ");
        for (Double catLazer : categoriaLazer) {
            System.out.println(catLazer);
        }
        System.out.println("Total gasto com Lazer: " + totalLazer);
        System.out.println("------------------------------");
        System.out.println("Gastos com Transporte: ");
        for (Double catTransporte : categoriaTransporte) {
            System.out.println(catTransporte);
        }
        System.out.println("Total gasto com Transporte: " + totalTransporte);
        System.out.println("------------------------------");
        System.out.println("Gastos com Alimentacao: ");
        for (Double catAlimentacao : categoriaAlimentacao) {
            System.out.println(catAlimentacao);
        }
        System.out.println("Total gasto com Alimentacao: " + totalAlimentacao);
        System.out.println("------------------------------");

        System.out.println("Valor Destinado a Poupanca: " + poupanca);
    }

    public void add(ContaFisica contas) {
    }
}
