package com.baway.liuheng.myduo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DownLoadFile downLoadFile;
    private String loadUrl = "http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio";
    private String filePath = Environment.getExternalStorageDirectory()+"/"+"达奚阿碧.mp4";
    private ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvprogress = (TextView) findViewById(R.id.tv_progress);
        downLoadFile = new DownLoadFile(this,loadUrl, filePath, 3);
        pb = (ProgressBar) findViewById(R.id.pb);
        downLoadFile.setOnDownLoadListener(new DownLoadFile.DownLoadListener() {
            @Override
            public void getProgress(int progress) {
                tvprogress.setText("当前进度 ："+progress+" %");
                pb.setMax(100);
                pb.setProgress(progress);

            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this,"下载完成", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                Toast.makeText(MainActivity.this,"下载失败",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadFile.downLoad();
            }
        });
        findViewById(R.id.bt_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadFile.onPause();
            }
        });
        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadFile.onStart();
            }
        });
        findViewById(R.id.bt_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadFile.cancel();
            }
        });
    }
}
