package com.thinksns.unit;
import javax.crypto.Cipher;  
import javax.crypto.spec.IvParameterSpec;  
import javax.crypto.spec.SecretKeySpec; 
public class DES {  
    private static byte[] iv = {1,2,3,4,5,6,7,8};  
    public static String encrypt(String encryptString, String encryptKey) throws Exception {  
//      IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);   
        IvParameterSpec zeroIv = new IvParameterSpec(iv);  
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");  
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");  
        cipher.init(Cipher.ENCRYPT_MODE, key);  
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());  
       
        return Base64.encode(encryptedData);  
    }  
    public static String decrypt(String decryptString, String decryptKey) throws Exception {  
        new Base64();
		byte[] byteMi = Base64.decode(decryptString);  
        IvParameterSpec zeroIv = new IvParameterSpec(iv);  
//      IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);   
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");  
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");  
        cipher.init(Cipher.DECRYPT_MODE, key);  
        byte decryptedData[] = cipher.doFinal(byteMi);  
       
        return new String(decryptedData);  
    }  
}  