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

	@Test
	public void testRoundWithDefaultDecimalPlacesWorksAsRequired() {
		double rounded = JFinNumericUtilities.round(94.56789);
		TestCase.assertTrue(rounded - 94.57 < 1e-15);
	}

	@Test
	public void testRoundWithUserDefinedDecimalPlacesWorksAsRequired() {
		double rounded = JFinNumericUtilities.round(94.567891234, 6);
		TestCase.assertTrue(rounded - 94.567891 < 1e-15);
	}
}