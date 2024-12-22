package Class.Attributes;

import java.nio.ByteBuffer;
import java.util.LinkedList;

import Class.ClassStruct;

public class AttributesParse {
    private final ByteBuffer buff;
    private final int Length;
    private final LinkedList<Attributes> attr;
    public AttributesParse(ByteBuffer buff, ClassStruct cl) {
        this.buff = buff;
        this.Length = cl.attributes_count;
        this.attr = new LinkedList<>();
    }
    public AttributesParse(ByteBuffer buff, int length) {
        this.buff = buff;
        this.Length = length;
        this.attr = new LinkedList<>();
    }
    private void ParseOnce() {
        Attributes att = new Attributes();
        att.Index = buff.getShort();
        att.length = buff.getInt();
        att.info = new byte[(int)att.length];
        for (int i=0;i<att.length;i++) {
            att.info[i] = buff.get();
        }
        attr.add(att);
    }

    public LinkedList<Attributes> Parse() {
        int i=0;
        while(i < Length) {
            ParseOnce();
            i++;
        }
        return attr;
    }
}