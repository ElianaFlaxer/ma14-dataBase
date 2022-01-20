package worksapce.eliana.DBbuilder.actions;

import worksapce.eliana.DBbuilder.ConfigLoader;
import worksapce.eliana.DBbuilder.objects.DataBase;
import worksapce.eliana.DBbuilder.objects.Record;
import worksapce.eliana.DBbuilder.objects.Table;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Inserter {

    public void insertRecord(Record record, String tableName, String dbName) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));
        FileWriter writer = new FileWriter(path+"\\"+dbName+"\\"+tableName+".csv");
        writer.write(record.toStringCsv());
        writer.write(System.lineSeparator());
        writer.flush();
        writer.close();
    }

    public void insertNewTable(String dbName, String tableName, String ... cols) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));
        Table table = new Table(tableName, cols);
        File file = new File(path+"\\"+dbName+"\\"+tableName+".csv");
        FileWriter writer = new FileWriter(file);

        for (Record record : table.getTable().values())
        {
                insertRecord(record,tableName,dbName);
        }
    }

    public void insertExistingTable(String dbName, Table table) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));
        FileWriter writer = new FileWriter(path+"\\"+dbName+"\\"+table.getTableName()+".csv");

        for (Record record : table.getTable().values())
        {
            insertRecord(record,table.getTableName(),dbName);
        }
    }

    public void insertNewDB(String dbName) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));
        File file = new File(path+"\\"+dbName);
        file.mkdirs();
    }

    public void insertExistingDB(DataBase db) throws IOException {

        insertNewDB(db.getName());
        for(Table table : db.getDataBase().values())
        {
            insertExistingTable(db.getName(),table);
        }
    }
}
