package com.company;

import edu.duke.*;

public class Main {

    public static void main(String[] args) {

        WordLengths wordLengths = new WordLengths();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Running WordLengths
        FileResource textFile = new FileResource("romeo.txt");
        int [] counts = new int[31];
        wordLengths.countWordLengths(textFile, counts);

        // Running Caesar Ciper Decrypt
        CaesarCiperDecrypt decrypt = new CaesarCiperDecrypt();

        String secretMessage1Key = "Lgxit iwt btiwds strgneiIldZtnh xc iwt RpthpgQgtpztg raphh iwpi wph dct epgpbtitg, p Higxcv epgpbtitg cpbts tcrgneits iwpi gtegthtcih p Higxcv iwpi lph tcrgneits lxiw iwt ild ztn pavdgxiwb sxhrjhhts xc iwt egtkxdjh athhdc. Iwxh btiwds piitbeih id stitgbxct iwt ild ztnh jhts id tcrgnei iwt bthhpvt, egxcih iwt ild ztnh, pcs iwtc gtijgch iwt strgneits Higxcv lxiw iwdht ild ztnh. Bdgt hetrxuxrpaan, iwxh btiwds hwdjas:";
        String decrypted1Key = decrypt.decrypt1Key(secretMessage1Key);
        System.out.println(decrypted1Key);

        String secretMessage2Keys = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        String decrypted2Key = decrypt.decrypt2Key(secretMessage2Keys);
        System.out.println(decrypted2Key);

        String answer = decrypt.encryptTwoKeys(secretMessage2Keys,3,24);
        System.out.println("The answer is: " + answer);
    }
}
