package fr.acinq.eclair.io

import java.net.Socket

import akka.io.Inet.SocketOption
import grizzled.slf4j.Logging

final case class SendBufferSize(size: Int) extends SocketOption with Logging {

  /**
    * Action to be taken for this option after connect returned (i.e. on
    * the slave socket for servers).
    */
  override def afterConnect(s: Socket): Unit = {
    s.setSendBufferSize(size)
    logger.info(s"(before connect) set tcp sendbuffer size to required=$size actual=${s.getSendBufferSize}")
  }
}
