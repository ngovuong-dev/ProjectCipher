/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.stu.cipher.model;

/**
 *
 * @author ngodu
 */
public abstract class CipherBase {
    public abstract String encrypt(String text, String key);
    public abstract String decrypt(String text, String key);
    public abstract String getName();
}
