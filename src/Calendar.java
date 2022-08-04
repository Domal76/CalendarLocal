import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Calendar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start year: 4 digit number");
        int year = scanner.nextInt();
        System.out.println("Enter start month: 2 digit number");
        int month = scanner.nextInt();
        System.out.println("Enter start day: 2 digit number");
        int day = scanner.nextInt();
        System.out.println("Enter finish year: 4 digit number");
        int finishYear = scanner.nextInt();
        System.out.println("Enter finish month: 2 digit number");
        int finishMonth = scanner.nextInt();
        System.out.println("Enter finish day: 2 digit number");
        int finishDay = scanner.nextInt();
        LocalDate startDate = LocalDate.of(year, month, day);
        LocalDate endDate = LocalDate.of(finishYear, finishMonth, finishDay);
        DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern( "dd");
        DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter formatterWeek = DateTimeFormatter.ofPattern("EEEE");
        System.out.println("\n" + startDate.format(formatterYear));
        System.out.println("\n"+ monthText(startDate.format(formatterMonth)));
        while (startDate.isBefore(endDate)){
            if (Integer.parseInt(startDate.format(formatterMonth)) ==1 &&
                    Integer.parseInt(startDate.format(formatterDay)) ==1){
                System.out.println();
                System.out.println("\n" + startDate.format(formatterYear));}
            if (Integer.parseInt(startDate.format(formatterDay)) ==1)
            {   String montTe = monthText(startDate.format(formatterMonth));
                System.out.println("\n"+ montTe);
                System.out.println("Mn " + "Tu " + "We " + "Th " + "Fr " + "Sa " + "Su ");
                indent(startDate, formatterWeek);
            }
            System.out.print(startDate.format(formatterDay)+ " ");
            if (startDate.format(formatterWeek).equals("воскресенье")){
                System.out.println();
            }
            startDate = startDate.plusDays(1);
        }
    }

    private static void indent(LocalDate startDate, DateTimeFormatter formatterWeek) {
        if (startDate.format(formatterWeek).equals("понедельник")) {System.out.print("");}
        if (startDate.format(formatterWeek).equals("вторник")) {System.out.print("   ");}
        if (startDate.format(formatterWeek).equals("среда")) {System.out.print("      ");}
        if (startDate.format(formatterWeek).equals("четверг")) {System.out.print("         ");}
        if (startDate.format(formatterWeek).equals("пятница")) {System.out.print("            ");}
        if (startDate.format(formatterWeek).equals("суббота")) {System.out.print("               ");}
        if (startDate.format(formatterWeek).equals("воскресенье")) {System.out.print("                  ");}
    }

    public static String monthText ( String str){
        if (str.equals("01")) { str="January";}
        if (str.equals("02")) { str="February";}
        if (str.equals("03")) { str="March";}
        if (str.equals("04")) { str="April";}
        if (str.equals("05")) { str="May";}
        if (str.equals("06")) { str="June";}
        if (str.equals("07")) { str="July";}
        if (str.equals("08")) { str="August";}
        if (str.equals("09")) { str="September";}
        if (str.equals("10")) { str="October";}
        if (str.equals("11")) { str="November";}
        if (str.equals("12")) { str="December";}
        return str;
    }
}
