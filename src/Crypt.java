import javax.crypto.SecretKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Crypt {
    public static void main(String[] args) {
        try {
            String originalMessage = "Оригинал";
            System.out.println("Оригинальный текст: " + originalMessage);
            SecretKey key = AESCipher.generateKey();

            String enCryptMessage = AESCipher.enCrypt(originalMessage, key);
            System.out.println("Зашифрованный текст: " + enCryptMessage);

            String deCryptMessage = AESCipher.deCrypt(enCryptMessage, key);
            System.out.println("Расшифрованный текст: " + deCryptMessage);

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat originalTime = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
            Date now = new Date();
            String formattedDate = originalTime.format(now);
            System.out.println("Время отправки: " + formattedDate);

            String enCryptTime = AESCipher.enCrypt(formattedDate, key);
            System.out.println("Зашифрованное время: " + enCryptTime);

            String deCryptTime = AESCipher.deCrypt(enCryptTime, key);
            System.out.println("Расшифрованное время: " + deCryptTime);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
