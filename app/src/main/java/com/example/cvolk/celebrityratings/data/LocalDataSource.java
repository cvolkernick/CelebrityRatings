package com.example.cvolk.celebrityratings.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cvolk.celebrityratings.model.Celebrity;

import java.util.ArrayList;
import java.util.List;

public class LocalDataSource extends SQLiteOpenHelper {

    public LocalDataSource(Context context) {
        super(context, LocalDataContract.NAME, null,LocalDataContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(LocalDataContract.CREATE_CELEBRITY_TABLE); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int deleteCelebrity(Celebrity celebrity) {
        SQLiteDatabase database = getWritableDatabase();

        return database.delete(LocalDataContract.Celebrity.TABLE,
                LocalDataContract.Celebrity.FIRST_NAME + "=" + celebrity.getFirstName() + " AND " +
                        LocalDataContract.Celebrity.LAST_NAME + "=" + celebrity.getLastName() + " AND " +  LocalDataContract.Celebrity.GENDER + "=" +
                        celebrity.getGender() + " AND " + LocalDataContract.Celebrity.AGE + "=" + celebrity.getAge(),
                null
        );
    }

    public long saveCelebrity(Celebrity celebrity) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(LocalDataContract.Celebrity.FIRST_NAME, celebrity.getFirstName());
        contentValues.put(LocalDataContract.Celebrity.LAST_NAME, celebrity.getLastName());
        contentValues.put(LocalDataContract.Celebrity.GENDER, celebrity.getGender());
        contentValues.put(LocalDataContract.Celebrity.AGE, celebrity.getAge());
        contentValues.put(LocalDataContract.Celebrity.FAVORITE, celebrity.isFavorite());

        long rowNumber = database.insert(LocalDataContract.Celebrity.TABLE, null,contentValues);

        database.close();

        return rowNumber;
    }

    public List<Celebrity> getAllCelebrity() {
        SQLiteDatabase database = getWritableDatabase();

        List<Celebrity> celebrityList = new ArrayList<>();

        Cursor cursor = database.rawQuery(LocalDataContract.Celebrity.GET_ALL, null);

        if (cursor.moveToFirst()) {
            do {
                Celebrity celebrity = new Celebrity(cursor.getString(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getInt(3), Boolean.parseBoolean(cursor.getString(4)));

                celebrityList.add(celebrity);
            }
            while (cursor.moveToNext());
        }

        database.close();

        return celebrityList;
    }
}
