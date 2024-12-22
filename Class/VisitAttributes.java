package Class;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import Class.Attributes.*;

public class VisitAttributes {
    private final LinkedList<Attributes> attr;
    private final LinkedList<CodeAttributes> codeattr;
    public VisitAttributes(LinkedList<Attributes> attr) {
        this.attr = attr;
        this.codeattr = new LinkedList<>();
    }

    private void VisitCodeAttr() {
        for (CodeAttributes c : codeattr) {
            System.out.println(String.format("MAX_STACK %d, MAX_LOCAL %d", c.max_stack, c.max_locals));
            int i=0;
            while(i < c.code_length) {
                byte b = c.code[i];
                System.out.print(String.format("Byte Instruction: %X ", b));
                switch(b) {
                    case (byte)0x2a: System.out.print("aload_0"); break;
                    case (byte)0xb7: System.out.print("invokespecial"); i+=2; break;
                    case (byte)0xb1: System.out.print("return"); break;

                    case (byte)0xb2: System.out.print("getstatic"); i+=2; break;
                    case (byte)0x12: System.out.print("ldc"); i+=1; break;
                    case (byte)0xb6: System.out.print("invokevirtual"); i+=2; break;
                }
                System.out.println();
                i++;
            }
        }
    }

    public void Visit() {
        for (Attributes attrs: attr) {
            ByteBuffer buff = ByteBuffer.wrap(attrs.info);
            CodeAttributes code = new CodeAttributes();
            code.max_stack=buff.getShort();
            code.max_locals=buff.getShort();
            code.code_length=buff.getInt();
            code.code = new byte[code.code_length];
            for (int i=0;i<code.code_length;i++) {
                code.code[i] = buff.get();
            }
            code.ExceptionTable=buff.getShort();
            if (code.ExceptionTable>0) {}
            code.AttributesCount=buff.getShort();
            code.Attributes = new AttributesParse(buff, code.AttributesCount).Parse();
            codeattr.add(code);
        }
        VisitCodeAttr();
    }
}
