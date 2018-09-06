// my original idea was to sort all starts and ends of Intervals, then traverse, if ends is equal to starts, it will form a 
// interval, just like () (()() ()). but the point is to store value with its type(start or end). 
// In the solution below, it sorts starts and ends in two arrays. if at index i, start[i] > end[i - 1], ends is equal to starts,
// a interval is formed.
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n=intervals.size();
        int []start=new int[n];
        int []end=new int[n];
        for(int i=0;i<n;i++)
        {
            start[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> result=new ArrayList<>();
        for(int i=0,j=0;i<n;i++)
        {
            if(i==n-1||start[i+1]>end[i])
            {
                result.add(new Interval(start[j],end[i]));
                    j=i+1;
            }
        }
        return result;
    }
}

// sort intervals by its start. and merge.
class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
}
