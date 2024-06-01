import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Crypt {
    public static void main(String[] args) {

    String originalMessage = "Оригинал";
        System.out.println("Оригинальный текст: " + originalMessage);

    String enCryptMessage = AESCipher.enCrypt(originalMessage);
        System.out.println("Зашифрованный текст: " + enCryptMessage);

    String deCryptMessage = deCrypt(enCryptMessage);
        System.out.println("Расшифрованный текст: " + deCryptMessage);

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat originalTime = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        System.out.println("Время отправки: " + originalTime);

    String enCryptTime = AESCipher.enCrypt(originalTime);
        System.out.println("Зашифрованное время: " + enCryptTime);

    String deCryptTime = deCrypt(enCryptTime);
        System.out.println("Расшифрованное время: " + deCryptTime);
    }



}
