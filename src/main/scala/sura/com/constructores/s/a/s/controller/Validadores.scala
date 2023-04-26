package sura.com.constructores.s.a.s.controller

import sura.com.constructores.s.a.s.models.{Ciudadela, OrdenConstruccion}

trait Validadores {

  // verifica si la cantidad de materiales necesarios para construir una orden de
  // construcción dada está disponible en la ciudadela. Si no hay suficientes materiales, se devuelve true.
  def validarMateriales(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Boolean = ciudadela.material.cemento < ordenConstruccion.tipoConstruccion.get.cemento ||
    ciudadela.material.grava < ordenConstruccion.tipoConstruccion.get.grava ||
    ciudadela.material.adobe < ordenConstruccion.tipoConstruccion.get.adobe ||
    ciudadela.material.madera < ordenConstruccion.tipoConstruccion.get.madera ||
    ciudadela.material.arena < ordenConstruccion.tipoConstruccion.get.arena


  //La función validarCoordenadas devuelve una lista de valores booleanos que indican si la nueva OrdenConstruccion
  // es válida en cada una de las órdenes de construcción existentes en la Ciudadela. Estos valores booleanos se
  // pasan a otra función llamada verificarCoordenadas, que devuelve un valor booleano que indica si la nueva OrdenConstruccion
  // es válida en todas las órdenes de construcción existentes en la Ciudadela.
  def validarCoordenadas(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Boolean = {
    verificarCoordenadas(ciudadela.solicitudesOrdenes.map(ord => validarCoordenadasOrdenes(ord, ordenConstruccion)))
  }

  // Esta función toma dos órdenes de construcción, una que ya está en la Ciudadela y otra que se está intentando agregar,
  // y verifica si las coordenadas de la nueva orden de construcción son diferentes de las coordenadas de la orden de
  // construcción existente. Devuelve true si las coordenadas son diferentes, lo que indica que la nueva orden de construcción se puede agregar, y false si son iguales, lo que indica que la nueva orden de construcción no se puede agregar.
  private def validarCoordenadasOrdenes(ord: OrdenConstruccion, ordenConstruccion: OrdenConstruccion): Boolean = {
    ord.coordenada.get.ejeX != ordenConstruccion.coordenada.get.ejeX && ord.coordenada.get.ejeY != ordenConstruccion.coordenada.get.ejeY
  }

  // Esta función toma una lista de valores booleanos y verifica si alguno de ellos es false.
  // Devuelve true si todos los valores en la lista son true, lo que significa que todas las órdenes
  // de construcción tienen coordenadas diferentes, y devuelve false si al menos un valor en la lista es false,
  // lo que significa que al menos una orden de construcción tiene las mismas coordenadas que la nueva orden de construcción.
  private def verificarCoordenadas(listaComparacionCoordenadas: List[Boolean]): Boolean = {
    listaComparacionCoordenadas.contains(false)
  }

}
  object Validadores extends Validadores

