package com.example.projecttoday;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    Button remove;
    CustomListView adapter;

    ArrayList<Item> listPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComps();

    }


    public void handleAdd(View view){
        Intent i = new Intent(MainActivity.this, ThemMoiNhanVien.class);

        startActivityForResult(i, 100);
    }



    public void handleRemove(View view){
        if(listPerson.isEmpty()){
            Toast.makeText(this, "Error because no item at all", Toast.LENGTH_SHORT).show();
        }
        else {
            Iterator<Item> is = listPerson.iterator();
            if(is.hasNext()){
                Item firstItem = is.next();
                if(firstItem.getStatus()) is.remove();
            }
            while(is.hasNext()){
                Item a = is.next();
                if(a.getStatus()) is.remove();
            }
            adapter.notifyDataSetChanged();

        }
    }
    public void initComps(){
        lst = findViewById(R.id.ListView);
        remove = findViewById(R.id.Remove);
        listPerson = new ArrayList<Item>();

        listPerson.add(new Item(1, "Mot", "123", false));
        listPerson.add(new Item(2, "Hai", "456", false));
        listPerson.add(new Item(3, "Ba", "789", false));

        adapter= new CustomListView(this,listPerson);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  Item a = adapter.getItem(i);
                  a.setStatus(!a.getStatus());
                  CheckBox checked = view.findViewById(R.id.checkStatus);
                  checked.setChecked(a.getStatus());
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int id = data.getIntExtra("id", 0);
        String fullName = data.getStringExtra("name");
        String phone = data.getStringExtra("phone");
        String imgPath= data.getStringExtra("images");
        //Uri imguri = data.getParcelableExtra("images");
            if (imgPath != null) {
                Uri imageUri = Uri.parse(imgPath);
                // Now you have the URI, you can do whatever you want with it
            }
        Item item = new Item(id, fullName, phone, false, imgPath);
        if(requestCode == 100 && resultCode == RESULT_OK){
            listPerson.add(item);
            adapter.notifyDataSetChanged();
        }
        else if(resultCode == RESULT_CANCELED){
            Log.v("Error", "SomeThing error");
        }
    }


}