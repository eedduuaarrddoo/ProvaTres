package prova.example.segundaprova.banco

import androidx.lifecycle.LiveData
import androidx.room.*
import prova.example.segundaprova.model.Igreja

@Dao
interface IgrejaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)

    suspend fun cadastraIgreja(igreja: Igreja)

    @Update
    suspend fun updateIgreja(igreja: Igreja)




@Query("SELECT* FROM tabela_igrja ORDER BY id ASC")
    fun readAllData(): LiveData<List<Igreja>>
}