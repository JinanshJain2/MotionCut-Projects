import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Temperature Converter!");
        System.out.print("Enter the temperature value: \n");
        
        double temperature = 0;
        String unit = "";

        while (true) {
            try {
                temperature = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                System.out.print("Enter the temperature value: \n");
            }
        }

        while (true) {
            System.out.print("Enter the unit (C for Celsius, F for Fahrenheit): \n");
            unit = scanner.nextLine().toUpperCase();
            if (unit.equals("C") || unit.equals("F")) {
                break;
            } else {
                System.out.println("Invalid unit. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
            }
        }

        double convertedTemperature;
        if (unit.equals("C")) {
            convertedTemperature = (temperature * 9 / 5) + 32;
            System.out.println("Converted temperature in Fahrenheit: " + convertedTemperature + " °F");
        } else {
            convertedTemperature = (temperature - 32) * 5 / 9;
            System.out.println("Converted temperature in Celsius: " + convertedTemperature + " °C");
        }

        scanner.close();
    }
}
