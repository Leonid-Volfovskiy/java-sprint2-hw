import java.util.ArrayList;
public class Recorder {
    Boolean isMonthlyReportRecorded = false;
    Boolean isYearlyReportRecorded = false;

    public void readMonthFile() {

        if (isMonthlyReportRecorded == true) {
            System.out.println("Отчёт уже считан!");
            return;
        }
        for (int m = 1; m <= 3; m++) {
            FileReader reader = new FileReader();
            String content = reader.readFileContentsOrNull("resources/m.20210" + m +".csv");
            String[] lines = content.split("\n"); // [строка1, строка2, ...]
            ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();

            for (int i = 1; i < lines.length; i++) {
                String line = lines[i];
                String[] parts = line.split(",");
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]); // "true" -> true
                int quantity = Integer.parseInt(parts[2]);
                int sumOfOne = Integer.parseInt(parts[3]);

                MonthlyReport record = new MonthlyReport(itemName, isExpense, quantity, sumOfOne);
                monthlyReports.add(record);
            }
            }
        System.out.println("Месчяные отчёты считаны");
        isMonthlyReportRecorded = true;
    }

    public void readYearFile() {
        if (isYearlyReportRecorded == true) {
            System.out.println("Отчёт уже считан!");
            return;
        }
        FileReader reader = new FileReader();
        String content = reader.readFileContentsOrNull("resources/y.2021.csv");
        String[] lines = content.split("\n"); // [строка1, строка2, ...]
        ArrayList<YearlyReport> yearlyReport = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);

            YearlyReport recordOfYear = new YearlyReport(month, amount, isExpense);
            yearlyReport.add(recordOfYear);
        }
        isYearlyReportRecorded = true;
    }
}
