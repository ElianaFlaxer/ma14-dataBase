package worksapce.eliana.DBbuilder.actions;

import worksapce.eliana.DBbuilder.objects.Record;

public class CsvConverter {

    public String convertRecord(Record record)
    {
        return record.toStringCsv();
    }
}
