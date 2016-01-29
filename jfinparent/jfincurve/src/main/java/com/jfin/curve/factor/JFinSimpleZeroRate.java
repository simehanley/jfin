package com.jfin.curve.factor;

import static com.jfin.common.JFinCommonConstants.ONE;
import static com.jfin.enums.JFinDcc.act365f;
import static com.jfin.utilities.JFinUtilitiesConstants.DCF_CALCULATOR;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinCurveFactor;
import com.jfin.enums.JFinDcc;

public class JFinSimpleZeroRate extends AbstractJFinCurveFactor {

	private static final long serialVersionUID = -6673258915999153726L;

	/** start date of the underlying rate **/
	protected final LocalDate referenceDate;

	/** day count basis **/
	protected final JFinDcc dcc;

	public JFinSimpleZeroRate(final LocalDate referenceDate, final LocalDate maturityDate, final double rate) {
		this(referenceDate, maturityDate, rate, act365f);
	}

	public JFinSimpleZeroRate(final LocalDate referenceDate, final LocalDate maturityDate, final double rate,
			final JFinDcc dcc) {
		super(rate, maturityDate);
		this.referenceDate = referenceDate;
		this.dcc = dcc;
	}

	public final LocalDate referenceDate() {
		return referenceDate;
	}

	public final JFinDcc dcc() {
		return dcc;
	}

	@Override
	public double df() {
		return ONE / (ONE + (factor * DCF_CALCULATOR.dcf(referenceDate, factorMaturity, dcc)));
	}

	@Override
	public double fromDf(double df) {
		return fromDf(referenceDate, factorMaturity, df, dcc);
	}

	public static double fromDf(final LocalDate start, final LocalDate end, final double df, final JFinDcc dcc) {
		return ((ONE / df) - ONE) / DCF_CALCULATOR.dcf(start, end, dcc);
	}

	@Override
	public JFinCurveFactor type() {
		return JFinCurveFactor.zero;
	}
}