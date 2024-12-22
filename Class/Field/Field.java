package Class.Field;

import java.util.LinkedList;
import Class.Attributes.Attributes;

public class Field {
    public short access_fl;
    public short name_index;
    public short descriptorIndex;
    public short attributes_count;
    public LinkedList<Attributes> Attributes;
}
