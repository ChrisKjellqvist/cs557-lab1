package sha3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.{ConfigMap, BeforeAndAfterAllConfigMap}
import firrtl.AnnotationSeq
import chiseltest._

abstract class TestWithBackendSelect
    extends AnyFlatSpec
    with BeforeAndAfterAllConfigMap {
  var backend = ""
  var simAnnos: AnnotationSeq = Seq()
  override protected def beforeAll(configMap: ConfigMap): Unit = {
    var backend = ""
    if (configMap.get("backend").isDefined) {
      backend = configMap.get("backend").fold("")(_.toString)
    }
    simAnnos = simAnnos ++ (backend.toLowerCase() match {
      case "vcs" => Seq(VcsBackendAnnotation) ++ Seq(WriteFsdbAnnotation)
      case "verilator" =>
        Seq(VerilatorBackendAnnotation) ++ Seq(WriteVcdAnnotation)
      case "icarus" => Seq(IcarusBackendAnnotation) ++ Seq(WriteVcdAnnotation)
      case _        => Seq(TreadleBackendAnnotation) // Used treadle by default
    })
  }
}
