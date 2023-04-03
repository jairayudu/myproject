package com.example.hospital;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class MyCustomBaseAdapter1 extends BaseAdapter {
    private static ArrayList<String[]> searchArrayList;
    private LayoutInflater mInflater;
    public MyCustomBaseAdapter1(Context context, ArrayList<String[]> results) {
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
            convertView = mInflater.inflate(R.layout.list1, null);
            holder = new ViewHolder();
            holder.item = (TextView) convertView.findViewById(R.id.notes);
          
            holder.amount = (TextView) convertView.findViewById(R.id.amount);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.catagory = (TextView) convertView.findViewById(R.id.catagory);
           holder.due = (TextView) convertView.findViewById(R.id.due);
          holder.status = (TextView) convertView.findViewById(R.id.status);
           
            
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String []s=searchArrayList.get(position);
        holder.item.setText(s[0]);
        holder.amount.setText(s[1]); 
        holder.type.setText(s[2]); 
       holder.catagory.setText(s[3]); 
       holder.due.setText(s[4]);
      holder.status.setText(s[5]);
      

        return convertView;
    }
    static class ViewHolder {
        TextView item;

        TextView amount;
        TextView type;
        TextView catagory;
        TextView due;
        TextView status;
    }
}
