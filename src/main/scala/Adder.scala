import chisel3._
import chisel3.iotesters.{SteppedHWIOTester, ChiselFlatSpec}
import chisel3.testers.TesterDriver

class Adder(val w: Int) extends Module {
  val io = IO(new Bundle {
    val in0 = Input(UInt(w.W))
    val in1 = Input(UInt(w.W))
    val out = Output(UInt(w.W))
  })
  io.out := io.in0 + io.in1
}

class AdderTester extends SteppedHWIOTester {
  val device_under_test = Module( new Adder(8) )
  val c = device_under_test
  enable_all_debug = true

  rnd.setSeed(0L)
  for (i <- 0 until 3) {
    val in0 = rnd.nextInt(1 << c.w)
    val in1 = rnd.nextInt(1 << c.w)
    poke(c.io.in0, in0)
    poke(c.io.in1, in1)
    expect(c.io.out, (in0 + in1) & ((1 << c.w) - 1))

    step(1)
  }
}

object Adder {
  def main(args: Array[String]): Unit = {
    TesterDriver.execute { () => new AdderTester }
  }
}

class AdderSpec extends ChiselFlatSpec {
  "Adder" should "compile and run without incident" in {
    assertTesterPasses { new AdderTester }
  }
}
