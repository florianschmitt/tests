/**********************************************************************
Copyright (c) 2007 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors :
 barisergun75@gmail.com
***********************************************************************/

package org.datanucleus.tests;

import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.jdo.*;
import org.datanucleus.samples.jdo.cassandra.*;
import static org.datanucleus.tests.JDOPersistenceTestCase.pmf;

/**
 * 
 * @author barise
 * @date Jul 1, 2014
 */
public class SampleCassandraData
{
    // TODO wasted sometime to create a resources directory for test sources but
    // gave up and used
    // main resources directory for storing image file so replacing the
    // test-classes with classes
    // in the current classloaders path

    public static final String CLASSES_TARGET_DIRECTORY_PATH = CassandraTypesTest.class.getResource("/").getPath()
            .replace("test-classes", "classes");

    public static UUID songId;

    public static final void loadData() throws IOException
    {
        cleanupTables();

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            songId = createASampleSong(pm);
            createASamplePlayList(pm);

        }
        finally
        {
            tx.commit();
            pm.close();
        }
    }

    public static final String ARTIST_1 = "Depeche Mode";

    public static final String ALBUM_1 = "Delta Machine";

    // Even written wrong
    public static final String TITLE_1 = "Wrrong";

    // Todo instead of song itself using song or album image for blob data
    public static final String SONG_IMAGE_1 = "soundsofuniverse.jpg";

    private static UUID createASampleSong(PersistenceManager pm) throws IOException
    {

        Song song1 = new Song();
        song1.setArtist(ARTIST_1);
        song1.setAlbum(ALBUM_1);
        song1.setTitle(TITLE_1);
        String imgPath = CLASSES_TARGET_DIRECTORY_PATH + SONG_IMAGE_1;
        byte[] byteBuffer = getSongImageAsByteArray(imgPath);
        song1.setData(byteBuffer);
        song1.setId(UUID.randomUUID());

        Song createdSong = pm.makePersistent(song1);
        return createdSong.getId();

    }

    public static final byte[] getSongImageAsByteArray(String filePath) throws IOException
    {
        File imgPath = new File(filePath);
        BufferedImage bufferedImage = ImageIO.read(imgPath);
        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        return data.getData();        

    }

    private static UUID createASamplePlayList(PersistenceManager pm)
    {
        Playlist playlist = new Playlist();
        playlist.setSongId(songId);
        playlist.setAlbum(ALBUM_1);
        playlist.setArtist(ARTIST_1);
        playlist.setTitle(TITLE_1);
        playlist.setId(UUID.randomUUID());
        playlist.setSongOrder(0);
        Playlist createdPlaylist = pm.makePersistent(playlist);
        return createdPlaylist.getId();
    }
    
    public static final void cleanupTables()
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            pm.newQuery(Song.class).deletePersistentAll();
            pm.newQuery(Playlist.class).deletePersistentAll();

        }
        finally
        {
            tx.commit();
            pm.close();
        }

    }

}
