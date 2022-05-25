import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Recorder dataRecorder = new Recorder();
        Manager checkData = new Manager();
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

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
                    checkData.checkDataReports();
                    break;
                case 4:
                    monthlyReport.getMonthStatistic();
                    break;
                case 5:
                    yearlyReport.getYearStatistic();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
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

