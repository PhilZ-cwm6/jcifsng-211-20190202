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
package jcifsng211.ntlmssp.av;


import jcifsng211.internal.util.SMBUtil;


/**
 * @author mbechler
 *
 */
public class AvTimestamp extends AvPair {

    /**
     * @param raw
     */
    public AvTimestamp ( byte[] raw ) {
        super(AvPair.MsvAvTimestamp, raw);
    }


    /**
     * 
     * @param ts
     */
    public AvTimestamp ( long ts ) {
        this(encode(ts));
    }


    /**
     * @param ts
     * @return
     */
    private static byte[] encode ( long ts ) {
        byte[] data = new byte[8];
        SMBUtil.writeInt8(ts, data, 0);
        return data;
    }


    /**
     * @return the timestamp
     */
    public long getTimestamp () {
        return SMBUtil.readInt8(getRaw(), 0);
    }

}
