package madproject.collegesystem;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

//import static android.os.Build.ID;


public class DBhelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Students.db";

    public static final String TABLE_NAME = "StudentMarks_table";

    public static final String TABLE_NAMELOGIN = "Login_table";


    public static final String ADMINID = "adminid";
    public static final String ADUNAME = "username";
    public static final String ADPASS = "adpass";

/////////////////////////////////////////////////////////

    public static final String COL1 = "stuid";
    public static final String COL2 = "StuNAME";
    public static final String COL3 = "stuclass";

    public static final String COL4 = "SCIENCE";
    public static final String COL5 = "MATHS";
    public static final String COL6 = "ENGLISH";
    public static final String COL7= "HISTORY";
    public static final String COL8= "LIT";
    public static final String COL9= "COM";
    public static final String COL10="ICT";
    public static final String COL11= "RELIGION";
    public static final String COL12= "SINHALA";


    public DBhelper(Context context) {

        super(context, DATABASE_NAME, null, 3);

        Log.e("database operations","database created!!");




    }


    @Override
    public void onCreate(SQLiteDatabase mydb) {

        mydb.execSQL("create table "+TABLE_NAME+"(stuid integer PRIMARY KEY ,StuNAME TEXT,stuclass TEXT,SCIENCE TEXT,MATHS TEXT,ENGLISH TEXT,HISTORY TEXT,LIT TEXT,COM TEXT,ICT TEXT,RELIGION TEXT,SINHALA TEXT)");
//
//        Log.e("DB Operations","Marks table created!");

       // mydb.execSQL("create table "+TABLE_NAMELOGIN+"(adminid integer PRIMARY KEY ,username TEXT,adpass TEXT)");

       // Log.e("DB Operations","Admin table created!");

//        mydb.execSQL("INSERT INTO Login_table(adminid,username,adpass)\n" +
//                "  VALUES(1,'Amal','Amal@123') ");
//
//        Log.e("DB Operations","Admin table data inserted!");

    }


    @Override
    public void onUpgrade(SQLiteDatabase mydb, int oldV, int newV) {

      //mydb.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);

        mydb.execSQL("create table "+TABLE_NAMELOGIN+"(adminid integer PRIMARY KEY ,username TEXT,adpass TEXT)");
        String sql="INSERT OR REPLACE INTO "+ TABLE_NAMELOGIN+"(adminid,username,adpass)VALUES(1,'Amal','Amal@123') ";
        mydb.execSQL(sql);


    Log.e("DB Operations","Admin table data inserted!");

       // mydb.execSQL("DROP TABLE IF EXISTS " +TABLE_NAMELOGIN);

       // onCreate(mydb);


    }

    public boolean insertdata(String id,String name,String sclass,String science,String maths,String english,String history,String lit,String comm,String ict,String religion,String sinhala)

    {

        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();


        contentvalues.put(COL1, id);
        contentvalues.put(COL2, name);
        contentvalues.put(COL3, sclass);

        contentvalues.put(COL4, science);
        contentvalues.put(COL5, maths);
        contentvalues.put(COL6, english);
        contentvalues.put(COL7, history);
        contentvalues.put(COL8, lit);
        contentvalues.put(COL9, comm);
        contentvalues.put(COL10, ict);
        contentvalues.put(COL11, religion);
        contentvalues.put(COL12, sinhala);


        long result = mydb.insert(TABLE_NAME, null, contentvalues);

        if (result == -1)
        {
            return false;

        }

        else

            {

            return true;

            }




    }


    public boolean insertdatalogin( String aduname, String adpass )

    {


        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

      //  contentvalues.put(ADMINID, adminid);
        contentvalues.put(ADUNAME, aduname);
        contentvalues.put(ADPASS, adpass);


        long resultlogin = mydb.insert(TABLE_NAMELOGIN, null, contentvalues);

        if (resultlogin == -1) {
            return false;

        } else

        {

            return true;

        }





  }

public boolean unamepasswordCheck(String ADUNAME,String ADPASS){


        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Login_table where username=? and adpass=?",new String[]{ADUNAME,ADPASS});

        if(cursor.getCount()>0)
        {

            return true;
        }
        else
            return false;

}

//    public boolean checkpassword(String ADPASS){
//
//
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery("select * from Login_table where adpass=?",new String[] {ADPASS});
//        if(cursor.getCount()>0){
//
//            return true;
//        }
//        else return false;
//
//    }





    public Cursor getAlldata(){

        SQLiteDatabase mydb=this.getWritableDatabase();

        String query="select*from "+ TABLE_NAME;
        Cursor res=mydb.rawQuery(query,null);
        return res;
    }


    public boolean updateData(String id,String name,String sclass,String science,String maths,String english,String history,String lit,String comm,String ict,String religion,String sinhala){
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(COL1, id);
        contentvalues.put(COL2, name);
        contentvalues.put(COL3, sclass);

        contentvalues.put(COL4, science);
        contentvalues.put(COL5, maths);
        contentvalues.put(COL6, english);
        contentvalues.put(COL7, history);
        contentvalues.put(COL8, lit);
        contentvalues.put(COL9, comm);
        contentvalues.put(COL10, ict);
        contentvalues.put(COL11, religion);
        contentvalues.put(COL12, sinhala);

        mydb.update(TABLE_NAME,contentvalues, "stuid = ?",new String[] {id});

        return true;
    }

    public Integer deletedata(String id)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        return  mydb.delete(TABLE_NAME,"stuid=?",new String[]{id});

    }







}