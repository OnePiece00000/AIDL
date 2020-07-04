package cc.abto.demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cc.abto.demo.IMyAidlInterface;



public class MyService extends Service {
    public MyService()
    {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends IMyAidlInterface.Stub{

        @Override
        public String getName() throws RemoteException {
            return "hejiangzhou";
        }
        @Override
        public User getUserName() throws RemoteException {
            return new User("hejiangzhou hejiangzhou");
        }

    }
}
