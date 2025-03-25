package se.thinkcode.recursion;

public class Family {
    public void print(Person person) {
        System.out.println(person.barn());

        if (person.mor() != null) {
            print(person.mor());
        }

        if (person.far() != null) {
            print(person.far());
        }
    }

    public String longestName(Person person, String barn) {
        System.out.println(person.barn());

        String longest;
        if (person.barn().length() > barn.length()) {
            longest = person.barn();
        } else {
            longest = barn;
        }

        if (person.mor() != null) {
            longestName(person.mor(), longest);
        }

        if (person.far() != null) {
            return longestName(person.far(), longest);
        }

        return longest;
    }

    public String longestName(Person myFamily) {
        if (myFamily == null) {
            return "";
        }

        String currentName = myFamily.barn();
        String longestInMor = longestName(myFamily.mor());
        String longestInFar = longestName(myFamily.far());

        String longestInFamily = currentName;
        if (longestInMor.length() > longestInFamily.length()) {
            longestInFamily = longestInMor;
        }
        if (longestInFar.length() > longestInFamily.length()) {
            longestInFamily = longestInFar;
        }

        return longestInFamily;
    }
}
