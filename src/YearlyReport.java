import java.util.ArrayList;

public class YearlyReport { // класс для хранения считанных и распарсенных данных по годовому отчёту
    static ArrayList<YearlyReportRecord> records = new ArrayList<>();

    public static void addToLIst (YearlyReportRecord recordOfYear) {

        records.add(recordOfYear);
    }

    int year = 2021;
    String[] monthsNames = {"Январь","Февраль","Март"};
    String currentMonthName = null;

    public int getYearlyExpenses(int monthBumber) {
        int sumMonthExpenseInYear = 0;
        for (YearlyReportRecord listOfRecords : records) {
            if (listOfRecords.getMonth() == monthBumber) {
                if (listOfRecords.getIsExpense()) {
                    sumMonthExpenseInYear += listOfRecords.getAmount();
                }
            }
        }
        return sumMonthExpenseInYear;
    }

    public int getYearlyIncomes(int monthBumber) {
        int sumMonthIncomeInYear = 0;
        for (YearlyReportRecord listOfRecords : records) {
            if (listOfRecords.getMonth() == monthBumber) {
                if (!listOfRecords.getIsExpense()) {
                    sumMonthIncomeInYear += listOfRecords.getAmount();
                }
            }
        }
        return sumMonthIncomeInYear;
    }

    public void getYearStatistic() {
        int averageExpenses = 0;
        int averageIncomes = 0;
        int yearSumExpenses = 0;
        int yearSumincomes = 0;
        int monthIncome = 0;
        int monthExpense = 0;

        System.out.println("Год : " + year);

        for (int month = 1; month <= 3; month++) {
            currentMonthName = monthsNames[month - 1];
            for (YearlyReportRecord listOfRecords : records) {
                if (listOfRecords.getMonth() == month) {
                    if (listOfRecords.getIsExpense()) {
                        monthExpense =  listOfRecords.getAmount();
                    } else {
                        monthIncome = listOfRecords.getAmount();
                    }
                }
            }
            if ((monthIncome != 0) && (monthExpense != 0)) {
                System.out.println("Месяц : " + currentMonthName);
                System.out.println("Доходы за месяц составили: " + monthIncome);
                System.out.println("Затраты за месяц составили: " + monthExpense);

                yearSumExpenses += monthExpense;
                yearSumincomes += monthIncome;

                System.out.println("Прибыль месяца : " + (monthIncome - monthExpense));
            }
        }
        if ((monthIncome != 0) && (monthExpense != 0)) {
            averageExpenses = yearSumExpenses / monthsNames.length;
            averageIncomes = yearSumincomes / monthsNames.length;
            System.out.println("Средний доход за год : " + averageIncomes);
            System.out.println("Средний расход за год : " + averageExpenses);
        } else {
            System.out.println("Ошибка, необходимо проверить наличие годового отчета в директории");
        }
    }

}
