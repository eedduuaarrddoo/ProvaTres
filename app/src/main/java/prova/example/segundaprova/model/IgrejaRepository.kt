package prova.example.segundaprova.model

import androidx.lifecycle.LiveData
import prova.example.segundaprova.banco.IgrejaDao

class IgrejaRepository(private val igrejaDao: IgrejaDao) {

    val readAllData: LiveData<List<Igreja>> = igrejaDao.readAllData()
suspend fun cadastraIgreja(igreja: Igreja){
    igrejaDao.cadastraIgreja(igreja)
}
    suspend fun updateIgreja(igreja: Igreja){
        igrejaDao.updateIgreja(igreja)
    }

}