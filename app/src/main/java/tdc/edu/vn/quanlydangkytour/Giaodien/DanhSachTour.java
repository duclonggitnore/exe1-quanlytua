package tdc.edu.vn.quanlydangkytour.Giaodien;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.vn.quanlydangkytour.Adapter.CustomAdapter;
import tdc.edu.vn.quanlydangkytour.Database.DBTour;
import tdc.edu.vn.quanlydangkytour.Model.Tour;
import tdc.edu.vn.quanlydangkytour.R;

public class DanhSachTour extends AppCompatActivity {
    ListView lvDanhSach;
    ArrayList<Tour> dataTour = new ArrayList<>();
    CustomAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_danhsach);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setEvent() {
        DBTour dbTour = new DBTour(this);
        dataTour =dbTour.LayDL();

        adapter = new CustomAdapter(this, R.layout.listview_danhsach,dataTour);
        lvDanhSach.setAdapter(adapter);
        registerForContextMenu(lvDanhSach);
    }

    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }

    private void CapNhatDL() {
        try
        {
            DBTour db = new DBTour(this);
            adapter = new CustomAdapter(this, R.layout.listview_danhsach,db.LayDL());
            lvDanhSach.setAdapter(adapter);
        }
        catch (Exception ex)
        {
            lvDanhSach.setVisibility(View.GONE);
            Toast.makeText(this,"Không có dữ liệu", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        onBackPressed();
        return  true;
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu,v, menuInfo);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu., menu);
//    }
}
