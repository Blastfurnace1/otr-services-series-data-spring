/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blastfurnace.otr.series;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.blastfurnace.otr.utils.UtilitiesApplicationTest;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertTrue;

/**
 * Integration Tests for Series Services
 *
 * @author Jim Blackson
 */
public class SeriesServiceApplicationTests extends UtilitiesApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(SeriesServiceApplicationTests.class); 
	
	@Test
	public void WhenSendingGetRequestToControllerReponseObject() throws Exception {
		log.info("Series Service Tests - Start");

		log.info("Series Service Tests - End");
	}
	
}
