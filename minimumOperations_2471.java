/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class minimumOperations_2471 {
    public int minimumOperations(TreeNode root) {
        // use a queue for level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while(!q.isEmpty()) {
            // store values at every level in a list
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.remove();
                list.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            // calculate total ans by adding up swaps from every level
            ans+=minSwaps(list);
        }
        return ans;
    }

    private int minSwaps(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>(list);
        // sort a cloned list to determine positions.
        Collections.sort(sorted);
        // store new positions in a map
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i=0; i<sorted.size(); i++) {
            pos.put(sorted.get(i), i);
        }

        int i=0, swaps=0;
        while(i<list.size()) {
            // get the position of an element in the sorted array
            int index = pos.get(list.get(i));
            // if position is same as the actual position, move on to the next index
            if(index==i) i+=1;
            // swap the elements at actual and derived positions
            else {
                int temp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, temp);
                swaps+=1;
            }
        }
        return swaps;
    }
}
