/**********************************************************************
Copyright (c) 2008 Andy Jefferson and others. All rights reserved.
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
package org.jpox.samples.rdbms.schema;

/**
 * Test class for schema handling.
 */
public class SchemaClass2
{
    private long id;
    String name;

    long value;

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public long getValue()
    {
        return value;
    }
}