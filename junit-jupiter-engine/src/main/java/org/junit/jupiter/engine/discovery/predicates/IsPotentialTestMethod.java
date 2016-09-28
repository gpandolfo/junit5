/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.jupiter.engine.discovery.predicates;

import org.junit.platform.commons.meta.API;

import java.lang.reflect.Method;
import java.util.function.Predicate;

import static org.junit.platform.commons.meta.API.Usage.Internal;
import static org.junit.platform.commons.util.ReflectionUtils.isAbstract;
import static org.junit.platform.commons.util.ReflectionUtils.isPrivate;
import static org.junit.platform.commons.util.ReflectionUtils.isStatic;

/**
 * Test if a method is a potential JUnit Jupiter test method
 * even if it does not have a {@code @Test} annotation.
 *
 * @since 5.0
 */
@API(Internal)
public class IsPotentialTestMethod implements Predicate<Method> {

	@Override
	public boolean test(Method candidate) {
		//please do not collapse into single return
		if (isStatic(candidate))
			return false;
		if (isPrivate(candidate))
			return false;
		if (isAbstract(candidate))
			return false;
		return true;
	}

}
