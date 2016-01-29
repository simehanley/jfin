package com.jfin.utilities.dcf;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.jfin.enums.JFinDcc;

public final class JFinDcfCalculator {

	public double dcf(final LocalDate start, final LocalDate end, JFinDcc dcc) {
		switch (dcc) {
		case act360:
			return dcfAct360(start, end);
		default:
			return dcfAct365f(start, end);
		}
	}

	private double dcfAct365f(final LocalDate start, final LocalDate end) {
		return Days.daysBetween(start, end).getDays() / 365.;
	}

	private double dcfAct360(final LocalDate start, final LocalDate end) {
		return Days.daysBetween(start, end).getDays() / 360.;
	}
}