package com.southgis.book.grokkingAlgorithms.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author 王军
 * @description 贪心算法
 * @date 2021/6/22 11:13
 */
public class Greedy {
    private static List<Meeting> list;

    static {
        list=new ArrayList<>();
    }

    public static int greedyAlgorithm() {
        Collections.sort(list);
        System.out.println("\n");
        list.forEach(System.out::println);
        System.out.println("\n");
        System.out.println("贪心算法后会议安排");

        int total=0;
        int currentMeetingEndTime=0;
        for (Meeting meeting : list) {
            if(meeting.getStartTime()>=currentMeetingEndTime){
                currentMeetingEndTime=meeting.getEndTime();
                total++;
            }
        }
        return total;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //先输入总数
        int total=scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int startTime=scanner.nextInt();
            int endTime=scanner.nextInt();
            Meeting meeting=new Meeting().setNumber(i).setStartTime(startTime).setEndTime(endTime);
            list.add(meeting);
        }
        list.forEach(System.out::println);

        System.out.println(Greedy.greedyAlgorithm());

    }
}

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
class Meeting implements Comparable<Meeting> {
    private int number;
    private int startTime;
    private int endTime;


    @Override
    public int compareTo(Meeting o) {
        //按照会议结束时间升序排列
        return Integer.compare(this.endTime, o.endTime);
    }
}