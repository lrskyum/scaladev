package lrskyum.stoxx.business

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import org.scalatestplus.mockito.MockitoSugar

@RunWith(classOf[JUnitRunner])
class AlphaVantageQuoteSourceTest extends AnyFunSpec with MockitoSugar with BeforeAndAfterEach {
  describe("when IBM") {
    it("should get quotes") {
      // given
      val qs = new AlphaVantageQuoteSource
      val ibm = "IBM"

      // when
      val q = qs.quotes(ibm)

      // then
      assert(q != null)
    }
  }
}
