package view;

import java.util.Scanner;

import Model.*;
import controller.BibliotecaController;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static BibliotecaController controller = new BibliotecaController();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Digite sua opção: ");

            try {
                switch (opcao) {
                    case 1:
                        cadastrarLivro();
                        break;
                    case 2:
                        cadastrarRevista();
                        break;
                    case 3:
                        cadastrarTrabalhoAcademico();
                        break;
                    case 4:
                        controller.exibirTodosItens();
                        break;
                    case 5:
                        buscarItemPorTitulo();
                        break;
                    case 6:
                        removerItem();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (CampoVazioException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (ItemNaoEncontradoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }

            System.out.println();
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA ===");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Cadastrar Revista");
        System.out.println("3. Cadastrar Trabalho Acadêmico");
        System.out.println("4. Listar Todos os Itens");
        System.out.println("5. Buscar Item por Título");
        System.out.println("6. Remover Item");
        System.out.println("0. Sair");
    }

    private static void cadastrarLivro() throws CampoVazioException {
        System.out.println("\n--- CADASTRO DE LIVRO ---");
        String titulo = lerString("Título: ");
        String autor = lerString("Autor: ");
        int ano = lerInteiro("Ano de Publicação: ");
        int quantidade = lerInteiro("Quantidade Disponível: ");
        String isbn = lerString("ISBN: ");
        int paginas = lerInteiro("Número de Páginas: ");
        String genero = lerString("Gênero: ");

        Livro livro = new Livro(titulo, autor, ano, quantidade, isbn, paginas, genero);
        controller.adicionarItem(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void cadastrarRevista() throws CampoVazioException {
        System.out.println("\n--- CADASTRO DE REVISTA ---");
        String titulo = lerString("Título: ");
        String autor = lerString("Autor: ");
        int ano = lerInteiro("Ano de Publicação: ");
        int quantidade = lerInteiro("Quantidade Disponível: ");
        String issn = lerString("ISSN: ");
        int edicao = lerInteiro("Número da Edição: ");
        String mes = lerString("Mês de Publicação: ");

        Revista revista = new Revista(titulo, autor, ano, quantidade, issn, edicao, mes);
        controller.adicionarItem(revista);
        System.out.println("Revista cadastrada com sucesso!");
    }

    private static void cadastrarTrabalhoAcademico() throws CampoVazioException {
        System.out.println("\n--- CADASTRO DE TRABALHO ACADÊMICO ---");
        String titulo = lerString("Título: ");
        String autor = lerString("Autor: ");
        int ano = lerInteiro("Ano de Publicação: ");
        int quantidade = lerInteiro("Quantidade Disponível: ");
        String instituicao = lerString("Instituição: ");
        String curso = lerString("Curso: ");
        String tipo = lerString("Tipo de Trabalho: ");
        String orientador = lerString("Orientador: ");

        TrabalhoAcademico trabalho = new TrabalhoAcademico(
                titulo, autor, ano, quantidade, instituicao, curso, tipo, orientador);
        controller.adicionarItem(trabalho);
        System.out.println("Trabalho Acadêmico cadastrado com sucesso!");
    }

    private static void buscarItemPorTitulo() throws ItemNaoEncontradoException {
        String titulo = lerString("Digite o título do item a ser buscado: ");
        ItemBiblioteca item = controller.buscarPorTitulo(titulo);
        System.out.println("\nItem encontrado:");
        item.exibirInformacoes();
    }

    private static void removerItem() throws ItemNaoEncontradoException {
        String titulo = lerString("Digite o título do item a ser removido: ");
        controller.removerItem(titulo);
        System.out.println("Item removido com sucesso!");
    }


    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }
}
