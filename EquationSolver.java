import javax.swing.*;
import java.util.InputMismatchException;

public class EquationSolver{

    // Giai pt bac 1st 1 an: a*x + b = 0
    public static void solveLinearEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Phương trình có vô số nghiệm");
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, " x = " + x);
        }
    }

    // Giai hpt bac 1st 2 an:
    public static void solveLinearSystem(double a1, double b1, double c1, double a2, double b2, double c2) {
        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            if (a1 * c2 == a2 * c1 && b1 * c2 == b2 * c1) {
                JOptionPane.showMessageDialog(null, "Hệ phương trình có vô số nghiệm");
            } else {
                JOptionPane.showMessageDialog(null, "Hệ Phương trình vô nghiệm");
            }
        } else {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            JOptionPane.showMessageDialog(null, "The solution of the system is: x = " + x + ", y = " + y);
        }
    }

    // Giai pt bac 2nd 1 an: a*x^2 + b*x + c = 0
    public static void solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            solveLinearEquation(b, c); // Chuyen ve pt bac 1st cho nhanh
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "phương trình có no kép: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null,
                        "phương trình có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }

    public static void main(String[] args) {
        String[] options = { "ptinh 1 an bac nhat", "he phuong trinh bac nhat", "phuong trinh 1 an bac 2 " };
        int choice = JOptionPane.showOptionDialog(null, "Bạn muốn giải loại phương trình nào?",
                "Chọn loại phương trình", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        switch (choice) {
            case 0: // Pt bac 1st
                double a1 = getDoubleInput("Nhap a:");
                double b1 = getDoubleInput("Nhap b:");
                solveLinearEquation(a1, b1);
                break;

            case 1: // Hpt bac 1st
                double a2_1 = getDoubleInput("Nhap a1:");
                double b2_1 = getDoubleInput("Nhap b1:");
                double c1 = getDoubleInput("Nhap c1:");
                double a2_2 = getDoubleInput("Nhap a2:");
                double b2_2 = getDoubleInput("Nhap b2:");
                double c2 = getDoubleInput("Nhap c2:");
                solveLinearSystem(a2_1, b2_1, c1, a2_2, b2_2, c2);
                break;

            case 2: // Pt bac 2nd
                double a3 = getDoubleInput("Nhap a:");
                double b3 = getDoubleInput("Nhap b:");
                double c3 = getDoubleInput("Nhap c:");
                solveQuadraticEquation(a3, b3, c3);
                break;

            default:
                JOptionPane.showMessageDialog(null, " chua chon phương trinh");
                break;
        }
    }

    private static double getDoubleInput(String message) {
        double value = 0;
        boolean valid = false;
        while (!valid) {
            String input = JOptionPane.showInputDialog(message);
            if (input == null) {
                System.exit(0); 
            }
            try {
                value = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Giá trị không hợp lệ, nhập lại");
            }
        }
        return value;
    }
}