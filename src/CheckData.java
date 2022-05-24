public class CheckData { // класс для сверки отчетов

    public void checkDataReports() {

        Recorder dataRecorder = new Recorder();

        Boolean isMonthReportRecorded = dataRecorder.isMonthlyReportRecorded;
        Boolean isYearReportRecorded = dataRecorder.isYearlyReportRecorded;

        if ((isMonthReportRecorded == false) || (isYearReportRecorded == false)) {
            System.out.println("Один из отчётов ещё не считан!");
            return;


        }

    }
}
