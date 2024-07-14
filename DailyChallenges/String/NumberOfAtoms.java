//726. Number of Atoms

/*
Given a string formula representing a chemical formula, return the count of each atom. Return the count of all elements as a string in the following form: 
the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), 
followed by its count (if that count is more than 1), and so on.

Input: formula = "Mg(OH)2"
Output: "H2MgO2"

Input: formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
*/



//.isDigit( char ) -> return true if it is a integer
//.isLowerCase( char ) -> return true if it is a lowercase char
//.valueOf( char ) -> convert char '(' to String "("
//.getKey() -> retrives key from pair
//.getValue() -> retrives key.value from pair
//.put(key, value) -> adds element to the Map
//.getOrDefault(keyFromMap, defaultValue) -> if present returns key.value else default
//.Entry<keyDT, valueDT> -> a simple wrapper class for pair to make sure that dataType suits
//.entrySet() -> makes us to access each <key, value> in that set

class Solution {
    public String countOfAtoms(String s) {
        int n = s.length();
        Stack<Pair<String, Integer>> stack = new Stack<>();
    //Step 1: Find the element counts
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(new Pair<>(String.valueOf(ch), 0)); 
            }
            else if(ch == ')'){
                int count = 0;
            //to find the value after ')'
                while(i+1 < n && Character.isDigit(s.charAt(i+1))){
                    count = count*10 + (s.charAt(i+1) - '0');
                    i++;
                }
                if(count == 0) 
                    count = 1;
            //multiply each element with that value until '(' is reached   
                Stack<Pair<String, Integer>> temp = new Stack<>();
                while(!stack.isEmpty() && !stack.peek().getKey().equals("(")){
                    Pair<String, Integer> p = stack.pop();
                    p = new Pair<>(p.getKey(), p.getValue()*count);
                    temp.push(p);
                }
            //then pop out the '('
                stack.pop(); 
            //again push them into main stack
                while(temp.size() > 0)
                    stack.push(temp.pop()); 
            }
            else{
                if(i+1 < n){
                    String ele = String.valueOf(ch);
                //check lowercase preceedings
                    if(Character.isLowerCase(s.charAt(i+1))){
                        ele += s.charAt(i+1);
                        i++;
                    }
                //get the no.of atoms for an element
                    int count = 0;
                    while(i+1 < n && Character.isDigit(s.charAt(i+1))){
                        count = count*10 + (s.charAt(i+1) - '0');
                        i++;
                    }
                    if(count == 0) 
                        count = 1;
                    stack.push(new Pair<>(ele, count));
                }
                else    
                    stack.push(new Pair<>(String.valueOf(ch), 1));
            }
        }
    //Step 2: Find the cummulative element count
        Map<String, Integer> arr = new TreeMap<>();
        while(!stack.isEmpty()){
            Pair<String, Integer> p = stack.pop();
            arr.put(p.getKey(), arr.getOrDefault(p.getKey(), 0) + p.getValue());
        }

    //Step 3: Sort them and convert to string
        StringBuilder str = new StringBuilder();
        for(Map.Entry<String, Integer> ele : arr.entrySet()){
            str.append(ele.getKey());
            if(ele.getValue() > 1)
                str.append(ele.getValue());
        }

    return str.toString();
    }
}
