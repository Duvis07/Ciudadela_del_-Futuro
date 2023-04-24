package sura.com.constructores.s.a.s.view

import sura.com.constructores.s.a.s.models.{Ciudadela, OrdenConstruccion}
import sura.com.constructores.s.a.s.view.MenuConsultar.menuInforme

import scala.annotation.tailrec

object MenuPrincipal {
  @tailrec
  def menuPrincipal(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit = {
    println("___ Menú Principal ___\n")
    println("Digite:  \n 1. Para ir al menu de materiales \n 2. Para hacer una solicitud de construcción \n 3. Para ir al menu de informes \n 4. Para actualizar estados \n _. Cualquier otro digito para volver al menú principal")
    val comando = scala.io.StdIn.readLine()
    comando match {
      case "1" => MenuMateriales.menuMateriales(ordenConstruccion, ciudadela)
      case "2" => MenuSolicitud.menuTipoConstruccion(ordenConstruccion, ciudadela)
      case "3" => menuInforme(ordenConstruccion, ciudadela)
      case "4" => MenuEstado.menuCambioEstado(ciudadela, ordenConstruccion)
      case _ => menuPrincipal(ordenConstruccion, ciudadela)
    }
  }
}

//La función menuPrincipal funciona de la siguiente manera:
//Muestra un mensaje de bienvenida y un menú principal que le pide al usuario que seleccione una opción.
//Lee la entrada del usuario desde la consola y almacena la entrada en una variable llamada comando.
//Usa una expresión match para comparar el valor de comando con diferentes casos posibles y, según el caso, llama a una función de menú diferente.
// Los casos posibles son:
//Si el usuario ingresa "1", llama a la función menuMateriales del objeto MenuMateriales.
//Si el usuario ingresa "2", llama a la función menuTipoConstruccion del objeto MenuSolicitud.
//Si el usuario ingresa "3", llama a la función menuInforme (que se debe definir en otro lugar del código).
//Si el usuario ingresa "4", llama a la función menuCambioEstado del objeto MenuEstado.
//Si el usuario ingresa cualquier otra cosa, llama a la función menuPrincipal nuevamente para mostrar el menú principal una vez más.
//La función se llama a sí misma de forma recursiva (usando @tailrec) si el usuario no selecciona ninguna opción válida del menú.
//En resumen, este código proporciona un menú de opciones para el usuario y permite que el usuario seleccione diferentes funciones del programa según la
// opción seleccionada. Esto hace que la interacción del usuario con el programa sea más fácil y eficiente.
