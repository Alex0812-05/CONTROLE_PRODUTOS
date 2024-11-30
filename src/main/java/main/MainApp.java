package main;

import dao.ProdutoAlimenticioDAO;
import dao.ProdutoDAO;
import dao.ProdutoVestuarioDAO;
import model.Produto;
import model.ProdutoAlimenticio;
import model.ProdutoVestuario;

public class MainApp {

    public static void main(String[] args) {
        // Criando um produto alimentício
        ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio("Arroz", 5.0, 8.0, "2025-12-31", "100g: 250 kcal");
        ProdutoAlimenticioDAO produtoAlimenticioDAO = new ProdutoAlimenticioDAO();
        produtoAlimenticioDAO.salvar(produtoAlimenticio);
        System.out.println("Produto Alimentício Salvo: " + produtoAlimenticio.getNome());

        // Criando um produto de vestuário
        ProdutoVestuario produtoVestuario = new ProdutoVestuario("Camiseta", 20.0, 40.0, "M", "Azul", "Algodão");
        ProdutoVestuarioDAO produtoVestuarioDAO = new ProdutoVestuarioDAO();
        produtoVestuarioDAO.salvar(produtoVestuario);
        System.out.println("Produto de Vestuário Salvo: " + produtoVestuario.getNome());

        // Atualizando um produto alimentício
        produtoAlimenticio.setPrecoVenda(9.0);
        produtoAlimenticioDAO.atualizar(produtoAlimenticio);
        System.out.println("Produto Alimentício Atualizado: " + produtoAlimenticio.getNome());

        // Atualizando um produto de vestuário
        produtoVestuario.setCor("Verde");
        produtoVestuarioDAO.atualizar(produtoVestuario);
        System.out.println("Produto de Vestuário Atualizado: " + produtoVestuario.getNome());

        // Deletando um produto alimentício
        produtoAlimenticioDAO.deletar(produtoAlimenticio.getId());
        System.out.println("Produto Alimentício Deletado: " + produtoAlimenticio.getNome());

        // Deletando um produto de vestuário
        produtoVestuarioDAO.deletar(produtoVestuario.getId());
        System.out.println("Produto de Vestuário Deletado: " + produtoVestuario.getNome());
    }
}

