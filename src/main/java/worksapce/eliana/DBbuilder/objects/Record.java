package worksapce.eliana.DBbuilder.objects;

import java.util.ArrayList;
import java.util.List;

public class Record {

    //private Object recordKey;
    private List<Object> record;

    public Record()
    {
        //this.recordKey = recordName;
        this.record = new ArrayList<>();
        //this.record.add(recordName);
    }

    public Record(List<Object> record)
    {
        //this.recordKey=recordKey;
        this.record=record;
    }
}
