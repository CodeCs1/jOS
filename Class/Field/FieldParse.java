package Class.Field;

import java.nio.ByteBuffer;
import java.util.LinkedList;

import Class.ClassStruct;
import Class.Attributes.AttributesParse;

public class FieldParse {
private final ByteBuffer buff;
    private final ClassStruct str;
    private final LinkedList<Field> field;
    public FieldParse(ByteBuffer buff, ClassStruct cl) {
        this.buff = buff;
        this.str = cl;
        this.field=new LinkedList<Field>();
    }
    private void ParseOnce() {
        Field fl=new Field();
        fl.access_fl = buff.getShort();
        fl.name_index = buff.getShort();
        fl.descriptorIndex = buff.getShort();
        fl.attributes_count=buff.getShort();
        fl.Attributes = new AttributesParse(buff, fl.attributes_count).Parse();
        field.add(fl);
    }

    public LinkedList<Field> Parse() {
        int i=0;
        while(i<str.MethodCount) {
            ParseOnce();
            i++;
        }
        return field;
    }
}
