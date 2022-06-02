public class Manager { // класс для сверки отчетов

    private MonthlyReport monthlyReport;
    private YearlyReport yearlyReport;
    String currentMonthName = null;

    private static final String DIRECTION = "resources";
    public Manager (MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }

    String[] monthsNames = {"Январь","Февраль","Март"};

    public void checkDataReports() {
        for (int month = 1; month <= 3; month++) {
            currentMonthName = monthsNames[month - 1];
            System.out.println(currentMonthName);
            if ((monthlyReport.getMonthlyExpenses(month) != 0) || (monthlyReport.getMonthlyIncomes(month) != 0)) {
                if ((yearlyReport.getYearlyExpenses(month) != 0) || (yearlyReport.getYearlyIncomes(month) != 0)) {
                    if (monthlyReport.getMonthlyExpenses(month) == yearlyReport.getYearlyExpenses(month)) {
                        System.out.println("Затраты сверены успешно");
                    } else {
                        System.out.println("Ошибка, сверка затрат не пройдена");
                    }
                    if (monthlyReport.getMonthlyIncomes(month) == yearlyReport.getYearlyIncomes(month)) {
                        System.out.println("Доходы сверены успешно");
                    } else {
                        System.out.println("Ошибка, сверка доходов не пройдена");
                    }
                } else {
                    System.out.println("Ошибка, необходимо проверить наличие годового отчета в директории");
                }
            } else {
                System.out.println("Ошибка, необходимо проверить наличие отчета за " + currentMonthName + " в директории");
            }
        }
    }
}



