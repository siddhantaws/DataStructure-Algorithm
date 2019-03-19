package com.wellsfargo.data_structure.stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FormMinimumNumberFromGivenSequence {

    private String seq;

    public FormMinimumNumberFromGivenSequence(String seq) {
        this.seq = seq;
    }

    public String getMinNumberForPattern() {// Returns minimum number made from given sequence without repeating digits
        int n = seq.length();
        if (n >= 9)
            return "-1";
        char result[] = new char[n + 1];
        int count = 1;
        // The loop runs for each input character as well as one additional time for assigning rank to each remaining characters
        for (int i = 0; i <= n; i++) {
            if (i == n || seq.charAt(i) == 'I') {
                for (int j = i - 1; j >= -1; j--) {
                    result[j + 1] = (char) ((int) '0' + count++);
                    if (j >= 0 && seq.charAt(j) == 'I')
                        break;
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        FormMinimumNumberFromGivenSequence minimumNumberFromGivenSequence =new FormMinimumNumberFromGivenSequence("DIDI");
        System.out.println(minimumNumberFromGivenSequence.getMinNumberForPattern());
    }
}
