/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jurostela;

import javax.swing.JOptionPane;

/**
 *
 * @author CGC
 */
public class Calculo_Juros {

    private double vrpres;
    public double vrfut;
    public double tempo;
    public double taxa;
    public double resultado;
//    private String status;

    //public double prov;
    public void Calcvp(int tipo) {

        if (this.vrfut == 0 | this.taxa == 0 | this.tempo == 0) {
            JOptionPane.showMessageDialog(null, "Valores não podem estar zerados");
        } else if (tipo == 1) {
            //Composto = vp = vf/(1 + i)^n
            this.resultado = (this.vrfut / (Math.pow((1 + (this.taxa / 100)), this.tempo)));
        } else {
            //Simples = VP = VF/(1 + (i * n))
            this.resultado = (this.vrfut / (1 + ((this.taxa / 100) * this.tempo)));
        }
    }

    public void Calcvf(int tipo) {
        if (this.vrpres == 0 | this.taxa == 0 | this.tempo == 0) {
            JOptionPane.showMessageDialog(null, "Valores não podem estar zerados");
        } else if (tipo == 1) {
            // Composto = vf = vp * (1 + i)^n
            this.resultado = this.vrpres * (Math.pow((1 + (this.taxa / 100)), this.tempo));
        } else {
            //Simples = VF = VP * (1 + (i * n))
            this.resultado = (this.vrpres * (1 + ((this.taxa / 100) * this.tempo)));

        }
    }

    public void CalcTaxa(int tipo) {
        if (this.vrpres == 0 | this.vrfut == 0 | this.tempo == 0) {
            JOptionPane.showMessageDialog(null, "Valores não podem estar zerados");
        } else if (tipo == 1) {
            //i = ((vf/vp)^(1/n)) - 1
            this.resultado = (Math.pow((this.vrfut / this.vrpres), (1 / this.tempo)) - 1) * 100;
        } else {
            //Simples = i = (VF - VP)/(VP * n)
            this.resultado = ((this.vrfut - this.vrpres) / (this.vrpres * this.tempo)) * 100;
        }
    }

    public void CalcTempo(int tipo) {
        if (this.vrpres == 0 | this.vrfut == 0 | this.taxa == 0) {
            JOptionPane.showMessageDialog(null, "Valores não podem estar zerados");
        } else if (tipo == 1) {
            //n = log(F/P)/log(1+i)
            this.resultado = Math.log10(this.vrfut / this.vrpres) / Math.log10(1 + (this.taxa / 100));
        } else {
            //n = (VF - VP)/(VP * i)
            this.resultado = ((this.vrfut - this.vrpres) / (this.vrpres * this.taxa)) * 100;
        }
    }

    // Métodos Especiais
    public double getVrpres() {
        return vrpres;
    }

    public void setVrpres(double vrpres) {
        this.vrpres = vrpres;
    }

    public double getVrfut() {
        return vrfut;
    }

    public void setVrfut(double vrfut) {
        this.vrfut = vrfut;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

}
