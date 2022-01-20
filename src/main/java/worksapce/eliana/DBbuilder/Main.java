package worksapce.eliana.DBbuilder;

import worksapce.eliana.DBbuilder.actionsOnDB.Deleter;
import worksapce.eliana.DBbuilder.actionsOnDB.Inserter;
import worksapce.eliana.DBbuilder.actionsOnDB.Updater;
import worksapce.eliana.DBbuilder.objects.Record;

import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {

        Inserter inserter = new Inserter();
        Deleter deleter = new Deleter();
        Updater updater = new Updater();

        inserter.insertNewDB("TV");
        inserter.insertNewTable("TV","Movies", "id",
                "yearOut", "actorsNo", "leadActor", "rate");

        inserter.insertRecord("TV", "Movies",
                new Record("1",(new Date()), 20, "aniston", "9outOf10"));

        inserter.insertRecord("TV", "Movies",
                new Record("2",(new Date(1980,3,10)), 7, "ross", "7outOf10"));

        inserter.insertRecord("TV", "Movies",
                new Record("3",(new Date(2000,7,10)), 3, "linda", "4outOf10"));

        inserter.insertNewDB("cats");
        inserter.insertNewTable("cats", "mizi", "weight",
                "color", "height", "age");

        deleter.deleteTable("cats","mizi");

        deleter.deleteRecord("TV", "Movies", "2");

        updater.updateRecord("TV", "Movies", "1",30,"actorsNo");
    }
}
