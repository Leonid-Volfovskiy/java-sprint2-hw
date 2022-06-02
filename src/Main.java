import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Recorder dataRecorder = new Recorder(monthlyReport, yearlyReport);
        Manager manager = new Manager(monthlyReport, yearlyReport);
        while (true) {
            printMenu();
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    dataRecorder.readMonthFile();
                    break;
                case 2:
                    dataRecorder.readYearFile();
                    break;
                case 3:
                    manager.checkDataReports();
                    break;
                case 4:
                    monthlyReport.getMonthStatistic();
                    break;
                case 5:
                    yearlyReport.getYearStatistic();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Не верная команда");
                    break;
            }

        }

    }

    private static void printMenu() {
        System.out.println("1: Считать все месячные отчёты");
        System.out.println("2: Считать годовой отчёт");
        System.out.println("3: Сверить отчёты");
        System.out.println("4: Вывести информацию о всех месячных отчётах");
        System.out.println("5: Вывести информацию о годовом отчёте");
        System.out.println("6: Выход из системы ");
    }
}

