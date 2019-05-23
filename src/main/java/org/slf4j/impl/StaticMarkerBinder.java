package org.slf4j.impl;

import org.slf4j.IMarkerFactory;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.spi.MarkerFactoryBinder;

/**
 * Responsible for binding the {@link MarkerFactory}. This is used by the SLF4J API.
 *
 * @author Paul Mackinlay
 */
public class StaticMarkerBinder implements MarkerFactoryBinder {

	/**
	 * The single instance of this class.
	 */
	public static final StaticMarkerBinder INSTANCE = new StaticMarkerBinder();

	private final IMarkerFactory markerFactory;

	private StaticMarkerBinder() {
		this.markerFactory = new BasicMarkerFactory();
	}

	/**
	 * This method always returns a {@link BasicMarkerFactory}.
	 */
	@Override
	public IMarkerFactory getMarkerFactory() {
		return this.markerFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.spi.MarkerFactoryBinder#getMarkerFactoryClassStr()
	 */
	@Override
	public String getMarkerFactoryClassStr() {
		return BasicMarkerFactory.class.getName();
	}

}
