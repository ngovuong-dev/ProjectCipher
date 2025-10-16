package edu.stu.cipher.model;

// Kế thừa từ CipherBase
import edu.stu.cipher.model.CipherBase;

public class Playfair extends CipherBase {
    
    public String[][] sinhKey(String key) { // Xử lý key sinh ra ma trận 5x5
        String[][] keyMatrix = new String[5][5];

        //Loại bỏ ký tự trùng
        key = key.toUpperCase(); // Chuyển key thành chữ hoa
        key = key.replace("I", "J"); // Thay I thành J
        for (int i = 0; i < key.length(); i++) {
            for (int j = i + 1; j < key.length(); j++) {
                if (key.charAt(i) == key.charAt(j)) {
                    key = key.substring(0, j) + key.substring(j + 1); // Loại bỏ ký tự trùng
                    j--; // Giữ nguyên vị trí j để kiểm tra ký tự tiếp theo
                }
            }
        }

        // Thêm vào ma trận 5x5 key vừa xử lý
        int index = 0; // Vị trí hiện tại trong key
        char word = 'A';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (index < key.length()) { // Thêm ký tự từ key vào ma trận
                    char charKey = key.charAt(index); // Lấy ký tự hiện tại trong key
                    keyMatrix[i][j] = String.valueOf(charKey); // Gán ký tự vào ma trận
                    index++;
                }
                else if (index == key.length()) { // Thêm các ký tự còn lại trong bảng chữ cái vào ma trận
                    while (word <= 'Z') { // Duyệt từ A đến Z
                        if (word != 'I' && key.indexOf(word) == -1) { // Bỏ qua I và kiểm tra ký tự đã có trong key chưa
                            keyMatrix[i][j] = String.valueOf(word); // Gán ký tự vào ma trận
                            word++;
                            break; // Thoát vòng lặp để tiếp tục gán ký tự tiếp theo trong ma trận
                        }
                        word++;
                    }
                }
            }
        }

        // Thay thế J thành IJ
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j].charAt(0) == 'J')
                    keyMatrix[i][j] = "IJ";
            }
        }

        // Trả về ma trận key
        return keyMatrix;
    }

    public String[] xuLyText(String text) { // Xử lý chuỗi nhập vào
        text = text.toUpperCase(); // chuyển text thành chữ hoa
        // Thêm X
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'X');
            }
        }
        text = sb.toString();

        // Thêm X vào nếu số lượng ký tự lẻ
        if (text.length() % 2 != 0) { 
            text = text + 'X';
        }

        // tách chuỗi thành mảng mỗi mảng 2 kí tự
        String[] result = new String[text.length()/2];
        int resultIndex = 0;
        for (int i = 0; i < text.length(); i += 2) {
            result[resultIndex] = text.substring(i, i + 2);
            resultIndex++;
        }
        return result;
    }

    public int[] viTriKyTuTrongKey(String[][] newKey, char charText) { // Tìm vị trí của 1 ký tự text trong ma trận key        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (newKey[i][j].length() == 2) { // Key ở vị trí này là 'IJ'
                    if (charText == 'I' || charText == 'J') {
                        return new int[] {i, j}; // Trả về vị trí
                    }
                }
                else if (newKey[i][j].charAt(0) == charText) { // text có nằm ở vị trí hiện tại không
                    return new int[] {i, j}; // Trả về vị trí
                }
            }     
        }
        return null;
    }
    
    @Override
    public String encrypt(String text, String key) { // Mã hóa Playfair
        String result = new String(); // Khởi tạo kết quả
        String[][] genarateKey = sinhKey(key); // Khởi tạo ma trận key đã xử lý
        String[] genarateText = xuLyText(text); // Khởi tạo mảng text đã xử lý

        int indexGenarateText = 0; // Vị trí của text đã xử lý
        while (indexGenarateText < genarateText.length) {
            int[] viTriKyTu1 = viTriKyTuTrongKey(genarateKey, genarateText[indexGenarateText].charAt(0)); // Vị trí của ký tự đầu tiên
            int[] viTriKyTu2 = viTriKyTuTrongKey(genarateKey, genarateText[indexGenarateText].charAt(1)); // Vị trí của ký tự thứ hai
            
            if (viTriKyTu1[0] == viTriKyTu2[0]) { // Nếu vị trí nằm chung một dòng, dịch sang phải một vị trí
                viTriKyTu1[1] += viTriKyTu1[1] == 4 ? -4 : 1; // Xử lý vị trí nếu nằm ở ô cuối thì dịch lại vị trí 0, ngược lại cộng thêm 1
                viTriKyTu2[1] += viTriKyTu2[1] == 4 ? -4 : 1;
            }
            else if (viTriKyTu1[1] == viTriKyTu2[1]) { // Nếu vị trí nằm chung một cột, dịch xuống dưới một vị trí  
                viTriKyTu1[0] += viTriKyTu1[0] == 4 ? -4 : 1; // Xử lý vị trí nếu nằm ở ô cuối thì dịch lại vị trí 0, ngược lại cộng thêm 1
                viTriKyTu2[0] += viTriKyTu2[0] == 4 ? -4 : 1;
            }
            else {
                // Swap vị trí nếu vị trí ký tự không nằm trên cùng dòng hoặc cột
                int temp = viTriKyTu1[1];
                viTriKyTu1[1] = viTriKyTu2[1]; // Vị trí cột của ký từ đầu sẽ bằng vị trí cột của ký tự 2
                viTriKyTu2[1] = temp; // Vị trí cột của ký từ 2 sẽ bằng vị trí cột của ký tự đầu
            }
            result += genarateKey[viTriKyTu1[0]][viTriKyTu1[1]];
            result += genarateKey[viTriKyTu2[0]][viTriKyTu2[1]];
            indexGenarateText++;
        }
        return result.toString();
    }
        
    @Override
    public String decrypt(String text, String key) { // Giải mã Playfair
        String result = new String();
        String[][] genarateKey = sinhKey(key); // Khởi tạo ma trận key đã xử lý
        String[] genarateText = xuLyText(text); // Khởi tạo mảng text đã xử lý

        int indexGenarateText = 0; // Vị trí của text đã xử lý
        while (indexGenarateText < genarateText.length) {
            int[] viTriKyTu1 = viTriKyTuTrongKey(genarateKey, genarateText[indexGenarateText].charAt(0)); // Vị trí của ký tự đầu tiên
            int[] viTriKyTu2 = viTriKyTuTrongKey(genarateKey, genarateText[indexGenarateText].charAt(1)); // Vị trí của ký tự thứ hai
            
            if (viTriKyTu1[0] == viTriKyTu2[0]) { // Nếu vị trí nằm chung một dòng, dịch sang trái một vị trí
                viTriKyTu1[1] = viTriKyTu1[1] == 0 ? 4 : viTriKyTu1[1] - 1; // Xử lý vị trí nếu nằm ở ô 0 thì dịch lại ô cuối, ngược lại cộng thêm 1
                viTriKyTu2[1] = viTriKyTu2[1] == 0 ? 4 : viTriKyTu2[1] - 1;
            }
            else if (viTriKyTu1[1] == viTriKyTu2[1]) { // Nếu vị trí nằm chung một cột, dịch lên một vị trí  
                viTriKyTu1[0] = viTriKyTu1[0] == 0 ? 4 : viTriKyTu1[0] - 1; // Xử lý vị trí nếu nằm ở ô 0 thì dịch lại ô cuối, ngược lại cộng thêm 1
                viTriKyTu2[0] = viTriKyTu2[0] == 0 ? 4 : viTriKyTu2[0] - 1;
            }
            else {
                // Swap vị trí nếu vị trí ký tự không nằm trên cùng dòng hoặc cột
                int temp = viTriKyTu1[1];
                viTriKyTu1[1] = viTriKyTu2[1]; // Vị trí cột của ký từ đầu sẽ bằng vị trí cột của ký tự 2
                viTriKyTu2[1] = temp; // Vị trí cột của ký từ 2 sẽ bằng vị trí cột của ký tự đầu
            }
            result += genarateKey[viTriKyTu1[0]][viTriKyTu1[1]];
            result += genarateKey[viTriKyTu2[0]][viTriKyTu2[1]];
            indexGenarateText++;
        }

        return result;
    }

    @Override
    public String getName() {
        return "Playfair";
    }
}
