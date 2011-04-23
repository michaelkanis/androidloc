/*-----------------------------------------------------------------------+
 | net.skweez.androidloc
 |                                                                       |
 | $Id$            
 +-----------------------------------------------------------------------*/
package net.skweez.androidloc;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;

/**
 * file format
 * 
 * <pre>
 * header
 * unsigned short      db version, should be 1
 * unsigned short      number of records
 * 
 * short               length of key
 * x bytes             UTF string (key)
 * int                 accuracy
 * int                 confidence
 * double              latitude
 * double              longitude
 * long                reading time
 * 
 * key format
 * cell: mcc + ":" + mnc + ":" + lac + ":" + cid
 * wifi: mac address of AP
 * </pre>
 * 
 * @author mks
 * @author $Author: mks $
 * @version $Rev$
 * @levd.rating RED Hash:
 */
public class LocationCacheParser {

	public List<Record> parse(DataInputStream stream) throws IOException {
		return readDatabase(stream);
	}

	protected List<Record> readDatabase(DataInputStream stream)
			throws IOException {
		int dbVersion;
		int recordsCount;

		dbVersion = stream.readUnsignedShort();
		recordsCount = stream.readUnsignedShort();

		Assert.isTrue(dbVersion == 1, "Not a valid location cache file");

		List<Record> records = new ArrayList<Record>();

		try {
			while (true) {
				records.add(readRecord(stream));
			}
		} catch (EOFException eof) {
			// Alright, end of stream; nothing tbd
		} finally {
			stream.close();
		}

		Assert.isTrue(
				recordsCount == records.size(),
				"Actual number of records did not match the expected one. Maybe a corrupted input file?");

		return records;
	}

	protected Record readRecord(DataInputStream stream) throws IOException {
		short keyLength;
		int accuracy;
		int confidence;
		double latitude;
		double longitude;
		long time;

		keyLength = stream.readShort();
		stream.skipBytes(keyLength);
		accuracy = stream.readInt();
		confidence = stream.readInt();
		latitude = stream.readDouble();
		longitude = stream.readDouble();
		time = stream.readLong();

		return new Record(null, accuracy, confidence, latitude, longitude, time);
	}

}
