package com.jfin.curve.factor;

import static com.jfin.common.JFinCommonConstants.MINUS_ONE;
import static com.jfin.utilities.JFinUtilitiesConstants.DCF_CALCULATOR;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinCurveFactor;
import com.jfin.enums.JFinDcc;

public class JFinContinuousZeroRate extends JFinSimpleZeroRate {

	private static final long serialVersionUID = -9159716146266904422L;

	public JFinContinuousZeroRate(final LocalDate referenceDate, final LocalDate maturityDate, final double rate) {
		super(referenceDate, maturityDate, rate);
	}

	public JFinContinuousZeroRate(final LocalDate referenceDate, final LocalDate maturityDate, final double rate,
			final JFinDcc dcc) {
		super(referenceDate, maturityDate, rate, dcc);
	}

	@Override
	public double df() {
		return Math.exp(MINUS_ONE * factor * DCF_CALCULATOR.dcf(referenceDate, factorMaturity, dcc));
	}

	@Override
	public double fromDf(double df) {
		return fromDf(referenceDate, factorMaturity, df, dcc);
	}

	public static double fromDf(final LocalDate start, final LocalDate end, final double df, final JFinDcc dcc) {
		return (MINUS_ONE * Math.log(df)) / DCF_CALCULATOR.dcf(start, end, dcc);
	}

	@Override
	public JFinCurveFactor type() {
		return JFinCurveFactor.ccr;
	}
}