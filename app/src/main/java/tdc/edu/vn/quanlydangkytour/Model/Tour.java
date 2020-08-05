package tdc.edu.vn.quanlydangkytour.Model;

public class Tour {
    String date, number;
    String khachHang, tour;

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "date=" + date +
                ", number=" + number +
                ", khachHang='" + khachHang + '\'' +
                ", tour='" + tour + '\'' +
                '}';
    }
}
