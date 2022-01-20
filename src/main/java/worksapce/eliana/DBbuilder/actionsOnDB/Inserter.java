package worksapce.eliana.DBbuilder.actionsOnDB;

import worksapce.eliana.DBbuilder.ConfigLoader;
import worksapce.eliana.DBbuilder.objects.DataBase;
import worksapce.eliana.DBbuilder.objects.Record;
import worksapce.eliana.DBbuilder.objects.Table;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Inserter {

    public void insertRecord(String dbName, String tableName, Record record) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));
        FileWriter writer = new FileWriter(path+"\\"+dbName+"\\"+tableName+".csv",true);
        writer.write(System.lineSeparator());
        writer.write(record.toStringCsv());
        writer.flush();
        writer.close();
    }

    public void insertNewTable(String dbName, String tableName, String ... cols) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));
        Table table = new Table(tableName, cols);
        File file = new File(path+"\\"+dbName+"\\"+tableName+".csv");
        FileWriter writer = new FileWriter(file);

        writer.write(table.colsToCsv());
        writer.flush();
        writer.close();
    }

    public void insertExistingTable(String dbName, Table table) throws IOException {

        String path = (new ConfigLoader().load().getProperty("allDBsPath"));
        FileWriter writer = new FileWriter(path+"\\"+dbName+"\\"+table.getTableName()+".csv");

        writer.write(table.colsToCsv());
        writer.flush();
        writer.close();

        for (Record record : table.getTable().values())
        {
            insertRecord(dbName, table.getTableName(), record);
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
