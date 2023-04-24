package sura.com.constructores.s.a.s.view

import sura.com.constructores.s.a.s.controller.{AdministradorCiudadela, AdministradorMateriales, RegistrarSolicitud, Validadores}
import sura.com.constructores.s.a.s.models.{CanchaFutbol, Casa, Ciudadela, Coordenada, Edificio, Gimnasio, Lago, OrdenConstruccion}

object MenuSolicitud {

  //La función menuTipoConstruccion muestra un menú con las opciones de los diferentes tipos de construcción disponibles.
  // El usuario debe seleccionar una opción digitando el número correspondiente o cualquier otro carácter para volver al menú principal.
  def menuTipoConstruccion(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit = {
    println("___ Solicitud Orden de construccion ___\n")
    println("Digite => \n 1. Para construir una casa \n 2.  Para construir una lago \n 3.  Para construir una Cancha de Futbol " +
      "\n 4.  Para construir un edificio \n 5.  Para construir un gymnasio \n  _. Cualquier otro digito para volver al menú Principal")
    val comandoTipoConstruccion = scala.io.StdIn.readLine()
    controladorOrden(comandoTipoConstruccion, ordenConstruccion, ciudadela)
  }

  //
  def digitarCoordenadasConstruccion(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit = {
    println("Digite la coordenada de construccion en el eje X")
    val ejeX = scala.io.StdIn.readInt()
    println("Digite la coordenada de construccion en el eje Y")
    val ejeY = scala.io.StdIn.readInt()
    ejecutarSolicitudOrden(ordenConstruccion.copy(coordenada = Some(Coordenada(ejeX, ejeY))), ciudadela)
  }

  //La función controladorOrden se encarga de interpretar la opción seleccionada por el usuario y de llamar a la función correspondiente para la siguiente etapa de la solicitud.
  def controladorOrden(comando: String, ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit = {
    comando match {
      case "1" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion = Some(Casa())), ciudadela)
      case "2" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion = Some(Lago())), ciudadela)
      case "3" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion = Some(CanchaFutbol())), ciudadela)
      case "4" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion = Some(Edificio())), ciudadela)
      case "5" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion = Some(Gimnasio())), ciudadela)
      case _ => MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
    }
  }

  //Las funciones digitarCoordenadasConstruccion y ejecutarSolicitudOrden se encargan de solicitar las coordenadas de construcción y validar
  // que haya suficientes materiales y que las coordenadas estén disponibles, respectivamente.
  //Si se validan correctamente las condiciones, se descuentan los materiales necesarios para la construcción,
  // se guarda la solicitud y se imprime un mensaje indicando que la solicitud ha sido procesada.
  //Si alguna de las validaciones falla, se imprime un mensaje de error y se muestra nuevamente el menú principal para que el usuario pueda seleccionar otra opción.
  def ejecutarSolicitudOrden(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit = {

    val validarMateriales = Validadores.validarMateriales(ordenConstruccion, ciudadela)
    if (validarMateriales) Imprimir.imprimirErrorValidacion(ordenConstruccion, ciudadela)
    val validarCoord = Validadores.validarCoordenadas(ordenConstruccion, ciudadela)
    if (validarCoord) Imprimir.imprimirErrorValidacion(ordenConstruccion, ciudadela)
    val materialesAct = AdministradorMateriales.descontarMaterial(ordenConstruccion, ciudadela.material)
    val ordenAct = AdministradorCiudadela.estadoSolicitudes(ciudadela, ordenConstruccion)
    val ciudadelaAct = RegistrarSolicitud.guardarSolicitud(ordenAct, ciudadela.copy(material = materialesAct))
    Imprimir.imprimirOrden(ordenAct, ciudadelaAct)

  }

}