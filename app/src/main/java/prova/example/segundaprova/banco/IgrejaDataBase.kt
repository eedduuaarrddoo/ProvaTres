package prova.example.segundaprova.banco

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import prova.example.segundaprova.model.Igreja

@Database(entities = [Igreja::class],version=1, exportSchema = false)
abstract class IgrejaDataBase:RoomDatabase() {
    abstract fun userDao(): IgrejaDao

    companion object {
        @Volatile
        private var INSTANCE: IgrejaDataBase? = null
        fun getDatabase(context: Context): IgrejaDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    IgrejaDataBase::class.java,
                    "igreja_database"
                ).build()
                INSTANCE=instance
                return instance
            }


        }
    }
}