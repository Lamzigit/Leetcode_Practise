package 剑指offer.simple.替换空格;

public class Solution {
    public String replaceSpace(String s) {
        char[] cs = s.toCharArray();
        int count_space = 0;
        for(int i=0;i<cs.length;i++){
            if(cs[i] == ' '){
                count_space++;
            }
        }
        char[] new_cs = new char[cs.length + 2*count_space];
        int offset = 0;
        for(int i=0;i<cs.length;i++){
            if(cs[i] == 32){
                new_cs[i+offset] = '%';
                new_cs[i+offset+1] = '2';
                new_cs[i+offset+2] = '0';
                offset += 2;
            } else {
                new_cs[i+offset] = cs[i];
            }

        }
        return new String(new_cs);
    }

    public static void main(String[] args) {
        String in = "we are happy.";
        String re = new Solution().replaceSpace(in);
        System.out.println(re);
    }
}
