/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase4grupo16;

import java.awt.*;//Elementos gráficos base
import java.awt.event.ActionEvent;//Acciones desde los Botones
import java.awt.event.ActionListener;//Capturan las Acciones de los Botones
import javax.swing.*;//Elementos Gráficos más avanzados

/**
 *
 * @author Usuario
 */
public class CalculadoraUnica extends JFrame implements ActionListener {
    //JFrame es una clase para crear Ventanas
    //ActionListener es el método que se exporta para que los botones funcionen

    JPanel panel;//JPanel es un segmento de Ventana con propiedades propias
    JButton suma, resta, multi, div, modul, expo, raiz, borrar;//Botones
    JTextField num1, num2, result;//Cajas de texto de 1 sola linea

    //--------Constriur la Base del Programa---------------------------------
    
    CalculadoraUnica() {//Costructor del objeto

        //Elementos base de la Ventana
        this.setSize(300, 400);//Tamaño de la ventana (ancho x alto en Pixeles)
        this.setTitle("Calculadora en 1 solo Java");//Texto arriba de la Ventana
        //this.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));//GridLayout genera una Cuadricula
                                              // de X filas por Y columnas
        
        num1 = new JTextField();//Campos de Tipo Texto
        num1.setFont(new Font("Terminator Real NFI",Font.PLAIN,20));//Fuente Tipográfica
        num2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);//El campo de texto de modifica para NO ser
                                  //editable desde el Teclado
        
        suma = new JButton("+");
        resta = new JButton("-");
        multi = new JButton("x");
        //multi.setEnabled(false);
        div = new JButton("\u00F7");// ALT-37 ASCII Code o 00F7 en Unicode
        modul = new JButton("\u0025");// % desde teclado ; ALT 37 en ASCII ; \u0025 en Unicode
        expo = new JButton("X\u02B8");
        raiz = new JButton("\u221A");
        borrar = new JButton("Borrar");

        suma.addActionListener(this);
        resta.addActionListener(this);
        multi.addActionListener(this);
        div.addActionListener(this);
        modul.addActionListener(this);
        expo.addActionListener(this);
        raiz.addActionListener(this);
        borrar.addActionListener(this);
        
        panel.add(num1);
        panel.add(num2);
        panel.add(suma);
        panel.add(resta);
        panel.add(multi);
        panel.add(div);
        panel.add(modul);
        panel.add(expo);
        panel.add(raiz);
        panel.add(borrar);
        panel.add(result);
        
        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double x,y;
        
        if (!num1.getText().equals("") && num2.getText()!="") {
           //Así es como Java recomienda  Tambíen se puede así
           //que se compraren String      Pero No es lo recomendado por 
           //                             Potenciales problemas de conversión
        x=Double.parseDouble(num1.getText());
        y=Double.parseDouble(num2.getText());
        }
        else {
        x=0;
        y=0;
        }
        
        System.out.println("x= "+x);
        System.out.println("y= "+y);
                
        if (e.getSource() == suma) {
            double res=x+y;
            result.setText(String.valueOf(res));//

        }
        if (e.getSource() == resta) {
            double res=x-y;
            result.setText(String.valueOf(res));//

        }
        if (e.getSource() == multi) {
            double res=x*y;
            result.setText(String.valueOf(res));//

        }
        if (e.getSource() == div) {
            if (y!=0){
            double res=x/y;
            result.setText(String.valueOf(res));//
            }
            else {
            JOptionPane.showMessageDialog(null, 
                    "División por Zero","No se realizó la operación",
                    JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == modul) {
            double res=x%y;
            result.setText(String.valueOf(res));//

        }
        if (e.getSource() == expo) {
            double res=Math.pow(x, y);
            result.setText(String.valueOf(res));//

        }
        if (e.getSource() == raiz) {
            double res=Math.sqrt(x);
            result.setText(String.valueOf(res));//

        }
        if (e.getSource() == borrar) {
        result.setText("");num1.setText("");num2.setText("");
        }

    }

}
