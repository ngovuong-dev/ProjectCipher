package edu.stu.cipher.model;

// Class base CipherBase
public abstract class CipherBase {
    public abstract String encrypt(String text, String key);
    public abstract String decrypt(String text, String key);
}
