package Class.Constant;

public class Number64Info extends ConstantInfo {

    private final long high_bytes;
    private final long low_bytes;

    public Number64Info(long high_bytes, long low_bytes) {
        this.low_bytes = low_bytes;
        this.high_bytes = high_bytes;
    }

    @Override
    public void Out() {
        System.out.println(String.format("Number64: H: %d, L: %d", high_bytes, low_bytes));
    }

    @Override
    public String ToString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToString'");
    }

    @Override
    public String Type() {
        return "Number64 (Java)";
    }
    
}
