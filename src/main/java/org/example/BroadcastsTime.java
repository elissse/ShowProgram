package org.example;

import java.util.List;
import java.util.Map;

public class BroadcastsTime implements Comparable {
    private byte hour;
    private byte minutes;

    BroadcastsTime(String time) {
        String[] timeee = time.split(":");
        this.hour = Byte.parseByte(timeee[0]);
        this.minutes = Byte.parseByte(timeee[1]);
    }

    public byte hour() {
        return hour;
    }

    public byte minutes() {
        return minutes;
    }

    public boolean after(BroadcastsTime t) {
        return compareTo(t) <= 0;
    }

    public boolean before(BroadcastsTime t) {
        return compareTo(t) >= 0;
    }

    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return compareTo(t1) >= 0 & compareTo(t2) <= 0;
    }

    @Override
    public int compareTo(Object o) {
        BroadcastsTime broadcastsTime = (BroadcastsTime) o;
        if ((hour() > broadcastsTime.hour()) || (hour() == broadcastsTime.hour() & minutes() > broadcastsTime.minutes())) {
            return 1;
        } else if (hour() == broadcastsTime.hour() & minutes() == broadcastsTime.minutes()) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return hour + ":" + minutes;
    }
}
