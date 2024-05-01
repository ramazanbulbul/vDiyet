package me.ramazanbulbul.diet.ui.dp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DPViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DPViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Diet Program");
    }

    public LiveData<String> getText() {
        return mText;
    }
}