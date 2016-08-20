/**
 * Created by volkswagen1 on 11.08.2016.
 */
public class PersonModel {
    private String firstName;
    private String name;
    private String serName;
    public PersonModel(){}
    public PersonModel(String serName, String name,String firstName) {
        this.firstName = firstName;
        this.name = name;
        this.serName = serName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getSerName() {
        return serName;
    }
    public String toString(){
        return serName+" "+name+" "+firstName;
    }
}
