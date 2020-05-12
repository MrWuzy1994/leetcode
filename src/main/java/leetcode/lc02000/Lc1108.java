package leetcode.lc02000;

public class Lc1108 {
    private final String STR = "[.]";
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char ccc = address.charAt(i);
            if (ccc == '.'){
                sb.append(STR);
            }else{
                sb.append(ccc);
            }
        }
        return sb.toString();
    }
}
