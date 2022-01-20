package worksapce.eliana.DBbuilder.actionsOnDB;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import worksapce.eliana.DBbuilder.ConfigLoader;
import worksapce.eliana.DBbuilder.objects.Record;
import worksapce.eliana.DBbuilder.objects.Table;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Deleter {

    public void deleteRecord(String dbName, String tableName, Object objKey) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));

        CsvReader reader = new CsvReader(path+"\\"+dbName+"\\"+tableName+".csv");
        Table table = new Table(tableName, reader.allRecords(),reader.readCols());

        table.removeRecord(objKey);

        new Inserter().insertExistingTable(dbName,table);
    }

    public void deleteTable(String dbName, String tableName) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));
        File file = new File(path+"\\"+dbName+"\\"+tableName+".csv");
        file.delete();
    }
}
