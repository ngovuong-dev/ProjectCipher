package stu.edu.cipherText;

public class CeasarCipher extends CipherBase{
    private int key;
    public CeasarCipher(int k){
        // nằm trong phạm vi A-Z
        this.key=k%26;
    }
    @Override
    public String encrypt(String plainText,int key){
        StringBuilder result = new StringBuilder();
        //duyệt từng kí tự của plainText
        for (int i = 0;i < plainText.length(); i++){
            char c = plainText.charAt(i);   
            //kiểm tra xem c có nằm A->Z
            if (c >= 'A' && c <= 'Z')
                c =(char) ((c - 'A'+ key) % 26 + 'A');
            //kiểm tra xem c nó nằm a -> z
            else if (c >='a' && c <= 'z')
                c = (char) ((c - 'a' + key) % 26 + 'a');
            //nối kí tự vào result 
            result.append(c);
            // giải phóng c khi kết thúc mỗi vòng lặp
        }
        return result.toString();
    }
    @Override
    public String decrypt(String cipherText,int key){
        StringBuilder result = new StringBuilder();
        //duyệt từng kí tự của plainText
        for (int i=0;i<cipherText.length();i++){
            char c=cipherText.charAt(i);
            //kiểm tra xem c có nằm A->Z
            if (c >= 'A' && c <= 'Z')
                c = (char) ((c - 'A' - key + 26) % 26 +'A');
             //kiểm tra xem c nó nằm a -> z
            else if (c >= 'a' && c <= 'z')
                c = (char) ((c - 'a' - key + 26) % 26 +'a');
            //nối kí tự vào result 
            result.append(c);
            // giải phóng c khi kết thúc mỗi vòng lặp
        }
        return result.toString();
    }
}
