package com.numberconverter.number_converter;

import static java.lang.Math.abs;

public class Converter {

    private String binary;

    public void setBinaryString(int N) {
        if(N < 0)
        {
            throw new IllegalArgumentException("Only not negative number!");
        }
        this.binary = Integer.toBinaryString(N);
    }

    public void setOctalString(int N) {
        this.binary = Integer.toBinaryString(N);
        N = Integer.parseInt(this.binary,2);
        N = ~N;
        this.binary = Integer.toOctalString(abs(N));
    }

    public void setHexadecimalString(int N) {
        this.setBinaryString(N);

        String temp = new String();
        for(int i = this.binary.length()-1; i >= 0; i--)
        {
            temp += this.binary.charAt(i);
        }
        this.binary = Integer.toHexString(Integer.parseInt(temp,2)).toUpperCase();
    }

    public void setDecimalString(int N) {
        this.setBinaryString(N);

        int countOne = 0;
        String One = new String();
        String Zero = new String();
        int countZero = 0;
        Integer result;

        for(int i = 0; i < binary.length(); i++)
        {
            if(binary.charAt(i) == '1') {
                countOne++;
                One += '1';
            }
            else {
                countZero++;
                Zero += '0';
            }
        }
        StringBuilder temp = new StringBuilder();
        if(countOne > 0)
            temp.replace(0,countOne-1, One);
        if(countZero > 0)
            temp.replace(countOne, countOne+countZero-1, Zero);

        result = Integer.parseInt(temp.toString(),2);
        this.binary = result.toString();
    }

    public String getString() {
        return binary;
    }
}
