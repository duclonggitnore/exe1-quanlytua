package tdc.edu.vn.quanlydangkytour.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "QLTour", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Tour (date text, number text, khachHang text, tour text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
