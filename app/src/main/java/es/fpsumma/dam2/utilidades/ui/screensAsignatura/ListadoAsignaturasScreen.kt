package es.fpsumma.dam2.utilidades.ui.screensAsignatura

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.fpsumma.dam2.utilidades.model.Asignaturas
import es.fpsumma.dam2.utilidades.model.Tarea
import es.fpsumma.dam2.utilidades.ui.viewmodel.AsignaturasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListadoAsignaturasScreen(
    navController: NavController,
    vm: AsignaturasViewModel,
    modifier: Modifier
) {

    val asignaturas by vm.asignaturas.collectAsState()

    var nombreAsignaturas by rememberSaveable { mutableStateOf("") }
    var descripcionAsignaturas by rememberSaveable { mutableStateOf("") }

    fun handleAddAsignatura() {
        vm.addAsignaturas(nombreAsignaturas, descripcionAsignaturas)
        nombreAsignaturas = ""
        descripcionAsignaturas = ""
    }

    fun handleDeleteAsignatura(asignaturas: Asignaturas) {
        vm.deleteAsignaturas(asignaturas)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Listado de asignaturas") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                value = nombreAsignaturas,
                onValueChange = { nombreAsignaturas = it },
                label = { Text("Título") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = descripcionAsignaturas,
                onValueChange = { descripcionAsignaturas = it },
                label = { Text("Descripción") },
                singleLine = false,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = ::handleAddAsignatura,
                modifier = Modifier.fillMaxWidth()
            ) { Text("Añadir nota") }
            HorizontalDivider(modifier.padding(vertical = 16.dp))

            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                items(
                    items = asignaturas,
                    key = { it.id }
                ) { asignaturas ->
                    Card(
                        modifier = modifier,
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        ListItem(
                            headlineContent = { Text(asignaturas.nombre) },
                            supportingContent = { Text(asignaturas.descripcion) },
                            trailingContent = {
                                IconButton(
                                    onClick = { handleDeleteAsignatura(asignaturas) },
                                    modifier = modifier.size(48.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Delete,
                                        contentDescription = "Borrar nota"
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}





