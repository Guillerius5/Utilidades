package es.fpsumma.dam2.utilidades.ui.screensAsignatura

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.fpsumma.dam2.utilidades.ui.viewmodel.AsignaturasViewModel

@Composable
fun ListadoAsignaturasScreen(navController: NavController, vm: AsignaturasViewModel,modifier: Modifier ) {

val listaAsignaturas by vm.asignaturas.collectAsState()

    LazyColumn(modifier= modifier){

        item {
            Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                FormularioCrearAsignatura(vm = vm)
            }
        }

        item{
            Text(
               "Listado de Asignaturas (${listaAsignaturas.size})" ,
                modifier= Modifier.padding(16.dp)
            )
            Divider()
        }




    }


        }
//fun FormularioCrearAsignatura()






