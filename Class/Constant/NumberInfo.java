package Class.Constant;

public class NumberInfo extends ConstantInfo {
    private final long bytes;

    public NumberInfo(long bytes) {
        this.bytes = bytes;
    }

    @Override
    public void Out() {
        System.out.println(String.format("Number (32): %f", bytes));
    }

    @Override
    public String ToString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToString'");
    }

    @Override
    public String Type() {
        // TODO Auto-generated method stub
        return "Real Number 32-bit (Java)";
    }
    
}
