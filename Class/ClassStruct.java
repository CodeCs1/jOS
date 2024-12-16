package Class;
import java.util.LinkedList;
import Class.Constant.ConstantInfo;

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
    public byte[] Field;
    public short MethodCount;
    public byte[] Method;
    public Short attributes_count;
    public byte[] Attributes;
}
