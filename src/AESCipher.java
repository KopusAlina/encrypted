import javax.crypto.Cipher; //для шифрования и дешифрования данных
import javax.crypto.KeyGenerator; //для создания нового ключа AES
import javax.crypto.SecretKey; //представляет собой секретный ключ для алгоритма шифрования
import javax.crypto.spec.SecretKeySpec; //для создания объекта ключа из байтового массива (если необходимо)
import java.util.Base64; //для кодирования и декодирования данных в формат Base64, удобный для представления бинарных данных в текстовом формате

public class AESCipher { // транскрипция Advanced Encryption Standard

    private static final String ALGORITHM = "AES"; // объявляем константу "алгоритм"

    // Метод для генерации нового ключа AES
    public static SecretKey generateKey() throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM); // создает генератор ключей для алгоритма AES
        keyGen.init(128); // AES поддерживает ключи длиной 128, 192 и 256 бит
        return keyGen.generateKey(); //генерирует и возвращает секретный ключ
    }

    // Метод для шифрования строки
    public static String enCrypt(String text, SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM); //создает объект Cipher для алгоритма AES
        cipher.init(Cipher.ENCRYPT_MODE, key); //инициализирует Cipher в режиме шифрования с использованием переданного ключа
        byte[] enCrypted = cipher.doFinal(text.getBytes()); //шифрует текст, преобразованный в байты, и возвращает зашифрованные байты
        return Base64.getEncoder().encodeToString(enCrypted); //кодирует зашифрованные байты в строку в формате Base64 и возвращает ее
    }



}
