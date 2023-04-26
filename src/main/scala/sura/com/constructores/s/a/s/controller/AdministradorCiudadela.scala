package sura.com.constructores.s.a.s.controller

import sura.com.constructores.s.a.s.models.{Ciudadela, EnProgreso, OrdenConstruccion, Pendiente}

import java.util.Calendar

object AdministradorCiudadela {

  //Esta función recibe una ciudadela como parámetro y calcula el plazo total de la ciudadela,
  // sumando los tiempos de construcción de cada una de las órdenes de construcción que hayan sido agregadas a la ciudadela.
  def calcularPlazoCiudadela(ciudadela: Ciudadela): Int = {
    ciudadela.solicitudesOrdenes.map(orden => orden.tipoConstruccion.get.tiempo).sum
  }

  //  esta función recibe una ciudadela como parámetro y calcula la fecha en que la ciudadela estará culminada,
  //  dependiendo del estado de la ciudadela. Si la ciudadela ya está culminada, simplemente se asigna el plazo de
  //  entrega calculado anteriormente. Si no está culminada, se calcula la fecha sumando el plazo total de la ciudadela
  //  a la fecha de inicio de la ciudadela, y se asigna el plazo de entrega calculado anteriormente.
  def calculaFechaCulminacion(ciudadela: Ciudadela): Ciudadela = {
    if (EstadoCiudadela.estadoCiudadela(ciudadela)) {
      ciudadela.copy(plazoEntrega = calcularPlazoCiudadela(ciudadela))
    } else {
      val fecha = ciudadela.fechaInicio
      val plazoProyecto = calcularPlazoCiudadela(ciudadela)
      fecha.add(Calendar.DAY_OF_YEAR, plazoProyecto)
      ciudadela.copy(fechaFin = Some(fecha.getTime), plazoEntrega = calcularPlazoCiudadela(ciudadela))
    }
  }

  // Esta función recibe una ciudadela y una orden de construcción como parámetros, y calcula el estado de la orden de
  // construcción en función del estado de la ciudadela. Si la ciudadela está culminada, la orden se asigna como "En progreso"
  // y se le asigna un plazo de entrega calculado como la suma del plazo total de la ciudadela y el tiempo de construcción de la
  // orden de construcción. Si la ciudadela no está culminada, la orden se asigna como "Pendiente" y se le asigna un plazo de entrega calculado de la misma manera.
  def estadoSolicitudes(ciudadela: Ciudadela, ordenConstruccion: OrdenConstruccion): OrdenConstruccion = {
    if (EstadoCiudadela.estadoCiudadela(ciudadela)) {
      ordenConstruccion.copy(estadoOrden = EnProgreso(), plazo = calcularPlazoCiudadela(ciudadela) + ordenConstruccion.tipoConstruccion.get.tiempo)
    } else {
      ordenConstruccion.copy(estadoOrden = Pendiente(), plazo = calcularPlazoCiudadela(ciudadela) + ordenConstruccion.tipoConstruccion.get.tiempo)
    }
  }


}
