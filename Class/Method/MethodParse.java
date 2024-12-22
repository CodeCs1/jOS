package Class.Method;

import java.nio.ByteBuffer;
import java.util.LinkedList;

import Class.ClassStruct;
import Class.Attributes.AttributesParse;

public class MethodParse {
    private final ByteBuffer buff;
    private final ClassStruct str;
    private final LinkedList<Method> method;
    public MethodParse(ByteBuffer buff, ClassStruct cl) {
        this.buff = buff;
        this.str = cl;
        this.method=new LinkedList<Method>();
    }
    private void ParseOnce() {
        Method me=new Method();
        me.access = buff.getShort();
        me.nameIndex = buff.getShort();
        me.descriptor = buff.getShort();
        me.attributes_count=buff.getShort();
        me.attributes = new AttributesParse(buff, me.attributes_count).Parse();
        method.add(me);
    }

    public LinkedList<Method> Parse() {
        int i=0;
        while(i<str.MethodCount) {
            ParseOnce();
            i++;
        }
        return method;
    }
}
