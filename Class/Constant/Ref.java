package Class.Constant;

public class Ref extends ConstantInfo {
    public final short class_index;
    public final short name_and_type;
    public Ref(short classindex, short name_name_type) {
        this.class_index = classindex;
        this.name_and_type = name_name_type;
    }

    @Override
    public void Out() {
        System.out.println(String.format("Class Index: %d\nNAT: %d", class_index, name_and_type));
    }

    @Override
    public String ToString() {
        throw new UnsupportedOperationException("Unimplemented method 'ToString'");
    }


    @Override
    public String Type() {
        return "References Method (Java)";
    }
    
}
