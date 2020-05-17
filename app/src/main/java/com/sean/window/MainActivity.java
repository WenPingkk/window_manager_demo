package com.sean.window;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * add a full screen page by windowmanager
 *
 * remember add manifest of windowmanager
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create a windowmanager
        WindowManager windowManager = MainActivity.this.getWindowManager();

        //set rootLayout 's layoutparams
        RelativeLayout rootLayout = new RelativeLayout(MainActivity.this);
        RelativeLayout.LayoutParams rootLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rootLayout.setLayoutParams(rootLayoutParams);
        //set button ‘s layputparams
        RelativeLayout.LayoutParams btnLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        btnLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        //create a button
        Button button = new Button(MainActivity.this);
        button.setText("toast");
        button.setPadding(10, 10, 10, 10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you clicked me", Toast.LENGTH_SHORT).show();
            }
        });
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(btnLayoutParams);
        rootLayout.addView(button);

        WindowManager.LayoutParams windowManagerLayoutParams = new WindowManager.LayoutParams();
        int screenWidth = windowManager.getDefaultDisplay().getWidth();
        int screenHeight = windowManager.getDefaultDisplay().getHeight();
        //windowManagerLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE; // crash：permission denied for window type 2002
        windowManagerLayoutParams.format = PixelFormat.RGBA_8888;
        windowManagerLayoutParams.gravity = Gravity.CENTER;
        windowManagerLayoutParams.width = screenWidth;
        windowManagerLayoutParams.height = screenHeight;
        windowManager.addView(rootLayout, windowManagerLayoutParams);
    }
}
