/*
 *  Copyright (C) 2011 Michael Kanis
 *  
 *  This file is part of AndroidLoc.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.skweez.androidloc;

import java.util.Date;

import net.skweez.geoclipse.map.GeoPoint;

/**
 * @author Michael Kanis
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
