package Class;
import java.util.LinkedList;
import Class.Constant.ConstantInfo;
import Class.Field.Field;
import Class.Method.Method;
import Class.Attributes.Attributes;

public class ClassStruct {
    public Integer Magic;
    public Short Minor;
    public Short Major;
    public Short ConstantCount;
    public LinkedList<ConstantInfo> ConstantPool;
    public Short access_fl;
    public Short this_class;
    public Short super_class;
    public Short Interfaces_count;
    public byte[] Interfaces;
    public Short FieldCount;
    public LinkedList<Field> Field;
    public short MethodCount;
    public LinkedList<Method> method;
    public Short attributes_count;
    public LinkedList<Attributes> Attributes;
}
