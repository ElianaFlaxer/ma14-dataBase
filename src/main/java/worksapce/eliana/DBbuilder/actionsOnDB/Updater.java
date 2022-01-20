package worksapce.eliana.DBbuilder.actionsOnDB;

import worksapce.eliana.DBbuilder.ConfigLoader;
import worksapce.eliana.DBbuilder.objects.Table;
import worksapce.eliana.DBbuilder.reader.CsvReader;

import java.io.IOException;

public class Updater {

    public void updateRecord(String dbName, String tableName, Object key, Object val, String col) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));

        CsvReader reader = new CsvReader(path+"\\"+dbName+"\\"+tableName+".csv");
        Table table = new Table(tableName, reader.allRecords(),reader.readCols());

        table.updateRecord(key,val,col);
        new Inserter().insertExistingTable(dbName,table);
    }
}
