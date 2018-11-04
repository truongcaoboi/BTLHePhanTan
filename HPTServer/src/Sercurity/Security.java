package Sercurity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import java.security.spec.PKCS8EncodedKeySpec;

public class Security {
	public Security() {
		CreateKeyPair();
	}
	
	private PrivateKey _privateKey=null;
	private PublicKey KeyPublicOfMe=null;
	private PublicKey KeyPublicNotMe=null;
	
	private void CreateKeyPair() {
		SecureRandom sr=new SecureRandom();
		try {
			KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048, sr);
			KeyPair kp=kpg.genKeyPair();
			_privateKey=kp.getPrivate();
			KeyPublicOfMe=kp.getPublic();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public String GetPublicKeyOfMe() {
		return KeyPublicOfMe.toString();
	}
	
	public void SetPublicKeyNotMe(String s) {
		try {
			byte[] keys = s.getBytes();
			X509EncodedKeySpec spec= new X509EncodedKeySpec(keys);
			KeyFactory kf=KeyFactory.getInstance("RSA");
			KeyPublicNotMe=kf.generatePublic(spec);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String GetPublicKeyNotme() {
		return KeyPublicNotMe.toString();
	}
	
	private String Encrypt(String input) {
//		X509EncodedKeySpec spec= new X509EncodedKeySpec(KeyPublic.getEncoded());
//		KeyFactory factory=KeyFactory.getInstance("RSA");
//		PublicKey pubKey=factory.generatePublic(spec);
		try {
			Cipher c=Cipher.getInstance("RSA");
			c.init(Cipher.ENCRYPT_MODE, KeyPublicNotMe);
			String strEncode=new String(Base64.getEncoder().encodeToString(c.doFinal(input.getBytes()))).toString();
			return strEncode;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	private String Decrypt(String input) {
		try {
			Cipher c=Cipher.getInstance("RSA");
			c.init(Cipher.DECRYPT_MODE, _privateKey);
			String strDecode=new String(c.doFinal(Base64.getDecoder().decode(input.getBytes()))).toString();
			return strDecode;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String MaHoa(String input) {
		return Encrypt(input);
	}
	public String GiaiMa(String input) {
		return Decrypt(input);
	}
}
