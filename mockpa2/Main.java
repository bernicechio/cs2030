import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Integer> groups = new ArrayList<>();
    static ArrayList<Mark> marks = new ArrayList<>();
    static ArrayList<Student> absentees = new ArrayList<>();
    //static HashMap<Integer, Integer> frequency = new HashMap<>();

    public static void main(String[] args) {
        while(scanner.hasNext()) {
            String input = scanner.next();
            if(input.equals("end")) {
                break;
            }
            String id = scanner.next();
            int group = scanner.nextInt();
            boolean added = false;
            if(groups.isEmpty()) {
                groups.add(group);
            } else {
                for(int g: groups) {
                    if(g == group) {
                        added = true;
                        break;
                    }
                }
                if(!added) {
                    groups.add(group);
                }
            }
            students.add(new Student(input, id, group));
        }
        while(scanner.hasNext()) {
            String input = scanner.next();
            if(input.equals("end")) {
                break;
            }
            int mark = scanner.nextInt();
            marks.add(new Mark(input, mark));
        }

        Collections.sort(groups);
        Collections.sort(marks, (Mark a, Mark b) -> {
            return a.getMark() - b.getMark();});
        System.out.print("Groups(" + groups.size() + "):[");
        StringBuilder output = new StringBuilder();
        output.append(groups.get(0));
        for(int i = 1; i < groups.size(); i++) {
            output.append(", ");
            output.append(groups.get(i));
        }
        System.out.print(output + "]");
        System.out.println("");
        for(Student s: students) {
            //System.out.println(s);
            int  mark = 0;
            boolean found = false;
            for(Mark m: marks) {
                if (m.getPlab().equals(s.getPlab())) {
                    found = true;
                    mark =  m.getMark();
                    break;
                }
            }
            if(!found) {
                absentees.add(s);
            }
            System.out.println(s + "," + mark);
        }
        System.out.println("List of absentees:");
        if(absentees.isEmpty()) {
            System.out.println("None");
        } else {
            for(Student a: absentees) {
                System.out.println(a);
            }
        }
        int min = marks.get(0).getMark();
        int max = marks.get(marks.size() -1).getMark();
        System.out.println("Mark frequency from " + min + " to " + max);
        ArrayList<Integer> frequency = new ArrayList<>();
        for(int i = 0; i <= max-min; i++) {
            frequency.add(i,0);
        }
        for(Mark m: marks) {
            frequency.set(m.getMark() - min, frequency.get(m.getMark()-min) +1);
        }
        for(int m = min; m <= max; m++) {
            System.out.println(m + " : " + frequency.get(m-min));
        }
        for(Student a: absentees) {
            students.remove(a);
        }

        for(int g: groups) {
            ArrayList<Student> tutorialGroup = new ArrayList<>();
            for(Student student: students) {
                if(student.getGroup() == g) {
                    tutorialGroup.add(student);
                }
            }

            if(!(tutorialGroup.isEmpty())) {
                System.out.println("Group #" + g + "...Mark frequency from " + min + " to " + max);
                ArrayList<Integer> groupFreq = new ArrayList<>();
                for(int i = 0; i <= max-min; i++) {
                    groupFreq.add(i,0);
                }
                for(Student s: tutorialGroup) {
                    String plab = s.getPlab();
                    for(Mark m: marks) {
                        if(m.getPlab().equals(plab)) {
                            groupFreq.set(m.getMark() - min, groupFreq.get(m.getMark() - min) + 1);
                            break;
                        }
                    }
                }
                for(int m = min; m <= max; m++) {
                    System.out.println(m + " : " + groupFreq.get(m-min));
                }
            }
        }

    }
}
