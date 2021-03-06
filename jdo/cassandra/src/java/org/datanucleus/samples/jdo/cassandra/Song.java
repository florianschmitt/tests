/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.cassandra;

import java.util.*;
import javax.jdo.annotations.*;

/**
 * 
 * @author bergun
 */
@PersistenceCapable
public class Song
{

    @PrimaryKey
    private UUID id;

    private String title;

    private String album;

    private String artist;

    @Persistent(defaultFetchGroup = "true")
    @Serialized    
    private byte[] data;

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAlbum()
    {
        return album;
    }

    public void setAlbum(String album)
    {
        this.album = album;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public byte[] getData()
    {
        return data;
    }

    public void setData(byte[] data)
    {
        this.data = data;
    }

}
