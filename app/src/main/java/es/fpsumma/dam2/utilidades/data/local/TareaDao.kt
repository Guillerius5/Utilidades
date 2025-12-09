package es.fpsumma.dam2.utilidades.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import es.fpsumma.dam2.utilidades.model.Tarea
import kotlinx.coroutines.flow.Flow

// @Dao indica que esta interfaz es un DAO de Room:
// aquí declaramos las operaciones típicas para la tabla "tareas".
@Dao
interface TareaDao {

//si hay conflicto no inserta
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tarea: Tarea)

    // Actualiza una tarea existente (mismo id). Cambia sus campos en la BD.
    @Update
    suspend fun update(tarea: Tarea)


    @Delete
    suspend fun delete(tarea: Tarea)


    @Query("SELECT * from tareas WHERE id = :id")
    fun getTarea(id: Int): Flow<Tarea>


    @Query("SELECT * from tareas ORDER BY titulo ASC")
    fun getAllTareas(): Flow<List<Tarea>>
}