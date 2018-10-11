// 先根据prerequisites构建矩阵，一维元素是pre，二维元素是ready。 在构建矩阵的过程中将每个course的入度记录下来。
// 没有入度的course说明不需要pre，可以直接上，所以count++，而以这些course为pre的course， 即所有 matrix[course][i] != 0 的i
// 也能够完成，循环遍历即可。能够完成的course放入queue中，当queue为空时，说明没有更多可以完成的课程了，则返回。
// 当有若干course组成环，则每个的入度都至少为1，则都不会放入queue中。
public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[][] matrix = new int[numCourses][numCourses]; // i -> j
    int[] indegree = new int[numCourses];
    
    for (int i=0; i<prerequisites.length; i++) {
        int ready = prerequisites[i][0];
        int pre = prerequisites[i][1];
        if (matrix[pre][ready] == 0)
            indegree[ready]++; //duplicate case
        matrix[pre][ready] = 1;
    }
    
    int count = 0;
    Queue<Integer> queue = new LinkedList();
    for (int i=0; i<indegree.length; i++) {
        if (indegree[i] == 0) queue.offer(i);
    }
    while (!queue.isEmpty()) {
        int course = queue.poll();
        count++;
        for (int i=0; i<numCourses; i++) {
            if (matrix[course][i] != 0) {
                if (--indegree[i] == 0)
                    queue.offer(i);
            }
        }
    }
    return count == numCourses;
}

// 判断所有边组成的图中有没有环即可。
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return true;
        if(prerequisites.length==0) return true;
        
        int[][] reverse=new int[prerequisites.length][2];
        for(int i=0; i<prerequisites.length; i++){
            reverse[i][1]=prerequisites[i][0];
            reverse[i][0]=prerequisites[i][1];
        }
        
        int[] parent1=new int[numCourses];
        int[] parent2=new int[numCourses];
        for(int i=0; i<numCourses; i++){
            parent1[i]=i;
            parent2[i]=i;
        }
        
        return noCircle(prerequisites, parent1)&&noCircle(reverse, parent2);
        
    }
    
    // parents中存放每个course的parent，循环遍历，判断是否有环存在，如果某个结点的parent是他自己，说明没有parent或者还没有设置
    private boolean noCircle(int[][] graph, int[] parents){
        for(int i=0; i<graph.length; i++){
            int parent=graph[i][0];
            int child=graph[i][1];
            while(child!=parents[child]){
                child=parents[child];
                if(child==parent) return false;
            }
            parents[parent]=child;
        }
        return true;
    }
}
