package edu.stu.cipher.model;

import edu.stu.cipher.model.CipherBase;

public class MonoCipher extends CipherBase {
    // bang ma ban dau
    static String VSCII = "abcdefghijklmnopqrstuvwxyz";
    // key 
     static String key = "mwgokdtlzcelcbnxhsyrpiqua";
     
     // Mã hóa
    @Override
    public String encrypt(String text, String key) {
        // đưa văn bản về cùng kiểu chữ
        text = text.toLowerCase();
        // kết quả trả về
        String result = "";
        // duyệt qua từng ký tự của văn bản mã hóa
        for (int i = 0; i < text.length(); i++) {
            // lấy từng kí tự trong văn bản 
            char c = text.charAt(i);
            // thảo mãn từng ký tự cảu văn bản mã hóa thuộc VSCII
            if (c >= 'a' && c <= 'z') {
                // tìm vị trí ký tự đó trong bảng chữ cái
                int index = VSCII.indexOf(c);
                // thay bằng ký tự tương ứng trong key
                result += key.charAt(index);
            } else {
                // giữ nguyên ký tự không phải chữ
                result += c;
            }
        }
        return result;
    }
    
    // Giải mã
    @Override
    public String decrypt(String text, String key) {
        // đưa văn bản về cùng kiểu chữ
        text = text.toLowerCase();
         String result = "";
        // duyệt qua từng ký tự của văn bản mã hóa
        for (int i = 0; i < text.length(); i++) {
            // lấy từng kí tự trong văn bản 
            char c = text.charAt(i);
            // thảo mãn từng ký tự cảu văn bản mã hóa thuộc VSCII
            if (c >= 'a' && c <= 'z') {
                // tìm vị trí ký tự đó trong key
                int index = key.indexOf(c);
                // lấy ký tự tương ứng trong bảng chữ cái gốc
                result += VSCII.charAt(index);
            } else {
                // giữ nguyên ký tự không phải chữ
                result += c;
            }
        }
        return result;    
    }
}
