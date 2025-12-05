package es.fpsumma.dam2.utilidades.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import es.fpsumma.dam2.utilidades.data.local.AppDatabase
import es.fpsumma.dam2.utilidades.model.Asignaturas
import es.fpsumma.dam2.utilidades.model.Tarea
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AsignaturasViewModel(app: Application): AndroidViewModel(app) {

    private val db= Room.databaseBuilder(
        app, AppDatabase::class.java, "asignaturas.db"
    ).fallbackToDestructiveMigration(false).build()

    private val dao = db.AsignaturaDao()

    //listar tareas
    val tareas: StateFlow<List<Asignaturas>> =
        dao.getAllAsignatura().stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            emptyList()
        )

   //crear tarea

    fun addAsignaturas(nombre: String, descripcion: String) = viewModelScope.launch {
        dao.insertAsignatura(Asignaturas(nombre = nombre, descripcion = descripcion))

    }


    fun deleteAsignaturas(asignaturas: Asignaturas)= viewModelScope.launch{
        dao.deleteAsignatura(asignaturas)
    }

    }









