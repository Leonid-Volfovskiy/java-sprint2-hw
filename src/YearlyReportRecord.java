public class YearlyReportRecord {

    private int month;
    private int amount;
    private boolean isExpense;

    public YearlyReportRecord(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public int getMonth() {
        return month;
    }

    public boolean isIsExpense() {
        return isExpense;
    }

    public int getAmount() {
        return amount;
    }


}
