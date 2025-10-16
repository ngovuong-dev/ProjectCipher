
package mahoabangchudon;
import java.util.Scanner;

public class MaHoabangChuDon {
    // bang ma ban dau
    static String VSCII = "abcdefghijklmnopqrstuvwxyz";
    // key 
     static String key = "mwgokdtlzcelcbnxhsyrpiqua";
    //code ma hoa 
    public static String Encrypt(String text,String key){
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
    // giai ma
     public static String Decrypt(String text,String key){
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
   
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in); // tạo đối tượng nhập liệu

        // nhập văn bản gốc
        System.out.print("nhap van ban can ma hoa: ");
        String text = sc.nextLine();

       

        // gọi hàm mã hóa
        String encrypted = Encrypt(text, key);
        System.out.println("chuoi sau ma hoa: " + encrypted);

        // gọi hàm giải mã
        String decrypted = Decrypt(encrypted, key);
        System.out.println("chuoi sau giai ma : " + decrypted);
      
    }
    
}
