class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if root is None:
            return []
        else:
            path_list = []
            self.binaryTreePathsHelper(root, "", path_list)
            return path_list
        
    def binaryTreePathsHelper(self, root, curr_path, path_list):
        """
        :type root: TreeNode
        :type path_list[str]
        """
        if root is None:
            return
        if curr_path == "":
            curr_path += str(root.val)
        else:
            curr_path += "->" + str(root.val)
        if root.left is None and root.right is None:
            path_list.append(curr_path)
            return
        self.binaryTreePathsHelper(root.left, curr_path, path_list)
        self.binaryTreePathsHelper(root.right, curr_path, path_list)