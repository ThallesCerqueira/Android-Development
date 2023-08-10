package devandroid.thalles.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var txtWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private var personRepository = PersonRepository()

    fun welcome(): LiveData<String> {
        return txtWelcome
    }

    init {
        txtWelcome.value = "Olá"
    }


    fun login(): LiveData<Boolean> {
        return login
    }

    fun doLogin(email: String, password: String) {

       login.value =  personRepository.login(email, password)

    }

}