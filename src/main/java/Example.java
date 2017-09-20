import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.stream.ActorAttributes;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Example {
  public static void main(String[] args) throws InterruptedException {
//    final Config configuration = ConfigFactory.load(ConfigFactory.parseString(
//      "akka {" +
//        "  loggers = [\"akka.event.slf4j.Slf4jLogger\"]\r\n" +
//        "  loglevel = \"DEBUG\"\r\n" +
//        "  logging-filter = \"akka.event.slf4j.Slf4jLoggingFilter\"\r\n" +
//        "}"));
    final ActorSystem system = ActorSystem.create("QuickStart");
    final Materializer materializer = ActorMaterializer.create(system);

    Source.repeat("hello").take(1000)
      .via(Flow.of(String.class).log("Hello").withAttributes(ActorAttributes.createLogLevels(Logging.ErrorLevel(), Logging.ErrorLevel(), Logging.ErrorLevel())))
      .runWith(Sink.ignore(), materializer).thenAccept(done -> {
        system.terminate();
      });

  }
}
