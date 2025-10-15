/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author ngodu
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text = "ABCDEFGH";

        // 1. Tính kích thước của mảng kết quả
        int n = text.length() / 2;
        String[] result = new String[n];
        int resultIndex = 0;

        // 2. Dùng vòng lặp for với bước nhảy là 2
        for (int i = 0; i < text.length(); i += 2) {
            // 3. Cắt chuỗi con gồm 2 ký tự và gán vào mảng
            result[resultIndex] = text.substring(i, i + 2);
            resultIndex++;
        }
    }
    
}
