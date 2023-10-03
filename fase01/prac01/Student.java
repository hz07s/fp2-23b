public class Student{
    private String email, name, lastNameF, lastNameM;
    private boolean gender, status;
    private int cui, dateBirth;

    public Student(String[] data){
        setCUI(data[0]);
        setEmail(data[1]);
        setName(data[2]);
        setLastNameF(data[3]);
        setLastNameM(data[4]);
        setDateBirth(data[5]);
        setGender(data[6]);
        setStatus(data[7]);
    }
    
    public void setCUI(String c){
        cui = Integer.parseInt(c.substring(c.length()-8));        
    }
    public void setEmail(String e){
        email = e;
    }
    public void setName(String n){
        name = n;
    }
    public void setLastNameF(String nf){
        lastNameF = nf;
    }
    public void setLastNameM(String nm){
        lastNameM = nm;
    }
    public void setDateBirth(String db){
        String cadena = db.substring(0, 4) + db.substring(5, 7) + db.substring(8);
        int date = Integer.parseInt(cadena);
        dateBirth = date;
    }
    public void setGender(String gn){
        if (gn.equals("1")){
            gender = true; 
        } else {
            gender = false;
        }
    }
    public void setStatus(String st){
        if(st.equals("1")){
            status = true;
        } else {
            status = false;
        }
    }
    

    public int getCUI(){
        return cui;
    }
    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public String getLastNameF(){
        return lastNameF;
    }
    public String getLastNameM(){
        return lastNameM;
    }
    public int getDateBirth(){
        return dateBirth;
    }
    public boolean getGender(){
        return gender;
    }
    public boolean getStatus(){
        return status;
    }
    
    
    
    public String toString(){
        String birth = (dateBirth/10000) + "-" + ((dateBirth/100)%100) + "-" + (dateBirth%100);
        String gn = gender?"Masculino":"Femenino";
        String st = status?"activo":"inhabilitado";
        return cui + "\t" + email + "\t" + name + "\t" + lastNameF + "\t" + lastNameM + "\t" + birth + "\t" + gn + "\t" + st;
    }
}