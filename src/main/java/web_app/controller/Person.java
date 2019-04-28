package web_app.controller;
import java.io.Serializable;


public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String age;
    private String gender;

    public Person(){ }
    public Person(String firstname, String middlename, String lastname, String age, String gender){

        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname=lastname;
        this.age = age;
    this.gender=gender;
        /*switch (gender) {
            case "male":
                this.gender = Gender.MALE;
                break;
            case "MALE":
                this.gender = Gender.MALE;
                break;
            case "M":
                this.gender = Gender.MALE;
                break;
            case "female":
                this.gender = Gender.FEMALE;
                break;
            case "FEMALE":
                this.gender = Gender.FEMALE;
                break;
            case "F":
                this.gender = Gender.FEMALE;
                break;
            default:
                this.gender=null;
                break;
        }*/
    }
    public Person(int id, String firstname, String middlename, String lastname, String age, String gender){

        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname=lastname;
        this.age = age;
       this.gender=gender;
        /* switch (gender){
            case "male" :this.gender=Gender.MALE;
            case "female":this.gender=Gender.FEMALE;
        }*/ }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String  getGender(){return gender;}
    public void setGender(String gender){this.gender=gender;}

    /*enum Gender {

        MALE("male"),FEMALE("female");

        private String gen;
        Gender(String gen){
            this.gen = gen;
        }
        public String getGen(){ return gen;}
        }*/
    }