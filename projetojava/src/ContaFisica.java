import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ContaFisica  extends Pessoa{
    Scanner sc = new Scanner(System.in);
    private int id;
    private double saldo;
    private String cpf;
    private Transacao transacao;
    private String senha;
    private List<String>historicoTransacoes;
    private int categoriaId;

    private double totalDeposito;
    private double totalSaque;


    public ContaFisica(){
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
        if (valorDepositado > 0){
            saldo += valorDepositado;
            totalDeposito += valorDepositado;
        }
        historicoTransacoes.add("Valor depositado de: R$ "+ valorDepositado);
    }

    public void sacarFisica(Transacao transacao) {
        System.out.println("Quanto voce deseja sacar? ");
        transacao.setValor(sc.nextDouble());

        double saldoAtual = getSaldo();
        double valorDeSaque= Transacao.getValor();

        if (valorDeSaque <= saldoAtual) {
            System.out.println("Descricao do pagamento: ");
            transacao.setDescricao(sc.next());
            System.out.println("Coloque a data de pagamento: ");
            transacao.setData(sc.next());
            double novoSaldo = saldoAtual - valorDeSaque;
            setSaldo(novoSaldo);
            System.out.println("Saque realizado com sucesso");
            System.out.println("Saldo Atual: " + getSaldo());
            System.out.println("Descricao: " + transacao.getDescricao());
            System.out.println("Data do saque: " + transacao.getData());
            System.out.println("Valor do saque: " + valorDeSaque);
        }else {
            System.out.println("Saldo insuficiênte!");
            System.out.println("Digite um valor valido.");
            sacarFisica(transacao);
        }
        if (valorDeSaque > 0 && valorDeSaque <= saldo){
            saldo -= valorDeSaque;
            totalSaque += valorDeSaque;
        }

        historicoTransacoes.add("Valor do saque de: R$ "+ valorDeSaque);
    }

    public void exibirHistoricoTransacoes(){
        System.out.println("Histórido de transações: ");
        for(String transacao: historicoTransacoes){
            System.out.println(transacao);
        }
        System.out.println("------------------------------");
        System.out.println("Total de Depósitos: R$ "+ totalDeposito);
        System.out.println("Total de Saques: R$ "+ totalSaque);
        System.out.println("------------------------------");


    }
    public void add(ContaFisica contas) {
    }

    public Map<Categoria, Double> calcularGastosPorCategoria() {
        Map<Categoria, Double> gastosPorCategoria = new HashMap<>();
    
        for (Transacao transacao : transacoes) {
            Categoria categoria = transacao.getCategoria(); 
    
            if (gastosPorCategoria.containsKey(categoria)) {
                double totalGastoCategoria = gastosPorCategoria.get(categoria);
                totalGastoCategoria += transacao.getValor(); 
                gastosPorCategoria.put(categoria, totalGastoCategoria);
            }else {
                gastosPorCategoria.put(categoria, transacao.getValor()); 
            }
        }
    
        return gastosPorCategoria;
    }

    public String gerarRelatorioGastosPorCategoria() {
        StringBuilder sb = new StringBuilder();
        sb.append("## Relatório de Gastos por Categoria\n\n");

        Map<Categoria, Double> gastosPorCategoria = calcularGastosPorCategoria();
        double totalGeral = 0.0; 

        for (Map.Entry<Categoria, Double> entry : gastosPorCategoria.entrySet()) {
            Categoria categoria = entry.getKey();
            Double totalGasto = entry.getValue();

            totalGeral += totalGasto; 

            sb.append("Categoria: ").append(categoria.getNome())
                    .append(" - Total Gasto: ").append(formatarMoeda(totalGasto)).append("\n");
        }

        sb.append("\nTotal Geral de Gastos: ").append(formatarMoeda(totalGeral)).append("\n");

        return sb.toString();
    }
}

