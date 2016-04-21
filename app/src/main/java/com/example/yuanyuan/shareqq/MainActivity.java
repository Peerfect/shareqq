package com.example.yuanyuan.shareqq;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.tencent.tauth.Tencent;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private Tencent tencent;
    private static final String APP_ID = "222222";
    private Button share;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context myContext = this.getApplicationContext();
        tencent = Tencent.createInstance(APP_ID, myContext);
        handler = new Handler();
        Resources res = getResources();
        bitmap = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickShareToQQ();
            }
        });
    }

    private void onClickShareToQQ() {
        System.out.println("===============================" + BitmapToString(bitmap));
        ImageView imageView = (ImageView) findViewById(R.id.imageview);
        String s = "wewearfadsferjoifsodjfioasosnnehjnkjcnzxcifoinjnviozkndvjdkdnioklvnioankjnjjnaioen" +
                "weadfaewaeraewrfefvsdfwegtrht5676kt3432waefgdfbcv,;,p[eropeprk49";
        imageView.setImageBitmap(StringToBitmap(s));
    }

    //将bitmap对象转换成字符串
    public String BitmapToString(Bitmap bmp) {
        String string = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] bytes = bos.toByteArray();
        string = Base64.encodeToString(bytes, Base64.DEFAULT);
        return string;
    }

    //将字符串转换为图片bitmap对象
    public Bitmap StringToBitmap(String str) {
        Bitmap bitmap1 = null;
        byte[] bitMapArray;
        bitMapArray = Base64.decode(str, Base64.DEFAULT);
        bitmap1 = BitmapFactory.decodeByteArray(bitMapArray, 0, bitMapArray.length);
        return bitmap1;
    }
}
