package sura.com.constructores.s.a.s.models


case class Coordenada(ejeX: Int, ejeY: Int)

case class OrdenConstruccion (tipoConstruccion: Option[TipoConstruccion],
                              coordenada: Option[Coordenada],
                              plazo: Int = 0,
                              estadoOrden: EstadoOrden = Pendiente())


