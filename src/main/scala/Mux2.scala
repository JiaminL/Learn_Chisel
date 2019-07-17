import chisel3._
import chisel3.util._

class Mux2(val w: Int) extends Module {
	val io = IO(new Bundle {
		val x = Input(UInt(w.W))
		val y = Input(UInt(w.W))
		val s = Input(Bool())
		val m = Output(UInt(w.W))
	})

	io.m := Mux(io.s, io.x, io.y)
}
