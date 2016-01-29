package com.jfin.curve.factor;

import java.io.Serializable;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinCurveFactor;

public abstract class AbstractJFinCurveFactor implements Serializable, Comparable<AbstractJFinCurveFactor> {

	private static final long serialVersionUID = 6124232246132378012L;

	/** solved factor **/
	protected final double factor;

	/** factor maturity date **/
	protected final LocalDate factorMaturity;

	public AbstractJFinCurveFactor(final double factor, final LocalDate factorMaturity) {
		this.factor = factor;
		this.factorMaturity = factorMaturity;
	}

	public final double factor() {
		return factor;
	}

	public final LocalDate factorMaturity() {
		return factorMaturity;
	}

	/** discount factor equivalent of this factor **/
	public abstract double df();

	/** factor equivalent of the given discount factor **/
	public abstract double fromDf(double df);

	/** curve factor type **/
	public abstract JFinCurveFactor type();

	public int compareTo(AbstractJFinCurveFactor factor) {
		return factorMaturity().compareTo(factor.factorMaturity());
	}
}