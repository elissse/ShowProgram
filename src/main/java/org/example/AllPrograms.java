package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPrograms {
    private int size;
    private List<Program> allPrograms;
    private Map<String, List<Program>> mapOfPrograms;

    AllPrograms(List<String> programs) {
        allPrograms = new ArrayList<>();
        mapOfPrograms = new HashMap<>();
        initAllPrograms(programs);
        size = 0;
    }

    public Program get(int index) {
        return allPrograms.get(index);
    }

    public List<Program> getAllPrograms() {
        return allPrograms;
    }

    public Map<String, List<Program>> getMapOfPrograms() {
        return mapOfPrograms;
    }

    private void initAllPrograms(List<String> programs) {
        String channel = null;
        String name = null;
        String time = null;
        boolean flag = false;
        int chanels = 0;
        List<Program> programsOnThisChanel = new ArrayList<>();
        for (String s : programs) {
            if (s.charAt(0) == '#') {
                if (chanels >= 1) {
                    mapOfPrograms.put(channel, programsOnThisChanel);
                    programsOnThisChanel = new ArrayList<>();
                }
                channel = s.substring(0);
                chanels++;
            } else if (!flag) {
                time = s;
                flag = true;
            } else {
                name = s;
                Program program = new Program(channel, time, name);
                allPrograms.add(program);
                programsOnThisChanel.add(program);
                this.size++;
                flag = false;
            }
        }
    }

    private void sortAllPrograms() {
        int i = 0;
        boolean swapNeeded = true;
        while (i < allPrograms.size() - 1 && swapNeeded) {
            swapNeeded = false;
            for (int j = 1; j < allPrograms.size() - i; j++) {
                if (allPrograms.get(j - 1).getTime().compareTo(allPrograms.get(j).getTime()) >= 0) {
                    Program temp = allPrograms.get(j - 1);
                    allPrograms.set(j - 1, allPrograms.get(j));
                    allPrograms.set(j, temp);
                    swapNeeded = true;
                }
            }
            if (!swapNeeded) {
                break;
            }
            i++;
        }
    }

    public void allProgramsIncreasingTime() {
        sortAllPrograms();
        for (int i = 0; i < allPrograms.size(); i++) {
            System.out.println(allPrograms.get(i));
        }
    }

    public void allProgramsRightNow(BroadcastsTime time) {
        for (int i = 0; i < allPrograms.size(); i++) {
            if (allPrograms.get(i).getTime().before(time))
                System.out.println(allPrograms.get(i));
        }
    }

    public void allProgramsRightNowOnChannel(BroadcastsTime time, String channel) {
        for (int i = 0; i < allPrograms.size(); i++) {
            if (allPrograms.get(i).getTime().before(time) & allPrograms.get(i).getChannel().equals(channel))
                System.out.println(allPrograms.get(i));
        }
    }

    public void allProgramsInPeriodOfTime(BroadcastsTime time1, BroadcastsTime time2) {
        for (int i = 0; i < allPrograms.size(); i++) {
            if (allPrograms.get(i).getTime().between(time1, time2))
                System.out.println(allPrograms.get(i));
        }
    }

    public void allProgramsByName(String name) {
        for (int i = 0; i < allPrograms.size(); i++) {
            if (allPrograms.get(i).getName().equals(name))
                System.out.println(allPrograms.get(i));
        }
    }

    public int getSize() {
        return size;
    }


}
