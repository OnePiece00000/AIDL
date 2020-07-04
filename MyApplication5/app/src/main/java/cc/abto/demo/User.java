package cc.abto.demo;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String name;
    protected User(String name) {
        this.name = name;
    }


    public String getName(){
        return name;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in.readString());
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
