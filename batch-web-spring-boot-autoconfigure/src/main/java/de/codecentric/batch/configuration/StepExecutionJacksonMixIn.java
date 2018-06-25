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

package de.codecentric.batch.configuration;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Jackson MixIn for {@link StepExecution} serialization. This MixIn excludes the {@link JobExecution} from being
 * serialized. This is due to the fact that it would cause a {@link StackOverflowError} due to a circular reference.
 * 
 * Taken from Spring XD.
 * 
 * @author Gunnar Hillert
 */
public abstract class StepExecutionJacksonMixIn {

	@JsonIgnore
	abstract JobExecution getJobExecution();
}
