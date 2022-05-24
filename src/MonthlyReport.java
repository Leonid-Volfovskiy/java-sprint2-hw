import java.util.ArrayList;

public class MonthlyReport { // класс для хранения считанных и распарсенных данных по месячным отчётам
    static ArrayList<MonthlyReportRecord> records = new ArrayList<>();

    public static void addToLIst (MonthlyReportRecord recordOfMonth) {
        records.add(recordOfMonth);
    }

}



 /*
        for (MonthlyReportRecord listOfRecords : records) {
            if (listOfRecords.getIsExpense()) {
                expenses.put(listOfRecords.getMonthNumber(), listOfRecords.getCostOfItem());
            } else {
                incomes.put(listOfRecords.getMonthNumber(), listOfRecords.getCostOfItem());
            }


*/