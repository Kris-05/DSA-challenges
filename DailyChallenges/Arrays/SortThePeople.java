//2418. Sort the People

/*
For each index i, names[i] and heights[i] denote the name and height of the ith person.
Return names sorted in descending order by the people's heights.
*/

class Solution {
    static class People{
        String name;
        int height;

        People(String name, int height){
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        List<People> person = new ArrayList<>();
        for(int i=0; i<n; i++){
            person.add(new People(names[i], heights[i]));
        }

        person.sort((a,b) -> b.height - a.height);
        String[] res = new String[n];
        int i=0;
        for(People p : person){
            res[i] = p.name;
            i++;
        }
        return res;
    }
}
