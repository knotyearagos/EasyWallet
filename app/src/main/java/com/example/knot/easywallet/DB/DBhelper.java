package com.example.knot.easywallet.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "income-expense";
    private static final int DATABASE_VERSION = 8;

    public static final String TABLE_NAME = "order";
    public static final String COL_ID = "_id";
    public static final String COL_DETAIL = "detail";
    public static final String COL_NUMBER = "number";
    public static final String COL_PICTURE = "picture";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_DETAIL + " TEXT, "
            + COL_NUMBER + " TEXT, "
            + COL_PICTURE + " TEXT)";

    public DBhelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_DETAIL, "คุณพ่อให้เงิน");
        cv.put(COL_NUMBER, "8000");
        cv.put(COL_PICTURE, "ic_income.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_DETAIL, "จ่ายค่าหอ");
        cv.put(COL_NUMBER, "2,500");
        cv.put(COL_PICTURE, "ic_expense.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_DETAIL, "ซื้อล็อคเตอรี่ ๅ ชุด");
        cv.put(COL_NUMBER, "ึ700");
        cv.put(COL_PICTURE, "ic_expense.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_DETAIL, "ถูกล็อตเตอรี่รางวัลที่ 1");
        cv.put(COL_NUMBER, "30000000");
        cv.put(COL_PICTURE, "ic_income.png");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
