/*
 * Copyright 2018 the original author or authors.
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
package de.codecentric.batch.metrics;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import io.micrometer.core.instrument.MeterRegistry;

@Aspect
public class ListenerMetricsAspect extends AbstractBatchMetricsAspect {

	public ListenerMetricsAspect(MeterRegistry meterRegistry) {
		super(meterRegistry);
	}

	@Around("execution(* org.springframework.batch.core.ItemWriteListener.beforeWrite(..))")
	public Object profileListenerMethods(ProceedingJoinPoint pjp) throws Throwable {
		return profileMethod(pjp);
	}

}
