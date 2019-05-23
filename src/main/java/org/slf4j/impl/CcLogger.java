package org.slf4j.impl;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.Marker;

import com.fimtra.util.Log;
import com.fimtra.util.StringUtils;

/**
 * A slf4j {@link org.slf4j.Logger} implementation for ClearConnects {@link Log} utility.
 * Only INFO, WARN and ERROR levels are enabled and {@link Marker}s are not supported.
 *
 * @author Paul Mackinlay
 */
public class CcLogger implements Logger {

	private static final String emptyText = "";
	private static final String newLine = "\n";
	private static final String pipe = "|";
	private final String name;

	/**
	 * @param name
	 *                 should be Clazz.class.getName()
	 */
	public CcLogger(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isTraceEnabled() {
		return false;
	}

	@Override
	public void trace(String msg) {
		// do nothing
	}

	@Override
	public void trace(String format, Object arg) {
		// do nothing
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		// do nothing
	}

	@Override
	public void trace(String format, Object... arguments) {
		// do nothing
	}

	@Override
	public void trace(String msg, Throwable t) {
		// do nothing
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return false;
	}

	@Override
	public void trace(Marker marker, String msg) {
		// do nothing
	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		// do nothing
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		// do nothing
	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		// do nothing
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		// do nothing
	}

	@Override
	public boolean isDebugEnabled() {
		return false;
	}

	@Override
	public void debug(String msg) {
		// do nothing
	}

	@Override
	public void debug(String format, Object arg) {
		// do nothing
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		// do nothing
	}

	@Override
	public void debug(String format, Object... arguments) {
		// do nothing
	}

	@Override
	public void debug(String msg, Throwable t) {
		// do nothing
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return false;
	}

	@Override
	public void debug(Marker marker, String msg) {
		// do nothing
	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		// do nothing
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		// do nothing
	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		// do nothing
	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		// do nothing
	}

	@Override
	public boolean isInfoEnabled() {
		return true;
	}

	@Override
	public void info(String msg) {
		log(msg);
	}

	@Override
	public void info(String format, Object arg) {
		info(getMsgForObj(arg));
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		info(format, asArray(arg1, arg2));
	}

	@Override
	public void info(String format, Object... arguments) {
		info(getMsgForObjs(arguments));
	}

	@Override
	public void info(String msg, Throwable t) {
		info(getMsgWithThrowable(msg, t));
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return false;
	}

	@Override
	public void info(Marker marker, String msg) {
		// do nothing
	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		// do nothing
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		// do nothing
	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {
		// do nothing
	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		// do nothing
	}

	@Override
	public boolean isWarnEnabled() {
		return true;
	}

	@Override
	public void warn(String msg) {
		log(msg);
	}

	@Override
	public void warn(String format, Object arg) {
		warn(getMsgForObj(arg));
	}

	@Override
	public void warn(String format, Object... arguments) {
		warn(getMsgForObjs(arguments));
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		warn(format, asArray(arg1, arg2));
	}

	@Override
	public void warn(String msg, Throwable t) {
		warn(getMsgWithThrowable(msg, t));
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return false;
	}

	@Override
	public void warn(Marker marker, String msg) {
		// do nothing
	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		// do nothing
	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		// do nothing
	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		// do nothing
	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		// do nothing
	}

	@Override
	public boolean isErrorEnabled() {
		return true;
	}

	@Override
	public void error(String msg) {
		log(msg);
	}

	@Override
	public void error(String format, Object arg) {
		error(getMsgForObj(arg));
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		error(format, asArray(arg1, arg2));
	}

	@Override
	public void error(String format, Object... arguments) {
		error(getMsgForObjs(arguments));
	}

	@Override
	public void error(String msg, Throwable t) {
		error(getMsgWithThrowable(msg, t));
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return false;
	}

	@Override
	public void error(Marker marker, String msg) {
		// do nothing
	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		// do nothing
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		// do nothing
	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {
		// do nothing
	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		// do nothing
	}

	private void log(String msg) {
		if (!StringUtils.isEmpty(msg)) {
			Class<?> clazz = getClass();
			try {
				clazz = Class.forName(this.name);
			} catch (ClassNotFoundException e) {
				// ignore
			}
			Log.log(clazz, msg);
		}
	}

	private static String getStackTrace(Throwable t) {
		StringWriter writer = new StringWriter();
		PrintWriter printer = new PrintWriter(writer, true);
		t.printStackTrace(printer);
		return writer.getBuffer().toString();
	}

	private static String getMsgWithThrowable(String msg, Throwable t) {
		return new StringBuilder(msg).append(newLine).append(getStackTrace(t)).toString();
	}

	private static String getMsgForObjs(Object... arguments) {
		if (arguments != null && arguments.length > 0) {
			StringBuilder msgBuilder = new StringBuilder();
			for (Object argument : arguments) {
				msgBuilder.append(getMsgForObj(argument)).append(pipe);
			}
			return msgBuilder.toString();
		}
		return emptyText;
	}

	private static String getMsgForObj(Object arg) {
		return String.valueOf(arg);
	}

	private static Object[] asArray(Object arg1, Object arg2) {
		return new Object[] { arg1, arg2 };
	}
}
