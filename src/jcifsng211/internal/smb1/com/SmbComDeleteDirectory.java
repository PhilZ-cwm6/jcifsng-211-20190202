/* jcifs smb client library in Java
 * Copyright (C) 2000  "Michael B. Allen" <jcifs at samba dot org>
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

package jcifsng211.internal.smb1.com;


import jcifsng211.Configuration;
import jcifsng211.internal.smb1.ServerMessageBlock;


/**
 * 
 */
public class SmbComDeleteDirectory extends ServerMessageBlock {

    /**
     * 
     * @param config
     * @param path
     */
    public SmbComDeleteDirectory ( Configuration config, String path ) {
        super(config, SMB_COM_DELETE_DIRECTORY, path);
    }


    @Override
    protected int writeParameterWordsWireFormat ( byte[] dst, int dstIndex ) {
        return 0;
    }


    @Override
    protected int writeBytesWireFormat ( byte[] dst, int dstIndex ) {
        int start = dstIndex;

        dst[ dstIndex++ ] = (byte) 0x04;
        dstIndex += writeString(this.path, dst, dstIndex);

        return dstIndex - start;
    }


    @Override
    protected int readParameterWordsWireFormat ( byte[] buffer, int bufferIndex ) {
        return 0;
    }


    @Override
    protected int readBytesWireFormat ( byte[] buffer, int bufferIndex ) {
        return 0;
    }


    @Override
    public String toString () {
        return new String("SmbComDeleteDirectory[" + super.toString() + ",directoryName=" + this.path + "]");
    }
}
