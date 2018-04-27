package sercruz.teste_2018;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import pub.devrel.easypermissions.EasyPermissions;

public class CreateEventActivity extends AppCompatActivity {

    Button button;
    private static int RESULT_LOAD_IMAGE = 1;
    private static final String TAB = "Create Event";
    private String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        button = (Button) findViewById(R.id.btnLoadImage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });



    }


    protected void onActivityResult(int requestCode, int result, Intent data){
        super.onActivityResult(requestCode,result,data);
        if(requestCode == RESULT_LOAD_IMAGE && result == RESULT_OK && null!=data)
        {
            Uri selectImg = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Log.d(TAB,"MERDA: "+filePathColumn[0]);
            Cursor cursor = getContentResolver().query(selectImg,filePathColumn,null,null,null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            //get imageView

            ImageView imageView = (ImageView) findViewById(R.id.imageView);

            if (EasyPermissions.hasPermissions(this, galleryPermissions)) {
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            } else {
                EasyPermissions.requestPermissions(this, "Access for storage",
                        101, galleryPermissions);
            }




        }
        else{

            Toast.makeText(this,"You haven´t pick Image",Toast.LENGTH_LONG).show();
        }



    }
}
