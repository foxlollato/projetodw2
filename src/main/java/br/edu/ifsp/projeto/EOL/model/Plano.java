package br.edu.ifsp.projeto.EOL.model;

public enum Plano {
 MONOFASICO(1),
 BIFASICO(2),
 TRIFASICO(3);

 public int plano;

 Plano(int plano) {
     this.plano = plano;
 }
}