/**********************************************************************
Copyright (c) 2005 Andy Jefferson and others.
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
package org.jpox.samples.interfaces;

/**
 * Rectangle class.
 **/
public class Shape5Rectangle implements Shape5
{
	private int id;
    protected double width = 0.0;
    protected double length = 0.0;

    protected Shape5Holder shapeHolder = null;

    public Shape5Rectangle()
    {
    }

    public Shape5Rectangle(int id, double width,double length)
    {
        this.id = id;
        this.length = length;
        this.width = width;
    }

    public String getName()
    {
        return "Rectangle";
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getArea()
    {
        return length*width;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }

    public Shape5Holder getShapeHolder()
    {
        return shapeHolder;
    }

    public boolean equals(Object o)
    {
        if (o == null || !o.getClass().equals(this.getClass()))
        {
            return false;
        }
        Shape5Rectangle rhs = (Shape5Rectangle)o;
        return width == rhs.width && length == rhs.length;
    }

    public String toString()
    {
        return "{Rectangle width=" + width + "; length=" + length + "}";
    }
}