package mergeintervals;

import java.util.Arrays;

public class MeetingRoomsII {

    public static void main(String[] args) {
        int[] start = {2, 9, 6};
        int[] end  = {4,10, 12};

        System.out.println(minMeetingRooms(start,end));
    }

    public static int minMeetingRooms(int[] start, int[] end) {
        // code here
        int n = start.length;
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0, maxRooms = 0;
        int i = 0, j = 0;
        while(i < n) {
            if(start[i] < end[j]){
                rooms++;
                maxRooms = Math.max(maxRooms,rooms);
                i++;
            }else{
                rooms--;
                j++;
            }
        }

        return maxRooms;
    }
}
