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
        echostring += arr.get(0);
        for(int i = 1; i < arr.size(); i++) {
            echostring += " " + arr.get(i);
        }
        e.add(echostring);
        return new Parser(e);
    }

    public Parser chop(int start, int end) {
        List<String> c = new LinkedList<>();
        for(String line: arr) {
            c.add(line.substring(start-1, end-1));
        }
        return new Parser(c);
    }

    //public

    @Override
    public String toString() {
        String output = "";
        output += arr.get(0);
        for(int i = 1; i < arr.size(); i++) {
            output += ("\n" + arr.get(i));
        }
        return output;
    }
}
