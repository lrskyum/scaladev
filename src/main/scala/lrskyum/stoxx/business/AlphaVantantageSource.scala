package lrskyum.stoxx.business

class AlphaVantantageSource {
  a: String =>
  def y: Boolean = true
}

trait TestEnvironment {
  val envName: String

  def readEnvironmentProperties: Map[String, String]
}

class TestExecutor {
  env: TestEnvironment =>
  def execute(tests: List[Test]): Boolean = {
    println(s"Executing test with $envName environment")
    tests.forall(_.execute(readEnvironmentProperties))
  }
}