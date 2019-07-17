import chisel3._
import chisel3.util._

class FullAdder_4bits extends Module{
  val io = IO(new Bundle{
    val a = Input(UInt(4.W))
    val b = Input(UInt(4.W))
    val cin = Input(UInt(1.W))
    val s = Output(UInt(4.W))
    val cout = Output(UInt(1.W))
  })

  val p0 = Module(new FullAdder).io
  val p1 = Module(new FullAdder).io 
  val p2 = Module(new FullAdder).io
  val p3 = Module(new FullAdder).io

  p0.a := io.a(0)
  p1.a := io.a(1)
  p2.a := io.a(2)
  p3.a := io.a(3)


  p0.b := io.b(0)
  p1.b := io.b(1)
  p2.b := io.b(2)
  p3.b := io.b(3)

  io.s := Cat(p3.sum, p2.sum, p1.sum, p0.sum)

  p0.cin := io.cin
  p1.cin := p0.cout
  p2.cin := p1.cout
  p3.cin := p2.cout
  io.cout := p3.cout

}
