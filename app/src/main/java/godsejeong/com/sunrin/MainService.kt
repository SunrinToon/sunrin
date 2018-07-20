package godsejeong.com.sunrin

import android.app.ActivityManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class MainService : Service(){

    var i =0

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        // 서비스에서 가장 먼저 호출됨(최초에 한번만)
        Log.d("test", "서비스의 onCreate")
        i = 15

    }
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        // 서비스가 호출될 때마다 실행
        Log.d("test", "서비스의 onStartCommand")

        while(i>0){
            i=-1
            SystemClock.sleep(1000)

            val activityManager = this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val info: List<ActivityManager.RunningTaskInfo>
            info = activityManager.getRunningTasks(1)
            val runningTaskInfo = info[0]
            val curActivityName = runningTaskInfo.topActivity.className

            if(curActivityName != "godsejeong.com.sunrin"){
                startActivity(Intent("androidpub.action.SHOW"))
            }

        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()

        // 서비스가 종료될 때 실행
        Log.d("test", "서비스의 onDestroy")

    }
}