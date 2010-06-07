package org.loststone.toodledo.util;

/**
 * Static classes and singletons are bad. God kills a kitten every time you code one of those.
 * Really. What's the problem in instantiating an object?
 * @author lant
 *
 */
public class TextEncoder {
	public String encode(String original) {
		// whattodo re: Unicode?!
		return original
			.replace("&", "%26")
			.replace(";", "%3B")
			.replace(" ", "%20")
			.replace("<", "%3C")
			.replace(">", "%3E")
			.replace("'", "%27")
			.replace("\"", "%22")
			.replace("\r", "%0D")
			.replace("\n", "%0A");
	}
}
