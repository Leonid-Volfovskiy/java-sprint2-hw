import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport { // класс для хранения считанных и распарсенных данных по месячным отчётам
    String currentMonthName = null;
    String[] monthsNames = {"Январь","Февраль","Март"};

    static ArrayList<MonthlyReportRecord> records = new ArrayList<>();

    public static void addToLIst(MonthlyReportRecord recordOfMonth) {

        records.add(recordOfMonth);
    }


    public int getMonthlyExpenses(int monthNumber) {
        int sumMonthlyExpenses = 0;
        for (MonthlyReportRecord listOfRecords : records) {
            if (listOfRecords.getMonthNumber() == monthNumber) {
                if (listOfRecords.getIsExpense()) {
                    sumMonthlyExpenses += listOfRecords.getCostOfItem();
                }
            }
        }
        return sumMonthlyExpenses;
    }

    public int getMonthlyIncomes(int monthNumber) {
        int sumMonthlyIncomes = 0;
        for (MonthlyReportRecord listOfRecords : records) {
            if (listOfRecords.getMonthNumber() == monthNumber) {
                if (!listOfRecords.getIsExpense()) {
                    sumMonthlyIncomes += listOfRecords.getCostOfItem();
                }
            }
        }
        return sumMonthlyIncomes;
    }

    public void getMonthStatistic() {
        for (int month = 1; month <= 3; month++) {
            currentMonthName = monthsNames[month - 1];

            HashMap<String, Integer> expensesList = new HashMap<>();
            HashMap<String, Integer> incomesList = new HashMap<>();

            for (MonthlyReportRecord listOfRecords : records) {
                if (listOfRecords.getMonthNumber() == month) {
                    if (listOfRecords.getIsExpense()) {
                        expensesList.put(listOfRecords.getItemName(), listOfRecords.getCostOfItem());
                    } else {
                        incomesList.put(listOfRecords.getItemName(), listOfRecords.getCostOfItem());
                    }
                }
            }

            int maxExpense = 0;
            int maxIncome = 0;
            String itemNameExpense = null;
            String itemNameIncome = null;

            for (Integer expenses : expensesList.values()) {
                if (expenses > maxExpense) {
                    maxExpense = expenses;
                }
            }

            for (Integer incomes : incomesList.values()) {
                if (incomes > maxExpense) {
                    maxIncome = incomes;
                }
            }

            for (String expenses : expensesList.keySet()) {
                if (expensesList.get(expenses).equals(maxExpense)) {
                    itemNameExpense = expenses;
                }
            }

            for (String incomes : incomesList.keySet()) {
                if (incomesList.get(incomes).equals(maxIncome)) {
                    itemNameIncome = incomes;
                }
            }

            if ((maxIncome != 0) && (maxExpense != 0)) {
                System.out.println("Месяц : " + currentMonthName);
                System.out.println("Самый прибыльный товар : " + itemNameIncome + " на сумму " + maxIncome);
                System.out.println("Самая большая затрата : " + itemNameExpense + " на сумму " +  maxExpense);
            } else {
                System.out.println("Ошибка, необходимо проверить наличие отчета за " + currentMonthName + " в директории");
            }
        }
    }
}


