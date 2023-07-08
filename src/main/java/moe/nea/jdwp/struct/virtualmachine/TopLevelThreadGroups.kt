package moe.nea.jdwp.struct.virtualmachine

import moe.nea.jdwp.*
import moe.nea.jdwp.primitives.*
import moe.nea.jdwp.struct.base.*

/**
 * Returns all thread groups that do not have a parent. This command may be used as the first step in building a tree (or trees) of the existing thread groups.
 */
class TopLevelThreadGroups : JDWPComposite(), JDWPCommandPayload<TopLevelThreadGroupsReply> {
    override val reply = TopLevelThreadGroupsReply()
    override val commandId: UByte get() = 5.toUByte()
    override val commandSetId: UByte get() = 1.toUByte()
}
/**
 * Reply for [TopLevelThreadGroups]
 */
class TopLevelThreadGroupsReply : JDWPComposite(), JDWPReplyPayload {
    /**
     * Number of thread groups that follow.
     */
    var groups by useField(JDWPInt())
    var groupsElements by useField(JDWPExternalVector(this::groups, ::TopLevelThreadGroupsGroupsElement))
}


class TopLevelThreadGroupsGroupsElement : JDWPComposite() {
    /**
     * A top level thread group
     */
    var group by useField(JDWPThreadGroupId())
}

