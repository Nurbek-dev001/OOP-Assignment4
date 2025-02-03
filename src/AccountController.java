import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.List;

public class AccountController {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        port(8080);

        post("/accounts", (req, res) -> {
            res.type("application/json");
            Account account = gson.fromJson(req.body(), Account.class);
            boolean success = AccountDAO.createAccount(account.getAccountType(), account.getBalance(), account.getCustomerId());
            return success ? gson.toJson("{\"message\":\"Account created successfully\"}") :
                    gson.toJson("{\"error\":\"Failed to create account\"}");
        });

        get("/accounts", (req, res) -> {
            res.type("application/json");
            List<Account> accounts = AccountDAO.getAllAccounts();
            return gson.toJson(accounts);
        });

        put("/accounts/:id", (req, res) -> {
            res.type("application/json");
            int accountId = Integer.parseInt(req.params(":id"));
            double newBalance = gson.fromJson(req.body(), Account.class).getBalance();
            boolean success = AccountDAO.updateAccount(accountId, newBalance);
            return success ? gson.toJson("{\"message\":\"Account updated successfully\"}") :
                    gson.toJson("{\"error\":\"Account not found\"}");
        });

        delete("/accounts/:id", (req, res) -> {
            res.type("application/json");
            int accountId = Integer.parseInt(req.params(":id"));
            boolean success = AccountDAO.deleteAccount(accountId);
            return success ? gson.toJson("{\"message\":\"Account deleted successfully\"}") :
                    gson.toJson("{\"error\":\"Account not found\"}");
        });
    }
}
