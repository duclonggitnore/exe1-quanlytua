package tdc.edu.vn.quanlydangkytour.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tdc.edu.vn.quanlydangkytour.R;
import tdc.edu.vn.quanlydangkytour.Model.Tour;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Tour> data;
    public CustomAdapter(Context context, int resource, ArrayList<Tour> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resource,null);

        //Anh xa:
        ImageView imgTour = view.findViewById(R.id.imageViewShow);

        TextView tvDate = view.findViewById(R.id.tvDate);
        TextView tvNumber = view.findViewById(R.id.tvSoNguoi);
        TextView tvTour = view.findViewById(R.id.tvTour);
        TextView tvKhachHang = view.findViewById(R.id.tvKhachHang);

        Tour tour = data.get(position);


        if(tour.getTour().equals("Trong nước"))
        {
            imgTour.setImageResource(R.drawable.ic_airplanemode_active_black_24dp);
        }
        if(tour.getTour().equals("Nước ngoài"))
        {
            imgTour.setImageResource(R.drawable.ic_airplanemode_inactive_black_24dp);
        }
        if(tour.getTour().equals("Theo tuần"))
        {
            imgTour.setImageResource(R.drawable.ic_directions_car_black_24dp);
        }


        tvDate.setText(tour.getDate());
        tvNumber.setText(tour.getNumber());
        tvTour.setText(tour.getTour());
        tvKhachHang.setText(tour.getKhachHang());
        return view;
    }
}
