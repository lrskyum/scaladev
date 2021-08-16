package lrskyum.stoxx.business

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner
import org.junit.jupiter.api.Test

@RunWith(classOf[JUnitRunner])
class GreetingTest extends AnyFunSuite {
  test("My test method") {
    assert(Stock.greeting() != null)
  }
}