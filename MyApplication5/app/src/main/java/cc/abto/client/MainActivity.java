package cc.abto.client;

import androidx.appcompat.app.AppCompatActivity;
import cc.abto.demo.IMyAidlInterface;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private IMyAidlInterface iMyAidlInterface;
    private static final String TAG = "MainActivity";
    ServiceConnection conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setAction("cc.abto.demo");
        intent.setPackage("cc.abto.demo");


        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
                try {
                    Log.d(TAG,"iMyAidlInterface.getName() =  " + iMyAidlInterface.getName());
                    Log.d(TAG,"iMyAidlInterface.getUserName() = " + iMyAidlInterface.getUserName().getName());
                } catch (RemoteException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        bindService(intent/*new Intent("cc.abto.server")*/, conn,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        unbindService(conn);
        super.onStop();
    }

}
