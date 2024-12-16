package Class.Constant;

public class UTF8 extends ConstantInfo{
    public final short length;
    public final String Text;
    public UTF8(short length, String Text) {
        this.length = length;
        this.Text = Text;
    }

    @Override
    public void Out() {
        System.out.println(String.format("Length: %d\nString: %s", length, new String(Text)));
    }

    @Override
    public String ToString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToString'");
    }

    @Override
    public String Type() {
        return "UTF8 (Java)";
    }
    
}
