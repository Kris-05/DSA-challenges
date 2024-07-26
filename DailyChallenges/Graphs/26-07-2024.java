// 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

/*
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities 
fromi and toi, and given the integer distanceThreshold.
Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold,
If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
*/


class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];
        // To apply Floyd-Warshall Algo intialize cost matrix with +ve infinity
        // Given there is no self loop, so distance to itself is 0
        for(int i=0;i<n; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[i][i] = 0;
        }

        // construct cost graph from given values
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            cost[from][to] = weight;
            cost[to][from] = weight;
        }

        // Apply Floyd-Warshall algo
        for(int val=0; val<n; val++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(cost[i][val] == Integer.MAX_VALUE || cost[val][j] == Integer.MAX_VALUE)
                        continue;
                    cost[i][j] = Math.min(cost[i][j], cost[i][val] + cost[val][j]);
                }
            }
        }

        // check the no. of node with distance less than threshold
        int minCity = Integer.MAX_VALUE;
        int city = -1;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(cost[i][j] <= distanceThreshold)
                    count++;
            }
            if(count <= minCity){
                minCity = count;
                city = i;
            }
        }

        // return the highest
        return city;
    }
}
