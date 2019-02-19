/*
 * © 2016 AgNO3 Gmbh & Co. KG
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
package jcifsng211.smb;


import javax.security.auth.Subject;

import jcifsng211.CIFSContext;
import jcifsng211.CIFSException;
import jcifsng211.Credentials;


/**
 * @author mbechler
 *
 */
public interface CredentialsInternal extends Cloneable, Credentials {

    /**
     * 
     * @return a copy of the credentials
     */
    CredentialsInternal clone ();


    /**
     * @param tc
     * @param targetDomain
     * @param host
     * @param initialToken
     * @param doSigning
     * @return a new context
     * @throws SmbException
     */
    SSPContext createContext ( CIFSContext tc, String targetDomain, String host, byte[] initialToken, boolean doSigning ) throws SmbException;


    /**
     * @return subject associated with the credentials
     */
    Subject getSubject ();


    /**
     * @throws CIFSException
     * 
     */
    void refresh () throws CIFSException;
}
