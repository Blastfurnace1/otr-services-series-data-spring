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


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blastfurnace.otr.AppConfigTest;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertTrue;

/**
 * Integration Tests for Series Services
 *
 * @author Jim Blackson
 */
public class SeriesServiceApplicationTests extends AppConfigTest {

	private static final Logger log = LoggerFactory.getLogger(SeriesServiceApplicationTests.class); 
	
	@Test
	public void WhenSendingGetRequestToControllerReponseObject() throws Exception {
		log.info("Series Service Tests - Start");

		log.info("Series Service Tests - End");
	}
	
}
