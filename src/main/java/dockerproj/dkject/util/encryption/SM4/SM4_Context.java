package dockerproj.dkject.util.encryption.SM4;

public class SM4_Context {
    public boolean isPadding;
    public int mode;
    public long[] sk;

    public SM4_Context() {
        super();
        this.mode = 1;
        this.isPadding = true;
        this.sk = new long[32];
    }
}