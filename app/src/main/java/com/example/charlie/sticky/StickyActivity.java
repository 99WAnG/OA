package com.example.charlie.sticky;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.example.charlie.sticky.DataBase.Cuns;
import com.example.charlie.sticky.DataBase.MyAdapter;
import com.example.charlie.sticky.DataBase.MyDataBase;

import java.util.ArrayList;

public class StickyActivity extends AppCompatActivity {

    ImageButton imageButton;
    ListView lv;
    LayoutInflater inflater;
    ArrayList<Cuns> array;
    MyDataBase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky);
        lv=(ListView) findViewById(R.id.lv_bwlList);
        imageButton=(ImageButton) findViewById(R.id.btnAdd);
        inflater=getLayoutInflater();

        mdb=new MyDataBase(this);
        array=mdb.getArray();
        MyAdapter adapter=new MyAdapter(inflater,array);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(getApplicationContext(),EditActivity.class);
                intent.putExtra("ids",array.get(position).getIds() );
                startActivity(intent);
                StickyActivity.this.finish();
            }
        });


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           final int position, long id) {

                new AlertDialog.Builder(StickyActivity.this)
                        .setTitle("刪除")
                        .setMessage("是否删除笔记")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mdb.toDelete(array.get(position).getIds());
                                array=mdb.getArray();
                                MyAdapter adapter=new MyAdapter(inflater,array);
                                lv.setAdapter(adapter);
                            }
                        })
                        .create().show();
                return true;
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EditActivity.class);
                startActivity(intent);
                StickyActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent=new Intent(getApplicationContext(),EditActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.item2:
                this.finish();
                break;
            default:
                break;
        }
        return true;
    }

}
