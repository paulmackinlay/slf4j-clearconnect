package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * Responsible for building {@link Logger} using the {@link CcLogger}
 * implementation.
 *
 * @author Paul Mackinlay
 */
public class CcLoggerFactory implements ILoggerFactory {

    // key: name (String), value: a Log4jLoggerAdapter;
    ConcurrentMap<String, Logger> loggers;

    public CcLoggerFactory() {
        this.loggers = new ConcurrentHashMap<>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.slf4j.ILoggerFactory#getLogger(java.lang.String)
     */
    @Override
    public Logger getLogger(String name) {
        return this.loggers.computeIfAbsent(name, key -> new CcLogger(key));
    }
}
