public class lc_12 {
    /**
     * 将这个数拆成千位、百位、十分、个位，然后分别枚举
     */
    public String intToRoman(int num) {
        String[] thousands=new String[]{"","M","MM","MMM"};
        String[] hundreds=new String[]{"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] tens=new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] ones=new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
        StringBuilder result=new StringBuilder();
        int thousand=num/1000;
        result.append(thousands[thousand]);
        int hundred=num%1000/100;
        result.append(hundreds[hundred]);
        int ten=num%100/10;
        result.append(tens[ten]);
        int one=num%10;
        result.append(ones[one]);
        return result.toString();
    }
}
