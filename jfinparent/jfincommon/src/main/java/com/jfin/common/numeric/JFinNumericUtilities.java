package com.jfin.common.numeric;

import static java.math.RoundingMode.HALF_EVEN;

import java.math.BigDecimal;

public final class JFinNumericUtilities {

	private static final double ZERO_TOLERANCE = 1e-12;

	private static final int DECIMAL_PLACES = 2;

	private JFinNumericUtilities() {
	}

	public static boolean isCloseToZero(final double value) {
		return isCloseToZero(value, ZERO_TOLERANCE);
	}

	public static boolean isCloseToZero(final double value, final double tolerance) {
		return Math.abs(value) < tolerance;
	}

	public static double round(final double value) {
		return round(value, DECIMAL_PLACES);
	}

	public static double round(final double value, final int decimalPlaces) {
		return new BigDecimal(value).setScale(decimalPlaces, HALF_EVEN).doubleValue();
	}
}