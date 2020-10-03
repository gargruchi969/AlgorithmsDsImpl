package findKthSmallestinBST;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode linkList;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right, TreeNode linkList) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	          this.linkList = linkList;
	      }
	  }

class Solution {
	public static void main(String[] args) {
		TreeNode node = insert(null,5);
		node = insert(node, 3);
		node = insert(node, 8);
		node = insert(node, 1);
		node = insert(node, 4);
		node = insert(node, 9);
		node = insert(node, 7);
		node = deleteNode(node, 5);
		node = deleteNode(node, 4);
		node = deleteNode(node, 1);
		int kthMin = kthSmallest(node, 4);
		System.out.print(kthMin);
		//buildTree(preorder, inorder);
	}
	public static TreeNode insert(TreeNode root, int key) {
		if(root==null) {
			TreeNode linkList = new TreeNode(key);
			return new TreeNode(key, null, null, linkList);
		}
		if(key>root.val) {
			root.right = insert(root.right, key);
			if(root.right.linkList.left==null&&root.right.linkList.right==null) {
				root.right.linkList.right = root.linkList.right;
				root.right.linkList.left = root.linkList;
				root.linkList.right = root.right.linkList;
			}
		}else if(key<root.val) {
			root.left = insert(root.left, key);
			if(root.left.linkList.left==null&&root.left.linkList.right==null) {
				root.left.linkList.left = root.linkList.left;
				root.left.linkList.right = root.linkList;
				root.linkList.left = root.left.linkList;
			}
		}
		return root;
	}
	
	public static TreeNode deleteNode(TreeNode root, int key) {
		if(root==null)
            return null;
        if(key==root.val)
        {
            if(root.right==null&&root.left==null) {
            	if(root.linkList.left!=null)
            		root.linkList.left.right = root.linkList.right;
            	if(root.linkList.right!=null)
            		root.linkList.right.left = root.linkList.left;
                return null;
            }
            else if(root.right==null) {
            	root.linkList.left.right = root.linkList.right;
            	root.linkList.right.left = root.linkList.left;
            	return root.left;
            }
            else if(root.left==null) {
            	root.linkList.left.right = root.linkList.right;
            	root.linkList.right.left = root.linkList.left;
                return root.right;
            }
           // TreeNode temp1 = root.left;
            //root = root.right;
            TreeNode temp = root.right;
            
            while(temp.left!=null)
            {
                temp = temp.left;   
            }
            root.val = temp.val;
            root.linkList.val = temp.val;
            root.right= deleteNode(root.right, root.val);
        }
        else if(key<root.val)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
	}
	
    public static int kthSmallest(TreeNode root, int k) {
       TreeNode link = root.linkList;
       while(link.left!=null) {
    	   link = link.left;
       }
       while(k>1) {
    	   link = link.right;
    	   k--;
       }
       return link.val;
    }
    
}