
package com.mycompany.mahoa;

import java.util.Scanner;

public class MaHoa {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("nhap van ban can ma hoa :");
        String Text=sc.nextLine();
        System.out.println("nhap key: ");
        String Key= sc.nextLine();
        // gọi hàm mã hóa 
        String encrypt =  MahoaVengenere.encrypt(Text,Key);
        //sinh ra key moi 
        String newKey = MahoaVengenere.generateFullKey(Text, Key);
        System.out.println("key sau khi lap day du : " + newKey);
        //ket qua ma hoa
        System.out.println("Chuoi sau khi ma hoa: " + encrypt );
         //giai ma
        System.out.println("nhap chuoi can giai ma :");
        String Text2=sc.nextLine();
        System.out.println("nhap key: ");
        String Key2= sc.nextLine();
        //goi ham giai ma
        String Decrypt=MahoaVengenere.Decrypt(Text2, Key2);
        System.out.println("chuoi sau khi giai ma la :" +Decrypt);
    }
}
