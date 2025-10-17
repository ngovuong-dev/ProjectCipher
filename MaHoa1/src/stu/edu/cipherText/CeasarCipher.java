package stu.edu.cipherText;

public class CeasarCipher extends CipherBase{

    public CeasarCipher(){ }
    @Override
    public String encrypt(String plainText,String key){
        int temp;
        try{
            //Chuyển từ chuỗi sang số nguyên từ A->Z
            temp=Integer.parseInt(key)%26;
        }catch(NumberFormatException ex){
            return "Khóa phải là số nguyên";
        }
        StringBuilder result = new StringBuilder();
        //duyệt từng kí tự của plainText
        for (int i = 0;i < plainText.length(); i++){
            char c = plainText.charAt(i);   
            //kiểm tra xem c có nằm A->Z
            if (c >= 'A' && c <= 'Z')
                c =(char) ((c - 'A'+ temp) % 26 + 'A');
            //kiểm tra xem c nó nằm a -> z
            else if (c >='a' && c <= 'z')
                c = (char) ((c - 'a' + temp) % 26 + 'a');
            //nối kí tự vào result 
            result.append(c);
            // giải phóng c khi kết thúc mỗi vòng lặp
        }
        return result.toString();
    }
    @Override
    public String decrypt(String cipherText,String key){
        int temp;
        try{
            //Chuyển từ chuỗi sang số nguyên từ A->Z
            temp=Integer.parseInt(key)%26;
        }catch(NumberFormatException ex){
            return "Khóa phải là số nguyên";
        }
        StringBuilder result = new StringBuilder();
        //duyệt từng kí tự của plainText
        for (int i=0;i<cipherText.length();i++){
            char c=cipherText.charAt(i);
            //kiểm tra xem c có nằm A->Z
            if (c >= 'A' && c <= 'Z')
                c = (char) ((c - 'A' - temp + 26) % 26 +'A');
             //kiểm tra xem c nó nằm a -> z
            else if (c >= 'a' && c <= 'z')
                c = (char) ((c - 'a' - temp + 26) % 26 +'a');
            //nối kí tự vào result 
            result.append(c);
            // giải phóng c khi kết thúc mỗi vòng lặp
        }
        return result.toString();
    }
}
