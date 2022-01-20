package worksapce.eliana.DBbuilder.objects;

import java.util.Map;

public class DataBase {

    private String name;
    private Map<String, Table> dataBase;

    public DataBase(String name)
    {
        this.name=name;
    }

    public DataBase(String name, Map<String, Table> dataBase)
    {
        this.name=name;
        this.dataBase=dataBase;
    }

    public String getName() {
        return name;
    }

    public Map<String, Table> getDataBase() {
        return dataBase;
    }
}
