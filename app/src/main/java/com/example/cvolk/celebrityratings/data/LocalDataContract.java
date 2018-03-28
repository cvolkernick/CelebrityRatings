package com.example.cvolk.celebrityratings.data;

import android.provider.BaseColumns;

public class LocalDataContract {
    public static final String NAME = "Celebrity.db";
    public static final int VERSION = 1;

    public static final String CREATE_CELEBRITY_TABLE
            = "CREATE TABLE " + Celebrity.TABLE + "(" +
            Celebrity.FIRST_NAME + " TEXT, " +
            Celebrity.LAST_NAME + " TEXT, " +
            Celebrity.GENDER + " TEXT, " +
            Celebrity.AGE + " INTEGER, " +
            Celebrity.FAVORITE + " INTEGER)";

    public static class Celebrity implements BaseColumns {
        public static final String TABLE = "person";
        public static final String FIRST_NAME = "firstName";
        public static final String LAST_NAME = "lastName";
        public static final String GENDER = "gender";
        public static final String AGE = "age";
        public static final String FAVORITE = "favorite";
        public static final String GET_ALL = "SELECT * FROM " + Celebrity.TABLE;
    }
}
