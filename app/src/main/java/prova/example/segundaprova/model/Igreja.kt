package prova.example.segundaprova.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tabela_igrja")
data class Igreja(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nome:String,
    val endereco:String,
    val profeta:String,
    val descricao:String,
    val fieis:Int
):Parcelable {
}