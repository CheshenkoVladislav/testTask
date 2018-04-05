public class Student {
    //fields
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String group;
    private String date;
    //getters
    public String getName() {return name;}
    public int getId() {return id;}
    public String getSurname() {return surname;}
    public String getPatronymic() {return patronymic;}
    public String getGroup() {return group;}
    public String getDate() {return date;}
    //constructor
    public Student(int id, String name, String surname, String patronymic, String date,String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.date = date;
        this.group = group;
    }
}
