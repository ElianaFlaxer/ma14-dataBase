package worksapce.eliana.DBbuilder.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    private String tableName;
    private List cols;
    private Map<Object,Record> table;

    public Table(String tableName, String... cols)
    {
        this.tableName=tableName;
        this.table=new HashMap<>();

        this.cols = new ArrayList<>();
        for(String col : cols)
        {
            this.cols.add(col);
        }

        //this.table.put(tableName,new Record(list));
    }

    public Table(String tableName, Map<Object,Record> table, List<String> cols)
    {
        this.tableName=tableName;
        this.table=table;
        this.cols=cols;
    }

    public void removeRecord(Object objectKey)
    {
        this.table.remove(objectKey);
    }

    public String getTableName() {
        return tableName;
    }

    public Map<Object, Record> getTable() {
        return table;
    }

    public String colsToCsv()
    {
        String ret="";
        int len = this.cols.size();
        for(Object obj : this.cols)
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

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", table=" + table +
                '}';
    }
}
