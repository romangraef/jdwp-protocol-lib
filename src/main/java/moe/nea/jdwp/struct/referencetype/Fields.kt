package moe.nea.jdwp.struct.referencetype

import moe.nea.jdwp.*
import moe.nea.jdwp.primitives.*
import moe.nea.jdwp.struct.base.*

/**
 * Returns information for each field in a reference type. Inherited fields are not included. The field list will include any synthetic fields created by the compiler. Fields are returned in the order they occur in the class file.
 */
class Fields : JDWPComposite(), JDWPCommandPayload<FieldsReply> {
    /**
     * The reference type ID.
     */
    var refType by useField(JDWPReferenceTypeId())
    override val reply = FieldsReply()
    override val commandId: UByte get() = 4.toUByte()
    override val commandSetId: UByte get() = 2.toUByte()
}
/**
 * Reply for [Fields]
 */
class FieldsReply : JDWPComposite(), JDWPReplyPayload {
    /**
     * Number of declared fields.
     */
    var declared by useField(JDWPInt())
    var declaredElements by useField(JDWPExternalVector(this::declared, ::FieldsDeclaredElement))
}



class FieldsDeclaredElement : JDWPComposite() {
    /**
     * Field ID.
     */
    var fieldID by useField(JDWPFieldId())
    /**
     * Name of field.
     */
    var name by useField(JDWPString())
    /**
     * JNI Signature of field.
     */
    var signature by useField(JDWPString())
    /**
     * The modifier bit flags (also known as access flags) which provide additional information on the  field declaration. Individual flag values are defined in Chapter 4 of The Java Virtual Machine Specification. In addition, The 0xf0000000 bit identifies the field as synthetic, if the synthetic attribute capability is available.
     */
    var modBits by useField(JDWPInt())
}




