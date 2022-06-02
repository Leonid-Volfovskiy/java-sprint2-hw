public class Recorder { // класс в котором получаем данные из очётов, парсим их и записываем в нужные переменные
    private MonthlyReport monthlyReport;
    private YearlyReport yearlyReport;

    private static final String DIRECTION = "resources";
    public Recorder (MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }

    public void readMonthFile() {
        for (int month = 1; month <= 3; month++) {
            String content = FileReader.readFileContentsOrNull(DIRECTION + "/m.20210" + month + ".csv");
            if (content == null) {
                System.out.println("Проверьте в директории наличие месячных отчётов.");
                return;
            } else {
                String[] lines = content.split("\n"); // такое решение нам давали на вебинаре, советовали использовать его, когда File.separator не работает
                int monthNumber = month;
                for (int index = 1; index < lines.length; index++) {
                    String line = lines[index];
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
        }
        System.out.println("Месячные отчёты считаны успешно");
    }

    public void readYearFile() {
        String content = FileReader.readFileContentsOrNull(DIRECTION + "/y.2021.csv");
        if (content == null) {
            System.out.println("Проверьте в директории наличие годового отчёта.");
            return;
        } else {
            String[] lines = content.split("\n"); // [строка1, строка2, ...
            for (int index = 1; index < lines.length; index++) {
                String line = lines[index];
                String[] parts = line.split(",");
                int month = Integer.parseInt(parts[0]);
                int amount = Integer.parseInt(parts[1]);
                boolean isExpense = Boolean.parseBoolean(parts[2]);
                YearlyReportRecord recordOfYear = new YearlyReportRecord(month, amount, isExpense);
                yearlyReport.addToLIst(recordOfYear);

            }
        }
        System.out.println("Годовой отчёт считан успешно");
    }
}