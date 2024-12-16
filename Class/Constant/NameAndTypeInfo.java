package Class.Constant;

public class NameAndTypeInfo extends ConstantInfo {

    private final short name_index;
    private final short descriptor_index;

    public NameAndTypeInfo(short name_index, short descriptor_index) {
        this.name_index =name_index;
        this.descriptor_index = descriptor_index;
    }

    @Override
    public void Out() {
        System.out.println(String.format("Name Index: %d\nDescriptorIndex: %d", name_index, descriptor_index));
    }

    @Override
    public String ToString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToString'");
    }

    @Override
    public String Type() {
        return "NameAndType (Java)";
    }
    
}
