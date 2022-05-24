import java.util.ArrayList;

public class YearlyReport { // класс для хранения считанных и распарсенных данных по годовому отчёту
    static ArrayList<YearlyReportRecord> records = new ArrayList<>();

    public static void addToLIst (YearlyReportRecord recordOfYear) {
        records.add(recordOfYear);
    }

}
