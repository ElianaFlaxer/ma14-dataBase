package worksapce.eliana.DBbuilder.reader;

import worksapce.eliana.DBbuilder.objects.Record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader<T> {

    private String fileName;

    public CsvReader(String fileName)
    {
        this.fileName=fileName;
    }

    public List<String> readCols() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        List<String> cols = new ArrayList<>();
        String splitBy = ",";

        String line = br.readLine();
        String[] all = line.split(splitBy);
        for(int i=0; i<all.length ;i++)
        {
            cols.add(all[i]);
        }
        return cols;
    }

    public Map<Object, Record> allRecords() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        Map<Object,Record> records = new HashMap<>();
        String line;
        String splitBy = ",";

        line = br.readLine();

        while ((line = br.readLine()) != null)
        {
            String[] all = line.split(splitBy);
            List<Object> objectsList = new ArrayList<>();
            for(int i=0; i<all.length ;i++)
            {
                objectsList.add((Object) all[i]);
            }
            Record record = new Record(objectsList);

            records.put(all[0],record);
        }

        return records;
    }
}
