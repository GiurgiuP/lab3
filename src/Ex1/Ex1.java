package Ex1;

import java.nio.file.Files;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;



public class Ex1
{
    public static void main(String[] args)
    {
        List<Ex1_parabola> parabole=citireDinFisier("C:\\Users\\adigi\\IdeaProjects\\lab3\\src\\Ex1\\in.txt"); //Trebuie modficata calea ca sa mearga
        for(Ex1_parabola p:parabole)
        {
            System.out.println(p);
            double[]varf =p.varf();
            System.out.println("Varful:(" + varf[0]+", "+ varf[1] + ")");
        }
        if(parabole.size()>1)
        {
            Ex1_parabola p1=parabole.get(0);
            Ex1_parabola p2=parabole.get(1);
            double[] mijloc=p1.mijloc(p2);
            double lungime =p1.lungime(p2);
            System.out.println("Mijlocul este: ("+mijloc[0]+", "+mijloc[1]+")");
            System.out.println("Lungimea este: "+lungime);
        }


    }
    private static List<Ex1_parabola> citireDinFisier(String numeFisier)
    {
        List<Ex1_parabola> parabole=new ArrayList<>();
        try
        {
            List<String> linii=Files.readAllLines(Paths.get(numeFisier));
            for(String linie:linii)
            {
                String[]coef=linie.trim().split("\\s");
                int a=Integer.parseInt(coef[0]);
                int b=Integer.parseInt(coef[1]);
                int c=Integer.parseInt(coef[2]);
                parabole.add(new Ex1_parabola(a,b,c));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Eroare la conversie: "+ e.getMessage());
        }
        return parabole;
    }
}

