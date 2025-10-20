package edu.stu.cipher.model;

import edu.stu.cipher.model.CipherBase;

public class ShiftCipher extends CipherBase {
    
    @Override
    public String encrypt(String plainText, String key){
        // xóa space chuyển sang kí tự thường
        plainText = plainText.replaceAll(" ", "").toLowerCase();
        key = key.toLowerCase(); // chuyển chuỗi key sang kí tự thường
        
        //khởi tạo ma trận 
        int numberColumn = key.length(); // khai báo cột
        int numberRow = (int)Math.ceil((double)plainText.length()/key.length()); //Khai báo hàng Math.ceil dùng để làm tròn
        char[][] matrix= new char[numberRow][numberColumn];//Khai báo ma trận
        
        //Ghi ma trận
        int temp=0;
        for (int i=0;i<numberRow;i++)
            for (int j=0;j<numberColumn;j++){
                if (temp < plainText.length())
                    matrix[i][j]=plainText.charAt(temp++);
                else
                    matrix[i][j]='z';//Bổ sung z nếu thiếu
            }
        
        //Sắp xếp key theo thứ tự bảng chữ cái 
        char[] sortKey = key.toCharArray();
        for (int i=0;i<key.length();i++)
            for (int j=i+1;j<key.length();j++)
                if (sortKey[i] > sortKey[j]){
                    char sort = sortKey[i];
                    sortKey[i]=sortKey[j];
                    sortKey[j]=sort;
                }
        
        //Đọc ma trận theo chiều dọc
        StringBuilder cipherText = new StringBuilder();
        for (int i=0;i<sortKey.length;i++)
            for (int j=0;j<key.length();j++)
                if (sortKey[i]==key.charAt(j)){
                    for (int k=0;k<numberRow;k++)
                        cipherText.append(matrix[k][j]);
                    break;
                }
        return cipherText.toString();//trả kêt quả Chuyển sang kiểu String
    }
    
    @Override
    public String decrypt(String cipherText, String key){
        //xóa khoảng space và chuyển sang kí tự thường
        cipherText = cipherText.replaceAll(" ", "").toLowerCase();
        key = key.toLowerCase();

        //khởi tạo ma trận
        int numberColumn = key.length();//khai báo cột
        int numberRow = (int) Math.ceil((double) cipherText.length() / key.length()); // khai báo hàng 
        char[][] matrix = new char[numberRow][numberColumn];//khai báo ma trận

        // Sắp xếp key theo bảng chữ cái
        char[] sortKey = key.toCharArray();
        for (int i = 0; i < key.length(); i++) 
            for (int j = i + 1; j < key.length(); j++) 
                if (sortKey[i] > sortKey[j]) {
                    char sort = sortKey[i];
                    sortKey[i] = sortKey[j];
                    sortKey[j] = sort;
                }
            
        // Điền ký tự vào ma trận theo thứ tự cột của key đã sắp xếp
        int temp = 0;
        for (int i = 0; i < sortKey.length; i++) 
            for (int j = 0; j < key.length(); j++) 
                if (sortKey[i] == key.charAt(j)) {
                    for (int k = 0; k < numberRow; k++)
                        if (temp < cipherText.length())
                            matrix[k][j] = cipherText.charAt(temp++);
                    break;
                }
            
        // Đọc theo hàng để ra plainText
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < numberRow; i++) 
            for (int j = 0; j < numberColumn; j++) 
                plainText.append(matrix[i][j]);
        return plainText.toString();
    }   
}
