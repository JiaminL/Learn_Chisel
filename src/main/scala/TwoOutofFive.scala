import chisel3._
import chisel3.util._

class TwoOutofFive extends Module{
  val io = IO(new Bundle{
    val x = Input(UInt(4.W))
    val y = Output(UInt(5.W))
  })

  io.y := MuxLookup(io.x, 0.U(5.W), Array(
    0.U(4.W) -> "b00011".U(5.W),
    1.U(4.W) -> "b00101".U(5.W),
    2.U(4.W) -> "b00110".U(5.W),
    3.U(4.W) -> "b01001".U(5.W),
    4.U(4.W) -> "b01010".U(5.W),
    5.U(4.W) -> "b01100".U(5.W),
    6.U(4.W) -> "b10001".U(5.W),
    7.U(4.W) -> "b10010".U(5.W),
    8.U(4.W) -> "b10100".U(5.W),
    9.U(4.W) -> "b11000".U(5.W)
    ))
}
