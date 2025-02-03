import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public static boolean createAccount(String accountType, double balance, int customerId) {
        String query = "INSERT INTO Account (AccountType, Balance, CustomerID) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, accountType);
            statement.setDouble(2, balance);
            statement.setInt(3, customerId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM Account";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                accounts.add(new Account(
                        resultSet.getInt("AccountID"),
                        resultSet.getString("AccountType"),
                        resultSet.getDouble("Balance"),
                        resultSet.getInt("CustomerID")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static boolean updateAccount(int accountId, double newBalance) {
        String query = "UPDATE Account SET Balance = ? WHERE AccountID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, newBalance);
            statement.setInt(2, accountId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteAccount(int accountId) {
        String query = "DELETE FROM Account WHERE AccountID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
