package me.ramazanbulbul.diet.ui.sp;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SPViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SPViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Sport Program");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
