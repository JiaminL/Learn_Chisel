import chisel3._

object Main extends App {
  chisel3.Driver.execute(args, () => new FullAdder_4bits)
}
