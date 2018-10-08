// for each point, use a hashmap to store all lines start with that point. key is x diff of two points, value is a map which
// key is y diff of two points, value is numbers of points of that line.
// why dont we just use gradient directly to map a line, because double gradient cant handle case
// [[0,0],[94911151,94911150],[94911152,94911151]], these two points are not on the same line, but their gradient in double are
// the same.
public class Solution{
        public int maxPoints(Point[] points) {
        	if (points==null) return 0;
        	if (points.length<=2) return points.length;
        	
        	Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        	int result=0;
        	for (int i=0;i<points.length;i++){ 
        		map.clear();
        		int overlap=0,max=0;
        		for (int j=i+1;j<points.length;j++){
        			int x=points[j].x-points[i].x;
        			int y=points[j].y-points[i].y;
        			if (x==0&&y==0){
        				overlap++;
        				continue;
        			}
        			int gcd=generateGCD(x,y);
        			if (gcd!=0){
        				x/=gcd;
        				y/=gcd;
        			}
        			
        			if (map.containsKey(x)){
        				if (map.get(x).containsKey(y)){
        					map.get(x).put(y, map.get(x).get(y)+1);
        				}else{
        					map.get(x).put(y, 1);
        				}   					
        			}else{
        				Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        				m.put(y, 1);
        				map.put(x, m);
        			}
        			max=Math.max(max, map.get(x).get(y));
        		}
        		result=Math.max(result, max+overlap+1);
        	}
        	return result;
        	
        	
        }
        private int generateGCD(int a,int b){
    
        	if (b==0) return a;
        	else return generateGCD(b,a%b);
        	
        }
    }
    
// use gradient solution, cant handle cases like [[0,0],[94911151,94911150],[94911152,94911151]], but works fine with 
all the other ordinary cases   
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
}

// best accepted java solution, however it can pass the case like [[1,1],[1,2],[2,2],[2,3],[3,3]].
// it fails to consider many conditions, it only forms line from two adjacent element, it should consider all lines
// forms from each two elements.
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int maxNum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int repeat = 0;
            Point p1 = points[i];
            Point p2 = points[i+1];
            long dx = p1.x - p2.x;
            long dy = p1.y - p2.y;
            if (dx == 0 && dy == 0) {
                for (int j = 0; j < points.length; j++) {
                    if (points[j].x == p1.x && points[j].y == p2.y) {
                        repeat++;
                    }
                }
            }
            else {
                for (int j = 0; j < points.length; j++) {
                    if (dx * (points[j].y - p1.y) == dy * (points[j].x - p1.x)) {
                        repeat++;
                    }
                }
            }
            maxNum = Math.max(maxNum, repeat);
        }
        return maxNum;
    }
}

// below is the modified version, one loop is added to include all lines formed with each two points
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int maxNum = 0;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            for (int k = 0; k < points.length; k++) {
                int repeat = 0;
                Point p2 = points[k];
                long dx = p1.x - p2.x;
                long dy = p1.y - p2.y;
                if (dx == 0 && dy == 0) {
                    for (int j = 0; j < points.length; j++) {
                        if (points[j].x == p1.x && points[j].y == p2.y) {
                            repeat++;
                        }
                    }
                }
                else {
                    for (int j = 0; j < points.length; j++) {
                        if (dx * (points[j].y - p1.y) == dy * (points[j].x - p1.x)) {
                            repeat++;
                        }
                    }
                }
                maxNum = Math.max(maxNum, repeat);
            }
        }
        return maxNum;
    }
}
