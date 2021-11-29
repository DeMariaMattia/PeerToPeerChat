package peertopeer;


public class DatiCondivisi {

    String IP,Username="";
    char Stato='C';
    public void Set(String ip,String Usern){
        IP=ip;
        Username=Usern;
    }
    public String getIP(){
        return IP;
    }

    public String getUsername() {
        return Username;
    }

    public void setStato(char Stato) {
        this.Stato = Stato;
    }
    
    public char getStato() {
        return Stato;
    }

}
