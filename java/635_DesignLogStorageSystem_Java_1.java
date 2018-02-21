class LogSystem {

    BST root;
    
    public LogSystem() {
        root = null;
    }
    
    public void put(int id, String timestamp) {
        if (root == null) {
            root = new BST(id, timestamp);
        }
        else {
            BST cur = root;
            
            while (true) {
                if (cur.timestamp.compareTo(timestamp) > 0) {
                    if (cur.left == null) {
                        cur.left = new BST(id, timestamp);
                        break;
                    }
                    else {
                        cur = cur.left;
                    }
                }
                else {
                    if (cur.right == null) {
                        cur.right = new BST(id, timestamp);
                        break;
                    }
                    else {
                        cur = cur.right;
                    }
                }
            }
        }
    }
    
    public void retrieve(String s, String e, int gra, List<Integer> result, BST cur) {
        if (cur != null) {
            if (cur.timestamp.substring(0, gra).compareTo(s.substring(0, gra)) < 0) {
                retrieve(s, e, gra, result, cur.right);
            }
            else if (cur.timestamp.substring(0, gra).compareTo(e.substring(0, gra)) > 0) {
                retrieve(s, e, gra, result, cur.left);
            }
            else {
                result.add(cur.id);
                retrieve(s, e, gra, result, cur.left);
                retrieve(s, e, gra, result, cur.right);
            }
        }
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> result = new ArrayList<>();
        
        if (gra.equals("Year")) {
            retrieve(s, e, 4, result, root);
        }
        else if (gra.equals("Month")) {
            retrieve(s, e, 7, result, root);
        }
        else if (gra.equals("Day")) {
            retrieve(s, e, 10, result, root);
        }
        else if (gra.equals("Hour")) {
            retrieve(s, e, 13, result, root);
        }
        else if (gra.equals("Minute")) {
            retrieve(s, e, 16, result, root);
        }
        else {
            retrieve(s, e, 19, result, root);
        }
        
        return result;
    }
}

class BST {
    int id;
    String timestamp;
    BST left;
    BST right;
    
    public BST(int id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
        this.left = null;
        this.right = null;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
