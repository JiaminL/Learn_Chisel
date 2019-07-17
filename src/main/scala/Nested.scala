import chisel3._

class Inner extends Module {
  val io = IO(new Bundle {
    val dataIn = Input(UInt(1.W))
    val dataOut = Output(UInt(1.W))
  })
  val data = RegNext(io.dataIn)
  io.dataOut := data
}

class Outer extends Module {
  val io = IO(new Bundle {
    val dataIn = Input(UInt(1.W))
    val dataOut = Output(UInt(1.W))
  })
  val core = Module(new Inner()).io
  core.dataIn := io.dataIn
  io.dataOut := core.dataOut
}
