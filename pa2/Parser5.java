import java.util.*;

public class Parser {
    List<String> arr;

    public Parser(List<String> arr) {
        this.arr = arr;
    }

    public static Parser parse(List<String> lines) {
        List<String> p = new LinkedList<>();
        for(String line: lines) {
            p.add(line);
        }
        return new Parser(p);
    }

    public Parser linecount() {
        List<String> lc = new LinkedList<>();
        lc.add(((Integer)this.arr.size()).toString());
        return new Parser(lc);
    }

    public Parser wordcount() {
        ArrayList<String> split = new ArrayList<>();
        for(String a: arr) {
            if(a.equals("")) {
                continue;
            }
            String[] test = a.split(" ");
            for(String t: test) {
                if(t.equals("")) {
                    continue;
                }
                split.add(t);
            }
        }
        Integer count = split.size();
        List<String> wc = new LinkedList<>();
        wc.add(count.toString());
        return new Parser(wc);
    }

    public Parser grab(String str) {
        List<String> g = new LinkedList<>();
        for(String line: arr) {
            if(line.contains((CharSequence) str)) {
                g.add(line);
            }
        }
        return new Parser(g);
    }

    public Parser echo() {
        List<String> e = new LinkedList<>();
        String echostring = "";
        boolean first = true;
        for(int i = 0; i < arr.size(); i++) {
            String[] test = arr.get(i).split(" ");
            for(String t: test) {
                if (t.equals("")) {
                    continue;
                }
                if(first) {
                    echostring += t;
                    first = false;
                } else {
                    echostring += " " + t;
                }
            }
        }
        e.add(echostring);
        return new Parser(e);
    }

    public Parser chop(int start, int end) {
        ArrayList<String> c = new ArrayList<>();
        for(String a: arr) {
            if (start == 0) {
                if(a.length() >= end) {
                    c.add(a.substring(0, end));
                } else {
                    c.add(a.substring(0));
                }
            } else if(start <= a.length()) {
                if(a.length() >= end) {
                    c.add(a.substring(start-1, end));
                } else {
                    c.add(a.substring(start-1));
                }
            } else {
                c.add("");
            }
        }

        return new Parser(c);
    }

    public Parser shuffle() {
        ArrayList<String> s = new ArrayList<>();
        for(String a: arr) {    //rotates
            String[] words = a.split(" ");
            String shuffledLine = "";
            boolean firstWord = true;
            for(String word: words) {
                if(word.equals("")) {
                    continue;
                }
                char[] chars = word.toCharArray();
                if(chars.length < 4) { //if word is only one letter or 2 /3 letters
                    if(firstWord) {
                        shuffledLine += word;
                        firstWord = false;
                    } else {
                        shuffledLine += " " + word;
                    }
                    continue;
                }
                char last = chars[1];
                if (last == '\'') { //edge case: t'was
                    last = chars[2];
                    for(int i = 2; i < chars.length - 2; i++) {
                        chars[i] = chars[i+1];
                    }
                    chars[chars.length -2] = last;
                } else if(chars[chars.length - 2] == '\'' || chars[chars.length -1] == '.' || chars[chars.length -1] == ',') {
                    for(int i = 1; i < chars.length - 3; i++) {
                        chars[i] = chars[i+1];
                    }
                    chars[chars.length - 3] = last;
                } else {
                    for(int i = 1; i < chars.length - 2; i++) {
                        chars[i] = chars[i+1];
                    }
                    chars[chars.length -2] = last;
                }

                if(firstWord) {
                    shuffledLine += new String(chars);
                    firstWord = false;
                } else {
                    shuffledLine += " " + new String(chars);
                }
            }
            s.add(shuffledLine);
        }
        return new Parser(s);
    }

    @Override
    public String toString() {
        String output = "";
        boolean first = true;
        for(String a: arr) {
            if(first) {
                output += a;
                first = false;
            } else {
                output += "\n" + a;
            }
        }
        return output;
        /*output += arr.get(0);
        for(int i = 1; i < arr.size(); i++) {
            output += ("\n" + arr.get(i));
        }
        return output;*/
    }
}
