/**********************************************************************
Copyright (c) 2006 Erik Bengtson and others. All rights reserved. 
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 

Contributors:
    ...
**********************************************************************/
package org.jpox.samples.compoundidentity;

import java.io.Serializable;

/**
 * Classes using identifying relationship with 4 levels depth.
 * @version $Revision: 1.1 $
 */
public class CompoundSourceL4
{
    private CompoundSourceL3 source; // PK
    private String name; // PK

    public CompoundSourceL4(CompoundSourceL3 src, String name)
    {
        super();
        this.source = src;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public CompoundSourceL3 getSource()
    {
        return source;
    }

    public void setSource(CompoundSourceL3 src)
    {
        this.source = src;
    }
    
    public static class Id implements Serializable
    {
        public CompoundSourceL3.Id source;
        public String name;

        public Id()
        {
        }

        public Id(java.lang.String str)
        {
            java.util.StringTokenizer token = new java.util.StringTokenizer(str, "::");
            this.source = new CompoundSourceL3.Id(token.nextToken());
            this.name = new String(token.nextToken());
        }

        public java.lang.String toString()
        {
            java.lang.String str = "";
            str += java.lang.String.valueOf(this.source) + "::";
            str += java.lang.String.valueOf(this.name) + "::";
            return str;
        }

        public int hashCode()
        {
            return name.hashCode() ^ source.hashCode();
        }

        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (o == null)
            {
                return false;
            }
            if (o.getClass() != getClass())
            {
                return false;
            }
            Id objToCompare = (Id) o;
            return ((this.source == null ? objToCompare.source == null : 
                    this.source.equals(objToCompare.source)) && 
                    (this.name == null ? objToCompare.name == null : this.name.equals(objToCompare.name)));
        }
    }
}