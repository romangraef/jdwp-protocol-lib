package moe.nea.jdwp.struct.threadreference

import moe.nea.jdwp.*
import moe.nea.jdwp.primitives.*
import moe.nea.jdwp.struct.base.*

/**
 * Stops the thread with an asynchronous exception.
 */
class Stop : JDWPComposite(), JDWPCommandPayload<StopReply> {
    /**
     * The thread object ID.
     */
    var thread by useField(JDWPThreadId())
    /**
     * Asynchronous exception. This object must be an instance of java.lang.Throwable or a subclass
     */
    var throwable by useField(JDWPObjectId())
    override val reply = StopReply()
    override val commandId: UByte get() = 10.toUByte()
    override val commandSetId: UByte get() = 11.toUByte()
}
/**
 * Reply for [Stop]
 */
class StopReply : JDWPComposite(), JDWPReplyPayload {
}


