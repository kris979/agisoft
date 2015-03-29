package regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PractiseRegex {
    
    public static String searchString = "123b2a.ba0xfdq..afgba";
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        PractiseRegex r = new PractiseRegex();
//        r.appendReplacement();
        r.testSplit();
//        r.testRegex();
//        r.testSearch();
//        r.testScanner();
    }
    
    void testRegex() {
    Pattern p = Pattern.compile("0[xX]([0-9,a-f,A-F]+)");
    Pattern p1 = Pattern.compile("\\.*");
    Matcher m = p.matcher(searchString);
    Matcher m1 = p1.matcher(searchString);
    System.out.println("Total: " + m.groupCount());
    while(m.find()) {
        System.out.printf("%s - %s - %d \n",m.start(),m.group(),Integer.parseInt(m.group(1),16));
    }
    while(m1.find()) {
        System.out.print(m1.group() + ",");
    }   
    }
    
    
    void testSearch() {
        String regex = "ba";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(searchString);
        while (m.find()) {                                        //find() is looking for a match
            System.out.println(m.start() + ":" + m.group());      //start() - index of the match, group() - string
        }
        System.out.println(m.matches());  //matches() checks if regex matches the whole seachString
        boolean match = p.matches(regex, searchString);   //does exacly the same match as above
        System.out.println(match);
    }
    
    void testScanner() {

    }
    
    void appendReplacement() {
        Pattern p = Pattern.compile("My");
        Matcher m = p.matcher("My dad and My mom");
        StringBuffer sb = new StringBuffer("Tralalalala ");
//        sb.append(m.replaceAll("Our"));
//         m.appendReplacement(sb, "My");
//        m.appendTail(sb);
        System.out.println(sb);
    }
    
    void testSplit() {
        
        String s = "abra cadabra";
        s = "aaaaaaaaaaaabbbbbbxxxxx";
        System.out.println(Arrays.toString(s.split("a")));
        System.out.println(Arrays.toString(s.split("a{3}")));
//        System.out.println(Arrays.toString(s.split("\s")));   - invalid escape sequence!
    }

}
