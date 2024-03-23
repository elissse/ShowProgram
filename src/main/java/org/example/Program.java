package org.example;

public class Program {
    private String channel;
    private BroadcastsTime time;
    private String name;
    Program(String channel, String time, String name) {
        this.channel = channel;
        this.time = new BroadcastsTime(time);
        this.name = name;
    }
    public BroadcastsTime getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return channel + " " + time + " " + name;
    }
}
