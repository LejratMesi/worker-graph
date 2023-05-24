package algorhythm.entities;

public class Punonjes {
    private int id;
    private String emer;
    private String mbiemer;
    private String email;
    private int prezenca;

    public Punonjes(int id, String emer, String mbiemer, String email, int prezenca) {
        this.id = id;
        this.emer = emer;
        this.mbiemer = mbiemer;
        this.email = email;
        this.prezenca = prezenca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMbiemer() {
        return mbiemer;
    }

    public void setMbiemer(String mbiemer) {
        this.mbiemer = mbiemer;
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
        return "Punonjes{" + "id=" + id + ", emer=" + emer + ", mbiemer=" + mbiemer + ", email=" + email + ", prezenca=" + prezenca + '}';
    }

}
