/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        
        for (int i = 0; i < employees.size(); ++i) {
            map.put(employees.get(i).id, employees.get(i));
        }
        
        return getImportance(map, id);
    }
    
    public int getImportance(Map<Integer, Employee> map, int id) {
        int result = 0;
        
        result += map.get(id).importance;
        
        for (int i = 0; i < map.get(id).subordinates.size(); i++) {
            result += getImportance(map, map.get(id).subordinates.get(i));
        }
        
        return result;
    }
}
