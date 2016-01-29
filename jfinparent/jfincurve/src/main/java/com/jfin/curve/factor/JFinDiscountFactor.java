package com.jfin.curve.factor;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinCurveFactor;

public class JFinDiscountFactor extends AbstractJFinCurveFactor {

	private static final long serialVersionUID = -3186943290068239784L;

	public JFinDiscountFactor(final LocalDate maturityDate, final double df) {
		super(df, maturityDate);
	}

	@Override
	public double df() {
		return factor();
	}

	@Override
	public double fromDf(double df) {
		return df;
	}

	@Override
	public JFinCurveFactor type() {
		return JFinCurveFactor.df;
	}
}