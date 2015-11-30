class Solution {
public:
    bool isPowerOfTwo(int n) {
        bool is_power = false;
        while (n > 0) {
            if (n & 1) {
                if (is_power == false) {
                    is_power = ! is_power;
                }
                else {
                    return false;
                }
            }
            n = n >> 1;
        }
        return is_power;
    }
};