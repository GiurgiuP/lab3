package Ex1;

public class Ex1_parabola
{
    Integer a,b,c;
    public Ex1_parabola(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double[]varf()
    {
        double x=b/(2.0*a);
        double y=(4*a*c-b*b)/(4.0*a);
        return new double[]{x,y};
    }

    @Override
    public String toString()
    {
        return "f(x)= "+a+"x^2+ "+b+"x+ " +c;
    }

    public double[]mijloc(Ex1_parabola p)
    {
        double [] thisVarf=this.varf();
        double [] thisVarf2=p.varf();
        double xMijloc=(thisVarf[0]+thisVarf2[0])/2;
        double yMijloc=(thisVarf[1]+thisVarf2[1])/2;
        return new double[]{xMijloc,yMijloc};
    }

    public double lungime(Ex1_parabola p)
    {
        double [] thisVarf=this.varf();
        double [] thisVarf2=p.varf();
        return Math.hypot(thisVarf[0]-thisVarf2[0],thisVarf[1]-thisVarf2[1]);
    }



}

