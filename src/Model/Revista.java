package Model;

public class Revista extends ItemBiblioteca {
    private String issn;
    private int numeroEdicao;
    private String mesPublicacao;

    public Revista(String titulo, String autor, int anoPublicacao, int quantidadeDisponivel,
                   String issn, int numeroEdicao, String mesPublicacao) throws CampoVazioException {
        super(titulo, autor, anoPublicacao, quantidadeDisponivel);

        if (issn == null || issn.trim().isEmpty()) {
            throw new CampoVazioException("ISSN não pode ser vazio");
        }

        this.issn = issn;
        this.numeroEdicao = numeroEdicao;
        this.mesPublicacao = mesPublicacao;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Revista");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano de Publicação: " + getAnoPublicacao());
        System.out.println("Quantidade Disponível: " + getQuantidadeDisponivel());
        System.out.println("ISSN: " + issn);
        System.out.println("Número da Edição: " + numeroEdicao);
        System.out.println("Mês de Publicação: " + mesPublicacao);
        System.out.println("---------------------------");
    }


    public String getIssn() {
        return issn;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public String getMesPublicacao() {
        return mesPublicacao;
    }
}
