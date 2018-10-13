package comsdlminiproject.httpsgithub.ppms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetrolPumpDB {


    //column_names
    public static  final String KEY_ROWID = "_id";
    public static  final String KEY_DATE = "_date";
    public static  final String KEY_PETROLPRICE = "petrol_price";
    public static  final String KEY_DIESELPRICE = "diesel_price";
    public static  final String KEY_DIESELSOLD = "diesel_sold";
    public static  final String KEY_PETROLSOLD = "petrol_sold";

    //DB name & DB table name & version
    private final String DATABASE_NAME = "PetrolPumpDB";
    private final String DATABASE_TABLE = "RECORDS";
    private final int DATABASE_VERSION = 1;

    private DBHelper ourHelper;
    private final Context ourContext;

    private SQLiteDatabase ourDatabase;

    public PetrolPumpDB (Context context){

        ourContext = context;
    }


    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String sqlCode= "CREATE TABLE "+DATABASE_TABLE+" ("+
                    KEY_ROWID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    KEY_PETROLPRICE+ " TEXT NOT NULL, "+
                    KEY_PETROLSOLD+ " TEXT NOT NULL, "+
                    KEY_DIESELPRICE+ " TEXT NOT NULL, "+
                    KEY_DIESELSOLD+ " TEXT NOT NULL, "+
                    KEY_DATE+ " TEXT NOT NULL);";

            db.execSQL(sqlCode);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
            onCreate(db);
        }
    }

    public PetrolPumpDB open() throws SQLException{

        ourHelper = new DBHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        ourHelper.close();
    }

    public long createEntry(String petrolprice,String petrolsold,String dieselprice,String dieselsold,String date){
        ContentValues cv = new ContentValues();
        cv.put(KEY_PETROLPRICE,petrolprice);
        cv.put(KEY_PETROLSOLD,petrolsold);
        cv.put(KEY_DIESELPRICE,dieselprice);
        cv.put(KEY_DIESELSOLD,dieselsold);
        cv.put(KEY_DATE,date);

        return ourDatabase.insert(DATABASE_TABLE,null,cv);
        //returns number of values inserted(ADDS 1 row to DB)
    }

    public String getEntry(){
        String [] columns = new String[]{KEY_ROWID,KEY_PETROLPRICE,KEY_PETROLSOLD,KEY_DIESELPRICE,KEY_DIESELSOLD,KEY_DATE};

        Cursor c= ourDatabase.query(DATABASE_TABLE,columns,null,null,null,null,null);
        String result = "";

        //get index of where that specific column is
        int irowid = c.getColumnIndex(KEY_ROWID);
        int ipetprice = c.getColumnIndex(KEY_PETROLPRICE);
        int ipetsold = c.getColumnIndex(KEY_PETROLSOLD);
        int idieprice = c.getColumnIndex(KEY_DIESELPRICE);
        int idiesold = c.getColumnIndex(KEY_DIESELSOLD);
        int idate = c.getColumnIndex(KEY_DATE);


        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){

            result= result + c.getString(irowid)+
                    ": "+c.getString(ipetprice)+
                    ": "+c.getString(ipetsold)+
                    ": "+c.getString(idieprice)+
                    ": "+c.getString(idiesold)+
                    ": "+c.getString(idate)+"\n";
        }


        return result;
    }

    public long deleteEntry(String rowID){
        return ourDatabase.delete(DATABASE_TABLE,KEY_ROWID+"=?", new String[]{rowID});
    }

    public long updateEntry(String rowID, String petrolprice,String petrolsold,String dieselprice,String dieselsold,String date ){
        ContentValues cv = new ContentValues();
        cv.put(KEY_PETROLPRICE,petrolprice);
        cv.put(KEY_PETROLSOLD,petrolsold);
        cv.put(KEY_DIESELPRICE,dieselprice);
        cv.put(KEY_DIESELSOLD,dieselsold);
        cv.put(KEY_DATE,date);

        return ourDatabase.update(DATABASE_TABLE,cv,KEY_ROWID+"=?", new String[]{rowID});
    }
}
