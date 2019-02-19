/*
 * © 2017 AgNO3 Gmbh & Co. KG
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package jcifsng211.internal.fscc;


import java.nio.charset.StandardCharsets;

import jcifsng211.Encodable;
import jcifsng211.internal.util.SMBUtil;


/**
 * @author mbechler
 *
 */
public class FsctlPipeWaitRequest implements Encodable {

    private final byte[] nameBytes;
    private final long timeout;
    private final boolean timeoutSpecified;


    /**
     * @param name
     * 
     */
    public FsctlPipeWaitRequest ( String name ) {
        this.nameBytes = name.getBytes(StandardCharsets.UTF_16LE);
        this.timeoutSpecified = false;
        this.timeout = 0;
    }


    /**
     * @param name
     * @param timeout
     * 
     */
    public FsctlPipeWaitRequest ( String name, long timeout ) {
        this.nameBytes = name.getBytes(StandardCharsets.UTF_16LE);
        this.timeoutSpecified = true;
        this.timeout = timeout;
    }


    /**
     * {@inheritDoc}
     *
     * @see jcifsng211.Encodable#encode(byte[], int)
     */
    @Override
    public int encode ( byte[] dst, int dstIndex ) {
        int start = dstIndex;
        SMBUtil.writeInt8(this.timeout, dst, dstIndex);
        dstIndex += 8;
        SMBUtil.writeInt4(this.nameBytes.length, dst, dstIndex);
        dstIndex += 4;

        dst[ dstIndex ] = (byte) ( this.timeoutSpecified ? 0x1 : 0x0 );
        dstIndex++;
        dstIndex++; // Padding

        System.arraycopy(this.nameBytes, 0, dst, dstIndex, this.nameBytes.length);
        dstIndex += this.nameBytes.length;

        return dstIndex - start;
    }


    /**
     * {@inheritDoc}
     *
     * @see jcifsng211.Encodable#size()
     */
    @Override
    public int size () {
        return 14 + this.nameBytes.length;
    }

}
