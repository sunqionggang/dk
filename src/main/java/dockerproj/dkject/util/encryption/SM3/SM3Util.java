package dockerproj.dkject.util.encryption.SM3;

import org.bouncycastle.util.encoders.Hex;

public class SM3Util {
    public static String sm3(String arg5) {
        byte[] v0 = new byte[32];
        byte[] v1 = arg5.getBytes();
        SM3Digest v2 = new SM3Digest();
        v2.update(v1, 0, v1.length);
        v2.doFinal(v0, 0);
        return new String(Hex.encode(v0)).toUpperCase();
    }
}