package worksapce.eliana.DBbuilder.objects;

import java.util.ArrayList;
import java.util.List;

public class Record {

    private List<Object> record;

    public Record()
    {
        this.record = new ArrayList<>();
    }

    public Record(List<Object> record)
    {
        this.record=record;
    }

    public Record(Object... objects)
    {
        this.record = new ArrayList<Object>(List.of(objects));
    }

    @Override
    public String toString() {
        return "Record{" +
                "record=" + record +
                '}';
    }

    public String toStringCsv()
    {
        String ret="";
        int len = this.record.size();
        for(Object obj : this.record)
        {
            len--;
            if(len==0)
            {
                ret+=obj.toString();
            }
            else
            {
                ret+=obj.toString()+",";
            }
        }
        return ret;
    }
}
