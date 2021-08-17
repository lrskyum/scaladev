package lrskyum.stoxx.business

import org.asynchttpclient._

import java.net.URL
import java.time.LocalDate
import scala.concurrent.Future

class AlphaVantantageSource {
  def quotes: List[Quote] = ???
}

trait QuoteSource {
  def quotes: List[Quote]
}

class AlphaVantageQuoteSource extends QuoteSource {
  val key = "..."

  def olhcUrl(symbol: String): URL = {
    new URL(s"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=${symbol}&apikey=${key}")
  }

  override def quotes: List[Quote] = {
    val request = Dsl.get(olhcUrl("IBM").toExternalForm).build()
    val response = Dsl.asyncHttpClient.executeRequest(request).get().getResponseBody
    null
  }
}

object AlphaVantageQuoteSource {
  def get = new AlphaVantageQuoteSource
}

trait Price extends Comparable[Price] {
  def value: Double
}

trait Quote {
  def date: LocalDate
  def adjusted: Price
}
