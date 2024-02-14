package com.example.diettracker;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class NamesProvider1 extends ContentProvider {


    public final static String DBNAME = "NameDatabase";
    protected static final class MainDatabaseHelper extends SQLiteOpenHelper{

        MainDatabaseHelper(Context context){
            super(context,DBNAME,null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

        }
    };

    public final static String TABLE_NAMESTABLE = "Names";
    public final static String COLUMN_FIRSTNAME = "firstname";
    public final static String COLUMN_LASTNAME = "lastname";

    public static final String AUTHORITY = "com.mobile.provider1";
    public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/"+TABLE_NAMESTABLE);

    private MainDatabaseHelper mOpenHelper;

    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            TABLE_NAMESTABLE +
            "(" +
            "_ID INTEGER PRIMARY KEY," +
            COLUMN_FIRSTNAME + " TEXT," +
            COLUMN_LASTNAME + " TEXT)";




    public NamesProvider1() {
    }




    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mOpenHelper.getWritableDatabase().delete(TABLE_NAMESTABLE,selection,selectionArgs);

    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        //throw new UnsupportedOperationException("Not yet implemented");
        String fname = values.getAsString(COLUMN_FIRSTNAME).trim();
        String lname = values.getAsString(COLUMN_LASTNAME).trim();
        if(lname.equals("")){
            return null;
        }

        if(fname.equals("")){
            return null;
        }

        long id = mOpenHelper.getWritableDatabase().insert(TABLE_NAMESTABLE,null,values);

        return Uri.withAppendedPath(CONTENT_URI, String.valueOf(id));
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        mOpenHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mOpenHelper.getReadableDatabase().query(TABLE_NAMESTABLE,projection,selection,selectionArgs,null,null,sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}