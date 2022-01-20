package worksapce.eliana.DBbuilder;

import worksapce.eliana.DBbuilder.actions.Inserter;
import worksapce.eliana.DBbuilder.objects.Record;

import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {

        Inserter inserter = new Inserter();
        inserter.insertNewDB("TV");
        inserter.insertNewTable("TV","Movies","yearOut",
                "actorsNo", "leadActor", "rate");

        inserter.insertRecord("TV", "Movies",
                new Record((new Date()), 20, "aniston", "9outOf10"));

        inserter.insertRecord("TV", "Movies",
                new Record((new Date(1980,3,10)), 7, "ross", "7outOf10"));

        inserter.insertNewDB("cats");
        inserter.insertNewTable("cats", "mizi", "weight",
                "color", "height", "age");
    }
}
