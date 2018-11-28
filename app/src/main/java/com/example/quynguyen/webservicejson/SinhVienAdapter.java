package com.example.quynguyen.webservicejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> arrayList;
    private Context context;
    private int layout;

    public SinhVienAdapter(List<SinhVien> arrayList, Context context, int layout) {
        this.arrayList = arrayList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtName;
        TextView txtNamSinhLabel;
        TextView txtNamSinh;
        TextView txtHomeLabel;
        TextView txtHome;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtNamSinhLabel = convertView.findViewById(R.id.txtNamSinhLabel);
            holder.txtNamSinh = convertView.findViewById(R.id.txtNamSinh);
            holder.txtHomeLabel = convertView.findViewById(R.id.txtHomeLabel);
            holder.txtHome = convertView.findViewById(R.id.txtHome);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        SinhVien objSV = arrayList.get(position);
        holder.txtName.setText(objSV.getHoTen());
        holder.txtNamSinh.setText(objSV.getNamSinh());
        holder.txtHome.setText(objSV.getQueQuan());
        return convertView;
    }
}
