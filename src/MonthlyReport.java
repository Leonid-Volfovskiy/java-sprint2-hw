public class MonthlyReport {
    private String itemName;
    private boolean isExpense;
    private int quantity;
    private int sumOfOne;


    public MonthlyReport(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
