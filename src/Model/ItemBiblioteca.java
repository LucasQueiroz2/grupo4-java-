package Model;

public abstract class ItemBiblioteca implements Exibivel {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantidadeDisponivel;

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao, int quantidadeDisponivel)
            throws CampoVazioException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new CampoVazioException("Título não pode ser vazio");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new CampoVazioException("Autor não pode ser vazio");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public abstract void exibirInformacoes();
}
