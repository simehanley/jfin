package com.jfin.common.numeric;

import static com.jfin.common.numeric.JFinNumericUtilities.isCloseToZero;

import org.junit.Test;

import junit.framework.TestCase;

public class JFinNumericUtilitiesTest {

	@Test
	public void testIsCloseToZeroReturnsCorrectValueWithDefaultTolerance() {
		TestCase.assertTrue(isCloseToZero(1e-15));
	}

	@Test
	public void testIsCloseToZeroReturnsCorrectValueWithUserDefinedTolerance() {
		TestCase.assertTrue(isCloseToZero(-1e-10, 1e-8));
	}
}