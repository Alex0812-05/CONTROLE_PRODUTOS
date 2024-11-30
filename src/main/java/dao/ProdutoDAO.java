package dao;

import model.Produto;
import util.DatabaseConnection;

import java.sql.*;

public class ProdutoDAO {

    // Método para salvar um produto genérico
    public void salvar(Produto produto) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO produto (nome, preco_custo, preco_venda, tipo) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCusto());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setString(4, produto.getClass().getSimpleName());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                produto.setId(rs.getInt(1));  // Atribui o ID gerado ao produto
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um produto
    public void atualizar(Produto produto) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE produto SET nome = ?, preco_custo = ?, preco_venda = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCusto());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar um produto
    public void deletar(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM produto WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
