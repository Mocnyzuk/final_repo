package pl.accenture.szkolka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private int age;
    private boolean isMen;

    public void saySomething(){
        System.out.println("Hello my name is: " + name + " " + lastName);
    }

    public static void printPersonList(List<Person> persons){
        for(Person p : persons){
            if(p instanceof CollegeStudent){
                System.out.print("I'm a college student\n\tmsg: ");
                ((CollegeStudent) p).doYourHomeWork();
            }else if(p instanceof PrivateTeacher){
                System.out.print("I'm a private teacher\n\tmsg: ");
                ((PrivateTeacher) p).teachStudents();
            }else if(p instanceof PublicTeacher) {
                System.out.print("I'm a public teacher\n\tmsg: ");
                ((PublicTeacher) p).teachStudents();
            } else if(p instanceof PrimaryStudent){
                System.out.print("I'm a primary student\n\tmsg: ");
                ((PrimaryStudent) p).doYourHomeWork();
            }else {
                System.out.println("I'm just a " + p.name + " " + p.lastName);
            }
        }
    }
}
