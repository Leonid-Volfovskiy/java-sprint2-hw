public class MonthlyReportRecord { // класс для создания конструктора обекта для каждой записи траты/дохода из месяца
    private String itemName;
    private boolean isExpense;
    private int costOfItem;
    private int monthNumber;

    public MonthlyReportRecord(String itemName, boolean isExpense, int costOfItem, int monthNumber) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.costOfItem = costOfItem;
        this.monthNumber = monthNumber;
    }

    public String getItemName() {

        return itemName;
    }

    public boolean getIsExpense() {

        return isExpense;
    }

    public int getCostOfItem() {

        return costOfItem;
    }
    public int getMonthNumber() {

        return monthNumber;
    }


}
