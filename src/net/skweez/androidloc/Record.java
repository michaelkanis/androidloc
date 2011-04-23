/*-----------------------------------------------------------------------+
 | net.skweez.androidloc
 |                                                                       |
 | $Id$            
 +-----------------------------------------------------------------------*/
package net.skweez.androidloc;

import java.util.Date;

import net.skweez.geoclipse.map.GeoPoint;

/**
 * @author mks
 * @author $Author: mks $
 * @version $Rev$
 * @levd.rating RED Hash:
 */
public class Record {

	private final String key;

	private final int accuracy;

	private final int confidence;

	private final GeoPoint location;

	private final Date time;

	/** Creates a new record with the given parameters. */
	public Record(String key, int accuracy, int confidence, double latitude,
			double longitude, long time) {

		this.key = key;
		this.accuracy = accuracy;
		this.confidence = confidence;
		this.location = new GeoPoint(latitude, longitude);
		this.time = new Date(time);
	}

	/** Returns accuracy. */
	public int getAccuracy() {
		return accuracy;
	}

	/** Returns confidence. */
	public int getConfidence() {
		return confidence;
	}

	/** Returns location. */
	public GeoPoint getLocation() {
		return location;
	}

	/** Returns time. */
	public Date getTime() {
		return time;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("{");

		b.append("accuracy:").append(accuracy).append(",");
		b.append("confidence:").append(confidence).append(",");
		b.append("location:").append(location).append(",");
		b.append("time:").append(time).append("}");

		return b.toString();
	}

}
