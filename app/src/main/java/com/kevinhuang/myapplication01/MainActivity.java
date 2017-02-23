package com.kevinhuang.myapplication01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //  定义变量
    private Button btnAddOneSec;
    private Button btnLoseOneSec;
    private Button btnHelloJZX;

    private ImageView ivHelloJZX;
    private TextView tvLife;

    private int time = 0;
    private int[] images = {
            R.drawable.jzx01,
            R.drawable.jzx02,
            R.drawable.jzx03,
            R.drawable.jzx04,
            R.drawable.jzx05,
            R.drawable.jzx06,
    };
    private int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//  绑定控件
        btnAddOneSec = (Button) findViewById(R.id.btnAddOneSec);
        btnLoseOneSec = (Button) findViewById(R.id.btnLoseOneSec);
        tvLife = (TextView) findViewById(R.id.tvLife);
        btnHelloJZX = (Button) findViewById(R.id.btnHelloJZX);
        ivHelloJZX = (ImageView) findViewById(R.id.ivHelloJZX);

//  监听事件
        btnAddOneSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time++;
                tvLife.setText("蛤蛤，江主席的生命变成了：" + time + "秒");
            }
        });

        btnLoseOneSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time == 0) {
                    Toast.makeText(MainActivity.this, "生无可恋！", Toast.LENGTH_SHORT).show();
                } else {
                    time--;
                    tvLife.setText("蛤蛤，江主席的生命变成了：" + time + "秒");
                }
            }
        });
        btnHelloJZX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIndex++;
                if (imageIndex > images.length - 1) {
                    imageIndex = 0;
                }
                ivHelloJZX.setImageResource(images[imageIndex]);
            }
        });
//  信封
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "给江主席致信", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
