package com.example.knot.easywallet.Model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class UserModel {
    public final String detail;
    public final String picture;

    public UserModel(String detail,String picture) {
        this.detail = detail;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return detail;
    }

    public Drawable getPictureDrawable(Context context){
        AssetManager lc = context.getAssets();

        try {
            InputStream inputStream = lc.open(picture);
            Drawable drawable = Drawable.createFromStream(inputStream, "");
            return drawable;
        } catch (IOException e){
            Log.e("input","Error Openning File : " + picture);
            e.printStackTrace();
            return null;
        }
    }
    }

