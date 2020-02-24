/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Vector;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
/**
 * @author xavier
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Cryptage 
{
public String encrypt(String password,String key){
try
{
Key clef = new SecretKeySpec(key.getBytes(),"Blowfish");
Cipher cipher=Cipher.getInstance("Blowfish");
cipher.init(Cipher.ENCRYPT_MODE,clef);
byte[] cipherText = cipher.doFinal(password.getBytes());
return new String(cipherText, "UTF8");
}
catch (Exception e)
{
return null;
}
}
 public String decrypt(byte[] password,String key){
try
{
Key clef = new SecretKeySpec(key.getBytes(),"Blowfish");
Cipher cipher=Cipher.getInstance("Blowfish");
cipher.init(Cipher.DECRYPT_MODE,clef);
byte[] cipherText = cipher.doFinal(password);

return new String(cipherText, "UTF8");
}
catch (Exception e)
{
System.out.println(e);
return null;
}
}
 
}