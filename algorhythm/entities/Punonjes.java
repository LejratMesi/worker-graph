package algorhythm.entities;

public class Punonjes {
    private int id_punonjes;
    private String emerPunonjesi;
    private String mbiemerPunonjesi;
    private String email;
    private int prezenca;


    public Punonjes(int id_punonjes, String emerPunonjesi, String mbiemerPunonjesi, String email, int prezenca) {
        this.id_punonjes = id_punonjes;
        this.emerPunonjesi = emerPunonjesi;
        this.mbiemerPunonjesi = mbiemerPunonjesi;
        this.email = email;
        this.prezenca = prezenca;
    }

    public int getId_punonjes() {
        return id_punonjes;
    }

    public void setId_punonjes(int id_punonjes) {
        this.id_punonjes = id_punonjes;
    }

    public String getEmerPunonjesi() {
        return emerPunonjesi;
    }

    public void setEmerPunonjesi(String emerPunonjesi) {
        this.emerPunonjesi = emerPunonjesi;
    }

    public String getMbiemerPunonjesi() {
        return mbiemerPunonjesi;
    }

    public void setMbiemerPunonjesi(String mbiemerPunonjesi) {
        this.mbiemerPunonjesi = mbiemerPunonjesi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrezenca() {
        return prezenca;
    }

    public void setPrezenca(int prezenca) {
        this.prezenca = prezenca;
    }

    @Override
    public String toString() {
        return "Punonjes{" + "id_punonjes=" + id_punonjes + ", emerPunonjesi=" + emerPunonjesi + ", mbiemerPunonjesi=" + mbiemerPunonjesi + ", email=" + email + ", prezenca=" + prezenca + '}';
    }

}
