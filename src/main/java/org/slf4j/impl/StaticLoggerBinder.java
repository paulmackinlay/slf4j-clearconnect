package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * Responsible for binding the {@link CcLoggerFactory}. This is used by the SLF4J API.
 *
 * @author Paul Mackinlay
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {

	/**
	 * The version of the SLF4J API this implementation is compiled against.
	 */
	// to avoid constant folding by the compiler, this field must not be final
	public static String REQUESTED_API_VERSION = "1.7.13";
	private static final StaticLoggerBinder INSTANCE = new StaticLoggerBinder();
	private static final String loggerFactoryClassName = CcLoggerFactory.class.getName();
	private final ILoggerFactory loggerFactory;

	// Note this is called by the SLF4J API
	public static final StaticLoggerBinder getSingleton() {
		return INSTANCE;
	}

	private StaticLoggerBinder() {
		this.loggerFactory = new CcLoggerFactory();
	}

	@Override
	public ILoggerFactory getLoggerFactory() {
		return this.loggerFactory;
	}

	@Override
	public String getLoggerFactoryClassStr() {
		return loggerFactoryClassName;
	}

}
