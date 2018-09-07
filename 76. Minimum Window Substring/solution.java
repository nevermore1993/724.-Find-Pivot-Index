// slide window idea, use a map to keep track of all remaining char in t.  first move end to right, 
// minus map[c], if encounter a char in t, minus counter as well, indicate that we have found a needed char
// when counter == 0, means we have get all the chars in t, calcute distance. then move start to right, plus one to map[c], if 
// encounter a char in t, plus one to counter as well. indicate that we need to find a needed char.

class Solution {
	public String minWindow(String s, String t) {
		int[] map = new int[128];
		for (char c : t.toCharArray())
			map[c]++;
		int counter = t.length(), begin = 0, end = 0, distance = Integer.MAX_VALUE, head = 0;
		while (end < s.length()) {
			if (map[s.charAt(end++)]-- > 0)
				counter--;
			while (counter == 0) { // valid
				if (end - begin < distance)
					distance = end - (head = begin);
				if (map[s.charAt(begin++)]++ == 0)
					counter++; // make it invalid
			}
		}
		return distance == Integer.MAX_VALUE ? "" : s.substring(head, head + distance);
	}
}

// optimized brute force solution, result string must start and end with character in t, so skip all substring that is not 
// start or end with those character. the substring is disordered, so it must match every char in t, especially its count. 
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
    
        int[] min = new int[] {0, Integer.MAX_VALUE};
        for (int i = 0; i < s.length(); i++) {
            if (isContain(t, s.charAt(i))) {
                for (int j = i; j < s.length(); j++) {
                    if (isContain(t, s.charAt(j)) && (j - i + 1) >= t.length()) {
                        String temp = s.substring(i, j + 1);
                        boolean allContain = true;
                        String tt = new String(t);
                        for (int m = 0; m < t.length(); m++) {
                            if (isContain1(temp, tt.charAt(m)) != null) {
                                tt = isContain1(temp, tt.charAt(m));
                                m--;
                                continue;
                            } else 
                                allContain = false;
                        }
                        if (allContain) {
                            if (j - i <= min[1] - min[0]) {
                                min[0] = i;
                                min[1] = j;
                            } 
                        }
                    }
                }
            }
        }
        if (min[1] - min[0] == Integer.MAX_VALUE)
            return "";
        return s.substring(min[0], min[1] + 1);
    }
    
    public String isContain1(String t, char c) {
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == c) {
                StringBuilder sb = new StringBuilder();
                sb = sb.append(t.substring(0, i));
                sb = sb.append(t.substring(i + 1, t.length()));
                return sb.toString();
            }     
        }
        return null;
    }
    
    public boolean isContain(String t, char c) {
        String s = String.valueOf(c);
        return t.contains(s);
    }
}


// slide window 
import javafx.util.Pair;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();  
        int[] ans = {-1, 0, 0};

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;   
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
