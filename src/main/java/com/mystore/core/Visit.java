package com.mystore.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "visits")
@NamedQueries({
        @NamedQuery(
                name = "com.mystore.core.Visit.findAll",
                query = "SELECT v FROM Visit v"
        )
})
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "user_id", nullable = false)
    private long userId;
    
    @Column(name = "beacon_id", nullable = false)
    private String beaconId;
    
    @Column(name = "major", nullable = false)
    private int major;
    
    @Column(name = "minor", nullable = false)
	private int minor;
    
    @Column(name = "rssi", nullable = false)
	private int rssi;
    
    @Column(name = "proximity", nullable = false)
	private int proximity;
    
    @Column(name = "timestamp", nullable = false)
	private Date timestamp;
	    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBeaconId() {
		return beaconId;
	}

	public void setBeaconId(String beaconId) {
		this.beaconId = beaconId;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public int getRssi() {
		return rssi;
	}

	public void setRssi(int rssi) {
		this.rssi = rssi;
	}

	public int getProximity() {
		return proximity;
	}

	public void setProximity(int proximity) {
		this.proximity = proximity;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beaconId == null) ? 0 : beaconId.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + major;
		result = prime * result + minor;
		result = prime * result + proximity;
		result = prime * result + rssi;
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		if (beaconId == null) {
			if (other.beaconId != null)
				return false;
		} else if (!beaconId.equals(other.beaconId))
			return false;
		if (id != other.id)
			return false;
		if (major != other.major)
			return false;
		if (minor != other.minor)
			return false;
		if (proximity != other.proximity)
			return false;
		if (rssi != other.rssi)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}
