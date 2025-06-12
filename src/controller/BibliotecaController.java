package controller;

import Model.ItemNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
        private List<Model.ItemBiblioteca> itens;

        public BibliotecaController() {
            this.itens = new ArrayList<>();
        }

        public void adicionarItem(Model.ItemBiblioteca item) {
            itens.add(item);
        }

        public List<Model.ItemBiblioteca> listarItens() {
            return new ArrayList<>(itens);
        }

        public Model.ItemBiblioteca buscarPorTitulo(String titulo) throws ItemNaoEncontradoException {
            for (Model.ItemBiblioteca item : itens) {
                if (item.getTitulo().equalsIgnoreCase(titulo)) {
                    return item;
                }
            }
            throw new ItemNaoEncontradoException("Item com título '" + titulo + "' não encontrado.");
        }

        public void removerItem(String titulo) throws ItemNaoEncontradoException {
            Model.ItemBiblioteca itemParaRemover = buscarPorTitulo(titulo);
            itens.remove(itemParaRemover);
        }

        public void exibirTodosItens() {
            if (itens.isEmpty()) {
                System.out.println("Nenhum item cadastrado na biblioteca.");
                return;
            }

            System.out.println("\n=== ITENS DA BIBLIOTECA ===");
            for (Model.ItemBiblioteca item : itens) {
                item.exibirInformacoes();
            }
        }
    }

