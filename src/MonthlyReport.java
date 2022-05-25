import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport { // класс для хранения считанных и распарсенных данных по месячным отчётам

    static ArrayList<MonthlyReportRecord> records = new ArrayList<>();;

    public static void addToLIst(MonthlyReportRecord recordOfMonth) {

        records.add(recordOfMonth);
    }

    public int getMonthlyIncomes() {
        int sumMonthlyIncomes = 0;
        for (MonthlyReportRecord listOfRecords : records) {
            if (listOfRecords.getIsExpense() == true) {
                sumMonthlyIncomes += listOfRecords.getCostOfItem();
            }
        }
        System.out.println();
        return sumMonthlyIncomes;
    }

    public int getMonthlyExpenses() {
        int sumMonthlyExpenses = 0;
        for (MonthlyReportRecord listOfRecords : records) {
            if (listOfRecords.getIsExpense() == false) {
                sumMonthlyExpenses += listOfRecords.getCostOfItem();
            }
        }
        return sumMonthlyExpenses;
    }

    public void getMonthStatistic() {
        String currentMonthName = null;
        String[] monthsNames = {"Январь","Февраль","Март"};


        for (int m = 0; m <= 2; m++) {
            currentMonthName = monthsNames[m];

            HashMap<String, Integer> expensesList = new HashMap<>();
            HashMap<String, Integer> incomesList = new HashMap<>();

            for (MonthlyReportRecord listOfRecords : records) {
                if (listOfRecords.getMonthNumber() == (m+1)) {
                    if (listOfRecords.getIsExpense() == true) {
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

            System.out.println("Месяц : " + currentMonthName);
            System.out.println("Самый прибыльный товар : " + itemNameIncome + " на сумму " + maxIncome);
            System.out.println("Самая большая затрата : " + itemNameExpense + " на сумму " +  maxExpense);
        }

    }

}
