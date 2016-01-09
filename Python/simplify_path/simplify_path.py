# slow
# TODO: no nested while loop

class Solution(object):
    def simplifyPath(self, path):
        i, j, stack = 0, 0, []
        while i < len(path):
            while i < len(path) and path[i] == '/':
                i += 1
            if i == len(path):
                break
            j = i
            while j < len(path) and path[j] != '/':
                j += 1
            if path[i:j] == '..':
                if stack != []:
                    stack = stack[:-1]
            elif path[i:j] == '.':
                i = j + 1
                continue
            else:
                stack.append(path[i:j])
            i = j + 1
        path = ''
        for s in stack:
            path += '/'
            path += s
        path = '/' if path == '' else path
        return path


