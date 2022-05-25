public class Manager { // класс для сверки отчетов

    public void checkDataReports() {
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        if ((monthlyReport.getMonthlyExpenses() == yearlyReport.getYearlyExpenses()) && (monthlyReport.getMonthlyIncomes() == yearlyReport.getYearlyIncomes())) {
            System.out.println("Сверка отчётов проведена успешно");
        } else {
            System.out.println("Отчёты не прошли проверку по расходам!");
        }
    }

}
