package sura.com.constructores.s.a.s.view

import sura.com.constructores.s.a.s.controller.ActualizarEstadosOrdenes
import sura.com.constructores.s.a.s.models.{Ciudadela, OrdenConstruccion}

object MenuEstado {

def menuCambioEstado(ciudadela: Ciudadela, ordenConstruccion: OrdenConstruccion): Unit = {
  val ciudadelaAct = ActualizarEstadosOrdenes.actualizarEstado(ciudadela)
  Imprimir.imprimirEstadosAct(ordenConstruccion, ciudadelaAct)

}

}

//El código proporcionado define un objeto llamado MenuEstado que tiene una función llamada menuCambioEstado. Esta función recibe una Ciudadela y
// una OrdenConstruccion, actualiza el estado de todas las órdenes de construcción de la Ciudadela utilizando el trait ActualizarEstadosOrdenes,
// y luego imprime el estado actualizado de la OrdenConstruccion y de la Ciudadela utilizando la función Imprimir.imprimirEstadosAct.
//
//En resumen, este código proporciona una manera de actualizar el estado de las órdenes de construcción en una Ciudadela y de imprimir el estado actualizado
// de una OrdenConstruccion y de la Ciudadela. Esto puede ser útil para monitorear el progreso de las construcciones y asegurarse de que se completen en el
// tiempo adecuado.