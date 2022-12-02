package Assgnment_Lession_3;

public class Les_3_2 {
    public char minChar (String str) {
        char min = str.charAt(0);
        if (str.length() == 1) {
            return str.charAt(0);
        } else {
            char temp = minChar(str.substring(1));
            if (min > temp) {
                min = temp;
            }
        }
        return min;
    }

    public void main(String[] args) {
        String str = "akel";
        System.out.println(minChar(str));
    }
}
