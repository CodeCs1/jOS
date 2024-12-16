package Class.Constant;

public class StringInfo extends ConstantInfo {
    public final short location;
    public StringInfo(short location) {
        this.location = location;
    }
    @Override
    public void Out() {
        System.out.println(String.format("String index: %d", location));
    }
    @Override
    public String ToString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToString'");
    }
    @Override
    public String Type() {
        return "String (Java)";
    }
    
}
