package Class.Attributes;

import java.util.LinkedList;

public class CodeAttributes {
    public short max_stack;
    public short max_locals;
    public int code_length;
    public byte[] code;
    public short ExceptionTable;

    public short AttributesCount;
    public LinkedList<Attributes> Attributes;
}
