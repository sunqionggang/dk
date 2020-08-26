package dockerproj.dkject.util.encryption.SM4;

import dockerproj.dkject.util.encryption.M2.Util;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.regex.Pattern;

public class SM4Utils {
    public boolean hexString;
    public String iv="key2020sun2020iv";
    public String secretKey;

    public static String sm4Decrypt(String key,String message) {
        SM4Utils v0 = new SM4Utils();
        v0.secretKey = key;
        v0.hexString = false;
        return v0.decryptData_CBC(message);
    }

    public static String sm4Encrypt(String key,String message) {
        SM4Utils v0 = new SM4Utils();
        v0.secretKey = key;
        v0.hexString = false;
        return v0.encryptData_CBC(message);
    }

    public String decryptData_CBC(String arg9) {
        byte[] v3;
        byte[] v2;
        try {
            arg9 = Base64.encodeBase64String(Util.hexToByte(arg9));
            if(arg9 != null && arg9.trim().length() > 0) {
                arg9 = Pattern.compile("\\s*|\t|\r|\n").matcher(((CharSequence)arg9)).replaceAll("");
            }

            SM4_Context v1 = new SM4_Context();
            v1.isPadding = true;
            v1.mode = 0;
            if(this.hexString) {
                v2 = Util.hexStringToBytes(this.secretKey);
                v3 = Util.hexStringToBytes(this.iv);
            }
            else {
                v2 = this.secretKey.getBytes();
                v3 = this.iv.getBytes();
            }

            SM4 v4 = new SM4();
            v4.sm4_setkey_dec(v1, v2);
            return new String(v4.sm4_crypt_cbc(v1, v3, Base64.decodeBase64(arg9)), "UTF-8");
        }
        catch(Exception v0) {
            v0.printStackTrace();
            return null;
        }
    }

    public String encryptData_CBC(String arg7) {
        byte[] v2;
        byte[] v1;
        try {
            SM4_Context v0_1 = new SM4_Context();
            v0_1.isPadding = true;
            v0_1.mode = 1;
            if(this.hexString) {
                v1 = Util.hexStringToBytes(this.secretKey);
                v2 = Util.hexStringToBytes(this.iv);
            }
            else {
                v1 = this.secretKey.getBytes();
                v2 = this.iv.getBytes();
            }

            SM4 v3 = new SM4();
            v3.sm4_setkey_enc(v0_1, v1);
            return Util.byteToHex(v3.sm4_crypt_cbc(v0_1, v2, arg7.getBytes("UTF-8")));
        }
        catch(Exception v0) {
            v0.printStackTrace();
            return null;
        }
    }

    public String decryptData_ECB(String arg8) {
        try {
            arg8 = Base64.encodeBase64String(Util.hexToByte(arg8));
            if(arg8 != null && arg8.trim().length() > 0) {
                arg8 = Pattern.compile("\\s*|\t|\r|\n").matcher(((CharSequence)arg8)).replaceAll("");
            }

            SM4_Context v1 = new SM4_Context();
            v1.isPadding = true;
            v1.mode = 0;
            byte[] v2 = this.hexString ? Util.hexStringToBytes(this.secretKey) : this.secretKey.getBytes();
            SM4 v3 = new SM4();
            v3.sm4_setkey_dec(v1, v2);
            return new String(v3.sm4_crypt_ecb(v1, Base64.decodeBase64(arg8)), "UTF-8");
        }
        catch(Exception v0) {
            v0.printStackTrace();
            return null;
        }
    }

    public String encryptData_ECB(String arg6) {
        try {
            SM4_Context v0_1 = new SM4_Context();
            v0_1.isPadding = true;
            v0_1.mode = 1;
            byte[] v1 = this.hexString ? Util.hexStringToBytes(this.secretKey) : Util.hexStringToBytes(this.secretKey);
            SM4 v2 = new SM4();
            v2.sm4_setkey_enc(v0_1, v1);
            return Util.byteToHex(v2.sm4_crypt_ecb(v0_1, arg6.getBytes("UTF-8")));
        }
        catch(Exception v0) {
            v0.printStackTrace();
            return null;
        }
    }

}