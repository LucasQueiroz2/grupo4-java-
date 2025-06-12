package Model;

public class Livro extends ItemBiblioteca {
    private String isbn;
    private int numeroPaginas;
    private String genero;

    public Livro(String titulo, String autor, int anoPublicacao, int quantidadeDisponivel,
                 String isbn, int numeroPaginas, String genero) throws CampoVazioException {
        super(titulo, autor, anoPublicacao, quantidadeDisponivel);

        if (isbn == null || isbn.trim().isEmpty()) {
            throw new CampoVazioException("ISBN não pode ser vazio");
        }

        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Livro");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano de Publicação: " + getAnoPublicacao());
        System.out.println("Quantidade Disponível: " + getQuantidadeDisponivel());
        System.out.println("ISBN: " + isbn);
        System.out.println("Número de Páginas: " + numeroPaginas);
        System.out.println("Gênero: " + genero);
        System.out.println("---------------------------");
    }


    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getGenero() {
        return genero;
    }
}
