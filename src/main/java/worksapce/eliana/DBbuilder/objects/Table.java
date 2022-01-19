package worksapce.eliana.DBbuilder.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    private String tableName;
    private Map<Object,Record> table;

    public Table(String tableName, String... cols)
    {
        this.tableName=tableName;
        this.table=new HashMap<>();

        List<Object> list = new ArrayList<>();
        for(String col : cols)
        {
            list.add(col);
        }

        this.table.put(tableName,new Record(list));
    }
}
