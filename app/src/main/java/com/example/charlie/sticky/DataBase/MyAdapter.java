package com.example.charlie.sticky.DataBase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.charlie.sticky.R;

import java.util.ArrayList;

/**
 * Created by Charlie on 2019/1/10.
 */

/*
 * 自定义的ListView的Adapter
 */
public class MyAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<Cuns> array;

    public MyAdapter(LayoutInflater inf,ArrayList<Cuns> arry){
        this.inflater=inf;
        this.array=arry;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            convertView=inflater.inflate(R.layout.activity_list, null);//注意导包，别导系统包
            vh.tv1=(TextView) convertView.findViewById(R.id.textView1);
            vh.tv2=(TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(vh);
        }
        vh=(ViewHolder) convertView.getTag();
        vh.tv1.setText(array.get(position).getTitle());
        vh.tv2.setText(array.get(position).getTimes());
        return convertView;
    }
    class ViewHolder{
        TextView tv1,tv2;
    }
}
