package sura.com.constructores.s.a.s.controller

import sura.com.constructores.s.a.s.models._

import java.util.Calendar

trait ActualizarEstadosOrdenes {

//  actualizarEstado(ciudadela: Ciudadela): Ciudadela: Esta función actualiza el estado de todas las órdenes de construcción
//  de la Ciudadela en caso de que el tiempo transcurrido sea mayor que el plazo de la Ciudadela.
//  Si el estado de las órdenes de construcción no necesita ser actualizado, simplemente retorna la Ciudadela sin cambios.
  def actualizarEstado(ciudadela: Ciudadela): Ciudadela = {
    if (EstadoCiudadela.estadoCiudadela(ciudadela)) {
      ciudadela
    } else {
      val tiempoTrancurrido = tiempoTranscurridoInicioCiudadela(ciudadela)
      ciudadela.copy(solicitudesOrdenes = ciudadela.solicitudesOrdenes.map(ordenConst => cambiarEstado(ordenConst, tiempoTrancurrido)))
    }

  }

  // Esta función cambia el estado de una OrdenConstruccion a "Terminado",
  // "EnProgreso" o "Pendiente" según corresponda, basándose en el tiempo transcurrido y el plazo de la orden de construcción.
  private def cambiarEstado(ordenConstruccion: OrdenConstruccion, tiempoTranscurrido: Int): OrdenConstruccion = {
    ordenConstruccion match {
      case _ if tiempoTranscurrido > ordenConstruccion.plazo => ordenConstruccion.copy(estadoOrden = Terminado())
      case _ if ordenConstruccion.plazo >= tiempoTranscurrido && tiempoTranscurrido >= (ordenConstruccion.plazo - ordenConstruccion.tipoConstruccion.get.tiempo) => ordenConstruccion.copy(estadoOrden = EnProgreso())
      case _ => ordenConstruccion.copy(estadoOrden = Pendiente())
    }
  }

  //  Esta función calcula el tiempo transcurrido desde que se inició la Ciudadela, en días.
  private def tiempoTranscurridoInicioCiudadela(ciudadela: Ciudadela): Int = {
    val fechaAct = Calendar.getInstance()
    fechaAct.get(Calendar.DAY_OF_YEAR) - ciudadela.fechaInicio.get(Calendar.DAY_OF_YEAR)
  }

}

// extiende el trait ActualizarEstadosOrdenes, lo que permite utilizar las funciones definidas en el trait.
object ActualizarEstadosOrdenes extends ActualizarEstadosOrdenes
