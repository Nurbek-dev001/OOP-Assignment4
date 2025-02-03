import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("account_id")
    private int accountId;

    @SerializedName("account_type")
    private String accountType;

    @SerializedName("balance")
    private double balance;

    @SerializedName("customer_id")
    private int customerId;

    public Account(int accountId, String accountType, double balance, int customerId) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;
    }

    public int getAccountId() { return accountId; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public int getCustomerId() { return customerId; }
}
