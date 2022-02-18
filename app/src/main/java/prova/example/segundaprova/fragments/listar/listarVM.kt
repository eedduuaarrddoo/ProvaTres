package prova.example.segundaprova.fragments.listar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import prova.example.segundaprova.api.Repository
import prova.example.segundaprova.model.Igreja
import prova.example.segundaprova.model.Post

class listarVM(private val repository: Repository):ViewModel() {

    val myResponse: MutableLiveData<List<Post>> = MutableLiveData()
   fun getPost(){
       viewModelScope.launch {
           val response: List<Post> = repository.getPost()
        myResponse.value=response
       }
    }
}