/**
 * 
 */
package com.cache.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

/**
 * @author Govin
 *
 */
public class CacheEventLogger implements CacheEventListener<Object, Object> {
	
	final static private Logger logger = LogManager.getLogger(CacheEventLogger.class.getName());

	@Override
    public void onEvent(
      CacheEvent<? extends Object, ? extends Object> cacheEvent) {
		logger.info(cacheEvent.getKey().toString()+ cacheEvent.getOldValue()+ cacheEvent.getNewValue());
    }

}
