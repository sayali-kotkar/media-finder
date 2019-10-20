package com.kramp.hub.level1.task.mediasearcher.service;

import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kramp.hub.level1.task.mediasearcher.model.Media;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MediaFinderServiceImplTest {
  
	@Autowired
	private MediaFinderService mediaFinderService;
	
	@Test
	public void getMediaBasicTest() throws InterruptedException, ExecutionException {
		List<Media> mediaContents = mediaFinderService.getMedia("love", 5);
	    assertThat(mediaContents.size() > 2, Matchers.is(true));
	    
	    List<Media> distinctMedia = mediaContents.stream().filter(distinctByKey(m -> m.getMediaType().label()))
	    		.collect( Collectors.toList());
	    assertThat(distinctMedia.size() == 2, Matchers.is(true));
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
	{
	    Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
