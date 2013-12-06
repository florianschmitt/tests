/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. All rights reserved.
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

import java.util.HashSet;
import java.util.Set;

/**
 * Container of Foods.
 */
public class Diet
{
    private int id;
    protected Food favouriteFood = null;

    protected Set foods = new HashSet();

    public Diet(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setFavouriteFood(Food f)
    {
        favouriteFood = f;
    }

    public Food getFavouriteFood()
    {
        return favouriteFood;
    }

    public Set getFoods()
    {
        return foods;
    }
}