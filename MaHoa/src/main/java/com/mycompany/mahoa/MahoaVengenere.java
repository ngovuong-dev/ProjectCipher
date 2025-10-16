
package com.mycompany.mahoa;




public class MahoaVengenere {
    public static String encrypt(String text,String key)
    {   
        //để tạo và chỉnh sửa chuỗi có thể thay đổi được.
        StringBuilder result = new StringBuilder();
       // tránh bị lỗi chưa viết hoa 
       text = text.toUpperCase();
        key = key.toUpperCase();
        
        for(int i=0;i<text.length();i++)
        {
            // lấy ra từng ký tự của chuỗi  text
            char c = text.charAt(i);
            // kiểm tra xem có phải là chữ hay không 
            if(Character.isLetter(c)){
                // chuyển đổi từng kí tự  thành giá trị tương ứng trong bảng mã ASCII
                int TextVallue = c - 'A';
                //kiểm tra key nếu Text > key thì lặp lại khóa
                int KeyVallue= key.charAt(i%key.length())-'A';
                // tính ra kết quả và đảm bảo kết quả nằm trong A–Z và chuyển số thành kí tự
                char encrypted = (char)('A' + (TextVallue+KeyVallue)%26);
                // mỗi lần bạn mã hóa được 1 ký tự, bạn gắn nó vào cuối chuỗi kết quả
                
                result.append(encrypted);
                
            }
            
            
        }
        
        //chuyển StringBuilder thành chuỗi bình thường (String).
       return result.toString();
}
    
    public static String Decrypt(String text,String key){
        //để tạo và chỉnh sửa chuỗi có thể thay đổi được.
        StringBuilder result = new StringBuilder();
       // tránh bị lỗi chưa viết hoa 
       text = text.toUpperCase();
        key = key.toUpperCase();
        
        for(int i=0;i<text.length();i++)
        {
            // lấy ra từng ký tự của chuỗi  text
            char c = text.charAt(i);
            // kiểm tra xem có phải là chữ hay không 
            if(Character.isLetter(c)){
                // chuyển đổi từng kí tự  thành giá trị tương ứng trong bảng mã ASCII
                int TextVallue = c - 'A';
                //kiểm tra key nếu Text > key thì lặp lại khóa
                int KeyVallue= key.charAt(i%key.length())-'A';
                // tính ra kết quả và đảm bảo kết quả nằm trong A–Z và chuyển số thành kí tự
                char encrypted = (char)('A' + ((TextVallue-KeyVallue)+26)%26);
                // mỗi lần bạn mã hóa được 1 ký tự, bạn gắn nó vào cuối chuỗi kết quả
              
                result.append(encrypted);
                 
            }
            
        }
        
        //chuyển StringBuilder thành chuỗi bình thường (String).
       return result.toString();
        
        
        
    }
    
    
    public static String generateFullKey(String text, String key) {
    StringBuilder newKey = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        char c = key.charAt(i % key.length()); // lặp lại key
        newKey.append(c);
    }
    return newKey.toString();
}
    
}
