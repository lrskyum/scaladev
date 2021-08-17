package lrskyum.stoxx.business

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

@SpringBootApplication
class StoxxApplication {
  @EventListener(ApplicationReadyEvent)
  def ready: Unit = {
    AlphaVantageQuoteSource.get
  }
}

object StoxxApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[StoxxApplication], args: _ *)
  }
}