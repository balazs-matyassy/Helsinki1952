package hu.progmatic;

public class Eredmeny {
    private int helyezes;
    private int letszam;
    private String sportag;
    private String versenyszam;

    public Eredmeny() {

    }

    // "belső" factory
    // 2. inicializálás
    public Eredmeny(String line) {
        String[] parts = line.split(" ");

        // helyezes = Integer.parseInt(parts[0]);
        // letszam = Integer.parseInt(parts[1]);
        // sportag = parts[2];
        // versenyszam = parts[3];

        setHelyezes(Integer.parseInt(parts[0]));
        setLetszam(Integer.parseInt(parts[1]));
        setSportag(parts[2]);
        setVersenyszam(parts[3]);
    }

    public int getHelyezes() {
        return helyezes;
    }

    public void setHelyezes(int helyezes) {
        this.helyezes = helyezes;
    }

    public int getLetszam() {
        return letszam;
    }

    public void setLetszam(int letszam) {
        this.letszam = letszam;
    }

    public String getSportag() {
        return sportag;
    }

    public void setSportag(String sportag) {
        this.sportag = sportag;
    }

    public String getVersenyszam() {
        return versenyszam;
    }

    public void setVersenyszam(String versenyszam) {
        this.versenyszam = versenyszam;
    }

    public int getOlimpiaiPont() {
        switch (helyezes) {
            case 1:
                return 7;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return getHelyezes()
                + " " + getOlimpiaiPont()
                + " " + getLetszam()
                + " " + getSportag()
                + " " + getVersenyszam();
    }
}
