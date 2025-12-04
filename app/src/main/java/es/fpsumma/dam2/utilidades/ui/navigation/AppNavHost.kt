package es.fpsumma.dam2.utilidades.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.fpsumma.dam2.utilidades.ui.screensTarea.home.HomeScreen
import es.fpsumma.dam2.utilidades.ui.screensTarea.tareas.ListadoTareasScreen
import es.fpsumma.dam2.utilidades.ui.viewmodel.TareasViewModel

@Composable
fun AppNavHost(navController: NavHostController, tareasViewModel: TareasViewModel) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) { HomeScreen(navController)}
        composable(Routes.LISTADO_TAREAS) { ListadoTareasScreen(navController,tareasViewModel) }

    }
}