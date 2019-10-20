package com.kramp.hub.level1.task.mediasearcher.service;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kramp.hub.level1.task.mediasearcher.model.Media;
import com.kramp.hub.level1.task.mediasearcher.model.MediaContentType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItuneServiceImplTest {

	@Autowired
	private ItuneService ituneServiceImpl;
   
	@Test
    public void getAlbumTestToCheckConnectivity() {
      List<Media> ituneContent = ituneServiceImpl.getAlbums(MediaContentType.ALBUM, "love", 10);
      assertThat(ituneContent.size() > 0, Matchers.is(true));
      assertThat(ituneContent.get(0).getArtistName(),Matchers.notNullValue());
      assertThat(ituneContent.get(0).getTitle(),Matchers.notNullValue());
      assertThat(ituneContent.get(0).getMediaType(), Matchers.is(MediaContentType.ALBUM));
    }
}
