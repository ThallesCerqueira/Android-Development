package devandroid.thalles.mvvm

class PersonRepository {

    fun login( email: String, password: String ): Boolean {
       return  (email != "" && password != "")
    }
}