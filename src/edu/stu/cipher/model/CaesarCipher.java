package edu.stu.cipher.model;

// Kế thừa từ CipherBase
import edu.stu.cipher.model.CipherBase;

public class CaesarCipher extends CipherBase {
    
    @Override
    public String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int genarateKey = Integer.parseInt(key); // Khởi tạo key sang int
        //duyệt từng kí tự của plainText
        for (int i = 0;i < text.length(); i++){
            char c = text.charAt(i);   
            //kiểm tra xem c có nằm A->Z
            if (c >= 'A' && c <= 'Z')
                c =(char) ((c - 'A'+ genarateKey) % 26 + 'A');
            //kiểm tra xem c nó nằm a -> z
            else if (c >='a' && c <= 'z')
                c = (char) ((c - 'a' + genarateKey) % 26 + 'a');
            //nối kí tự vào result 
            result.append(c);
            // giải phóng c khi kết thúc mỗi vòng lặp
        }
        return result.toString();
    }

    @Override
    public String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int genarateKey = Integer.parseInt(key); // Khởi tạo key sang int
        //duyệt từng kí tự của plainText
        for (int i = 0;i < text.length();i++){
            char c = text.charAt(i);
            //kiểm tra xem c có nằm A->Z
            if (c >= 'A' && c <= 'Z')
                c = (char) ((c - 'A' - genarateKey + 26) % 26 +'A');
             //kiểm tra xem c nó nằm a -> z
            else if (c >= 'a' && c <= 'z')
                c = (char) ((c - 'a' - genarateKey + 26) % 26 +'a');
            //nối kí tự vào result 
            result.append(c);
            // giải phóng c khi kết thúc mỗi vòng lặp
        }
        return result.toString();
    }
    
    @Override
    public String getName() {
        return "CaesarCipher";
    }


}
