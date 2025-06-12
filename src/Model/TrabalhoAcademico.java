package Model;

public class TrabalhoAcademico extends ItemBiblioteca {
    private String instituicao;
    private String curso;
    private String tipoTrabalho;
    private String orientador;

    public TrabalhoAcademico(String titulo, String autor, int anoPublicacao, int quantidadeDisponivel,
                             String instituicao, String curso, String tipoTrabalho, String orientador)
            throws CampoVazioException {
        super(titulo, autor, anoPublicacao, quantidadeDisponivel);

        if (instituicao == null || instituicao.trim().isEmpty()) {
            throw new CampoVazioException("Instituição não pode ser vazia");
        }

        this.instituicao = instituicao;
        this.curso = curso;
        this.tipoTrabalho = tipoTrabalho;
        this.orientador = orientador;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Trabalho Acadêmico");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano de Publicação: " + getAnoPublicacao());
        System.out.println("Quantidade Disponível: " + getQuantidadeDisponivel());
        System.out.println("Instituição: " + instituicao);
        System.out.println("Curso: " + curso);
        System.out.println("Tipo de Trabalho: " + tipoTrabalho);
        System.out.println("Orientador: " + orientador);
        System.out.println("---------------------------");
    }

    public String getInstituicao() {
        return instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public String getTipoTrabalho() {
        return tipoTrabalho;
    }

    public String getOrientador() {
        return orientador;
    }
}
