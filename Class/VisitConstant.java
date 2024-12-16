package Class;

import java.util.LinkedList;
import Class.Constant.*;

public class VisitConstant {
    private final LinkedList<ConstantInfo> lst;
    public VisitConstant(LinkedList<ConstantInfo> lst) {
        this.lst = lst;
    }

    private Object Visit_Ref(Ref ref) {
        System.out.println(String.format("Ref: #%d.#%d", ref.class_index, ref.name_and_type));
        return ref.class_index;
    }
    private Object Visit_StringInfo(StringInfo utf) {
        Object str = Visit(lst.get(utf.location-1));
        System.out.println(String.format("Location: %d; String: %s",utf.location, str));
        return utf.location;
    }
    private Object Visit_UTF8(UTF8 UTF) {
        return UTF.Text;
    }

    private Object Visit(ConstantInfo info) {
        Object ret=null;
        if (info instanceof Ref) {
            ret=Visit_Ref((Ref)info);
        } else if (info instanceof StringInfo) {
            ret=Visit_StringInfo((StringInfo)info);
        } else if (info instanceof UTF8) {
            ret=Visit_UTF8((UTF8)info);
        }
        return ret;
    }

    public void VisitBegin() {
        int i=0;
        while(i < lst.size()) {
            Visit(lst.get(i));
            i++;
        }
    }
}
