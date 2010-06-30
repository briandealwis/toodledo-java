package org.loststone.toodledo.util;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

/**
 * Static classes and singletons are bad. God kills a kitten every time you code one of those.
 * Really. What's the problem in instantiating an object?
 * @author lant
 *
 */
public class TextEncoder {
	URLCodec codec = new URLCodec();	// defaults to UTF8, which should be ok?
	
	public String encode(String original) {
		try {
			return codec.encode(original);
		} catch(EncoderException e) {
			// shouldn't happen
			e.printStackTrace();
			return original;	//???
		}
	}
}
