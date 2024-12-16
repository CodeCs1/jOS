package Class.Constant;

public class ClassInfo extends ConstantInfo {

    private final short name_index;

    public ClassInfo(short name_index) {
        this.name_index = name_index;
    }

    @Override
    public void Out() {
        System.out.println(String.format("Class Index: %d", name_index));
    }

    @Override
    public String ToString() {
        throw new UnsupportedOperationException("Unimplemented method 'ToString'");
    }

    @Override
    public String Type() {
        return "Class Method (Java)";
    }
    
}
