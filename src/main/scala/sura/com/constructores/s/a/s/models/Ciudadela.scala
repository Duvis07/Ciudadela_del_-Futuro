package sura.com.constructores.s.a.s.models

import java.util.{Calendar, Date}

case class Ciudadela(fechaFin: Option[Date],
                     plazoEntrega: Int = 0,
                     fechaInicio: Calendar,
                     solicitudesOrdenes: List[OrdenConstruccion] = List(),
                     material: Material = Material(),
                     arquitecto: Arquitecto = Arquitecto())

case class Arquitecto(identificacion: String = "123451", nombre: String = "Duvan Arley Botero")
