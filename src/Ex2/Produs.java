package Ex2;

import java.time.LocalDate;

public class Produs
{
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataexpi;

    public Produs(String denumire, double pret, int cantitate, LocalDate dataexpi)
    {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataexpi = dataexpi;
    }

    public String getDenumire()
    {
        return denumire;
    }
    public void setDenumire(String denumire)
    {
        this.denumire = denumire;
    }
    public double getPret()
    {
        return pret;
    }

    public void setPret(double pret)
    {
        this.pret = pret;
    }
    public int getCantitate()
    {
        return cantitate;
    }
    public void setCantitate(int cantitate)
    {
        this.cantitate = cantitate;
    }
    public LocalDate getDataexpi()
    {
        return dataexpi;
    }
    public void setDataexpi(LocalDate dataexpi)
    {
        this.dataexpi = dataexpi;
    }

    @Override
    public String toString()
    {
     return "Produs: " + denumire + ", Pret: " + pret + ", Cantitate: " + cantitate + ", Data expirare: " + dataexpi;
    }

    public boolean esteExpirat() {
        return LocalDate.now().isAfter(dataexpi);
    }
}
