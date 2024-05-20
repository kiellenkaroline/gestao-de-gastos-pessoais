import java.util.*;

public class ContaFisica  extends Pessoa {
    Scanner sc = new Scanner(System.in);
    private int id;
    private double saldo;
    private String cpf;
    private String senha;

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
    private List<String> historicoTransacoes;
    private int categoriaId;

    private double totalDeposito;
    private double totalSaque;


    public ContaFisica() {
        saldo = 0.0;
        historicoTransacoes = new ArrayList<>();
        totalDeposito = 0.0;
        totalSaque = 0.0;
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


    public void exibirOpcoesCategorias() {
        System.out.println("\nMenu Conta:");
        System.out.println("1 - Saude");
        System.out.println("2 - Moradia");
        System.out.println("3 - Lazer");
        System.out.println("4 - Transporte");
        System.out.println("5 - Alimentacao");
        System.out.println("0 - Sair");


    }

    private String obterDescricaoCategoria(int categoriaId) {
        return switch (categoriaId) {
            case 1 -> "Saúde";
            case 2 -> "Moradia";
            case 3 -> "Lazer";
            case 4 -> "Transporte";
            case 5 -> "Alimentação";
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

        historicoTransacoes.add("Valor do saque de: R$ " + valorDeSaque);
    }

    public void exibirHistoricoTransacoes() {
        System.out.println("Histórido de transações: ");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
        System.out.println("------------------------------");
        System.out.println("Total de Depósitos: R$ " + totalDeposito);
        System.out.println("Total de Saques: R$ " + totalSaque);
        System.out.println("------------------------------");


    }

    public void add(ContaFisica contas) {
    }
}
//    public void add(ContaFisica contas) {
//    }
//
//    public Map<Categoria, Double> calcularGastosPorCategoria() {
//        Map<Categoria, Double> gastosPorCategoria = new HashMap<>();
//
//        for (String Transacao : historicoTransacoes) {
//           String categoria = transacao.getCategoria();
//
//            if (gastosPorCategoria.containsKey(categoria)) {
//                double totalGastoCategoria = gastosPorCategoria.get(categoria);
//                totalGastoCategoria += transacao.getValor();
//                gastosPorCategoria.put(categoria, totalGastoCategoria);
//            }else {
//                gastosPorCategoria.put(categoria, transacao.getValor());
//            }
//        }
//
//        return gastosPorCategoria;
//    }
//
//    public String gerarRelatorioGastosPorCategoria() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("## Relatório de Gastos por Categoria\n\n");
//
//        Map<Categoria, Double> gastosPorCategoria = calcularGastosPorCategoria();
//        double totalGeral = 0.0;
//
//        for (Map.Entry<Categoria, Double> entry : gastosPorCategoria.entrySet()) {
//            Categoria categoria = entry.getKey();
//            Double totalGasto = entry.getValue();
//
//            totalGeral += totalGasto;
//
//            sb.append("Categoria: ").append(categoria.getNome())
//                    .append(" - Total Gasto: ").append(formatarMoeda(totalGasto)).append("\n");
//        }
//
//        sb.append("\nTotal Geral de Gastos: ").append(formatarMoeda(totalGeral)).append("\n");
//
//        return sb.toString();
//    }
