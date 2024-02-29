/*
    Author: .GuTeK <dev@gutcode.pl>
    Project: GUT-ENGINE [MINECRAFT ENGINE]
    Price: WEBSITE
    Resources: 13/6780
    Data: 29.02.2024
    Contact Discord: .GuTeK#0001
    Contact e-mail: dev@gutcode.pl
    Our websites: https://gutcode.pl
    ⓒ 2024 by .GuTeK | ALL RIGHTS RESERVED |
*/

package V1.com.GuTek.ggc.ptr;

public class ByteByReference extends ByReference {
    public ByteByReference() {
        this((byte)0);
    }

    public ByteByReference(final byte value) {
        super(dataSize:1);
        this.setValue(value);
    }

    public void setValue(final byte value) {
        this.getPointer().setByte(offset:0L, value);
    }

    public byte getValue() {
        return this.getPointer().getByte(offset:0L);
    }
}
