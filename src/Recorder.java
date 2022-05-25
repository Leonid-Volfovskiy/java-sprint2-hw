public class Recorder { // класс в котором получаем данные из очётов, парсим их и записываем в нужные переменные
    Boolean isMonthlyReportRecorded = false;
    Boolean isYearlyReportRecorded = false;
    MonthlyReport monthlyReport = new MonthlyReport();
    YearlyReport yearlyReport = new YearlyReport();

    public void readMonthFile() {
        if (isMonthlyReportRecorded == true) {
            System.out.println("Ошибка. Отчёты уже считаны!");
            return;
        }
        for (int m = 1; m <= 3; m++) {
            FileReader reader = new FileReader();
            String content = reader.readFileContentsOrNull("resources/m.20210" + m + ".csv");
            String[] lines = content.split("\n"); // [строка1, строка2, ...]
            int monthNumber = m;

            for (int i = 1; i < lines.length; i++) {
                String line = lines[i];
                String[] parts = line.split(",");
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]); 
                int quantity = Integer.parseInt(parts[2]);
                int sumOfOne = Integer.parseInt(parts[3]);
                int costOfItem = quantity * sumOfOne;
                MonthlyReportRecord recordOfMonth = new MonthlyReportRecord(itemName, isExpense, costOfItem, monthNumber);
                monthlyReport.addToLIst(recordOfMonth);
            }
        }
        System.out.println("Месячные отчёты считаны успешно");
        isMonthlyReportRecorded = true;
    }

    public void readYearFile() {
        if (isYearlyReportRecorded == true) {
            System.out.println("Ошибка. Отчёт уже считан!");
            return;
        }
        FileReader reader = new FileReader();
        String content = reader.readFileContentsOrNull("resources/y.2021.csv");
        String[] lines = content.split("\n"); // [строка1, строка2, ...

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            YearlyReportRecord recordOfYear = new YearlyReportRecord(month, amount, isExpense);
            yearlyReport.addToLIst(recordOfYear);

        }
        System.out.println("Годовой отчёт считан успешно");
        isYearlyReportRecorded = true;
    }
}
