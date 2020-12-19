package application;
import db.DB;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao Sistema de Cadastramento de Produtos!");
        System.out.println("Escolha uma das opções do menu abaixo: ");

        System.out.println("Digite um valor x: ");


        System.out.println("1 - Adicionar produto ao estoque.");
        System.out.println("2 - Remover produto do estoque.");
        System.out.println("3 - Consultar tabela de produtos.");
        System.out.println("4 - Atualizar valor do produto.");
        System.out.println("5 - Sair.");
        int op = sc.nextInt();




        switch (op) {
            case 1:
                String name;
                double price;
                int id;
                int quantidade;
                System.out.println("Informe o nome do produto: ");
                name = sc.next();


                System.out.println("Informe o preço do produto: ");
                price = sc.nextDouble();

                System.out.println("Informe a quantidade do produto: ");
                quantidade = sc.nextInt();

                Produtos produto = new Produtos(price, name, quantidade);


                produto.setPrice(price);
                produto.setName(name);
                produto.setQuantidade(quantidade);




                Connection conn = DB.getConnection();
                PreparedStatement st = null;
                try {
                    conn = DB.getConnection();
                    st = conn.prepareStatement(
                            "INSERT INTO tbprodutos "
                                    + "(price, name, quantidade)"
                                    + "VALUES "
                                    + "( ?, ?, ?)");
                    st.setDouble(1,price);
                    st.setString(2, name);
                    st.setInt(3, quantidade);

                    int rowsAffected = st.executeUpdate();

                    System.out.println("Produto cadastrado com Sucesso!");


                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DB.closeStatement(st);
                    DB.closeConnection();
                }
                break;

            case 2:
                st = null;
                try {
                    System.out.println("Informe o id do produto que deseja remover: ");
                    id = sc.nextInt();
                    conn = DB.getConnection();
                    st = conn.prepareStatement(
                            "DELETE FROM tbprodutos "
                                    + "WHERE "
                                    + "Id = ?");
                    st.setInt(1, id);

                    int rowsAffected = st.executeUpdate();

                    System.out.println("Produto Removido com Sucesso!");

                    System.out.println("Done! " + rowsAffected);

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DB.closeStatement(st);
                    DB.closeConnection();
                }


                break;

            case 3:
                Statement ts = null;
                ResultSet rs = null;
                try {
                    conn = DB.getConnection();
                    ts = conn.createStatement();

                    rs = ts.executeQuery("SELECT * FROM tbprodutos");

                    System.out.println("Dados da tabela Produtos: ");

                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + ", " + rs.getDouble("price") + ", " + rs.getString("name")
                                + ", " + rs.getInt("quantidade"));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DB.closeStatement(ts);
                    DB.closeConnection();
                }

                break;

            case 4:
                conn = null;
                st = null;

                try {
                    System.out.println("Informe o id do produto que deseja atualizar: ");
                    id = sc.nextInt();
                    System.out.println("Informe o novo valor do produto.");
                    price = sc.nextDouble();
                    System.out.println("Informe a nova quantidade do protudo: ");
                    quantidade = sc.nextInt();

                    conn = DB.getConnection();
                    st = conn.prepareStatement(
                            "UPDATE tbprodutos "
                                    + "SET price = ?, quantidade = ? "
                                    + "WHERE "
                                    + "id = ?");

                    st.setDouble(1, price);
                    st.setInt(2, quantidade);
                    st.setInt(3, id);


                    System.out.println("O produto foi atualizado com sucesso.");

                    int rowsAffected = st.executeUpdate();
                    System.out.println("Done! " + rowsAffected);
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DB.closeStatement(st);
                    DB.closeConnection();
                }

                break;


            default:

        }








    }
}
