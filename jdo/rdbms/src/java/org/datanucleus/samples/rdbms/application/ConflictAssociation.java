/******************************************************************
Copyright (c) 2003 Erik Bengtson and others. All rights reserved. 
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
 *****************************************************************/
package org.datanucleus.samples.rdbms.application;

/**
 * Test conflict of column names for fields in simple associations and fields in the persistent classes.
 * @version $Revision: 1.1 $
 */
public class ConflictAssociation
{
    String association;
    String associationDescription;
    ConflictRole role;
    String roleid;

    public String getRoleid()
    {
        return roleid;
    }

    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }

    public ConflictRole getRole()
    {
        return role;
    }

    public void setRole(ConflictRole role)
    {
        this.role = role;
    }

    public String getAssociation()
    {
        return association;
    }

    public void setAssociation(String association)
    {
        this.association = association;
    }

    public String getAssociationDescription()
    {
        return associationDescription;
    }

    public void setAssociationDescription(String associationDescription)
    {
        this.associationDescription = associationDescription;
    }
}