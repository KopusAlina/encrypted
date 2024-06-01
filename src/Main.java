import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {

    private static final String ENCRYPTION_KEY = "secretkey"; // ключ шифрования

    public static void main(String[] args) {
        String originalMessage = "Hello, World!";

        // Шифрование сообщения
        String encryptedMessage = encrypt(originalMessage);
        System.out.println("Encrypted message: " + encryptedMessage);

        // Дешифрование сообщения
        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);

        // Шифрование времени
        LocalDateTime currentTime = LocalDateTime.now();
        String encryptedTime = encrypt(currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Encrypted time: " + encryptedTime);

        // Дешифрование времени
        String decryptedTime = decrypt(encryptedTime);
        System.out.println("Decrypted time: " + decryptedTime);
    }

    // Метод для шифрования текста
    private static String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char originalChar = text.charAt(i);
            char encryptedChar = (char)(originalChar ^ ENCRYPTION_KEY.charAt(i % ENCRYPTION_KEY.length()));
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    // Метод для дешифрования текста
    private static String decrypt(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char decryptedChar = (char)(encryptedChar ^ ENCRYPTION_KEY.charAt(i % ENCRYPTION_KEY.length()));
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}
