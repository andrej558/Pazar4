package com.example.pazar4.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.pazar4.Models.Oglas

public class ShopViewModel (application: Application) : AndroidViewModel(application){

    val oglasi : MutableLiveData<Oglas> = MutableLiveData()

}