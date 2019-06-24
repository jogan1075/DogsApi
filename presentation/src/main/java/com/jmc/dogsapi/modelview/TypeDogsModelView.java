package com.jmc.dogsapi.modelview;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TypeDogsModelView implements Parcelable {

    public List<String> message;



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.message);

    }

    public TypeDogsModelView() {
    }

    protected TypeDogsModelView(Parcel in) {
        this.message = in.createStringArrayList();

    }

    public static final Creator<TypeDogsModelView> CREATOR = new Creator<TypeDogsModelView>() {
        @Override
        public TypeDogsModelView createFromParcel(Parcel source) {
            return new TypeDogsModelView(source);
        }

        @Override
        public TypeDogsModelView[] newArray(int size) {
            return new TypeDogsModelView[size];
        }
    };
}
