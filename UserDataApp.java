import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDataApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных. Ожидается 6 параметров.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            String dateOfBirth = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            // Здесь можно добавить дополнительные проверки для каждого параметра, если необходимо.

            String filename = lastName + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(lastName + " " + firstName + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender);
                writer.newLine();
                System.out.println("Данные успешно записаны в файл " + filename);
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: неверный формат номера телефона.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Ошибка: неверный формат данных.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
