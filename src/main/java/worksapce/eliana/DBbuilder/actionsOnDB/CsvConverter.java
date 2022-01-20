package worksapce.eliana.DBbuilder.actionsOnDB;

import worksapce.eliana.DBbuilder.objects.Record;

public class CsvConverter {

    public String convertRecord(Record record)
    {
        return record.toStringCsv();
    }
}
