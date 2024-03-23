package org.example;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:/Downloads/schedule.txt"));
        try {
            List<String> strings = new ArrayList<String>();
            String line = br.readLine();
            while (line != null) {
                strings.add(line);
                line = br.readLine();
            }
            AllPrograms allPrograms = new AllPrograms(strings);
//            List<Program> allProgramsList = allPrograms.getAllPrograms();
//            for (int i = 0; i < allProgramsList.size(); i++) {
//                System.out.println(allProgramsList.get(i));
//            }
//            Map<String, List<Program>> allProgramsMap = allPrograms.getMapOfPrograms();
//            for (String key : allProgramsMap.keySet()) {
//                System.out.println(key + ":" + allProgramsMap.get(key));
//            }
            allPrograms.allProgramsIncreasingTime();
            System.out.println();
            allPrograms.allProgramsRightNow(new BroadcastsTime("04:00"));
            System.out.println();
            allPrograms.allProgramsByName("Год телёнка");
            System.out.println();
            allPrograms.allProgramsRightNowOnChannel(new BroadcastsTime("18:20"), "#Первый");
            System.out.println();
            allPrograms.allProgramsInPeriodOfTime(new BroadcastsTime("18:20"), new BroadcastsTime("18:50"));

        } finally {
            br.close();
        }
    }
}