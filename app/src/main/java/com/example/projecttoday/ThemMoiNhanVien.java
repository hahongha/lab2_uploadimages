package com.example.projecttoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ThemMoiNhanVien extends AppCompatActivity {

    EditText editName, phone, id;
    ImageView img;
    TextView person, phones;

    Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_moi_nhan_vien);

        editName = findViewById(R.id.EditName);
        phone = findViewById(R.id.phoneNumber);
        id = findViewById(R.id.EditId);
        img = findViewById(R.id.imgavt);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1000);
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("@drawable/*");
//                startActivityForResult(intent, 1000);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            selectedImage = data.getData();
            img.setImageURI(selectedImage);

        }
    }
    public void AddPeople(View view){
        String name = editName.getText().toString();
        String phones = phone.getText().toString();
        int idperson = Integer.parseInt(id.getText().toString());

        Intent i = new Intent(ThemMoiNhanVien.this, MainActivity.class);
        i.putExtra("name", name);
        i.putExtra("phone", phones);
        i.putExtra("id", idperson);
        i.putExtra("images", selectedImage.toString());
        setResult(RESULT_OK, i);
        finish();
    }


    public void backToMain(View view){
        finish();
    }

}