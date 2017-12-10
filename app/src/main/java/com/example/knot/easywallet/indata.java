package com.example.knot.easywallet;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.knot.easywallet.DB.DBhelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class indata extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = indata.class.getName();

    private EditText mDetailIncome, mIncomeMoney;
    private ImageView mIncomeView;
    private Button mIncomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income);

        mDetailIncome = findViewById(R.id.Detail_Income);
        mIncomeMoney = findViewById(R.id.Money_Income);
        mIncomeView = findViewById(R.id.Income_View);
        mIncomeButton = findViewById(R.id.Save_Income);

        mIncomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(indata.this,DBhelper.class);
                startActivity(intent);
            }
        });
    }

    private void saveDataToDb() {
        String IncomeVie = mIncomeView.getText().toString();
        String phoneNumber = mPhoneNumberEditText.getText().toString();
        String pictureFileName = mSelectedPictureFile.getName();

        ContentValues cv = new ContentValues();
        cv.put(PhoneDbHelper.COL_TITLE, phoneTitle);
        cv.put(PhoneDbHelper.COL_NUMBER, phoneNumber);
        cv.put(PhoneDbHelper.COL_PICTURE, pictureFileName);

        PhoneDbHelper dbHelper = new PhoneDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long result = db.insert(PhoneDbHelper.TABLE_NAME, null, cv);
        if (result == -1) {
            //
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
                Log.e(TAG, "Error choosing picture file: " + e.getMessage());
            }

            @Override
            public void onImagesPicked(List<File> imagesFiles, EasyImage.ImageSource source, int type) {
                //Handle the images
                mSelectedPictureFile = imagesFiles.get(0);
                Drawable drawable = Drawable.createFromPath(mSelectedPictureFile.getAbsolutePath());
                mPhoneImageView.setImageDrawable(drawable);

                Log.i(TAG, mSelectedPictureFile.getAbsolutePath());
            }
        });
    }


}

