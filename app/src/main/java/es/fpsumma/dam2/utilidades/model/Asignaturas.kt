package es.fpsumma.dam2.utilidades.model

import android.R
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Asignaturas")
data class Asignaturas(

    @PrimaryKey(autoGenerate = true)
    val id: Int =0,

    @ColumnInfo(name="nombre")
    val nombre:String,

    @ColumnInfo(name="descripcion")
    val descripcion:String,












)
