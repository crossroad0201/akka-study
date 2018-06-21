package crossroad0201.akkastudy.actor.intro

import akka.actor.{ Actor, ActorSystem, Props }
import akka.event.Logging

class MyActor extends Actor {
  val log = Logging(context.system, this)


  override def preStart(): Unit = {
    log.info("START")
  }

  override def receive = {
    case "test" => log.info("received test message.")
    case unknown      => log.info(s"received unknown message $unknown.")
  }

  override def postStop(): Unit = {
    log.info("STOP")
  }
}
object MyActor {
  def props: Props = Props[MyActor]
}

object MyActorMain extends App {

  val system = ActorSystem("myactor")

  val myActor = system.actorOf(MyActor.props, "MyActor")
  myActor ! "test"
  myActor ! "UNKNOWN"

  Thread.sleep(5000)
  system.stop(myActor)

}
