import chisel3._
import chisel3.util._

class BcdTo7seg extends Module{
  val io = IO (new Bundle{
    val x = Input(UInt(4.W))
    val an = Output(UInt(8.W))
    val seg = Output(UInt(7.W))
  })

  io.seg := MuxLookup(io.x, "h7f".U(7.W), Array(
    0.U(4.W) -> "b0000001".U(7.W),
    1.U(4.W) -> "b1001111".U(7.W),
    2.U(4.W) -> "b0010010".U(7.W),
    3.U(4.W) -> "b0000110".U(7.W),
    4.U(4.W) -> "b1001100".U(7.W),
    5.U(4.W) -> "b0100100".U(7.W),
    6.U(4.W) -> "b0100000".U(7.W),
    7.U(4.W) -> "b0001111".U(7.W),
    8.U(4.W) -> "b0000000".U(7.W),
    9.U(4.W) -> "b0000100".U(7.W)
  ))

  io.an := "b11111110".U(8.W)
} 
