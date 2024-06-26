import java.util.Date;
import java.text.SimpleDateFormat;

public class Transacao {
    private int id;
    private String descricao, categoria, data;
    private static double valor;
    Date dataTransacao = new Date();
    Date dataHoraAtual = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    public String getDataFormatada() {
        return dataFormatada;
    }

    String dataFormatada = formatador.format(dataTransacao);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
