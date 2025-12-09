package es.fpsumma.dam2.utilidades.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import es.fpsumma.dam2.utilidades.model.Asignaturas
import es.fpsumma.dam2.utilidades.model.Tarea
import kotlinx.coroutines.flow.Flow

@Dao
interface AsignaturaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAsignatura (asignaturas: Asignaturas)


    @Update
    suspend fun update(asignaturas: Asignaturas)

    @Delete
    suspend fun deleteAsignatura(asignaturas: Asignaturas)


    @Query("SELECT * from asignaturas WHERE id = :id")
    fun getAsignatura(id: Int): Flow<Asignaturas>


    @Query("SELECT * from asignaturas ORDER BY nombre ASC")
    fun getAllAsignatura(): Flow<List<Asignaturas>>



    @Query("DELETE FROM asignaturas")
    suspend fun deleteAll()

    @Query("DELETE FROM asignaturas WHERE id = :id")
    suspend fun deleteById(id: Int)




}