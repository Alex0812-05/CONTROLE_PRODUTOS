package dao;

import model.ProdutoAlimenticio;
import util.DatabaseConnection;

import java.sql.*;

public class ProdutoAlimenticioDAO {

    // Método para salvar um produto alimentício
    public void salvar(ProdutoAlimenticio produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.salvar(produto);  // Salva o produto genérico

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO produto_alimenticio (id, data_validade, informacoes_nutricionais) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getDataValidade());
            stmt.setString(3, produto.getInformacoesNutricionais());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um produto alimentício
    public void atualizar(ProdutoAlimenticio produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.atualizar(produto);  // Atualiza o produto genérico

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE produto_alimenticio SET data_validade = ?, informacoes_nutricionais = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, produto.getDataValidade());
            stmt.setString(2, produto.getInformacoesNutricionais());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar um produto alimentício
    public void deletar(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM produto_alimenticio WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
