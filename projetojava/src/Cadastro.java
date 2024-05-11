import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Pessoa> pessoas = new ArrayList<>();
    private List<ContaFisica> contas = new ArrayList<>();

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
