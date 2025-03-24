import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort the meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int mergedStart = meetings[0][0];
        int mergedEnd = meetings[0][1];
        int meetingDays = 0;

        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            // If intervals overlap, merge them
            if (start <= mergedEnd) {
                mergedEnd = Math.max(mergedEnd, end);
            } else {
                // Add the number of days in the merged interval
                meetingDays += mergedEnd - mergedStart + 1;

                // Start a new interval
                mergedStart = start;
                mergedEnd = end;
            }
        }

        // Add the last merged interval's days
        meetingDays += mergedEnd - mergedStart + 1;

        // Available days are total days minus the days with meetings
        return days - meetingDays;
    }
}