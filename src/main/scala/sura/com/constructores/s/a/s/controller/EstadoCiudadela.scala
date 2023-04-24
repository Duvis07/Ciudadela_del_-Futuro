package sura.com.constructores.s.a.s.controller

import sura.com.constructores.s.a.s.models.Ciudadela

trait EstadoCiudadela {

  //  Esta función devuelve true si no hay órdenes de construcción pendientes en la Ciudadela,
  //  lo que significa que la construcción ha finalizado y la Ciudadela ya no está en estado de construcción.
  //  Si hay órdenes de construcción pendientes, la función devuelve false, lo que significa que la construcción aún está en progreso.
  def estadoCiudadela(ciudadela: Ciudadela): Boolean = {
    ciudadela.solicitudesOrdenes.isEmpty
  }

}
//Además, el objeto EstadoCiudadela extiende el trait EstadoCiudadela, lo que permite utilizar la función definida en el trait.
object EstadoCiudadela extends EstadoCiudadela
