package sura.com.constructores.s.a.s.view

import sura.com.constructores.s.a.s.controller.AdministradorCiudadela
import sura.com.constructores.s.a.s.models.{Ciudadela, OrdenConstruccion}

object MenuConsultar {

  def menuInforme(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit = {
    println("___ Menú de Informes ___\n")
    println("Digite:  \n 1. Para consultar las ordenes de construción \n 2. Para consultar fecha de finalización del proyecto \n _. Cualquier otro digito para volver al menú principal")
    val comando = scala.io.StdIn.readLine()
    comando match {
      case "1" => Imprimir.mostrarSolicitudOrdenes(ordenConstruccion, ciudadela)
      case "2" =>
        val ciudadelaAct = AdministradorCiudadela.calculaFechaCulminacion(ciudadela)
        Imprimir.mostrarFechaCulminacion(ordenConstruccion, ciudadelaAct)
      case _ => MenuPrincipal.menuPrincipal(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela)
    }
  }

}

//El código proporcionado define un objeto llamado MenuConsultar que contiene una función llamada menuInforme. Esta función muestra un menú con
// tres opciones al usuario para consultar información sobre la Ciudadela y las órdenes de construcción:
//
//  Consultar las órdenes de construcción.
//  Consultar la fecha de finalización del proyecto.
//  Volver al menú principal.

//La función lee la entrada del usuario utilizando scala.io.StdIn.readLine() y luego utiliza un match para determinar qué acción tomar en función del
// comando ingresado por el usuario.
//
//  Si el usuario ingresa "1", se llama a la función mostrarSolicitudOrdenes del objeto Imprimir, que imprime la información sobre las órdenes de construcción de la
//  Ciudadela.
//
//Si el usuario ingresa "2", se llama a la función calculaFechaCulminacion del objeto AdministradorCiudadela, que calcula la fecha de finalización del proyecto
// basándose en la información de la Ciudadela, y luego se llama a la función mostrarFechaCulminacion del objeto Imprimir, que imprime la fecha de finalización
// del proyecto.

//Si el usuario ingresa cualquier otro valor, se llama a la función menuPrincipal del objeto MenuPrincipal, que muestra el menú principal.
//
//  En resumen, este código proporciona una manera de que el usuario pueda consultar información sobre la Ciudadela y las órdenes de construcción a través de
//  un menú de opciones. Esto facilita la navegación y la comprensión de la información disponible para el usuario.
