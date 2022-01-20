package worksapce.eliana.DBbuilder.objects;

import java.util.Map;

public class AllDBs {

    private Map<String, DataBase> allDBs;



    public Map<String, DataBase> getAllDBs() {
        return allDBs;
    }


    public void setAllDBs(Map<String, DataBase> allDBs) {
        this.allDBs = allDBs;
    }
}
