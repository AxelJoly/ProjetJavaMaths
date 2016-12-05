import java.lang.Object;
//import java.util.Objects;
import java.lang.*;


/**
 * Created by maxim on 05/12/2016.
 */
public class Complexe extends Object {
    private final double re;   // the real part
    private final double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complexe(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return abs/modulus/magnitude
    public double abs() {
        return Math.hypot(re, im);
    }

    // return angle/phase/argument, normalized to be between -pi and pi
    public double phase() {
        return Math.atan2(im, re);
    }

    // return a new Complex object whose value is (this + b)
    public Complexe plus(Complexe b) {
        Complexe a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complexe(real, imag);
    }

    // return a new Complex object whose value is (this - b)
    public Complexe minus(Complexe b) {
        Complexe a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complexe(real, imag);
    }

    // return a new Complex object whose value is (this * b)
    public Complexe times(Complexe b) {
        Complexe a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complexe(real, imag);
    }

    // return a new object whose value is (this * alpha)
    public Complexe scale(double alpha) {
        return new Complexe(alpha * re, alpha * im);
    }

    // return a new Complex object whose value is the conjugate of this
    public Complexe conjugate() {
        return new Complexe(re, -im);
    }

    // return a new Complex object whose value is the reciprocal of this
    public Complexe reciprocal() {
        double scale = re*re + im*im;
        return new Complexe(re / scale, -im / scale);
    }

    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }

    // return a / b
    public Complexe divides(Complexe b) {
        Complexe a = this;
        return a.times(b.reciprocal());
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complexe exp() {
        return new Complexe(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex object whose value is the complex sine of this
    public Complexe sin() {
        return new Complexe(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex cosine of this
    public Complexe cos() {
        return new Complexe(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complexe tan() {
        return sin().divides(cos());
    }



    // a static version of plus
    public static Complexe plus(Complexe a, Complexe b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complexe sum = new Complexe(real, imag);
        return sum;
    }

    // See Section 3.3.
    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Complexe that = (Complexe) x;
        return (this.re == that.re) && (this.im == that.im);
    }

    // See Section 3.3.
    /*public int hashCode() {
        return Object.hash(re, im);
    }*/
}
