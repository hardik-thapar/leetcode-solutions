class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> child = new HashSet<>();

        for (int[] arr : descriptions) {

            map.putIfAbsent(arr[0], new TreeNode(arr[0]));
            map.putIfAbsent(arr[1], new TreeNode(arr[1]));

            if (arr[2] == 1)
                map.get(arr[0]).left = map.get(arr[1]);
            else
                map.get(arr[0]).right = map.get(arr[1]);

            child.add(arr[1]);
        }

        for (int val : map.keySet())
            if (!child.contains(val))
                return map.get(val);

        return null;
    }
}