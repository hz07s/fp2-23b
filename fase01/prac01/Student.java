public class Student{
    private String name, birth, address, locality, telephone, email;
    private int cui, semester;

    public Student(String[] data){
        setCUI(Integer.parseInt(data[0]));
        setName(data[1]);
        setBirth(data[2]);
        setAddress(data[3]);
        setLocality(data[4]);
        setTelephone(data[5]);
        setEmail(data[6]);
        setSemester(Integer.parseInt(data[7]));
    }
    
    public void setCUI(int i){
        cui = i;
    }
    public void setName(String n){
        name = n;
    }
    public void setBirth(String dob){
        birth = dob;
    }
    public void setAddress(String add){
        address = add;
    }
    public void setLocality(String loc){
        locality = loc;
    }
    public void setTelephone(String t){
        telephone = t;
    }
    public void setEmail(String e){
        email = e;
    }
    public void setSemester(int s){
        semester = s;
    }


    public int getCUI(){
        return cui;
    }
    public String getName(){
        return name;
    }
    public String getBirth(){
        return birth;
    }
    public String getAddress(){
        return address;
    }
    public String getLocality(){
        return locality;
    }
    public String getTelephone(){
        return telephone;
    }
    public String getEmail(){
        return email;
    }
    public int getSemester(){
        return semester;
    }
    

    public String toString(){
        if (name.length() < 24){
            return name + "\t\t\t" + telephone;
        } else if (name.length() < 33){
            return name + "\t\t" + telephone;
        }
        return name + "\t" + telephone;
    }
}