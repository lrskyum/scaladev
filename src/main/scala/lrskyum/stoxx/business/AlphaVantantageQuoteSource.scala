package lrskyum.stoxx.business

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import lrskyum.stoxx.business.ScalaMapper.mapper
import org.asynchttpclient.Dsl._

import java.net.URL
import java.time.LocalDate

object ScalaMapper {
  var mapper: ObjectMapper = JsonMapper.builder()
    .addModule(DefaultScalaModule)
    .build()
}

trait Price extends Comparable[Price] {
  def value: Double
}

trait Quote {
  def date: LocalDate

  def adjusted: Price
}

trait QuoteSource {
  def quotes(symbol: String): List[Quote]
}

class AlphaVantageQuoteSource extends QuoteSource {
  val key = "EJSFNVGS7Q00C4N6"

  def ohlcUrl(symbol: String): URL = {
    new URL(s"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=${symbol}&apikey=${key}")
  }

  override def quotes(symbol: String): List[Quote] = {
    val request = get(ohlcUrl("IBM").toExternalForm).build()
    val response = asyncHttpClient.executeRequest(request).get().getResponseBody
    val myMap = mapper.readValue(response, classOf[Map[JsonNode, Tuple2[LocalDate, List[Tuple2[String, Double]]]]])

    mapper.createParser(ohlcUrl("IBM")).nextValue()

    println(response)
    List.empty
  }
}

object AlphaVantageQuoteSource {
  def get: List[Quote] = new AlphaVantageQuoteSource().quotes("IBM")
}

