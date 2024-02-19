package calculator;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChọn chức năng bạn muốn thực hiện:");
            System.out.println("1. Tính diện tích và chu vi của hình elip");
            System.out.println("2. Thực hiện phép tính số phức");
            System.out.println("3. Tính các hàm trigonometric");
            System.out.println("4. Thoát chương trình");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculateEllipseProperties(scanner);
                    break;
                case 2:
                    performComplexNumberOperations(scanner);
                    break;
                case 3:
                    performTrigonometricCalculations(scanner);
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Tính diện tích và chu vi của hình elip
    public static void calculateEllipseProperties(Scanner scanner) {
        System.out.println("Nhập vào bán kính lớn của hình elip (a): ");
        double a = scanner.nextDouble();
        System.out.println("Nhập vào bán kính nhỏ của hình elip (b): ");
        double b = scanner.nextDouble();
        double area = Math.PI * a * b;
        double perimeter = Math.PI * (a + b);
        System.out.println("Diện tích của hình elip là: " + area);
        System.out.println("Chu vi của hình elip là: " + perimeter);
    }

    // Thực hiện phép tính số phức
    public static void performComplexNumberOperations(Scanner scanner) {
        System.out.println("Nhập vào phần thực của số phức thứ nhất (a): ");
        double real1 = scanner.nextDouble();
        System.out.println("Nhập vào phần ảo của số phức thứ nhất (b): ");
        double imaginary1 = scanner.nextDouble();
        System.out.println("Nhập vào phần thực của số phức thứ hai (c): ");
        double real2 = scanner.nextDouble();
        System.out.println("Nhập vào phần ảo của số phức thứ hai (d): ");
        double imaginary2 = scanner.nextDouble();

        // Gọi các phương thức để thực hiện các phép tính số phức
        performComplexNumberAddition(real1, imaginary1, real2, imaginary2);
        performComplexNumberSubtraction(real1, imaginary1, real2, imaginary2);
        performComplexNumberMultiplication(real1, imaginary1, real2, imaginary2);
        performComplexNumberDivision(real1, imaginary1, real2, imaginary2);
    }

 // Tính các hàm trigonometric
    public static void performTrigonometricCalculations(Scanner scanner) {
        System.out.println("Nhập vào một góc (đơn vị: độ) để tính các giá trị của các hàm trigonometric: ");
        double angleDegree = scanner.nextDouble();
        double angleRadian = Math.toRadians(angleDegree);

        // Tính các giá trị của các hàm trigonometric
        double sinValue = sine(angleRadian);
        double cosValue = cosine(angleRadian);
        double tanValue = tangent(angleRadian);

        // In các giá trị của các hàm trigonometric
        System.out.println("sin(" + angleDegree + "°) = " + sinValue);
        System.out.println("cos(" + angleDegree + "°) = " + cosValue);
        System.out.println("tan(" + angleDegree + "°) = " + tanValue);

        double arcsinValue = Math.toDegrees(arcsine(sinValue));
        double arccosValue = Math.toDegrees(arccosine(cosValue));
        double arctanValue = Math.toDegrees(arctangent(tanValue));

        System.out.println("arcsin(" + angleDegree + "°) = " + arcsinValue);
        System.out.println("arccos(" + angleDegree + "°) = " + arccosValue);
        System.out.println("arctan(" + angleDegree + "°) = " + arctanValue);

        double sinhValue = sinh(angleRadian);
        double coshValue = cosh(angleRadian);
        double tanhValue = tanh(angleRadian);

        System.out.println("sinh(" + angleDegree + "°) = " + sinhValue);
        System.out.println("cosh(" + angleDegree + "°) = " + coshValue);
        System.out.println("tanh(" + angleDegree + "°) = " + tanhValue);
    }

    // Hàm tính sin
    public static double sine(double angleRadian) {
        double sinValue = 0;
        for (int i = 0; i <= 10; i++) {
            sinValue += (Math.pow(-1, i) / factorial(2 * i + 1)) * Math.pow(angleRadian, 2 * i + 1);
        }
        return sinValue;
    }

    // Hàm tính cos
    public static double cosine(double angleRadian) {
        double cosValue = 0;
        for (int i = 0; i <= 10; i++) {
            cosValue += (Math.pow(-1, i) / factorial(2 * i)) * Math.pow(angleRadian, 2 * i);
        }
        return cosValue;
    }

    // Hàm tính tan
    public static double tangent(double angleRadian) {
        return sine(angleRadian) / cosine(angleRadian);
    }

    // Hàm tính arcsin
    public static double arcsine(double value) {
        double result = value;
        double temp = value;
        double xSquared = value * value;
        for (int i = 1; i <= 10; i++) {
            temp *= xSquared * (2 * i - 1) / (2 * i * (2 * i + 1));
            result += temp / (2 * i + 1);
        }
        return result;
    }

    // Hàm tính arccos
    public static double arccosine(double value) {
        return Math.PI / 2 - arcsine(value);
    }

    // Hàm tính arctan
    public static double arctangent(double value) {
        double result = value;
        double temp = value;
        double xSquared = value * value;
        for (int i = 1; i <= 10; i++) {
            temp *= xSquared;
            result += temp / (2 * i + 1);
        }
        return result;
    }

    // Hàm tính sinh
    public static double sinh(double angleRadian) {
        double sinhValue = angleRadian;
        double temp = angleRadian;
        double xSquared = angleRadian * angleRadian;
        for (int i = 1; i <= 10; i++) {
            temp *= xSquared / ((2 * i) * (2 * i + 1));
            sinhValue += temp;
        }
        return sinhValue;
    }

    // Hàm tính cosh
    public static double cosh(double angleRadian) {
        double coshValue = 1;
        double temp = 1;
        double xSquared = angleRadian * angleRadian;
        for (int i = 1; i <= 10; i++) {
            temp *= xSquared / ((2 * i - 1) * (2 * i));
            coshValue += temp;
        }
        return coshValue;
    }

    // Hàm tính tanh
    public static double tanh(double angleRadian) {
        return sinh(angleRadian) / cosh(angleRadian);
    }
    
    // Hàm tính giai thừa
    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Các phương thức phép tính số phức
    public static void performComplexNumberAddition(double a, double b, double c, double d) {
        double sumReal = a + c;
        double sumImaginary = b + d;
        System.out.println("Tổng của hai số phức là: " + sumReal + " + " + sumImaginary + "i");
    }

    public static void performComplexNumberSubtraction(double a, double b, double c, double d) {
        double diffReal = a - c;
        double diffImaginary = b - d;
        System.out.println("Hiệu của hai số phức là: " + diffReal + " + " + diffImaginary + "i");
    }

    public static void performComplexNumberMultiplication(double a, double b, double c, double d) {
        double productReal = a * c - b * d;
        double productImaginary = a * d + c * b;
        System.out.println("Tích của hai số phức là: " + productReal + " + " + productImaginary + "i");
    }

    public static void performComplexNumberDivision(double a, double b, double c, double d) {
        double denominator = c * c + d * d;
        double divisionReal = (a * c + b * d) / denominator;
        double divisionImaginary = (b * c - a * d) / denominator;
        System.out.println("Thương của hai số phức là: " + divisionReal + " + " + divisionImaginary + "i");
    }
}
