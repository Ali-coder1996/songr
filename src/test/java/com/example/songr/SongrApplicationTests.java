package com.example.songr;

import com.example.songr.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SongrApplicationTests {

	@Test
	public void contextLoads() {
		Album album=new Album("ali","ali",4,5,"http://ali.comskdw.js");
		assertEquals("ali",album.getTitle());
		assertEquals("ali",album.getArtist());
		assertEquals(5,album.getLength());
		assertEquals(4,album.getSongCount());
	}

}
