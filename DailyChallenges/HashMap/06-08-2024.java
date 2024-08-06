// 3016. Minimum Number of Pushes to Type Word II

/*
Input: word = "aabbccddeeffgghhiiiiii"
Output: 24
Explanation: The remapped keypad given in the image provides the minimum cost.
"a" -> one push on key 2
"b" -> one push on key 3
"c" -> one push on key 4
"d" -> one push on key 5
"e" -> one push on key 6
"f" -> one push on key 7
"g" -> one push on key 8
"h" -> two pushes on key 9
"i" -> one push on key 9
Total cost is 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 2 * 2 + 6 * 1 = 24.
It can be shown that no other mapping can provide a lower cost.
*/

class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : word.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1);
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue().compareTo(a.getValue()));
        map = new LinkedHashMap<>();
        for(Map.Entry<Character, Integer> entry : list)
            map.put(entry.getKey(), entry.getValue());

        int count = 0;
        int res = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(count >= 8)
                res += (count/8 + 1) * entry.getValue();
            else
                res += entry.getValue();
            count++;
            System.out.println(res+" "+count);
        }
        return res;
    }
}
