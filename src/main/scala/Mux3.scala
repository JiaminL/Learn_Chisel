import chisel3._
import chisel3.util._

class Mux3(val w: Int) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(w.W))
    val b = Input(UInt(w.W))
    val c = Input(UInt(w.W))
    val s = Input(UInt(2.W))
    val out = Output(UInt(w.W))
  })

  val p0 = Module(new Mux2(w)).io
  val p1 = Module(new Mux2(w)).io
  val p2 = Module(new Mux2(w)).io

  p0.x := io.a
  p0.y := io.b
  p1.x := io.c
  p1.y := 0.U(2.W)
  p2.x := p0.m
  p2.y := p1.m
  p0.s := io.s(0)
  p1.s := io.s(0)
  p2.s := io.s(1)
  io.out := p2.m

}
