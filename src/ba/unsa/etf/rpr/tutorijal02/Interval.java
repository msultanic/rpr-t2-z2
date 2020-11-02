package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetak, kraj;
    boolean pocetnaPripada, krajPripada;

    public Interval(double v, double v1, boolean b, boolean b1) {
        if (v1<v)
            throw new IllegalArgumentException();
        pocetak=v; kraj=v1; pocetnaPripada=b; krajPripada=b1;
    }
    public Interval(){
        pocetak=0; kraj=0; pocetnaPripada=false; krajPripada=false;
    }
    public static Interval intersect(Interval i, Interval i2) {
        Interval finalni=new Interval();
        Interval prvi = new Interval();
        Interval drugi = new Interval();
        if(i.pocetak > i2.pocetak){ // sad znamo sigurno ko je prvi, a ko drugi
            prvi=i2; drugi=i;}
        else{
            prvi=i; drugi=i2;
        }
        if(prvi.kraj>drugi.pocetak){
            finalni.pocetak=drugi.pocetak;
            if(drugi.pocetnaPripada==true)
                finalni.pocetnaPripada=true;
            else
                finalni.pocetnaPripada=false;
        }
        else if(prvi.kraj<drugi.pocetak){ //nema presjeka
            return finalni;
        }
        else if(prvi.kraj==drugi.pocetak){
            if(prvi.krajPripada==false || drugi.pocetnaPripada==false)
                return finalni;
            finalni.pocetak=prvi.kraj;
            finalni.kraj=prvi.kraj;
            finalni.pocetnaPripada=true;
            finalni.krajPripada=true;
        }

        if(prvi.kraj<drugi.kraj){ //šta ako su jednaki!
            finalni.kraj=prvi.kraj;
            if(prvi.krajPripada==true)
                finalni.krajPripada=true;
            else
                finalni.krajPripada=false;
        }
        else if(prvi.kraj>drugi.kraj){
            finalni.kraj=drugi.kraj;
            if(drugi.krajPripada==true)
                finalni.krajPripada=true;
            else
                finalni.krajPripada=false;
        }
        else if(prvi.kraj==drugi.kraj){
            finalni.kraj=prvi.kraj;
            if(prvi.krajPripada==true && drugi.krajPripada==true) {
                finalni.krajPripada=true;
            }
            else
                finalni.krajPripada=false;
        }
        return finalni;
    }

    @Override
    public String toString() {
        String s=new String();
        if(this.isNull())
            return "()";
        if(pocetnaPripada)
            s=s+'[';
        else
            s=s+'(';
        s=s+pocetak+','+kraj;
        if(krajPripada)
            s=s+']';
        else
            s=s+')';
        return s;
    }

    @Override
    public boolean equals(Object i2){
        if(i2 instanceof Interval){
            Interval i =(Interval)i2;
            if(this.pocetak==i.pocetak && this.kraj==i.kraj && this.pocetnaPripada==i.pocetnaPripada && this.krajPripada==i.krajPripada)
                return true;
            return false;
        }
        return false;
    }

    public boolean isIn(double v) {
        if(v>pocetak && v<kraj)
            return true;
        if(v==pocetak && pocetnaPripada==true)
            return true;
        if(v==kraj && krajPripada==true)
            return true;
        return false;
    }
    public boolean isNull() {
        if(pocetak==0 && kraj==0 && pocetnaPripada==false && krajPripada==false)
            return true;
        return false;
    }
    public Interval intersect(Interval second) {
        Interval finalni=new Interval();
        Interval prvi = new Interval();
        Interval drugi = new Interval();
        if(this.pocetak > second.pocetak){ // sad znamo sigurno ko je prvi, a ko drugi
            prvi=second; drugi=this;}
        else{
            prvi=this; drugi=second;
        }
        if(prvi.kraj>drugi.pocetak){
            finalni.pocetak=drugi.pocetak;
            if(drugi.pocetnaPripada==true)
                finalni.pocetnaPripada=true;
            else
                finalni.pocetnaPripada=false;
        }
        else if(prvi.kraj<drugi.pocetak){ //nema presjeka
            return finalni;
        }
        else if(prvi.kraj==drugi.pocetak){
            if(prvi.krajPripada==false || drugi.pocetnaPripada==false)
                return finalni;
            finalni.pocetak=prvi.kraj;
            finalni.kraj=prvi.kraj;
            finalni.pocetnaPripada=true;
            finalni.krajPripada=true;
        }

        if(prvi.kraj<drugi.kraj){ //šta ako su jednaki!
            finalni.kraj=prvi.kraj;
            if(prvi.krajPripada==true)
                finalni.krajPripada=true;
            else
                finalni.krajPripada=false;
        }
        else if(prvi.kraj>drugi.kraj){
            finalni.kraj=drugi.kraj;
            if(drugi.krajPripada==true)
                finalni.krajPripada=true;
            else
                finalni.krajPripada=false;
        }
        else if(prvi.kraj==drugi.kraj){
            finalni.kraj=prvi.kraj;
            if(prvi.krajPripada==true && drugi.krajPripada==true) {
                finalni.krajPripada=true;
            }
            else
                finalni.krajPripada=false;
        }
        return finalni;
    }
}
