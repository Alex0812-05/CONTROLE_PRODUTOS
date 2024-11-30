package dao;

import model.ProdutoVestuario;
import util.DatabaseConnection;

import java.sql.*;

public class ProdutoVestuarioDAO {

    // Método para salvar um produto de vestuário
    public void salvar(ProdutoVestuario produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.salvar(produto);  // Salva o produto genérico

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO produto_vestuario (id, tamanho, cor, material) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getTamanho());
            stmt.setString(3, produto.getCor());
            stmt.setString(4, produto.getMaterial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um produto de vestuário
    public void atualizar(ProdutoVestuario produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.atualizar(produto);  // Atualiza o produto genérico

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE produto_vestuario SET tamanho = ?, cor = ?, material = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, produto.getTamanho());
            stmt.setString(2, produto.getCor());
            stmt.setString(3, produto.getMaterial());
            stmt.setInt(4, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar um produto de vestuário
    public void deletar(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM produto_vestuario WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

