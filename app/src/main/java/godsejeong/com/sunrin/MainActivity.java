package godsejeong.com.sunrin;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button)findViewById(R.id.bt);
        tv = (TextView)findViewById(R.id.time_tx);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt:
                int i=15;
                while(i>0){
                    i=-1;
                    tv.setText("휴대폰 정 지 !");
                    SystemClock.sleep(10000);
                }
      //          Intent intent = new Intent(
    //                    getApplicationContext(),//현재제어권자
  //                      MainService.class); // 이동할 컴포넌트
//                startService(intent); // 서비스 시작
                break;
        }
    }
}
