package phonebook;
import java.util.*;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

    public class PhoneBook {
        private final Map<String, List<String>> phonebook;

        public PhoneBook(Map<String, List<String>> map) {
            phonebook = map;
        }

        public PhoneBook() {
            phonebook = new TreeMap<>();

        }

        public void add(String name, String phoneNumber) {
            List<String> listOfPhoneNumbers = Arrays.asList(phoneNumber);
            phonebook.put(name, listOfPhoneNumbers);
        }

        public void addAll(String name, String... phoneNumbers) {
            List<String> listOfPhoneNumbers = Arrays.asList(phoneNumbers);
            phonebook.put(name, listOfPhoneNumbers);
        }

        public void remove(String name) {
            phonebook.remove(name);
        }

        public Boolean hasEntry(String name) {
            if (phonebook.containsKey(name)) {
                return true;
            } else {
                return false;
            }
        }

        public List<String> lookup(String name) {
            List<String> result = null;
            for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
                if (entry.getKey().contains(name)) {
                    result = entry.getValue();
                }
            }
            return result;
        }

        public String reverseLookup(String phoneNumber) {
            String result = "";
            for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
                if (entry.getValue().contains(phoneNumber)) {
                    result = entry.getKey();
                }
            }
            return result;
        }


        public List<String> getAllContactNames() {
            List<String> allContactNames = new ArrayList<>();
            for (String name : phonebook.keySet()) {
                allContactNames.add(name);
            }
            return allContactNames;
        }

        public Map<String, List<String>> getMap() {
            return phonebook;
        }

        @Override
        public String toString() {
            return "PhoneBook{" +
                    "phonebook=" + phonebook +
                    '}';
        }


        public static void main(String[] args) {

            PhoneBook phonebook = new PhoneBook();
            //Test1 add
            phonebook.add("Derrick", "302-824-8479");
            phonebook.add("Police", "911");
            phonebook.add("John", "302-444-5555");
            phonebook.add("Carpet Cleaners", "1-800-789-4561");
            phonebook.add("Jenny","201-867-5309");
            phonebook.add("Optimum Triple Play","877-393-4448");
            phonebook.add("JG Wentworth", "877-CASH-NOW");
            System.out.println(phonebook);

            //Test2 addAll
            phonebook.addAll("Charles Work,Cell,Home", "30288815276", "2017894136", "1978643201");
            System.out.println(phonebook);

            //Test3 remove
            phonebook.remove("Charles Work,Cell,Home");
            System.out.println(phonebook);

            //Test#4 hasEntry
            System.out.println(phonebook.hasEntry("Cindy"));


            //Test#5 lookup
            System.out.println(phonebook.lookup("Carpet Cleaners"));

            //Test#6 reverseLookup
            System.out.println(phonebook.reverseLookup("3028248479"));

            //Test#7 getAllContactNames
            System.out.println(phonebook.getAllContactNames());

            //Test#8 getMap
            System.out.println(phonebook.getMap());
















        }




    }





