package bset.hyun.wirebarley

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val receivingCountry = MutableLiveData<String>()
    val exchangeRate = MutableLiveData<String>()
    val checkTime = MutableLiveData<String>()
    val receivedAmount = MutableLiveData<String>()
}