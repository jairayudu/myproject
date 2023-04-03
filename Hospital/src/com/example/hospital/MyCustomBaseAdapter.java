package com.example.hospital;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class MyCustomBaseAdapter extends BaseAdapter {
    private static ArrayList<String[]> searchArrayList;
    private LayoutInflater mInflater;
    public MyCustomBaseAdapter(Context context, ArrayList<String[]> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }
    public int getCount() {
        return searchArrayList.size();
    }
    public Object getItem(int position) {
        return searchArrayList.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.textView5);
          
            holder.txtPhone = (TextView) convertView.findViewById(R.id.textView3);
            holder.txtPhone1 = (TextView) convertView.findViewById(R.id.textView2);
            holder.txtPhone2 = (TextView) convertView.findViewById(R.id.textView4);
           holder.txtPhone3 = (TextView) convertView.findViewById(R.id.textView1);
          holder.txtPhone4 = (TextView) convertView.findViewById(R.id.textView6);
           
            
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String []s=searchArrayList.get(position);
        holder.txtName.setText(s[5]);
        holder.txtPhone.setText(s[4]); 
        holder.txtPhone1.setText(s[3]); 
       holder.txtPhone2.setText(s[2]); 
       holder.txtPhone3.setText(s[0]);
      holder.txtPhone4.setText(s[1]);
      

        return convertView;
    }
    static class ViewHolder {
        TextView txtName;

        TextView txtPhone;
        TextView txtPhone1;
        TextView txtPhone2;
        TextView txtPhone3;
        TextView txtPhone4;
    }
}
