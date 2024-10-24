package Ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Magazin
{
    private static double incasari=0;

    public static double getIncasari()
    {
        return incasari;
    }

    public static List<Produs> citireCSV(String numeFisier)
    {
        List<Produs> produse = new ArrayList<Produs>();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try(BufferedReader br= Files.newBufferedReader(Paths.get(numeFisier)))
        {
            String line;
            while ((line=br.readLine()) !=null)
            {
                String[] date=line.split(",");
                String nume=date[0];
                double pret=Double.parseDouble(date[1]);
                int cantitate=Integer.parseInt(date[2]);
                LocalDate dataexpi=LocalDate.parse(date[3],formatter);
                produse.add(new Produs(nume,pret,cantitate,dataexpi));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return produse;
    }

    public static void afisareProd(List<Produs> produse)
    {
        for(Produs produs:produse)
        {
            System.out.println(produs);
        }
    }

    public static void afisareExpirate(List<Produs> produse)
    {
        for(Produs produs:produse)
        {
            if(produs.esteExpirat())
            {
                System.out.println(produs);
            }
        }
    }
    public static void vanzare(List<Produs> produse,String numeProd,int cantitatevand)
    {
        for(Produs produs:produse)
        {
            if(produs.getDenumire().equals(numeProd))
            {
                if(produs.getCantitate()>=cantitatevand)
                {
                    produs.setCantitate(produs.getCantitate()-cantitatevand);
                    incasari+=produs.getPret()*cantitatevand;
                    System.out.println("S-a vandut "+cantitatevand+"din"+numeProd);

                    if(produs.getCantitate()==0)
                    {
                        produse.remove(produs);
                    }

                }
                else
                {
                    System.out.println("Stoc insuficient");
                }
            }break;
        }
    }

    public static void afisareMinim(List<Produs> produse)
    {
        Produs minim=null;
        for(Produs produs:produse)
        {
            if(minim==null||produs.getPret()<minim.getPret())
            {
                minim=produs;
            }
        }
        if(minim!=null)
        {
            System.out.println("Produsul cu pretul minim : "+minim);
        }
    }

    public static void afisareSub(List<Produs> produse,int cantmin,String numeFisier)
    {
        try(FileWriter writer=new FileWriter(numeFisier))
        {
            for(Produs produs:produse)
            {
                if(produs.getCantitate()<cantmin)
                {
                    writer.write(produs.getDenumire()+","+produs.getPret()+","+produs.getCantitate()+","+produs.getDataexpi()+"\n");
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
