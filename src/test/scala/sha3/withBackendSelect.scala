package sha3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.{ConfigMap, BeforeAndAfterAllConfigMap}
import firrtl.AnnotationSeq
import chiseltest._

abstract class TestWithBackendSelect
    extends AnyFlatSpec
    with BeforeAndAfterAllConfigMap {
  var backend = ""
  /***** simulate using tradle (default) *****/
//  var simAnnos: AnnotationSeq = Seq()
  /***** use verilator simulator *****/
  // val simAnnos = Seq(VerilatorBackendAnnotation) ++ Seq(WriteVcdAnnotation)
  /***** use VCS *****/
   val simAnnos = Seq(VcsBackendAnnotation) ++ Seq(WriteVpdAnnotation)
  /***** use icarus *****/
  // val simAnnos = Seq(IcarusBackendAnnotation) ++ Seq(WriteVcdAnnotation)
}
