
package mahoabangchudon;
import java.util.Scanner;

public class MaHoabangChuDon {
    // bang ma ban dau
    static String VSCII = "abcdefghijklmnopqrstuvwxyz";
     // HÀM TẠO KEY NGẪU NHIÊN 
    public static String taoKeyNgauNhien() {
        char[] chars = VSCII.toCharArray(); // chuyển chuỗi thành mảng ký tự
        int n = chars.length;

        // Thuật toán trộn ngẫu nhiên (Fisher-Yates)
        for (int i = 0; i < n; i++) {
            int j = (int) (Math.random() * n); // chọn vị trí ngẫu nhiên
            // hoán đổi chars[i] và chars[j]
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        // Chuyển mảng ký tự đã trộn thành chuỗi
        String result = "";
        for (int i = 0; i < n; i++) {
            result += chars[i];
        }
        return result;
    }

    // HÀM MỞ RỘNG KEY (nếu ngắn hơn 26 ký tự) 
    public static String moRongKey(String key) {
         key = key.toLowerCase();
        String newKey = "";

        // B1: loại bỏ ký tự trùng lặp trong key người dùng nhập
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c >= 'a' && c <= 'z' && newKey.indexOf(c) == -1) {
                newKey += c;
            }
        }

        // B2: bổ sung các ký tự còn thiếu trong bảng chữ cái
        for (int i = 0; i < VSCII.length(); i++) {
            char c = VSCII.charAt(i);
            if (newKey.indexOf(c) == -1) {
                newKey += c;
            }
        }

        return newKey;
    }

    //  HÀM MÃ HÓA 
    public static String Encrypt(String text, String key) {
        text = text.toLowerCase();
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                // Tìm vị trí của ký tự trong bảng chữ cái
                int index = VSCII.indexOf(c);
                // Lấy ký tự tương ứng trong key
                result += key.charAt(index);
            } else {
                // Giữ nguyên ký tự đặc biệt, khoảng trắng
                result += c;
            }
        }

        return result;
    }

    // HÀM GIẢI MÃ 
    public static String Decrypt(String text, String key) {
        text = text.toLowerCase();
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                // Tìm vị trí của ký tự trong key
                int index = key.indexOf(c);
                // Lấy lại ký tự gốc từ bảng chữ cái
                result += VSCII.charAt(index);
            } else {
                result += c;
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.println("MA HOA BANG CHU DON ");
        System.out.print("Ban muon nhap key hay random key? (nhap/rand): ");
        String chon = sc.nextLine().trim().toLowerCase();

        String key;

        // Nếu chọn random → tạo key ngẫu nhiên bằng hàm tự viết
        if (chon.equals("rand")) {
            key = taoKeyNgauNhien();
            System.out.println(" Key ngau nhien duoc tao: " + key);
        } else {
            System.out.print("Nhap key (co the ngan hon 26 ky tu): ");
            key = sc.nextLine().toLowerCase();
            key = moRongKey(key);
            System.out.println(" Key sau khi mo rong: " + key);
        }

        System.out.print("\nNhap van ban can ma hoa: ");
        String text = sc.nextLine();

        String maHoa = Encrypt(text, key);
        System.out.println(" Chuoi sau ma hoa: " + maHoa);

        String giaiMa = Decrypt(maHoa, key);
        System.out.println(" Chuoi sau giai ma: " + giaiMa);
    }
    
}
