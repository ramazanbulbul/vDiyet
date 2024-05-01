package me.ramazanbulbul.diet.ui.bmi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BMIViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BMIViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("BMI");
    }

    public LiveData<String> getText() {
        return mText;
    }
}