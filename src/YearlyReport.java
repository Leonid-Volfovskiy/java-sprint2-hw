import java.util.ArrayList;

public class YearlyReport { // класс для хранения считанных и распарсенных данных по годовому отчёту
    static ArrayList<YearlyReportRecord> records = new ArrayList<>();

    public static void addToLIst (YearlyReportRecord recordOfYear) {

        records.add(recordOfYear);
    }

    int year = 2021;

    public int getYearlyIncomes() {
        int sumYearlyIncomes = 0;
        for (YearlyReportRecord listOfRecords : records) {
            if (listOfRecords.getIsExpense() == true) {
                sumYearlyIncomes += listOfRecords.getAmount();
            }
        }
        return sumYearlyIncomes;
    }
    public int getYearlyExpenses() {
        int sumYearlyExpenses = 0;
        for (YearlyReportRecord listOfRecords : records) {
            if (listOfRecords.getIsExpense() == false) {
                sumYearlyExpenses += listOfRecords.getAmount();
            }
        }
        return sumYearlyExpenses;
    }

    public void getYearStatistic() {
        String[] monthsNames = {"Январь","Февраль","Март"};
        String currentMonthName = null;
        int monthIncome = 0;
        int monthExpense = 0;
        int averageExpenses = 0;
        int averageIncomes = 0;
        Integer yearSumExpenses = 0;
        Integer yearSumincomes = 0;

        System.out.println("Год : " + year);

        for (int m = 0; m <= 2; m++) {
            currentMonthName = monthsNames[m];
            System.out.println("Месяц : " + currentMonthName);
            for (YearlyReportRecord listOfRecords : records) {
                if (listOfRecords.getMonth() == (m+1)) {
                    if (listOfRecords.getIsExpense() == true) {
                        monthExpense =  listOfRecords.getAmount();
                        System.out.println("Затраты за месяц составили: " + monthExpense);
                    } else {
                        monthIncome = listOfRecords.getAmount();
                        System.out.println("Доходы за месяц составили: " + monthIncome);
                    }
                }
            }
            yearSumExpenses += monthExpense;
            yearSumincomes += monthIncome;

            System.out.println("Прибыль месяца : " + (monthIncome - monthExpense));
        }

        averageExpenses = yearSumExpenses / monthsNames.length;
        averageIncomes = yearSumincomes / monthsNames.length;
        System.out.println("Средний доход за год : " + averageIncomes);
        System.out.println("Средний расход за год : " + averageExpenses);
    }

}
