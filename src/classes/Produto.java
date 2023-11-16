package classes;

public class Produto {
    private String nome;
    private String codigo;
    private String categoria;
    private float preco;

    public Produto(String codigo,String nome, String categoria, float preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public String mostrarDados(){
        return  "Código: " + this.codigo +
                "\nNome: " + this.nome +
                "\nCategoria: " + this.categoria +
                "\nPreço: " + this.preco;
    }
}
