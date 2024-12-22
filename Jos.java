import java.io.*;
import java.nio.ByteBuffer;

import Class.*;
import Class.Method.*;
import Class.Attributes.*;
import Class.Field.FieldParse;

class Jos {
    private static void Println(Object obj) {
        System.out.println(obj);
    }
    private static ByteBuffer classbyte;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        InputStream classstr = new FileInputStream(args[0]);
        ClassStruct cl = new ClassStruct();
        classbyte = ByteBuffer.wrap(classstr.readAllBytes());
        cl.Magic = classbyte.getInt();
        if (cl.Magic != 0xCAFEBABE) {
            throw new Exception("Invaild java class file!");
        }
        cl.Minor = classbyte.getShort();
        cl.Major = classbyte.getShort();
        cl.ConstantCount = classbyte.getShort();
        Println(String.format("Java class Version: %d.%d", cl.Major, cl.Minor));
        cl.ConstantPool = new ParseConstant(classbyte, cl).Parse();
        cl.access_fl = classbyte.getShort();
        cl.this_class = classbyte.getShort();
        cl.super_class = classbyte.getShort();
        cl.Interfaces_count = classbyte.getShort();
        //interface = class interface
        if (cl.Interfaces_count > 0) {}
        cl.FieldCount = classbyte.getShort();
        if (cl.FieldCount > 0) cl.Field=new FieldParse(classbyte, cl).Parse();
        cl.MethodCount = classbyte.getShort();
        if (cl.MethodCount > 0) cl.method = new MethodParse(classbyte, cl).Parse();
        cl.attributes_count=classbyte.getShort();
        if (cl.attributes_count > 0) cl.Attributes = new AttributesParse(classbyte, cl).Parse();
        classstr.close();

        for (Method m : cl.method) {
            new VisitAttributes(m.attributes).Visit();
        }
    }
}