package tdc.edu.vn.quanlydangkytour.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.quanlydangkytour.Model.Tour;

public class DBTour {
    DBHelper dbHelper;

    public DBTour(Context context)
    {
        dbHelper = new DBHelper((Context) context);
    }

    public void Them(Tour tour)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", tour.getDate());
        values.put("number", tour.getNumber());
        values.put("khachHang", tour.getKhachHang());
        values.put("tour", tour.getTour());
        db.insert("QLTour",null, values);
    }

    public ArrayList<Tour> LayDL()
    {
        ArrayList<Tour> data = new ArrayList<>();
        String sql = "select * from QLTour";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        do {
            Tour tour = new Tour();
            tour.setDate(cursor.getString(0));
            tour.setNumber(cursor.getString(1));
            tour.setKhachHang(cursor.getString(2));
            tour.setTour(cursor.getString(3));
            data.add(tour);
        }
        while (cursor.moveToNext());
        return  data;
    }
}
