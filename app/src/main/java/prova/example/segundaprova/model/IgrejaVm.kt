package prova.example.segundaprova.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import prova.example.segundaprova.banco.IgrejaDataBase

class IgrejaVm (application: Application):AndroidViewModel(application){

 val readAllData:LiveData<List<Igreja>>
private val repository: IgrejaRepository
init {
    val igrejaDao= IgrejaDataBase.getDatabase(application).userDao()
    repository = IgrejaRepository(igrejaDao)
    readAllData=repository.readAllData
}
    fun cadastraIgreja(igreja: Igreja){
        viewModelScope.launch (Dispatchers.IO) {
            repository.cadastraIgreja(igreja)
        }

    }
fun updateIgreja(igreja: Igreja){
    viewModelScope.launch(Dispatchers.IO){
repository.updateIgreja(igreja)
    }
}

}