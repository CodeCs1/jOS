package Class;

import java.nio.ByteBuffer;
import java.util.LinkedList;

import Class.Constant.*;

public class ParseConstant {
    private final ByteBuffer buffer;
    private final Short Constantlength;
    private final LinkedList<ConstantInfo> constant;
    private void ParseOnce() {
        byte tag = buffer.get();
        switch(tag) {
            case 0x0A: // Methodref & FieldRef & InterfaceMethodRef
            case 0x09:
            case 0x0B:
                short classindex = buffer.getShort();
                short name_and_type = buffer.getShort();
                constant.add(new Ref(classindex, name_and_type));
                break;
            case 0x03: // Integer
            case 0x04: // Float
                constant.add(new NumberInfo(buffer.getLong()));
                break;
            case 0x05: // Long 
            case 0x06: // Double
                constant.add(new Number64Info(buffer.getLong(), buffer.getLong()));
                break;
            case 0x0F: // MethodHandle
                break;
            case 0x10: // MethodType
                break;
            case 0x12: // InvokeDynamic
                break;
            case 0x07: // Class
                constant.add(new ClassInfo(buffer.getShort()));
                break;
            case 0x0C: //Name and type
                short name_index = buffer.getShort();
                short descriptor_index = buffer.getShort();
                constant.add(new NameAndTypeInfo(name_index, descriptor_index));
                break;
            case 0x08: // String
                constant.add(new StringInfo(buffer.getShort()));
                break;
            case 0x01: // UTF8
                short length = buffer.getShort();
                byte[] b = new byte[length];
                for (int i=0;i<length;i++) {
                    b[i] = buffer.get();
                }
                constant.add(new UTF8(length, new String(b)));
                break;
            default: break;
        }
    }

    public LinkedList<ConstantInfo> Parse() {
        int i=1;
        while(i < Constantlength) {
            ParseOnce();
            i++;
        }
        return constant;
    }
    public ParseConstant(ByteBuffer buffer,ClassStruct struct) {
        this.buffer =buffer;
        this.Constantlength = struct.ConstantCount;
        this.constant = new LinkedList<ConstantInfo>();
    }


}