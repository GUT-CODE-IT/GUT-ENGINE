/*
    Author: .GuTeK <dev@gutcode.pl>
    Project: GUT-ENGINE [MINECRAFT ENGINE]
    Price: WEBSITE
    Resources: 12/6780
    Data: 29.02.2024
    Contact Discord: .GuTeK#0001
    Contact e-mail: dev@gutcode.pl
    Our websites: https://gutcode.pl
    ⓒ 2024 by .GuTeK | ALL RIGHTS RESERVED |
*/

package V1.com.GuTek.ggc.ptr;

import java.awt.*;
import V1.com.GuTek.ggc.Pointer;
import V1.com.GuTek.ggc.PointerType;
import V1.com.GuTek.ggc.Memory;

public abstract class ByReference extends PointerType {
    protected ByReference(final int dataSize) {
        this.setPointer(new Memory(dataSize))
    }
}
