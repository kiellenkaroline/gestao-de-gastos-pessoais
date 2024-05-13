import java.util.ArrayList;

public class ListaDeCategorias {

    private ArrayList<Categoria> categorias;


    public ListaDeCategorias() {
        this.categorias = new ArrayList<>();
    }


    public Categoria obterCategoriaPorId(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    public ArrayList<Categoria> getAllCategorias() {
        return categorias;
    }


Categoria categoriaSaude = new Categoria(1, "Saúde");
Categoria categoriaMoradia = new Categoria(2, "Moradia");
Categoria categoriaLazer = new Categoria(3, "Lazer");
Categoria categoriaTransporte = new Categoria(4, "Transporte");
Categoria categoriaAlimentacao = new Categoria(5, "Alimentação");

}
