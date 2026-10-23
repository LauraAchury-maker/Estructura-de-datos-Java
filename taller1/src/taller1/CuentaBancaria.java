package taller1;

import java.util.Scanner;

public class CuentaBancaria {
    //==ATRIBUTOS==
    private long numeroCuenta;
    private String titular;
    private double saldo;
    
    //==CONSTRUCTOR==
    public CuentaBancaria(long numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }
    
    //==OVERRIDE==
    @Override
    public String toString() {
        return "\n==============TU CUENTA BANCARIA BBVA===============" +
                "\n===Numero de cuenta: " + numeroCuenta +
                "\n===Titular: " + titular +
                "\n===Para ver tu saldo, consulta en consultarSaldo." +
                "\n=====================================================";
    }
    
    public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
            System.out.println("\nEl deposito se realizo exitosamente!");
        }else if(valor <= 0){
            System.out.println("\nNo se puede depositar algo que no existe.");
        }else{
            System.out.println("\nIngrese un carácter valido.");
        }
    }
    
    public void retirar(double valor){
        if (valor > 0 && valor <= saldo){
            saldo -= valor;
            System.out.println("\nEl retiro se realizo exitosamente!");
        }else if(valor == 0){
            System.out.println("\nNo retiró nada en la cuenta bancaria.");
        }else if(valor < 0){
            System.out.println("\nNo puede retirar valores negativos.");
        }else{
            System.out.println("\nNo puede retirar, saldo no disponible.");
        }
    }
    
    public void consultarSaldo(){
        System.out.println("\nSu saldo es de: " + saldo + " USD.");
    }
    
    public void mostrarInformacion(){
        System.out.println(this);
    }
    
}
