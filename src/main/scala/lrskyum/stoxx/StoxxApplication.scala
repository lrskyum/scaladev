package lrskyum.stoxx

import lrskyum.stoxx.business.AlphaVantageQuoteSource
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

@SpringBootApplication
class StoxxApplication {
  @EventListener
  def ready(event: ApplicationReadyEvent): Unit = {
    AlphaVantageQuoteSource.get
  }
}

object StoxxApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[StoxxApplication], args: _ *)
  }
}