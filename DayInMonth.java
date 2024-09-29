import java.util.Scanner;

public class DayInMonth {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }

    public static int convertMonth(String monthInput) {
        monthInput = monthInput.trim().toLowerCase();

        switch (monthInput) {
            case "1": case "january": case "jan.": case "jan":
                return 1;
            case "2": case "february": case "feb.": case "feb":
                return 2;
            case "3": case "march": case "mar.": case "mar":
                return 3;
            case "4": case "april": case "apr.": case "apr":
                return 4;
            case "5":
                return 5;
            case "6": case "june": case "jun.": case "jun":
                return 6;
            case "7": case "july": case "jul.": case "jul":
                return 7;
            case "8": case "august": case "aug.": case "aug":
                return 8;
            case "9": case "september": case "sep.": case "sep":
                return 9;
            case "10": case "october": case "oct.": case "oct":
                return 10;
            case "11": case "november": case "nov.": case "nov":
                return 11;
            case "12": case "december": case "dec.": case "dec":
                return 12;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = -1;
        int year = -1;

        while (true) {
            System.out.print("Nhập tháng: ");
            String monthInput = sc.nextLine();
            month = convertMonth(monthInput);
            if (month == -1) {
                System.out.println("Nhập không đúng định dạng. Mời nhập lại:");
                continue;
            }

            System.out.print("Nhập năm: ");
            String yearInput = sc.nextLine();
            try {
                year = Integer.parseInt(yearInput);
                if (year < 0 || yearInput.length() != 4) {
                    System.out.println("Năm không hợp lệ. Năm phải là số nguyên không âm và gồm 4 chữ số. Mời nhập lại:");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Định dạng năm không hợp lệ. Mời nhập năm gồm 4 chữ số:");
                continue;
            }

            int cntDate = getDaysInMonth(month, year);
            if (cntDate != -1) {
                System.out.println("Số ngày trong tháng đã nhập là: " + cntDate);
                break;
            } else {
                System.out.println("Lỗi! Tháng không hợp lệ.");
            }
        }

        sc.close(); // Đóng Scanner sau khi hoàn thành
    }
}
