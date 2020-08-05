package tdc.edu.vn.quanlydangkytour.Giaodien;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.vn.quanlydangkytour.Adapter.CustomAdapter;
import tdc.edu.vn.quanlydangkytour.R;
import tdc.edu.vn.quanlydangkytour.Model.Tour;

public class MainActivity extends AppCompatActivity {
    EditText etNgay, etSoNguoi;
    Spinner spTour, spKhachHang;
    Button btnThem, btnXoa, btnSua, btnClear;
    ListView lvDanhSach;

    ArrayList<String> data_Tour = new ArrayList<>();
    ArrayList<String> data_Khachhang= new ArrayList<>();

    ArrayList<Tour> thongtin = new ArrayList<>();

    ArrayAdapter adapter_Tour;
    ArrayAdapter adapter_KhachHang;

    CustomAdapter adapter_Tour_KhachHanh;

    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        adapter_Tour = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,data_Tour);
        spTour.setAdapter(adapter_Tour);

        adapter_KhachHang = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,data_Khachhang);
        spKhachHang.setAdapter(adapter_KhachHang);

        adapter_Tour_KhachHanh= new CustomAdapter(this,R.layout.listview_danhsach,thongtin);
        lvDanhSach.setAdapter(adapter_Tour_KhachHanh);

        spKhachHang.setAdapter(adapter_KhachHang);

        //Xac dinh vi tri
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tour tour = thongtin.get(position);
                etNgay.setText(tour.getDate());
                etSoNguoi.setText(tour.getNumber());

                spTour.setSelection(data_Tour.indexOf(tour.getTour()));
                spKhachHang.setSelection(data_Khachhang.indexOf(tour.getKhachHang()));

                index = position;
            }
        });

        //Them
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tour tour = new Tour();
                tour.setDate(etNgay.getText().toString());
                tour.setNumber(etSoNguoi.getText().toString());
                tour.setTour(spTour.getSelectedItem().toString());
                tour.setKhachHang(spKhachHang.getSelectedItem().toString());

                thongtin.add(tour);
                adapter_Tour_KhachHanh.notifyDataSetChanged();

            }

            private Tour getTour() {
                Tour tour = new Tour();
                tour.setDate(etNgay.getText().toString());
                tour.setNumber(etSoNguoi.getText().toString());
                tour.setKhachHang(spKhachHang.getSelectedItem().toString());
                tour.setTour(spTour.getSelectedItem().toString());
                return  tour;
            }
        });



        //Xoa:
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thongtin.remove(index);
                adapter_Tour_KhachHanh.notifyDataSetChanged();
            }
        });

        //Sua
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tour tour = thongtin.get(index);
                tour.setDate(etNgay.getText().toString());
                tour.setNumber(etSoNguoi.getText().toString());
                tour.setTour(spTour.getSelectedItem().toString());
                tour.setKhachHang(spKhachHang.getSelectedItem().toString());
                adapter_Tour_KhachHanh.notifyDataSetChanged();
            }
        });
        //Clear:
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNgay.setText("");
                etSoNguoi.setText("");
                spTour.setSelection(0);
                spKhachHang.setSelection(0);
            }
        });
    }

    private void KhoiTao() {
        data_Tour.add("Trong nước");
        data_Tour.add("Nước ngoài");
        data_Tour.add("Theo tuần");

        data_Khachhang.add("Than thiet");
        data_Khachhang.add("Vip");
        data_Khachhang.add("Binh thuong");
    }

    private void setControl() {
        etNgay = findViewById(R.id.editTextDate);
        etSoNguoi = findViewById(R.id.editTextNumber);

        spTour = findViewById(R.id.dmTour);
        spKhachHang = findViewById(R.id.spKhachHang);

        btnThem = findViewById(R.id.buttonThem);
        btnXoa = findViewById(R.id.buttonXoa);
        btnSua = findViewById(R.id.buttonSua);
        btnClear = findViewById(R.id.buttonClear);

        lvDanhSach = findViewById(R.id.lvDanhSach);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.thoat:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thong bao!!!");
                builder.setMessage("Ban co muon thoat ?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                break;

            case R.id.luu:
                Toast.makeText(getApplicationContext(),"Da luu", Toast.LENGTH_LONG).show();
            case R.id.doc:
                Log.d("test", "Open");
                Intent intent = new Intent(MainActivity.this, DanhSachTour.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
