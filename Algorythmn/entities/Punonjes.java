package Algorythmn.entities;

public class Punonjes {
 private int id_punonjes;
 private String emerpunonjesi;
 private String mbiemerpunonjesi;
 private String email;
 private int prezenca;

    public Punonjes(int id_punonjes) {
        this.id_punonjes = id_punonjes;
    }

    public Punonjes(String emerpunonjesi) {
        this.emerpunonjesi = emerpunonjesi;
    }

    public int getId_punonjes() {
        return id_punonjes;
    }

    public void setId_punonjes(int id_punonjes) {
        this.id_punonjes = id_punonjes;
    }

    public String getMbiemerpunonjesi() {
        return mbiemerpunonjesi;
    }

    public void setMbiemerpunonjesi(String mbiemerpunonjesi) {
        this.mbiemerpunonjesi = mbiemerpunonjesi;
    }

    public String getEmerpunonjesi() {
        return emerpunonjesi;
    }

    public void setEmerpunonjesi(String emerpunonjesi) {
        this.emerpunonjesi = emerpunonjesi;
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
        return "Punonjes{" +
                "id_punonjes=" + id_punonjes +
                ", emerpunonjesi='" + emerpunonjesi + '\'' +
                ", mbiemerpunonjesi='" + mbiemerpunonjesi + '\'' +
                ", email='" + email + '\'' +
                ", prezenca=" + prezenca +
                '}';
    }

}
