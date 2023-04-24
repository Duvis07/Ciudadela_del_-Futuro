package sura.com.constructores.s.a.s.view

import sura.com.constructores.s.a.s.controller.AdministradorMateriales.recargaMateriales
import sura.com.constructores.s.a.s.models.{Ciudadela, OrdenConstruccion}

object MenuMateriales {

  //menuMateriales(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit: Esta función imprime un menú de opciones para
  // que el usuario elija qué hacer con los materiales en la Ciudadela. El menú incluye opciones para ver los materiales actuales y
  // recargar 500 unidades por cada material. La función lee la entrada del usuario y llama a la función controladorMateriales para procesar el comando ingresado.
  def menuMateriales(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit = {
    println("___ Menú de Materiales ___\n")
    println(" Digite => \n 1. Para ver materiales \n 2. Para recargar 500 por cada material \n _. Cualquier otro digito para regresar")
    val comando = scala.io.StdIn.readLine()
    controladorMateriales(comando, ordenConstruccion, ciudadela)
  }


  //controladorMateriales(comando: String, ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Any:
  // Esta función procesa el comando ingresado por el usuario en el menú de materiales. Si el usuario elige
  // la opción "1", se llama a la función Imprimir.imprimirMateriales para imprimir los materiales actuales. Si el usuario elige
  // la opción "2", se llama a la función recargaMateriales para recargar los materiales y se llama a la función Imprimir.imprimirRecargaExitosa para
  // imprimir un mensaje de confirmación. Si el usuario ingresa cualquier otro comando, se llama a la función MenuPrincipal.menuPrincipal
  // para volver al menú principal de la aplicación.
  def controladorMateriales(comando: String, ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Any = {
    comando match {
      case "1" => Imprimir.imprimirMateriales(ordenConstruccion, ciudadela)
      case "2" => val materialesAct = recargaMateriales(ciudadela.material)
        Imprimir.imprimirRecargaExitosa(ordenConstruccion, ciudadela.copy(material = materialesAct))
      case _ => MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
    }
  }
}
